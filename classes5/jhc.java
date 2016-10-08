import android.text.TextUtils;
import com.tencent.biz.webviewplugin.KeyInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class jhc
  implements Runnable
{
  public jhc(KeyInfo paramKeyInfo, AppRuntime paramAppRuntime, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_a_of_type_MqqAppAppRuntime.isLogin()) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo.c(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        Thread.yield();
        return;
        KeyInfo.a(this.jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo, 1);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("KeyInfo", 2, "preGetDomainInfo exception:" + localException.toString());
      }
      KeyInfo.a(this.jdField_a_of_type_ComTencentBizWebviewpluginKeyInfo, 1);
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */