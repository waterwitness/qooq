import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gyx
  implements GestureDetector.OnGestureListener
{
  public gyx(VideoControlUI paramVideoControlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if ((this.a.m != null) && (this.a.m.isShown())) {
      this.a.m.setVisibility(8);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gyx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */