import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;

public class ndj
  implements Runnable
{
  public ndj(MediaPlayerManager paramMediaPlayerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      AudioUtil.a(2131165191, 1, MediaPlayerManager.a(this.a), MediaPlayerManager.a(this.a));
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */