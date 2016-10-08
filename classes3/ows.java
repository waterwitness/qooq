import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.recent.PollBanner;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ows
  implements Handler.Callback
{
  public ows(PollBanner paramPollBanner)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (1 == paramMessage.what) {
      this.a.c();
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */