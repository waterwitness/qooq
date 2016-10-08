import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.CheckOfflineCallback;
import com.tencent.qphone.base.util.QLog;

public class jhl
  implements SwiftBrowserOfflineHandler.CheckOfflineCallback
{
  public jhl(OfflinePlugin paramOfflinePlugin, long paramLong, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.d = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "onCheckOfflineFinish, cost: " + this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.d + ", url: " + Util.b(this.jdField_a_of_type_JavaLangString, new String[0]));
    }
    OfflinePlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin, this.jdField_a_of_type_JavaLangString, paramInt);
    CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.mRuntime.a();
    if (localCustomWebView != null)
    {
      localCustomWebView.a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.e("OfflinePluginQQ", 1, "error!!!! webview is null, now can not loadUrl " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */