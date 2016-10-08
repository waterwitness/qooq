import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.export.external.interfaces.JsResult;

public class hnu
  implements DialogInterface.OnClickListener
{
  public hnu(CustomWebChromeClient paramCustomWebChromeClient, JsResult paramJsResult)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsResult.confirm();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hnu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */