package org.nypl.drm.core

import java.io.File

interface BoundlessServiceFactoryType : DRMServiceFactoryType {

  /**
   * Create a new Boundless service.
   *
   * @param directory The base directory that will be used for persistent state
   */

  fun create(directory: File): BoundlessServiceType
}
