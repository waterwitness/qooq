import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class vgy
  implements Animation.AnimationListener
{
  public vgy(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.a.jdField_b_of_type_AndroidViewView.post(new vgz(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vgy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */