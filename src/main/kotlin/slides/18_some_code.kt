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


private val infos = SlideData(
    stateCount = 3
)

fun KPresentationBuilder.s18_some_code() = slide(infos) { props ->
    //TODO
}