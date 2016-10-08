import android.os.SystemClock;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import mqq.app.MobileQQ;

public class jgl
  implements Runnable
{
  public jgl(AbsBaseWebViewActivity paramAbsBaseWebViewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SystemClock.uptimeMillis();
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      if (this.a.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
        this.a.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine == null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a, null, null);
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a);
        SystemClock.uptimeMillis();
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */