import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nnk
  implements View.OnTouchListener
{
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  View jdField_a_of_type_AndroidViewView;
  final OnLongClickAndTouchListener jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener;
  
  public nnk(QQStoryCommentItemBuilder paramQQStoryCommentItemBuilder, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new nnl(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener.onTouch(paramView, paramMotionEvent);
    }
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return true;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nnk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */