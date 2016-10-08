package cooperation.huangye;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HYTopGestureLayout$HYTopGestureDetector
  extends TopGestureLayout.TopGestureDetector
{
  public HYTopGestureLayout$HYTopGestureDetector(HYTopGestureLayout paramHYTopGestureLayout, Context paramContext)
  {
    super(paramHYTopGestureLayout, paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((HYTopGestureLayout.a(this.a)) || (HYTopGestureLayout.b(this.a))) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
    int i = HYTopGestureLayout.a(this.a) / 4;
    if ((HYTopGestureLayout.a(this.a, 1)) && (paramFloat1 < 0.0F) && (paramFloat2 < 0.5F) && (this.a.mOnFlingGesture != null) && (paramMotionEvent1.getX() < i))
    {
      HYTopGestureLayout.a(this.a, -1);
      this.a.mOnFlingGesture.flingLToR();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYTopGestureLayout$HYTopGestureDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */