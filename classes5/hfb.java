import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hfb
  extends GestureDetector.SimpleOnGestureListener
{
  public hfb(PoiMapActivity paramPoiMapActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    PoiMapActivity.a(this.a, null);
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    PoiMapActivity.a(this.a, null);
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.a.m();
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */