package com.tencent.mobileqq.activity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;
import lwk;
import lwm;
import lwn;
import lwo;
import lwp;
import lwq;
import lwr;
import lws;
import lwt;
import lwu;
import lwv;
import lww;
import lwx;
import lwy;
import lwz;
import lxa;
import lxb;
import lxd;
import lxe;
import lxf;
import lxg;
import lxh;
import lxi;
import lxl;
import lxm;
import mqq.app.Constants.LogoutReason;
import org.json.JSONObject;

public class NotificationActivity
  extends BaseActivity
{
  public static final int a = 1;
  public static NotificationActivity a;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  private static final String e = "sec_sig_tag";
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 10;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  String jdField_a_of_type_JavaLangString;
  private Constants.LogoutReason jdField_a_of_type_MqqAppConstants$LogoutReason;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String b;
  private String c;
  private String d;
  private int k;
  private int l;
  private final int m;
  
  public NotificationActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "http://fwd.z.qq.com:8080/forward.jsp?bid=906";
    this.d = "";
    this.jdField_a_of_type_MqqAppConstants$LogoutReason = Constants.LogoutReason.tips;
    this.m = 1;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new lxg(this);
  }
  
  private Dialog a()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
    localAlertDialog.show();
    Object localObject = localAlertDialog.getWindow();
    ((Window)localObject).setContentView(2130903421);
    Button localButton1 = (Button)((Window)localObject).findViewById(2131298535);
    Button localButton2 = (Button)((Window)localObject).findViewById(2131298534);
    localObject = (TextView)((Window)localObject).findViewById(2131298529);
    if ((localButton1 == null) || (localObject == null)) {
      return null;
    }
    ((TextView)localObject).setText(getString(2131369247) + "6.5.5" + getString(2131369248));
    localButton1.setOnClickListener(new lxb(this));
    localButton2.setOnClickListener(new lxd(this));
    return localAlertDialog;
  }
  
  private void a(int paramInt)
  {
    int i1 = 1;
    int n = -1;
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppDialog = null;
    label400:
    int i2;
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        sendBroadcast(new Intent("before_account_change"));
        if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!isFinishing()))
        {
          this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        return;
        this.b = getString(2131368060);
        this.c = getString(2131368062);
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(17039370, new lxh(this));
        continue;
        TextView localTextView = new TextView(this);
        localTextView.setLinksClickable(true);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localTextView.setTextSize(getResources().getInteger(2131623938));
        localTextView.setTextColor(getResources().getColor(2131427355));
        if ((this.b != null) && (this.b.equals("true"))) {}
        for (;;)
        {
          try
          {
            String str1 = getPackageName();
            localTextView.setText(this.c);
            this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage(this.c).addView(localTextView).setPositiveButton(2131371641, new lxi(this, str1), false);
            paramInt = i1;
            if (paramInt != 0) {
              break;
            }
            if (TextUtils.isEmpty(this.c)) {
              break label400;
            }
            localTextView.setText(Html.fromHtml(this.c));
            this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage(this.c).addView(localTextView).setPositiveButton(2131367774, new lxl(this));
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
          paramInt = 0;
          continue;
          localTextView.setText(Html.fromHtml(getString(2131367485)));
        }
        try
        {
          this.jdField_a_of_type_AndroidAppDialog = a();
        }
        catch (Exception localException1)
        {
          a();
        }
      }
    case 5: 
      if (QQPlayerService.a()) {
        sendBroadcast(new Intent("qqplayer_exit_action"));
      }
      paramInt = 2131367263;
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason != Constants.LogoutReason.kicked) {
        paramInt = 2131370692;
      }
      if (this.c != null)
      {
        i2 = this.c.indexOf("http://110.qq.com/");
        i1 = i2;
        if (i2 > 0) {
          n = "http://110.qq.com/".length() + i2;
        }
      }
      break;
    }
    for (i1 = i2;; i1 = -1)
    {
      if (this.c != null) {}
      for (Object localObject1 = this.c;; localObject1 = "")
      {
        localObject1 = new SpannableString((CharSequence)localObject1);
        if ((i1 > 0) && (n > i1)) {
          ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(getResources().getColor(2131427451)), i1, n, 33);
        }
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage((CharSequence)localObject1).setNegativeButton(paramInt, new lxm(this));
        if (this.jdField_a_of_type_MqqAppConstants$LogoutReason == Constants.LogoutReason.kicked) {
          break;
        }
        ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131367502, new lwm(this));
        break;
      }
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(17039370, new lwn(this));
      break;
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(17039370, new lwo(this));
      break;
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(getString(2131369343)).setMessage(getString(2131369346)).setPositiveButton(getString(2131369344), new lwq(this)).setNegativeButton(getString(2131369345), new lwp(this));
      break;
      if (this.l == 40)
      {
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(getActivity(), 231, getString(2131370678), this.c, 2131370677, 2131370676, new lwr(this), new lws(this));
        break;
      }
      switch (this.l)
      {
      default: 
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.b(this, 230).setMessageWithUrl(this.c).setTitle(getString(2131368142)).setPositiveButton(17039370, new lwv(this));
        break;
      case 41: 
      case 116: 
        if (this.l == 41) {}
        for (localObject1 = getString(2131369347);; localObject1 = getString(2131369348))
        {
          str2 = getString(2131369357);
          this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setMessage((CharSequence)localObject1).setTitle(str2).setNegativeButton(2131369349, new lwu(this)).setPositiveButton(2131369350, new lwt(this));
          break;
        }
        Object localObject2 = getIntent().getExtras();
        localObject1 = ((Bundle)localObject2).getString("dlg_title");
        String str2 = ((Bundle)localObject2).getString("dlg_content");
        String str3 = ((Bundle)localObject2).getString("dlg_lbutton");
        String str4 = ((Bundle)localObject2).getString("dlg_rbutton");
        localObject2 = ((Bundle)localObject2).getString("dlg_url");
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str2).setPositiveButton(str4, new lwy(this, (String)localObject2)).setNegativeButton(str3, new lwx(this));
        break;
        localObject1 = getResources().getString(2131371161);
        str2 = getResources().getString(2131371162);
        str3 = getResources().getString(2131371165);
        str4 = getResources().getString(2131371164);
        Object localObject3 = getResources().getString(2131371163);
        localObject2 = new CheckBox(this);
        ((CheckBox)localObject2).setText((CharSequence)localObject3);
        ((CheckBox)localObject2).setTextSize(getResources().getInteger(2131623938));
        ((CheckBox)localObject2).setTextColor(getResources().getColor(2131427355));
        localObject3 = this.app.a().getSharedPreferences(this.app.getAccount(), 0);
        boolean bool = ((SharedPreferences)localObject3).getBoolean("MemoryAlertAutoClear", false);
        ((CheckBox)localObject2).setChecked(bool);
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle((String)localObject1).setMessage(str2).setView((View)localObject2).setPositiveButton(str4, new lxa(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3)).setNegativeButton(str3, new lwz(this, (CheckBox)localObject2, bool, (SharedPreferences)localObject3));
        break;
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "send broadcast:NewIntent.ACTION_ACCOUNT_KICKED");
    }
    Intent localIntent = new Intent();
    if (localIntent != null)
    {
      localIntent.setAction("mqq.intent.action.ACCOUNT_KICKED");
      this.app.a().sendBroadcast(localIntent);
    }
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != 41) && (paramInt != 116)) {
      return;
    }
    Object localObject;
    Intent localIntent;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      localObject = "http://haoma.qq.com/m/expire.html?num=" + this.d;
      localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      startActivity(localIntent);
      finish();
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("unit", "月");
        ((JSONObject)localObject).put("userId", this.d);
        ((JSONObject)localObject).put("openMonth", "3");
        ((JSONObject)localObject).put("offerId", "1450000833");
        ((JSONObject)localObject).put("aid", "mvip.gongneng.android.haoma_03");
        ((JSONObject)localObject).put("ticketValue", SecUtil.toHexString(this.jdField_a_of_type_ArrayOfByte));
        ((JSONObject)localObject).put("ticketName", "vask_27");
        switch (paramInt)
        {
        case 41: 
          localIntent = new Intent(this, PayBridgeActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putString("json", ((JSONObject)localObject).toString());
          localBundle.putString("callbackSn", "0");
          localIntent.putExtras(localBundle);
          localIntent.putExtra("payparmas_from_is_login_state", false);
          localIntent.putExtra("pay_requestcode", 4);
          startActivityForResult(localIntent, 1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        finish();
        return;
      }
      localException.put("serviceCode", "LTMCLUB");
      localException.put("serviceName", "QQ会员");
      continue;
      localException.put("serviceCode", "CJCLUBT");
      localException.put("serviceName", "QQ超级会员");
    }
  }
  
  private void c()
  {
    ConfigHandler localConfigHandler = (ConfigHandler)this.app.a(4);
    if (localConfigHandler != null) {
      localConfigHandler.a();
    }
  }
  
  public void a()
  {
    sendBroadcast(new Intent("qqplayer_exit_action"));
    finish();
    this.app.b(false);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903420);
    Object localObject = "";
    paramBundle = (Bundle)localObject;
    try
    {
      this.k = getIntent().getIntExtra("type", 0);
      paramBundle = (Bundle)localObject;
      localObject = getIntent().getAction();
      paramBundle = (Bundle)localObject;
      if (QLog.isColorLevel())
      {
        paramBundle = (Bundle)localObject;
        QLog.d("NotificationActivity", 2, "NotificationActivity action = " + (String)localObject);
      }
      paramBundle = (Bundle)localObject;
      if (!"mqq.intent.action.ACCOUNT_EXPIRED".equals(localObject)) {
        break label318;
      }
      paramBundle = (Bundle)localObject;
      this.k = 1;
      paramBundle = (Bundle)localObject;
      c();
    }
    catch (Exception localException)
    {
      try
      {
        do
        {
          for (;;)
          {
            String str;
            paramBundle.mergeFrom((byte[])localObject);
            if (paramBundle.has()) {
              break label454;
            }
            return false;
            paramBundle = (Bundle)localObject;
            if ("mqq.intent.action.ACCOUNT_TIPS".equals(localObject))
            {
              paramBundle = (Bundle)localObject;
              this.k = 6;
              continue;
              localException = localException;
              localObject = paramBundle;
              paramBundle = (Bundle)localObject;
              if (QLog.isColorLevel())
              {
                QLog.e("NotificationActivity", 2, "doOnCreate exception", localException);
                paramBundle = (Bundle)localObject;
              }
            }
            else
            {
              paramBundle = (Bundle)localObject;
              if ("mqq.intent.action.ACCOUNT_KICKED".equals(localObject))
              {
                paramBundle = (Bundle)localObject;
                b();
                paramBundle = (Bundle)localObject;
                c();
                paramBundle = (Bundle)localObject;
                this.k = 5;
              }
              else
              {
                paramBundle = (Bundle)localObject;
                if (!"mqq.intent.action.GRAY".equals(localObject)) {
                  break;
                }
                paramBundle = (Bundle)localObject;
                this.k = 2;
              }
            }
          }
          paramBundle = (Bundle)localObject;
        } while (!"mqq.intent.action.SUSPEND".equals(localObject));
        paramBundle = (Bundle)localObject;
        this.k = 4;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if ((paramBundle.str_left_button.has()) && (paramBundle.str_packname.has()) && (paramBundle.u32_check_result.has()) && (paramBundle.str_right_button.has()) && (paramBundle.str_url.has())) {
          break label521;
        }
        if (!QLog.isColorLevel()) {
          break label519;
        }
        QLog.d("sec_sig_tag", 2, "NotificationActivity:package fail");
        return false;
        ThreadManager.a(new lww(this, paramBundle.u32_check_result.get()), 5, null, false);
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230).setTitle(this.b).setMessage(this.c).setPositiveButton(paramBundle.str_right_button.get(), new lxf(this, paramBundle)).setNegativeButton(paramBundle.str_left_button.get(), new lxe(this));
        if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing()) || (isFinishing())) {
          break label643;
        }
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.show();
        return true;
      }
    }
    paramBundle = (Bundle)localObject;
    this.b = getIntent().getStringExtra("title");
    paramBundle = (Bundle)localObject;
    this.c = getIntent().getStringExtra("msg");
    paramBundle = (Bundle)localObject;
    this.d = getIntent().getStringExtra("loginalias");
    paramBundle = (Bundle)localObject;
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("expiredSig");
    paramBundle = (Bundle)localObject;
    this.l = getIntent().getIntExtra("loginret", 0);
    paramBundle = (Bundle)localObject;
    this.jdField_a_of_type_MqqAppConstants$LogoutReason = ((Constants.LogoutReason)getIntent().getSerializableExtra("reason"));
    paramBundle = (Bundle)localObject;
    str = getIntent().getStringExtra("securityScan");
    if (str != null)
    {
      paramBundle = (Bundle)localObject;
      if ("security_scan".equals(str))
      {
        paramBundle = (Bundle)localObject;
        this.k = 7;
      }
    }
    paramBundle = (Bundle)localObject;
    if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramBundle))
    {
      if (this.jdField_a_of_type_MqqAppConstants$LogoutReason == Constants.LogoutReason.secKicked)
      {
        if (QLog.isColorLevel()) {
          QLog.d("sec_sig_tag", 2, "NotificationActivity:sec kick");
        }
        localObject = getIntent().getByteArrayExtra("data");
        paramBundle = new signature.SignatureKickData();
      }
      label318:
      label454:
      label519:
      label521:
      label643:
      PatternLockUtils.d(this, this.app.getAccount(), true);
    }
    a(this.k);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.closeNotification"));
    return false;
  }
  
  protected void doOnDestroy()
  {
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
      super.doOnDestroy();
      if (jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity == this) {
        jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
      }
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
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      ((QQCustomDialog)this.jdField_a_of_type_AndroidAppDialog).setPositiveButton(2131371642, new lwk(this));
    }
  }
  
  protected void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
    if (this.k == 3) {
      a();
    }
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_AndroidAppDialog = null;
    super.finish();
    if (jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity == this) {
      jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = null;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity = this;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\NotificationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */