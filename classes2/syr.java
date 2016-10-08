import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;

public class syr
  implements DialogInterface.OnClickListener
{
  public syr(UiApiPlugin paramUiApiPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (QQUtils.a(this.jdField_a_of_type_AndroidAppActivity, new String[] { this.jdField_a_of_type_JavaLangString }))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2131369476, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492908));
        paramDialogInterface = UiApiPlugin.a("-4", null, "createShortcut exsit!", this.b);
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -2, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.e, new String[] { paramDialogInterface });
        return;
      }
      if (UiApiPlugin.a(this.jdField_a_of_type_AndroidAppActivity, UiApiPlugin.a(this.jdField_a_of_type_AndroidAppActivity, null, this.c, "qqbrowser_float_shortcut"), this.jdField_a_of_type_JavaLangString, this.d))
      {
        paramDialogInterface = UiApiPlugin.a("0", null, null, this.b);
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, 0, "", "", "", "");
      }
      for (paramInt = 2131365174;; paramInt = 2131365175)
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramInt, 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492908));
        if ((paramDialogInterface != null) && (!TextUtils.isEmpty(this.e))) {
          this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.e, new String[] { paramDialogInterface });
        }
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, 0, "", "", "", "");
        break;
        paramDialogInterface = UiApiPlugin.a("-3", null, "createShortcut failed, iconUrl is invalide: " + this.d, this.b);
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_result", 0, 1, -1, "", "", "", "");
      }
    }
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "jsapi_addShortcut_dialog_click", 0, 1, -1, "", "", "", "");
    paramDialogInterface = UiApiPlugin.a("-1", null, "user cancel", this.b);
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.e, new String[] { paramDialogInterface });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */