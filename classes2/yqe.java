import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Intent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.video.interact.CircularCameraSurfaceView;
import cooperation.qzone.video.interact.ParaMoveImageView;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yqe
  implements Animator.AnimatorListener
{
  public yqe(RecordSVInteractActivity paramRecordSVInteractActivity, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidContentIntent.setAction("com.qzone.live.RECORD_ANI_END");
    this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity.sendBroadcast(this.jdField_a_of_type_AndroidContentIntent);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).setVisibility(8);
    RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).setVisibility(8);
    RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).setVisibility(8);
    RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).setVisibility(0);
    this.jdField_a_of_type_AndroidContentIntent.setAction("com.qzone.live.RECORD_ANI_START");
    this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity.sendBroadcast(this.jdField_a_of_type_AndroidContentIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */