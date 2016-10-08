package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import lfa;
import lfb;
import lfc;
import lfd;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class DevlockPushActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.devlock.DevlockPushActivity";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  public DevlockPushActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new lfa(this);
    this.jdField_a_of_type_MqqObserverWtloginObserver = new lfb(this);
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      EquipmentLockImpl.a().a(paramDevlockInfo.MbGuideInfo);
    }
    int m;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        m = 1;
      }
    }
    for (;;)
    {
      if (m != 0) {
        EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          break label99;
        }
        return;
        m = 0;
        break;
        EquipmentLockImpl.a().a(this.app, this, this.app.a(), false);
      }
      label99:
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
      {
        paramDevlockInfo = new Intent(this, AuthDevActivity.class);
        paramDevlockInfo.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramDevlockInfo.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        paramDevlockInfo.putExtra("auth_dev_open", true);
        startActivity(paramDevlockInfo);
        finish();
        overridePendingTransition(0, 0);
        return;
      }
      DevlockPhoneStatus localDevlockPhoneStatus = DevlockPhoneStatus.a();
      if ((localDevlockPhoneStatus != null) && (localDevlockPhoneStatus.a() == DevlockPhoneStatus.d))
      {
        paramDevlockInfo = "";
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          paramDevlockInfo = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
        }
        localDevlockPhoneStatus.a(this, paramDevlockInfo);
        return;
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1))
      {
        paramDevlockInfo = new Intent(this, AuthDevActivity.class);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramDevlockInfo.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramDevlockInfo.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramDevlockInfo.putExtra("auth_dev_open", false);
        paramDevlockInfo.putExtra("allow_set", true);
        startActivity(paramDevlockInfo);
        finish();
        return;
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
      {
        paramDevlockInfo = new Intent(this, AuthDevConfirmPhoneNoActivity.class);
        paramDevlockInfo.putExtra("ParaTextUp", this.j);
        paramDevlockInfo.putExtra("ParaTextDown", this.k);
        paramDevlockInfo.putExtra("PhoneNO", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramDevlockInfo.putExtra("mainaccount", this.d);
        paramDevlockInfo.putExtra("uin", this.b);
        paramDevlockInfo.putExtra("from_where", this.c);
        paramDevlockInfo.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult(paramDevlockInfo, 1001);
        overridePendingTransition(0, 2130968592);
        return;
      }
      EquipLockWebEntrance.a(this, this.app, EquipLockWebEntrance.c, 1003, null);
      return;
      m = 0;
    }
  }
  
  private void b()
  {
    this.leftView.setVisibility(4);
    if (this.jdField_a_of_type_Boolean)
    {
      setRightButton(2131367262, this);
      if (AppSetting.j) {
        this.rightViewText.setContentDescription(getString(2131367262));
      }
    }
    TextView localTextView = (TextView)findViewById(2131301577);
    if (TextUtils.isEmpty(this.e)) {
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131370748));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131370703));
      EquipmentLockImpl.a().a(null, this.app.a(), 1);
      return;
      localTextView.setText(this.e);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new lfc(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new lfd(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    String str = this.app.a();
    int m = EquipmentLockImpl.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (m != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "startGetDevLockStatus.CheckDevLockStatus fail ret=" + m);
      }
      str = getString(2131370730);
      QQToast.a(getApplicationContext(), str, 0).b(getTitleBarHeight());
      return;
    }
    c();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        if ((paramIntent == null) || (paramIntent.getExtras().getInt("requestCode") != 1002)) {
          break label50;
        }
        setResult(-1, null);
        finish();
      }
    }
    label50:
    label690:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    DevlockPhoneStatus.a().a(DevlockPhoneStatus.e);
                    if (EquipmentLockImpl.a().a())
                    {
                      paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
                      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                      {
                        paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                        paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                      }
                      startActivity(paramIntent);
                    }
                    for (;;)
                    {
                      paramIntent = new Intent();
                      paramIntent.putExtra("allow_set", true);
                      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                        paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                      }
                      setResult(-1, paramIntent);
                      finish();
                      return;
                      paramIntent = new Intent(this, AuthDevActivity.class);
                      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                      {
                        paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                        paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                      }
                      paramIntent.putExtra("auth_dev_open", true);
                      startActivity(paramIntent);
                    }
                    if (paramInt1 != 1002) {
                      break;
                    }
                  } while (paramInt2 != -1);
                  finish();
                  return;
                } while (paramInt1 != 1003);
                if (paramInt2 != -1) {
                  break;
                }
              } while ((paramIntent == null) || (paramIntent.getExtras() == null));
              paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
              }
            } while (paramInt1 != 2);
            localObject = paramIntent.getExtras().getString("resultMobileMask");
            bool = paramIntent.getExtras().getBoolean("resultSetMobile");
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + (String)localObject + " openSuccess=" + bool);
            }
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = ((String)localObject);
            }
          } while (!bool);
          EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
          boolean bool = EquipmentLockImpl.a().a();
          Object localObject = new Intent();
          if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
          {
            ((Intent)localObject).putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            ((Intent)localObject).putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          }
          String str = paramIntent.getExtras().getString("emergency_phone_mask");
          if (!TextUtils.isEmpty(str))
          {
            paramInt1 = paramIntent.getExtras().getInt("emergency_phone_state");
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.DevlockPushActivity", 2, "emergency phone:" + str + " state=" + paramInt1);
            }
            DevlockPhoneStatus.a().a(str);
            paramIntent = DevlockPhoneStatus.a();
            if (paramInt1 == 1)
            {
              paramInt1 = DevlockPhoneStatus.f;
              paramIntent.b(paramInt1);
            }
          }
          else
          {
            if (!bool) {
              break label690;
            }
            ((Intent)localObject).setClass(this, AuthDevEnableCompleteActivity.class);
          }
          for (;;)
          {
            startActivity((Intent)localObject);
            QQToast.a(getApplicationContext(), 2, getString(2131370706), 0).b(getTitleBarHeight());
            paramIntent = new Intent();
            paramIntent.putExtra("auth_dev_open", true);
            paramIntent.putExtra("allow_set", true);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            }
            setResult(-1, paramIntent);
            finish();
            return;
            paramInt1 = DevlockPhoneStatus.j;
            break;
            ((Intent)localObject).setClass(this, AuthDevActivity.class);
            ((Intent)localObject).putExtra("auth_dev_open", true);
          }
        } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
        paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
        }
      } while (paramInt1 != 2);
      paramIntent = paramIntent.getExtras().getString("resultMobileMask");
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.DevlockPushActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
      }
      if (!TextUtils.isEmpty(paramIntent)) {
        EquipmentLockImpl.a().a(this.app, this.app.a(), null);
      }
    } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      finish();
      overridePendingTransition(0, 2130968593);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    try
    {
      EquipmentLockImpl.a().a(null, this.app.a(), 3);
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        if (!NetworkUtil.e(this))
        {
          QQToast.a(this, getString(2131367256), 0).b(getTitleBarHeight());
          return;
        }
        a();
        return;
      }
      a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      return;
      try
      {
        EquipmentLockImpl.a().a(null, this.app.a(), 2);
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
    int m = 0;
    setTheme(2131559165);
    super.onCreate(paramBundle);
    super.setContentView(2130904150);
    setTitle(2131370700);
    if (this.app == null)
    {
      finish();
      return;
    }
    this.app.setDevLockIntent(null);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301578));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
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
    EquipmentLockImpl.a().a(true);
    EquipmentLockImpl.a().a("Push");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
      DevlockPhoneStatus.a().a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TransferInfo);
    }
    this.b = ((Bundle)localObject).getString("uin");
    this.c = ((Bundle)localObject).getString("from_where");
    this.d = ((Bundle)localObject).getString("mainaccount");
    this.jdField_a_of_type_Boolean = getIntent().getExtras().getBoolean("canCancel", false);
    this.e = getIntent().getExtras().getString("title");
    this.f = getIntent().getExtras().getString("secondTitle");
    this.g = getIntent().getExtras().getString("thirdTitle");
    this.jdField_a_of_type_JavaUtilArrayList = getIntent().getExtras().getStringArrayList("wordsList");
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      if (m < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        paramBundle = (String)this.jdField_a_of_type_JavaUtilArrayList.get(m);
        if (m == 0) {
          this.h = paramBundle;
        }
        for (;;)
        {
          m += 1;
          break;
          if (m == 1) {
            this.i = paramBundle;
          } else if (m == 2) {
            this.j = paramBundle;
          } else if (m == 3) {
            this.k = paramBundle;
          }
        }
      }
    }
    if (TextUtils.isEmpty(this.e)) {
      this.e = getString(2131370761);
    }
    if (TextUtils.isEmpty(this.f)) {
      this.f = getString(2131370748);
    }
    if (TextUtils.isEmpty(this.h)) {
      this.h = getString(2131370750);
    }
    if (TextUtils.isEmpty(this.i)) {
      this.i = getString(2131370751);
    }
    if (TextUtils.isEmpty(this.j)) {
      this.j = getString(2131370754);
    }
    if (TextUtils.isEmpty(this.k)) {
      this.k = getString(2131370755);
    }
    if (TextUtils.isEmpty(this.g)) {
      this.g = getString(2131370749);
    }
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\DevlockPushActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */