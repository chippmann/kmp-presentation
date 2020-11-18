package slides

import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import kpresentation.notes
import react.dom.*
import styled.*

private fun CSSBuilder.tableStyle(state: Int) {
    fontSize = 1.em

    th {
        textAlign = TextAlign.left
        borderBottomWidth = 1.px
        borderColor = Color.darkGray
        borderBottomStyle = BorderStyle.solid
        borderCollapse = BorderCollapse.collapse
        paddingBottom = 0.5.em
    }
    td {
        width = 50.pct
        paddingBottom = 0.5.em
    }
}

fun KPresentationBuilder.s08_what_kmp_does_differently(title: String, subtitle: String = "", arguments: List<Pair<String, String>>, notesString: String = "") = slide(
    SlideData(
        notes = notes(notesString),
        stateCount = (arguments.size * 2) + 1
)
) { props ->
    fun CSSBuilder.minState(min: Int, stays: Boolean = false) {
        transition(::opacity, duration = 0.3.s)
        opacity = if (props.state < min) 0.0 else if (stays || props.state < 10) 1.0 else 0.2
    }

    styledH2 {
        css {
            marginTop = 0.5.em
        }
        +title
    }

    if (subtitle.isNotEmpty()) {
        styledH3 {
            css {
                marginTop = 0.1.em
                marginBottom = 1.em
            }
            +subtitle
        }
    }

    styledTable {
        css {
            tableStyle(props.state)
        }
        tr {
            th { +"Generic cross platform framework" }
            th { +"KMP" }
        }
        var lastStep= 0
        arguments.forEach {
            tr {
                styledTd {
                    css { minState(lastStep + 1) }
                    +it.second
                }
                styledTd {
                    css { minState(lastStep + 2) }
                    +it.first
                }
            }
            lastStep += 2
        }
    }
}
