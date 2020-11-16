import kotlinx.browser.document
import kpresentation.Move
import kpresentation.presentation
import react.dom.render
import slides.s01_intro
import slides.s02_why_not_use
import slides.s03_what_kmp_does_differently
import styled.injectGlobal
import styling.globalCss


fun main() {
    render(document.getElementById("app")) {
        injectGlobal { globalCss() }

        presentation(defaultTransition = Move) {
            s01_intro()
            s02_why_not_use()
            s03_what_kmp_does_differently(
                "Code Sharing",
                arguments = listOf(
                    "Share what makes sense" to "Share everything",
                    "Write UI platform specific and use everything it provides" to "Write UI once and use a limited set or write custom views"
                )
            )
            s03_what_kmp_does_differently(
                "Platform API's (ex. Bluetooth)",
                arguments = listOf(
                    "Write platform specific" to "Write platform specific",
                    "Let compiler choose the correct implementation" to "Manually choose the correct implementation for a given platform",
                    "Use a library" to "Use a library"
                )
            )
            s03_what_kmp_does_differently(
                "Missing implementations",
                "(which are available on some platforms)",
                listOf(
                    "Write replacements where missing and let compiler use platform specifics where available" to "Write platform specific wrappers AND replacements",
                    "Use a library" to "Use a library"
                )
            )
        }
    }
}