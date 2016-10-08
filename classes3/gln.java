import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gln
  implements Animation.AnimationListener
{
  public gln(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a(this.a.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_ComTencentAvUtilsCircle3D);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gln.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */