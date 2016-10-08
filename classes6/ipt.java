import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ipt
  implements MediaPlayer.OnInfoListener
{
  public ipt(TextureVideoView paramTextureVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.a.a != null) {
      this.a.a.onInfo(paramMediaPlayer, paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */