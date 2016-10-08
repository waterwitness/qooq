package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class StatisticTroopAssist
{
  public static final String a = "Click_grp_asst";
  public static final String b = "grp_setting_asst";
  public static final String c = "grp_setting_msg";
  public static final String d = "grp_msg_equ";
  public static final String e = "grp_msg_dec";
  public static final String f = "grp_msg_inc";
  
  public StatisticTroopAssist()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "Click_grp_asst");
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    paramContext.putInt(paramString + "Click_grp_asst", 0);
    paramContext.putInt(paramString + "grp_setting_asst", 0);
    paramContext.putInt(paramString + "grp_setting_msg", 0);
    paramContext.putInt(paramString + "grp_msg_equ", 0);
    paramContext.putInt(paramString + "grp_msg_dec", 0);
    paramContext.putInt(paramString + "grp_msg_inc", 0);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    int i = paramContext.getInt(paramString1, 0);
    paramContext.edit().putInt(paramString1, i + 1).commit();
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_setting_asst");
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "Click_grp_asst");
  }
  
  public static int c(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_setting_msg");
  }
  
  public static void c(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_setting_asst");
  }
  
  public static int d(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_msg_equ");
  }
  
  public static void d(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_setting_msg");
  }
  
  public static int e(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_msg_dec");
  }
  
  public static void e(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_equ");
  }
  
  public static int f(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "grp_msg_inc");
  }
  
  public static void f(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_dec");
  }
  
  public static void g(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "grp_msg_inc");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\statistics\StatisticTroopAssist.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */