package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;

public class PhoneLaunchView
  extends BaseActivityView
  implements View.OnClickListener
{
  private static final int g = 1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private boolean jdField_a_of_type_Boolean;
  
  public PhoneLaunchView(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a(2130903441);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131298617));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void j()
  {
    Intent localIntent = new Intent(getContext(), BindNumberActivity.class);
    localIntent.putExtra("key_is_modal_pop", true);
    b(localIntent, 1);
    a(2130968793, 2130968589);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_Int == 3) {
      this.b.setText("通讯录");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_Boolean) {
        j();
      }
      return;
      this.b.setText("启用通讯录");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label26;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(paramInt2);
      f();
    }
    label26:
    do
    {
      return;
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("refuse_upload", false)))
        {
          f();
          return;
        }
        a(new Intent(getContext(), ContactListView.class));
        return;
      }
    } while (paramInt2 != 1);
    f();
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("k_start_number", false))) {
      this.jdField_a_of_type_Boolean = true;
    }
    super.a(paramIntent, paramPhoneInnerFrame);
    if (this.jdField_a_of_type_Int == 3)
    {
      ((ImageView)a(2131298615)).setImageResource(2130838729);
      ((TextView)a(2131298616)).setText(2131369709);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "QQPim", "Clk_address_on", 0, 0, "", "", "", "");
      if (i == 1)
      {
        ContactUtils.a(6);
        j();
      }
    }
    else
    {
      return;
    }
    if (i == 2)
    {
      b(new Intent(getContext(), BindNumberFromPcActivity.class), 1);
      a(2130968793, 2130968589);
      return;
    }
    a("请求出错", "请稍后重试");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\phone\PhoneLaunchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */