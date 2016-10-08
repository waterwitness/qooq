import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AutoSwitchIconView;

public class wkv
  implements Animation.AnimationListener
{
  public wkv(AutoSwitchIconView paramAutoSwitchIconView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new wkw(this), 1500L);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wkv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */