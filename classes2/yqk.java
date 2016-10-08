import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yqk
  implements View.OnTouchListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  long b;
  
  public yqk(RecordSVInteractActivity paramRecordSVInteractActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int != 1) {
        break label34;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    label34:
    while (this.jdField_a_of_type_Int != 2) {
      return false;
    }
    this.b = System.currentTimeMillis();
    if (this.b - this.jdField_a_of_type_Long < 1000L) {
      RecordSVInteractActivity.a(this.jdField_a_of_type_CooperationQzoneVideoInteractRecordSVInteractActivity);
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yqk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */