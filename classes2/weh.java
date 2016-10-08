import android.media.MediaPlayer;
import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ColorRingPlayer;

public class weh
  implements Runnable
{
  public weh(ColorRingPlayer paramColorRingPlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      Object localObject1 = this.a.jdField_a_of_type_JavaLangObject;
      boolean bool = false;
      try
      {
        if (this.a.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
          bool = this.a.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
        }
        if ((this.a.jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!bool)) {
          break;
        }
        int i = this.a.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
        int j = this.a.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        this.a.jdField_a_of_type_AndroidOsHandler.post(new wei(this, j, i));
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          this.a.jdField_a_of_type_AndroidMediaMediaPlayer = null;
          this.a.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        Thread.sleep(50L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\weh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */