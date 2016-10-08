import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hkv
  implements Runnable
{
  public hkv(EqqAccountDetailActivity paramEqqAccountDetailActivity, EqqDetail paramEqqDetail)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "saveEqqDetailInSubThread");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hkv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */