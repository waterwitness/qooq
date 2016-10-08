import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.export.js.VipDownloadInterface;
import com.tencent.smtt.sdk.WebView;

public class wxx
  implements Runnable
{
  public wxx(VipDownloadInterface paramVipDownloadInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.a != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.a.loadUrl(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtility.a(this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.b, "webview loadUrl>>> ", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */