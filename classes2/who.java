import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.SetCookiesCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class who
  implements Runnable
{
  who(whn paramwhn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Iterator localIterator = SwiftBrowserCookieMonster.a(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = (CopyOnWriteArrayList)SwiftBrowserCookieMonster.a(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster).get(str);
      str = SwiftBrowserCookieMonster.a(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster, str, this.a.jdField_a_of_type_MqqAppAppRuntime);
      localObject = ((CopyOnWriteArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SwiftBrowserCookieMonster.SetCookiesCallback localSetCookiesCallback = (SwiftBrowserCookieMonster.SetCookiesCallback)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserCookieMonster", 2, "post callback onSetCookiesFinished " + Util.b(str, new String[0]) + ", errorCode: " + SwiftBrowserCookieMonster.a(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster));
        }
        if (SwiftBrowserCookieMonster.a(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster)) {
          QLog.i("SwiftBrowserCookieMonster", 1, "cookie is wrong, need do jump ptlogin! " + Util.b(str, new String[0]));
        }
        localSetCookiesCallback.a(str, null, SwiftBrowserCookieMonster.a(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster));
      }
    }
    if ((SwiftBrowserCookieMonster.a(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster)) || (SwiftBrowserCookieMonster.a(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster) > 0L))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster.a();
      return;
    }
    SwiftBrowserCookieMonster.a(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserCookieMonster).clear();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\who.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */