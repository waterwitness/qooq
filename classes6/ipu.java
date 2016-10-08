import android.app.AlertDialog.Builder;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.widget.MediaController;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ipu
  implements MediaPlayer.OnErrorListener
{
  public ipu(TextureVideoView paramTextureVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "Error: " + paramInt1 + "," + paramInt2);
    }
    this.a.h = -1;
    this.a.i = -1;
    if (this.a.jdField_a_of_type_AndroidWidgetMediaController != null) {
      this.a.jdField_a_of_type_AndroidWidgetMediaController.hide();
    }
    if ((this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnErrorListener != null) && (this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnErrorListener.onError(this.a.jdField_a_of_type_AndroidMediaMediaPlayer, paramInt1, paramInt2))) {}
    while (this.a.getWindowToken() == null) {
      return true;
    }
    this.a.getContext().getResources();
    if (paramInt1 == 200) {}
    for (paramInt1 = 17039381;; paramInt1 = 17039377)
    {
      new AlertDialog.Builder(this.a.getContext()).setMessage(paramInt1).setPositiveButton(17039376, new ipv(this)).setCancelable(false).show();
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */