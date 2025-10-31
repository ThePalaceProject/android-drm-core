package org.nypl.drm.core;

/**
 * The interface exposed by the Adobe Adept Connector (the DRM component of the
 * Adobe RMSDK).
 */

public interface AdobeAdeptConnectorType
{
  /**
   * @return The current net provider
   */

  AdobeAdeptNetProviderType getNetProvider();

  /**
   * @return The current resource provider
   */

  AdobeAdeptResourceProviderType getResourceProvider();

  /**
   * Authorize the current device.
   *
   * @param client   The DRM client that will be notified of progress and
   *                 errors
   * @param vendor   The Adobe Vendor ID
   * @param user_name     The user name
   * @param password The password
   */

  void activateDevice(
    AdobeAdeptActivationReceiverType client,
    AdobeVendorID vendor,
    String user_name,
    String password);


  /**
   * @param client   The DRM client that will be notified of progress and
   *                 errors
   * @param vendor   The Adobe Vendor ID
   * @param user_name     The user name
   * @param token    The client token
   */
  void activateDeviceToken(
    AdobeAdeptActivationReceiverType client,
    AdobeVendorID vendor,
    String user_name,
    String token);



  /**
   * Remove an activation with the given details for the current device.
   *
   * @param client    The receiver
   * @param vendor    The Adobe Vendor ID
   * @param user      The user ID
   * @param user_name The user name
   * @param password  The password
   */
  void deactivateDevice(
    AdobeAdeptDeactivationReceiverType client,
    AdobeVendorID vendor,
    AdobeUserID user,
    String user_name,
    String password);

  /**
   * Discard the current device activations, if any.
   *
   * Note: This is not the same as contacting Adobe's servers and deactivating
   * accounts. In practice, this function is only useful for testing purposes:
   * It can be used to return a device to a blank state with regard to
   * activations.
   */

  void discardDeviceActivations();

  /**
   * Set the current device activations.
   *
   * Note: This is a dangerous method that's used to set the raw bytes of the current device
   * activations. The bytes are supposed to represent a serialized XML file. Needless to say,
   * this has the potential to completely destroy the state of the connector in a way that
   * can't necessarily be reset even with discardDeviceActivations().
   */

  void setDeviceActivations(byte[] data);

  /**
   * Delete an activation with the given details for the current device. Note: This does not
   * actually delete the deactivation from the perspective of Adobe, so the deleted activation
   * will still count towards the maximum activation limit.
   *
   * @param vendor    The Adobe Vendor ID
   * @param user      The user ID
   */

  void deleteDeviceActivation(
    AdobeVendorID vendor,
    AdobeUserID user);

  /**
   * Get the current list of device activations.
   *
   * @param client The receiver
   */

  void getDeviceActivations(AdobeAdeptActivationReceiverType client);

  /**
   * Fulfill an ACSM file.
   *
   * @param listener The result listener
   * @param acsm     The ACSM data
   * @param user     The Adobe User ID
   */

  void fulfillACSM(
    AdobeAdeptFulfillmentListenerType listener,
    byte[] acsm,
    AdobeUserID user);

  /**
   * Attempt to join the account {@code user} with the currently activated
   * account.
   *
   * @param listener The result listener
   * @param user     The account to be joined
   */

  void joinAccount(
    AdobeAdeptJoinAccountListenerType listener,
    AdobeUserID user);

  /**
   * Attempt to return the loan {@code loan_id}.
   *
   * @param listener The result listener
   * @param loan_id  The loan ID
   * @param user     The Adobe User ID
   */

  void loanReturn(
    AdobeAdeptLoanReturnListenerType listener,
    AdobeLoanID loan_id,
    AdobeUserID user);
}
