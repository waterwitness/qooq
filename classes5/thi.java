import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyEntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.LogoutReason;

public class thi
  implements Runnable
{
  public thi(NearbyAppInterface paramNearbyAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyEntityManagerFactory.verifyAuthentication())
    {
      QLog.e(NearbyAppInterface.jdField_a_of_type_JavaLangString, 1, "verify fail!");
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\thi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */