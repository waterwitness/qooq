package com.tencent.mobileqq.app;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.UEC;
import mqq.app.Constants.LogoutReason;

public abstract class Frame
{
  private View jdField_a_of_type_AndroidViewView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  protected boolean i;
  
  public Frame()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void A_() {}
  
  public ContentResolver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getContentResolver();
  }
  
  public Resources a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return null;
  }
  
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public Object a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService(paramString);
  }
  
  protected String a()
  {
    return null;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt);
  }
  
  public String a(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt, new Object[] { paramString });
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramIntent);
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.post(paramRunnable);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean)
  {
    this.i = true;
    if (Build.VERSION.SDK_INT >= 15)
    {
      UEC localUEC = UEC.a;
      if (localUEC != null) {
        localUEC.a(getClass().getSimpleName(), a(), false);
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(paramRunnable);
  }
  
  public abstract void c();
  
  void c(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public boolean c()
  {
    if (FrameHelperActivity.a())
    {
      FrameHelperActivity.n();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
  }
  
  public void e()
  {
    this.i = false;
    if (Build.VERSION.SDK_INT >= 15)
    {
      UEC localUEC = UEC.a;
      if (localUEC != null) {
        localUEC.a(getClass().getSimpleName(), a(), true);
      }
    }
  }
  
  public void f() {}
  
  protected void g() {}
  
  public void h() {}
  
  public void l()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_AndroidViewView.getAnimation();
      if (localObject != null) {
        ((Animation)localObject).setAnimationListener(null);
      }
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
    Object localObject = FrameHelperActivity.a(a());
    if (localObject != null) {
      ((FrameHelperActivity)localObject).p();
    }
  }
  
  public void w()
  {
    if (this.i) {
      e();
    }
  }
  
  protected void x() {}
  
  public void y()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void z_()
  {
    g();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */