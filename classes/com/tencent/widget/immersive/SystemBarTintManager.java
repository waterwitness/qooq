package com.tencent.widget.immersive;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;

public class SystemBarTintManager
  implements Handler.Callback
{
  public static final int a = 255;
  private static String jdField_a_of_type_JavaLangString;
  public static final int b = 0;
  private static final String b = "navigation_bar_height";
  public static boolean b = false;
  public static final int c = 1;
  private static final String jdField_c_of_type_JavaLangString = "navigation_bar_height_landscape";
  private static int jdField_d_of_type_Int = 0;
  private static final String jdField_d_of_type_JavaLangString = "navigation_bar_width";
  private static final String e = "config_showNavigationBar";
  public Handler a;
  public View a;
  private final SystemBarTintManager.SystemBarConfig jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager$SystemBarConfig;
  public boolean a;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (VersionUtils.h()) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      jdField_a_of_type_JavaLangString = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      d = -1;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        jdField_a_of_type_JavaLangString = null;
      }
    }
  }
  
  public SystemBarTintManager(Window paramWindow, boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)paramWindow.getDecorView();
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.c = paramBoolean;
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager$SystemBarConfig = new SystemBarTintManager.SystemBarConfig(paramWindow, this.c, null);
    if (this.c) {
      a(paramWindow, localViewGroup);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    if (paramWindow.getContext().getResources().getConfiguration().orientation == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b = paramBoolean;
      return;
    }
  }
  
  public static int a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = 0;
    if (Build.VERSION.SDK_INT >= 14) {
      if (!b) {
        break label32;
      }
    }
    label32:
    for (paramContext = "navigation_bar_height";; paramContext = "navigation_bar_height_landscape")
    {
      i = a(localResources, paramContext);
      return i;
    }
  }
  
  private static int a(Resources paramResources, String paramString)
  {
    int i = 0;
    int j = paramResources.getIdentifier(paramString, "dimen", "android");
    if (j > 0) {
      i = paramResources.getDimensionPixelSize(j);
    }
    return i;
  }
  
  private void a(Window paramWindow, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = new View(paramWindow.getContext());
    paramWindow = new FrameLayout.LayoutParams(-1, this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager$SystemBarConfig.a());
    paramWindow.gravity = 48;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramWindow);
    try
    {
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Exception paramWindow)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("setupStatusBarView", 2, paramWindow.toString());
        }
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (d != -1) {
      return d == 1;
    }
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool;
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if ("1".equals(jdField_a_of_type_JavaLangString)) {
        bool = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "hasNavbar=" + bool);
      }
      if (bool) {}
      for (d = 1;; d = 0)
      {
        return bool;
        if (!"0".equals(jdField_a_of_type_JavaLangString)) {
          break;
        }
        bool = true;
        break;
        if (Build.VERSION.SDK_INT < 14) {
          break label149;
        }
        if (!ViewConfiguration.get(paramContext).hasPermanentMenuKey())
        {
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      label149:
      bool = false;
    }
  }
  
  public SystemBarTintManager.SystemBarConfig a()
  {
    return this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager$SystemBarConfig;
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    c(paramInt);
  }
  
  public void a(Drawable paramDrawable)
  {
    b(paramDrawable);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemBarTintManager", 2, "setStatusBarTintEnabled enabled = " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    View localView;
    if (this.c)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label62;
      }
    }
    label62:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "setStatusBarVisible=" + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, paramInt);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramInt);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(float paramFloat)
  {
    if ((this.c) && (Build.VERSION.SDK_INT >= 11))
    {
      this.jdField_a_of_type_AndroidViewView.setAlpha(paramFloat);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
  
  public void b(int paramInt)
  {
    d(paramInt);
  }
  
  public void b(Drawable paramDrawable)
  {
    if (this.c) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.c) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramInt);
    }
  }
  
  public void d(int paramInt)
  {
    if (this.c) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(paramInt);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "SystemBarTintManager=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return false;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\immersive\SystemBarTintManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */