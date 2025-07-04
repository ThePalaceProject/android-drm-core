package org.nypl.drm.core

import java.math.BigInteger
import java.util.Base64

/**
 * Functions relating to [JWK](https://datatracker.ietf.org/doc/html/rfc7517).
 *
 * @see "https://www.rfc-editor.org/rfc/rfc7515.html#appendix-C"
 */

object BoundlessJWK {

  private val base64Enc =
    Base64.getEncoder()
  private val base64Dec =
    Base64.getDecoder()

  fun encodeInteger(x: BigInteger): String {
    return encode(x.toByteArray())
  }

  fun decodeInteger(s: String): BigInteger {
    return BigInteger(decode(s))
  }

  fun encode(
    data: ByteArray
  ): String {
    var text = this.base64Enc.encodeToString(data)
    text = text.split("==".toRegex())[0]
    text = text.replace('+', '-')
    text = text.replace('/', '_')
    return text
  }

  fun decode(
    text: String
  ): ByteArray {
    var ptr = text.replace('-', '+')
    ptr = ptr.replace('_', '/')

    return this.base64Dec.decode(
      when (ptr.length % 4) {
        0 -> ptr
        2 -> "$ptr=="
        3 -> "$ptr="
        else -> {
          throw IllegalArgumentException("Illegal base64url string.")
        }
      }
    )
  }
}
