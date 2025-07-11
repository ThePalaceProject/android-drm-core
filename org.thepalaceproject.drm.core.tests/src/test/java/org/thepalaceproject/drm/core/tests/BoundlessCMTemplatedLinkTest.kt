package org.thepalaceproject.drm.core.tests

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.nypl.drm.core.BoundlessCMTemplatedLink
import java.math.BigInteger
import java.net.URI
import java.util.UUID

class BoundlessCMTemplatedLinkTest {

  @Test
  fun testExpand0() {
    assertEquals(
      URI.create("https://example.com/?modulus=Cg&exponent=Cg&device_id=7e157a7e-f13f-4f22-a87b-8bbdc01122aa"),
      BoundlessCMTemplatedLink(
        "https://example.com/{?modulus,exponent,device_id}"
      ).evaluate(
        BigInteger.TEN,
        BigInteger.TEN,
        UUID.fromString("7e157a7e-f13f-4f22-a87b-8bbdc01122aa")
      )
    )
  }
}
