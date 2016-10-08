import android.view.animation.Animation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.LSRecordAnimations.LSRecordAnimationCallback;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.qphone.base.util.QLog;

public class tyb
  extends LSRecordAnimations.LSRecordAnimationCallback
{
  public tyb(LSRecordPanel paramLSRecordPanel)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Animation paramAnimation, float paramFloat)
  {
    if ((this.a.c == null) && (this.a.a != null) && (paramFloat >= 0.5F)) {
      this.a.f();
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LsRecord", 4, "LS startExpandAnimation onAnimationEnd");
    }
    if (paramAnimation == this.a.a) {
      this.a.h();
    }
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tyb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */