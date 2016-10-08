import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.TimerCheckMsgCount;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qkb
  implements Runnable
{
  public qkb(TimerCheckMsgCount paramTimerCheckMsgCount)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    TimerCheckMsgCount.a(this.a).b.a().l();
    ((HotChatManager)TimerCheckMsgCount.b(this.a).b.getManager(59)).b();
    TimerCheckMsgCount.c(this.a).b.a().c();
    ((ReadInJoyLogicManager)TimerCheckMsgCount.d(this.a).b.getManager(162)).a().a(0);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qkb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */