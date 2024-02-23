package org.nypl.drm.core;

/**
 * The type of functions that map resources to byte arrays.
 */

public interface AdobeAdeptResourceProviderType
{
  /**
   * @param name The resource name
   *
   * @return The resource named <tt>name</tt> as an array of bytes, or
   * <tt>null</tt> if the resource does not exist.
   */

  byte[] getResourceAsBytes(
    String name);
}
