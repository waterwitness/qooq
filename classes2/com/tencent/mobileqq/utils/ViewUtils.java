package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ViewUtils
{
  public static float a;
  public static int a;
  private static float jdField_b_of_type_Float;
  private static int jdField_b_of_type_Int = -1;
  private static float jdField_c_of_type_Float;
  private static int jdField_c_of_type_Int = -1;
  private static int d = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    jdField_a_of_type_Float = localDisplayMetrics.density;
    jdField_a_of_type_Int = localDisplayMetrics.densityDpi;
    jdField_c_of_type_Float = -1.0F;
  }
  
  public static float a()
  {
    if (jdField_c_of_type_Float < 0.0F) {
      jdField_c_of_type_Float = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
    return jdField_c_of_type_Float;
  }
  
  public static float a(float paramFloat)
  {
    if (jdField_b_of_type_Float == 0.0F) {
      jdField_b_of_type_Float = jdField_a_of_type_Int;
    }
    return jdField_b_of_type_Float * paramFloat / 160.0F;
  }
  
  public static int a()
  {
    if (jdField_c_of_type_Int < 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;; jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels) {
      return jdField_c_of_type_Int;
    }
  }
  
  public static int a(float paramFloat)
  {
    return (int)(jdField_a_of_type_Float * paramFloat + 0.5F);
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getResources();
    int j = paramContext.getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static int a(Paint paramPaint, CharSequence paramCharSequence)
  {
    int j = 0;
    int i = 0;
    int k = j;
    if (paramCharSequence != null)
    {
      k = j;
      if (paramCharSequence.length() > 0)
      {
        int m = paramCharSequence.length();
        float[] arrayOfFloat = new float[m];
        paramPaint.getTextWidths(paramCharSequence.toString(), arrayOfFloat);
        j = 0;
        for (;;)
        {
          k = i;
          if (j >= m) {
            break;
          }
          k = (int)Math.ceil(arrayOfFloat[j]);
          j += 1;
          i = k + i;
        }
      }
    }
    return k;
  }
  
  public static Point a(View paramView, ViewGroup paramViewGroup)
  {
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    paramView.getGlobalVisibleRect(localRect1);
    paramViewGroup.getGlobalVisibleRect(localRect2);
    return new Point(localRect1.left - localRect2.left, localRect1.top - localRect2.top);
  }
  
  public static String a(Paint paramPaint, String paramString, float paramFloat)
  {
    float f2 = 0.0F;
    int i = 0;
    if (paramPaint == null) {
      return paramString;
    }
    for (;;)
    {
      float[] arrayOfFloat;
      float f1;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        arrayOfFloat = new float[paramString.length()];
        paramPaint.getTextWidths(paramString, arrayOfFloat);
        f1 = 0.0F;
        if (i < arrayOfFloat.length)
        {
          f1 += arrayOfFloat[i];
          if (f1 <= paramFloat) {
            break label161;
          }
        }
        if (i == arrayOfFloat.length) {
          break;
        }
        f1 = paramPaint.measureText("...");
        if (i <= 0) {
          return "";
        }
        paramFloat = f2;
        j = i;
        if (i > 1) {
          break label170;
        }
        return paramString.substring(0, i);
      }
      catch (Throwable paramPaint) {}
      paramPaint = paramString.substring(0, i) + "...";
      return paramPaint;
      int j = i;
      if (i <= 0)
      {
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("getBreakString", 2, "getBreakString", paramPaint);
        return paramString;
        label161:
        i += 1;
        continue;
      }
      label170:
      i = j - 1;
      paramFloat += arrayOfFloat[i];
      if (paramFloat < f1) {}
    }
  }
  
  public static void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
    while (paramView.getBackground() == null) {
      return;
    }
    paramView.getBackground().setAlpha((int)(255.0F * paramFloat));
  }
  
  public static void a(View paramView, int paramInt)
  {
    if (paramView.getBackground() != null) {
      paramView.getBackground().setAlpha(paramInt);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        a(paramView.getChildAt(i), paramInt);
        i += 1;
      }
    }
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramDrawable);
      return;
    }
    paramView.setBackground(paramDrawable);
  }
  
  public static void a(View paramView1, View paramView2, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2)) {}
    label156:
    for (;;)
    {
      return;
      int i = 0;
      int j = 0;
      int k;
      int m;
      if (paramView1.getParent() != null)
      {
        j = paramView1.getLeft() + j;
        k = paramView1.getTop() + i;
        if (paramView1.getParent() == paramView2)
        {
          paramArrayOfInt[0] = j;
          paramArrayOfInt[1] = k;
          i = k;
          m = j;
          if (paramArrayOfInt.length >= 4)
          {
            paramArrayOfInt[2] = paramView1.getMeasuredWidth();
            paramArrayOfInt[3] = paramView1.getMeasuredHeight();
            m = j;
            i = k;
          }
        }
      }
      for (;;)
      {
        if (paramView2 != null) {
          break label156;
        }
        paramArrayOfInt[0] = m;
        paramArrayOfInt[1] = i;
        return;
        try
        {
          paramView1 = (View)paramView1.getParent();
          if (paramArrayOfInt.length >= 4)
          {
            paramArrayOfInt[2] = paramView1.getMeasuredWidth();
            paramArrayOfInt[3] = paramView1.getMeasuredHeight();
          }
          i = k;
        }
        catch (ClassCastException paramView1)
        {
          i = k;
          m = j;
        }
        continue;
        m = j;
      }
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      paramView.setEnabled(paramBoolean);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          a(paramView.getChildAt(i), paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    if ((paramView2 instanceof ViewGroup))
    {
      int j = ((ViewGroup)paramView2).getChildCount();
      int i = 0;
      while (i < j)
      {
        if (a(paramView1, ((ViewGroup)paramView2).getChildAt(i))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static float b()
  {
    if (jdField_b_of_type_Int < 0) {
      jdField_b_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    }
    return jdField_b_of_type_Int;
  }
  
  public static int b()
  {
    if (d < 0) {
      if (BaseApplication.getContext().getResources().getConfiguration().orientation != 2) {
        break label41;
      }
    }
    label41:
    for (d = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;; d = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels) {
      return d;
    }
  }
  
  public static int b(float paramFloat)
  {
    return Math.round(a() * paramFloat);
  }
  
  public static void b(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setScaleX(paramFloat);
  }
  
  public static int c(float paramFloat)
  {
    return Math.round(paramFloat / a());
  }
  
  public static void c(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setScaleY(paramFloat);
  }
  
  public static int d(float paramFloat)
  {
    return (int)(BaseApplication.getContext().getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public static void d(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setPivotX(paramFloat);
  }
  
  public static void e(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setPivotY(paramFloat);
  }
  
  public static void f(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setTranslationX(paramFloat);
  }
  
  public static void g(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setTranslationY(paramFloat);
  }
  
  public static void h(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT < 11) {
      return;
    }
    paramView.setRotation(paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */