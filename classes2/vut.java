import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.VersionUtils;

public class vut
  implements MediaPlayer.OnErrorListener
{
  public vut(VideoViewX paramVideoViewX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Log.d(VideoViewX.a(this.a), "Error: " + paramInt1 + "," + paramInt2);
    VideoViewX.b(this.a);
    VideoViewX.c(this.a, -1);
    VideoViewX.d(this.a, -1);
    VideoViewX.b(this.a, true);
    if (VideoViewX.a(this.a) != null)
    {
      VideoViewX.a(this.a).d();
      VideoViewX.a(this.a).c();
    }
    if (VersionUtils.b()) {
      ((AudioManager)BaseApplication.getContext().getSystemService("audio")).abandonAudioFocus(this.a.a);
    }
    if ((VideoViewX.a(this.a) != null) && (VideoViewX.a(this.a).onError(VideoViewX.a(this.a), paramInt1, paramInt2))) {}
    while (this.a.getWindowToken() == null) {
      return true;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */