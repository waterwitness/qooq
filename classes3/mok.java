import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class mok
  extends SubAccountBindObserver
{
  public mok(SubLoginActivity paramSubLoginActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() isSucc=" + paramBoolean + " isBindFromThis=" + this.a.a);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubLoginActivity.onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
    }
    if (!this.a.a) {}
    label468:
    for (;;)
    {
      return;
      this.a.a = false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount: start");
      }
      this.a.a();
      Object localObject;
      if (paramBoolean)
      {
        this.a.b(this.a.getString(2131370557));
        if (QLog.isColorLevel()) {
          QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub success............");
        }
        SubAccountAssistantForward.b(this.a.app);
        SubAccountAssistantForward.a(this.a.app);
        localObject = new Intent(this.a, SplashActivity.class);
        ((Intent)localObject).putExtra("tab_index", MainFragment.a);
        ((Intent)localObject).setFlags(67108864);
        this.a.startActivity((Intent)localObject);
        this.a.finish();
      }
      for (;;)
      {
        if ((paramSubAccountBackProtocData == null) || (!QLog.isColorLevel())) {
          break label468;
        }
        QLog.d("Q.subaccount.SubLoginActivity", 2, "onBindSubAccount:....SubloginActivity......bindSub failed............ ...errorMsg = " + paramSubAccountBackProtocData.a + "...errorType = " + paramSubAccountBackProtocData.p);
        return;
        if (paramSubAccountBackProtocData == null) {
          break;
        }
        switch (paramSubAccountBackProtocData.p)
        {
        default: 
          this.a.a(this.a.getString(2131370538));
          break;
        case 1002: 
          SubAccountControll.a(this.a.app, this.a);
          break;
        case 1003: 
          this.a.a(this.a.getString(2131370535));
          break;
        case 1004: 
          String str = paramSubAccountBackProtocData.a;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = this.a.getString(2131370537);
          }
          this.a.a((String)localObject);
          this.a.runOnUiThread(new mol(this));
          SubLoginActivity.a(this.a, null);
          SubAccountAssistantForward.a(this.a.app, 300L);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mok.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */