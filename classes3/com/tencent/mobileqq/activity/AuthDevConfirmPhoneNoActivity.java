package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevConfirmPhoneNoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1001;
  public static final String a = "from_login";
  public static final int b = 1002;
  public static final String b = "phone_num";
  public static final int c = 1003;
  public static final String c = "country_code";
  public static final String d = "auth_dev_open";
  public static final String e = "allow_set";
  public static final String f = "user_guide";
  public static final String g = "user_uin";
  public static final String h = "seq";
  public static final String i = "DevlockInfo";
  private static final String j = "Q.devlock.AuthDevConfirmPhoneNoActivity";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  
  public AuthDevConfirmPhoneNoActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    super.setContentView(2130904149);
    setTitle(2131370700);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301569));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301572));
    this.c = ((TextView)findViewById(2131301573));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301574));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131301575));
    if ((QLog.isColorLevel()) && ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.c == null) || (this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_b_of_type_AndroidWidgetButton == null)))
    {
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "one or more controls is null! ");
      return;
    }
    onCreateRightView();
    setRightButton(2131370752, this);
    Object localObject = (TextView)findViewById(2131297083);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    if (this.k != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.k);
    }
    if (this.l != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.l);
    }
    if (this.m != null) {
      this.c.setText(this.m);
    }
    localObject = getString(2131370756);
    String str = getString(2131370757);
    this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setText(str);
    this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    try
    {
      EquipmentLockImpl.a().a(null, this.app.a(), 6);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "verify page call back resultCode = " + paramInt2);
            }
            if (paramInt2 == -1)
            {
              if (paramIntent != null) {}
              for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
              {
                paramIntent.putExtra("requestCode", paramInt1);
                setResult(-1, paramIntent);
                finish();
                return;
              }
            }
          } while (paramInt2 != 0);
          return;
        } while (paramIntent == null);
        localObject = paramIntent.getExtras();
      } while (localObject == null);
      paramInt2 = ((Bundle)localObject).getInt("resultState", 1);
      localObject = ((Bundle)localObject).getString("resultMobileMask");
    } while (paramInt2 == 1);
    if (paramInt2 == 2) {
      DevlockPhoneStatus.a().a(DevlockPhoneStatus.e);
    }
    for (;;)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.putExtra("requestCode", paramInt1);
      paramIntent.putExtra("phone_num", (String)localObject);
      setResult(-1, paramIntent);
      finish();
      return;
      if (paramInt2 == 3)
      {
        DevlockPhoneStatus.a().a(DevlockPhoneStatus.d);
        DevlockPhoneStatus.a().a(0L);
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130968593);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301574: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click confirm mobile phone button! ");
      }
      break;
    }
    try
    {
      EquipmentLockImpl.a().a(null, this.app.a(), 7);
      paramView = new Intent(this, AuthDevVerifyCodeActivity.class);
      paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
      paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      paramView.putExtra("mobile_type", 0);
      startActivityForResult(paramView, 1001);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click modify mobile phone button! ");
      }
      try
      {
        EquipmentLockImpl.a().a(null, this.app.a(), 8);
        if (this.app != null) {
          this.app.sendWirelessMeibaoReq(1);
        }
        if ((!TextUtils.isEmpty(this.o)) && (this.o.equals("subaccount")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "subaccount enter webview mUin=" + this.n + " mMainAccount=" + this.p);
          }
          if ((TextUtils.isEmpty(this.n)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
          }
          EquipLockWebEntrance.a(this, this.p, this.n, EquipLockWebEntrance.c, 1002, null);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mainaccount enter webview mUin=" + this.n);
        }
        if ((TextUtils.isEmpty(this.n)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
        }
        EquipLockWebEntrance.a(this, this.n, this.n, EquipLockWebEntrance.c, 1002, null);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "onClick right cancel button! ");
        }
        finish();
        overridePendingTransition(0, 2130968593);
        return;
      }
      catch (Exception paramView)
      {
        for (;;) {}
      }
    }
    catch (Exception paramView)
    {
      for (;;) {}
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    this.k = ((Bundle)localObject).getString("ParaTextUp");
    this.l = ((Bundle)localObject).getString("ParaTextDown");
    this.m = ((Bundle)localObject).getString("PhoneNO");
    this.n = ((Bundle)localObject).getString("uin");
    this.o = ((Bundle)localObject).getString("from_where");
    this.p = ((Bundle)localObject).getString("mainaccount");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    if (QLog.isColorLevel())
    {
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "on Create strParaGraphUp : " + this.k);
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "on Create strParaGraphDown : " + this.l);
    }
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AuthDevConfirmPhoneNoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */