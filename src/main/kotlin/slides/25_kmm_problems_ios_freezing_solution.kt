package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.*
import react.RBuilder
import react.RProps
import react.child
import react.dom.span
import react.functionalComponent
import styled.*

private val newMemoryManager = listOf(
    "New memory manager",
    "No special memory management or annotations",
    "Will !mostly! work with existing code",
    "Freezing will stay, but opt in",
)

private val infos = SlideData(
    stateCount = newMemoryManager.size + 1
)

fun KPresentationBuilder.s25_kmm_problems_ios_freezing_solution() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"Solution in sight?"
    }

    styledA(href = "https://blog.jetbrains.com/kotlin/2020/07/kotlin-native-memory-management-roadmap/") {
        css {
            color = Color("#007bfa")
            textDecoration = TextDecoration.none
            display = Display.block
            marginTop = 2.em
            marginBottom = 1.em
            item(1, props.state)
        }
        +"Kotlin/Native Memory Management Roadmap Blogpost"
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 80.pct
            opacity = if (props.state != 0) {
                1.0f
            } else 0.0f
            transition(::fontSize, 500.ms)
            fontSize = if (props.state != 0) 1.em else 0.em
        }

        newMemoryManager.forEachIndexed { index, point ->
            styledLi {
                css { item(index + 2, props.state) }
                +point
            }
        }
    }
}


private fun CSSBuilder.item(visibleState: Int, currentState: Int) {
    opacity = if (visibleState <= currentState) {
        1.0f
    } else 0.0f
    transition(::fontSize, 500.ms)
    fontSize = if (currentState < visibleState) 0.em else 1.em
}