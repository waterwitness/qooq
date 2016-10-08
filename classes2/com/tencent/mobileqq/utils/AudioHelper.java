package com.tencent.mobileqq.utils;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import mqq.app.MobileQQ;

public class AudioHelper
{
  public static final int a = 0;
  private static final long jdField_a_of_type_Long = 2000L;
  public static final String a = "tencent.video.q2v.config";
  private static boolean jdField_a_of_type_Boolean = false;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 35, 36 };
  private static AudioHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  public static final int b = 1;
  public static final String b = "tencent.video.q2v.debug";
  private static final int[] b = { 26, 27 };
  public static final int c = 2;
  private static final String c;
  public static final int d = 3;
  private static final String d = "!@$#_";
  public static final int e = 4;
  private static final String e = "appops";
  public static final int f = 0;
  private static final String f = "AppOpsManager";
  public static final int g = 1;
  public static int h = -1;
  public static int i = -1;
  private static int j = 0;
  private static final int k = 35;
  private static final int l = 36;
  private static final int m = 26;
  private static final int n = 27;
  private static final int o = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    c = AudioHelper.class.getSimpleName();
  }
  
  /* Error */
  public static long a(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 76	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Boolean	Z
    //   6: ifne +27 -> 33
    //   9: getstatic 78	com/tencent/mobileqq/utils/AudioHelper:j	I
    //   12: iconst_3
    //   13: if_icmpge +20 -> 33
    //   16: getstatic 78	com/tencent/mobileqq/utils/AudioHelper:j	I
    //   19: iconst_1
    //   20: iadd
    //   21: putstatic 78	com/tencent/mobileqq/utils/AudioHelper:j	I
    //   24: aload_0
    //   25: ldc 80
    //   27: invokestatic 86	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   30: putstatic 76	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Boolean	Z
    //   33: getstatic 76	com/tencent/mobileqq/utils/AudioHelper:jdField_a_of_type_Boolean	Z
    //   36: ifeq +17 -> 53
    //   39: aload_1
    //   40: iload_2
    //   41: fload_3
    //   42: invokestatic 90	com/tencent/mobileqq/utils/AudioHelper:enlargeVolum	([BIF)J
    //   45: lstore 4
    //   47: ldc 2
    //   49: monitorexit
    //   50: lload 4
    //   52: lreturn
    //   53: ldc2_w 9
    //   56: lstore 4
    //   58: goto -11 -> 47
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramContext	Context
    //   0	67	1	paramArrayOfByte	byte[]
    //   0	67	2	paramInt	int
    //   0	67	3	paramFloat	float
    //   45	12	4	l1	long
    // Exception table:
    //   from	to	target	type
    //   3	33	61	finally
    //   33	47	61	finally
  }
  
  public static AudioHelper.AudioPlayerParameter a()
  {
    if (d()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, true);
    }
    return new AudioHelper.AudioPlayerParameter(3, 0, true);
  }
  
  private static AudioHelper.AudioPlayerParameter a(int paramInt)
  {
    AudioHelper.AudioPlayerParameter localAudioPlayerParameter;
    if (paramInt == 0) {
      localAudioPlayerParameter = a();
    }
    for (;;)
    {
      String str = "!@$#_" + paramInt + "_";
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext());
      localAudioPlayerParameter.jdField_a_of_type_Int = localSharedPreferences.getInt(str + "m", localAudioPlayerParameter.jdField_a_of_type_Int);
      localAudioPlayerParameter.b = localSharedPreferences.getInt(str + "s", localAudioPlayerParameter.b);
      localAudioPlayerParameter.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean(str + "so", localAudioPlayerParameter.jdField_a_of_type_Boolean);
      return a(paramInt, localAudioPlayerParameter);
      if (paramInt == 1)
      {
        localAudioPlayerParameter = b();
      }
      else if (paramInt == 2)
      {
        localAudioPlayerParameter = a();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
      else if (paramInt == 3)
      {
        localAudioPlayerParameter = a();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
      else
      {
        localAudioPlayerParameter = c();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private static AudioHelper.AudioPlayerParameter a(int paramInt, AudioHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    paramAudioPlayerParameter = new AudioHelper.AudioPlayerParameter(paramAudioPlayerParameter.b, paramAudioPlayerParameter.jdField_a_of_type_Int, paramAudioPlayerParameter.jdField_a_of_type_Boolean);
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.qq_audio_play_fix.name(), null);
    if (QLog.isColorLevel()) {
      QLog.d(AudioHelper.class.getSimpleName(), 2, "getDPCFixConfig | dpcConfig = " + (String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 1)) {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (paramInt == 0)
        {
          if (!"-1".equals(localObject[0])) {
            paramAudioPlayerParameter.jdField_a_of_type_Int = Integer.parseInt(localObject[0]);
          }
          if (!"-1".equals(localObject[1]))
          {
            paramAudioPlayerParameter.b = Integer.parseInt(localObject[1]);
            return paramAudioPlayerParameter;
          }
        }
        else if (paramInt == 1)
        {
          if (!"-1".equals(localObject[2])) {
            paramAudioPlayerParameter.jdField_a_of_type_Int = Integer.parseInt(localObject[2]);
          }
          if (!"-1".equals(localObject[3]))
          {
            paramAudioPlayerParameter.b = Integer.parseInt(localObject[3]);
            return paramAudioPlayerParameter;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(AudioHelper.class.getSimpleName(), 2, "getDPCFixConfig error.", localException);
        }
      }
    }
    return paramAudioPlayerParameter;
  }
  
  public static void a(int paramInt, AudioHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    String str = "!@$#_" + paramInt + "_";
    PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext()).edit().putInt(str + "m", paramAudioPlayerParameter.jdField_a_of_type_Int).putInt(str + "s", paramAudioPlayerParameter.b).putBoolean(str + "so", paramAudioPlayerParameter.jdField_a_of_type_Boolean).commit();
  }
  
  private static void a(Resources paramResources, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTextView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "changButtonStyle button is null");
      }
      return;
    }
    if (paramInt1 != 0)
    {
      Drawable localDrawable = paramResources.getDrawable(paramInt1);
      TintStateDrawable localTintStateDrawable = TintStateDrawable.a(paramResources, paramInt1, paramInt2);
      localTintStateDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, localTintStateDrawable, null, null);
    }
    paramTextView.setTextColor(paramResources.getColorStateList(paramInt3));
  }
  
  public static void a(Resources paramResources, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      a(paramResources, paramTextView, paramInt, 2131428165, 2131428166);
      return;
    }
    a(paramResources, paramTextView, paramInt, 2131428157, 2131428158);
  }
  
  public static void a(BaseApplication paramBaseApplication)
  {
    Intent localIntent = new Intent("tencent.video.q2v.config");
    localIntent.putExtra("ptv_extra_config_changed", true);
    localIntent.setPackage(paramBaseApplication.getPackageName());
    paramBaseApplication.sendBroadcast(localIntent);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      h = i1;
      if (QLog.isDevelopLevel()) {}
      return;
    }
  }
  
  public static boolean a()
  {
    return (q()) || (p());
  }
  
  public static boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "SDK_INT: " + Build.VERSION.SDK_INT + " Man: " + Build.MANUFACTURER);
    }
    if ((!s()) || (Build.VERSION.SDK_INT < 17)) {}
    for (;;)
    {
      return false;
      Object localObject = BaseApplicationImpl.getContext().getSystemService("appops");
      if ((localObject != null) && (localObject.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = localObject.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i1 = b[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            i1 = jdField_a_of_type_ArrayOfInt[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)localMethod.invoke(localObject, new Object[] { Integer.valueOf(i1), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel()) {
            QLog.d(AudioHelper.class.getSimpleName(), 2, "isForbidByRubbishXiaomi(), result = " + paramInt);
          }
          if (paramInt != 0) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception localException) {}
      }
    }
    QLog.e(AudioHelper.class.getSimpleName(), 2, localException.toString());
    return false;
  }
  
  public static boolean a(int paramInt, Context paramContext)
  {
    if ((!r()) || (Build.VERSION.SDK_INT < 17)) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getSystemService("appops");
      if ((paramContext != null) && (paramContext.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Method localMethod = paramContext.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i1 = b[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            i1 = jdField_a_of_type_ArrayOfInt[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)localMethod.invoke(paramContext, new Object[] { Integer.valueOf(i1), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel()) {
            QLog.d(AudioHelper.class.getSimpleName(), 2, "isForbidByRubbishMeizu(), result = " + paramInt);
          }
          if (paramInt != 0) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception paramContext) {}
      }
    }
    QLog.e(AudioHelper.class.getSimpleName(), 2, paramContext.toString());
    return false;
  }
  
  public static boolean a(BluetoothDevice paramBluetoothDevice)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 15)
    {
      localObject = paramBluetoothDevice.getUuids();
      if (localObject != null) {
        break label19;
      }
    }
    for (;;)
    {
      return false;
      label19:
      paramBluetoothDevice = new ParcelUuid[2];
      paramBluetoothDevice[0] = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
      paramBluetoothDevice[1] = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
      localObject = new HashSet(Arrays.asList((Object[])localObject));
      int i2 = paramBluetoothDevice.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (((HashSet)localObject).contains(paramBluetoothDevice[i1])) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramContext.isBluetoothA2dpOn()) {
      return true;
    }
    if ((paramContext.isBluetoothScoOn()) || (AudioPlayer.a(paramContext))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isDevelopLevel()) {}
    return false;
  }
  
  public static AudioHelper.AudioPlayerParameter[] a()
  {
    try
    {
      if (jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter == null)
      {
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = new AudioHelper.AudioPlayerParameter[5];
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[0] = a(0);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[1] = a(1);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[2] = a(2);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[3] = a(3);
        jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[4] = a(4);
      }
      AudioHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
      return arrayOfAudioPlayerParameter;
    }
    finally {}
  }
  
  public static AudioHelper.AudioPlayerParameter b()
  {
    if (n()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (e()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (f()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (g()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (h()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (j()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (i()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (k()) {
      return new AudioHelper.AudioPlayerParameter(0, 2, false);
    }
    if (l()) {
      return new AudioHelper.AudioPlayerParameter(0, 2, false);
    }
    if (m()) {
      return new AudioHelper.AudioPlayerParameter(3, 3, false);
    }
    if (o()) {
      return new AudioHelper.AudioPlayerParameter(0, 0, false);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new AudioHelper.AudioPlayerParameter(0, 3, false);
    }
    return new AudioHelper.AudioPlayerParameter(0, 2, false);
  }
  
  public static void b(BaseApplication paramBaseApplication)
  {
    Intent localIntent = new Intent("tencent.video.q2v.debug");
    localIntent.putExtra("debugkeeptoolbar_flag", true);
    localIntent.putExtra("debugkeeptoolbar", c());
    localIntent.setPackage(paramBaseApplication.getPackageName());
    paramBaseApplication.sendBroadcast(localIntent);
  }
  
  public static void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      i = i1;
      if (QLog.isDevelopLevel()) {}
      return;
    }
  }
  
  public static boolean b()
  {
    if (QLog.isDevelopLevel()) {}
    return false;
  }
  
  public static boolean b(int paramInt)
  {
    return a(paramInt, BaseApplicationImpl.getContext());
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext.isBluetoothScoOn()) || (AudioPlayer.a(paramContext));
  }
  
  public static AudioHelper.AudioPlayerParameter c()
  {
    return new AudioHelper.AudioPlayerParameter(0, 2, true);
  }
  
  public static void c(BaseApplication paramBaseApplication)
  {
    Intent localIntent = new Intent("tencent.video.q2v.debug");
    localIntent.putExtra("debugmode_flag", true);
    localIntent.putExtra("debugmode", b());
    localIntent.setPackage(paramBaseApplication.getPackageName());
    paramBaseApplication.sendBroadcast(localIntent);
  }
  
  public static boolean c()
  {
    if (QLog.isDevelopLevel()) {}
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    return ((AudioManager)paramContext.getSystemService("audio")).isBluetoothScoOn();
  }
  
  private static boolean d()
  {
    String str = Build.MODEL;
    int i1;
    if (((Build.MANUFACTURER.equalsIgnoreCase("Samsung")) || (str.contains("MI 2")) || (str.contains("Nexus 4"))) && (Build.VERSION.SDK_INT >= 11))
    {
      i1 = 1;
      if (i1 == 0) {
        break label57;
      }
    }
    label57:
    while ((str.contains("SCH-I699")) && (Build.VERSION.SDK_INT == 10))
    {
      return true;
      i1 = 0;
      break;
    }
    return false;
  }
  
  private static boolean e()
  {
    return (Build.MODEL.contains("HUAWEI Y 200T")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  @Deprecated
  public static native long enlargeVolum(byte[] paramArrayOfByte, int paramInt, float paramFloat);
  
  private static boolean f()
  {
    return (Build.MODEL.contains("Lenovo A278t")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean g()
  {
    return (Build.MODEL.contains("ZTE-T U960s")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean h()
  {
    return Build.MODEL.contains("5910");
  }
  
  private static boolean i()
  {
    return Build.MODEL.contains("Lenovo K900");
  }
  
  private static boolean j()
  {
    return Build.MODEL.contains("V926");
  }
  
  private static boolean k()
  {
    return Build.MODEL.contains("ZTE N881E");
  }
  
  private static boolean l()
  {
    return Build.MODEL.contains("LNV-Lenovo S870e");
  }
  
  private static boolean m()
  {
    return Build.MODEL.contains("Coolpad 5891Q");
  }
  
  private static boolean n()
  {
    return (Build.MODEL.contains("ME860")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean o()
  {
    return Build.MODEL.contains("GT-S7500");
  }
  
  private static boolean p()
  {
    return Build.MODEL.contains("Lenovo A750");
  }
  
  private static boolean q()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (str.contains("X907"));
  }
  
  private static boolean r()
  {
    return "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static boolean s()
  {
    return "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\AudioHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */