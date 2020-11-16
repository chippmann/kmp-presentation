package slides

import kotlinx.css.em
import kotlinx.css.margin
import kotlinx.css.opacity
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import styled.css
import styled.styledH2
import styled.styledImg

private val infos = SlideData(
        stateCount = 2
)

fun KPresentationBuilder.s02_why_not_use() = slide(infos) { props ->

    styledH2 {
        css {
            margin(0.5.em)
        }
        +"KMP!"
    }

    styledImg {
        css {
            opacity = if (props.state >= 1) {
                1
            } else {
                0
            }
            transition(::opacity, duration = 0.3.s)
        }
        attrs.src = "gifs/but_why.gif"
    }
}
