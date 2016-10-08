import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView.IGetTotalTime;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sho
  implements MediaPlayer.OnPreparedListener
{
  sho(shn paramshn, MediaPlayer paramMediaPlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    this.jdField_a_of_type_Shn.a.a(i);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */