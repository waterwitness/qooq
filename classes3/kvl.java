import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kvl
  implements AudioPlayer.AudioPlayerListener
{
  public kvl(ChatHistory paramChatHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    this.a.i();
    if (this.a.a != null) {
      this.a.a.b();
    }
    this.a.setVolumeControlStream(3);
    ChatHistory.a(this.a).unregisterListener(this.a);
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.a.c(2131368150);
    this.a.setVolumeControlStream(3);
    ChatHistory.a(this.a).unregisterListener(this.a);
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.a.setVolumeControlStream(paramInt);
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */