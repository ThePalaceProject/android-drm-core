package org.nypl.drm.core

import java.io.File

/**
 * The response returned from successfully fetching an EPUB from the CM. We return a file
 * containing the encrypted EPUB, and the intermediate full license response.
 */

data class BoundlessFulfilledCMEPUB(
  val epubFile: File,
  val licenseFile: File
)
