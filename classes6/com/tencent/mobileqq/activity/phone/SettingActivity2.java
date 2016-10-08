package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import opw;
import oqa;
import oqb;

public class SettingActivity2
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public static final int a = 1001;
  public static final String a = "SettingActivity2";
  public Button a;
  public TextView a;
  public ContactBindObserver a;
  public boolean a;
  public int b;
  public Button b;
  public TextView b;
  public ContactBindObserver b;
  public String b;
  public int c;
  public ContactBindObserver c;
  
  public SettingActivity2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = -1;
  }
  
  public void a()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.setCanceledOnTouchOutside(true);
    localActionSheet.a("停用", 3);
    localActionSheet.d(2131367262);
    localActionSheet.a(new opw(this, localActionSheet));
    localActionSheet.d(2131367262);
    localActionSheet.show();
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if ((1 != this.jdField_b_of_type_Int) && (2 != this.jdField_b_of_type_Int)) {}
    try
    {
      this.jdField_b_of_type_JavaLangString = (localRespondQueryQQBindingStat.nationCode + " " + localRespondQueryQQBindingStat.mobileNo);
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        super.finish();
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SettingActivity2", 2, "" + this.jdField_b_of_type_Int, localException);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SettingActivity2", 2, "updateStateLayout mNumber = " + this.jdField_b_of_type_JavaLangString + ", mState = " + this.jdField_b_of_type_Int);
      }
      super.setTitle("手机通讯录");
      if (this.jdField_b_of_type_Int != 4) {
        break label318;
      }
    }
    Object localObject = "启用手机通讯录匹配。如果你的通讯录中有朋友开通此功能，系统会通知你。可在QQ直接给朋友发消息、图片等。";
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298640));
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298641));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298642));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_b_of_type_Int == 4)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      localObject = (ImageView)findViewById(2131297392);
      ((ImageView)localObject).setVisibility(0);
      if (AppSetting.j) {
        ((ImageView)localObject).setContentDescription(getString(2131371010));
      }
      ((ImageView)localObject).setBackgroundResource(2130838587);
      ((ImageView)localObject).setOnClickListener(this);
      return true;
      label318:
      localObject = "已启用手机通讯录匹配。如果你的通讯录中有朋友开通此功能，系统会通知你。可在QQ直接给朋友发消息、图片等。";
      break;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void b()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131368805);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d())
    {
      startActivity(new Intent(this, GuideBindPhoneActivity.class));
      return;
    }
    int i = getResources().getDimensionPixelSize(2131492908);
    if (this.jdField_c_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_c_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new oqa(this);
      this.app.registObserver(this.jdField_c_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.app.a(new oqb(this));
    QQToast.a(BaseApplicationImpl.a, "特征码匹配中。", 0).b(i);
    a(2131368647, 1000L, true);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    if (paramBundle == null) {
      super.finish();
    }
    do
    {
      return true;
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("kSrouce", -1);
      super.setContentView(2130903446);
    } while (a());
    super.finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    this.app.a(SettingActivity2.class);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
      throw new RuntimeException("unknown id: " + i);
    case 2131297392: 
      a();
      return;
    case 2131298643: 
      if (!NetworkUtil.e(this))
      {
        b(2131368805);
        return;
      }
      paramView = new Intent(this, BindNumberActivity.class);
      paramView.putExtra("kNeedUnbind", true);
      paramView.putExtra("cmd_param_is_from_uni", true);
      paramView.putExtra("cmd_param_is_from_change_bind", true);
      startActivity(paramView);
      return;
    case 2131298641: 
      ReportController.b(this.app, "CliOper", "", "", "0X8005B89", "0X8005B89", 0, 0, "", "", "", "");
      b();
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d())
    {
      startActivity(new Intent(this, GuideBindPhoneActivity.class));
      return;
    }
    if (this.jdField_c_of_type_Int == 6)
    {
      super.finish();
      return;
    }
    paramView = new Intent(getActivity(), PhoneFrameActivity.class);
    paramView.putExtra("key_req_type", 5);
    getActivity().startActivity(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\phone\SettingActivity2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */