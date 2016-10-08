package com.tencent.widget.immersive;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.Window;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class SystemBarCompact
{
  public int a;
  public Drawable a;
  private Window jdField_a_of_type_AndroidViewWindow;
  private SystemBarTintManager jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager;
  public boolean a;
  private int b;
  public boolean b;
  public boolean c;
  
  public SystemBarCompact(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewWindow = paramActivity.getWindow();
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public SystemBarCompact(Dialog paramDialog, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewWindow = paramDialog.getWindow();
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager == null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager = new SystemBarTintManager(this.jdField_a_of_type_AndroidViewWindow, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager.b(paramDrawable);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (ImmersiveUtils.a())
    {
      if (!ThemeUtil.isDefaultOrDIYTheme()) {
        paramBoolean = false;
      }
      ImmersiveUtils.a(this.jdField_a_of_type_AndroidViewWindow, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("status", 2, "setgetStatusBarVisible=" + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager.a(paramBoolean, paramInt);
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != paramInt))
    {
      this.jdField_a_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager.c(paramInt);
      }
    }
  }
  
  public void init()
  {
    if (this.c) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("systembar", 2, "mChatBarComp init()");
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      a();
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarTintManager.a(this.jdField_a_of_type_Boolean);
    }
    b(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_Boolean = true;
    this.c = true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\widget\immersive\SystemBarCompact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */