import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class ysp
  extends Handler
{
  WeakReference a;
  WeakReference b;
  
  public ysp(Looper paramLooper, String paramString, TextView paramTextView)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = new WeakReference(paramTextView);
    this.a = new WeakReference(paramString);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.b == null) || (this.b.get() == null) || (this.a == null) || (this.a.get() == null));
        paramMessage = new StringBuilder((String)this.a.get());
        paramMessage.append(".");
        ((TextView)this.b.get()).setText(paramMessage.toString());
        removeMessages(2);
        sendEmptyMessageDelayed(2, 300L);
        return;
      } while ((this.b == null) || (this.b.get() == null) || (this.a == null) || (this.a.get() == null));
      paramMessage = new StringBuilder((String)this.a.get());
      paramMessage.append("..");
      ((TextView)this.b.get()).setText(paramMessage.toString());
      removeMessages(3);
      sendEmptyMessageDelayed(3, 300L);
      return;
    } while ((this.b == null) || (this.b.get() == null) || (this.a == null) || (this.a.get() == null));
    paramMessage = new StringBuilder((String)this.a.get());
    paramMessage.append("...");
    ((TextView)this.b.get()).setText(paramMessage.toString());
    removeMessages(1);
    sendEmptyMessageDelayed(1, 300L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */