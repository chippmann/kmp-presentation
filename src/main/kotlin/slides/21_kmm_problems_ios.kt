package slides

import kotlinx.css.*
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import react.dom.li
import styled.*


private val kmmProblemsIOs = listOf(
    "Two IDE's",
    "At least two programming languages",
    "Freezing ❄️",
    "Memory model",
    "Binary incompatibility between kotlin versions",
    "Build times",
    "Coroutines (Multithreading in general)",
    "Stacktraces (not too bad though)",
    "No annotation processing, but compiler plugins"
)

private val infos = SlideData(
    stateCount = kmmProblemsIOs.size + 2
)

fun KPresentationBuilder.s21_kmm_problems_ios() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"KMM problems - iOS"
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 80.pct
        }

        styledLi {
            css { item(1, props.state) }
            +"Hard to debug"

            styledUl {
                css {
                    listStyleType = ListStyleType.square
                }
                li { +"Use a XCode plugin (thirdparty, not recommended)" }
                li { +"Use commandline (LLVM or GDB)" }
                li { +"Print statements \uD83E\uDD2E" }
            }
        }

        kmmProblemsIOs.forEachIndexed { index, point ->
            styledLi {
                css { item(index + 2, props.state) }
                +point
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
    marginTop = 0.1.em
}