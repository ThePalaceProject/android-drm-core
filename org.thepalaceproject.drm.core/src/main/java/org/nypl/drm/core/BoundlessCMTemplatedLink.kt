package org.nypl.drm.core

import org.librarysimplified.http.uri_builder.LSHTTPURIQueryBuilder
import java.math.BigInteger
import java.net.URI
import java.util.UUID

/**
 * A templated link returned by the circulation manager.
 */

data class BoundlessCMTemplatedLink(
  val baseURI: URI
) {

  fun evaluate(
    modulus: BigInteger,
    exponent: BigInteger,
    deviceID: UUID
  ): URI {
    return LSHTTPURIQueryBuilder.encodeQuery(
      URI(
        this.baseURI.getScheme(),
        this.baseURI.getAuthority(),
        this.baseURI.getPath(),
        null,
        null
      ),
      sortedMapOf(
        Pair("modulus", BoundlessJWK.encodeInteger(modulus)),
        Pair("exponent", BoundlessJWK.encodeInteger(exponent)),
        Pair("device_id", deviceID.toString())
      )
    )
  }
}
