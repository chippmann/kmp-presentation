import kotlinx.browser.document
import kpresentation.Move
import kpresentation.presentation
import react.dom.render
import slides.s01_intro
import slides.s02_agenda
import slides.s02_why_not_use
import slides.s03_what_kmp_does_differently
import styled.injectGlobal
import styling.globalCss


fun main() {
    render(document.getElementById("app")) {
        injectGlobal { globalCss() }

        presentation(defaultTransition = Move) {
            s01_intro()
            s02_agenda()
            s02_why_not_use()
            s03_what_kmp_does_differently(
                "Code Sharing",
                arguments = listOf(
                    "Share was sinn macht" to "Share alles",
                    "Schreibe UI platform speziefisch und nutze alles was die platform zur verfügung stellt" to "Schreibe UI einmal und benutze eine limitierte anzahl views oder baue native views selber nach"
                )
            )
            s03_what_kmp_does_differently(
                "Platform API's (zB. Bluetooth)",
                arguments = listOf(
                    "Schreibe platform speziefisch" to "Schreibe platform speziefisch",
                    "Lasse den compiler die richtige impl während des kompilierens verwenden" to "Selektiere die richtige impl während die App läuft manuell",
                    "Verwende eine library" to "Verwende eine library"
                )
            )
            s03_what_kmp_does_differently(
                "Fehlende implementationen",
                "(welche auf anderen platformen existiert)",
                listOf(
                    "Write replacements where missing and let compiler use platform specifics where available" to "Write platform specific wrappers AND replacements",
                    "Use a library" to "Use a library"
                )
            )
        }
    }
}