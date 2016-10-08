import android.os.Looper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class wiz
  implements Runnable
{
  public wiz(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      String str = HttpUtil.a(SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler), MsfSdkUtils.insertMtype("Web", this.jdField_a_of_type_JavaLangString), "POST", null, null);
      if ((str == null) || ("".equals(str.trim())) || (SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler) == null)) {}
      synchronized (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler)
      {
        if (SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler) == null) {
          SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler, new MqqWeakReferenceHandler(Looper.getMainLooper(), SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler)));
        }
        SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler).sendMessage(SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserTBSHandler).obtainMessage(100, str));
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wiz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */