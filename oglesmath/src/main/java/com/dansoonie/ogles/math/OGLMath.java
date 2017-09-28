package com.dansoonie.ogles.math;

import android.util.Log;

/**
 * Created by dansoonie on 17/9/28/.
 */

public class OGLMath {
  public static final String TAG = OGLMath.class.getName(); // Tag for logging

  // Ogles math library operation mode
  public static final int MODE_DEBUG = 100;
  public static final int MODE_RELEASE = 101;

  private static int sMode = MODE_DEBUG;

  public static void setMode(int newMode) {
    if (newMode == MODE_DEBUG || newMode == MODE_RELEASE) {
      sMode = newMode;
    } else {
      Log.w(TAG, "Unknown mode for OGLMath. Defaulting to MODE_DEBUG");
      sMode = MODE_DEBUG;
    }
  }

  public static boolean isDebugMode() {
    return sMode == MODE_DEBUG;
  }
}
