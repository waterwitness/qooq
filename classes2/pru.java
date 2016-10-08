import android.view.SurfaceHolder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.SoftReference;

public class pru
  implements Animation.AnimationListener
{
  private SoftReference a;
  
  public pru(ApolloGuestsStateActivity paramApolloGuestsStateActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new SoftReference(paramApolloGuestsStateActivity);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ApolloGuestsStateActivity)this.a.get();
    if (paramAnimation == null) {
      return;
    }
    paramAnimation.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(paramAnimation, null);
    paramAnimation.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getHolder().setFormat(-2);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    paramAnimation.c = ((RelativeLayout)paramAnimation.jdField_a_of_type_AndroidViewView.findViewById(2131297065));
    ((RelativeLayout.LayoutParams)paramAnimation.c.getLayoutParams()).bottomMargin = ((int)(paramAnimation.b * 0.3D));
    paramAnimation.c.requestLayout();
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    paramAnimation.c.addView(paramAnimation.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView, localLayoutParams);
    paramAnimation.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a(new prs(paramAnimation));
    paramAnimation.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderInterfaceImpl = paramAnimation.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a();
    paramAnimation.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\pru.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */