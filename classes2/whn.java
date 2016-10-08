import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class whn
  implements Runnable
{
  public whn(SwiftBrowserCookieMonster paramSwiftBrowserCookieMonster, Intent paramIntent, AppRuntime paramAppRuntime)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster).get() == 2)
    {
      SwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster);
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "start set all cookies " + Util.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.l, new String[0]));
      }
      SwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster, SwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_MqqAppAppRuntime), true);
      if (!SwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster).compareAndSet(2, 3)) {}
    }
    for (;;)
    {
      synchronized (SwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster))
      {
        SwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster).notifyAll();
        if (SwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster) > 0L)
        {
          SwiftBrowserCookieMonster.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster);
          QLog.e("SwiftBrowserCookieMonster", 1, "set cookie error :" + SwiftBrowserCookieMonster.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster));
          Util.b("Web_qqbrowser_check_and_set_cookies");
          new Handler(Looper.getMainLooper()).post(new who(this));
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "set cookie success: now start post handle callback");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */