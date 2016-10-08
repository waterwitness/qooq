import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PaFlashLightView;

public class wna
  implements Animation.AnimationListener
{
  public wna(PaFlashLightView paramPaFlashLightView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_Wnc.sendEmptyMessage(1);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wna.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */