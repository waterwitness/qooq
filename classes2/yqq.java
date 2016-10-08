import android.animation.Animator;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yqq
  extends yqs
{
  public yqq(RecordSVInteractActivity paramRecordSVInteractActivity)
  {
    super(paramRecordSVInteractActivity);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecordSVInteractActivity", 2, "enterRecordModeAnimation: onAnimationEnd <<===");
    }
    RecordSVInteractActivity.a(this.a).a.i();
    RecordSVInteractActivity.b(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    RecordSVInteractActivity.a(this.a).setImageResource(2130842047);
    RecordSVInteractActivity.a(this.a).setLongClickable(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */