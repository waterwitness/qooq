import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.WaveView;

public class xvm
  implements ValueAnimator.AnimatorUpdateListener
{
  public xvm(WaveView paramWaveView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((i > WaveView.b) && (i < WaveView.b * 2)) {
      this.a.d = i;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xvm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */