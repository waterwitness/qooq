import android.animation.Animator;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import cooperation.qzone.video.interact.CircleProgressBar;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yqc
  extends yqs
{
  public yqc(RecordSVInteractActivity paramRecordSVInteractActivity, boolean paramBoolean, double paramDouble)
  {
    super(paramRecordSVInteractActivity);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Double < CodecParam.e))
    {
      RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity, 2131367223);
      RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity, 2131367223, 2000L);
    }
    for (;;)
    {
      if (RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).a != null) {
        RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).a.j();
      }
      return;
      RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity, 0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity).a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */