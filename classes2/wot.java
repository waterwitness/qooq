import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.WebViewProgressBarController;

public class wot
  extends Handler
{
  public wot(WebViewProgressBarController paramWebViewProgressBarController)
  {
    super(Looper.getMainLooper());
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.e();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */