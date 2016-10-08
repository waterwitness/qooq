import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import java.util.concurrent.atomic.AtomicInteger;

public class wif
  implements Runnable
{
  public wif(SwiftBrowserOfflineHandler paramSwiftBrowserOfflineHandler, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler.a();
    long l = System.currentTimeMillis();
    if (SwiftBrowserOfflineHandler.b.get() == 3) {}
    for (boolean bool = HtmlOffline.a(BaseApplicationImpl.a().getApplicationContext(), this.jdField_a_of_type_JavaLangString, new wig(this, l));; bool = false)
    {
      if (!bool) {
        SwiftBrowserOfflineHandler.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserOfflineHandler);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */