import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.statistics.ReportController;

public class sys
  implements DialogInterface.OnCancelListener
{
  public sys(UiApiPlugin paramUiApiPlugin, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, -2, "", "", "", "");
    paramDialogInterface.dismiss();
    paramDialogInterface = UiApiPlugin.a("-2", null, "user cancel", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.b, new String[] { paramDialogInterface });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */