import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;

class xrc
  implements AudioManager.OnAudioFocusChangeListener
{
  xrc(xqz paramxqz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "focusChange:" + paramInt + " _focusSteamType:" + this.a.z + " currMode:" + this.a.b.a.getMode() + " _activeMode:" + this.a.b.w);
    }
    if (paramInt == -1) {}
    while ((paramInt == -2) || (paramInt == -3) || (paramInt != 1)) {
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xrc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */