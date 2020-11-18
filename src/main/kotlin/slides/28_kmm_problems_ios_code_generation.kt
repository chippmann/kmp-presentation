package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.*
import react.dom.span
import react.useEffect
import styled.*

private val compilerPluginPoints1 = listOf(
    "Gen source code not included in current run",
    "Generate IR (Intermediate Representation) directly"
)
private val generateIRDownsides = listOf(
    "Hard to write,read,debug and maintain",
    "Currently different impl for native and jvm",
    "Not able to set breakpoints",
    "Not able to step through",
    "<No source> in stacktraces",
)

private val infos = SlideData(
    stateCount = compilerPluginPoints1.size + generateIRDownsides.size + 8
)

fun KPresentationBuilder.s28_kmm_problems_ios_code_generation() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"Code Generation"
    }

    styledH4 {
        css {
            transition(::fontSize, 300.ms)
            fontSize = if (props.state in 1 .. 2) 1.em else 0.em
        }

        span {
            +"No kapt annotation processors"
        }
        styledSpan {
            css {
                transition(::fontSize, 300.ms)
                fontSize = if (props.state == 2) 1.em else 0.em
            }
            +"... But compiler plugins"
        }
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 80.pct
            transition(::fontSize, 300.ms)
            transition(::opacity, 300.ms)
            fontSize = if (props.state in 3 .. compilerPluginPoints1.size + 2) 1.em else 0.em
            opacity = if (props.state in 3 .. compilerPluginPoints1.size + 2) {
                1.0f
            } else 0.0f
        }

        compilerPluginPoints1.forEachIndexed { index, point ->
            styledLi {
                css { item(index + 3, props.state) }
                +point
            }
        }
    }

    if (props.state == compilerPluginPoints1.size + 3) {
        sourceCode("kotlin",
            """
                InstructionAdapter(this).apply {
                    Lgetstatic("j/l/System", "out", "Ljava/io/PrintStream;")
                    anew("j/l/StringBuilder")
                    dup()
                    invokespecial("j/l/StringBuilder", "<init>", "()V")
                    visitLdcInsn("⇢ ${'$'}{function.name}(")
                    invokevirtual("j/l/StringBuilder", "append",    "(Lj/l/Object;)Lj/l/StringBuilder;")
                    function.valueParameters.forEachIndexed { i, param ->
                        visitLdcInsn("${'$'}{param.name}=")
                        invokevirtual("j/l/StringBuilder", "append", "(Lj/l/String;)Lj/l/SB;")
                        visitVarInsn(ALOAD, i + 1)
                        invokevirtual("j/l/StringBuilder", "append", "(Lj/l/Object;)Lj/l/SB;")
                    }
                    Rinvokevirtual("j/l/StringBuilder", "toString", "()Lj/l/String;")
                    invokevirtual("j/io/PrintStream", "println", "(Lj/l/String;)V")
                }
            """.trimIndent()
        ) {
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
            }
        }
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 60.pct
            transition(::fontSize, 300.ms)
            transition(::opacity, 300.ms)
            fontSize = if (props.state in compilerPluginPoints1.size + 4 .. compilerPluginPoints1.size + generateIRDownsides.size + 3) 1.em else 0.em
            opacity = if (props.state in compilerPluginPoints1.size + 4 .. compilerPluginPoints1.size + generateIRDownsides.size + 3) {
                1.0f
            } else 0.0f
        }

        generateIRDownsides.forEachIndexed { index, point ->
            styledLi {
                css { item(index + compilerPluginPoints1.size + 4, props.state) }
                +point
            }
        }
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 100.pct
            transition(::fontSize, 300.ms)
            transition(::opacity, 300.ms)
            fontSize = if (props.state in compilerPluginPoints1.size + generateIRDownsides.size + 4 .. compilerPluginPoints1.size + generateIRDownsides.size + 5) 1.em else 0.em
            opacity = if (props.state in compilerPluginPoints1.size + generateIRDownsides.size + 4 .. compilerPluginPoints1.size + generateIRDownsides.size + 5) {
                1.0f
            } else 0.0f
        }
        styledLi {
            css {
                item(compilerPluginPoints1.size + generateIRDownsides.size + 4, props.state)
                marginTop = 2.em
            }
            +"Gen source code in dummy target"
        }
        styledLi {
            css { item(compilerPluginPoints1.size + generateIRDownsides.size + 5, props.state) }
            +"Let actual target build task depend on dummy target compilation task"
        }
    }

    styledA(href = "https://www.youtube.com/watch?v=w-GMlaziIyo") {
        css {
            color = Color("#007bfa")
            textDecoration = TextDecoration.none
            display = Display.block
            marginTop = 0.2.em
            transition(::fontSize, 300.ms)
            fontSize = if (props.state > compilerPluginPoints1.size + generateIRDownsides.size + 5) 1.em else 0.em
        }
        +"Talk: Writing your first compiler plugin"
    }

    styledA(href = "https://resources.jetbrains.com/storage/products/kotlinconf2018/slides/5_Writing%20Your%20First%20Kotlin%20Compiler%20Plugin.pdf") {
        css {
            color = Color("#007bfa")
            textDecoration = TextDecoration.none
            display = Display.block
            marginTop = 0.2.em
            transition(::fontSize, 300.ms)
            fontSize = if (props.state > compilerPluginPoints1.size + generateIRDownsides.size + 5) 1.em else 0.em
        }
        +"Slides from that talk"
    }

    styledA(href = "https://github.com/utopia-rise/godot-kotlin/tree/master/entry-generation") {
        css {
            color = Color("#007bfa")
            textDecoration = TextDecoration.none
            display = Display.block
            marginTop = 1.em
            transition(::fontSize, 300.ms)
            fontSize = if (props.state > compilerPluginPoints1.size + generateIRDownsides.size + 6) 1.em else 0.em
        }
        +"Simple compiler plugin from my OSS project"
    }
}

private fun CSSBuilder.item(visibleState: Int, currentState: Int) {
    opacity = if (visibleState <= currentState) {
        1.0f
    } else 0.0f
    transition(::fontSize, 500.ms)
    fontSize = if (currentState < visibleState) 0.em else 1.em
}