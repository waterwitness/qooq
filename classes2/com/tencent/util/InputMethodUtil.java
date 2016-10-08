package com.tencent.util;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.Secure;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class InputMethodUtil
{
  public static final String A = "TimeLength";
  public static final String a = "SOGOU_EXPRESSION";
  public static final String b = "com.sogou.inputmethod.expression";
  public static final String c = "SOGOU_EXP_PATH";
  public static final String d = "com.tencent.qqpinyin.expression";
  public static final String e = "com.tencent.qqpinyin.qqexp";
  public static final String f = "com.tencent.qqpinyin";
  public static final String g = "QQINPUT_EXP_PATH";
  public static final String h = "com.sogou.inputmethod.qqexp";
  public static final String i = "PACKAGE_ID";
  public static final String j = "EXP_ID";
  public static final String k = "EXP_PATH";
  public static final String l = "EXP_KEY";
  public static final String m = "EXP_ALL_PACKID";
  public static final String n = "com.sogou.inputmethod.appid";
  public static final String o = "com.tencent.mobileqq.sogou.openid";
  public static final String p = "SOGOU_APP_ID";
  public static final String q = "SOGOU_OPENID";
  public static final String r = "sougouptt";
  public static final String s = "com.tencent.mobileqq_audioArgs";
  public static final String t = "com.tencent.mobileqq_handleCompleted";
  public static final String u = "PCMFilePath";
  public static final String v = "Channels";
  public static final String w = "SampleRate";
  public static final String x = "InputMethodName";
  public static final String y = "com.sohu.inputmethod.sogou";
  public static final String z = "DoesSupportDirectlyAudio";
  
  public InputMethodUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Activity paramActivity)
  {
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
      if (localInputMethodManager.isActive()) {
        localInputMethodManager.hideSoftInputFromWindow(paramActivity.getWindow().getDecorView().getWindowToken(), 0);
      }
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isDevelopLevel()) {}
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(View paramView)
  {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).showSoftInput(paramView, 0);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "default_input_method");
      bool1 = bool2;
      if (paramContext != null) {
        if (!paramContext.contains("com.sohu.inputmethod.sogou"))
        {
          bool1 = bool2;
          if (!paramContext.contains("com.tencent.qqpinyin")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    catch (NullPointerException paramContext)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("InputMethodUtil", 2, "checkSogouInputDefault(), e = " + paramContext.getStackTrace());
    }
    return bool1;
    return false;
  }
  
  public static void b(View paramView)
  {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\util\InputMethodUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */