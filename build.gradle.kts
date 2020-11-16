
plugins {
    kotlin("js") version "1.4.10"
}

group = "ch.hippmann"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    jcenter()
    mavenCentral()
    maven( url = "https://kotlin.bintray.com/kotlin-js-wrappers" )
}

kotlin {
    target {
        browser()
        useCommonJs()

        sourceSets["main"].dependencies {
            implementation(kotlin("stdlib-js"))

            implementation("org.jetbrains:kotlin-react-dom:${DependenciesVersions.reactVersion}-${DependenciesVersions.kotlinWrapperVersion}")
            implementation("org.jetbrains:kotlin-react-router-dom:${DependenciesVersions.reactRouterVersion}")
            implementation("org.jetbrains:kotlin-styled:5.2.0-${DependenciesVersions.kotlinWrapperVersion}")

            implementation(npm("react", "^${DependenciesVersions.reactVersion}"))
            implementation(npm("react-dom", "^${DependenciesVersions.reactVersion}"))
            implementation(npm("react-router", "^${DependenciesVersions.reactRouterVersion}"))
            implementation(npm("react-router-dom", "^${DependenciesVersions.reactRouterVersion}"))

            implementation(npm("css-in-js-utils", "3.0.2"))
            implementation(npm("inline-style-prefixer", "5.1.0"))
            implementation(npm("styled-components", "4.3.2"))
            implementation(npm("core-js", "3.2.0"))

            implementation(npm("highlight.js", "9.16.2"))
            implementation(npm("react-markdown", "4.2.2"))
        }
    }
}