import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeMediaPlayer;
import com.tencent.sharp.jni.TraeMediaPlayer.OnCompletionListener;
import java.util.TimerTask;

public class xri
  extends TimerTask
{
  public xri(TraeMediaPlayer paramTraeMediaPlayer)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (TraeMediaPlayer.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "TraeMediaPlay | play timeout");
      }
      if (TraeMediaPlayer.a(this.a) != null) {
        TraeMediaPlayer.a(this.a).a();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */