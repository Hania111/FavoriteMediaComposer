plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //id("kotlin-kapt")
    //id("kotlin-parcelize")
    //id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.androidprojekt2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidprojekt2"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation ("androidx.navigation:navigation-compose:2.7.0")
    //implementation("androidx.naviagation:naviagation-compose:2.7.5")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.5")
    implementation("androidx.media3:media3-ui:1.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Exo Player Library
    //implementation("com.google.android.exoplayer:exoplayer:exoplayer:2.16.1")
//    implementation("com.google.android.exoplayer:exoplayer-core:2.19.1")
//    implementation("com.google.android.exoplayer:exoplayer-ui:2.19.1")

    //media 3
    implementation("androidx.media3:media3-exoplayer:1.0.0-beta02")
    implementation("androidx.media3:media3-ui:1.0.0-beta02")
//
    // Gagger - Hilt
    //implementation("com.google.dragger:hilt-android:2.42")
//    kapt("com.google.dagger:hilt-android-compiler:2.42")
//    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
//
//    implementation("androidx.compose.material:material-icons-extended:1.3.0-beta03")
//    //implementation("androidx.lifecycle:lifecycle-viewmodel--compose:2.5.1")


}