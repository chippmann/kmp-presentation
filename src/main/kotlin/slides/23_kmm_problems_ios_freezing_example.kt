package slides

import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.*
import react.*
import react.dom.span
import styled.*

private val freezingExamples = listOf(
    """
        object Foo { var bar = 21 }
        
        fun main() {
            Foo.bar = 42«crash« // Crash happens here!»
            println(Foo.bar)
        }
    """.trimIndent(),
    """
        var globalState = SomeData("1")
        
        fun main() {
            println(globalState)
            globalState = SomeData("2")
            println(globalState)
        }
    """.trimIndent(),
    """
        var globalState = SomeData("1")
        
        fun main() {
            runBlocking {
                println(globalState)
            }
            globalState = SomeData("2")
            println(globalState)
        }
    """.trimIndent(),
    """
        var globalState = SomeData("1")
        
        fun main() {
            runBlocking(Dispatchers.Default) {
                println(globalState)«crash« // Crash happens here!»
            }
            globalState = SomeData("2")
            println(globalState)
        }
    """.trimIndent(),
    """
        object Foo {
            fun printString(string: String) {
                println("I received a string: ${'$'}string")
            }
        }
        
        class RandomTestClass {
            var blubb = SomeData("blubb")
            
            fun someFunction() {
                runBlocking {
                    Foo.printString(blubb.s)
                }
                blubb.s += " something else"
                println(blubb)
            }
        }
    """.trimIndent(),
    """
        object Foo {
            fun printString(string: String) {
                println("I received a string: ${'$'}string")
            }
        }
        
        class RandomTestClass {
            var blubb = SomeData("blubb")
            
            fun someFunction() {
                runBlocking(Dispatchers.Default) {
                    Foo.printString(blubb.s)
                }
                blubb = SomeData("something else")«crash« // Crash happens here!»
                println(blubb)
            }
        }
    """.trimIndent()
)

private val results = listOf(
    """
        InvalidMutabilityException: mutation attempt of frozen ExampleTests.Foo@1551a88
    """.trimIndent(),
    """
        SomeData(s=1)
        SomeData(s=2)
    """.trimIndent(),
    """
        SomeData(s=1)
        SomeData(s=2)
    """.trimIndent(),
    """
        IncorrectDereferenceException: Trying to access top level value not marked as @ThreadLocal or @SharedImmutable from non-main thread
    """.trimIndent(),
    """
        I received a string: blubb
        SomeData(s=blubb something else)
    """.trimIndent(),
    """
        I received a string: blubb
        InvalidMutabilityException: mutation attempt of frozen ExampleTests@1e4cdb8
    """.trimIndent()
)

private val infos = SlideData(
    stateCount = freezingExamples.size * 2
)

fun KPresentationBuilder.s23_kmm_problems_ios_freezing_example() = slide(infos) { props ->
    styledH2 {
        css {
            if (props.state == 0) {
                margin(0.5.em)
            }
            transition(::fontSize, 500.ms)
            fontSize = if (props.state == 0) 1.em else 0.em
        }
        +"Let's play a game..."
    }

    if (props.state in 0 until (freezingExamples.size * 2)) {
        val index = if (props.state % 2 == 0) {
            if (props.state == 0) {
                props.state
            } else {
                props.state / 2
            }
        } else if (props.state - 1 == 0) {
            props.state - 1
        } else {
            (props.state - 1) / 2
        }

        sourceCode("kotlin", freezingExamples[index]) {
            useEffect {
                height = 100.pct
            }
            "code" {
                overflow = Overflow.hidden
            }

            "span" {
                +"c-marker" {
                    opacity = 1.0
                    verticalAlign = VerticalAlign.middle
                    transition(::opacity, 300.ms)
                    transition(::lineHeight, 300.ms)
                    transition(::fontSize, 300.ms)
                }
                +"c-crash" {
                    fontSize = if (props.state % 2 == 0) 0.em else 1.em
                }
            }
        }

        if (props.state % 2 != 0) {
            val resultIndex = if (props.state - 1 == 0) {
                props.state - 1
            } else {
                (props.state - 1) / 2
            }
            styledDiv {
                css {
                    marginTop = 0.4.em
                    width = 100.pct
                }
                sourceCode("log", results[resultIndex]) {
                    useEffect {
                        height = 100.pct
                    }
                    overflow = Overflow.hidden
                    textOverflow = TextOverflow.ellipsis

                    "span" {
                        +"c-marker" {
                            opacity = 1.0
                            verticalAlign = VerticalAlign.middle
                            transition(::opacity, 300.ms)
                            transition(::lineHeight, 300.ms)
                            transition(::fontSize, 300.ms)
                        }
                        +"c-crash" {
                            fontSize = if (props.state < 1) 0.em else 1.em
                        }
                    }
                }
            }
        }
    }
}