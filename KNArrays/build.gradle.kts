import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("kotlin-multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")
}

version = "1.0.0"
val ourFrameworkName = "KNArrays"
val archivesBaseName = "KNArrays"

kotlin {

    // Configure common
    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
    }

    // configure iOS - x64 and arm64 (armv7 excluded right now)
    val sdkName = System.getenv("SDK_NAME")
    val nativeArch = System.getenv("NATIVE_ARCH")
    println("iOS arch: $nativeArch")

    val iphoneNotSimulator = (sdkName != null && sdkName.startsWith("iphoneos"))
    val iosTargetName = "ios"
    val iosTarget : KotlinNativeTarget = if(iphoneNotSimulator) {
        iosArm64(iosTargetName)
    } else {
        iosX64(iosTargetName)
    }

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "summary"
        homepage = "https://github.com/j4GGy/KN-arrays-release-builds"
        authors = "TW"

        // The name of the produced framework can be changed.
        // The name of the Gradle project is used here by default.
        frameworkName = ourFrameworkName
    }

    iosTarget.binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java) {
        // sets the internal Obj-C prefix for all classes
        val args = mutableListOf("-module-name", "TW")
        freeCompilerArgs = args
    }

    val compilerArgs = ArrayList<String>()
    compilerArgs.add("-Xobjc-generics")
    iosTarget.compilations.getByName("main").kotlinOptions.freeCompilerArgs = compilerArgs
}