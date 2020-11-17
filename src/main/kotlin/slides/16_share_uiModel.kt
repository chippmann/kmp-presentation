package slides

import kotlinx.css.*
import kotlinx.css.properties.*
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import kpresentation.sourceCode
import org.w3c.dom.HTMLElement
import react.dom.a
import react.dom.div
import react.dom.span
import react.dom.strong
import react.useEffect
import react.useRef
import styled.*

private val uiModelShare = listOf(
    "✔️ Almost no ui testing needed",
    "✔️ Tests are executed way faster",
    "✔️ Less ui logic in UI (SwiftUI, Jetpack Compose)",
    "❌ Only testable on Android",
    "❌ Only really usable with reactive patterns and libraries",
)

private val infos = SlideData(
    stateCount = uiModelShare.size + 4
)

fun KPresentationBuilder.s16_share_uiModel() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"Ui model / ui logic?"
    }

    styledH3 {
        css {
            marginTop = 0.5.em
            transition(::fontSize, 500.ms)
            fontSize = if (props.state == 1) 1.em else 0.em
        }
        +"Move ui logic to shared code"
    }
    styledH3 {
        css {
            marginBottom = 0.5.em
            transition(::fontSize, 500.ms)
            fontSize = if (props.state == 1) 1.em else 0.em
        }
        +"Keep ui itself platform specific"
    }

    styledDiv {
        css {
            height = if (props.state == 2) 100.pct else 0.px
            opacity = if (props.state == 2) 1f else 0f
        }
        sourceCode(
            "kotlin",
            """
        enum class DetailUiViewState {
            LOADING,
            LOADED,
            REQUESTING,
            ERROR
        }
        
        data class DetailUiModel(
            val mediaDetail: MediaDetail,
            val requestAction: ((MediaDetail) -> Unit)?,
            val requestQualityAction: ((MediaDetail) -> Unit)?,
            val requestLanguageAction: ((MediaDetail) -> Unit)?,
            val deleteWishAction: ((MediaDetail) -> Unit)?,
            val uiState: DetailUiViewState,
            val errorString: String?
        )
        """.trimIndent()
        ) {
            "code" {
                overflow = Overflow.hidden
            }

            "span" {
                +"c-marker" {
                    opacity = 1.0
                    verticalAlign = VerticalAlign.middle
                    transition(::opacity, 300.ms)
                    transition(::lineHeight, 300.ms)
                    transition(::fontSize, 300.ms)
                }
            }
        }
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            width = 80.pct
        }

        uiModelShare.forEachIndexed { index, point ->
            styledLi {
                css { item(index + 3, props.state) }
                +point
            }
        }

        styledLi {
            css { item(uiModelShare.size + 3, props.state) }
            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    marginTop = 4.em
                }
                span {
                    +"KMM compatible reactive library ->"
                }
                span {
                    styledA(href = "https://kotlinlang.org/docs/reference/coroutines/flow.html") {
                        css {
                            color = Color("#007bfa")
                            textDecoration = TextDecoration.none
                            display = Display.block
                            marginLeft = 0.2.em
                        }
                        +"Kotlin Flow"
                    }
                }
            }
        }
    }
}

private fun CSSBuilder.item(visibleState: Int, currentState: Int) {
    display = Display.flex
    flexDirection = FlexDirection.row
    justifyContent = JustifyContent.spaceBetween
    transition(::fontSize, 500.ms)
    fontSize = if (currentState < visibleState) 0.em else 1.em
    marginTop = 0.2.em
}