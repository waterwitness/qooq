import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class itp
  implements ValueAnimator.AnimatorUpdateListener
{
  public itp(StoryDownloadView paramStoryDownloadView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.q = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\itp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */