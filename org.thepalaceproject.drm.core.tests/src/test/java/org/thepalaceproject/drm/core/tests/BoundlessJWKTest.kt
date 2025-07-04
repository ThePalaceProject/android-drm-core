package org.thepalaceproject.drm.core.tests

import net.jqwik.api.ForAll
import net.jqwik.api.Property
import org.junit.Assert
import org.nypl.drm.core.BoundlessJWK
import java.math.BigInteger

class BoundlessJWKTest {

  @Property
  fun testEncodeDecode(@ForAll x: BigInteger) {
    val s = BoundlessJWK.encodeInteger(x)
    val y = BoundlessJWK.decodeInteger(s)
    Assert.assertEquals(x, y)
  }
}
