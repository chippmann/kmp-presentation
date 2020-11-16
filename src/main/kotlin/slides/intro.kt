package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kpresentation.KPresentationBuilder
import styled.*

fun KPresentationBuilder.intro() = slide {

    styledH1 {
        css {
            margin(0.5.em)
        }
        +"KMP - t.Talk"
    }

    styledH2 {
        css {
            fontWeight = FontWeight.w200
            marginTop= 0.em
        }
        +"Cedric Hippmann"
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
                marginBottom = 0.75.em
            }
            +"github:chippmann"
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