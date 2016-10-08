import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

public class urb
  implements Runnable
{
  public urb(CameraProxy paramCameraProxy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.obtainMessage(1).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\urb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */