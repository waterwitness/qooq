package com.tencent.mobileqq.dating;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import rcw;
import rcx;
import rcy;
import rcz;
import rda;

public class DatingBaseActivity
  extends NearbyTitleBarActivity
{
  public static final int a = 4097;
  public static final String a = "abp_flag";
  public static final boolean a;
  public static final String b = "is_from_web";
  public Dialog a;
  protected QQProgressNotifier a;
  protected int b;
  public boolean b;
  public boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = AppSetting.j;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    a(paramAppInterface, paramString, "", "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    a(paramAppInterface, paramString1, paramString2, "", "", "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ThreadManager.a(new rda(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5), 5, null, true);
  }
  
  public static void b(NearbyAppInterface paramNearbyAppInterface, Activity paramActivity, int paramInt, String paramString) {}
  
  public void a(int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), getString(paramInt), 0).b(this.jdField_b_of_type_Int);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(this.jdField_b_of_type_Int);
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(paramInt1, paramString, paramInt2);
    }
  }
  
  protected void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (paramOnDismissListener == null) {}
    do
    {
      return;
      b("0X800500D");
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 2131371851, 0, 2131367263, null, new rcz(this));
      }
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(paramOnDismissListener);
    } while (isFinishing());
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a(NearbyAppInterface paramNearbyAppInterface, Activity paramActivity, int paramInt, String paramString)
  {
    DatingManager localDatingManager = (DatingManager)paramNearbyAppInterface.getManager(212);
    if (localDatingManager.a())
    {
      if (!TextUtils.isEmpty(localDatingManager.c())) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(paramActivity, 2131371758, 2131367262, 2131367263, new rcw(this), new rcx(this, paramNearbyAppInterface, paramActivity, paramInt, paramString));
        if (this.jdField_a_of_type_AndroidAppDialog != null) {
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        return;
      }
      b(paramNearbyAppInterface, paramActivity, paramInt, paramString);
      return;
    }
    c();
  }
  
  public void a(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).b(this.jdField_b_of_type_Int);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramString1, paramString2, "", "", "");
  }
  
  protected void a(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean) {
      if (!this.rightViewText.isEnabled())
      {
        localDrawable = this.rightViewText.getBackground();
        if (localDrawable != null) {
          localDrawable.setAlpha(255);
        }
        this.rightViewText.setEnabled(true);
      }
    }
    do
    {
      do
      {
        return;
      } while (!this.rightViewText.isEnabled());
      this.rightViewText.setEnabled(false);
      localDrawable = this.rightViewText.getBackground();
    } while (localDrawable == null);
    localDrawable.setAlpha(102);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  public void b(String paramString)
  {
    a(this.jdField_b_of_type_ComTencentMobileqqNearbyNearbyAppInterface, paramString, "", "", "", "");
  }
  
  protected void c()
  {
    a(new rcy(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_Int = getTitleBarHeight();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("abp_flag", false);
    this.c = getIntent().getBooleanExtra("is_from_web", false);
    if ((this.c) && (!this.jdField_b_of_type_Boolean)) {
      setLeftViewName(2131366637);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_b_of_type_Boolean) {
      overridePendingTransition(2130968587, 2130968588);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */