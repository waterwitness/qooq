package com.tencent.mobileqq.app;

import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class HotChatRecentUserMgr
{
  public HotChatRecentUserMgr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(1009));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    paramString = localRecentUserProxy.b(paramString, 1);
    if (paramString != null) {
      localRecentUserProxy.b(paramString);
    }
    a(paramQQAppInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\HotChatRecentUserMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */