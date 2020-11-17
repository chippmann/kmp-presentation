package slides

import kotlinx.css.*
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import styled.*

private val kmmProblemsAndroid = listOf(
    "You cannot use every library the way you might want to"
)

private val infos = SlideData(
    stateCount = kmmProblemsAndroid.size + 3
)

fun KPresentationBuilder.s20_kmm_problems_android() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"KMM problems - Android"
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 80.pct
        }

        styledLi {
            css {
                transition(::fontSize, 500.ms)
                transition(::opacity, 500.ms)
                fontSize = if (props.state == 1) 1.em else 0.em
                opacity = if (props.state == 1) {
                    1.0f
                } else 0.0f
            }
            +"iOS"
        }

        styledLi {
            css { item(2, props.state) }
            +"Not everything that runs on Android runs on iOS!"
        }

        kmmProblemsAndroid.forEachIndexed { index, point ->
            styledLi {
                css { item(index + 3, props.state) }
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