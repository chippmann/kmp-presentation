package slides

import kotlinx.css.*
import kpresentation.KPresentationBuilder
import react.dom.li
import react.dom.p
import react.dom.ul
import styled.css
import styled.styledH1
import styled.styledUl


fun KPresentationBuilder.s02_agenda() = slide {
    styledH1 {
        css {
            margin(0.5.em)
        }
        +"Agenda"
    }

    styledUl {
        css {
            textAlign = TextAlign.start
            listStyleType = ListStyleType.disc
        }
        li {
            +"KMP kurz zusammengefasst"
        }
        li {
            +"KMP in der Praxis"
        }
        li {
            +"KMP Probleme"
        }
        li {
            +"Zusammenfassung & Einschätzung "
        }
    }
}