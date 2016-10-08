import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.control.ColorPicker;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ixy
  implements Animation.AnimationListener
{
  ixy(ixx paramixx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DoodleLayout.d(this.a.a).setAnimation(null);
    DoodleLayout.c(this.a.a).setAnimation(null);
    DoodleLayout.e(this.a.a).setAnimation(null);
    DoodleLayout.b(this.a.a).setAnimation(null);
    DoodleLayout.a(this.a.a).setAnimation(null);
    DoodleLayout.a(this.a.a).setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ixy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */