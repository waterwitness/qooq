import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class ieo
  implements Animation.AnimationListener
{
  public ieo(SubscriptRecommendController paramSubscriptRecommendController)
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
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.a.h > 0) && (this.a.i > 0)) {
      ((ImageView)((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131300557)).setLayoutParams(new LinearLayout.LayoutParams(this.a.i, this.a.h));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ieo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */