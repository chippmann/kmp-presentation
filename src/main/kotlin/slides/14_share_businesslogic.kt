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
import styled.*

private val businessLogicShare = listOf(
    "Visibility modifiers",
    "No duplicate class names exposed",
    "Global objects/functions file name"
)

private val infos = SlideData(
    stateCount = businessLogicShare.size + 4
)

fun KPresentationBuilder.s14_share_businesslogic() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
            opacity = if (props.state == 1) 0f else 1f
        }
        +"Business logic️"

        styledSpan {
            css {
                transition(::fontSize, 500.ms, delay = 0.3.s)
                fontSize = if (props.state > 1) 1.em else 0.em
            }
            +"... but pay attention to:"
        }
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 60.pct
        }

        businessLogicShare.forEachIndexed { index, point ->
            styledLi {
                css { item(index + 3, props.state) }
                +point
            }
        }

        styledLi {
            css { item(businessLogicShare.size + 3, props.state) }
            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                }
                span {
                    +"Datatypes ->"
                }
                span {
                    styledA(href = "https://kotlinlang.org/docs/reference/native/objc_interop.html#mappings") {
                        css {
                            color = Color("#007bfa")
                            textDecoration = TextDecoration.none
                            display = Display.block
                            marginLeft = 0.2.em
                        }
                        +"Kotlin/Swift type mappings"
                    }
                }
            }
        }
    }

    styledImg {
        css {
            position = Position.absolute
            top = 10.pct
            height = if (props.state == 1) {
                80.pct
            } else 0.px
            opacity = if (props.state == 1) {
                1.0f
            } else 0.0f
            transition(::opacity, duration = 0.3.s)
        }
        attrs.src = "images/tell_me_something_new.jpg"
    }
}

private fun CSSBuilder.item(visibleState: Int, currentState: Int) {
    opacity = if (visibleState <= currentState) {
        1.0f
    } else 0.0f
    transition(::fontSize, 500.ms)
    fontSize = if (currentState < visibleState) 0.em else 1.em
}