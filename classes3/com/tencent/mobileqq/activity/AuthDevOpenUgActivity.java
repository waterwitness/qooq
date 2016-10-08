package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import klh;
import kli;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthDevOpenUgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 1001;
  public static final String a = "from_login";
  public static final int b = 1002;
  public static final String b = "phone_num";
  public static final int c = 1003;
  public static final String c = "country_code";
  public static final int d = 1004;
  public static final String d = "auth_dev_open";
  public static final String e = "allow_set";
  public static final String f = "user_guide";
  public static final String g = "user_uin";
  public static final String h = "seq";
  public static final String i = "DevlockInfo";
  private static final String j = "Q.devlock.AuthDevOpenUgActivity";
  private static final String k = "UserBehavior";
  private static final String l = "Manually";
  private Button jdField_a_of_type_AndroidWidgetButton;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private int e;
  private int f;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  
  public AuthDevOpenUgActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = true;
    this.jdField_a_of_type_MqqObserverWtloginObserver = new klh(this);
    this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new kli(this);
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      int i1;
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        this.p = paramString.getString("title");
        this.q = paramString.getString("smallTitle");
        this.r = paramString.getString("guideTitle");
        paramString = paramString.getJSONArray("guideArray");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i1 = 0;
          if (i1 < paramString.length())
          {
            str = paramString.getString(i1);
            if (i1 == 0) {
              this.s = str;
            } else if (i1 == 1) {
              this.t = str;
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "parseJson error.");
        }
      }
      return;
      if (i1 == 2) {
        this.u = str;
      } else if (i1 == 3) {
        this.v = str;
      }
      i1 += 1;
    }
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    try
    {
      EquipmentLockImpl.a().a(null, this.app.a(), 3);
      DevlockPhoneStatus localDevlockPhoneStatus = DevlockPhoneStatus.a();
      if ((localDevlockPhoneStatus != null) && (localDevlockPhoneStatus.a() == DevlockPhoneStatus.d))
      {
        String str2 = "";
        String str1 = str2;
        if (paramDevlockInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(paramDevlockInfo.Mobile)) {
            str1 = paramDevlockInfo.Mobile;
          }
        }
        localDevlockPhoneStatus.a(this, str1);
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        if ((paramDevlockInfo == null) || (TextUtils.isEmpty(paramDevlockInfo.Mobile))) {
          break label284;
        }
        if (paramDevlockInfo.AllowSet != 1) {
          break;
        }
      } while (EquipmentLockImpl.a().a(this.app, this.app.a(), "", null, this.jdField_a_of_type_MqqObserverWtloginObserver) == 0);
      QQToast.a(getApplicationContext(), getString(2131370729), 0).b(getTitleBarHeight());
      return;
      Intent localIntent = new Intent(this, AuthDevConfirmPhoneNoActivity.class);
      if (getIntent() != null) {
        localIntent.putExtra("devlock_need_broadcast", getIntent().getExtras().getBoolean("devlock_need_broadcast"));
      }
      localIntent.putExtra("ParaTextUp", this.u);
      localIntent.putExtra("ParaTextDown", this.v);
      localIntent.putExtra("PhoneNO", paramDevlockInfo.Mobile);
      localIntent.putExtra("mainaccount", this.o);
      localIntent.putExtra("uin", this.m);
      localIntent.putExtra("from_where", this.n);
      localIntent.putExtra("DevlockInfo", paramDevlockInfo);
      startActivityForResult(localIntent, 1001);
      overridePendingTransition(0, 2130968592);
      return;
      label284:
      EquipLockWebEntrance.a(this, this.app, EquipLockWebEntrance.c, 1003, null);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = getIntent();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((Intent)localObject1).getExtras();
    } while ((localObject1 == null) || (!((Bundle)localObject1).containsKey("devlock_need_broadcast")) || (!((Bundle)localObject1).getBoolean("devlock_need_broadcast")));
    localObject1 = new Intent();
    ((Intent)localObject1).setAction("mqq.intent.action.DEVLOCK_ROAM");
    ((Intent)localObject1).putExtra("auth_dev_open", paramBoolean);
    ((Intent)localObject1).putExtra("auth_dev_open_cb_reason", paramInt);
    if (paramBoolean)
    {
      Object localObject2 = (WtloginManager)this.app.getManager(1);
      if (localObject2 != null)
      {
        localObject2 = ((WtloginManager)localObject2).GetLocalTicket(this.app.a(), 16L, 33554432);
        if (localObject2 != null) {
          ((Intent)localObject1).putExtra("devlock_roam_sig", ((Ticket)localObject2)._sig);
        }
      }
    }
    sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
  }
  
  private void b(String paramString)
  {
    Object localObject = (TextView)findViewById(2131301577);
    if (TextUtils.isEmpty(paramString))
    {
      ((TextView)localObject).setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidWidgetButton;
      if (TextUtils.isEmpty(this.q)) {
        break label178;
      }
    }
    label178:
    for (paramString = this.q;; paramString = getString(2131370748))
    {
      ((Button)localObject).setText(paramString);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131370703));
      if (!TextUtils.isEmpty(this.r)) {
        setTitle(this.r);
      }
      if (this.f != 0)
      {
        paramString = (ImageView)findViewById(2131301576);
        if (paramString != null) {
          paramString.setImageResource(this.f);
        }
      }
      if (!TextUtils.isEmpty(this.w))
      {
        paramString = (Button)findViewById(2131301579);
        if (paramString != null)
        {
          paramString.setVisibility(0);
          paramString.setText(this.w);
          paramString.setOnClickListener(this);
        }
      }
      EquipmentLockImpl.a().a(null, this.app.a(), 1);
      return;
      ((TextView)localObject).setText(paramString);
      break;
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    if (getIntent().getBooleanExtra("open_devlock_from_roam", false))
    {
      super.finish();
      overridePendingTransition(2130968583, 2130968584);
      return;
    }
    super.finish();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        if ((paramIntent == null) || (paramIntent.getExtras().getInt("requestCode") != 1002)) {
          break label46;
        }
        a(-1, paramIntent);
      }
    }
    label46:
    label723:
    label907:
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
                  a(true, 0);
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
                    a(-1, paramIntent);
                    return;
                    if (this.b)
                    {
                      paramIntent = new Intent(this, AuthDevActivity.class);
                      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                      {
                        paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                        paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                      }
                      if (getIntent() != null) {
                        paramIntent.putExtra("devlock_need_broadcast", getIntent().getExtras().getBoolean("devlock_need_broadcast"));
                      }
                      paramIntent.putExtra("auth_dev_open", true);
                      startActivity(paramIntent);
                    }
                  }
                  if (paramInt1 != 1002) {
                    break;
                  }
                } while (paramInt2 != -1);
                finish();
                return;
                if (paramInt1 != 1003) {
                  break label907;
                }
                if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
                  break;
                }
                paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
                }
              } while (paramInt1 != 2);
              localObject = paramIntent.getExtras().getString("resultMobileMask");
              bool = paramIntent.getExtras().getBoolean("resultSetMobile");
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + (String)localObject + " openSuccess=" + bool);
              }
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = ((String)localObject);
              }
            } while (!bool);
            EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
            a(true, 0);
            boolean bool = EquipmentLockImpl.a().a();
            Object localObject = new Intent(getIntent());
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
                QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "emergency phone:" + str + " state=" + paramInt1);
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
                break label723;
              }
              ((Intent)localObject).setClass(this, AuthDevEnableCompleteActivity.class);
              startActivity((Intent)localObject);
            }
            for (;;)
            {
              QQToast.a(getApplicationContext(), 2, getString(2131370706), 0).b(getTitleBarHeight());
              paramIntent = new Intent();
              paramIntent.putExtra("auth_dev_open", true);
              paramIntent.putExtra("allow_set", true);
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              }
              a(-1, paramIntent);
              return;
              paramInt1 = DevlockPhoneStatus.j;
              break;
              if (this.b)
              {
                ((Intent)localObject).setClass(this, AuthDevActivity.class);
                ((Intent)localObject).putExtra("auth_dev_open", true);
                startActivity((Intent)localObject);
              }
            }
          } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
          paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
          }
        } while (paramInt1 != 2);
        paramIntent = paramIntent.getExtras().getString("resultMobileMask");
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
        }
        if (!TextUtils.isEmpty(paramIntent)) {
          EquipmentLockImpl.a().a(this.app, this.app.a(), null);
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
      return;
    } while (paramInt1 != 1004);
    if (paramInt2 == 3000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "verify passwd failed");
      }
      a(false, 3);
      super.finish();
      overridePendingTransition(2130968583, 2130968584);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "verify passwd succ");
    }
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
    {
      EquipmentLockImpl.a().a(this.app, this.app.a(), this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
    }
    a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject = super.getIntent();
    if (localObject == null)
    {
      super.doOnCreate(paramBundle);
      finish();
      return false;
    }
    Bundle localBundle = ((Intent)localObject).getExtras();
    if (localBundle == null)
    {
      super.doOnCreate(paramBundle);
      finish();
      return false;
    }
    EquipmentLockImpl.a().a(false);
    localObject = localBundle.getString("devlock_open_source");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "Manually";
    }
    for (;;)
    {
      EquipmentLockImpl.a().a((String)localObject);
      this.jdField_a_of_type_Boolean = localBundle.getBoolean("from_login");
      this.e = localBundle.getInt("seq");
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)localBundle.get("DevlockInfo"));
      this.m = localBundle.getString("uin");
      this.n = localBundle.getString("from_where");
      this.o = localBundle.getString("mainaccount");
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.e + " mUin=" + this.m + " mFromWhere=" + this.n + " mMainAccount=" + this.o);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onCreate DevlockInfo devSetup:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup + " countryCode:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + " mobile:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AvailableMsgCount + " AllowSet:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.ProtectIntro:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro + "  info.MbGuideType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideMsg:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideInfoType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfoType);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideInfo:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
        }
      }
      super.doOnCreate(paramBundle);
      super.setContentView(2130904150);
      super.setTitle(2131370700);
      if (this.app == null) {
        this.app = ((QQAppInterface)getAppRuntime());
      }
      if (this.app == null)
      {
        super.doOnCreate(paramBundle);
        finish();
        return false;
      }
      if (TextUtils.equals((CharSequence)localObject, "PhoneUnity")) {
        this.leftView.setText(2131370946);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131301578));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.b = localBundle.getBoolean("devlock_show_auth_dev_list", true);
      paramBundle = localBundle.getString("devlock_guide_config");
      if (!TextUtils.isEmpty(paramBundle)) {}
      for (;;)
      {
        try
        {
          paramBundle = new JSONObject(paramBundle);
          this.r = paramBundle.getString("title");
          this.p = paramBundle.getString("wording");
          this.f = paramBundle.getInt("image_res_id");
          this.q = paramBundle.getString("btn_text");
          this.w = paramBundle.getString("jump_text");
          if (TextUtils.isEmpty(this.p)) {
            this.p = getString(2131370761);
          }
          if (TextUtils.isEmpty(this.s)) {
            this.s = getString(2131370750);
          }
          if (TextUtils.isEmpty(this.t)) {
            this.t = getString(2131370751);
          }
          if (TextUtils.isEmpty(this.u)) {
            this.u = getString(2131370754);
          }
          if (TextUtils.isEmpty(this.v)) {
            this.v = getString(2131370755);
          }
          if (TextUtils.isEmpty(this.r)) {
            this.r = getString(2131370749);
          }
          b(this.p);
          this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.e);
          return true;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          continue;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro);
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected boolean onBackEvent()
  {
    a(false, 1);
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", false);
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))) {
      localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
    }
    a(0, localIntent);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301587: 
      if (this.app != null) {
        this.app.sendWirelessMeibaoReq(1);
      }
      if (mAppForground)
      {
        if ((!TextUtils.isEmpty(this.n)) && (this.n.equals("subaccount")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "subaccount enter webview mUin=" + this.m + " mMainAccount=" + this.o);
          }
          if ((TextUtils.isEmpty(this.m)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mUin is empty.");
          }
          EquipLockWebEntrance.a(this, this.o, this.m, EquipLockWebEntrance.a);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mainaccount enter webview mUin=" + this.m);
        }
        if ((TextUtils.isEmpty(this.m)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mUin is empty.");
        }
        EquipLockWebEntrance.a(this, this.m, this.m, EquipLockWebEntrance.a);
        return;
      }
      EquipLockWebEntrance.a(this, this.app, EquipLockWebEntrance.a);
      return;
    case 2131301578: 
      if (getIntent().getBooleanExtra("open_devlock_verify_passwd", false))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "http://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "open_devlock"));
        startActivityForResult(paramView, 1004);
      }
      for (;;)
      {
        paramView = getIntent().getStringExtra("devlock_open_source");
        if ((TextUtils.isEmpty(paramView)) || ((!paramView.equals("RoamMsg")) && (!paramView.equals("RoamMsgWeb")))) {
          break;
        }
        VipUtils.a(this.app, "chat_history", "LockSet", "Clk_buttonUse", 1, 0, new String[0]);
        return;
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) {
          EquipmentLockImpl.a().a(this.app, this.app.a(), this.jdField_a_of_type_MqqObserverWtloginObserver);
        } else {
          a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        }
      }
    case 2131297183: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onClick.cancelVerifyCode mVerifyObserver.seq=" + this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.getSeq());
      }
      EquipmentLockImpl.a().a(this.app, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = null;
      finish();
      overridePendingTransition(0, 2130968593);
    }
    a(false, 2);
    super.finish();
    overridePendingTransition(2130968583, 2130968584);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\AuthDevOpenUgActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */