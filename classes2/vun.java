import android.media.MediaPlayer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.mobileqq.troop.widget.VideoViewX.OnPlayListener;

public class vun
  implements Runnable
{
  public vun(VideoViewX paramVideoViewX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (VideoViewX.a(this.a) != null)
    {
      if (VideoViewX.a(this.a).getCurrentPosition() > 0)
      {
        if (this.a.a)
        {
          this.a.a = false;
          if (VideoViewX.a(this.a) != null) {
            VideoViewX.a(this.a).b();
          }
        }
        if (VideoViewX.a(this.a) != null) {
          VideoViewX.a(this.a).a(VideoViewX.a(this.a));
        }
        VideoViewX.c(this.a, false);
      }
    }
    else {
      return;
    }
    this.a.postDelayed(VideoViewX.a(this.a), 300L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */