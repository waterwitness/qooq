import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;

public class uiu
  extends GestureDetector.SimpleOnGestureListener
{
  public uiu(StatusHistoryActivity paramStatusHistoryActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
      if ((paramFloat1 <= -this.jdField_a_of_type_Int) && (paramFloat2 < 0.5F)) {
        return StatusHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusHistoryActivity);
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uiu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */