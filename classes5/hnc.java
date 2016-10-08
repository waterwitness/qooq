import android.os.Handler;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;

public class hnc
  implements Runnable
{
  public hnc(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateUnfollowInfo");
    }
    if (this.a.n)
    {
      int i = PublicAccountUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.accountFlag);
      if ((i == -3) || (i == -4)) {
        PublicAccountManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      }
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.p, this.a.B);
    this.a.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.b(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    this.a.b(this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    RecentUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.p, this.a.B);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.p, "0X8004E43", "0X8004E43", 0, 0, this.a.p, "", "", "");
    PAStartupTracker.a(" pubAcc_follow_cancel", null, this.a.p);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hnc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */