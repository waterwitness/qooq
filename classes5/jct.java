import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.app.AppActivity;

class jct
  implements DialogInterface.OnClickListener
{
  jct(jcr paramjcr, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_JavaLangString.toLowerCase();
    if (paramDialogInterface.startsWith("www.")) {
      paramDialogInterface = "http://" + this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Jcr.jdField_a_of_type_MqqAppAppActivity, QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", paramDialogInterface);
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("fromQrcode", true);
      localIntent.putExtra("injectrecommend", false);
      this.jdField_a_of_type_Jcr.jdField_a_of_type_MqqAppAppActivity.startActivity(localIntent);
      if (this.jdField_a_of_type_Jcr.jdField_a_of_type_ComTencentBizWidgetsScannerView.jdField_a_of_type_Boolean == true) {
        this.jdField_a_of_type_Jcr.jdField_a_of_type_MqqAppAppActivity.finish();
      }
      if (this.jdField_a_of_type_Jcr.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Jcr.jdField_a_of_type_MqqAppAppActivity.finish();
      }
      return;
      if (paramDialogInterface.startsWith("https:")) {
        paramDialogInterface = "https" + this.jdField_a_of_type_JavaLangString.substring(5);
      } else if (paramDialogInterface.startsWith("http:")) {
        paramDialogInterface = "http" + this.jdField_a_of_type_JavaLangString.substring(4);
      } else {
        paramDialogInterface = this.jdField_a_of_type_JavaLangString;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */