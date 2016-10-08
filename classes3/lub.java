import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.ErrMsg;

public class lub
  extends WtloginObserver
{
  public lub(LoginVerifyCodeActivity paramLoginVerifyCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    String str1 = null;
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    this.a.d();
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetStViaSMSVerifyLogin  login success ret =  " + paramInt2);
      }
      paramString = this.a.app.a(LoginPhoneNumActivity.class);
      if (paramString != null) {
        paramString.sendEmptyMessage(2015);
      }
      this.a.finish();
      return;
    }
    if (paramInt2 == -20160326)
    {
      this.a.finish();
      return;
    }
    if (paramInt2 == 2008)
    {
      this.a.a(2131367486, 0);
      this.a.finish();
      return;
    }
    String str3;
    if (paramErrMsg != null)
    {
      str3 = paramErrMsg.getMessage();
      str2 = str3;
      if (paramErrMsg.getType() == 1) {
        str1 = paramErrMsg.getOtherinfo();
      }
    }
    for (String str2 = str3;; str2 = null)
    {
      if (!TextUtils.isEmpty(str1))
      {
        paramErrMsg = new Intent(this.a, NotificationActivity.class);
        paramErrMsg.putExtra("type", 8);
        if (paramInt2 == 40) {
          paramErrMsg.putExtra("msg", str2);
        }
        for (;;)
        {
          paramErrMsg.putExtra("loginalias", paramString);
          paramErrMsg.putExtra("loginret", paramInt2);
          this.a.startActivity(paramErrMsg);
          return;
          paramErrMsg.putExtra("msg", str2 + " " + str1);
        }
      }
      if (TextUtils.isEmpty(str2)) {
        this.a.a(2131368654, 1);
      }
      while (paramInt2 == 155)
      {
        this.a.finish();
        return;
        this.a.a(str2, 0);
      }
      break;
    }
  }
  
  public void OnGetSubaccountStViaSMSVerifyLogin(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnGetSubaccountStViaSMSVerifyLogin  userAccount = " + paramString2 + " mainAccount=" + paramString1 + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnGetSubaccountStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("logintime", 2, "login end.......");
    }
    if (paramInt2 == 0) {
      if ((paramString1 != null) && (paramString2 != null) && (paramString1.equals(paramString2)))
      {
        SubAccountAssistantForward.d(this.a.app);
        LoginVerifyCodeActivity.b(this.a);
        LoginVerifyCodeActivity.a(this.a, 2131370555, 0);
        this.a.finish();
      }
    }
    for (;;)
    {
      return;
      if (this.a.app != null)
      {
        paramString1 = new HashMap();
        paramString1.put("param_FailCode", "12001");
        paramString1.put("fail_step", "loginsucc");
        paramString1.put("fail_location", "subLogin");
        StatisticCollector.a(BaseApplication.getContext()).a(this.a.app.a(), "actSBLogin", true, 0L, 0L, paramString1, "");
        SharedPreUtils.a(this.a.app.getApplication().getApplicationContext(), paramString2, true);
        this.a.getAppRuntime().getSubAccountKey(this.a.app.getAccount(), paramString2, this.a.a);
        paramString1 = (SubAccountManager)this.a.app.getManager(60);
        if (paramString1 == null) {
          break;
        }
        paramString1.a(paramString2, 0, "");
        return;
        this.a.d();
        if (paramInt2 == -20160326)
        {
          this.a.finish();
          return;
        }
        if (paramInt2 == 2008)
        {
          this.a.a(2131367486, 0);
          this.a.finish();
          return;
        }
        Object localObject1 = null;
        Object localObject2 = null;
        paramString1 = (String)localObject2;
        if (paramErrMsg != null)
        {
          String str = paramErrMsg.getMessage();
          paramString1 = (String)localObject2;
          localObject1 = str;
          if (paramErrMsg.getType() == 1)
          {
            paramString1 = paramErrMsg.getOtherinfo();
            localObject1 = str;
          }
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          paramErrMsg = new Intent(this.a, NotificationActivity.class);
          paramErrMsg.putExtra("type", 8);
          if (paramInt2 == 40) {
            paramErrMsg.putExtra("msg", (String)localObject1);
          }
          for (;;)
          {
            paramErrMsg.putExtra("loginalias", paramString2);
            paramErrMsg.putExtra("loginret", paramInt2);
            this.a.startActivity(paramErrMsg);
            return;
            paramErrMsg.putExtra("msg", (String)localObject1 + " " + paramString1);
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          this.a.a(2131368654, 1);
        }
        while (paramInt2 == 155)
        {
          this.a.finish();
          return;
          this.a.a((String)localObject1, 0);
        }
      }
    }
  }
  
  public void OnRefreshSMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.mobile=" + paramString1 + " msg=" + paramString2 + " timeLimit=" + paramInt2);
      QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.ret=" + paramInt3);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnRefreshSMSVerifyLoginAccount.errMsg=" + paramErrMsg);
      }
    }
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      this.a.d();
      if (paramInt3 == 0) {
        break;
      }
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1)) {
        this.a.a(2131368654, 1);
      }
      while (paramInt3 == 155)
      {
        this.a.finish();
        return;
        this.a.a(paramString1, 0);
      }
    }
    LoginVerifyCodeActivity.a(this.a, 60);
  }
  
  public void OnVerifySMSVerifyLoginAccount(String paramString1, String paramString2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("LoginVerifyCodeActivity", 2, "OnVerifySMSVerifyLoginAccount mobile=" + paramString1 + " msgCode=" + paramString2 + " ret=" + paramInt);
      if (paramErrMsg != null) {
        QLog.d("LoginVerifyCodeActivity", 2, "OnVerifySMSVerifyLoginAccount errMsg=" + paramErrMsg.getMessage());
      }
    }
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      if (paramInt == 0) {
        break;
      }
      this.a.d();
      paramString1 = null;
      if (paramErrMsg != null) {
        paramString1 = paramErrMsg.getMessage();
      }
      if (TextUtils.isEmpty(paramString1)) {
        this.a.a(2131368654, 1);
      }
      while (paramInt == 155)
      {
        this.a.finish();
        return;
        this.a.a(paramString1, 0);
      }
    }
    LoginVerifyCodeActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */