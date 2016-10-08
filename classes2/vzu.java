import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class vzu
  implements MediaPlayer.OnCompletionListener
{
  public vzu()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    com.tencent.mobileqq.utils.AudioUtil.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */