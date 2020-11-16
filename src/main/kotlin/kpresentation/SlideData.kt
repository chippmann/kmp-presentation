package kpresentation

import kotlinx.css.CSSBuilder
import styled.StyledDOMBuilder

data class SlideData(
        val stateCount: Int = 1,
        val containerStyle: CSSBuilder.(Int) -> Unit = {},
        val inTransitions: Transition.Set? = null,
        val outTransitions: Transition.Set? = null,
        val inTransitionDuration: Int? = null,
        val debugAlign: Boolean = false,
        val notes: StyledDOMBuilder<*>.(Int) -> Unit = {}
) {
    init {
        require(stateCount >= 1)
    }
}