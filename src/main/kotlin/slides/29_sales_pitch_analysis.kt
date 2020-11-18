package slides

import kotlinx.css.*
import kotlinx.css.properties.ms
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import react.dom.img
import react.dom.ul
import styled.*


private val salesPitchPoints = listOf(
    "✔️ Single codebase for business logic",
    "✔️ Get cross platform benefits in existing projects",
    "❌ Easy to integrate in existing projects",
    "❌❌ Easy to migrate existing projects",
    "\uD83E\uDD37\u200D♂️ Use Android or iOS specific features without overhead",
    "\uD83E\uDD37\u200D♂️ Easy to adopt, also for iOS dev's",
    "❌❌ Partner <enter_generic_company_name> already successfully uses KMM in production!"
)

private val infos = SlideData(
    stateCount = salesPitchPoints.size + 1
)

fun KPresentationBuilder.s29_sales_pitch_analysis() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"KMM Sales pitch - Analysis"
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 100.pct
            transition(::fontSize, 300.ms)
            transition(::opacity, 300.ms)
            fontSize = if (props.state > 0) 1.em else 0.em
            opacity = if (props.state > 0) {
                1.0f
            } else 0.0f
        }
        salesPitchPoints.forEachIndexed { index, point ->
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