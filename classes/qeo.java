import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.LogoutReason;

public class qeo
  implements Runnable
{
  public qeo(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!QQAppInterface.a(this.a).verifyAuthentication())
    {
      QLog.e(QQAppInterface.a, 1, "", new RuntimeException("WTF"));
      if (this.a.isLogin()) {
        this.a.logout(true);
      }
      Intent localIntent = new Intent("mqq.intent.action.ACCOUNT_KICKED");
      localIntent.putExtra("title", "登录失败");
      localIntent.putExtra("msg", "登录失败");
      localIntent.putExtra("reason", Constants.LogoutReason.kicked);
      localIntent.addFlags(268435456);
      BaseApplicationImpl.a.startActivity(localIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qeo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */