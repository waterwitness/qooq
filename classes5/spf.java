import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

class spf
  implements Animation.AnimationListener
{
  spf(spe paramspe)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.e = true;
    this.a.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsDetailActivity.n = 0;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ((View)this.a.jdField_a_of_type_JavaUtilList.get(0)).setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\spf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */