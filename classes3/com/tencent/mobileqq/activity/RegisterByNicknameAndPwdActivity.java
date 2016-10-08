package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import mim;
import min;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterByNicknameAndPwdActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "RegisterByNicknameAndPwdActivity";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private ClearableEditText jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public RegisterByNicknameAndPwdActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_MqqObserverAccountObserver = new min(this);
  }
  
  private boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label46;
      }
      int k = paramString.charAt(i);
      if ((k < 48) || (k > 57)) {
        break;
      }
      i += 1;
    }
    label46:
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367975);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303008));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(new mim(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303005));
    this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298410));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (AccessibilityUtil.a(this))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(2131368675);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setHint(2131367469);
    }
  }
  
  private boolean b(String paramString)
  {
    return paramString.indexOf(" ") != -1;
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, RegisterQQNumberActivity.class);
    localIntent.putExtra("phonenum", this.d);
    localIntent.putExtra("key", this.e);
    localIntent.putExtra("uin", this.c);
    localIntent.putExtra("key_register_now_account", this.f);
    localIntent.putExtra("key_register_sign", this.jdField_a_of_type_ArrayOfByte);
    localIntent.putExtra("key_register_password", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText()));
    localIntent.putExtra("key_register_unbind", true);
    startActivity(localIntent);
    finish();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramEditable.toString()))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8006653", "0X8006653", 0, 0, "", "", "", "");
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131367256, 0);
      return;
    }
    paramView = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText());
    if (TextUtils.isEmpty(paramView))
    {
      a(2131368560, 1);
      return;
    }
    if (b(paramView))
    {
      a(2131368546, 1);
      return;
    }
    if (a(paramView))
    {
      if (paramView.length() < 9) {
        a(2131368544, 1);
      }
    }
    else if (paramView.length() < 6)
    {
      a(2131368545, 1);
      return;
    }
    String str = this.jdField_b_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((TextUtils.isEmpty(str)) || (str.trim().length() == 0))
    {
      a(2131368574, 1);
      return;
    }
    try
    {
      if (str.getBytes("utf-8").length > 24L)
      {
        a(2131368575, 1);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      PhoneNumLoginImpl.a().a(this.app, false);
      try
      {
        ((AccountManager)this.app.getManager(0)).sendRegisterBySetPass(paramView, str, this.jdField_b_of_type_JavaLangString, false, this.jdField_a_of_type_MqqObserverAccountObserver);
        a(2131368499);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130904515));
    setTitle(2131368481);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key_register_smscode");
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = "";
    }
    this.d = getIntent().getStringExtra("phonenum");
    this.e = getIntent().getStringExtra("key");
    this.f = getIntent().getStringExtra("key_register_now_account");
    b();
    ReportController.b(this.app, "CliOper", "", "", "0X8006652", "0X8006652", 0, 0, "", "", "", "");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\RegisterByNicknameAndPwdActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */