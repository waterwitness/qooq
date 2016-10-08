import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.ar.ARMusicController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qoy
  implements MediaPlayer.OnPreparedListener
{
  public qoy(ARMusicController paramARMusicController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + ARMusicController.b(this.a));
      }
      this.a.a.seekTo(0);
      ARMusicController.b(this.a, true);
      if (ARMusicController.b(this.a))
      {
        this.a.a.start();
        ARMusicController.c(this.a, false);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      paramMediaPlayer.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qoy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */