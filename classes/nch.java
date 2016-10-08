import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;

public class nch
  extends Handler
{
  public nch(AudioPlayer paramAudioPlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && (AudioPlayer.a(this.a) == 0) && (this.a.a()))
    {
      int i = AudioPlayer.a(this.a).getStreamVolume(AudioPlayer.a(this.a).b);
      int j = AudioPlayer.a(this.a).getStreamMaxVolume(AudioPlayer.a(this.a).b);
      if (i / j <= 0.1F) {
        break label126;
      }
      AudioPlayer.a(this.a, 1);
      if (AudioPlayer.a(this.a) != null) {
        AudioPlayer.a(this.a).c(this.a, AudioPlayer.a(this.a));
      }
    }
    return;
    label126:
    AudioPlayer.a(this.a).sendEmptyMessageDelayed(1000, 200L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */