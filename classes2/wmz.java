import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PaFlashLightView;

public class wmz
  implements Animation.AnimationListener
{
  public wmz(PaFlashLightView paramPaFlashLightView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_Boolean = false;
    if (this.a.c == 0) {
      this.a.jdField_a_of_type_Wnc.sendEmptyMessage(0);
    }
    if (this.a.c == 2) {
      this.a.jdField_a_of_type_Wnc.sendEmptyMessage(2);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wmz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */