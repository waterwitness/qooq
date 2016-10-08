import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.FormalView;
import com.tencent.util.AnimateUtils.AnimationAdapter;

public class ttv
  extends AnimateUtils.AnimationAdapter
{
  public ttv(FormalView paramFormalView, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ttv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */