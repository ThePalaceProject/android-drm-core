package org.nypl.drm.core

import org.librarysimplified.http.api.LSHTTPAuthorizationType
import org.librarysimplified.http.api.LSHTTPClientType
import org.librarysimplified.http.downloads.LSHTTPDownloadState
import java.io.File
import java.security.KeyPair
import java.time.OffsetDateTime
import java.util.UUID

interface BoundlessServiceType : DRMServiceType {

  /**
   * Create a Readium content protection filter for the given book, using the given
   * temporary directory for large resources.
   */

  fun createContentProtection(
    epubFile: File,
    licenseFile: File,
    tempDirectory: File,
    inMemorySizeThreshold: ULong,
    currentTime: OffsetDateTime = OffsetDateTime.now()
  ): ContentProtectionCloseableType

  /**
   * Fulfill an EPUB from a CM templated link. The EPUB and license file will be written
   * to the given output files, on success.
   */

  fun fulfillEPUB(
    httpClient: LSHTTPClientType,
    link: BoundlessCMTemplatedLink,
    credentials: LSHTTPAuthorizationType?,
    outputFile: File,
    outputLicenseFile: File,
    isCancelled: () -> Boolean,
    onDownloadEvent: (LSHTTPDownloadState) -> Unit
  ): DRMTaskResult<BoundlessFulfilledCMEPUB>

  /**
   * Get access to the keypair that will be used for DRM operations.
   */

  fun keyPair(): KeyPair

  /**
   * Get the device UUID.
   */

  fun deviceID(): UUID
}
