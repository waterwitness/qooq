package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.io.File;

public class TbsLog
{
  private static TbsLogClient mTbsLogClient = null;
  private static boolean should_show_toast = false;
  
  public static void app_extra(String paramString, Context paramContext)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getApplicationContext();
      String[] arrayOfString = new String[6];
      arrayOfString[0] = "com.tencent.x5sdk.demo";
      arrayOfString[1] = "com.tencent.mtt";
      arrayOfString[2] = "com.tencent.mm";
      arrayOfString[3] = "com.tencent.mobileqq";
      arrayOfString[4] = "com.tencent.mtt.sdk.test";
      arrayOfString[5] = "com.qzone";
      for (;;)
      {
        if (i < arrayOfString.length)
        {
          if (paramContext.getPackageName().contains(arrayOfString[i])) {
            i(paramString, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + new String[] { "DEMO", "QB", "WX", "QQ", "TEST", "QZ" }[i] + "!");
          }
        }
        else
        {
          if (i == arrayOfString.length) {
            i(paramString, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
          }
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Throwable paramContext)
    {
      w(paramString, "app_extra exception:" + Log.getStackTraceString(paramContext));
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (mTbsLogClient == null) {
      return;
    }
    mTbsLogClient.d(paramString1, "TBS:" + paramString2);
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean)
  {
    d(paramString1, paramString2);
    if ((mTbsLogClient != null) && (should_show_toast) && (paramBoolean)) {
      mTbsLogClient.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (mTbsLogClient == null) {
      return;
    }
    mTbsLogClient.e(paramString1, "TBS:" + paramString2);
    mTbsLogClient.writeLog("(E)-" + paramString1 + "-TBS:" + paramString2);
  }
  
  public static void e(String paramString1, String paramString2, boolean paramBoolean)
  {
    e(paramString1, paramString2);
    if ((mTbsLogClient != null) && (should_show_toast) && (paramBoolean)) {
      mTbsLogClient.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static String getTbsLogFilePath()
  {
    if (TbsLogClient.mLogFile != null) {
      return TbsLogClient.mLogFile.getAbsolutePath();
    }
    return null;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (mTbsLogClient == null) {
      return;
    }
    mTbsLogClient.i(paramString1, "TBS:" + paramString2);
    mTbsLogClient.writeLog("(I)-" + paramString1 + "-TBS:" + paramString2);
  }
  
  public static void i(String paramString1, String paramString2, boolean paramBoolean)
  {
    i(paramString1, paramString2);
    if ((mTbsLogClient != null) && (should_show_toast) && (paramBoolean)) {
      mTbsLogClient.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static void initIfNeed(Context paramContext)
  {
    try
    {
      if (mTbsLogClient == null) {
        setTbsLogClient(new TbsLogClient(paramContext));
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void setLogView(TextView paramTextView)
  {
    if ((paramTextView == null) || (mTbsLogClient == null)) {
      return;
    }
    mTbsLogClient.setLogView(paramTextView);
  }
  
  public static boolean setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    if (paramTbsLogClient == null) {
      return false;
    }
    mTbsLogClient = paramTbsLogClient;
    return true;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (mTbsLogClient == null) {
      return;
    }
    mTbsLogClient.v(paramString1, "TBS:" + paramString2);
  }
  
  public static void v(String paramString1, String paramString2, boolean paramBoolean)
  {
    v(paramString1, paramString2);
    if ((mTbsLogClient != null) && (should_show_toast) && (paramBoolean)) {
      mTbsLogClient.showLog(paramString1 + ": " + paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (mTbsLogClient == null) {
      return;
    }
    mTbsLogClient.w(paramString1, "TBS:" + paramString2);
    mTbsLogClient.writeLog("(W)-" + paramString1 + "-TBS:" + paramString2);
  }
  
  public static void w(String paramString1, String paramString2, boolean paramBoolean)
  {
    w(paramString1, paramString2);
    if ((mTbsLogClient != null) && (should_show_toast) && (paramBoolean)) {
      mTbsLogClient.showLog(paramString1 + ": " + paramString2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\TbsLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */