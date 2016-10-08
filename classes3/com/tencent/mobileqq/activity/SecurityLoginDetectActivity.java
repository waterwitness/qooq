package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;

public class SecurityLoginDetectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public SecurityLoginDetectActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    if (SettingCloneUtil.readValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842908);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.b.setText(2131370821);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131370819);
      ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "show open login secure view", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842911);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.b.setText(2131370820);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131370818);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904959);
    setTitle(2131370795);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131304889));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131304886));
    this.b = ((TextView)findViewById(2131304888));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304887));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    a();
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131304889)
    {
      SettingCloneUtil.writeValue(this, null, "security_scan_key", "qqsetting_security_scan_key", true);
      a();
      ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on open login secure", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\SecurityLoginDetectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */