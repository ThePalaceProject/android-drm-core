dependencies {
    coreLibraryDesugaring(libs.android.desugaring)

    implementation(project(":org.thepalaceproject.drm.core"))
    implementation(libs.slf4j)
    implementation(libs.junit)
}
