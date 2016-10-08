import android.os.Handler;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hkt
  implements Runnable
{
  public hkt(EqqAccountDetailActivity paramEqqAccountDetailActivity, EqqDetail paramEqqDetail, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a, 2, "updateDetailInfo");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity.d(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
      if (this.jdField_a_of_type_Boolean) {
        EqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity).sendEmptyMessage(1);
      }
    }
    else
    {
      return;
    }
    EqqAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityEqqAccountDetailActivity, new hku(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hkt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */