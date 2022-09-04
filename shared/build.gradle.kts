plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.7.10"

}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Libraries.ktorCore)
                implementation(Libraries.ktorSerialization)
                implementation(Libraries.Common.kotlinxSerializationCore)
                implementation(Libraries.Common.kotlinxCoroutinesCore)
                implementation(Libraries.koinCore)
                implementation(Libraries.ktorNegotiaion)
                implementation(Libraries.ktorSerializationJson)
            }

        }
        val commonTest by getting {
            dependencies {

            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies{
                implementation(Libraries.Ktor.ktorClient)
                implementation(Libraries.ktorNegotiaion)
                implementation(Libraries.ktorSerializationJson)
                implementation(Libraries.ktorSerialization)
                implementation(Libraries.Common.kotlinxSerializationCore)
                implementation(Libraries.Common.kotlinxCoroutinesCore)
            }

        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}