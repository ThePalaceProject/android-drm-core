package org.nypl.drm.core

/**
 * The credentials required to use Boundless servers.
 */

data class BoundlessServerCredentials(
  val libraryID: String,
  val userName: String,
  val password: String
)
