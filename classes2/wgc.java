import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.VideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class wgc
  implements MediaPlayer.OnCompletionListener
{
  public wgc(VideoView paramVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.a.start();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */