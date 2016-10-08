import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ips
  implements MediaPlayer.OnCompletionListener
{
  public ips(TextureVideoView paramTextureVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.a.h = 5;
    this.a.i = 5;
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    if (this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != null) {
      this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener.onCompletion(this.a.jdField_a_of_type_AndroidMediaMediaPlayer);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */