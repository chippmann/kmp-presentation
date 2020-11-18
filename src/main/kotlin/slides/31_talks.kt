package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import styled.*

private val infos = SlideData(
    stateCount = 3
)

fun KPresentationBuilder.s31_talks() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"KMM Talks to watch"
    }

    styledA(href = "https://www.youtube.com/playlist?list=PLQ176FUIyIUY6SKGl3Cj9yeYibBuRr3Hl") {
        css {
            color = Color("#007bfa")
            textDecoration = TextDecoration.none
            display = Display.block
            marginTop = 0.2.em
            transition(::fontSize, 300.ms)
            fontSize = if (props.state > 0) 1.em else 0.em
        }
        +"Kotlin Conf 2019 playlist"
    }
    styledA(href = "https://www.youtube.com/user/JetBrainsTV") {
        css {
            color = Color("#007bfa")
            textDecoration = TextDecoration.none
            display = Display.block
            marginTop = 0.2.em
            transition(::fontSize, 300.ms)
            fontSize = if (props.state > 1) 1.em else 0.em
        }
        +"JetbrainsTV"
    }
}