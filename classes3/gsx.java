import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class gsx
  implements Animation.AnimationListener
{
  public gsx(EffectSettingUi paramEffectSettingUi)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (gth)this.a.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.a.jdField_a_of_type_Int));
    if (paramAnimation != null) {
      paramAnimation.a.a();
    }
    this.a.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */