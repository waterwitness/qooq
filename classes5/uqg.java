import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class uqg
  extends TimerTask
{
  public uqg(ShortVideoPreDownloader paramShortVideoPreDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.a.get())
    {
      this.a.a.set(true);
      ShortVideoPreDownloader.a("off", "Timer count off, mIsPreDownloaderOpen=" + this.a.a.get());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */