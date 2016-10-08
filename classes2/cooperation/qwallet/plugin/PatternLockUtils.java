package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.gesturelock.LockPatternView.Cell;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatternLockUtils
{
  public static final int a = 5;
  protected static long a = 0L;
  private static final String a = "Q.qwallet.pay.pattutils";
  public static final int b = 600;
  private static final String b = "qwallet_patternlock";
  public static final int c = 300;
  private static final String c = "lock_pwd";
  public static final int d = 4;
  private static final String d = "unlock_failed_times";
  private static final String e = "last_unlock_failed_time";
  private static final String f = "is_first_create";
  private static final String g = "is_need_sync";
  private static final String h = "isFirstEnterAfterLogin";
  private static final String i = "check_interval_time";
  private static final String j = "forground_interval_time";
  private static final String k = "is_new_create";
  private static final String l = "cft_user_type";
  
  public PatternLockUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    int m = a(paramContext).getInt("unlock_failed_times" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getUnlockFailedTime.uin=" + paramString + ",failedTimes=" + m);
    }
    return m;
  }
  
  public static long a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getLastExitWalletTime,gLastExitWalletTime=" + a);
    }
    return a;
  }
  
  public static long a(Context paramContext, String paramString)
  {
    long l2 = a(paramContext).getLong("check_interval_time" + paramString, -1L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getCheckIntervalTime.uin=" + paramString + ",checkIntervalTime=" + l2);
    }
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 300L;
    }
    return l1;
  }
  
  private static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qwallet_patternlock", 4);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext).getString("lock_pwd" + paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getGesturePWD.uin=" + paramString + ",pw=" + paramContext);
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    String str = Utils.b(paramContext);
    paramContext = b(paramContext, paramString1, paramString2);
    return MD5.toMD5(str + paramContext);
  }
  
  public static String a(List paramList)
  {
    if (paramList == null) {
      return "";
    }
    int n = paramList.size();
    StringBuilder localStringBuilder = new StringBuilder(n);
    int m = 0;
    while (m < n)
    {
      LockPatternView.Cell localCell = (LockPatternView.Cell)paramList.get(m);
      int i1 = localCell.a();
      localStringBuilder.append((char)(localCell.b() + i1 * 3 + 49));
      m += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    int m = 0;
    while (m < paramString.length())
    {
      int n = paramString.indexOf(m) - 49;
      localArrayList.add(LockPatternView.Cell.a(n / 3, n % 3));
      m += 1;
    }
    return localArrayList;
  }
  
  public static void a(long paramLong)
  {
    a = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setLastExitWalletTime,curTime=" + paramLong);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setUnlockFailedTime.uin=" + paramString + ",failedTimes=" + paramInt);
    }
    paramContext = a(paramContext).edit();
    paramContext.putInt("unlock_failed_times" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setCheckIntervalTime.uin=" + paramString + ",curTime=" + paramLong);
    }
    paramContext = a(paramContext).edit();
    paramContext.putLong("check_interval_time" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setGesturePWD.uin=" + paramString1 + ",pw=" + paramString2);
    }
    paramContext = a(paramContext).edit();
    paramContext.putString("lock_pwd" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setFirstCreatePatternLock.uin=" + paramString + ",isFirst=" + paramBoolean);
    }
    paramContext = a(paramContext).edit();
    paramContext.putBoolean("is_first_create" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (GesturePWDUtils.getAppForground(paramActivity)) {
      return false;
    }
    paramString = paramString.toLowerCase();
    if (!paramString.startsWith("mqqapi://wallet/open?")) {
      return false;
    }
    for (;;)
    {
      int m;
      try
      {
        paramString = paramString.split("\\?");
        if (paramString.length != 2) {
          return false;
        }
        Object localObject1 = paramString[1].split("&");
        paramString = new HashMap();
        if (localObject1 != null)
        {
          m = 0;
          if (m < localObject1.length)
          {
            localObject2 = localObject1[m].split("=");
            if ((localObject2 == null) || (localObject2.length != 2)) {
              break label243;
            }
            paramString.put(localObject2[0], localObject2[1]);
            break label243;
          }
        }
        localObject1 = (String)paramString.get("src_type");
        Object localObject2 = (String)paramString.get("viewtype");
        paramString = (String)paramString.get("view");
        if ((localObject1 == null) || (!((String)localObject1).equals("web"))) {
          break;
        }
        if ((localObject2 == null) || (!((String)localObject2).equals("0"))) {
          break label254;
        }
        if ((paramString != null) && (!paramString.equals("0")))
        {
          boolean bool = paramString.equals("1");
          if (!bool) {
            return false;
          }
        }
      }
      catch (Exception paramActivity)
      {
        return false;
      }
      return a(paramActivity, paramQQAppInterface.a());
      label243:
      m += 1;
    }
    return false;
    label254:
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
    return (paramContext != null) && (paramContext.length() > 0);
  }
  
  public static int b(Context paramContext, String paramString)
  {
    int m = a(paramContext).getInt("cft_user_type" + paramString, -1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getCftUserType.uin=" + paramString + ",userType=" + m);
    }
    return m;
  }
  
  public static long b(Context paramContext, String paramString)
  {
    long l1 = a(paramContext).getLong("forground_interval_time" + paramString, -1L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getForgroundIntervalTime.uin=" + paramString + ",forgroundIntervalTime=" + l1);
    }
    if (l1 < 0L) {
      return 0L;
    }
    return l1;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = MD5.toMD5(paramString1 + paramString2);
    return MD5.toMD5(paramContext + paramString2);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setCftUserType.uin=" + paramString + ",userType=" + paramInt);
    }
    paramContext = a(paramContext).edit();
    paramContext.putInt("cft_user_type" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setForgroundIntervalTime.uin=" + paramString + ",curTime=" + paramLong);
    }
    paramContext = a(paramContext).edit();
    paramContext.putLong("forground_interval_time" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setNewCreatePatternLock.uin=" + paramString + ",isNew=" + paramBoolean);
    }
    paramContext = a(paramContext).edit();
    paramContext.putBoolean("is_new_create" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool = a(paramContext).getBoolean("is_first_create" + paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "isFirstCreatePatternLock.uin=" + paramString + ",isFirst=" + bool);
    }
    return bool;
  }
  
  public static long c(Context paramContext, String paramString)
  {
    long l1 = a(paramContext).getLong("last_unlock_failed_time" + paramString, 0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getLastUnlockFailedTime.uin=" + paramString + ",allFailedTime=" + l1);
    }
    return l1;
  }
  
  public static void c(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setLastUnlockFailedTime.uin=" + paramString + ",curTime=" + paramLong);
    }
    paramContext = a(paramContext).edit();
    paramContext.putLong("last_unlock_failed_time" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setSyncPatternLockState.uin=" + paramString + ",isNeedSync=" + paramBoolean);
    }
    a(paramContext).edit().putBoolean("is_need_sync" + paramString, paramBoolean).commit();
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    boolean bool = a(paramContext).getBoolean("is_new_create" + paramString, false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "isNewCreatePatternLock.uin=" + paramString + ",isNew=" + bool);
    }
    return bool;
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "setFirstEnterAfterLoginState.uin=" + paramString + ",isFirstState=" + paramBoolean);
    }
    a(paramContext).edit().putBoolean("isFirstEnterAfterLogin" + paramString, paramBoolean).commit();
    if (paramBoolean) {
      c(paramContext, paramString, true);
    }
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    boolean bool = a(paramContext).getBoolean("is_need_sync" + paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "getSyncPatternLockState.uin=" + paramString + ",isNeedSync=" + bool);
    }
    return bool;
  }
  
  public static boolean e(Context paramContext, String paramString)
  {
    boolean bool = a(paramContext).getBoolean("isFirstEnterAfterLogin" + paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay.pattutils", 2, "isFirstEnterAfterLogin.uin=" + paramString + ",isFirstEnterAfterLogin=" + bool);
    }
    return bool;
  }
  
  public static boolean f(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            String str = a(paramContext, paramString);
            if ((str == null) || (str.length() <= 0)) {
              return false;
            }
            bool1 = bool2;
          } while (c(paramContext, paramString));
          bool1 = bool2;
        } while (e(paramContext, paramString));
        bool1 = bool2;
      } while (a(paramContext, paramString) >= 5);
      bool1 = bool2;
    } while (a(paramContext, paramString) + a() <= NetConnInfoCenter.getServerTimeMillis() / 1000L);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\PatternLockUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */