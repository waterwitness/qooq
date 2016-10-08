import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.ui.PopupMenuPA;
import com.tencent.biz.ui.PopupMenuPA.AnimationCallbacks;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jfz
  implements PopupMenuPA.AnimationCallbacks
{
  public jfz(PopupMenuPA paramPopupMenuPA)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.b.findViewById(2131298198).setVisibility(0);
      localAnimation = AnimationUtils.loadAnimation(this.a.jdField_a_of_type_AndroidContentContext, 2130968650);
      this.a.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.a.jdField_a_of_type_AndroidContentContext, 2130968651);
    this.a.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1) {
      this.a.c();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */