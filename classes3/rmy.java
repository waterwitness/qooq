import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rmy
  implements Animation.AnimationListener
{
  public rmy(Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((Face2FaceFriendBubbleView.a(this.a) == 2) || (Face2FaceFriendBubbleView.a(this.a) == 3) || (Face2FaceFriendBubbleView.a(this.a) == 4))
    {
      Face2FaceFriendBubbleView.a(this.a).startAnimation(Face2FaceFriendBubbleView.a(this.a));
      return;
    }
    Face2FaceFriendBubbleView.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\rmy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */