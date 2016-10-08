import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.js.OpenJsBridge.OpenJsBridgeListener;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class wtk
  implements Runnable
{
  public wtk(OpenJsBridge.OpenJsBridgeListener paramOpenJsBridgeListener, String paramString1, String paramString2, WebView paramWebView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LogUtility.b("Response", "AsyncInterface_end:javascript:window.JsBridge&&JsBridge.callback('interface." + this.jdField_a_of_type_JavaLangString + "',{guid:" + this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge$OpenJsBridgeListener.b + ",'r':0,'data':" + this.b + "});");
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback('interface." + this.jdField_a_of_type_JavaLangString + "',{guid:" + this.jdField_a_of_type_ComTencentOpenAppcommonJsOpenJsBridge$OpenJsBridgeListener.b + ",'r':0,'data':" + this.b + "});");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wtk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */