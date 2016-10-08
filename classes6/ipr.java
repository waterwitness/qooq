import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ipr
  implements MediaPlayer.OnPreparedListener
{
  public ipr(TextureVideoView paramTextureVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.a.h = 2;
    TextureVideoView localTextureVideoView1 = this.a;
    TextureVideoView localTextureVideoView2 = this.a;
    this.a.c = true;
    localTextureVideoView2.b = true;
    localTextureVideoView1.jdField_a_of_type_Boolean = true;
    if (this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnPreparedListener != null) {
      this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnPreparedListener.onPrepared(this.a.jdField_a_of_type_AndroidMediaMediaPlayer);
    }
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.setEnabled(true);
    }
    this.a.k = paramMediaPlayer.getVideoWidth();
    this.a.l = paramMediaPlayer.getVideoHeight();
    int i = this.a.n;
    if (i != 0) {
      this.a.seekTo(i);
    }
    if ((this.a.k != 0) && (this.a.l != 0))
    {
      if (Build.VERSION.SDK_INT >= 15) {
        this.a.getSurfaceTexture().setDefaultBufferSize(this.a.k, this.a.l);
      }
      if (this.a.i == 3)
      {
        this.a.start();
        if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
          this.a.jdField_a_of_type_AndroidWidgetMediaController.show();
        }
      }
    }
    while (this.a.i != 3)
    {
      do
      {
        return;
      } while ((this.a.isPlaying()) || ((i == 0) && (this.a.getCurrentPosition() <= 0)) || (this.a.jdField_a_of_type_AndroidWidgetMediaController == null));
      this.a.jdField_a_of_type_AndroidWidgetMediaController.show(0);
      return;
    }
    this.a.start();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */