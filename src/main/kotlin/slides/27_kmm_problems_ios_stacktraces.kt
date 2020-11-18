package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.*
import react.dom.img
import react.useEffect
import styled.*

private val infos = SlideData(
    stateCount = 3
)

fun KPresentationBuilder.s27_kmm_problems_ios_stacktraces() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"Stacktraces"
    }

    if (props.state == 1) {
        img {
            attrs.src = "images/error_full.png"
        }
    }

    if (props.state == 2) {
        img {
            attrs.src = "images/error_detailed_1.png"
        }
        styledImg {
            css { marginTop = 1.em }
            attrs.src = "images/error_detailed_2.png"
        }
    }
}