import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.qphone.base.util.QLog;

public class vop
  implements AudioManager.OnAudioFocusChangeListener
{
  public vop(TVKTroopVideoManager paramTVKTroopVideoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.a.a())
          {
            this.a.c = true;
            this.a.e();
          }
        } while (!QLog.isColorLevel());
        QLog.d(TVKTroopVideoManager.a, 2, "onAudioFocusChange,loss focus");
        return;
      } while ((this.a.a()) && (!QLog.isColorLevel()));
      QLog.d(TVKTroopVideoManager.a, 2, "onAudioFocusChange,temporarily lost audio focus");
      return;
      if ((!this.a.a()) && (this.a.c)) {
        this.a.d();
      }
    } while (!QLog.isColorLevel());
    QLog.d(TVKTroopVideoManager.a, 2, "onAudioFocusChange,gain focus");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */