import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView;
import com.tencent.biz.qqstory.view.widget.StrokeTextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ipp
  implements Animation.AnimationListener
{
  public ipp(ExploreAnimalView paramExploreAnimalView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
    this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(600L);
    this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setRepeatCount(-1);
    this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setRepeatMode(2);
    this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    paramAnimation = (ImageView)this.a.findViewById(2131302835);
    ImageView localImageView1 = (ImageView)this.a.findViewById(2131302836);
    ImageView localImageView2 = (ImageView)this.a.findViewById(2131297122);
    ExploreAnimalView.a(this.a, paramAnimation, 100L);
    ExploreAnimalView.a(this.a, localImageView1, 240L);
    ExploreAnimalView.a(this.a, localImageView2, 360L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ipp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */