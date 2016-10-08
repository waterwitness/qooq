import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iqj
  implements Animation.AnimationListener
{
  public iqj(QQStoryBaseActivity paramQQStoryBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.c != null)
    {
      ((ViewGroup)this.a.findViewById(16908290)).removeView(this.a.c);
      this.a.c = null;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */