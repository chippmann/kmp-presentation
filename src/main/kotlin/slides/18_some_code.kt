package slides

import kotlinx.css.*
import kotlinx.css.properties.*
import kpresentation.KPresentationBuilder
import kpresentation.SlideData
import kpresentation.sourceCode
import react.useEffect
import styled.*

private val infos = SlideData(
    stateCount = 9
)

fun KPresentationBuilder.s18_some_code() = slide(infos) { props ->
    styledH2 {
        css {
            if (props.state == 0) {
                margin(0.5.em)
            }
            transition(::fontSize, 500.ms)
            fontSize = if (props.state == 0) 1.em else 0.em
        }
        +"Let's look at some code"
    }

    if (props.state == 1) {
        sourceCode(
            "kotlin",
            """
        //commonMain
        class Greeting() {
            fun greeting(): String {
                return "Hello, ${'$'}{Platform().platform}!"
            }
        }
        
        expect class Platform() {
            val platform: String
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
            }
        }
    }

    if (props.state == 2) {
        sourceCode(
            "kotlin",
            """
        //androidMain
        actual class Platform actual constructor() {
            actual val platform: String = 
                "Android ${'$'}{Build.VERSION.SDK_INT}"
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
            }
        }
    }

    if (props.state == 3) {
        sourceCode(
            "kotlin",
            """
        //iosMain
        actual class Platform actual constructor() {
            actual val platform: String = 
                UIDevice.currentDevice.systemName() 
                + " " 
                + UIDevice.currentDevice.systemVersion
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
            }
        }
    }

    if (props.state == 4) {
        sourceCode(
            "kotlin",
            """
        //commonMain
        expect object Database {
            internal fun dbClear()
            internal val instance: PlexCompanionDatabase
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
            }
        }
    }

    if (props.state in 5 .. 6) {
        sourceCode(
            "kotlin",
            """
        //androidMain«specific«
        interface DbDriverProvider { fun provideDriver(): SqlDriver }
        
        »actual object Database {«specific«
            private var driverProviderRef: DbDriverProvider? = null
            private var driverRef: SqlDriver? = null
            private var dbRef: PlexCompanionDatabase? = null

            fun init(driverProvider: DbDriverProvider) {
                driverProviderRef = driverProvider
            }

            private fun dbInternalSetup(): PlexCompanionDatabase {
                val localDriverProvider = driverProviderRef
                requireNotNull(localDriverProvider) { "driverProviderRef was null. Did you forget to call init?" }
                
                val driver = localDriverProvider.provideDriver()
                val db = createQueryWrapper(driver) //sqldelight specific
                driverRef = driver
                dbRef = db
                return db
            }
            »//...«common«
            internal actual fun dbClear() {
                driverRef?.close()
                dbRef = null
                driverRef = null
            }

            internal actual val instance: PlexCompanionDatabase
                get() = dbRef ?: dbInternalSetup()
        »}
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
                +"c-common" {
                    fontSize = if (props.state == 5) 1.em else 0.em
                }
                +"c-specific" {
                    fontSize = if (props.state == 6) 1.em else 0.em
                }
            }
        }
    }

    if (props.state in 7 .. 8) {
        sourceCode(
            "kotlin",
            """
        //iosMain«specific«
        »actual object Database {«specific«
            private val driverRef = AtomicReference<SqlDriver?>(null)
            private val dbRef = AtomicReference<PlexCompanionDatabase?>(null)
        
            private fun dbSetup(): PlexCompanionDatabase {
                val driver = NativeSqliteDriver(Schema, "plexcompaniondb")
                val db = createQueryWrapper(driver) //sqldelight specific
                driverRef.value = driver.freeze()
                dbRef.value = db.freeze()
                return db
            }
            »//...«common«
            internal actual fun dbClear() {
                driverRef.value?.close()
                dbRef.value = null
                driverRef.value = null
            }
        
            internal actual val instance: PlexCompanionDatabase
                get() = dbRef.value ?: dbSetup()
        »}
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
                +"c-common" {
                    fontSize = if (props.state == 7) 1.em else 0.em
                }
                +"c-specific" {
                    fontSize = if (props.state == 8) 1.em else 0.em
                }
            }
        }
    }
}