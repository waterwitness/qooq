import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnOverScrollHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jge
  extends GestureDetector.SimpleOnGestureListener
{
  public jge(TouchWebView paramTouchWebView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (((this.a.f) && (paramFloat2 < 0.0F)) || ((this.a.g) && (this.a.a != null)))
    {
      this.a.a.a((int)(paramFloat2 / 1.5D));
      this.a.g = true;
    }
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */