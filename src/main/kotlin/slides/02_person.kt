package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kpresentation.KPresentationBuilder
import react.dom.a
import react.dom.div
import react.dom.img
import react.dom.li
import styled.*

fun KPresentationBuilder.s02_person() = slide {
    styledDiv {
        css {
            display = Display.flex
            flexDirection = FlexDirection.row
            alignSelf = Align.stretch
            alignItems = Align.center
        }

        styledImg {
            css {
                maxWidth = 100.pct
                maxHeight = 100.pct
                marginRight = 4.em
            }
            attrs.src = "images/hippmann-cedric_quare.jpg"
        }

        div {

            styledH1 {
                css {
                    marginBottom = 0.5.em
                    whiteSpace = WhiteSpace.nowrap
                }
                +"Cedric Hippmann"
            }



            styledUl {
                css {
                    textAlign = TextAlign.start
                    listStyleType = ListStyleType.disc
                }
                styledLi {
                    css {
                        marginBottom = 1.em
                    }
                    +"Android Dev"
                }
                li {
                    +"KMP PoC @Abacus"
                }
                li {
                    styledA(href = "https://github.com/utopia-rise/godot-kotlin") {
                        css {
                            color = Color("#007bfa")
                            textDecoration = TextDecoration.none
                            display = Display.block
                        }
                        +"Kotlin/Native OSS project"
                    }
                }
                li {
                    +"Sideprojects with KMP"
                }
            }
        }
    }
}