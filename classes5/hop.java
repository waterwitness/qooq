import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hop
  implements Animation.AnimationListener
{
  public hop(MultiVideoPlayActivity paramMultiVideoPlayActivity, RelativeLayout paramRelativeLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */