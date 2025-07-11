package org.nypl.drm.core

import io.github.stduritemplate.StdUriTemplate
import java.math.BigInteger
import java.net.URI
import java.util.UUID

/**
 * A templated link returned by the circulation manager.
 */

data class BoundlessCMTemplatedLink(
  val templatedURI: String
) {

  fun evaluate(
    modulus: BigInteger,
    exponent: BigInteger,
    deviceID: UUID
  ): URI {
    return URI.create(
      StdUriTemplate.expand(
        this.templatedURI,
        mapOf(
          Pair("modulus", BoundlessJWK.encodeInteger(modulus)),
          Pair("exponent", BoundlessJWK.encodeInteger(exponent)),
          Pair("device_id", deviceID.toString())
        )
      )
    )
  }
}
