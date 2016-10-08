import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yqf
  implements Animation.AnimationListener
{
  public yqf(RecordSVInteractActivity paramRecordSVInteractActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity) != null)
    {
      RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).clearAnimation();
      paramAnimation = (FrameLayout.LayoutParams)RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).getLayoutParams();
      paramAnimation.topMargin += this.jdField_a_of_type_Int;
      RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).setLayoutParams(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */