package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import miv;
import miw;
import miz;
import mja;
import mjb;
import mjc;
import mjd;
import mje;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class RegisterQQNumberActivity
  extends RegisterBaseActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "RegisterQQNumberActivity";
  private Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  
  public RegisterQQNumberActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqObserverWtloginObserver = new mja(this);
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new mjb(this);
    this.jdField_a_of_type_MqqObserverAccountObserver = new mjc(this);
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303026));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303028));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131303027));
    Object localObject = "+" + this.e + "-" + this.d;
    localObject = new SpannableString(String.format(getString(2131368577), new Object[] { localObject }));
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 10, 25, 33);
    this.c.setText((CharSequence)localObject);
    if (this.jdField_b_of_type_Boolean) {
      this.c.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367975);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new miv(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString + "");
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF8444"));
    this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(new miw(this));
  }
  
  private void b()
  {
    Object localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.a);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
    localObject = this.app.a(LoginActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(20140325);
    }
  }
  
  private void c()
  {
    PhoneNumLoginImpl.a().a(true);
    PhoneNumLoginImpl.a().b(this.app, this.e, this.d, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new mjd(this));
  }
  
  private void g()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new mje(this));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged success");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      b();
      g();
    }
    do
    {
      return;
      if (PhoneNumLoginImpl.a().a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RegisterQQNumberActivity", 2, "onAccountChanged not phonenum login");
    return;
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    if (this.jdField_a_of_type_Boolean)
    {
      this.app.a(new miz(this));
      QQToast.a(BaseApplicationImpl.a, "特征码匹配中。", 0).a();
    }
    LoginActivity.a(this.app, this.app.getAccount());
    b();
    g();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8006655", "0X8006655", 0, 0, "", "", "", "");
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131367256, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
    }
    f();
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        break label170;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "swz mSign = " + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      }
    }
    while (this.jdField_b_of_type_Boolean)
    {
      getAppRuntime().login(this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
      label170:
      if (QLog.isColorLevel()) {
        QLog.d("RegisterQQNumberActivity", 2, "swz mSign = null");
      }
    }
    ContactBindServlet.a(this.app, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_JavaLangString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130904520));
    setTitle(2131368547);
    this.d = getIntent().getStringExtra("phonenum");
    this.e = getIntent().getStringExtra("key");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("key_register_sign");
    paramBundle = getIntent().getStringExtra("key_register_password");
    if (paramBundle != null) {
      this.jdField_b_of_type_ArrayOfByte = MD5.toMD5Byte(paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onCreate ,pwd = " + paramBundle + ",mPassByte = " + this.jdField_b_of_type_ArrayOfByte);
    }
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_unbind", false);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    a();
    ReportController.b(this.app, "CliOper", "", "", "0X8006654", "0X8006654", 0, 0, "", "", "", "");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    d();
    g();
  }
  
  protected void onPause()
  {
    super.onPause();
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\RegisterQQNumberActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */