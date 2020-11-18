package slides

import kotlinx.css.em
import kotlinx.css.margin
import kpresentation.KPresentationBuilder
import styled.css
import styled.styledH2


fun KPresentationBuilder.s09_kmm_personal_experience() = slide { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"KMM in practise"
    }
}
