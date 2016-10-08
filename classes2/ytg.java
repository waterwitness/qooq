import CardPay.Channel;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.thirdpay.ThirdPayGate;

public class ytg
  extends Handler
{
  public ytg(ThirdPayGate paramThirdPayGate, String paramString, long paramLong, Channel paramChannel, Bundle paramBundle, Activity paramActivity, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "download-suc", 0, 0, this.jdField_a_of_type_JavaLangString, System.currentTimeMillis() - this.jdField_a_of_type_Long + "", "" + this.jdField_a_of_type_CardPayChannel.pluginSize, "");
      ThirdPayGate.access$300(this.jdField_a_of_type_CooperationThirdpayThirdPayGate, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
      return;
      ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "download-fail", 0, 0, this.jdField_a_of_type_JavaLangString, "by download", "", "");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    } while (ThirdPayGate.access$400(this.jdField_a_of_type_CooperationThirdpayThirdPayGate) == null);
    ThirdPayGate.access$400(this.jdField_a_of_type_CooperationThirdpayThirdPayGate).dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ytg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */