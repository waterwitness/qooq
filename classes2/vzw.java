import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;

public final class vzw
  implements MediaPlayer.OnCompletionListener
{
  public vzw(MediaPlayer.OnCompletionListener paramOnCompletionListener, Handler paramHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (AudioUtil.b() == 0)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != null)
      {
        if ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_AndroidOsHandler.getLooper() == Looper.myLooper()))
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener.onCompletion(AudioUtil.a);
          return;
        }
        AudioUtil.a();
        this.jdField_a_of_type_AndroidOsHandler.post(new vzx(this));
        return;
      }
      AudioUtil.a();
      return;
    }
    AudioUtil.c();
    AudioUtil.a.start();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */