package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import lua;
import lub;
import luc;
import lud;
import lue;
import luf;
import lug;
import mqq.observer.SubAccountObserver;
import mqq.observer.WtloginObserver;

public class LoginVerifyCodeActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, SMSBodyObserver
{
  public static final int a = 60;
  private static final String jdField_a_of_type_JavaLangString = "LoginVerifyCodeActivity";
  public static final int b = 1000;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public SubAccountBindObserver a;
  private SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public SubAccountObserver a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private int c;
  
  public LoginVerifyCodeActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 60;
    this.jdField_a_of_type_JavaLangRunnable = new lua(this);
    this.jdField_a_of_type_MqqObserverWtloginObserver = new lub(this);
    this.jdField_a_of_type_MqqObserverSubAccountObserver = new luc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new lud(this);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.c = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131368540) + "(" + this.c + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void c()
  {
    ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301589)).setText(getString(2131368539, new Object[] { this.d }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301591));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131368540) + "(" + this.c + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301832));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298567));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginVerifyCodeActivity", 2, "startLogin start...");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      PhoneNumLoginImpl.a().b(this.app, this.app.a(), this.e, this.d, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
    }
    PhoneNumLoginImpl.a().b(this.app, this.e, this.d, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void g()
  {
    a(2131368493);
    if (PhoneNumLoginImpl.a().a(this.app, this.e, this.d, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
    {
      d();
      a(2131368654, 1);
    }
  }
  
  private void h()
  {
    Object localObject1 = "";
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (localObject2 != null)
    {
      localObject2 = localObject2.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
    }
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      a(2131368497);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "commitSmsCode start...");
      }
      if (PhoneNumLoginImpl.a().a(this.app, this.e, this.d, (String)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0)
      {
        d();
        a(2131368654, 1);
      }
      return;
    }
    a(2131368538, 0);
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new lue(this));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() >= 4)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new luf(this));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130904210));
    setTitle(2131368537);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("fromWhere");
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("isSubaccount", false);
    }
    if (this.jdField_a_of_type_Boolean) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    }
    this.d = getIntent().getStringExtra("phonenum");
    this.e = getIntent().getStringExtra("key");
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
    return true;
  }
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new lug(this, paramString1, paramString2));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (getIntent().getBooleanExtra("login_from_account_change", false))
    {
      setResult(-1);
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131367256, 0);
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301591: 
      g();
      return;
    }
    h();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d();
    if (this.jdField_a_of_type_Boolean) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\LoginVerifyCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */