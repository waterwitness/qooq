import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import mqq.observer.BusinessObserver;

public class hxb
  implements BusinessObserver
{
  public hxb(ReadInJoySettingActivity paramReadInJoySettingActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = false;
    mobileqq_mp.SetMessageConfigurationResponse localSetMessageConfigurationResponse;
    if (paramBoolean) {
      localSetMessageConfigurationResponse = new mobileqq_mp.SetMessageConfigurationResponse();
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          localSetMessageConfigurationResponse.mergeFrom(paramBundle);
          if ((localSetMessageConfigurationResponse.ret_info.has()) && (localSetMessageConfigurationResponse.ret_info.ret_code.has()))
          {
            paramInt = localSetMessageConfigurationResponse.ret_info.ret_code.get();
            if (paramInt == 0)
            {
              paramInt = 1;
              paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity;
              paramBundle.jdField_a_of_type_Int -= 1;
              if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.b = false;
              if (paramInt == 0) {
                break label300;
              }
              ReadInJoySettingActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity).setChecked(this.jdField_a_of_type_Boolean);
              if (this.jdField_a_of_type_Boolean)
              {
                ReportController.b(null, "CliOper", "", "", "0X80067D5", "0X80067D5", 0, 0, "", "", "", ReadInJoyUtils.c());
                ReadInJoySettingActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity).a(this.jdField_a_of_type_Boolean);
              }
            }
            else
            {
              QLog.d("ReadInJoySettingActivity", 1, "setkandian recomm fail code:" + paramInt);
              break label359;
            }
          }
          else
          {
            QLog.d("ReadInJoySettingActivity", 1, "setkandian recomm wrong resp");
            paramInt = 0;
            continue;
          }
        }
        else
        {
          QLog.d("ReadInJoySettingActivity", 1, "setkandian recomm fail data null");
        }
      }
      catch (Exception paramBundle)
      {
        QLog.d("ReadInJoySettingActivity", 1, "failed to handle setkandian recomm configuration");
      }
      ReportController.b(null, "CliOper", "", "", "0X800676D", "0X800676D", 0, 0, "", "", "", ReadInJoyUtils.c());
      continue;
      label300:
      QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.getApplicationContext(), 2131362997, 0).a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity.c = true;
      paramBundle = ReadInJoySettingActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySettingActivity);
      paramBoolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        paramBoolean = true;
      }
      paramBundle.setChecked(paramBoolean);
      QLog.d("ReadInJoySettingActivity", 1, "handle setkandian recomm failed");
      return;
      label359:
      paramInt = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hxb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */