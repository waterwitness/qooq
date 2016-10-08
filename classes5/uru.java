import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle;

public class uru
  implements Runnable
{
  public uru(CameraProxy.WaitDoneBundle paramWaitDoneBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.a.a)
    {
      this.a.a.notifyAll();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */