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
    width = 80.pct

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

fun KPresentationBuilder.s03_what_kmp_does_differently(title: String, subtitle: String = "", arguments: List<Pair<String, String>>, notesString: String = "") = slide(
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
            margin(0.5.em)
        }
        +title
    }

    if (subtitle.isNotEmpty()) {
        styledH3 {
            css {
                marginBottom = 0.5.em
            }
            +subtitle
        }
    }

    styledTable {
        css {
            tableStyle(props.state)
        }
        tr {
            th { +"Generisches Cross Platform framework" }
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
