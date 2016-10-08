package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import lty;
import ltz;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class LoginPhoneNumActivity2
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "LoginPhoneNumActivity";
  public static final int b = 2014;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private int c;
  
  public LoginPhoneNumActivity2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqOsMqqHandler = new lty(this);
    this.jdField_a_of_type_MqqObserverWtloginObserver = new ltz(this);
  }
  
  private String a(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.e)) {
          break label149;
        }
        if ("853".equals(this.e))
        {
          break label149;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        if (paramString.startsWith("1")) {
          break label138;
        }
        bool = "86".equals(this.e);
        if (!bool) {
          break label138;
        }
        i = k;
      }
      catch (Exception localException)
      {
        for (;;) {}
        i = j;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.e);
      if (bool)
      {
        i = 9;
        continue;
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label138:
        continue;
        label149:
        i = 6;
      }
    }
  }
  
  private boolean a()
  {
    boolean bool = true;
    this.d = a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString());
    if (this.d == null)
    {
      a(2131368511, 1);
      bool = false;
    }
    return bool;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301831));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131368573) + "+" + this.e);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298567));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301832));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void f()
  {
    if (!a()) {}
    do
    {
      return;
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        a(2131367256, 0);
        return;
      }
      a(2131368493);
      if (QLog.isColorLevel()) {
        QLog.d("LoginPhoneNumActivity", 2, "-->startQueryAccount--CheckSMSVerifyLoginAccount, countryCode = " + this.e + "phoneNum = " + this.d);
      }
    } while (PhoneNumLoginImpl.a().a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.d, this.e, this.jdField_a_of_type_MqqObserverWtloginObserver) == 0);
    d();
    a(getString(2131368479), 1);
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, LoginVerifyCodeActivity2.class);
    localIntent.putExtra("phonenum", this.d);
    localIntent.putExtra("key", this.e);
    localIntent.putExtra("key_req_src", this.c);
    startActivityForResult(localIntent, 10000);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (a(paramEditable.toString()) != null)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void b()
  {
    a(2131368654, 1);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginPhoneNumActivity", 2, "-->onActivityResult--reqCode = " + paramInt1 + ", resCode = " + paramInt2);
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      str1 = paramIntent.getStringExtra("last_account");
      str2 = paramIntent.getStringExtra("wtTicket");
      localIntent = new Intent();
      localIntent.putExtra("last_account", str1);
      localIntent.putExtra("wtTicket", str2);
      localIntent.putExtra("ssobundle", paramIntent.getBundleExtra("ssobundle"));
      setResult(-1, localIntent);
      finish();
    }
    while ((paramInt1 != 1) || (paramInt2 != -1))
    {
      String str2;
      Intent localIntent;
      return;
    }
    String str1 = paramIntent.getStringExtra("k_name");
    this.e = paramIntent.getStringExtra("k_code");
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str1 + " +" + this.e);
    try
    {
      if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301831: 
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      return;
    }
    f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130904209));
    setTitle(2131367476);
    this.c = getIntent().getIntExtra("key_req_src", -1);
    if (QLog.isColorLevel()) {
      QLog.d("LoginPhoneNumActivity", 2, "-->onCreate--mReqSrc = " + this.c);
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    c();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    d();
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(getClass());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\LoginPhoneNumActivity2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */