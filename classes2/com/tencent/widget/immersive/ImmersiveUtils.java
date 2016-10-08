package com.tencent.widget.immersive;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ImmersiveUtils
{
  private static float a;
  public static int a;
  public static String a;
  public static boolean a;
  public static int b;
  public static boolean b;
  public static int c;
  private static int d;
  private static int e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "ImmersiveUtils";
    jdField_a_of_type_Float = -1.0F;
    d = -1;
    e = -1;
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Int = 67108864;
    c = -1;
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    if (str.equalsIgnoreCase("smartisan-sm705")) {
      jdField_b_of_type_Boolean = true;
    }
    if (str.equalsIgnoreCase("Xiaomi-MI NOTE Pro")) {
      jdField_b_of_type_Boolean = true;
    }
    if (str.equalsIgnoreCase("vivo-vivo Y35A")) {
      jdField_b_of_type_Boolean = true;
    }
  }
  
  public static float a()
  {
    return jdField_a_of_type_Float;
  }
  
  public static int a()
  {
    return d;
  }
  
  public static int a(float paramFloat)
  {
    return Math.round(a() * paramFloat);
  }
  
  public static int a(Context paramContext)
  {
    float f2 = 1.0F;
    int i = 0;
    if (c != -1) {
      i = c;
    }
    int j;
    while (jdField_b_of_type_Boolean)
    {
      j = i;
      return j;
      Resources localResources = paramContext.getResources();
      j = localResources.getIdentifier("status_bar_height", "dimen", "android");
      if (j > 0) {
        i = localResources.getDimensionPixelSize(j);
      }
      c = i;
    }
    if (QLog.isColorLevel()) {
      QLog.d("systembar", 2, "getStatusBarHeight org=" + i);
    }
    float f1 = FontSettingManager.a.density / paramContext.getResources().getDisplayMetrics().density;
    if (i <= 0)
    {
      if (f1 <= 0.0F) {
        f1 = 1.0F;
      }
      for (;;)
      {
        i = a(f1 * 25.0F);
        j = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("systembar", 2, "getStatusBarHeight return result=" + i);
        return i;
      }
    }
    float f3 = i;
    if (f1 <= 0.0F) {
      f1 = f2;
    }
    for (;;)
    {
      i = (int)Math.ceil(f3 * f1 + 0.5F);
      break;
    }
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_Float == -1.0F)
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      jdField_a_of_type_Float = paramContext.density;
      if (paramContext.widthPixels < paramContext.heightPixels)
      {
        d = paramContext.widthPixels;
        e = paramContext.heightPixels;
      }
    }
    else
    {
      return;
    }
    e = paramContext.widthPixels;
    d = paramContext.heightPixels;
  }
  
  public static void a(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setAlpha(paramFloat);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      paramView.setFitsSystemWindows(paramBoolean);
      paramView.setPadding(0, a(paramView.getContext()), 0, 0);
    }
  }
  
  public static boolean a()
  {
    return (VersionUtils.h()) && ((SystemUtil.b()) || (SystemUtil.c()));
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    if (!VersionUtils.h()) {}
    do
    {
      return false;
      if (SystemUtil.b()) {
        return b(paramWindow, paramBoolean);
      }
    } while (!SystemUtil.c());
    return c(paramWindow, paramBoolean);
  }
  
  public static int b()
  {
    return e;
  }
  
  public static int b(float paramFloat)
  {
    return Math.round(paramFloat / a());
  }
  
  private static boolean b(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null)
    {
      Object localObject = paramWindow.getClass();
      try
      {
        Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int j = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
        localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
        if (paramBoolean) {}
        for (int i = j;; i = 0)
        {
          ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          return true;
        }
        return false;
      }
      catch (Exception paramWindow)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "setStatusBarDarkModeForMIUI: failed");
        }
      }
    }
  }
  
  private static boolean c(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null) {
      try
      {
        WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
        Field localField1 = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
        Field localField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
        localField1.setAccessible(true);
        localField2.setAccessible(true);
        int i = localField1.getInt(null);
        int j = localField2.getInt(localLayoutParams);
        if (paramBoolean) {
          i |= j;
        }
        for (;;)
        {
          localField2.setInt(localLayoutParams, i);
          paramWindow.setAttributes(localLayoutParams);
          return true;
          i = (i ^ 0xFFFFFFFF) & j;
        }
        return false;
      }
      catch (Exception paramWindow)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "setStatusBarDarkModeForFlyme: failed");
        }
      }
    }
  }
  
  public static int isSupporImmersive()
  {
    if (jdField_a_of_type_Int != -1) {
      return jdField_a_of_type_Int;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      jdField_a_of_type_Int = 0;
      return jdField_a_of_type_Int;
    }
    String str1 = Build.MANUFACTURER.toUpperCase();
    String str2 = str1 + "-" + Build.MODEL;
    if ((str1.endsWith("BBK")) || ((str1.endsWith("VIVO")) && (Build.VERSION.SDK_INT < 20)) || (str2.equals("OPPO-3007"))) {}
    for (jdField_a_of_type_Int = 0;; jdField_a_of_type_Int = 1) {
      return jdField_a_of_type_Int;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\immersive\ImmersiveUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */