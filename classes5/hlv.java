import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class hlv
  implements BusinessObserver
{
  public hlv(AccountDetailActivity paramAccountDetailActivity, PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.J();
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.d(2131364487);
    }
    for (;;)
    {
      paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity;
      paramBundle.E -= 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.E == 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.J();
      }
      return;
      if (paramBoolean) {
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle != null)
          {
            mobileqq_mp.SetFunctionFlagResponse localSetFunctionFlagResponse = new mobileqq_mp.SetFunctionFlagResponse();
            localSetFunctionFlagResponse.mergeFrom(paramBundle);
            if (((mobileqq_mp.RetInfo)localSetFunctionFlagResponse.ret_info.get()).ret_code.get() == 0)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.d = this.jdField_a_of_type_Int;
              this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.o();
              if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.e == 6)
              {
                if (this.b != 1) {
                  break label308;
                }
                this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(1);
                ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p, "mp_msg_ziliao_2", "share_click", 0, 0, "", "", "", "");
                ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p, "0X8004F05", "0X8004F05", 0, 0, "", "", "", "");
              }
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, String.valueOf(this.b));
                }
                this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.f();
                if (QLog.isColorLevel()) {
                  QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "状态切换成功");
                }
                this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo);
                break;
                label308:
                ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.p, "0X8004F07", "0X8004F07", 0, 0, "", "", "", "");
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "状态切换失败1");
            }
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.d(2131364487);
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.d(2131364487);
            if (QLog.isColorLevel()) {
              QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "状态切换失败");
            }
          }
        }
        catch (Exception paramBundle) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */