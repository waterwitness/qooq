import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;

public class hnx
  implements DialogInterface.OnClickListener
{
  public hnx(CustomWebChromeClient paramCustomWebChromeClient, JsPromptResult paramJsPromptResult, EditText paramEditText)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentSmttExportExternalInterfacesJsPromptResult.confirm(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hnx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */