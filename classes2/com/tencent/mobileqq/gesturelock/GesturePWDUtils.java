package com.tencent.mobileqq.gesturelock;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;
import ssr;

public class GesturePWDUtils
{
  public static final int GESTUREPWD_MODE_AUTO = 21;
  public static final int GESTUREPWD_MODE_MANUAL = 20;
  public static final int GESTUREPWD_STATE_CLOSED = 1;
  public static final int GESTUREPWD_STATE_NOTSET = 0;
  public static final int GESTUREPWD_STATE_OPEN = 2;
  public static final int GESTUREPWD_UNLOCKFAILED_TYPE_FORGET = 0;
  public static final int GESTUREPWD_UNLOCKFAILED_TYPE_WRONG = 1;
  public static final String GESTURE_SALT = "28DF17A9B837BAFD951724E325F6F86B5B6E477D";
  private static long jdField_a_of_type_Long = 0L;
  private static final String jdField_a_of_type_JavaLangString = "Q.gesturelock.util";
  private static final String b = "gesturepassword_sharepreference";
  private static final String c = "gesturepassword_gesture_state";
  private static final String d = "gesturepassword_gesture_pwd";
  private static final String e = "gesturepassword_gesture_mode";
  private static final String f = "gesturepassword_unlock_failed";
  private static final String g = "gesturepassword_unlock_failed_type";
  private static final String h = "gesturepassword_locking";
  private static final String i = "gesturepassword_unlock_failed_time";
  private static final String j = "gesturepassword_currentuin_forplugin";
  private static final String k = "gesturepassword_appforground";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = -1L;
  }
  
  private static SharedPreferences a(Context paramContext)
  {
    return BaseApplicationImpl.a().getSharedPreferences("gesturepassword_sharepreference", 4);
  }
  
  private static SharedPreferences b(Context paramContext)
  {
    return BaseApplicationImpl.a().getSharedPreferences("gesturepassword_sharepreference", 4);
  }
  
  public static void clearGestureData(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "clearGestureData.uin=" + paramString);
    }
    paramContext = a(paramContext).edit();
    paramContext.putInt("gesturepassword_gesture_state" + paramString, 0);
    paramContext.putString("gesturepassword_gesture_pwd" + paramString, "");
    paramContext.commit();
  }
  
  public static boolean enableGestureLock(Context paramContext)
  {
    int m = Process.myPid();
    Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    String str = paramContext.getApplicationContext().getPackageName();
    paramContext = ((ActivityManager)localObject).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      } while (((ActivityManager.RunningAppProcessInfo)localObject).pid != m);
    }
    for (paramContext = ((ActivityManager.RunningAppProcessInfo)localObject).processName;; paramContext = "") {
      return (paramContext != null) && ((paramContext.equals(str + ":qzone")) || (paramContext.equals(str + ":picture")) || (paramContext.equals(str + ":qqfav")) || (paramContext.equals(str + ":qlink")));
    }
  }
  
  public static String encodeGesture(String paramString1, String paramString2)
  {
    paramString1 = MD5.toMD5(paramString1);
    int n = "28DF17A9B837BAFD951724E325F6F86B5B6E477D".length();
    if (!TextUtils.isEmpty(paramString2)) {}
    for (int m = paramString2.length();; m = 0)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new StringBuilder(paramString1);
        paramString1.insert(6, "28DF17A9B837BAFD951724E325F6F86B5B6E477D".substring(0, n / 2));
        paramString1.insert(paramString1.length() - 9, "28DF17A9B837BAFD951724E325F6F86B5B6E477D".substring(n / 2, n));
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString1.insert(2, paramString2.substring(0, m / 2));
          paramString1.insert(paramString1.length() - 5, paramString2.substring(m / 2, m));
        }
      }
      for (paramString1 = paramString1.toString();; paramString1 = "") {
        return MD5.toMD5(paramString1);
      }
    }
  }
  
  public static boolean getAppForground(Context paramContext)
  {
    boolean bool = b(paramContext).getBoolean("gesturepassword_appforground", false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getAppForground.uin=,isAppFroground=" + bool);
    }
    return bool;
  }
  
  public static boolean getGestureLocking(Context paramContext)
  {
    boolean bool = a(paramContext).getBoolean("gesturepassword_locking", false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGestureLocking.uin=,islocking=" + bool);
    }
    return bool;
  }
  
  public static String getGesturePWD(Context paramContext, String paramString)
  {
    paramContext = a(paramContext).getString("gesturepassword_gesture_pwd" + paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGesturePWD.uin=" + paramString + ",pw=" + paramContext);
    }
    return paramContext;
  }
  
  public static int getGesturePWDMode(Context paramContext, String paramString)
  {
    int m = a(paramContext).getInt("gesturepassword_gesture_mode" + paramString, 21);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGesturePWDMode.uin=" + paramString + ",mode=" + m);
    }
    return m;
  }
  
  public static int getGesturePWDState(Context paramContext, String paramString)
  {
    int m = a(paramContext).getInt("gesturepassword_gesture_state" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGesturePWDState.uin=" + paramString + ",state=" + m);
    }
    return m;
  }
  
  public static boolean getGestureUnlockFailed(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramContext = a(paramContext);
    String str = paramContext.getString("gesturepassword_unlock_failed", "");
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (str.equals(paramString))
        {
          bool1 = bool2;
          if (paramContext.getInt("gesturepassword_gesture_state" + paramString, 0) == 0) {
            bool1 = true;
          }
        }
      }
    }
    paramContext = paramContext.edit();
    paramContext.putString("gesturepassword_unlock_failed", "");
    paramContext.commit();
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGestureUnlockFailed.uin=" + paramString + ",ret=" + bool1);
    }
    return bool1;
  }
  
  public static int getGestureUnlockFailedTime(Context paramContext, String paramString)
  {
    int m = a(paramContext).getInt("gesturepassword_unlock_failed_time" + paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGestureUnlockFailedTime.uin=" + paramString + ",failedTime=" + m);
    }
    return m;
  }
  
  public static int getGestureUnlockFailedType(Context paramContext)
  {
    int m = a(paramContext).getInt("gesturepassword_unlock_failed_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getGestureUnlockFailedType.type=" + m);
    }
    return m;
  }
  
  public static boolean getJumpLock(Context paramContext, String paramString)
  {
    boolean bool = true;
    paramContext = a(paramContext);
    int m = paramContext.getInt("gesturepassword_gesture_mode" + paramString, 21);
    if (m == 21) {
      if (paramContext.getInt("gesturepassword_gesture_state" + paramString, 0) != 2) {
        break label129;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.gesturelock.util", 2, "getJumpLock.uin=" + paramString + ",isjumplock=" + bool);
      }
      return bool;
      if ((m != 20) || (!paramContext.getBoolean("gesturepassword_locking", false))) {
        label129:
        bool = false;
      }
    }
  }
  
  public static boolean getSplashLock(Context paramContext, String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    int m;
    if (!TextUtils.isEmpty(paramString))
    {
      paramContext = a(paramContext);
      m = paramContext.getInt("gesturepassword_gesture_mode" + paramString, 21);
      if (m != 21) {
        break label132;
      }
      if (paramContext.getInt("gesturepassword_gesture_state" + paramString, 0) != 2) {
        break label161;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.gesturelock.util", 2, "getSplashLock.uin=" + paramString + ",islock=" + bool1);
      }
      return bool1;
      label132:
      bool1 = bool3;
      if (m == 20)
      {
        bool1 = bool3;
        if (paramContext.getBoolean("gesturepassword_locking", false))
        {
          bool1 = true;
          continue;
          label161:
          bool1 = false;
        }
      }
    }
  }
  
  public static String getUinForPlugin(Context paramContext)
  {
    paramContext = a(paramContext).getString("gesturepassword_currentuin_forplugin", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "getUinForPlugin.uin=" + paramContext);
    }
    return paramContext;
  }
  
  public static boolean isAppOnForeground(Context paramContext)
  {
    if (Foreground.sCountActivity > 0) {
      return true;
    }
    Object localObject = (ActivityManager)paramContext.getApplicationContext().getSystemService("activity");
    paramContext = paramContext.getApplicationContext().getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.importance == 100) && (localRunningAppProcessInfo.processName.startsWith(paramContext))) {
        return true;
      }
    }
    return false;
  }
  
  public static String patternToString(List paramList)
  {
    if (paramList == null) {
      return "";
    }
    int n = paramList.size();
    byte[] arrayOfByte = new byte[n];
    int m = 0;
    while (m < n)
    {
      LockPatternView.Cell localCell = (LockPatternView.Cell)paramList.get(m);
      int i1 = localCell.a();
      arrayOfByte[m] = ((byte)(localCell.b() + i1 * 3));
      m += 1;
    }
    return Arrays.toString(arrayOfByte);
  }
  
  public static void setAppForground(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setAppForground.uin=,isAppFroground=" + paramBoolean);
    }
    SharedPreferences.Editor localEditor = b(paramContext).edit();
    localEditor.putBoolean("gesturepassword_appforground", paramBoolean);
    localEditor.commit();
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      new ssr(paramContext).execute(new Void[0]);
    }
  }
  
  public static void setGestureLocking(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGestureLocking.uin=,islock=" + paramBoolean);
    }
    paramContext = a(paramContext).edit();
    paramContext.putBoolean("gesturepassword_locking", paramBoolean);
    paramContext.commit();
  }
  
  public static void setGesturePWD(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGesturePWD.uin=" + paramString1 + ",pw=" + paramString2);
    }
    paramContext = a(paramContext).edit();
    paramContext.putString("gesturepassword_gesture_pwd" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void setGesturePWDMode(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGesturePWDMode.uin=" + paramString + ",mode=" + paramInt);
    }
    paramContext = a(paramContext).edit();
    paramContext.putInt("gesturepassword_gesture_mode" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void setGesturePWDState(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGesturePWDState.uin=" + paramString + ",state=" + paramInt);
    }
    paramContext = a(paramContext).edit();
    paramContext.putInt("gesturepassword_gesture_state" + paramString, paramInt);
    if ((paramContext.commit()) && (paramInt == 2)) {
      com.tencent.mobileqq.app.BaseActivity.isUnLockSuccess = true;
    }
  }
  
  public static void setGestureUnlockFailed(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGestureUnlockFailed.uin=" + paramString);
    }
    paramContext = a(paramContext).edit();
    paramContext.putString("gesturepassword_unlock_failed", paramString);
    paramContext.commit();
  }
  
  public static void setGestureUnlockFailedTime(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGestureUnlockFailedTime.uin=" + paramString + ",failedTime=" + paramInt);
    }
    paramContext = a(paramContext).edit();
    paramContext.putInt("gesturepassword_unlock_failed_time" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void setGestureUnlockFailedType(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setGestureUnlockFailedType.type=" + paramInt);
    }
    paramContext = a(paramContext).edit();
    paramContext.putInt("gesturepassword_unlock_failed_type", paramInt);
    paramContext.commit();
  }
  
  public static void setUinForPlugin(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.gesturelock.util", 2, "setUinForPlugin.uin=" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramContext = a(paramContext).edit();
    paramContext.putString("gesturepassword_currentuin_forplugin", paramString);
    paramContext.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\gesturelock\GesturePWDUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */