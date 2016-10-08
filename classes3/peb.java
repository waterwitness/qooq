import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.OnTrimVDPlayCompelteListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class peb
  implements MediaPlayer.OnCompletionListener
{
  public peb(FixedSizeVideoView paramFixedSizeVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a.a != null)
    {
      if (FixedSizeVideoView.a(this.a) != null) {
        FixedSizeVideoView.a(this.a).removeMessages(0);
      }
      this.a.a.a(paramMediaPlayer);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\peb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */