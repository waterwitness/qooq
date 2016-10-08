import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.av.widget.ChildLockCircle.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class grs
  implements Animation.AnimationListener
{
  public grs(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.d.clearAnimation();
    this.a.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.setVisibility(0);
    if (this.a.b == 1)
    {
      this.a.b = 2;
      this.a.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.a();
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener.d();
    this.a.jdField_a_of_type_ComTencentAvWidgetChildLockCircle$AnimationListener.b();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */