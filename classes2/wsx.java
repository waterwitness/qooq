import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.smtt.sdk.WebView;
import java.util.List;
import java.util.TimerTask;

public class wsx
  extends TimerTask
{
  public wsx(BaseInterface paramBaseInterface, WebView paramWebView, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.optLef <= 0)
    {
      cancel();
      this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.firstIn = true;
    }
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.batchCallbackQueue.size() > 0) {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.batchCallback(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wsx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */