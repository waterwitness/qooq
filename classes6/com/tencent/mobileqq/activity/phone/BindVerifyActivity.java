package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import ook;
import ool;

public class BindVerifyActivity
  extends DialogBaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener, SMSBodyObserver
{
  protected static final int a = 0;
  public static final String a = "k_number";
  public static final String b = "k_country_code";
  private static final int e = 1;
  private static final int f = 2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  boolean jdField_a_of_type_Boolean;
  public int b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  private String d;
  
  public BindVerifyActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -1;
  }
  
  private void a(Intent paramIntent)
  {
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("kBindType", 0);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("kShowAgree", false);
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("k_number");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("k_country_code");
    if ((this.jdField_c_of_type_Int == 10) || (this.jdField_c_of_type_Int == 11))
    {
      ((TextView)findViewById(2131298579)).setText(getResources().getString(2131362957, new Object[] { this.jdField_c_of_type_JavaLangString }));
      setTitle("输入短信验证码");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        findViewById(2131298578).setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText("重新发送");
      this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, 60, 0), 1000L);
      return;
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131362957, new Object[] { this.jdField_c_of_type_JavaLangString }));
      } else if (1 == this.jdField_b_of_type_Int) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131362958, new Object[] { this.jdField_c_of_type_JavaLangString }));
      }
    }
  }
  
  private void b()
  {
    if (!NetworkUtil.e(this))
    {
      b(2131368805);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new ool(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    if (getIntent().getBooleanExtra("k_is_block", false)) {
      ReportController.b(this.app, "CliOper", "", "", "0X80056B5", "0X80056B5", 0, 0, "", "", "", "");
    }
    if ((getIntent() != null) && (getIntent().getBooleanExtra("key_is_from_qav_multi_call", false))) {
      ReportController.b(this.app, "CliOper", "", "", "0X8005D0F", "0X8005D0F", 0, 0, "", "", "", "");
    }
    if (this.jdField_c_of_type_Int == 10) {
      ReportController.b(this.app, "dc00898", "", "", "0X8006AA7", "0X8006AA7", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
    a(2131368647, 1000L, true);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() >= 4))
    {
      if ((this.jdField_c_of_type_Int == 10) || (this.jdField_c_of_type_Int == 11))
      {
        this.rightViewText.setEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if ((this.jdField_c_of_type_Int == 10) || (this.jdField_c_of_type_Int == 11))
    {
      this.rightViewText.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    a();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != 0)
    {
      setResult(paramInt2);
      finish();
    }
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_c_of_type_Int == 10) {
      ReportController.b(this.app, "dc00898", "", "", "0X8006AA8", "0X8006AA8", 0, 0, "", "", "", "");
    }
    QQAppInterface localQQAppInterface;
    if (getIntent().getBooleanExtra("k_is_block", false))
    {
      localQQAppInterface = this.app;
      if (this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() < 4) {
        break label106;
      }
    }
    label106:
    for (int i = 1;; i = 0)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X80056B6", "0X80056B6", i, 0, "", "", "", "");
      super.doOnBackPressed();
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_d_of_type_Int = getIntent().getIntExtra("keyReqBindMode", 0);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "doOnCreate ,mSource = " + this.jdField_c_of_type_Int + ",mReqBindMode = " + this.jdField_d_of_type_Int);
    }
    if ((this.jdField_c_of_type_Int == 10) || (this.jdField_c_of_type_Int == 11))
    {
      getWindow().setSoftInputMode(16);
      setContentView(2130903433);
      if (this.jdField_c_of_type_Int == 10)
      {
        setRightButton(2131368949, this);
        setLeftButton(2131366637, this);
        label174:
        if (!this.jdField_b_of_type_Boolean) {
          break label408;
        }
        setTitle("填写验证码");
        ReportController.b(this.app, "CliOper", "", "", "0X8005B79", "0X8005B79", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298575));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131298576));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298568));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131297859));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298570));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298577));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
      a(getIntent());
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
      return true;
      setRightButton(2131368729, this);
      break;
      setContentView(2130903432);
      break label174;
      label408:
      setTitle("验证手机号码");
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(paramIntent);
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    paramString1 = Utils.d(paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, paramString1).sendToTarget();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 1: 
      int i = paramMessage.arg1 - 1;
      paramMessage.arg1 = i;
      if (i <= 0)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setText("重新发送");
        return true;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText("重新发送(" + i + ")");
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, i, 0), 1000L);
      return true;
    }
    paramMessage = (String)paramMessage.obj;
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramMessage);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramMessage.length());
    return true;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.jdField_a_of_type_AndroidWidgetCheckBox) {
      a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131297391: 
    case 2131297183: 
      do
      {
        return;
        doOnBackPressed();
        return;
      } while ((this.jdField_c_of_type_Int != 10) && (this.jdField_c_of_type_Int != 11));
      b();
      return;
    case 2131298568: 
      b();
      return;
    case 2131298577: 
      if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new ook(this);
        this.app.registObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      }
      if ((this.jdField_c_of_type_Int == 10) || (this.jdField_c_of_type_Int == 11))
      {
        this.rightViewText.setEnabled(false);
        if (this.jdField_d_of_type_Int != 1) {
          break label245;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("k_is_block", false)) {
          ReportController.b(this.app, "CliOper", "", "", "0X800568C", "0X800568C", 1, 0, "", "", "", "");
        }
        a(2131368647, 1000L, true);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        break;
        label245:
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      }
    }
    paramView = new Intent(this, TosActivity.class);
    paramView.putExtra("frombusiness", 0);
    startActivity(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\mobileqq\activity\phone\BindVerifyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */