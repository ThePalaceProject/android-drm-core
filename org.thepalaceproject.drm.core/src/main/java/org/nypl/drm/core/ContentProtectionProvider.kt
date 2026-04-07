package org.nypl.drm.core

import android.app.Activity
import org.readium.r2.shared.publication.protection.ContentProtection

interface ContentProtectionProvider {

  fun create(context: Activity): ContentProtection?
}
