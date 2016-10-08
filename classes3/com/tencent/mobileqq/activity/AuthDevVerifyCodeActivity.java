package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.app.utils.SmsContent;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import klp;
import klq;
import klr;
import kls;
import klt;
import klu;
import klv;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;

public class AuthDevVerifyCodeActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, SMSBodyObserver
{
  public static final int a = 60;
  public static final String a = "mobile_type";
  public static final int b = 1000;
  public static final int c = -1;
  public static final int d = 0;
  public static final int e = 1;
  private static final String g = "Q.devlock.AuthDevVerifyCodeActivity";
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  SmsContent jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  protected String b;
  protected String c;
  protected int f;
  private int l;
  private int m;
  
  public AuthDevVerifyCodeActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = -1;
    this.m = 60;
    this.jdField_a_of_type_JavaLangRunnable = new klp(this);
    this.jdField_a_of_type_AndroidOsHandler = new klq(this);
    this.jdField_a_of_type_MqqObserverWtloginObserver = new klr(this);
    this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new kls(this);
  }
  
  private void a()
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, getString(2131367256), 0).b(getTitleBarHeight());
      return;
    }
    Object localObject1 = "";
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
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
      localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to submitSms smsCode=" + (String)localObject1);
        }
        i = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver, (String)localObject1);
        if (i == 0)
        {
          c();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.submitSms failed ret=" + i);
        }
        a(2131368512, 1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to CheckDevLockSms smsCode=" + (String)localObject1);
      }
      int i = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject2, (String)localObject1, null, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (i == 0)
      {
        c();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.CheckDevLockSms failed ret=" + i);
      }
      a(2131368512, 1);
      return;
    }
    a(2131368538, 0);
  }
  
  private void b()
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131367256), 0).b(getTitleBarHeight());
    }
    int i;
    do
    {
      String str;
      do
      {
        return;
        str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        if (this.f != -1) {
          EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.f);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to refreshDevLockSms");
        }
        i = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        if (i == 0)
        {
          a(2131368493);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.refreshDevLockSms failed ret=" + i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to AskDevLockSms");
      }
      i = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (i == 0)
      {
        a(2131368493);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.AskDevLockSms failed ret=" + i);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.m = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131368540) + "(" + this.m + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new klt(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new klu(this));
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
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new klv(this, paramString1, paramString2));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300209: 
      a();
      return;
    }
    b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130904155);
    super.setTitle(2131368537);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.app;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      super.finish();
      return;
    }
    paramBundle = super.getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getExtras().getBoolean("from_login");
    this.d = paramBundle.getExtras().getString("phone_num");
    this.e = paramBundle.getExtras().getString("country_code");
    this.f = paramBundle.getExtras().getInt("mobile_type", -1);
    this.l = paramBundle.getExtras().getInt("seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.l + " phoneNum=" + this.d);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131301589));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)super.findViewById(2131298567));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131300209));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131368539, new Object[] { this.d }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131301591));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131368540));
    if (AppSetting.j)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131367263));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131368540));
    }
    this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.l);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = new SmsContent(null);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a(this, this);
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent.a();
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsSmsContent = null;
    }
    EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
    d();
    f();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AuthDevVerifyCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */