package slides

import kotlinx.css.*
import kpresentation.KPresentationBuilder
import styled.*


fun KPresentationBuilder.s30_recommendation() = slide { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"My opinion / recommendation"
    }
}