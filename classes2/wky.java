import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.BounceScrollView;

public class wky
  extends GestureDetector.SimpleOnGestureListener
{
  public wky(BounceScrollView paramBounceScrollView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) >= Math.abs(paramFloat1);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */