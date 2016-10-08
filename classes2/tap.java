import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.IMessageHandler;

public final class tap
  extends Handler
{
  private java.lang.ref.WeakReference a;
  
  public tap(IMessageHandler paramIMessageHandler)
  {
    super(Looper.getMainLooper());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new mqq.util.WeakReference(paramIMessageHandler);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    IMessageHandler localIMessageHandler;
    do
    {
      return;
      localIMessageHandler = (IMessageHandler)this.a.get();
    } while (localIMessageHandler == null);
    localIMessageHandler.a(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */