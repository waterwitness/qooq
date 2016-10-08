package com.tencent.open.agent;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRLoginActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.OpenConst;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountManage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import wrl;
import wrm;
import wrn;
import wro;
import wrp;

public class QuickLoginAuthorityActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, OpenConst, HttpImageDownloadAsyncTask.TaskCompleteCallback
{
  protected static final String[] a;
  protected static final int b = 50;
  public static final String b = "packagename";
  protected static final int c = 20;
  public static final String c = "isLogin";
  protected static final int d = 100;
  public static final String d = "Q.quicklogin.";
  protected static final int e = 100;
  public static final String e = "QuickLoginAuthorityActivity";
  protected static final int f = 1000;
  protected static final int g = 1001;
  protected static final int h = 1002;
  protected static final int i = 1003;
  protected float a;
  protected ProgressDialog a;
  protected SharedPreferences a;
  public Bundle a;
  protected Handler a;
  protected Button a;
  public CardContainer a;
  public OpenSDKAppInterface a;
  protected ArrayList a;
  protected List a;
  public WtloginManager a;
  protected SSOAccountObserver a;
  private WtloginObserver a;
  protected boolean a;
  public byte[] a;
  public Handler b;
  private byte[] b;
  public String f;
  protected String g;
  protected String h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "http://ptlogin2.qq.com", "http://ptlogin2.soso.com", "http://ptlogin2.paipai.com", "http://ptlogin2.tenpay.com", "http://ptlogin2.taotao.com", "http://ptlogin2.tencent.com", "http://ptlogin2.oa.com", "http://ptlogin2.webdev.com", "http://ptlogin2.3366.com", "http://ptlogin2.imqq.com", "http://ptlogin2.pengyou.com", "http://ptlogin2.qplus.com", "http://ptlogin2.qzone.com", "http://ptlogin2.id.qq.com", "http://ptlogin2.myapp.com", "http://ptlogin2.kuyoo.cn", "http://ptlogin2.function.qq.com", "http://ptlogin2.crm2.qq.com", "http://ptlogin2.weiyun.com", "http://ptlogin2.wechatapp.com", "http://ptlogin2.51buy.com", "http://ptlogin2.qcloud.com", "http://ptlogin2.wechat.com", "http://ptlogin2.qmail.com", "http://ptlogin2.ejinshang.com", "http://ptlogin2.lvren.com", "http://ptlogin2.weishi.com", "https://ssl.ptlogin2.qq.com", "https://ssl.ptlogin2.tenpay.com", "https://ssl.ptlogin2.paipai.com", "https://ssl.ptlogin2.soso.com", "https://ssl.ptlogin2.3366.com", "https://ssl.ptlogin2.pengyou.com", "https://ssl.ptlogin2.imqq.com", "https://ssl.ptlogin2.qzone.com", "https://ssl.ptlogin2.qcloud.com", "https://ssl.ptlogin2.51buy.com", "https://ssl.ptlogin2.weiyun.com", "https://ssl.ptlogin2.myapp.com", "https://ssl.ptlogin2.yixun.com", "https://ssl.ptlogin2.wanggou.com", "https://ssl.ptlogin2.ejinshang.com" };
  }
  
  public QuickLoginAuthorityActivity()
  {
    this.jdField_a_of_type_MqqObserverSSOAccountObserver = new wrl(this);
    this.jdField_a_of_type_MqqObserverWtloginObserver = new wrm(this);
    this.jdField_a_of_type_AndroidOsHandler = new wrn(this, ThreadManager.b());
    this.jdField_b_of_type_AndroidOsHandler = new wro(this, Looper.getMainLooper());
  }
  
  private int a()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("qrcode");
    int j = str.indexOf("?k=") + 3;
    str = str.substring(j, j + 32);
    this.jdField_b_of_type_ArrayOfByte = QRLoginActivity.a(str.getBytes(), str.length());
    return this.jdField_a_of_type_MqqManagerWtloginManager.VerifyCode(this.f, 16L, true, this.jdField_b_of_type_ArrayOfByte, null, 1, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  private Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    try
    {
      paramString = new URL(paramString);
      paramString = paramString.getQuery();
      if (TextUtils.isEmpty(paramString)) {
        return localBundle;
      }
    }
    catch (MalformedURLException paramString)
    {
      return localBundle;
    }
    paramString = paramString.split("&");
    int j = 0;
    while (j < paramString.length)
    {
      Object localObject = paramString[j];
      int k = ((String)localObject).indexOf('=');
      if (k > 0) {
        localBundle.putString(((String)localObject).substring(0, k), ((String)localObject).substring(k + 1, ((String)localObject).length()));
      }
      j += 1;
    }
    return localBundle;
  }
  
  protected void a()
  {
    if (Build.VERSION.SDK_INT > 10) {}
    for (int j = 4;; j = 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = super.getSharedPreferences("accountList", j);
      this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
      e();
      return;
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("quicklogin_errmsg", paramString2);
    localIntent.putExtra("quicklogin_uin", paramString1);
    localIntent.putExtra("quicklogin_ret", paramInt);
    localIntent.putExtra("quicklogin_buff", paramArrayOfByte);
    super.setResult(-1, localIntent);
    g();
    super.finish();
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "setSdkResult:error:" + paramString2);
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      super.setResult(0);
    }
    for (;;)
    {
      super.finish();
      return;
      super.setResult(0, paramIntent);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "-->showLoginActivity--uin = *" + AuthorityUtil.a(paramString));
    }
    Intent localIntent = new Intent(this, Login.class);
    if (paramString != null) {
      localIntent.putExtra("param_uin", paramString);
    }
    if (this.jdField_a_of_type_Boolean) {
      localIntent.putExtra("key_req_src", 3);
    }
    for (;;)
    {
      super.startActivityForResult(localIntent, 1);
      return;
      localIntent.putExtra("key_req_src", 2);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("-->onTaskCompleted--identifier = ").append(paramString).append("bitmap = null ? ");
      if (paramBitmap != null) {
        break label77;
      }
    }
    label77:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.quicklogin.", 2, bool);
      if (paramString.equals(this.f)) {
        runOnUiThread(new wrp(this, paramBitmap));
      }
      return;
    }
  }
  
  protected boolean a(Bundle paramBundle)
  {
    if ((super.getIntent() == null) || (paramBundle != null)) {}
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
              return false;
              this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
            } while (this.jdField_a_of_type_AndroidOsBundle == null);
            paramBundle = super.getIntent().getStringExtra("key_action");
            if (("action_ptlogin_login".equals(paramBundle)) || ("action_quick_login".equals(paramBundle))) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.quicklogin.", 2, "invalid action! " + paramBundle);
          return false;
          this.jdField_a_of_type_Boolean = "action_ptlogin_login".equals(paramBundle);
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("qrcode")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("schemacallback"))) {
            return true;
          }
        } while (!this.jdField_a_of_type_AndroidOsBundle.containsKey("p"));
        paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("p");
        if (!TextUtils.isEmpty(paramBundle))
        {
          String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
          int k = arrayOfString.length;
          int j = 0;
          while (j < k)
          {
            if (paramBundle.startsWith(arrayOfString[j])) {
              return true;
            }
            j += 1;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.quicklogin.", 2, "invalid path! " + paramBundle);
      return false;
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("publickey");
      this.h = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (!TextUtils.isEmpty(this.h)) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstSsoVer")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("subDstAppid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstAppid")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("dstAppVer"))) {
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.quicklogin.", 2, "invalid parameters! " + this.jdField_a_of_type_AndroidOsBundle.toString());
    return false;
  }
  
  protected void b()
  {
    c();
  }
  
  protected void b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {
      return;
    }
    Object localObject1 = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject1);
    Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (localObject2 = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(paramString, (int)(58.0F * this.jdField_a_of_type_Float), true);; localObject2 = null)
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramString, (String)localObject1, (Bitmap)localObject2, true);
      if (localObject2 != null)
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 1000;
        ((Message)localObject1).obj = localObject2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      }
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("packagename");
      if (this.jdField_a_of_type_Boolean)
      {
        Bundle localBundle = a(this.jdField_a_of_type_AndroidOsBundle.getString("p"));
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("appname");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localBundle.getString("pt_appname");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 20) {
            localObject2 = ((String)localObject1).substring(0, 20);
          }
          this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a((String)localObject2, null);
        }
        localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("package");
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = localBundle.getString("pt_package");
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 100) {
            localObject1 = ((String)localObject2).substring(0, 100);
          }
        }
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      try
      {
        localObject2 = WtloginHelper.GetFastLoginUrl((String)localObject1, Long.valueOf(Long.parseLong(paramString)).longValue());
        if (localObject2 == null) {
          break;
        }
        if (!TextUtils.isEmpty(((WFastLoginInfo)localObject2).iconUrl))
        {
          paramString = Message.obtain();
          paramString.what = 1001;
          paramString.obj = ((WFastLoginInfo)localObject2).iconUrl;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        }
        if (!this.jdField_a_of_type_Boolean) {}
        try
        {
          paramString = super.getPackageManager();
        }
        catch (PackageManager.NameNotFoundException paramString)
        {
          for (;;)
          {
            label374:
            paramString = null;
            localObject1 = null;
          }
        }
        try
        {
          localObject1 = paramString.getApplicationInfo((String)localObject1, 0);
          if (localObject1 == null) {
            continue;
          }
          paramString = (String)paramString.getApplicationLabel((ApplicationInfo)localObject1);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          continue;
          paramString = "";
          break label374;
        }
        if (!TextUtils.isEmpty(paramString)) {
          this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(paramString, null);
        }
        if (TextUtils.isEmpty(((WFastLoginInfo)localObject2).adUrl)) {
          break;
        }
        paramString = new StringBuffer(((WFastLoginInfo)localObject2).adUrl);
        this.jdField_a_of_type_ComTencentOpenAgentCardContainer.setAdImageByURL(null, paramString.replace(0, 4, "gamead").toString());
        return;
      }
      catch (NumberFormatException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.quicklogin.", 2, "Long.parseLong(uin) has NumberFormatException" + paramString.getMessage());
          }
          localObject2 = null;
        }
      }
    }
  }
  
  protected void c()
  {
    if (TextUtils.isEmpty(this.f)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "updatePortrait");
    }
    String str = ((TicketManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(2)).getSkey(this.f);
    AvatarUpdateService.a().a(this, this.f, str, this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b(this.f), this);
  }
  
  protected void c(String paramString)
  {
    Object localObject2 = new ArrayList();
    if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {}
    for (Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");; localObject1 = null)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        int k = localObject1.length;
        int j = 0;
        while (j < k)
        {
          localObject3 = localObject1[j];
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((ArrayList)localObject2).add(localObject3);
          }
          j += 1;
        }
      }
      if (!((ArrayList)localObject2).contains(paramString)) {
        ((ArrayList)localObject2).add(paramString);
      }
      for (;;)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + "," + (String)localObject3) {
          localObject3 = (String)((Iterator)localObject2).next();
        }
        ((ArrayList)localObject2).remove(paramString);
        ((ArrayList)localObject2).add(paramString);
      }
      localObject2 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject2).putString("last_account", paramString);
      ((SharedPreferences.Editor)localObject2).putString("accList", (String)localObject1);
      ((SharedPreferences.Editor)localObject2).commit();
      return;
    }
  }
  
  protected void d()
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      j = this.jdField_a_of_type_JavaUtilList.size();
    }
    if (j > 1)
    {
      Intent localIntent = new Intent(this, SwitchAccountActivity.class);
      if (this.f != null) {
        localIntent.putExtra("param_uin", this.f);
      }
      if (this.jdField_a_of_type_Boolean) {
        localIntent.putExtra("key_req_src", 3);
      }
      for (;;)
      {
        super.startActivityForResult(localIntent, 1);
        return;
        localIntent.putExtra("key_req_src", 2);
      }
    }
    a(this.f);
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface == null)
    {
      d();
      return;
    }
    if (!TextUtils.isEmpty(this.g))
    {
      this.f = this.g;
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.", 2, "login mAccountString :" + this.g);
      }
    }
    b(this.f);
    if (!TextUtils.isEmpty(this.f))
    {
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.f, 16)) {
          bool = true;
        }
      }
      while (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.", 2, "login have");
        }
        b();
        return;
        bool = false;
        continue;
        bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.f, 16L);
      }
      d();
      QQToast.a(BaseApplicationImpl.getContext(), 2131369841, 0).b(getResources().getDimensionPixelSize(2131492908));
      return;
    }
    d();
  }
  
  public void f()
  {
    super.setResult(-1, new Intent());
    g();
    super.finish();
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "setPtloginSdkResult:");
    }
  }
  
  public void g()
  {
    if ((!super.isFinishing()) && (this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void h()
  {
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage(super.getString(2131369838));
    if (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "doAuthorize");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("qrcode")) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("schemacallback"))) {
        if (this.f.equals(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) {
          a();
        }
      }
      while (!this.jdField_a_of_type_AndroidOsBundle.containsKey("p"))
      {
        return;
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.f, 32, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
        return;
      }
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetTicketNoPasswd(this.f, 32, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
      return;
    }
    long l1 = this.jdField_a_of_type_AndroidOsBundle.getLong("dstSsoVer", 0L);
    long l2 = this.jdField_a_of_type_AndroidOsBundle.getLong("subDstAppid", 0L);
    long l3 = this.jdField_a_of_type_AndroidOsBundle.getLong("dstAppid", 0L);
    byte[] arrayOfByte1 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("dstAppVer");
    byte[] arrayOfByte2 = this.jdField_a_of_type_MqqManagerWtloginManager.getPkgSigFromApkName(this, this.h);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.ssoGetA1WithA1(this.f, this.h.getBytes(), l1, l3, l2, arrayOfByte1, arrayOfByte2, this.jdField_a_of_type_MqqObserverSSOAccountObserver);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onActivityResult: resultcode:").append(paramInt2).append("requestCode:").append(paramInt1).append("data null?");
      if (paramIntent == null)
      {
        bool = true;
        QLog.d("Q.quicklogin.", 2, bool);
      }
    }
    else
    {
      if (paramInt1 != 100) {
        break label107;
      }
      if (paramInt2 != -1) {
        break label101;
      }
      if (paramIntent != null) {
        this.g = paramIntent.getStringExtra("uin");
      }
      a();
    }
    label101:
    label107:
    label128:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        a(null);
        return;
        g();
        if (paramInt2 != 0) {
          break label128;
        }
      } while (this.f != null);
      a(paramIntent);
      return;
    } while ((-1 != paramInt2) || (paramIntent == null));
    this.f = paramIntent.getStringExtra("last_account");
    boolean bool = paramIntent.getBooleanExtra("isLogin", false);
    Object localObject = new WloginSimpleInfo();
    if (this.jdField_a_of_type_MqqManagerWtloginManager != null) {
      this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.f, (WloginSimpleInfo)localObject);
    }
    for (paramIntent = new String(((WloginSimpleInfo)localObject)._nick);; paramIntent = paramIntent.getStringExtra("nick"))
    {
      this.jdField_a_of_type_ComTencentOpenAgentCardContainer.a(this.f, paramIntent, null, true);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.quicklogin.", 2, "isLogin:" + bool);
        }
        c(this.f);
      }
      h();
      return;
    }
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.quicklogin.", 2, "onBackPressed");
    }
    a(null);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_MqqManagerWtloginManager == null) {}
    do
    {
      return;
      if (paramView == this.leftView)
      {
        a(null);
        return;
      }
      if (paramView == this.rightViewText)
      {
        ReportCenter.a().a(this.f, "", "", "1000", "200", "0", false);
        d();
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetButton);
    if (!NetworkUtil.h(this))
    {
      g();
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this, getResources().getString(2131369830));
      return;
    }
    boolean bool;
    if (this.jdField_a_of_type_Boolean) {
      if (!this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(this.f, 16)) {
        bool = true;
      }
    }
    while (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.", 2, "onClick login have");
      }
      h();
      return;
      bool = false;
      continue;
      bool = this.jdField_a_of_type_MqqManagerWtloginManager.IsUserHaveA1(this.f, 16L);
    }
    d();
    QQToast.a(BaseApplicationImpl.getContext(), 2131369841, 0).b(super.getResources().getDimensionPixelSize(2131492908));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)super.getAppRuntime());
    if (!a(paramBundle))
    {
      QQToast.a(BaseApplicationImpl.getContext(), "参数错误", 0).a();
      a(null);
      return;
    }
    super.setContentView(2130903512);
    this.leftView.setText(2131369828);
    super.setTitle(2131369823);
    this.leftView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298890));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    setRightButton(2131369821, this);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentOpenAgentCardContainer = ((CardContainer)super.findViewById(2131298889));
    this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this);
    this.jdField_a_of_type_AndroidAppProgressDialog.setCanceledOnTouchOutside(false);
    AccountManage.a().a();
    this.jdField_a_of_type_JavaUtilList = SharedPrefs.a();
    if (this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.isLogin()) {
      this.f = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount();
    }
    if ((this.f == null) && (this.jdField_a_of_type_JavaUtilList != null)) {
      this.f = ((String)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    paramBundle = super.getAppRuntime().getAccount();
    if ((GesturePWDUtils.getJumpLock(this, paramBundle)) && (!GesturePWDUtils.getAppForground(this)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.quicklogin.", 2, "-->onCreate--has gesture password, will start unlock activity");
      }
      this.g = paramBundle;
      paramBundle = new Intent(this, GesturePWDUnlockActivity.class);
      paramBundle.putExtra("key_gesture_from_authority", true);
      super.startActivityForResult(paramBundle, 100);
      return;
    }
    a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    QLog.d("Q.quicklogin.", 2, "ondestroy");
    g();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\QuickLoginAuthorityActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */