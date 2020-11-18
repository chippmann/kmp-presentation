package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.*
import react.RBuilder
import react.RProps
import react.child
import react.dom.span
import react.functionalComponent
import styled.*

private val problemsOfFreezing = listOf(
    "Kotlin/Native only",
    "Performace of actor based programming",
    "Limitation enforced at runtime \uD83D\uDCA5",
    "The IDE does not, and cannot give hint's about that (~)",
    "Thus coroutines on native are single threaded... (~)",
)

private val infos = SlideData(
    stateCount = problemsOfFreezing.size + 4,
    notes = notes(
        """
        Performance ist nie so gut wie mit traditionellen trading modellen.
        Ein thread alleine verwaltet daten, andere threads warten in einer queue
        
        GC: schwierig high throughput zu erzielen, speziell bei grossen allocations
        
        Desswegen coroutines auf native immernoch single threaded by default
        Multithreading branches -> problems
        """.trimIndent()
    )
)

fun KPresentationBuilder.s24_kmm_problems_ios_freezing_2() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"Problems of that memory model"
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 80.pct
            opacity = if (props.state != 0) {
                1.0f
            } else 0.0f
            transition(::fontSize, 500.ms)
            fontSize = if (props.state != 0) 1.em else 0.em
        }

        problemsOfFreezing.forEachIndexed { index, point ->
            styledLi {
                css { item(index + 1, props.state) }
                +point
            }
        }

        styledLi {
            css { item(problemsOfFreezing.size + 1, props.state) }
            styledA(href = "https://github.com/JetBrains/kotlin-native/blob/master/CONCURRENCY.md") {
                css {
                    color = Color("#007bfa")
                    textDecoration = TextDecoration.none
                    display = Display.block
                    marginTop = 2.em
                }
                +"ℹ️ Kotlin/Native concurrency readme"
            }
        }

        styledLi {
            css { item(problemsOfFreezing.size + 2, props.state) }
            styledA(href = "https://medium.com/@kpgalligan/kotlin-native-stranger-threads-ep-1-1ccccdfe0c99") {
                css {
                    color = Color("#007bfa")
                    textDecoration = TextDecoration.none
                    display = Display.block
                    marginTop = 0.2.em
                }
                +"ℹ️ Stranger threads"
            }
        }

        styledLi {
            css { item(problemsOfFreezing.size + 3, props.state) }
            styledA(href = "https://itnext.io/why-the-kotlin-native-memory-model-cannot-hold-ae1631d80cf6") {
                css {
                    color = Color("#007bfa")
                    textDecoration = TextDecoration.none
                    display = Display.block
                    marginTop = 0.2.em
                }
                +"\uD83E\uDD2C Why the Kotlin/Native memory model cannot hold"
            }
        }
    }
}


private fun CSSBuilder.item(visibleState: Int, currentState: Int) {
    opacity = if (visibleState <= currentState) {
        1.0f
    } else 0.0f
    transition(::fontSize, 500.ms)
    fontSize = if (currentState < visibleState) 0.em else 1.em
}