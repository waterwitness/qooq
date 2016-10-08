import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class grt
  implements Animation.AnimationListener
{
  public grt(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.d.clearAnimation();
    this.a.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.setVisibility(8);
    if (this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
      this.a.jdField_a_of_type_ComTencentAvUtilsTipsManager.b();
    }
    this.a.b = 0;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */