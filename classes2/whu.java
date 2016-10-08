import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public final class whu
  implements Runnable
{
  public whu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (SwiftBrowserCookieMonster.a() == null) {
      synchronized (SwiftBrowserCookieMonster.a())
      {
        if (SwiftBrowserCookieMonster.a() == null)
        {
          Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
          if (localObject1 != null)
          {
            localObject1 = (TicketManager)((AppRuntime)localObject1).getManager(2);
            if (localObject1 != null)
            {
              SwiftBrowserCookieMonster.a(new whv(null));
              ((TicketManager)localObject1).registTicketManagerListener(SwiftBrowserCookieMonster.a());
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */