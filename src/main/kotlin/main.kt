import kotlinx.browser.document
import kpresentation.Move
import kpresentation.presentation
import react.dom.render
import slides.*
import styled.injectGlobal
import styling.globalCss


fun main() {
    render(document.getElementById("app")) {
        injectGlobal { globalCss() }

        presentation(defaultTransition = Move) {
            s01_intro()
            s02_person()
            s03_why_not_use()
            s04_agenda()
            s05_kmp_brief_explanation()
            s06_targets()
            s07_sales_pitch()
            s08_what_kmp_does_differently(
                "Code Sharing",
                arguments = listOf(
                    "Share was sinn macht" to "Share alles",
                    "Schreibe UI platform speziefisch und nutze alles was die platform zur verfügung stellt" to "Schreibe UI einmal und benutze eine limitierte anzahl views oder baue native views selber nach"
                )
            )
            s08_what_kmp_does_differently(
                "Platform API's (zB. Bluetooth)",
                arguments = listOf(
                    "Schreibe platform speziefisch" to "Schreibe platform speziefisch",
                    "Lasse den compiler die richtige impl während des kompilierens verwenden" to "Selektiere die richtige impl während die App läuft manuell",
                    "Verwende eine library" to "Verwende eine library"
                )
            )
            s09_kmm_personal_experience()
            s10_kmm_setup()
            s11_kmm_gradle_setup()
            s12_kmm_gradle_dependencies()
            s13_what_to_share()
            s14_share_businesslogic()
            s15_share_datalayer()
            s16_share_uiModel()
            s17_not_share_ui()
            s19_kmm_problems()
            s20_kmm_problems_android()
        }
    }
}