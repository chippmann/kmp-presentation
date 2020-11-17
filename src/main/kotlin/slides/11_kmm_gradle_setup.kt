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
    stateCount = 7
)

fun KPresentationBuilder.s11_kmm_gradle_setup() = slide(infos) { props ->
    styledH2 {
        css {
            margin(0.5.em)
        }
        +"\"shared\" build gradle"
    }

    sourceCode(
        "kotlin",
        """
    «cocoapods1«plugins {
        //...
        id("native.cocoapods") version "1.4.10"
    }
    
    »kotlin {«android«
        android()«ios«
        ios«cocoapods2«()»«framework«{
            binaries {
                framework {
                    baseName = "shared"
                }
            }
        }»»»«cocoapods3«
         
        cocoapods {
            summary = "Some description for your Kotlin/Native module"
            homepage = "Link to your Kotlin/Native module homepage"«cocoapods4«
            
            pod("AFNetworking", "~> 4.0.0")
        »}
        »//...
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
            +"c-android" {
                fontSize = if (props.state < 1) 0.em else 1.em
            }
            +"c-ios" {
                lineHeight = LineHeight(if (props.state < 2) "0" else "1.2")
                opacity = if (props.state < 2) 0.0 else 1.0
            }
            +"c-framework" {
                lineHeight = LineHeight(if (props.state != 2 && props.state != 3) "0" else "1.2")
                opacity = if (props.state != 2 && props.state != 3) 0.0 else 1.0
            }
            +"c-cocoapods1" {
                lineHeight = LineHeight(if (props.state < 3) "0" else "1.2")
                opacity = if (props.state < 3) 0.0 else 1.0
            }
            +"c-cocoapods2" {
                lineHeight = LineHeight(if (props.state < 4) "0" else "1.2")
                opacity = if (props.state < 4) 0.0 else 1.0
            }
            +"c-cocoapods3" {
                lineHeight = LineHeight(if (props.state < 5) "0" else "1.2")
                opacity = if (props.state < 5) 0.0 else 1.0
            }
            +"c-cocoapods4" {
                lineHeight = LineHeight(if (props.state < 6) "0" else "1.2")
                opacity = if (props.state < 6) 0.0 else 1.0
            }
        }
    }
}
