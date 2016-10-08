package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import opr;
import ops;

public class PhoneMatchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public static final String a = "key_from_Tab";
  public static final String b = "key_from_l_w";
  public static final String c = "key_from_contact_first";
  private Button a;
  public ContactBindObserver a;
  
  public PhoneMatchActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentViewB(2130903442);
    this.centerView.setText("通讯录");
    if (getIntent().getBooleanExtra("key_from_contact_first", false)) {
      ((TextView)super.findViewById(2131298620)).setText(2131371014);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298621));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    setLeftButton(2131369134, this);
    ReportController.b(this.app, "dc00898", "", "", "0X800689B", "0X800689B", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968584);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!NetworkUtil.e(this))
      {
        b(2131368805);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new opr(this);
        this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      this.app.a(new ops(this));
      QQToast.a(BaseApplicationImpl.a, "特征码匹配中。", 0).a();
      if (getIntent().getBooleanExtra("key_from_Tab", false)) {
        ReportController.b(this.app, "CliOper", "", "", "0X80053DE", "0X80053DE", 0, 0, "", "", "", "");
      }
      if (getIntent().getBooleanExtra("key_from_l_w", false)) {
        ReportController.b(this.app, "dc00898", "", "", "0X800650C", "0X800650C", 2, 0, this.app.f(), "", "", "");
      }
      ReportController.b(this.app, "dc00898", "", "", "0X800689C", "0X800689C", 0, 0, "", "", "", "");
      a(2131368647, 1000L, true);
      return;
    }
    finish();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\phone\PhoneMatchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */