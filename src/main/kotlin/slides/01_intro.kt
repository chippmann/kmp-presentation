package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import styled.*

private val infos = SlideData(
        stateCount = 2
)

fun KPresentationBuilder.s01_intro() = slide(infos) { props ->

    styledH1 {
        css {
            margin(0.5.em)
        }
        styledSpan {
            css {
                transition(::fontSize, 500.ms)
                fontSize = if (props.state <= 0) 1.em else 0.em
                verticalAlign = VerticalAlign.middle
            }
            +"Kotlin Multi Platform"
        }
        styledSpan {
            css {
                transition(::fontSize, 500.ms)
                fontSize = if (props.state >= 1) 1.em else 0.em
                verticalAlign = VerticalAlign.middle
            }
            +"KMP"
        }
        +" - t.Talk"
    }

    styledH2 {
        css {
            fontWeight = FontWeight.w200
            marginTop= 0.em
            display = Display.flex
            flexDirection = FlexDirection.row
            alignItems = Align.center
            justifyContent = JustifyContent.center
            height = 1.em
        }
        styledSpan {
            css {
                transition(::fontSize, 500.ms)
                fontSize = if (props.state <= 0) 1.em else 0.em
                verticalAlign = VerticalAlign.middle
            }
            +"Cedric Hippmann"
        }
        styledSpan {
            css {
                transition(::fontSize, 500.ms)
                fontSize = if (props.state >= 1) 1.em else 0.em
                verticalAlign = VerticalAlign.middle
            }
            +"Crossplatform done right?"
        }
    }

    styledH3 {
        css {
            fontSize = 0.8.em
            fontWeight = FontWeight.w400
            width = 28.5.em
            textAlign = TextAlign.left
            marginTop = 0.75.em
        }

        styledA(href = "https://github.com/chippmann") {
            css {
                color = Color("#007bfa")
                textDecoration = TextDecoration.none
                display = Display.block
                marginBottom = 0.25.em
            }
            +"github.com/chippmann"
        }
        styledA(href = "https://twitter.com/cedric_hippmann") {
            css {
                color = Color("#007bfa")
                textDecoration = TextDecoration.none
                display = Display.block
                marginBottom = 0.75.em
            }
            +" @cedric_hippmann"
        }
    }
}