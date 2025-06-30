package org.nypl.drm.core

interface BoundlessServiceFactoryType : DRMServiceFactoryType {

  /**
   * Create a new Boundless service.
   */

  fun create(): BoundlessServiceType
}
