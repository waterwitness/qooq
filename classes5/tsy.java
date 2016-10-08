import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicPreDownloader;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class tsy
  extends TimerTask
{
  public tsy(PicPreDownloader paramPicPreDownloader)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!this.a.a.get())
    {
      this.a.a.set(true);
      Logger.b("PIC_TAG_PRELOAD", "timer count off,picPreDownload set on", "mIsPicPreloadSuitable" + this.a.a.get());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tsy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */