import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ndn
  implements Runnable
{
  public ndn(MediaPlayerManager paramMediaPlayerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MediaPlayerManager.a(this.a).unregisterListener(MediaPlayerManager.a(this.a));
    MediaPlayerManager.a(this.a).unregisterListener(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */