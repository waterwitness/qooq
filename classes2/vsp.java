import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallView;

public class vsp
  implements Animation.AnimationListener
{
  public vsp(AvatarWallView paramAvatarWallView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    int i = 0;
    paramAnimation = this.a;
    paramAnimation.p -= 1;
    if (this.a.p <= 0)
    {
      this.a.e = true;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b(this.a.jdField_a_of_type_Int, this.a.m);
      if (this.a.d)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.f();
        this.a.d = false;
      }
      int j = this.a.getChildCount();
      while (i < j)
      {
        this.a.getChildAt(i).clearAnimation();
        i += 1;
      }
      this.a.jdField_a_of_type_Int = this.a.m;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */