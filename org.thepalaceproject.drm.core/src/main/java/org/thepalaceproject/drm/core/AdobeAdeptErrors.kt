package org.thepalaceproject.drm.core

import org.readium.r2.shared.util.Error
import org.readium.r2.shared.util.format.AdeptSpecification
import org.thepalaceproject.drm.core.AdobeAdeptAssets.ENCRYPTION_PATH
import org.thepalaceproject.drm.core.AdobeAdeptAssets.RIGHTS_PATH

data object AdobeErrorNoSpecification : Error {
  override val cause: Error? =
    null
  override val message: String =
    "The given asset does not have $AdeptSpecification in its format"
}

data object AdobeErrorNotContainer : Error {
  override val cause: Error? =
    null
  override val message: String =
    "The given asset is not a ContainerAsset"
}

data object AdobeErrorRightsFileMissing : Error {
  override val cause: Error? =
    null
  override val message: String =
    "No $RIGHTS_PATH was included as part of the provided asset"
}

data object AdobeErrorEncryptionFileMissing : Error {
  override val cause: Error? =
    null
  override val message: String =
    "No $ENCRYPTION_PATH was included as part of the provided asset"
}
