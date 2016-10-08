import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public final class ifa
  implements Runnable
{
  public ifa(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.a.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + this.a.a(), 0);
    if (localObject != null) {}
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_name", PublicAccountConfigUtil.D);
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_icon", PublicAccountConfigUtil.E);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_delete", PublicAccountConfigUtil.a);
      ((SharedPreferences.Editor)localObject).putBoolean("service_account_folder_redspots", PublicAccountConfigUtil.b);
      ((SharedPreferences.Editor)localObject).putBoolean("public_account_mp_config", PublicAccountConfigUtil.g);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicAccountConfigUtil", 2, "updatePublicAccountCenterUrlConfigData error", localException);
      }
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ifa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */