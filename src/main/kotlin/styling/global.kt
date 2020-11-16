package styling

import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition

fun CSSBuilder.globalCss() {
    body {
        backgroundColor = Color.silver
        fontFamily = "Picon"
        color = Color.white
        margin(0.em)
        padding(0.em)

        div {
            +"pres-container" {
                backgroundImage = Image("linear-gradient(to bottom right, #E8441F, #921F81)")
            }

            +"inner-container" {
                backgroundColor = Color("rgba(0, 0, 0, 0.8)")
                transition(::background, 500.ms)
            }
        }
    }

    pre {
        +"code" {
            textAlign = TextAlign.left
            backgroundColor = Color("#2b2b2b")
            alignSelf = Align.stretch
            margin(0.em, 2.em)
            padding(0.5.em)
            borderRadius = 0.2.em
            boxShadow(Color.black, blurRadius = 0.5.em)
            code {
                fontFamily = "fira code"
                fontSize = 0.65.em
                lineHeight = LineHeight("1.2")
            }
        }
    }

    ul {
        listStyleType = ListStyleType.none
        textAlign = TextAlign.left
    }
}