import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.biz.qqstory.view.RingView.DrawInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class izs
  implements ValueAnimator.AnimatorUpdateListener
{
  public izs(NeoVideoRecordButton paramNeoVideoRecordButton)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a.a(((Integer)paramValueAnimator.getAnimatedValue("border")).intValue(), 0.0F);
    this.a.a.b(((Integer)paramValueAnimator.getAnimatedValue("ring")).intValue(), 0.0F);
    this.a.b.a(((Integer)paramValueAnimator.getAnimatedValue("center")).intValue(), 0.0F);
    this.a.b.c(((Integer)paramValueAnimator.getAnimatedValue("color")).intValue());
    NeoVideoRecordButton.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */