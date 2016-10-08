import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.ui.CallbackWaitingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gqh
  extends Handler
{
  public gqh(CallbackWaitingActivity paramCallbackWaitingActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */