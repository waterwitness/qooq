package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import opp;
import opq;

public class PhoneLaunchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 1;
  public static final String a = "needAlert";
  private static final int jdField_b_of_type_Int = 2;
  public static final String b = "fromStopAndMatch";
  public static final String c = "fromCall";
  public static final String d = "fromPermiPriv";
  public static final String e = "fromAVCallInvite";
  public static final String f = "returnAndFinish";
  public static final String g = "key_is_first_activity";
  public static final String h = "k_start_number";
  private Button jdField_a_of_type_AndroidWidgetButton;
  public ContactBindObserver a;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public PhoneLaunchActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void b()
  {
    ContactUtils.a(2);
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    if (getIntent().getIntExtra("kSrouce", -1) == 8) {
      localIntent.putExtra("kSrouce", 8);
    }
    startActivityForResult(localIntent, 1);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d())
    {
      startActivity(new Intent(this, GuideBindPhoneActivity.class));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if (!NetworkUtil.e(this))
    {
      b(2131368805);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new opp(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.app.a(new opq(this));
    a(2131368647, 1000L, true);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if (paramInt2 != 0) {
        finish();
      }
    }
    while ((paramInt2 != 2) || (!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b())) {
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    boolean bool = getIntent().hasExtra("needAlert");
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("fromStopAndMatch", false);
    this.b = getIntent().getBooleanExtra("fromCall", false);
    this.c = getIntent().getBooleanExtra("fromPermiPriv", false);
    this.d = getIntent().getBooleanExtra("fromAVCallInvite", false);
    this.e = getIntent().getBooleanExtra("returnAndFinish", false);
    if ((!bool) && (paramBundle == null))
    {
      finish();
      return false;
    }
    if (!this.jdField_a_of_type_Boolean) {
      if (getIntent().getStringExtra("leftViewText") == null) {
        getIntent().putExtra("leftViewText", "联系人");
      }
    }
    for (;;)
    {
      setContentView(2130903441);
      setTitle("启用通讯录");
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298617));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (getIntent().getBooleanExtra("k_start_number", false)) {
        b();
      }
      return true;
      getIntent().putExtra("leftViewText", "关闭");
    }
  }
  
  public void finish()
  {
    super.finish();
    if (!this.jdField_a_of_type_Boolean) {
      overridePendingTransition(2130968589, 2130968795);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
      if (i == 1) {
        b();
      }
      for (;;)
      {
        if (this.d) {
          ReportController.b(this.app, "CliOper", "", "", "0X8005D10", "0X8005D10", 0, 0, "", "", "", "");
        }
        return;
        if (i == 2)
        {
          paramView = new Intent(this, BindNumberFromPcActivity.class);
          paramView.putExtra("key_is_first_activity", false);
          startActivityForResult(paramView, 1);
        }
        else if (i == 4)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          a();
        }
        else
        {
          a("请求出错", "请稍后重试");
        }
      }
    }
    finish();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\phone\PhoneLaunchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */