package cooperation.qqpim;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQPimSharedPrefrenceUtil
{
  public static final String a = "QQPIM_SETTING";
  public static final String b = "QQPIM_IS_BACKUP";
  public static final String c = "QQPIM_TIPS_CLICK";
  
  public QQPimSharedPrefrenceUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("QQPIM_SETTING", 0).getLong(paramString, 0L);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("QQPIM_SETTING", 0).getString(paramString, "");
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getSharedPreferences("QQPIM_SETTING", 0).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    paramContext.getSharedPreferences("QQPIM_SETTING", 0).edit().putString(paramString1, paramString2).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqpim\QQPimSharedPrefrenceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */