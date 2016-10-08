import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class qav
  implements Runnable
{
  public qav(MessageRoamManager paramMessageRoamManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MqqHandler localMqqHandler = MessageRoamManager.a(this.a).a(ChatHistoryForC2C.class);
    if (MessageRoamManager.a(this.a)) {}
    for (Message localMessage = localMqqHandler.obtainMessage(18);; localMessage = localMqqHandler.obtainMessage(19))
    {
      localMqqHandler.sendMessage(localMessage);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */