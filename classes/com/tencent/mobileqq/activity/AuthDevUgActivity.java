package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;
import klo;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevUgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "from_login";
  public static final int b = 1;
  public static final String b = "phone_num";
  public static final int c = 2;
  public static final String c = "country_code";
  public static final int d = 3;
  public static final String d = "auth_dev_open";
  public static final int e = 1001;
  public static final String e = "allow_set";
  public static final int f = 1002;
  public static final String f = "user_guide";
  public static final int g = 1003;
  public static final String g = "user_uin";
  public static final int h = 0;
  public static final String h = "seq";
  public static final int i = 1;
  public static final String i = "DevlockInfo";
  public static final int j = 2;
  public static final String j = "devlock_roam_sig";
  public static final String k = "devlock_need_broadcast";
  public static final String l = "devlock_open_source";
  public static final String m = "skip_guide_page";
  public static final String n = "auth_dev_open_cb_reason";
  private static final String o = "Q.devlock.AuthDevUgActivity";
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int k;
  private String p;
  private String q;
  private String r;
  
  public AuthDevUgActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new klo(this);
  }
  
  private void a()
  {
    String str;
    if (this.jdField_a_of_type_Boolean) {
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason)))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          str = getString(2131370707) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
          this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        }
        this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131370727));
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.BakMobileState == 2))
        {
          this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
          if (AppSetting.j) {
            this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(getString(2131370771));
          }
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.leftView.setVisibility(4);
        setRightButton(2131367262, this);
        if (AppSetting.j)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131370725));
          this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131370727));
        }
      }
    }
    label420:
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131370726));
      break;
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType != 2)) {
          break label420;
        }
        str = getString(2131370707) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131370703));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        if (!AppSetting.j) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131370725));
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131370703));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131370726));
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131370703));
    } while (!AppSetting.j);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131370725));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getString(2131370703));
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      return true;
    }
    paramBundle = paramBundle.getExtras();
    if (paramBundle == null)
    {
      finish();
      return true;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = paramBundle.getBoolean("from_login");
        this.k = paramBundle.getInt("seq");
        Object localObject = paramBundle.get("DevlockInfo");
        if ((localObject instanceof DevlockInfo)) {
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)localObject);
        }
        this.p = paramBundle.getString("uin");
        this.q = paramBundle.getString("from_where");
        this.r = paramBundle.getString("mainaccount");
        if (QLog.isColorLevel())
        {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.k + " mUin=" + this.p + " mFromWhere=" + this.q + " mMainAccount=" + this.r);
          if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
          {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "onCreate DevlockInfo devSetup:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup + " countryCode:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + " mobile:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AvailableMsgCount + " AllowSet:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.ProtectIntro:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro + "  info.MbGuideType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideMsg:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideInfoType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfoType);
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "DevlockInfo.MbGuideInfo:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
          }
        }
        super.getWindow().setFormat(-3);
        if (this.jdField_a_of_type_Boolean) {
          setTheme(2131559165);
        }
        super.setContentView(2130904154);
        if (this.jdField_a_of_type_Boolean)
        {
          super.setTitle(2131370701);
          this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.app;
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
            this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
          }
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
            break;
          }
          super.finish();
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        finish();
        return true;
      }
      super.setTitle(2131370700);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(LoginActivity.class);
      if (paramBundle != null) {
        paramBundle.sendEmptyMessage(20140107);
      }
      paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(SubLoginActivity.class);
      if (paramBundle != null) {
        paramBundle.sendEmptyMessage(20140107);
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo))) {
        break label786;
      }
      EquipmentLockImpl.a().a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131301585));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131301586));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298640));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131301587));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131301578));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131301588));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      a();
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.k);
      return true;
      label786:
      finish();
      overridePendingTransition(0, 0);
      QQToast.a(this, 1, getString(2131367480), 0).a();
    }
  }
  
  protected boolean isWrapContent()
  {
    return !this.jdField_a_of_type_Boolean;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent(this, AuthDevActivity.class);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramIntent.putExtra("auth_dev_open", true);
        startActivity(paramIntent);
        paramIntent = new Intent();
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent.putExtra("allow_set", true);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        }
        a(-1, paramIntent);
      }
    }
    label667:
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool;
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
                      if (paramInt1 != 1002) {
                        break;
                      }
                    } while (paramInt2 != -1);
                    setResult(paramInt2, paramIntent);
                    finish();
                    return;
                  } while (paramInt1 != 1003);
                  if (paramInt2 != -1) {
                    break;
                  }
                } while ((paramIntent == null) || (paramIntent.getExtras() == null));
                paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
                }
              } while (paramInt1 != 2);
              str = paramIntent.getExtras().getString("resultMobileMask");
              bool = paramIntent.getExtras().getBoolean("resultSetMobile");
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + str + " openSuccess=" + bool);
              }
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
              {
                this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
                {
                  localObject = getString(2131370707) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
                  this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                  this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131370703));
                  this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                  this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
                }
              }
            } while (!bool);
            EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), true);
            Object localObject = new Intent(this, AuthDevActivity.class);
            ((Intent)localObject).putExtra("phone_num", str);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              ((Intent)localObject).putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            String str = paramIntent.getExtras().getString("emergency_phone_mask");
            if (!TextUtils.isEmpty(str))
            {
              paramInt1 = paramIntent.getExtras().getInt("emergency_phone_state");
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.AuthDevUgActivity", 2, "emergency phone:" + str + " state=" + paramInt1);
              }
              DevlockPhoneStatus.a().a(str);
              paramIntent = DevlockPhoneStatus.a();
              if (paramInt1 != 1) {
                break label667;
              }
            }
            for (paramInt1 = DevlockPhoneStatus.f;; paramInt1 = DevlockPhoneStatus.j)
            {
              paramIntent.b(paramInt1);
              ((Intent)localObject).putExtra("auth_dev_open", true);
              startActivity((Intent)localObject);
              QQToast.a(getApplicationContext(), 2, getString(2131370706), 0).b(getTitleBarHeight());
              paramIntent = new Intent();
              paramIntent.putExtra("auth_dev_open", true);
              paramIntent.putExtra("allow_set", true);
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              }
              a(-1, paramIntent);
              return;
            }
          } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
          paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
          }
        } while (paramInt1 != 2);
        paramIntent = paramIntent.getExtras().getString("resultMobileMask");
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
        }
        if (!TextUtils.isEmpty(paramIntent)) {
          EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), null);
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile));
    paramIntent = getString(2131370707) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramIntent);
    this.jdField_b_of_type_AndroidWidgetButton.setText(getString(2131370703));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onBackEvent.cancelVerifyCode mVerifyObserver.seq=");
        if (this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver == null) {
          break label97;
        }
      }
      label97:
      for (int i1 = this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.getSeq();; i1 = 0)
      {
        QLog.d("Q.devlock.AuthDevUgActivity", 2, i1);
        setResult(0);
        EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = null;
        finish();
        overridePendingTransition(0, 2130968593);
        return false;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", false);
    String str = "";
    Object localObject = str;
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
    {
      localObject = str;
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile != null) {
        localObject = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
      }
    }
    localIntent.putExtra("phone_num", (String)localObject);
    a(0, localIntent);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label605:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.sendWirelessMeibaoReq(1);
      if (mAppForground)
      {
        if ((!TextUtils.isEmpty(this.q)) && (this.q.equals("subaccount")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "subaccount enter webview mUin=" + this.p + " mMainAccount=" + this.r);
          }
          if ((TextUtils.isEmpty(this.p)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
          }
          EquipLockWebEntrance.a(this, this.r, this.p, EquipLockWebEntrance.a);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "mainaccount enter webview mUin=" + this.p);
        }
        if ((TextUtils.isEmpty(this.p)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevUgActivity", 2, "mUin is empty.");
        }
        EquipLockWebEntrance.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), this.p, EquipLockWebEntrance.a);
        return;
      }
      EquipLockWebEntrance.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, EquipLockWebEntrance.a);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        if ("com.tencent.mobileqq:openSdk".equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getProcessName())) {}
        for (paramView = new Intent(this, AuthDevVerifyCodeActivity2.class);; paramView = new Intent(this, AuthDevVerifyCodeActivity.class))
        {
          if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
          {
            paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            paramView.putExtra("mobile_type", 0);
          }
          paramView.putExtra("from_login", this.jdField_a_of_type_Boolean);
          paramView.putExtra("uin", this.p);
          paramView.putExtra("seq", this.k);
          startActivityForResult(paramView, 1002);
          return;
        }
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
      {
        ReportController.b(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
        paramView = new Intent(this, AuthDevVerifyCodeActivity.class);
        paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        startActivityForResult(paramView, 1001);
        return;
      }
      EquipLockWebEntrance.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, EquipLockWebEntrance.a, 1003, null);
      return;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder().append("onClick.cancelVerifyCode mVerifyObserver.seq=");
        if (this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver == null) {
          break label605;
        }
      }
      for (int i1 = this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.getSeq();; i1 = 0)
      {
        QLog.d("Q.devlock.AuthDevUgActivity", 2, i1);
        EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = null;
        finish();
        overridePendingTransition(0, 2130968593);
        return;
      }
    } while (!this.jdField_a_of_type_Boolean);
    if ("com.tencent.mobileqq:openSdk".equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getProcessName())) {}
    for (paramView = new Intent(this, AuthDevVerifyCodeActivity2.class);; paramView = new Intent(this, AuthDevVerifyCodeActivity.class))
    {
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.BakMobileState == 2))
      {
        paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.BakMobile);
        paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.BakCountryCode);
        paramView.putExtra("mobile_type", 1);
      }
      paramView.putExtra("from_login", this.jdField_a_of_type_Boolean);
      paramView.putExtra("uin", this.p);
      paramView.putExtra("seq", this.k);
      startActivityForResult(paramView, 1002);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\AuthDevUgActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */