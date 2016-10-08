import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Build.VERSION;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ipq
  implements MediaPlayer.OnVideoSizeChangedListener
{
  public ipq(TextureVideoView paramTextureVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.a.k = paramMediaPlayer.getVideoWidth();
    this.a.l = paramMediaPlayer.getVideoHeight();
    if ((this.a.k != 0) && (this.a.l != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.a.getSurfaceTexture().setDefaultBufferSize(this.a.k, this.a.l);
      }
      this.a.requestLayout();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */