package kpresentation

internal enum class Mode {
    OVERVIEW,
    PRESENTER
}

internal fun Set<Mode>.params() = if (isEmpty()) "" else "mode=" + joinToString(separator = ",") { it.name.toLowerCase() }