plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.androidx.room)
    alias(libs.plugins.hilt.gradlePlugin)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.androidpaginationexample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.androidpaginationexample"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildFeatures{
        viewBinding = true
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
}

hilt {
    enableAggregatingTask = true
}

ksp {
    arg("room.generateKotlin", "true")
}

room {
    schemaDirectory("$projectDir/schemas/")
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // Material
    implementation(libs.material3)


    // Activity
    implementation(libs.androidx.activity.ktx)

    // Fragment
    implementation(libs.androidx.fragment.ktx)

    // Lifecycle
    implementation(libs.androidx.lifecycle.viewmodel)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Timber
    implementation(libs.timber)

    // Coroutines
    implementation(libs.bundles.kotlinx.coroutines)

    // Room
    implementation(libs.bundles.androidx.room)
    ksp(libs.androidx.room.compiler)

    // Paging
    implementation(libs.androidx.paging.runtime)

    // Recyclerview
    implementation(libs.androidx.recyclerview)

    // DataStore
    implementation(libs.androidx.dataStore.core)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.interceptor)
    implementation(libs.retrofit.converter.gson)

    //Coil
    implementation(libs.coil)
}