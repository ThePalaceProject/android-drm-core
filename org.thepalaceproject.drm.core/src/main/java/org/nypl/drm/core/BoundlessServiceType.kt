package org.nypl.drm.core

import java.io.File
import javax.crypto.SecretKey

interface BoundlessServiceType : DRMServiceType {

  /**
   * Create a Readium content protection filter for the given book, using the given
   * temporary directory for large resources, and the given secret key for decryption.
   */

  fun createContentProtection(
    epubFile: File,
    tempDirectory: File,
    contentKey: SecretKey,
    inMemorySizeThreshold: ULong
  ): ContentProtectionCloseableType
}
