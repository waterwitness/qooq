import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oyt
  extends TouchDelegate
{
  public oyt(DragTextView paramDragTextView, Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.getVisibility() != 0) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    boolean bool = super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.setLocation(f1, f2);
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oyt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */