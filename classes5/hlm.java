import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hlm
  implements Runnable
{
  public hlm(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "saveAccountDetailInSubThread");
    }
    this.a.a(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */