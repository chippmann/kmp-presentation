package slides

import kotlinx.css.*
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import styled.*

private val infos = SlideData(
    stateCount = 2
)

fun KPresentationBuilder.recommendation_base(
    question: String,
    answer: String
) = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +question
    }

    styledH5 {
        css {
            transition(::fontSize, 300.ms)
            fontSize = if (props.state > 0) 1.em else 0.em
        }
        answer.split("\n").forEach { answerPart ->
            styledP {
                css { marginTop = 0.px }
                +answerPart
            }
        }
    }
}