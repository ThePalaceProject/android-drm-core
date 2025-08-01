val dependencyObjects = listOf(
    libs.androidx.test.monitor,
    libs.androidx.test.runner,
    libs.bouncycastle,
    libs.bouncycastle.bcprov,
    libs.bouncycastle.pki,
    libs.bouncycastle.tls,
    libs.bytebuddy,
    libs.bytebuddy.agent,
    libs.commons.compress,
    libs.commons.io,
    libs.conscrypt,
    libs.google.failureaccess,
    libs.google.guava,
    libs.hamcrest,
    libs.io7m.jmulticlose,
    libs.irradia.mime.api,
    libs.irradia.mime.vanilla,
    libs.jackson.annotations,
    libs.jackson.core,
    libs.jackson.databind,
    libs.jackson.dataformat.xml,
    libs.jackson.kotlin,
    libs.jackson.module.jaxb,
    libs.javax.annotation.api,
    libs.javax.inject,
    libs.joda.time,
    libs.jqwik.api,
    libs.jqwik.engine,
    libs.junit,
    libs.junit.jupiter.api,
    libs.junit.jupiter.engine,
    libs.junit.jupiter.vintage,
    libs.junit.platform.commons,
    libs.junit.platform.engine,
    libs.kotlin.reflect,
    libs.kotlin.stdlib,
    libs.kotlinx.coroutines,
    libs.kotlinx.datetime,
    libs.logback.classic,
    libs.logback.core,
    libs.mockito.core,
    libs.mockito.kotlin,
    libs.net.minidev.accessors.smart,
    libs.net.minidev.json.smart,
    libs.nimbus.jose.jwt,
    libs.objenesis,
    libs.okhttp3,
    libs.okhttp3.mockwebserver,
    libs.okio,
    libs.opentest,
    libs.ow2,
    libs.ow2.asm,
    libs.ow2.asm.commons,
    libs.ow2.asm.tree,
    libs.palace.drm.core,
    libs.palace.http.api,
    libs.palace.http.downloads,
    libs.palace.http.uri,
    libs.palace.http.vanilla,
    libs.quicktheories,
    libs.r2.shared,
    libs.r2.streamer,
    libs.reactive.streams,
    libs.robolectric,
    libs.robolectric.annotations,
    libs.robolectric.junit,
    libs.robolectric.nativeruntime,
    libs.robolectric.pluginapi,
    libs.robolectric.plugins.maven.dependency.resolver,
    libs.robolectric.resources,
    libs.robolectric.sandbox,
    libs.robolectric.shadowapi,
    libs.robolectric.shadows.framework,
    libs.robolectric.utils,
    libs.robolectric.utils.reflector,
    libs.slf4j,
    libs.stduritemplate,
    libs.woodstock.stax,
    project(":org.thepalaceproject.drm.core"),
)

dependencies {
    coreLibraryDesugaring(libs.android.desugaring)

    for (dep in dependencyObjects) {
        implementation(dep)
        testImplementation(dep)
    }
}

afterEvaluate {
    tasks.matching { task -> task.name.contains("UnitTest") }
        .forEach { task -> task.enabled = true }
}
