import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.biz.qqstory.view.RingView.DrawInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class izt
  implements ValueAnimator.AnimatorUpdateListener
{
  public izt(NeoVideoRecordButton paramNeoVideoRecordButton)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c.a(((Integer)paramValueAnimator.getAnimatedValue("radius")).intValue(), 0.0F);
    this.a.c.c(((Integer)paramValueAnimator.getAnimatedValue("color")).intValue());
    NeoVideoRecordButton.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */