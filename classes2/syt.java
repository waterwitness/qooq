import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import cooperation.troop.TroopManageProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class syt
  implements TroopMemberApiClient.Callback
{
  public syt(UiApiPlugin paramUiApiPlugin, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    int i = 12;
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("isSuccess"))
      {
        paramBundle = new Intent();
        paramBundle.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a() instanceof WebViewPluginContainer)) {
          i = ((WebViewPluginContainer)this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a()).switchRequestCode(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin, (byte)12);
        }
        TroopManageProxyActivity.a("troop_manage_plugin.apk", "管理群", TroopManageProxyActivity.class, this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a(), paramBundle, TroopManageProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a()), "com.tencent.mobileqq.activity.TroopSetJoinTypeActivity", this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a().getAccount(), i);
      }
    }
    else {
      return;
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("gc", this.jdField_a_of_type_JavaLangString);
      paramBundle.put("ret", 1);
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(UiApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin), new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\syt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */