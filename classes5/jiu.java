import android.app.Activity;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.webso.WebSoUtils;

public class jiu
  implements Runnable
{
  public jiu(WebSoPlugin paramWebSoPlugin, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((WebSoUtils.c(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin.mRuntime != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin.mRuntime.a() != null)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin.mRuntime.a().runOnUiThread(new jiv(this));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jiu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */