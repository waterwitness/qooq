package com.tencent.mobileqq.widget;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import wnz;

public class QQToast
{
  public static final int a = -1;
  private static Class jdField_a_of_type_JavaLangClass;
  public static final String a = "QQToast";
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  public static final int b = 0;
  private static final String b = "checkOpNoThrow";
  public static final int c = 1;
  private static final String c = "OP_POST_NOTIFICATION";
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  private static int i = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private int j = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQToast(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static int a()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 19) {
        return 2;
      }
      AppOpsManager localAppOpsManager = (AppOpsManager)BaseApplicationImpl.a.getSystemService("appops");
      ApplicationInfo localApplicationInfo = BaseApplicationImpl.a.getApplicationInfo();
      String str = BaseApplicationImpl.a.getApplicationContext().getPackageName();
      int k = localApplicationInfo.uid;
      if (jdField_a_of_type_JavaLangClass == null) {
        jdField_a_of_type_JavaLangClass = Class.forName(AppOpsManager.class.getName());
      }
      if (jdField_a_of_type_JavaLangReflectMethod == null) {
        jdField_a_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
      }
      if (jdField_a_of_type_JavaLangReflectField == null) {
        jdField_a_of_type_JavaLangReflectField = jdField_a_of_type_JavaLangClass.getDeclaredField("OP_POST_NOTIFICATION");
      }
      int m = ((Integer)jdField_a_of_type_JavaLangReflectField.get(Integer.class)).intValue();
      k = ((Integer)jdField_a_of_type_JavaLangReflectMethod.invoke(localAppOpsManager, new Object[] { Integer.valueOf(m), Integer.valueOf(k), str })).intValue();
      if (k == 0) {}
      for (k = 1; k != 0; k = 0) {
        return 1;
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, " isNotificationEnabled, get except, " + localThrowable.getMessage());
      }
    }
    return 2;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 2130838200;
    case 2: 
      return 2130842940;
    case 4: 
      return 2130842072;
    case 5: 
      return 2130842074;
    case 6: 
      return 2130838204;
    }
    return 2130842073;
  }
  
  public static QQToast a(Context paramContext, int paramInt1, int paramInt2)
  {
    return a(paramContext, 0, paramInt1, paramInt2);
  }
  
  public static QQToast a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = new QQToast(paramContext);
    paramContext.a(a(paramInt1));
    paramContext.b(paramInt2);
    paramContext.c(paramInt3);
    return paramContext;
  }
  
  public static QQToast a(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    paramContext = new QQToast(paramContext);
    paramContext.a(a(paramInt1));
    paramContext.a(paramCharSequence);
    paramContext.c(paramInt2);
    return paramContext;
  }
  
  public static QQToast a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    return a(paramContext, 0, paramCharSequence, paramInt);
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return false;
      if ((i == -1) || (paramBoolean))
      {
        i = a();
        if (QLog.isColorLevel()) {
          QLog.d("QQToast", 2, "canUseCustomToast = " + i);
        }
      }
    } while (i == 1);
    return true;
  }
  
  public static boolean b()
  {
    return Build.BOARD.contains("mx2");
  }
  
  public Toast a()
  {
    if (b())
    {
      localToast = a(b());
      localToast.show();
      return localToast;
    }
    Toast localToast = a(0);
    localToast.show();
    return localToast;
  }
  
  public Toast a(int paramInt)
  {
    return a(paramInt, 2130903425);
  }
  
  public Toast a(int paramInt1, int paramInt2)
  {
    wnz localwnz = new wnz(this.jdField_a_of_type_AndroidContentContext);
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt2, null);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      ((ImageView)localView.findViewById(2131297872)).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        ((TextView)localView.findViewById(2131297873)).setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      localwnz.setGravity(55, 0, paramInt1);
      localwnz.setView(localView);
      localwnz.setDuration(this.j);
      return localwnz;
      ((ImageView)localView.findViewById(2131297872)).setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt));
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int b()
  {
    try
    {
      int k = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return k;
    }
    catch (Exception localException) {}
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public Toast b(int paramInt)
  {
    Toast localToast = a(paramInt);
    localToast.show();
    return localToast;
  }
  
  public void b(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
  }
  
  public void c(int paramInt)
  {
    this.j = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\widget\QQToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */