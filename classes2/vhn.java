import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarImagePreviewAdapter;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import java.util.ArrayList;

public class vhn
  implements Animation.AnimationListener
{
  public vhn(TroopBarPublishActivity paramTroopBarPublishActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool = false;
    paramAnimation = this.a;
    paramAnimation.v -= 1;
    if (this.a.v == 0)
    {
      this.a.o = false;
      int i = 0;
      while (i < this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getCount())
      {
        paramAnimation = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(i);
        if (paramAnimation != null) {
          paramAnimation.clearAnimation();
        }
        i += 1;
      }
      this.a.c.clearAnimation();
      this.a.jdField_a_of_type_JavaUtilArrayList.remove(this.a.w);
      paramAnimation = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() < this.a.x) {
        bool = true;
      }
      paramAnimation.a(bool, true);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.a.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vhn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */