package slides

import kotlinx.css.*
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import styled.css
import styled.styledH2
import styled.styledSpan

private val infos = SlideData(
    stateCount = 2
)

fun KPresentationBuilder.s13_what_to_share() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        styledSpan {
            css {
                transition(::fontSize, 500.ms)
                fontSize = if (props.state <= 0) 1.em else 0.em
                verticalAlign = VerticalAlign.middle
            }
            +"What to share \uD83E\uDD14"
        }
        styledSpan {
            css {
                transition(::fontSize, 500.ms)
                fontSize = if (props.state > 0) 1.em else 0.em
                verticalAlign = VerticalAlign.middle
            }
            +"And what not ☝️"
        }
    }
}