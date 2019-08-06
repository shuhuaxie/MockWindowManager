// IMockInputMethodClient.aidl
package com.example.gs.mockwindowmanager;

// Declare any non-default types here with import statements
//import com.android.internal.view.InputBindResult;
interface IMockInputMethodClient {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
    void setUsingInputMethod(boolean state);
//    void onBindMethod(in InputBindResult res); //TODO
    // unbindReason corresponds to InputMethodClient.UnbindReason.
    void onUnbindMethod(int sequence, int unbindReason);
    void setActive(boolean active, boolean fullscreen);
    void setUserActionNotificationSequenceNumber(int sequenceNumber);
    void reportFullscreenMode(boolean fullscreen);
}
