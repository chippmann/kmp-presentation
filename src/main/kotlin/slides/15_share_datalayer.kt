package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import react.dom.a
import react.dom.span
import react.dom.strong
import styled.*

private val infos = SlideData(
    stateCount = 5
)

fun KPresentationBuilder.s15_share_datalayer() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"Datalayer?"
    }

    styledDiv {
        css {
            item(1, props.state)
        }

        +"Database: "
        styledA(href = "https://cashapp.github.io/sqldelight/multiplatform_sqlite/") {
            css {
                color = Color("#007bfa")
                textDecoration = TextDecoration.none
                display = Display.block
            }
            +"SQLDelight"
        }
    }

    styledDiv {
        css {
            item(2, props.state)
        }

        +"Networking: "
        styledA(href = "https://ktor.io/docs/http-client-multiplatform.html") {
            css {
                color = Color("#007bfa")
                textDecoration = TextDecoration.none
                display = Display.block
            }
            +"Ktor"
        }
    }

    styledDiv {
        css {
            item(3, props.state)
        }

        +"Serialization: "
        styledA(href = "https://github.com/Kotlin/kotlinx.serialization") {
            css {
                color = Color("#007bfa")
                textDecoration = TextDecoration.none
                display = Display.block
            }
            +"kotlinx.serialization"
        }
    }

    styledDiv {
        css {
            item(4, props.state)
            marginTop = 4.em
        }

        +"Or Platform specific with expect/actual"
    }
}

private fun CSSBuilder.item(visibleState: Int, currentState: Int) {
    display = Display.flex
    flexDirection = FlexDirection.row
    justifyContent = JustifyContent.spaceBetween
    transition(::fontSize, 500.ms)
    fontSize = if (currentState < visibleState) 0.em else 1.em
    width = 60.pct
    marginTop = 0.2.em
}