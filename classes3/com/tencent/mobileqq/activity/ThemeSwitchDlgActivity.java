package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.NightModeLogic;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mov;

public class ThemeSwitchDlgActivity
  extends BaseActivity
{
  Dialog jdField_a_of_type_AndroidAppDialog;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  NightModeLogic jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic;
  boolean jdField_a_of_type_Boolean;
  
  public ThemeSwitchDlgActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "ThemeSwitchDlgActivity showThemeSettingDialog");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(getAppRuntime(), this);
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.a(new mov(this));
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.c();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Night_mode_us", 0, 0, "1", "", "", "");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic == null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(getAppRuntime(), this);
    }
    if ((paramBundle != null) && (paramBundle.getBooleanExtra("themedownloadalert", false)) && (!ThemeUtil.isInNightMode(getAppRuntime()))) {
      a(paramBundle.getStringExtra("themeID"));
    }
    for (;;)
    {
      if ((getAppRuntime() instanceof QQAppInterface)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
      }
      return true;
      finish();
    }
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null) {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    super.doOnDestroy();
  }
  
  public void onPostThemeChanged()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.c();
      finish();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ThemeSwitchDlgActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */