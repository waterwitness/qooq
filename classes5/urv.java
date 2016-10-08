import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.DispatchThread;

public class urv
  implements Runnable
{
  public urv(DispatchThread paramDispatchThread)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (this.a)
    {
      this.a.notifyAll();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\urv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */