import android.os.Handler;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hmb
  implements Runnable
{
  public hmb(AccountDetailActivity paramAccountDetailActivity, AccountDetail paramAccountDetail, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "updateDetailInfo");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.isSyncLbs)) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    AccountDetailActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, new hmc(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */