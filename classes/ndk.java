import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ndk
  implements MediaPlayer.OnCompletionListener
{
  public ndk(MediaPlayerManager paramMediaPlayerManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    com.tencent.mobileqq.utils.AudioUtil.a = null;
    if (MediaPlayerManager.a(this.a)) {}
    for (paramMediaPlayer = MediaPlayerManager.a(this.a); (paramMediaPlayer != null) && (MediaPlayerManager.b(this.a)); paramMediaPlayer = MediaPlayerManager.a(this.a)) {
      return;
    }
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ndk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */