import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rdm
  implements DialogInterface.OnDismissListener
{
  public rdm(DatingDestinationActivity paramDatingDestinationActivity, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.b.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */