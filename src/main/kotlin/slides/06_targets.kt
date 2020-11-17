package slides

import kotlinx.css.*
import kotlinx.css.properties.*
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import kpresentation.notes
import react.dom.*
import styled.*
import util.li

private fun CSSBuilder.targetsStyle(state: Int) {
    listStyleType = ListStyleType.none
    display = Display.flex
    flexDirection = FlexDirection.row
    padding(0.em, 1.em)
    marginTop = 2.em
    alignSelf = Align.stretch
    position = Position.relative

    li {
        p {
            +"target" {
                margin(0.2.em)
                backgroundColor = Color("#EDEDED")
                color = Color("#444444")
                fontSize = 0.75.em
                borderRadius = 0.5.em
                padding(0.4.em)
            }
            +"targetType" {
                fontSize = 0.5.em
                if (state < 2) opacity = 0.0
                transition(::opacity, duration = 0.3.s)
            }
        }
        fontWeight = FontWeight.w500
        margin(0.2.em)
        flexGrow = 1.0
        flexBasis = FlexBasis.zero
        if (state == 0) opacity = 0.0
        transition(::opacity, duration = 0.3.s)
        transition(::backgroundColor, duration = 0.3.s)

        +"notCovered" {
            if (state >= 3) opacity = 0.2
            +"web" {
                if (state >= 5) opacity = 0.6
            }
        }
        +"godot" {
            if (state >= 4) opacity = 1
        }
    }
}

private val infos = SlideData(
        stateCount = 6
)

fun KPresentationBuilder.s06_targets() = slide(infos) { props ->
    styledDiv {
        fun CSSBuilder.absolute(top: LinearDimension, left: LinearDimension) {
            position = Position.absolute
            this.top = top
            this.left = left
        }

        fun CSSBuilder.relative(x: LinearDimension, y: LinearDimension) {
            position = Position.relative
            this.top = x
            this.left = y
        }

        fun CSSBuilder.minState(min: Int, stays: Boolean = false) {
            transition(::opacity, duration = 0.3.s)
            opacity = if (props.state < min) 0.0 else if (stays || props.state < 10) 1.0 else 0.2
        }

        styledH2 {
            css {
                margin(0.5.em)
            }
            +"The KMP Targets"
        }

        styledDiv {
            styledUl {
                css {
                    textAlign = TextAlign.center
                    targetsStyle(props.state)
                }
                li {
                    p("target") {
                        +"Android"
                    }
                    p("targetType") {
                        +"JVM"
                    }
                }
                li {
                    p("target") {
                        +"iOS"
                    }
                    p("targetType") {
                        +"Native"
                    }
                }
                li("notCovered web") {
                    p("target") {
                        +"Web"
                        styledSpan {
                            css {
                                fontSize = if (props.state >= 5) 1.em else 0.em
                                transition(::fontSize, duration = 0.3.s)
                            }
                            +"?"
                        }
                    }
                    p("targetType") {
                        +"JS"
                    }
                }
                li("notCovered") {
                    p("target") {
                        +"Server"
                    }
                    p("targetType") {
                        +"JVM"
                    }
                }
                li("godot notCovered") {
                    p("target") {
                        +"Desktop"
                    }
                    p("targetType") {
                        styledSpan {
                            css {
                                if (props.state >= 4) fontSize = 0.em
                                transition(::fontSize, duration = 0.3.s)
                            }
                            +"JVM/"
                        }
                        span {
                            +"Native"
                        }
                    }
                }
                li("notCovered") {
                    p("target") {
                        +"Embedded"
                    }
                    p("targetType") {
                        +"Native"
                    }
                }
            }
            styledImg { // Object -> Metadata
                css {
                    transform { rotate(120.deg) }
                    relative(0.em, 10.pct)
                    minState(4)
                    maxWidth = 3.em
                }
                attrs.src = "images/arrow.webp"
            }
            styledA(href = "https://github.com/utopia-rise/godot-kotlin") {
                css {
                    color = Color("#007bfa")
                    textDecoration = TextDecoration.none
                    display = Display.block
                    marginBottom = 0.75.em
                    relative(1.em, 0.pct)
                    minState(4)
                    fontSize = 0.75.em
                }
                +"github.com:utopia-rise/godot-kotlin"
            }
        }
    }
}