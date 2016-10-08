import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerListener;

public class whv
  implements TicketManagerListener
{
  private whv()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onTicketRefreshed()
  {
    QLog.i("SwiftBrowserCookieMonster", 1, "TicketManager invoke onTicketRefreshed");
    SwiftBrowserCookieMonster.b();
    SwiftBrowserCookieMonster.a(MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */