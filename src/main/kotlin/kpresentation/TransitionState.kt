package kpresentation

sealed class TransitionState {
    abstract val forward: Boolean
    class Prepare(override val forward: Boolean) : TransitionState()
    class Execute(val state: Int, val duration: Int, override val forward: Boolean, val remaining: Int) : TransitionState()
}