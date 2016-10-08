import android.os.Bundle;
import com.tencent.biz.pubaccount.PublicAccountManageActivity;
import com.tencent.biz.pubaccount.PublicAccountManageAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class hqa
  implements BusinessObserver
{
  public hqa(PublicAccountManageAdapter paramPublicAccountManageAdapter, String paramString, hqc paramhqc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter) != null) && (PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter).isResume())) {
      PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter).a(false);
    }
    if (!paramBoolean)
    {
      PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter);
      ReportController.b(PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter), "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X80067A0", "0X80067A0", 0, 0, String.valueOf(this.jdField_a_of_type_Hqc.a), "", "", "");
    }
    for (;;)
    {
      return;
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
          localUnFollowResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountManageAdapter", 2, "unfollow->puin:" + this.jdField_a_of_type_JavaLangString + " sucess");
            }
            PublicAccountManageAdapter.b(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter, this.jdField_a_of_type_Hqc);
            StructLongMessageDownloadProcessor.a(PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter), this.jdField_a_of_type_JavaLangString);
            ((TroopBindPublicAccountMgr)PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter).getManager(131)).a(this.jdField_a_of_type_JavaLangString);
            ReportController.b(PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter), "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X80067A0", "0X80067A0", 0, 1, String.valueOf(this.jdField_a_of_type_Hqc.a), "", "", "");
            return;
          }
          PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter);
          ReportController.b(PublicAccountManageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter), "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X80067A0", "0X80067A0", 0, 0, String.valueOf(this.jdField_a_of_type_Hqc.a), "", "", "");
          return;
        }
      }
      catch (Exception paramBundle) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */