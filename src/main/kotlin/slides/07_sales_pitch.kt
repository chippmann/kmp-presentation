package slides

import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import react.dom.img
import react.dom.ul
import styled.*


private val salesPitchPoints = listOf(
    "Single codebase for business logic",
    "Get cross platform benefits in existing projects",
    "Easy to integrate in existing projects",
    "Easy to migrate existing projects",
    "Use Android or iOS specific features without overhead",
    "Easy to adopt, also for iOS dev's",
    "Partner <enter_generic_company_name> already successfully uses KMM in production!"
)

private val infos = SlideData(
    stateCount = salesPitchPoints.size + 2
)

fun KPresentationBuilder.s07_sales_pitch() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"KMM Sales pitch"
    }

    styledUl {
        css { listStyleType = ListStyleType.disc }
        salesPitchPoints.forEachIndexed { index, point ->
            styledLi {
                css { item(index + 1, props.state) }
                +point
            }
        }
    }

    styledImg {
        css {
            position = Position.absolute
            top = 25.pct
            left = 12.5.pct
            width = 75.pct
            opacity = if (salesPitchPoints.size + 1 <= props.state) {
                1.0f
            } else 0.0f
            transition(::opacity, duration = 0.3.s)
        }
        attrs.src = "images/doubt_meme.jpg"
    }
}

private fun CSSBuilder.item(visibleState: Int, currentState: Int) {
    opacity = if (visibleState <= currentState) {
        1.0f
    } else 0.0f
    transition(::opacity, duration = 0.3.s)
    margin(0.2.em)
}