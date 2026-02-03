pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("$rootDir/org.thepalaceproject.android.platform/build_libraries.toml"))
        }
    }

    /*
     * The set of repositories used to resolve library dependencies. The order is significant!
     */

    repositories {
        mavenLocal()
        mavenCentral()
        google()

        /*
         * Allow access to the Sonatype snapshots repository.
         */

        maven {
            url = uri("https://central.sonatype.com/repository/maven-snapshots/")
        }
    }
}

include(":org.thepalaceproject.drm.core")
include(":org.thepalaceproject.drm.core.tests")
