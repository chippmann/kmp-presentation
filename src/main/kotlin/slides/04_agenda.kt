package slides

import kotlinx.css.*
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import styled.css
import styled.styledH1
import styled.styledLi
import styled.styledUl

private val agendaEntries = listOf(
    "KMP kurz zusammengefasst",
    "KMP in der Praxis",
    "KMP Probleme",
    "Zusammenfassung & Einschätzung",
)

private val infos = SlideData(
    stateCount = agendaEntries.size + 1
)

fun KPresentationBuilder.s04_agenda() = slide(infos) { props ->
    styledH1 {
        css {
            margin(0.5.em)
        }
        +"Agenda"
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 50.pct
            transition(::fontSize, 300.ms)
            transition(::opacity, 300.ms)
            fontSize = if (props.state > 0) 1.em else 0.em
            opacity = if (props.state > 0) {
                1.0f
            } else 0.0f
        }

        agendaEntries.forEachIndexed { index, point ->
            styledLi {
                css { item(index + 1, props.state) }
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