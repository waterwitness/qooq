package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Method;

public class SysCoreQua2Utils
{
  private static final byte CORE_TYPE_BLINK = 2;
  private static final byte CORE_TYPE_SYS = 0;
  private static final byte CORE_TYPE_X5 = 1;
  private static final String MM_PACKAGE_NAME = "com.tencent.mm";
  private static final String TAG = "QBInfoUtils";
  private static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
  private static boolean mIsTablet = false;
  private static boolean mPadCheckFinished;
  private static String mParentPackageName;
  private static String mParentPackageVersion;
  private static String mTbsQua;
  private static String sLCID = "9397";
  
  static
  {
    mTbsQua = "";
    mParentPackageName = "PP";
    mParentPackageVersion = "PPVC";
    mPadCheckFinished = false;
  }
  
  private static void appendInfo(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("&").append(paramString1).append("=").append(paramString2);
  }
  
  private static String generateQUA2(Context paramContext, byte paramByte, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    int i = 0;
    String str2 = "x5Version";
    byte b = 0;
    String str1 = "blinkVersion";
    switch (paramByte)
    {
    default: 
      paramByte = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QV").append("=").append("2");
      appendInfo(localStringBuilder, "PL", "ADR");
      if (paramBoolean)
      {
        appendInfo(localStringBuilder, "PR", "TBS");
        label88:
        appendInfo(localStringBuilder, "PB", "GE");
        appendInfo(localStringBuilder, "VE", "B1");
        if (!paramBoolean) {
          break label378;
        }
        appendInfo(localStringBuilder, "VN", paramString2);
        label119:
        if (i == 0) {
          break label390;
        }
        appendInfo(localStringBuilder, "CO", "X5");
        appendInfo(localStringBuilder, "COVN", str2);
        label142:
        appendInfo(localStringBuilder, "RF", "PRI");
        if (paramBoolean) {
          break label435;
        }
      }
      break;
    }
    for (;;)
    {
      appendInfo(localStringBuilder, "RL", getDeviceWidth(paramContext) + "*" + getDeviceHeight(paramContext));
      paramString1 = getDeviceName();
      try
      {
        paramString2 = new String(paramString1.getBytes("UTF-8"), "ISO8859-1");
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          continue;
          appendInfo(localStringBuilder, "DE", "PHONE");
        }
      }
      if (!TextUtils.isEmpty(paramString1)) {
        appendInfo(localStringBuilder, "MO", paramString1);
      }
      if (!isRealPad(paramContext)) {
        break label461;
      }
      appendInfo(localStringBuilder, "DE", "PAD");
      paramContext = Build.VERSION.RELEASE;
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          continue;
          paramContext = "11111";
        }
      }
      if (!TextUtils.isEmpty(paramContext)) {
        appendInfo(localStringBuilder, "OS", paramContext);
      }
      appendInfo(localStringBuilder, "API", Build.VERSION.SDK_INT + "");
      if (!TextUtils.isEmpty("11111")) {
        break label477;
      }
      paramContext = "0";
      appendInfo(localStringBuilder, "CHID", paramContext);
      appendInfo(localStringBuilder, "LCID", getLCID());
      return localStringBuilder.toString();
      i = 1;
      str2 = paramString1;
      paramByte = b;
      break;
      paramByte = 1;
      str1 = paramString1;
      break;
      appendInfo(localStringBuilder, "PR", "QB");
      break label88;
      label378:
      appendInfo(localStringBuilder, "VN", "QBVersion");
      break label119;
      label390:
      if (paramByte != 0)
      {
        appendInfo(localStringBuilder, "CO", "Blink");
        appendInfo(localStringBuilder, "COVN", str1);
        break label142;
      }
      appendInfo(localStringBuilder, "CO", "AMTT");
      appendInfo(localStringBuilder, "COVN", paramString1);
      break label142;
      label435:
      appendInfo(localStringBuilder, "PP", paramString3);
      appendInfo(localStringBuilder, "PPVC", paramString4);
    }
  }
  
  private static String getAndroidOsSystemProperties(String paramString)
  {
    try
    {
      paramString = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      if (paramString != null) {}
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static int getDensityDpi(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.densityDpi;
  }
  
  private static int getDeviceHeight(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  private static String getDeviceName()
  {
    return " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
  }
  
  private static int getDeviceWidth(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  private static String getLCID()
  {
    return sLCID;
  }
  
  private static String getNewBeeROMName()
  {
    return getAndroidOsSystemProperties("ro.build.version.newbee.display");
  }
  
  public static String getQUA2(Context paramContext)
  {
    if (!mTbsQua.equals("")) {
      return mTbsQua;
    }
    Object localObject1 = paramContext.getApplicationInfo();
    try
    {
      Object localObject2 = paramContext.getPackageManager().getPackageInfo(((ApplicationInfo)localObject1).packageName, 0);
      mParentPackageName = ((ApplicationInfo)localObject1).packageName;
      mParentPackageVersion = String.valueOf(((PackageInfo)localObject2).versionCode);
      localObject1 = null;
      if (mParentPackageName.equals("com.tencent.mm")) {
        localObject1 = AppUtil.getAppMetadata(paramContext.getApplicationContext(), "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      }
      localObject2 = mParentPackageName;
      if (localObject1 != null)
      {
        mTbsQua = generateQUA2(paramContext, (byte)0, "0", true, "2.2.0.1095", (String)localObject2, (String)localObject1);
        return mTbsQua;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        continue;
        String str = mParentPackageVersion;
      }
    }
  }
  
  private static boolean isRealPad(Context paramContext)
  {
    if (mPadCheckFinished) {
      return mIsTablet;
    }
    if (Math.min(getDeviceWidth(paramContext), getDeviceHeight(paramContext)) * 160 / getDensityDpi(paramContext) >= 700) {}
    for (boolean bool = true;; bool = false)
    {
      mIsTablet = bool;
      mPadCheckFinished = true;
      return mIsTablet;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\SysCoreQua2Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */