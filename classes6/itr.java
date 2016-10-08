import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class itr
  implements ValueAnimator.AnimatorUpdateListener
{
  public itr(StoryDownloadView paramStoryDownloadView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.r = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\itr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */