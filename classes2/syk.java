import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import org.json.JSONObject;

public class syk
  implements View.OnClickListener
{
  public syk(UiApiPlugin paramUiApiPlugin, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    UiApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin, this.jdField_a_of_type_OrgJsonJSONObject);
    paramView = this.jdField_a_of_type_OrgJsonJSONObject.optString("callback");
    if (!TextUtils.isEmpty(paramView)) {
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(paramView, new String[] { String.valueOf(0) });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */