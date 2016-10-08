import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class izy
  implements Animation.AnimationListener
{
  public izy(StoryNewGuideDialog paramStoryNewGuideDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\izy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */