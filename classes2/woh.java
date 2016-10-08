import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class woh
  implements Animation.AnimationListener
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  
  woh(wog paramwog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Wog.jdField_a_of_type_AndroidViewView.getBackground();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Wog.jdField_a_of_type_AndroidViewView.getParent() != null)
    {
      this.jdField_a_of_type_Wog.jdField_a_of_type_AndroidViewView.clearAnimation();
      if (QLog.isColorLevel()) {
        QLog.i("ScrollerRunnable", 2, "onAnimationEnd-->clearAnimation");
      }
    }
    this.jdField_a_of_type_Wog.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    if (QLog.isColorLevel()) {
      QLog.i("ScrollerRunnable", 2, "onAnimationEnd:" + hashCode() + "," + this.jdField_a_of_type_Wog.jdField_a_of_type_AndroidViewView.hashCode() + "," + this.jdField_a_of_type_Wog.jdField_a_of_type_AndroidViewView.getParent());
    }
    if ((TroopAioMsgNavigateBar.a(ScrollerRunnable.a(this.jdField_a_of_type_Wog.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable))) && (ScrollerRunnable.a(this.jdField_a_of_type_Wog.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable) != null)) {
      ScrollerRunnable.a(this.jdField_a_of_type_Wog.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable).obtainMessage(50).sendToTarget();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Wog.jdField_a_of_type_AndroidViewView.setBackgroundResource(17170443);
    if (QLog.isColorLevel()) {
      QLog.i("ScrollerRunnable", 2, "onAnimationStart:" + hashCode() + "," + this.jdField_a_of_type_Wog.jdField_a_of_type_AndroidViewView.hashCode() + "," + this.jdField_a_of_type_Wog.jdField_a_of_type_AndroidViewView.getParent());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\woh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */