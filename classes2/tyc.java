import android.view.animation.Animation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.LSRecordAnimations.LSRecordAnimationCallback;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.qphone.base.util.QLog;

public class tyc
  extends LSRecordAnimations.LSRecordAnimationCallback
{
  public tyc(LSRecordPanel paramLSRecordPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startSideAnimation onAnimationEnd");
    }
    this.a.b = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tyc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */