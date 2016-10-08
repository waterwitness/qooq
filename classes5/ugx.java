import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.DataCollector;

public class ugx
  extends Handler
{
  public ugx(DataCollector paramDataCollector, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ugx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */