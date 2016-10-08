import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class syq
  implements DialogInterface.OnCancelListener
{
  public syq(UiApiPlugin paramUiApiPlugin, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString + "({button: -1})");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */