import android.animation.Animator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yqh
  extends yqs
{
  public yqh(RecordSVInteractActivity paramRecordSVInteractActivity)
  {
    super(paramRecordSVInteractActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.p();
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */