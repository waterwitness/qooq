import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import mqq.os.MqqHandler;

public final class utr
  extends MqqHandler
{
  public utr(Looper paramLooper, HandlerThread paramHandlerThread)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = paramMessage.obj;
    if ((paramMessage instanceof Pair))
    {
      paramMessage = (Pair)paramMessage;
      new utt((String)paramMessage.first, (String)paramMessage.second).a(new Void[0]);
    }
    if (this.a != null) {
      this.a.quit();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\utr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */