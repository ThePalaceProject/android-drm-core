package org.thepalaceproject.drm.core

import java.io.File

data class AxisNowFulfillment(
  val book: File,
  val license: File,
  val userKey: File,
)
