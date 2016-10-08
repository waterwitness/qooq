import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ldl
  implements Runnable
{
  public ldl(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).a(this.a.a, 0, true);
    }
    this.a.s();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */