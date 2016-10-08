import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public final class whq
  implements Runnable
{
  public whq(AppRuntime paramAppRuntime)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2) && (this.a != null) && (this.a.isLogin()))
    {
      ??? = (TicketManager)this.a.getManager(2);
      String str = this.a.getAccount();
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.jdField_a_of_type_JavaLangString)) {
        SwiftBrowserCookieMonster.jdField_a_of_type_JavaLangString = ((TicketManager)???).getSkey(str);
      }
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.b)) {
        SwiftBrowserCookieMonster.b = ((TicketManager)???).getSuperkey(str);
      }
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.d)) {
        SwiftBrowserCookieMonster.d = ((TicketManager)???).getStweb(str);
      }
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.e)) {
        SwiftBrowserCookieMonster.e = ((TicketManager)???).getA2(str);
      }
      synchronized (SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        if (SwiftBrowserCookieMonster.b())
        {
          SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 3);
          SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
          return;
        }
        SwiftBrowserCookieMonster.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(2, 1);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */