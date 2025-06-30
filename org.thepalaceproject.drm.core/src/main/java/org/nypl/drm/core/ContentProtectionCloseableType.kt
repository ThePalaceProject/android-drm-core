package org.nypl.drm.core

import org.readium.r2.shared.publication.protection.ContentProtection

/**
 * An extension of the Readium ContentProtection interface that provides a close operation.
 */

interface ContentProtectionCloseableType : ContentProtection, AutoCloseable
