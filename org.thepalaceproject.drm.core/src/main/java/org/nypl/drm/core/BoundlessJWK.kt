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

  private fun toUnsignedByteArray(
    value: BigInteger
  ): ByteArray {
    val unsigned = value.abs().toByteArray()
    if (unsigned.size > 1 && unsigned[0].toInt() == 0x00) {
      val tmp = ByteArray(unsigned.size - 1)
      System.arraycopy(unsigned, 1, tmp, 0, tmp.size)
      return tmp
    }
    return unsigned
  }

  private fun fromUnsignedByteArray(
    data: ByteArray
  ): BigInteger {
    val extended = ByteArray(data.size + 1)
    System.arraycopy(data, 0, extended, 1, data.size)
    return BigInteger(extended)
  }

  fun encodeInteger(x: BigInteger): String {
    return this.encode(this.toUnsignedByteArray(x))
  }

  fun decodeInteger(s: String): BigInteger {
    return this.fromUnsignedByteArray(this.decode(s))
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
