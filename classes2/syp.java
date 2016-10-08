import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class syp
  implements DialogInterface.OnClickListener
{
  public syp(UiApiPlugin paramUiApiPlugin, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString + "({button: 1})");
      }
    }
    while (paramInt != 1)
    {
      return;
      UiApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin, "showDialog", 0, "({button: 1})");
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_JavaLangString + "({button: 0})");
      return;
    }
    UiApiPlugin.b(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin, "showDialog", 0, "({button: 0})");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */