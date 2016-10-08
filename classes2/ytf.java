import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.statistics.ReportController;
import cooperation.thirdpay.ThirdPayGate;

public class ytf
  implements DialogInterface.OnClickListener
{
  public ytf(ThirdPayGate paramThirdPayGate, String paramString, PluginInterface paramPluginInterface, Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.a(null, "P_CliOper", "cardpay", "", "installPlugin", "download-again", 0, 0, this.jdField_a_of_type_JavaLangString, "by download", "", "");
    paramDialogInterface.dismiss();
    ThirdPayGate.access$100(this.jdField_a_of_type_CooperationThirdpayThirdPayGate, this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterface, this.jdField_a_of_type_JavaLangString);
    ThirdPayGate.access$200(this.jdField_a_of_type_CooperationThirdpayThirdPayGate, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginInterface, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ytf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */