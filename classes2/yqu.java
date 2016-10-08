import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.QzoneGiftFullScreenViewController.GiftFullScreenPlayListener;
import cooperation.qzone.webviewplugin.QZoneGiftFullScreenJsPlugin;

public class yqu
  implements QzoneGiftFullScreenViewController.GiftFullScreenPlayListener
{
  public yqu(QZoneGiftFullScreenJsPlugin paramQZoneGiftFullScreenJsPlugin, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneGiftFullScreenJsPlugin.a != null)
    {
      String str = "window." + this.jdField_a_of_type_JavaLangString + "({playFinish:1})";
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneGiftFullScreenJsPlugin.a.callJs(str);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */