import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rmf
  implements Animation.AnimationListener
{
  public rmf(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AlphaAnimation(0.2F, 0.0F);
    paramAnimation.setDuration(500L);
    paramAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rmf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */