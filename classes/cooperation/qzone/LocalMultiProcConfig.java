package cooperation.qzone;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ykl;

public class LocalMultiProcConfig
{
  public static final String a = "Qz_setting";
  public static final String b = "QZ_QQ_shared_setting";
  public static final String c = "QZ_video_shared_setting";
  public static final String d = "paster_setting";
  public static final String e = "QZ_Per_Config";
  public static final String f = "Widget_";
  public static final String g = "qzone_bar_time_stamp";
  public static final String h = "QZ_setting";
  public static final String i = "Qzone_setVideoplay";
  public static final String j = "qzone_font_enabled";
  public static final String k = "qzone_font_red_dot";
  private static final String l = "QZ_QQ_shared_preference";
  
  public LocalMultiProcConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString, int paramInt)
  {
    return a("QZ_QQ_shared_setting", paramString, paramInt);
  }
  
  public static int a(String paramString, int paramInt, long paramLong)
  {
    return a(paramLong).getInt(paramString, paramInt);
  }
  
  public static int a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      int m = a(Long.valueOf(paramString2).longValue()).getInt(paramString1, paramInt);
      return m;
    }
    catch (NumberFormatException paramString1) {}
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1).getInt(paramString2, paramInt);
  }
  
  public static long a(String paramString, long paramLong)
  {
    return a("QZ_QQ_shared_setting").getLong(paramString, paramLong);
  }
  
  public static long a(String paramString, long paramLong1, long paramLong2)
  {
    return a(paramLong2).getLong(paramString, paramLong1);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1).getLong(paramString2, paramLong);
  }
  
  private static SharedPreferences a(long paramLong)
  {
    if (paramLong == 0L) {
      return a("QZ_QQ_shared_setting");
    }
    return a(paramLong + "_" + "QZ_QQ_shared_preference");
  }
  
  private static SharedPreferences a(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int m = 4;; m = 0) {
      return localBaseApplicationImpl.getSharedPreferences(paramString, m);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a("QZ_QQ_shared_setting", paramString1, paramString2);
  }
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramLong).getString(paramString1, paramString2);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1).getString(paramString2, paramString3);
  }
  
  private static void a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT < 9)
    {
      paramEditor.commit();
      return;
    }
    paramEditor.apply();
  }
  
  public static void a(String paramString, int paramInt)
  {
    a("QZ_QQ_shared_setting", paramString, paramInt);
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = a(paramLong).edit();
    localEditor.putInt(paramString, paramInt);
    a(localEditor);
  }
  
  public static void a(String paramString, long paramLong)
  {
    b("QZ_QQ_shared_setting", paramString, paramLong);
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2)
  {
    SharedPreferences.Editor localEditor = a(paramLong2).edit();
    localEditor.putLong(paramString, paramLong1);
    a(localEditor);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a("QZ_QQ_shared_setting", paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = a(paramString1).edit();
    paramString1.putInt(paramString2, paramInt);
    a(paramString1);
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences.Editor localEditor = a(paramLong).edit();
    localEditor.putString(paramString1, paramString2);
    a(localEditor);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1).edit();
    paramString1.putString(paramString2, paramString3);
    a(paramString1);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.a(new ykl(paramString1, paramString2, paramBoolean), 8, null, true);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    a("QZ_QQ_shared_setting", paramString, paramBoolean);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramString1).getBoolean(paramString2, paramBoolean);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a("QZ_QQ_shared_setting", paramString, paramBoolean);
  }
  
  public static void b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = a(paramString1).edit();
    paramString1.putLong(paramString2, paramLong);
    a(paramString1);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = a(paramString1).edit();
    paramString1.putBoolean(paramString2, paramBoolean);
    a(paramString1);
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    b("QZ_QQ_shared_setting", paramString, paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\qzone\LocalMultiProcConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */