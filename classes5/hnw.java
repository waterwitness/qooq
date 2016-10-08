import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.export.external.interfaces.JsResult;

public class hnw
  implements DialogInterface.OnCancelListener
{
  public hnw(CustomWebChromeClient paramCustomWebChromeClient, JsResult paramJsResult)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsResult.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hnw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */