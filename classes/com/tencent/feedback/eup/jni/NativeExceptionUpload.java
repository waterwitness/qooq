package com.tencent.feedback.eup.jni;

import com.tencent.bugly.proguard.v;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeExceptionUpload
{
  public static final int ANDROID_LOG_DEBUG = 3;
  public static final int ANDROID_LOG_ERROR = 6;
  public static final int ANDROID_LOG_INFO = 4;
  public static final int ANDROID_LOG_WARN = 5;
  public static final int JAR_JNI_VERSION = 1;
  private static NativeExceptionHandler a = null;
  public static AtomicBoolean isEnable = new AtomicBoolean(true);
  
  public static native void doNativeCrashForTest();
  
  public static native void enableHandler(boolean paramBoolean);
  
  public static NativeExceptionHandler getmHandler()
  {
    try
    {
      NativeExceptionHandler localNativeExceptionHandler = a;
      return localNativeExceptionHandler;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static native boolean registNativeExceptionHandler(String paramString1, String paramString2, int paramInt);
  
  public static native String registNativeExceptionHandler2(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public static native void setLogMode(int paramInt);
  
  public static void setmHandler(NativeExceptionHandler paramNativeExceptionHandler)
  {
    try
    {
      a = paramNativeExceptionHandler;
      return;
    }
    finally
    {
      paramNativeExceptionHandler = finally;
      throw paramNativeExceptionHandler;
    }
  }
  
  public static void testNativeCrash()
  {
    v.a("rqdp{ test native crash}", new Object[0]);
    doNativeCrashForTest();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\feedback\eup\jni\NativeExceptionUpload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */