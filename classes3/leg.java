import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.LoadingStateManager;

public class leg
  implements Handler.Callback
{
  public leg(Conversation paramConversation)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    LoadingStateManager.a().a(paramMessage.what);
    if (paramMessage.what == 4)
    {
      this.a.a(1134013, 0L, false);
      return true;
    }
    this.a.d(true);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\leg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */