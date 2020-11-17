package slides

import kotlinx.css.*
import kotlinx.css.properties.*
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import kpresentation.sourceCode
import org.w3c.dom.HTMLElement
import react.dom.a
import react.dom.div
import react.dom.span
import react.dom.strong
import react.useEffect
import react.useRef
import styled.*


private val infos = SlideData(
    stateCount = 3
)

fun KPresentationBuilder.s17_not_share_ui() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"Dont share the UI!"

        styledSpan {
            css {
                transition(::fontSize, 0.3.s)
                fontSize = if (props.state >= 1) 1.em else 0.em
            }
            +" Or should you? \uD83E\uDD14"
        }
    }

    styledH4 {
        css {
            transition(::fontSize, 0.3.s)
            fontSize = if (props.state >= 2) 1.em else 0.em
        }

        styledA(href = "https://www.jetbrains.com/lp/compose/") {
            css {
                color = Color("#007bfa")
                textDecoration = TextDecoration.none
                display = Display.block
            }
            +"Compose for Desktop"
        }

        +" lately released (alpha)"
    }
}