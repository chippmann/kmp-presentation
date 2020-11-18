package slides

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.*
import react.RBuilder
import react.RProps
import react.child
import react.dom.span
import react.functionalComponent
import styled.*

private val whatsFreezing = listOf(
    "An object can either be mutable or shared",
    "A shared object is frozen",
    "A frozen object cannot be mutated",
    "Freezing an object also freezes every object it references",
    "A frozen object cannot be \"unfrozen\"",
    "Top level object are frozen by default"
)

private val freezingExistencePoints = listOf(
    "Paradigm shift to actor based programming",
    "Easier to implement garbage collection"
)

private val infos = SlideData(
    stateCount = whatsFreezing.size + freezingExistencePoints.size + 2,
    notes = notes(
        """
        Ohne shared mutable data, keine mutex nötig
        Somit keine race conditions und fixe performance
        
        Actor based programming
        Ein thread ist owner des objekts, andere threads fragen diesen nach daten oder geben actionen in auftrag
        
        Geschichte
        Objective-C model zu begin -> kann keine object graphs with cycles -> handled by dev, no option
        Jetzt: immer noch ref counting, +cyclic garbage collector -> kontrolliert refs by trial deletion
        """.trimIndent()
    )
)

fun KPresentationBuilder.s22_kmm_problems_ios_freezing() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"KMM problems - iOS - Freezing ❄"
    }

    styledH3 {
        css {
            opacity = if (shouldShowWhatIsFrozen(props)) {
                1.0f
            } else 0.0f
            transition(::fontSize, 500.ms)
            fontSize = if (shouldShowWhatIsFrozen(props)) 1.em else 0.em
        }
        +"What is freezing?"
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 80.pct
            opacity = if (shouldShowWhatIsFrozen(props)) {
                1.0f
            } else 0.0f
            transition(::fontSize, 500.ms)
            fontSize = if (shouldShowWhatIsFrozen(props)) 1.em else 0.em
        }

        whatsFreezing.forEachIndexed { index, point ->
            styledLi {
                css { item(index + 1, props.state) }
                +point
            }
        }
    }

    styledH3 {
        css {
            opacity = if (shouldShowWhyItExists(props)) {
                1.0f
            } else 0.0f
            transition(::fontSize, 500.ms, delay = 600.ms)
            fontSize = if (shouldShowWhyItExists(props)) 1.em else 0.em
        }
        +"Why does it exist?"
    }

    styledUl {
        css {
            listStyleType = ListStyleType.disc
            minWidth = 60.pct
            opacity = if (shouldShowWhyItExists(props)) {
                1.0f
            } else 0.0f
            transition(::fontSize, 500.ms, delay = 600.ms)
            fontSize = if (shouldShowWhyItExists(props)) 1.em else 0.em
        }

        freezingExistencePoints.forEachIndexed { index, point ->
            styledLi {
                css { item(index + whatsFreezing.size + 2, props.state) }
                +point
            }
        }
    }
}

private fun shouldShowWhatIsFrozen(props: SlideContentProps) = props.state in 0..whatsFreezing.size
private fun shouldShowWhyItExists(props: SlideContentProps) = props.state in whatsFreezing.size + 1 until whatsFreezing.size + freezingExistencePoints.size + 2

private fun CSSBuilder.item(visibleState: Int, currentState: Int) {
    opacity = if (visibleState <= currentState) {
        1.0f
    } else 0.0f
    transition(::fontSize, 500.ms)
    fontSize = if (currentState < visibleState) 0.em else 1.em
}