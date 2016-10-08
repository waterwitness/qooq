import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kvg
  implements Runnable
{
  public kvg(ChatHistory paramChatHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.isFinishing()) {
      ThreadManager.a(new kvh(this), 8, null, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */