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
                    "Share what makes sense" to "Share everything",
                    "Write UI platform specific and use what the platform provides" to "Write UI once, use what view the framework provides or write your own"
                )
            )
            s08_what_kmp_does_differently(
                "Platform API's (ex. Bluetooth)",
                arguments = listOf(
                    "Write platform specific" to "Write platform specific",
                    "Let the compiler choose the correct impl at copile time" to "Choose the correct impl manually at runtime",
                    "Use a library" to "Use a library"
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
            s18_some_code()
            s19_kmm_problems()
            s20_kmm_problems_android()
            s21_kmm_problems_ios()
            s22_kmm_problems_ios_freezing()
            s23_kmm_problems_ios_freezing_example()
            s24_kmm_problems_ios_freezing_2()
            s25_kmm_problems_ios_freezing_solution()
            s26_kmm_problems_ios_build_time()
            s27_kmm_problems_ios_stacktraces()
            s28_kmm_problems_ios_code_generation()
            s29_sales_pitch_analysis()
            s30_recommendation()
            recommendation_base(
                "Is KMM production ready?",
                "NO. It's in alpha and that shows"
            )
            recommendation_base(
                "Can we still use it in projects?",
                """
                    It dependes...
                    If the project fit's and everybody is open minded, sure!
                """.trimIndent()
            )
            recommendation_base(
                "What dev machine to use?",
                """
                If it's possible to test most of the shared code on the
                dev machine, it doesn't matter. Otherwise use macOS.
            """.trimIndent()
            )
            recommendation_base(
                    "What team composition to build?",
            """
                At least one dedicated dev per target. Ideally someone
                experienced but not necessary.
                At least one dev who is very experienced with kotlin AND gradle!
            """.trimIndent()
            )
            recommendation_base(
                "Will you use it in production?",
                """
                Yes. We evaluated it and it suits our needs.
                We'll develop a feature we agreed on with KMM and
                if the struggle is manageable, we'll continue with it
            """.trimIndent()
            )
            s31_talks()
            s32_presentation_reveal()
        }
    }
}