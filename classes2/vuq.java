import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.qphone.base.util.QLog;

public class vuq
  implements AudioManager.OnAudioFocusChangeListener
{
  public vuq(VideoViewX paramVideoViewX)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
    case -2: 
    case -1: 
    case -3: 
      do
      {
        return;
        if (this.a.a())
        {
          this.a.c = true;
          this.a.e();
        }
        if (QLog.isColorLevel()) {
          QLog.d(VideoViewX.a(this.a), 2, "onAudioFocusChange,loss focus");
        }
        this.a.b = false;
        return;
      } while ((this.a.a()) && (!QLog.isColorLevel()));
      QLog.d(VideoViewX.a(this.a), 2, "onAudioFocusChange,temporarily lost audio focus");
      return;
    }
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).setVolume(1.0F, 1.0F);
    }
    if ((!this.a.a()) && (this.a.c)) {
      this.a.d();
    }
    if (QLog.isColorLevel()) {
      QLog.d(VideoViewX.a(this.a), 2, "onAudioFocusChange,gain focus");
    }
    this.a.b = true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vuq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */