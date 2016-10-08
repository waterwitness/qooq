import android.view.View;
import android.view.animation.AnimationSet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ScrollerRunnable;

public class wog
  implements Runnable
{
  public wog(ScrollerRunnable paramScrollerRunnable, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    woi localwoi1 = new woi(this.jdField_a_of_type_AndroidViewView, 1.0F, 0.0F);
    localwoi1.setFillEnabled(true);
    localwoi1.setDuration(700L);
    woi localwoi2 = new woi(this.jdField_a_of_type_AndroidViewView, 0.0F, 1.0F);
    localwoi2.setFillEnabled(true);
    localwoi2.setStartTime(700L);
    localwoi2.setDuration(700L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localwoi1);
    localAnimationSet.addAnimation(localwoi2);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new woh(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
    ScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, -1L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */