import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

public class wsy
  implements Runnable
{
  public wsy(BaseInterface paramBaseInterface, long paramLong, List paramList, WebView paramWebView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('batchCallback',{'guid':" + this.jdField_a_of_type_Long + ",'r':0,'data':" + this.jdField_a_of_type_JavaUtilList.toString() + "})};";
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(str);
      LogUtility.b(BaseInterface.TAG, "Response<callBatch> AsyncInterface result : " + str);
      return;
      LogUtility.e(BaseInterface.TAG, "Response<callBatch> AsyncInterface result : webview is null !!!");
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */