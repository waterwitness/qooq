import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ldx
  implements Runnable
{
  public ldx(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).a(this.a.a, 0, false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ldx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */