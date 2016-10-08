package com.tencent.mobileqq.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ThemeSwitchUtil
{
  public static final String a = "ThemeSwitchUtil";
  public static final String b = "previousThemeId";
  public static final String c = "previousThemeVersion";
  public static final String d = "nightmodedownload_uin";
  
  public ThemeSwitchUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Bundle a(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", ThemeUtil.getThemePreferences(paramContext).getString("nightmodedownload_uin", ""));
    return localBundle;
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface)
  {
    Bundle localBundle = new Bundle();
    Object localObject = ThemeUtil.getWeekLoopTheme(paramQQAppInterface);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = paramQQAppInterface.getPreferences();
      paramQQAppInterface = ((SharedPreferences)localObject).getString("previousThemeId", "1000");
      localObject = ((SharedPreferences)localObject).getString("previousThemeVersion", "0");
      localBundle.putString("themeID", paramQQAppInterface);
      localBundle.putString("version", (String)localObject);
      return localBundle;
    }
    localBundle.putString("themeID", (String)localObject);
    localBundle.putString("version", ThemeUtil.getUserCurrentThemeVersion(paramQQAppInterface));
    return localBundle;
  }
  
  public static Boolean a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    Object localObject = paramAppInterface.getPreferences();
    paramAppInterface = paramAppInterface.getAccount();
    String str = ((SharedPreferences)localObject).getString("previousThemeId", "1000");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("previousThemeId", paramString1);
    ((SharedPreferences.Editor)localObject).putString("previousThemeVersion", paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitchUtil", 2, "ThemeSwitchUtil setPreviousThemeIdVersion,uin=" + paramAppInterface + ",oldPreviousThemeId=" + str + ",set new themeId=" + paramString1);
    }
    return Boolean.valueOf(((SharedPreferences.Editor)localObject).commit());
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    Object localObject = ThemeUtil.getThemePreferences(paramContext);
    paramContext = ((SharedPreferences)localObject).getString("nightmodedownload_uin", "");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("nightmodedownload_uin", paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitchUtil", 2, "setUserDownload ,curruin=" + paramString + ",oldPreviousUser=" + paramContext);
    }
    return ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\ThemeSwitchUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */