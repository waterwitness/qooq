import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class nvu
  implements View.OnTouchListener
{
  nvu(nvt paramnvt, PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nvu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */