package com.facebook.jni;

import com.facebook.soloader.SoLoader;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class Prerequisites
{
  private static final int EGL_OPENGL_ES2_BIT = 4;
  
  public static void ensure()
  {
    SoLoader.loadLibrary("fbjni");
  }
  
  public static boolean supportsOpenGL20()
  {
    EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
    EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    int[] arrayOfInt1 = new int[1];
    if (localEGL10.eglInitialize(localEGLDisplay, null)) {}
    try
    {
      if (localEGL10.eglGetConfigs(localEGLDisplay, null, 0, arrayOfInt1))
      {
        EGLConfig[] arrayOfEGLConfig = new EGLConfig[arrayOfInt1[0]];
        if (localEGL10.eglGetConfigs(localEGLDisplay, arrayOfEGLConfig, arrayOfInt1[0], arrayOfInt1))
        {
          int[] arrayOfInt2 = new int[1];
          int i = 0;
          while (i < arrayOfInt1[0])
          {
            if (localEGL10.eglGetConfigAttrib(localEGLDisplay, arrayOfEGLConfig[i], 12352, arrayOfInt2))
            {
              int j = arrayOfInt2[0];
              if ((j & 0x4) == 4) {
                return true;
              }
            }
            i += 1;
          }
        }
      }
      return false;
    }
    finally
    {
      localEGL10.eglTerminate(localEGLDisplay);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\jni\Prerequisites.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */