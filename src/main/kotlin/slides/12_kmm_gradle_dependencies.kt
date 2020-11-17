package slides

import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import kotlinx.css.properties.ms
import kotlinx.css.properties.transition
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import kpresentation.sourceCode
import react.useEffect
import styled.css
import styled.styledDiv
import styled.styledH2
import styled.styledImg


private val infos = SlideData(
    stateCount = 3
)

fun KPresentationBuilder.s12_kmm_gradle_dependencies() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"\"shared\" build gradle"
    }

    sourceCode(
        "kotlin",
        """
            sourceSets {
                val commonMain by getting {
                    dependencies { «commonDep«
                        //datetime
                        implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.1.0")»
                    }
                }
                val androidMain by getting {
                    dependencies { «specificDep«
                        //database
                        implementation("com.squareup.sqldelight:android-driver:1.4.4")»
                    }
                }
                val iosMain by getting {
                    dependencies { «specificDep«
                        //database
                        implementation("com.squareup.sqldelight:native-driver:1.4.4")»
                    }
                }
            }
        """.trimIndent()
    ) {
        useEffect {
            height = 100.pct
        }
        "code" {
            overflow = Overflow.hidden
        }

        "span" {
            +"c-marker" {
                opacity = 1.0
                verticalAlign = VerticalAlign.middle
                transition(::opacity, 300.ms)
                transition(::lineHeight, 300.ms)
                transition(::fontSize, 300.ms)
            }
            +"c-commonDep" {
                fontSize = if (props.state < 1) 0.em else 1.em
            }
            +"c-specificDep" {
                lineHeight = LineHeight(if (props.state < 2) "0" else "1.2")
                opacity = if (props.state < 2) 0.0 else 1.0
            }
        }
    }
}
