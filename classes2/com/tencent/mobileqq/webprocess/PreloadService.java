package com.tencent.mobileqq.webprocess;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import wgq;

public class PreloadService
{
  public static final long a = 1L;
  public static WebViewPluginEngine a;
  public static final Object a;
  public static final String a = "preload_opt";
  public static volatile boolean a = false;
  public static final long b = 2L;
  public static WebViewPluginEngine b;
  private static final String b = "PreloadService";
  public static volatile boolean b = false;
  public static final long c = 4L;
  public static volatile boolean c = false;
  public static final long d = 8L;
  public static volatile boolean d = false;
  public static final long e = 16L;
  public static volatile boolean e = false;
  public static final long f = 31L;
  private static volatile boolean f;
  private static volatile boolean g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "preloadForTool start");
    }
    if (!g)
    {
      g = true;
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "preloadForTool webview");
      }
      ThreadManager.a(new wgq(paramContext), null, false);
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "preloadForTool webview end");
      }
    }
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "preload options:" + paramLong);
    }
    long l = paramLong;
    if ((paramLong & 0x4) == 4L)
    {
      l = paramLong;
      if (!f)
      {
        f = true;
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "preload webview");
        }
      }
    }
    try
    {
      WebAccelerateHelper.getInstance().createWebView(paramContext.getApplicationContext());
      WebAccelerateHelper.getInstance().preInflaterBrowserView();
      l = paramLong ^ 0x4;
      if (jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "preload:already initialized.");
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "preload webview failed:" + localException.toString());
        }
      }
      new PreloadService.PreloadImpl().a(paramContext, l);
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getClass().getSimpleName().equals("ReaderRuntime");
  }
  
  public static void b(Context paramContext)
  {
    a(paramContext, 31L);
  }
  
  public static boolean b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getClass().getSimpleName().equals("VipComicPluginRuntime");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webprocess\PreloadService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */