import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class hme
  implements BusinessObserver
{
  public hme(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      if (!this.a.c) {
        this.a.d(2131364487);
      }
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.E -= 1;
      if (this.a.E == 0) {
        this.a.J();
      }
      return;
      if (paramBoolean) {}
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          localGetPublicAccountDetailInfoResponse.mergeFrom(paramBundle);
          if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() == 0)
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || ((localGetPublicAccountDetailInfoResponse.seqno.has()) && (localGetPublicAccountDetailInfoResponse.seqno.get() != this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno)))
            {
              this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = localGetPublicAccountDetailInfoResponse;
              paramBundle = new AccountDetail(this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
              if ((this.a.f) && (paramBundle.followType == 1))
              {
                this.a.a(paramBundle, false);
                continue;
              }
              this.a.a(paramBundle, true);
              continue;
            }
            if ((!this.a.f) || (this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
              continue;
            }
            this.a.e();
            continue;
          }
          this.a.d(2131364487);
          continue;
        }
        if (this.a.c) {
          continue;
        }
        this.a.d(2131364487);
      }
      catch (Exception paramBundle) {}
      if (!this.a.c) {
        this.a.d(2131364487);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */