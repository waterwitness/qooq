import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hlk
  implements Runnable
{
  public hlk(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initData");
    }
    AccountDetailActivity localAccountDetailActivity = this.a;
    if (!this.a.a()) {}
    for (boolean bool = true;; bool = false)
    {
      localAccountDetailActivity.c = bool;
      AccountDetailActivity.b(this.a, new hll(this));
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "initData exit");
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */