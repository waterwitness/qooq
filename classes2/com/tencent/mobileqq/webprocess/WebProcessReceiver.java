package com.tencent.mobileqq.webprocess;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQBroadcastReceiver;

public class WebProcessReceiver
  extends QQBroadcastReceiver
{
  public static int a = 0;
  public static long a = 0L;
  protected static final String a = "WebProcessReceiver";
  public static final int b = 100;
  public static long b = 0L;
  public static final String b = "com.tencent.mobileqq.webprocess.preload_web_process";
  public static final String c = "action_clear_cache";
  public static final String d = "action_reset_tbs";
  public static final String e = "action_download_tbs";
  public static final String f = "com.tencent.msg.permission.pushnotify";
  public static final String g = "com.tencent.mobileqq.webprocess.start_time";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = -1;
  }
  
  private void b(Context paramContext)
  {
    try
    {
      PreloadService.b(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  protected void a(Context paramContext)
  {
    try
    {
      WebView localWebView = new WebView(paramContext);
      if (localWebView.getX5WebViewExtension() == null)
      {
        WebSettings localWebSettings = localWebView.getSettings();
        if (localWebSettings != null)
        {
          String str2 = "";
          String str3 = MobileQQ.getMobileQQ().getProcessName();
          String str1 = str2;
          if (str3 != null)
          {
            int i = str3.lastIndexOf(':');
            str1 = str2;
            if (i > -1) {
              str1 = "_" + str3.substring(i);
            }
          }
          localWebSettings.setDatabasePath(paramContext.getDir("database" + str1, 0).getPath());
          localWebSettings.setAppCachePath(paramContext.getDir("appcache" + str1, 0).getPath());
        }
        localWebView.clearCache(true);
        localWebView.clearFormData();
        localWebView.clearSslPreferences();
        localWebView.clearHistory();
        localWebView.clearMatches();
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      for (;;)
      {
        localWebView.destroy();
        return;
        QbSdk.clearAllWebViewCache(paramContext, true);
      }
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiver", 2, "clear webview cache got exception:", paramContext);
      }
    }
  }
  
  protected void a(AppRuntime paramAppRuntime, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessReceiver", 2, "preloadData");
    }
    b(paramContext);
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    String str;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      if (str != null) {
        break label16;
      }
    }
    label16:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiver", 2, "action=" + str);
      }
      if ("com.tencent.mobileqq.webprocess.preload_web_process".equals(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessReceiver", 2, "Receive preload broadcast, start web process!");
        }
        jdField_a_of_type_Long = paramIntent.getLongExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
        b = System.currentTimeMillis();
        if (!WebIPCOperator.a().a()) {
          WebIPCOperator.a().a().doBindService(paramContext.getApplicationContext());
        }
        a(paramAppRuntime, paramContext);
        try
        {
          jdField_a_of_type_Int = paramIntent.getIntExtra("from", -1);
          return;
        }
        catch (Exception paramAppRuntime)
        {
          paramAppRuntime.printStackTrace();
          return;
        }
      }
      if ("action_clear_cache".equals(str))
      {
        a(paramContext);
        SwiftBrowserCookieMonster.b();
        return;
      }
      if ("action_reset_tbs".equals(str))
      {
        QbSdk.reset(paramContext.getApplicationContext());
        return;
      }
    } while (!"action_download_tbs".equals(str));
    paramIntent = WebAccelerateHelper.getInstance().getTBSDpcParam();
    if ((paramIntent != null) && (paramIntent.charAt(0) == '1')) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = TbsDownloader.needDownload(paramContext, false);
      if ((i == 0) || (!bool) || (!(paramAppRuntime instanceof BrowserAppInterface))) {
        break;
      }
      ((BrowserAppInterface)paramAppRuntime).a();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webprocess\WebProcessReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */