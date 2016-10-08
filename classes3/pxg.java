import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class pxg
  extends MqqHandler
{
  private WeakReference a;
  
  private pxg(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.a.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pxg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */