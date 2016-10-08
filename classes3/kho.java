import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;

public class kho
  implements Runnable
{
  public kho(AccountManageActivity paramAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i;
    if (this.a.app.a().a().b(AppConstants.ah, 7000) != null)
    {
      i = DBUtils.a().a(this.a.app.a());
      if (i >= 3) {
        if (QLog.isColorLevel()) {
          QLog.d("AccountManageActivity", 2, "refreshSubAccount() set stick2top fail." + this.a.app.a() + " count=" + i + " >=max_stick2top_count , return.");
        }
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AccountManageActivity", 2, "refreshSubAccount() RecentList has default subAccount RU. go 2 stick2Top, current count=" + i);
      }
      SubAccountControll.a(this.a.app, AppConstants.ah, true);
      DBUtils.a().a(this.a.app.a(), i);
      return;
      DBUtils.a().a(this.a.app.a(), 3);
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "recent list does not exist ruDefault.");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */