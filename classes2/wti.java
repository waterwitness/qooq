import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class wti
  implements Runnable
{
  public wti(DownloadInterface paramDownloadInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.webview != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.webview.loadUrl(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtility.a(this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.TAG, "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */