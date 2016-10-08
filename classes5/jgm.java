import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class jgm
  implements Runnable
{
  public jgm(AbsBaseWebViewActivity paramAbsBaseWebViewActivity, boolean paramBoolean, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewBase", 2, "start request: " + this.jdField_a_of_type_Boolean);
    }
    WebProcessManager.a(true);
    if (this.jdField_a_of_type_Boolean) {
      AbsBaseWebViewActivity.a(this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */