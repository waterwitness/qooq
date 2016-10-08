package com.tencent.av.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoConstants;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import hbz;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Locale;

public class UITools
{
  public static MediaPlayer.OnCompletionListener a;
  static TraeAudioSession a;
  public static final String a = "UITools";
  public static boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
  }
  
  public static float a()
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (!MobileIssueSettings.f) {
      KapalaiAdapterUtil.a().a(localLayoutParams);
    }
    for (;;)
    {
      return localLayoutParams.screenBrightness;
      localLayoutParams.screenBrightness = 0.034F;
    }
  }
  
  public static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static float a(Context paramContext, float paramFloat)
  {
    return paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 3;
    case 3000: 
      return 2;
    case 1: 
      return 1;
    }
    return 7;
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static Bitmap a(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      do
      {
        return null;
        paramActivity = paramActivity.getWindow().getDecorView();
      } while (paramActivity == null);
      paramActivity.setDrawingCacheEnabled(true);
      paramActivity.buildDrawingCache(true);
      localBitmap = paramActivity.getDrawingCache();
    } while (localBitmap == null);
    Bitmap localBitmap = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight());
    paramActivity.destroyDrawingCache();
    return localBitmap;
  }
  
  public static Bitmap a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = ((BitmapDrawable)paramContext.getResources().getDrawable(paramInt)).getBitmap();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "getBitmapFromResourceId", paramContext);
      }
      return null;
    }
    catch (OutOfMemoryError paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "getBitmapFromResourceId", paramContext);
      }
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, Context paramContext, int paramInt, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("blur", 2, "width = " + paramBitmap.getWidth() + " # height = " + paramBitmap.getHeight());
    }
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      i = a(paramContext);
      j = b(paramContext);
      k = i * paramBitmap.getHeight() / j;
      j = (paramBitmap.getWidth() - k) / 2;
      i = j;
      if (j < 0) {
        i = 0;
      }
      paramContext = Bitmap.createBitmap(paramBitmap, i, 0, k, paramBitmap.getHeight());
      paramBitmap = Bitmap.createScaledBitmap(paramContext, paramContext.getWidth() / 2, paramContext.getHeight() / 2, false);
      paramContext.recycle();
      if (QLog.isColorLevel()) {
        QLog.d("blur", 2, "isMutable = " + paramBitmap.isMutable());
      }
      if (paramInt >= 1) {
        break label202;
      }
      paramContext = null;
    }
    label202:
    do
    {
      return paramContext;
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2, false);
      break;
      int i12 = paramBitmap.getWidth();
      int i13 = paramBitmap.getHeight();
      paramContext = new int[i12 * i13];
      paramBitmap.getPixels(paramContext, 0, i12, 0, 0, i12, i13);
      int i11 = i12 - 1;
      int i14 = i13 - 1;
      i = i12 * i13;
      int i15 = paramInt + paramInt + 1;
      int[] arrayOfInt1 = new int[i];
      int[] arrayOfInt2 = new int[i];
      int[] arrayOfInt3 = new int[i];
      int[] arrayOfInt4 = new int[Math.max(i12, i13)];
      i = i15 + 1 >> 1;
      j = i * i;
      int[] arrayOfInt5 = new int[j * 256];
      i = 0;
      while (i < j * 256)
      {
        arrayOfInt5[i] = (i / j);
        i += 1;
      }
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i15, 3 });
      int i16 = paramInt + 1;
      int i7 = 0;
      i = 0;
      int i6 = 0;
      int i8;
      int m;
      int n;
      int i1;
      int i2;
      int i3;
      int i4;
      int i5;
      int i9;
      int[] arrayOfInt6;
      int i10;
      int i17;
      while (i6 < i13)
      {
        j = 0;
        i8 = -paramInt;
        m = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        k = 0;
        if (i8 <= paramInt)
        {
          i9 = paramContext[(Math.min(i11, Math.max(i8, 0)) + i)];
          arrayOfInt6 = arrayOfInt[(i8 + paramInt)];
          arrayOfInt6[0] = ((0xFF0000 & i9) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i9) >> 8);
          arrayOfInt6[2] = (i9 & 0xFF);
          i9 = i16 - Math.abs(i8);
          i5 += arrayOfInt6[0] * i9;
          i4 += arrayOfInt6[1] * i9;
          i3 += i9 * arrayOfInt6[2];
          if (i8 > 0)
          {
            m += arrayOfInt6[0];
            k += arrayOfInt6[1];
            j += arrayOfInt6[2];
          }
          for (;;)
          {
            i8 += 1;
            break;
            i2 += arrayOfInt6[0];
            i1 += arrayOfInt6[1];
            n += arrayOfInt6[2];
          }
        }
        i8 = i4;
        i10 = 0;
        i4 = paramInt;
        i9 = i5;
        i5 = i3;
        i3 = i10;
        while (i3 < i12)
        {
          arrayOfInt1[i] = arrayOfInt5[i9];
          arrayOfInt2[i] = arrayOfInt5[i8];
          arrayOfInt3[i] = arrayOfInt5[i5];
          arrayOfInt6 = arrayOfInt[((i4 - paramInt + i15) % i15)];
          int i18 = arrayOfInt6[0];
          i17 = arrayOfInt6[1];
          i10 = arrayOfInt6[2];
          if (i6 == 0) {
            arrayOfInt4[i3] = Math.min(i3 + paramInt + 1, i11);
          }
          int i19 = paramContext[(arrayOfInt4[i3] + i7)];
          arrayOfInt6[0] = ((0xFF0000 & i19) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i19) >> 8);
          arrayOfInt6[2] = (i19 & 0xFF);
          m += arrayOfInt6[0];
          k += arrayOfInt6[1];
          j += arrayOfInt6[2];
          i9 = i9 - i2 + m;
          i8 = i8 - i1 + k;
          i5 = i5 - n + j;
          i4 = (i4 + 1) % i15;
          arrayOfInt6 = arrayOfInt[(i4 % i15)];
          i2 = i2 - i18 + arrayOfInt6[0];
          i1 = i1 - i17 + arrayOfInt6[1];
          n = n - i10 + arrayOfInt6[2];
          m -= arrayOfInt6[0];
          k -= arrayOfInt6[1];
          j -= arrayOfInt6[2];
          i += 1;
          i3 += 1;
        }
        i7 += i12;
        i6 += 1;
      }
      i = 0;
      while (i < i12)
      {
        i5 = 0;
        i7 = -paramInt * i12;
        i6 = -paramInt;
        i3 = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        j = 0;
        m = 0;
        k = 0;
        i4 = 0;
        if (i6 <= paramInt)
        {
          i8 = Math.max(0, i7) + i;
          arrayOfInt6 = arrayOfInt[(i6 + paramInt)];
          arrayOfInt6[0] = arrayOfInt1[i8];
          arrayOfInt6[1] = arrayOfInt2[i8];
          arrayOfInt6[2] = arrayOfInt3[i8];
          i9 = i16 - Math.abs(i6);
          i10 = arrayOfInt1[i8];
          i11 = arrayOfInt2[i8];
          i17 = arrayOfInt3[i8];
          if (i6 > 0)
          {
            i3 += arrayOfInt6[0];
            i4 += arrayOfInt6[1];
            i5 += arrayOfInt6[2];
          }
          for (;;)
          {
            i8 = i7;
            if (i6 < i14) {
              i8 = i7 + i12;
            }
            i6 += 1;
            j = i17 * i9 + j;
            m = i11 * i9 + m;
            k = i10 * i9 + k;
            i7 = i8;
            break;
            i2 += arrayOfInt6[0];
            i1 += arrayOfInt6[1];
            n += arrayOfInt6[2];
          }
        }
        i9 = m;
        i10 = k;
        i11 = 0;
        k = i;
        i6 = i5;
        i7 = i4;
        i8 = i3;
        m = n;
        n = i1;
        i1 = i2;
        i2 = paramInt;
        i5 = i10;
        i4 = i9;
        i3 = j;
        j = i11;
        while (j < i13)
        {
          paramContext[k] = (0xFF000000 & paramContext[k] | arrayOfInt5[i5] << 16 | arrayOfInt5[i4] << 8 | arrayOfInt5[i3]);
          arrayOfInt6 = arrayOfInt[((i2 - paramInt + i15) % i15)];
          i11 = arrayOfInt6[0];
          i10 = arrayOfInt6[1];
          i9 = arrayOfInt6[2];
          if (i == 0) {
            arrayOfInt4[j] = (Math.min(j + i16, i14) * i12);
          }
          i17 = arrayOfInt4[j] + i;
          arrayOfInt6[0] = arrayOfInt1[i17];
          arrayOfInt6[1] = arrayOfInt2[i17];
          arrayOfInt6[2] = arrayOfInt3[i17];
          i8 += arrayOfInt6[0];
          i7 += arrayOfInt6[1];
          i6 += arrayOfInt6[2];
          i5 = i5 - i1 + i8;
          i4 = i4 - n + i7;
          i3 = i3 - m + i6;
          i2 = (i2 + 1) % i15;
          arrayOfInt6 = arrayOfInt[i2];
          i1 = i1 - i11 + arrayOfInt6[0];
          n = n - i10 + arrayOfInt6[1];
          m = m - i9 + arrayOfInt6[2];
          i8 -= arrayOfInt6[0];
          i7 -= arrayOfInt6[1];
          i6 -= arrayOfInt6[2];
          k += i12;
          j += 1;
        }
        i += 1;
      }
      paramBitmap.setPixels(paramContext, 0, i12, 0, 0, i12, i13);
      paramContext = paramBitmap;
    } while (!QLog.isColorLevel());
    QLog.d("blur", 2, "blur time = " + (System.currentTimeMillis() - l) + "ms");
    return paramBitmap;
  }
  
  public static String a(long paramLong)
  {
    String str = "00:00";
    long l1;
    long l2;
    if (paramLong > 0L)
    {
      l1 = paramLong % 60L;
      l2 = paramLong / 60L;
      paramLong = l2 / 60L;
      l2 %= 60L;
      if (paramLong > 0L) {
        str = String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l2), Long.valueOf(l1) });
      }
    }
    else
    {
      return str;
    }
    return String.format(Locale.CHINA, "%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
  }
  
  public static String a(Context paramContext, String paramString, TextView paramTextView, float paramFloat)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    paramTextView = paramString;
    if (paramFloat > 0.0F)
    {
      float f1 = localTextPaint.measureText(paramString);
      paramTextView = paramString;
      if (f1 > paramFloat)
      {
        float f2 = paramFloat - localTextPaint.measureText("...");
        paramFloat = f1;
        paramContext = paramString;
        while ((f2 > 0.0F) && (paramFloat > f2) && (paramContext.length() > 0))
        {
          paramTextView = paramContext.substring(0, paramContext.length() - 1);
          f1 = localTextPaint.measureText(paramTextView);
          paramContext = paramTextView;
          paramFloat = f1;
          if (f1 == 0.0F)
          {
            paramContext = paramTextView;
            paramFloat = f1;
            if (paramTextView.length() > 0)
            {
              paramFloat = 1.0F + f2;
              paramContext = paramTextView;
            }
          }
        }
        paramTextView = paramString;
        if (f2 > 0.0F)
        {
          paramTextView = paramString;
          if (paramContext.length() > 0) {
            paramTextView = paramContext + "...";
          }
        }
      }
    }
    return paramTextView;
  }
  
  public static String a(String paramString)
  {
    int j = 0;
    String str = "已进行通话时长,";
    String[] arrayOfString = paramString.split(":");
    int k;
    int i;
    if (arrayOfString.length == 3)
    {
      k = Integer.valueOf(arrayOfString[0]).intValue();
      j = Integer.valueOf(arrayOfString[1]).intValue();
      i = Integer.valueOf(arrayOfString[2]).intValue();
    }
    for (;;)
    {
      if ((k > 0) || (j > 0) || (i > 0))
      {
        if (k > 0) {
          str = "已进行通话时长," + k + "小时,";
        }
        paramString = str;
        if (j > 0) {
          paramString = str + j + "分,";
        }
        str = paramString;
        if (i > 0) {
          str = paramString + i + "秒";
        }
        return str;
        if (arrayOfString.length == 2)
        {
          j = Integer.valueOf(arrayOfString[0]).intValue();
          i = Integer.valueOf(arrayOfString[1]).intValue();
          k = 0;
        }
      }
      else
      {
        return "已进行通话时长," + paramString;
      }
      i = 0;
      k = 0;
    }
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
      {
        jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
        jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("UITools", 2, "uninitTrae", localException);
    }
  }
  
  public static void a(Activity paramActivity, float paramFloat)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      paramActivity = paramActivity.getWindow();
    } while (paramActivity == null);
    WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    paramActivity.setAttributes(localLayoutParams);
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession(paramContext, new hbz());
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    if (jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UITools", 2, "SetAccText: " + paramString);
      }
      if (paramView != null) {}
    }
    else
    {
      return;
    }
    paramView.setFocusable(true);
    paramView.setContentDescription(paramString);
  }
  
  public static void a(View paramView, String paramString, int paramInt)
  {
    if (jdField_a_of_type_Boolean)
    {
      String str = paramString;
      if (paramInt == 2) {
        str = paramString.replace("QQ电话", "群视频");
      }
      if (QLog.isColorLevel()) {
        QLog.i("UITools", 2, "SetAccText with avtype:" + str + " avtype:" + paramInt);
      }
      paramView.setFocusable(true);
      paramView.setContentDescription(str);
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = paramVideoAppInterface.a().getSharedPreferences(paramVideoAppInterface.a() + "qav_SP", 0).edit();
    paramVideoAppInterface.putBoolean("qav_EffectBtn_ShowTips", false);
    paramVideoAppInterface.commit();
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
    {
      jdField_a_of_type_ComTencentSharpJniTraeAudioSession.i();
      return;
    }
    AudioUtil.a();
  }
  
  public static void a(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if (arrayOfStackTraceElement == null) {
      if (QLog.isColorLevel()) {
        QLog.d(paramString, 2, "PrintBacktrace-->can npt het StackTrace");
      }
    }
    String str;
    do
    {
      return;
      str = new String();
      int i = 0;
      while (i < arrayOfStackTraceElement.length)
      {
        str = str + "STE[" + i + "]:" + arrayOfStackTraceElement[i].toString() + "\n";
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d(paramString, 2, str);
  }
  
  public static boolean a()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      if (Build.DEVICE.equals("mx2")) {
        return true;
      }
      if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9"))) {
        return false;
      }
    }
    return false;
  }
  
  static boolean a(Context paramContext)
  {
    if ((SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false)) && ((VideoConstants.b) || (!ReflectionUtil.a(BaseApplicationImpl.a))))
    {
      int i = Calendar.getInstance().get(11);
      if ((i >= 23) || (i < 8)) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (AudioHelper.b()) {
      return true;
    }
    return paramVideoAppInterface.a().getSharedPreferences(paramVideoAppInterface.a() + "qav_SP", 0).getBoolean("qav_EffectBtn_ShowTips", true);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if (a(paramVideoAppInterface))
    {
      AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
      return true;
    }
    return false;
  }
  
  static boolean a(AppInterface paramAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramAppInterface == null) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool2;
              SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.a);
              bool1 = bool2;
              if (paramAppInterface.a() != null)
              {
                String str = paramAppInterface.a();
                bool1 = bool2;
                if (str != null) {
                  bool1 = localSharedPreferences.getBoolean(paramAppInterface.a().getString(2131367787) + str, true);
                }
              }
              bool2 = bool1;
            } while (AudioUtil.a() == 0);
            bool2 = bool1;
          } while (!bool1);
          bool2 = bool1;
        } while (PhoneStatusTools.b(BaseApplicationImpl.a));
        bool2 = bool1;
      } while (PhoneStatusTools.d(BaseApplicationImpl.a));
      bool2 = bool1;
    } while (PhoneStatusTools.e(BaseApplicationImpl.a));
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    boolean bool;
    for (;;)
    {
      try
      {
        if ((!a(paramAppInterface)) || (!a(paramAppInterface.a().getApplicationContext()))) {
          break label185;
        }
        if (jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
          break label175;
        }
        jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
        if (paramInt1 == 0)
        {
          localObject = jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
          if (paramInt2 >= 0) {
            break label207;
          }
          bool = true;
          break label187;
          ((TraeAudioSession)localObject).a(2, paramInt1, null, paramString, bool, paramInt2, paramAppInterface);
          break label205;
        }
        if (paramInt1 == SoundAndVibrateActivity.e) {
          break;
        }
        paramString = jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
        if (paramInt2 >= 0) {
          break label123;
        }
        bool = true;
      }
      catch (Exception paramAppInterface)
      {
        label88:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("UITools", 2, paramAppInterface.toString());
        return false;
      }
      paramString.a(0, paramInt1, null, null, bool, paramInt2, paramAppInterface);
      break label205;
      label123:
      bool = false;
      break label223;
      label129:
      break label229;
      label132:
      paramAppInterface = "normal-ring";
    }
    paramString = jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
    Object localObject = Settings.System.DEFAULT_NOTIFICATION_URI;
    if (paramInt2 < 0) {
      bool = true;
    }
    for (;;)
    {
      paramString.a(1, -1, (Uri)localObject, null, bool, paramInt1, paramAppInterface);
      break label205;
      label175:
      AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
      break label205;
      label185:
      return false;
      label187:
      if (paramInt2 <= 0) {
        paramInt2 = 1;
      }
      for (;;)
      {
        if (paramOnCompletionListener == null) {
          break label216;
        }
        paramAppInterface = "comp-ring";
        break;
        label205:
        return true;
        label207:
        bool = false;
        break label187;
      }
      label216:
      paramAppInterface = "normal-ring";
      break;
      label223:
      if (paramInt2 > 0) {
        break label129;
      }
      paramInt2 = 1;
      label229:
      if (paramOnCompletionListener == null) {
        break label132;
      }
      paramAppInterface = "comp-ring";
      break label88;
      label241:
      if (paramInt2 <= 0) {}
      for (paramInt1 = 1;; paramInt1 = paramInt2)
      {
        if (paramOnCompletionListener == null) {
          break label270;
        }
        paramAppInterface = "comp-ring";
        break;
        bool = false;
        break label241;
      }
      label270:
      paramAppInterface = "normal-ring";
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    String str = paramString1;
    if (paramString1.startsWith("+")) {
      str = paramString1.substring(1);
    }
    paramString1 = paramString2;
    if (paramString2.startsWith("+")) {
      paramString1 = paramString2.substring(1);
    }
    return str.equals(paramString1);
  }
  
  public static float b(Context paramContext, float paramFloat)
  {
    return paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    default: 
      return -1;
    case 3: 
      return 0;
    case 2: 
      return 3000;
    case 1: 
      return 1;
    }
    return 1011;
  }
  
  public static int b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("qav_SP", 0);
      SharedPreferences.Editor localEditor = paramContext.edit();
      localEditor.putBoolean("qav_random_speakeron", false);
      localEditor.commit();
      if (QLog.isColorLevel()) {
        QLog.d("UITools", 2, "qav_random_speakeron:" + paramContext.getBoolean("qav_random_speakeron", false));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\UITools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */