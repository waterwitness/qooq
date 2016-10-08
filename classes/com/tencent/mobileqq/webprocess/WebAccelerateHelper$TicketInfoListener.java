package com.tencent.mobileqq.webprocess;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerListener;

public class WebAccelerateHelper$TicketInfoListener
  implements TicketManagerListener
{
  private WebAccelerateHelper$TicketInfoListener(WebAccelerateHelper paramWebAccelerateHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onTicketRefreshed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebAccelerateHelper", 2, "TicketManager invoke onTicketRefreshed");
    }
    SwiftBrowserCookieMonster.b();
    SwiftBrowserCookieMonster.a(MobileQQ.sMobileQQ.waitAppRuntime(null));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\webprocess\WebAccelerateHelper$TicketInfoListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */