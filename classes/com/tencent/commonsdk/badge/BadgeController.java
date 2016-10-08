package com.tencent.commonsdk.badge;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;

public final class BadgeController
{
  private static final String[] LAUNCHER_WHITE_LIST = { "com.tct.launcher", "com.bbk.studyos.launcher" };
  private static final String TAG = "BadgeUtils";
  private static Context sApplication;
  private static String sCurBadgeProviderAuthorities;
  private static String sCurLauncherPackageName;
  private static boolean sDebug = false;
  private static volatile Integer sNextCount;
  private static volatile boolean sResumed = true;
  
  private static String getCurLauncherPackageName()
  {
    Object localObject = new Intent("android.intent.action.MAIN");
    ((Intent)localObject).addCategory("android.intent.category.HOME");
    localObject = sApplication.getPackageManager().resolveActivity((Intent)localObject, 0);
    if ((localObject == null) || (((ResolveInfo)localObject).activityInfo == null)) {}
    while (((ResolveInfo)localObject).activityInfo.packageName.equals("android")) {
      return null;
    }
    return ((ResolveInfo)localObject).activityInfo.packageName;
  }
  
  public static void init(Context paramContext)
  {
    sApplication = paramContext.getApplicationContext();
    paramContext = getCurLauncherPackageName();
    int k = 0;
    String[] arrayOfString = LAUNCHER_WHITE_LIST;
    int m = arrayOfString.length;
    int i = 0;
    int j = k;
    if (i < m)
    {
      if (arrayOfString[i].equalsIgnoreCase(paramContext)) {
        j = 1;
      }
    }
    else
    {
      if (sDebug) {
        break label105;
      }
      if (j == 0) {}
    }
    label105:
    for (sCurLauncherPackageName = paramContext;; sCurLauncherPackageName = paramContext)
    {
      if (sCurLauncherPackageName != null) {}
      try
      {
        paramContext = sApplication.getPackageManager().getApplicationInfo(sCurLauncherPackageName, 128);
        if (paramContext != null) {
          sCurBadgeProviderAuthorities = paramContext.metaData.getString("badge_provider");
        }
        return;
      }
      catch (Exception paramContext) {}
      i += 1;
      break;
    }
  }
  
  public static boolean isSupport(Context paramContext)
  {
    if (sCurLauncherPackageName == null) {
      init(paramContext);
    }
    return sCurBadgeProviderAuthorities != null;
  }
  
  public static void resumeOrPause(boolean paramBoolean)
  {
    sResumed = paramBoolean;
    Integer localInteger = sNextCount;
    if ((sResumed) && (localInteger != null)) {
      setBadge(localInteger.intValue());
    }
  }
  
  public static boolean setBadge(int paramInt)
  {
    if (!sResumed) {}
    for (sNextCount = Integer.valueOf(paramInt); sCurBadgeProviderAuthorities == null; sNextCount = null) {
      return false;
    }
    Uri localUri = Uri.parse("content://" + sCurBadgeProviderAuthorities + "/badge");
    Bundle localBundle = new Bundle();
    localBundle.putInt("count", paramInt);
    return sApplication.getContentResolver().call(localUri, "setBadge", "", localBundle).getBoolean("result");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\badge\BadgeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */