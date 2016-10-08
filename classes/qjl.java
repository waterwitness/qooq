import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.GetJoinedHotChatListStep;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qjl
  extends HotChatObserver
{
  private qjl(GetJoinedHotChatListStep paramGetJoinedHotChatListStep)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(int paramInt)
  {
    if (GetJoinedHotChatListStep.a(this.a) != null)
    {
      GetJoinedHotChatListStep.a(this.a).b.b(GetJoinedHotChatListStep.a(this.a));
      GetJoinedHotChatListStep.a(this.a, null);
    }
    if (paramInt == 0)
    {
      this.a.a(7);
      return;
    }
    this.a.a(6);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */