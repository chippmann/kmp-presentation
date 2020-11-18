package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.*
import react.useEffect
import styled.*

private val buildTimePoints = listOf(
    "Actual compilation reasonably fast",
    "~80% of time is spent on linking and binary generation",
    "No incremental build support",
    "Relatively big memory consumption",
    "c interop code generation",
    "Don't write or generate huge classes"
)

private val infos = SlideData(
    stateCount = buildTimePoints.size + 2
)

fun KPresentationBuilder.s26_kmm_problems_ios_build_time() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"Build time for Kotlin/Native"
    }

    if (props.state == 1) {
        sourceCode(
            "kotlin",
            """
        fun main() {
            println("Hello, Kotlin/Native!")
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
            minWidth = 80.pct
            opacity = if (props.state > 1) {
                1.0f
            } else 0.0f
            transition(::fontSize, 500.ms)
            fontSize = if (props.state > 1) 1.em else 0.em
        }

        buildTimePoints.forEachIndexed { index, point ->
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
}