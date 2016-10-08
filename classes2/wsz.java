import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class wsz
  implements Runnable
{
  public wsz(BaseInterface paramBaseInterface, long paramLong, String paramString, WebView paramWebView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('batchCallback',{guid:" + this.jdField_a_of_type_Long + ",'r':-2,'data':['" + this.jdField_a_of_type_JavaLangString + "']})};";
    LogUtility.e("Response<callBatch>", str);
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(str);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */