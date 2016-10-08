import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.QZoneTopGestureLayout;

public class yla
  extends TopGestureLayout.TopGestureDetector
{
  public static final float a = 500.0F;
  
  public yla(QZoneTopGestureLayout paramQZoneTopGestureLayout, Context paramContext)
  {
    super(paramQZoneTopGestureLayout, paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!QZoneTopGestureLayout.a()) {
      QZoneTopGestureLayout.b(this.a, -1);
    }
    if ((QZoneTopGestureLayout.a(this.a)) || (QZoneTopGestureLayout.b(this.a))) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
    if ((QZoneTopGestureLayout.a(this.a, 1)) && (paramFloat2 < 0.0F) && (f < 0.5F) && (this.a.mOnFlingGesture != null) && (paramFloat1 > 500.0F))
    {
      QZoneTopGestureLayout.c(this.a, -1);
      this.a.mOnFlingGesture.flingLToR();
      return true;
    }
    return false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!QZoneTopGestureLayout.a()) {
      QZoneTopGestureLayout.a(this.a, -1);
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yla.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */