import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;

public class hne
  implements Runnable
{
  public hne(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateFollowInfo");
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.a.c();
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountUtilProfileParams == null) {}
    for (int i = 1;; i = 0)
    {
      PAStartupTracker.a("pubAcc_follow_confirm", null, this.a.p);
      if ((i != 0) && (!AccountDetailActivity.a(this.a))) {
        AccountDetailActivity.a(this.a, new hnf(this));
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */