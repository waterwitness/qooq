import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioUtil;

public final class wab
  implements MediaPlayer.OnCompletionListener
{
  public wab(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (AudioUtil.b() == 0)
    {
      if (this.a != null)
      {
        this.a.onCompletion(AudioUtil.a);
        return;
      }
      AudioUtil.a();
      return;
    }
    AudioUtil.c();
    AudioUtil.a.start();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */