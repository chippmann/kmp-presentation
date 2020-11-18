package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import react.dom.img
import styled.*

private val infos = SlideData(
    stateCount = 3
)

fun KPresentationBuilder.s32_presentation_reveal() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"One more thing... ™"
    }

    styledImg {
        css {
            transition(::opacity, 0.3.s)
            transition(::height, 0.3.s)
            opacity = if (props.state > 0) 1f else 0f
            height = when (props.state){
                1 -> 80.pct
                2 -> 60.pct
                else -> 0.px
            }
        }
        attrs.src = "images/thats_no_pp_presentation.jpg"
    }

    styledA(href = "https://github.com/chippmann/kmp-presentation") {
        css {
            color = Color("#007bfa")
            textDecoration = TextDecoration.none
            display = Display.block
            marginTop = 0.2.em
            transition(::fontSize, 300.ms)
            fontSize = if (props.state > 0) 1.em else 0.em
        }
        +"github.com:chippmann/kmp-presentation"
    }
    styledA(href = "https://hippmann.ch/kmp-presentation") {
        css {
            color = Color("#007bfa")
            textDecoration = TextDecoration.none
            display = Display.block
            marginTop = 0.2.em
            transition(::fontSize, 300.ms)
            fontSize = if (props.state > 0) 1.em else 0.em
        }
        +"https://hippmann.ch/kmp-presentation"
    }

    styledH3 {
        css {
            marginTop = 2.em
            transition(::fontSize, 300.ms)
            fontSize = if (props.state > 1) 1.em else 0.em
        }
        +"Thanks for your attention! Questions?"
    }
}