import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeMediaPlayer.OnCompletionListener;
import java.util.HashMap;

class xra
  implements TraeMediaPlayer.OnCompletionListener
{
  xra(xqz paramxqz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "_ringPlayer onCompletion _activeMode:" + this.a.b.w + " _preRingMode:" + this.a.y);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(true));
    this.a.a(32783, localHashMap);
    this.a.h();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */