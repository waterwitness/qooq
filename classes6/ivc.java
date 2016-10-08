import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.biz.qqstory.takevideo.NewStoryFilterViewPagerController.ItemViewGestureListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ivc
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private NewStoryFilterViewPagerController.ItemViewGestureListener jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  private boolean jdField_b_of_type_Boolean;
  
  public ivc(NewStoryFilterViewPagerController.ItemViewGestureListener paramItemViewGestureListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener = paramItemViewGestureListener;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener == null) {}
    do
    {
      do
      {
        float f;
        do
        {
          do
          {
            return true;
            f = paramMotionEvent.getY();
            switch (paramMotionEvent.getAction() & 0xFF)
            {
            case 3: 
            case 4: 
            default: 
              return true;
            case 0: 
              this.jdField_a_of_type_Int = ((int)f);
              this.jdField_a_of_type_Boolean = false;
              this.jdField_b_of_type_Boolean = false;
              this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
              return true;
            }
          } while (paramMotionEvent.getPointerCount() > 2);
          if (this.jdField_b_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener.a(paramMotionEvent);
            return true;
          }
          this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
          this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener.a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent);
        } while ((!this.jdField_b_of_type_Boolean) || (!(paramView instanceof ViewParent)));
        ((ViewParent)paramView).requestDisallowInterceptTouchEvent(true);
        return true;
        if (Math.abs((int)(f - this.jdField_a_of_type_Int)) > 5) {
          this.jdField_a_of_type_Boolean = true;
        }
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener.a(paramMotionEvent);
      return true;
    } while ((paramMotionEvent.getPointerCount() > 2) || (!this.jdField_b_of_type_Boolean));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener.a(paramMotionEvent);
    return true;
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener.a(paramView);
    }
    if ((this.jdField_b_of_type_Boolean) && ((paramView instanceof ViewParent))) {
      ((ViewParent)paramView).requestDisallowInterceptTouchEvent(false);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$ItemViewGestureListener.a(paramMotionEvent);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */