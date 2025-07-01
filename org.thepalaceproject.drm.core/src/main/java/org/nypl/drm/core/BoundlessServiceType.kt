package org.nypl.drm.core

import java.io.File
import java.security.KeyPair
import java.time.OffsetDateTime

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
   * Get access to the keypair that will be used for DRM operations.
   */

  fun keyPair(): KeyPair
}
