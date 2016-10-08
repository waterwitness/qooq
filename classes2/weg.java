import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ColorRingPlayer;
import com.tencent.qphone.base.util.QLog;

public class weg
  implements AudioManager.OnAudioFocusChangeListener
{
  public weg(ColorRingPlayer paramColorRingPlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt == -2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "transient focus loss.");
      }
      synchronized (this.a.a)
      {
        if (this.a.a.h == 4) {
          this.a.a();
        }
        return;
      }
    }
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "gained focus");
      }
      if (this.a.b)
      {
        this.a.c();
        this.a.b = false;
      }
    }
    else if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorRingPlayer", 2, "Audio focus Loss");
      }
      this.a.b();
      synchronized (this.a.a)
      {
        this.a.a.h = 6;
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\weg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */