import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

class grv
  implements Runnable
{
  grv(gru paramgru)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a.jdField_b_of_type_AndroidViewAnimationAnimation == null) && (this.a.a.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      this.a.a.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation((Context)this.a.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130968697);
    }
    if (this.a.a.jdField_b_of_type_AndroidViewAnimationAnimation != null)
    {
      this.a.a.jdField_b_of_type_Int = 3;
      this.a.a.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.a.a.c);
      this.a.a.jdField_a_of_type_ComTencentAvWidgetChildLockCircle.startAnimation(this.a.a.jdField_b_of_type_AndroidViewAnimationAnimation);
      return;
    }
    this.a.a.c.onAnimationEnd(this.a.a.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\grv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */