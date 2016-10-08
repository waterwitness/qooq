import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.HorizontalLoadingView;

public class svq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public svq(HorizontalLoadingView paramHorizontalLoadingView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onGlobalLayout()
  {
    int i = this.a.getMeasuredWidth() * 40 / 710;
    View localView = new View(this.a.getContext());
    localView.setBackgroundResource(2130841569);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 3;
    this.a.addView(localView, (ViewGroup.LayoutParams)localObject);
    localObject = ValueAnimator.ofFloat(new float[] { 0.0F, i });
    ((ValueAnimator)localObject).setInterpolator(new LinearInterpolator());
    ((ValueAnimator)localObject).setRepeatMode(1);
    ((ValueAnimator)localObject).setRepeatCount(-1);
    ((ValueAnimator)localObject).setDuration(1000L);
    ((ValueAnimator)localObject).addUpdateListener(new svr(this, localView));
    ((ValueAnimator)localObject).start();
    HorizontalLoadingView.a(this.a, (ValueAnimator)localObject);
    this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\svq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */