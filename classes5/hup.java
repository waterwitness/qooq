import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.ecshopassit.EcShopRecommendView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hup
  implements Animation.AnimationListener
{
  public hup(EcShopRecommendView paramEcShopRecommendView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    ((ViewGroup)this.a.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.a.jdField_a_of_type_AndroidViewView);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */