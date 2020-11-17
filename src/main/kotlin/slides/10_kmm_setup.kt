package slides

import kotlinx.css.*
import kpresentation.KPresentationBuilder
import styled.css
import styled.styledDiv
import styled.styledH2
import styled.styledImg


fun KPresentationBuilder.s10_kmm_setup() = slide { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"Setup"
    }

    styledDiv {
        css {
            display = Display.flex
            flexDirection = FlexDirection.row
            alignItems = Align.center
            marginBottom = 1.em
            height = 80.pct
        }

        styledImg {
            css {
                width = 45.pct
            }
            attrs.src = "images/kmm_plugin.svg"
        }
        styledImg {
            css {
                margin(1.em)
                width = 8.pct
            }
            attrs.src = "images/arrow.webp"
        }
        styledImg {
            css {
                maxHeight = 100.pct
                maxWidth = 45.pct
            }
            attrs.src = "images/project_setup.png"
        }
    }
}
