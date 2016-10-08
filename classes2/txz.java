import android.os.Handler;
import android.view.animation.Animation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.LSRecordAnimations.LSRecordAnimationCallback;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.qphone.base.util.QLog;

public class txz
  extends LSRecordAnimations.LSRecordAnimationCallback
{
  public txz(LSRecordPanel paramLSRecordPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS stopRecordingBarAnimation onAnimationEnd");
    }
    LSRecordPanel.a(this.a).post(new tya(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\txz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */