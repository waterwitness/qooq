import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class lud
  extends SubAccountBindObserver
{
  public lud(LoginVerifyCodeActivity paramLoginVerifyCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "LoginVerifyCodeActivity.onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
    }
    this.a.d();
    Object localObject;
    if (paramBoolean)
    {
      this.a.a(2131370557, 2);
      if (QLog.isColorLevel()) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
      }
      SubAccountAssistantForward.b(this.a.app);
      SubAccountAssistantForward.a(this.a.app);
      SubAccountAssistantForward.c(this.a.app);
      SubAccountAssistantForward.d(this.a.app);
      localObject = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject).putExtra("tab_index", MainFragment.a);
      ((Intent)localObject).setFlags(67108864);
      this.a.startActivity((Intent)localObject);
      this.a.finish();
    }
    for (;;)
    {
      if ((paramSubAccountBackProtocData != null) && (QLog.isColorLevel())) {
        QLog.d("LoginVerifyCodeActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramSubAccountBackProtocData.a + "...errorType = " + paramSubAccountBackProtocData.p);
      }
      return;
      if (paramSubAccountBackProtocData != null) {
        switch (paramSubAccountBackProtocData.p)
        {
        default: 
          this.a.a(2131370538, 0);
          break;
        case 1002: 
          SubAccountControll.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(2131370535, 0);
          break;
        case 1004: 
          String str = paramSubAccountBackProtocData.a;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131370537);
          }
          this.a.a((String)localObject, 0);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */