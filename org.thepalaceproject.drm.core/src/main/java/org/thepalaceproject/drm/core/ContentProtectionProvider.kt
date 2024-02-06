package org.thepalaceproject.drm.core

import android.content.Context
import org.readium.r2.shared.publication.protection.ContentProtection

interface ContentProtectionProvider {

  fun create(context: Context): ContentProtection?
}
