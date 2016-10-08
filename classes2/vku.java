import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.troop.activity.VideoRecordActivity;

public class vku
  implements Runnable
{
  public vku(VideoRecordActivity paramVideoRecordActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Thread.sleep(1000L);
      VideoRecordActivity.a(this.a, new EncodeThread(this.a, new vkx(this.a, Looper.getMainLooper()), VideoRecordActivity.a(this.a), null, null));
      VideoRecordActivity.a(this.a).run();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vku.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */