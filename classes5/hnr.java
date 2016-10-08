import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.export.external.interfaces.JsResult;

public class hnr
  implements DialogInterface.OnClickListener
{
  public hnr(CustomWebChromeClient paramCustomWebChromeClient, JsResult paramJsResult)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsResult.cancel();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hnr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */