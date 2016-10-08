import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.VersionUtils;

public class vus
  implements MediaPlayer.OnCompletionListener
{
  public vus(VideoViewX paramVideoViewX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    VideoViewX.b(this.a);
    VideoViewX.c(this.a, 5);
    VideoViewX.d(this.a, 5);
    if (VideoViewX.a(this.a) != null)
    {
      VideoViewX.a(this.a).d();
      VideoViewX.a(this.a).c();
    }
    if (VersionUtils.b()) {
      ((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this.a.a);
    }
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).onCompletion(VideoViewX.a(this.a));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */