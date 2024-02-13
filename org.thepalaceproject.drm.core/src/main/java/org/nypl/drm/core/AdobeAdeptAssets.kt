package org.nypl.drm.core

import org.readium.r2.shared.util.Url
import org.readium.r2.shared.util.asset.ContainerAsset
import org.readium.r2.shared.util.data.CompositeContainer
import org.readium.r2.shared.util.file.FileResource
import org.readium.r2.shared.util.format.AdeptSpecification
import org.readium.r2.shared.util.format.Format
import org.readium.r2.shared.util.format.FormatSpecification
import org.readium.r2.shared.util.format.Specification
import org.readium.r2.shared.util.resource.SingleResourceContainer
import java.io.File

/**
 * Functions to open Adobe-encrypted EPUB files in a form the Readium2 DRM can handle.
 */

object AdobeAdeptAssets {

  /**
   * The path at which the rights file is "mounted" within the container.
   */

  const val RIGHTS_PATH = "/META-INF/rights.xml"

  /**
   * The path at which the encryption descriptor can be found.
   */

  const val ENCRYPTION_PATH = "/META-INF/encryption.xml"

  /**
   * Open an encrypted EPUB as an asset.
   */

  @JvmStatic
  fun openAsset(
    epubAsset: ContainerAsset,
    rightsFile: File
  ): ContainerAsset {
    /*
     * We need to make the separate rights file appear as if it were an entry in the EPUB file.
     * We can do this by creating a "composite container" that conceptually merges the rights
     * file and the original EPUB file.
     */

    val rightsResource =
      FileResource(rightsFile)
    val rightsContainer =
      SingleResourceContainer(
        entryUrl = Url(RIGHTS_PATH)!!,
        resource = rightsResource
      )

    val mainContainer =
      CompositeContainer(epubAsset.container, rightsContainer)

    /*
     * We need to add Adobe Adept as a specification to the existing format.
     */

    val specifications = mutableSetOf<Specification>()
    specifications.addAll(epubAsset.format.specification.specifications)
    specifications.add(AdeptSpecification)

    val formatSpecification =
      FormatSpecification(epubAsset.format.specification.specifications)

    val encryptedFormat =
      Format(
        specification = formatSpecification,
        mediaType = epubAsset.format.mediaType,
        fileExtension = epubAsset.format.fileExtension
      )

    return ContainerAsset(
      format = encryptedFormat,
      container = mainContainer
    )
  }
}
