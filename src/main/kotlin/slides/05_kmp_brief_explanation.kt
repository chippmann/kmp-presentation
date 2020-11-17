package slides

import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import react.dom.*
import styled.*
import kotlin.Float
import kotlin.random.Random

private val infos = SlideData(
    stateCount = 8
)

fun KPresentationBuilder.s05_kmp_brief_explanation() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"Keywords"
    }

//    styledUl {
//        css {
//            alignSelf = Align.stretch
//        }
//        styledLi {
//            css {
//                display = Display.flex
//                flexDirection = FlexDirection.row
//                justifyContent = JustifyContent.end
//            }
//            styledDiv {
//                css {
//                    css {
//                        display = Display.flex
//                        flexDirection = FlexDirection.row
//                    }
//                }
//                p {
//                    +"key"
//                }
//                p {
//                    +"value"
//                }
//            }
//            styledDiv {
//                css {
//                    css {
//                        display = Display.flex
//                        flexDirection = FlexDirection.row
//                    }
//                }
//                p {
//                    +"key"
//                }
//                p {
//                    +"value"
//                }
//            }
//        }
//        li {
//            div {
//                p {
//                    +"key"
//                }
//                p {
//                    +"value"
//                }
//            }
//        }
//    }

    styledDiv {
        css {
            explanationStyle(props.state)
        }
        styledDiv {
            css {
                classes.add("keywordsRow")
                display = Display.flex
                flexDirection = FlexDirection.row
                alignSelf = Align.stretch
                justifyContent = JustifyContent.start
            }
            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    alignSelf = Align.stretch
                    alignItems = Align.center
                    marginRight = 4.em
                }

                styledP {
                    css {
                        if (props.state < 1) opacity = 0.0
                        transition(::opacity, delay = 0.3.s, duration = 0.3.s)
                        classes.add("keyword")
                    }
                    +"KMP${if (props.state < 5) "?" else ""}"
                }
                styledP {
                    css {
                        if (props.state < 5) opacity = 0.0
                        classes.add("actual")
                    }
                    +"Kotlin Multiplatform"
                }
            }
            styledDiv {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.row
                    alignSelf = Align.stretch
                    alignItems = Align.center
                    marginTop = 1.em
                }

                styledP {
                    css {
                        if (props.state < 1) opacity = 0.0
                        transition(::opacity, delay = 0.9.s, duration = 0.3.s)
                        classes.add("keyword")
                    }
                    +"KMM${if (props.state < 6) "?" else ""}"
                }
                styledP {
                    css {
                        if (props.state < 6) opacity = 0.0
                        classes.add("actual")
                    }
                    span {
                        +"Kotlin Multiplatform "
                    }
                    styledSpan {
                        css { fontWeight = FontWeight.bold }
                        +"Mobile"
                    }
                }
            }
        }

        styledDiv {
            css {
                classes.add("keywordsRow")
                display = Display.flex
                flexDirection = FlexDirection.row
                alignSelf = Align.stretch
                justifyContent = JustifyContent.end
                alignItems = Align.center
            }

            styledP {
                css {
                    if (props.state < 1) opacity = 0.0
                    transition(::opacity, delay = 1.5.s, duration = 0.3.s)
                    classes.add("keyword")
                    classes.add("target")
                }
                +"Kotlin/Native${if (props.state < 4) "?" else ""}"
            }
            styledP {
                css {
                    if (props.state < 4) opacity = 0.0
                    classes.add("actual")
                }
                +"LLVM Bytecode"
            }
        }

        styledDiv {
            css {
                classes.add("keywordsRow")
                display = Display.flex
                flexDirection = FlexDirection.row
                alignSelf = Align.stretch
                justifyContent = JustifyContent.start
                alignItems = Align.center
            }

            styledP {
                css {
                    if (props.state < 1) opacity = 0.0
                    transition(::opacity, delay = 2.1.s, duration = 0.3.s)
                    marginLeft = 20.pct
                    classes.add("keyword")
                    classes.add("target")
                    marginLeft = 20.pct
                }
                +"Kotlin(/Jvm)${if (props.state < 2) "?" else ""}"
            }
            styledP {
                css {
                    if (props.state < 2) opacity = 0.0
                    classes.add("actual")
                }
                +"JVM Bytecode"
            }
        }

        styledDiv {
            css {
                classes.add("keywordsRow")
                display = Display.flex
                flexDirection = FlexDirection.row
                alignSelf = Align.end
                justifyContent = JustifyContent.end
                alignItems = Align.center
            }

            styledP {
                css {
                    if (props.state < 1) opacity = 0.0
                    transition(::opacity, delay = 2.7.s, duration = 0.3.s)
                    classes.add("keyword")
                    classes.add("target")
                }
                +"Kotlin/Js${if (props.state < 3) "?" else ""}"
            }
            styledP {
                css {
                    if (props.state < 3) opacity = 0.0
                    classes.add("actual")
                    marginRight = 20.pct
                }
                +"Javascript"
            }
        }
    }
}

private fun CSSBuilder.explanationStyle(state: Int) {
    padding(0.em, 1.em)
    marginTop = 2.em
    position = Position.relative
    alignSelf = Align.stretch

    div {
        +"keywordsRow" {
            p {
                +"keyword" {
                    margin(0.2.em)
                    backgroundColor = Color("#EDEDED")
                    color = Color("#444444")
                    fontSize = 0.75.em
                    borderRadius = 0.5.em
                    padding(0.4.em)
                }
                +"target" {
                    backgroundColor = if (state >= 7 ) {
                        Color("#00ff23")
                    } else {
                        Color("#EDEDED")
                    }

                    color = if (state >= 7 ) {
                        Color("#000000")
                    } else {
                        Color("#444444")
                    }
                }
                +"actual" {
                    fontSize = 0.5.em
                    transition(::opacity, duration = 0.3.s)
                }
            }
            fontWeight = FontWeight.w500
            margin(0.2.em)
            if (state == 0) opacity = 0.0
            transition(::opacity, duration = 0.3.s)
            transition(::backgroundColor, duration = 0.3.s)
        }
    }
}

private fun randFloat(min: Float, max: Float): Float {
    return Random.nextFloat() * (max - min) + min
}