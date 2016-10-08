import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.FrameLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AntiphingToast;

public class wko
  extends Handler
{
  public wko(AntiphingToast paramAntiphingToast, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a(0.0F, 0 - AntiphingToast.a(this.a).getHeight(), true);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */