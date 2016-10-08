import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rxt
  extends Handler
{
  public rxt(OnlineFileSessionCenter paramOnlineFileSessionCenter, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rxt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */