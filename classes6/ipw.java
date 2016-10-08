import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ipw
  implements MediaPlayer.OnBufferingUpdateListener
{
  public ipw(TextureVideoView paramTextureVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.a.m = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */