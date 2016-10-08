import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;

public class wol
  extends GestureDetector.SimpleOnGestureListener
{
  public wol(SlideDetectListView paramSlideDetectListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > 0.0F) && (Math.abs(paramFloat1) > Math.abs(paramFloat2) * 2.0F) && (this.a.c == 0) && (!this.a.jdField_a_of_type_Boolean) && (Math.abs(paramFloat1) > this.a.f))
    {
      this.a.jdField_b_of_type_Int = this.a.a(this.a.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_AndroidViewView = this.a.a(this.a.jdField_b_of_type_Int);
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        this.a.jdField_a_of_type_Boolean = true;
        this.a.setPressed(false);
        this.a.jdField_a_of_type_AndroidViewView.setPressed(false);
        if (SlideDetectListView.a(this.a) != null)
        {
          int i = this.a.jdField_b_of_type_Int;
          int j = this.a.m();
          SlideDetectListView.a(this.a).a(this.a, this.a.jdField_a_of_type_AndroidViewView, i - j);
        }
        this.a.jdField_a_of_type_Int = 0;
        return true;
      }
      this.a.jdField_b_of_type_Boolean = true;
      return true;
    }
    if (Math.abs(paramFloat1) > Math.abs(paramFloat2) * 2.0F) {
      this.a.jdField_b_of_type_Boolean = true;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */