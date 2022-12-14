/**
 * @author dogancankilic
 * Created on 3.09.2022
 */

object Versions {
    const val kotlin = "1.7.10"
    const val gradle = "7.2.2"

    const val compose = "1.3.0-beta01"
    const val composeRuntime = "2.6.0-alpha01"
    const val coil = "2.2.0"
    const val activityCompose = "1.5.1"
    const val navigation = "2.5.1"

    const val material = "1.6.1"

    const val coroutines = "1.6.4"
    const val koin = "3.2.0"
    const val ktor = "2.1.0"

    const val minSdk = 23
    const val compileSdk = 33
    const val targetSdk = 33

    const val kotlinxSerializationCore = "1.3.3"
    const val kotlinxCoroutinesCore = "1.6.4"
    const val composeConstraintLayout = "1.0.1"
    const val koinAnnotaions = "1.0.1"

}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"

    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val ktorSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val ktorSerializationJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    const val ktorNegotiaion = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val ktorAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
    const val annotations = "io.insert-koin:koin-annotations:${Versions.koinAnnotaions}"
    const val kspCompiler = "io.insert-koin:koin-ksp-compiler:${Versions.koinAnnotaions}"


    object Compose {
        const val activity = "androidx.activity:activity-compose:${Versions.activityCompose}"
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
        const val composeRuntime =
            "androidx.lifecycle:lifecycle-runtime-compose:${Versions.composeRuntime}"
        const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
        const val composeConstraintLayout =
            "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraintLayout}"
    }

    object Common {
        const val kotlinxSerializationCore =
            "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerializationCore}"
        const val kotlinxCoroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutinesCore}"
    }

    object Ktor {
        const val ktorClient = "io.ktor:ktor-client-ios:${Versions.ktor}"
    }
}

object SupportLibraries {
    const val material = "com.google.android.material:material:${Versions.material}"
}