import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotchat.ui.HotChatPttStageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class svj
  implements ValueAnimator.AnimatorUpdateListener
{
  public svj(HotChatPttStageView paramHotChatPttStageView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.a.a.setAlpha(paramValueAnimator.floatValue());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\svj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */