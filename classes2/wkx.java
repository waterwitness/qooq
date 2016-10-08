import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.AutoSwitchIconView;

public class wkx
  implements Animation.AnimationListener
{
  public wkx(AutoSwitchIconView paramAutoSwitchIconView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.a.jdField_a_of_type_AndroidWidgetImageView.getTag() instanceof Integer))
    {
      if (((Integer)this.a.jdField_a_of_type_AndroidWidgetImageView.getTag()).intValue() != 2130841025) {
        break label82;
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841026);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130841026));
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
      return;
      label82:
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841025);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2130841025));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */