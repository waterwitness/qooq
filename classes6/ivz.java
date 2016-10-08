import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.NewStoryRMViewSTInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ivz
  implements Animation.AnimationListener
{
  public ivz(NewStoryRMViewSTInterface paramNewStoryRMViewSTInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.b.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */