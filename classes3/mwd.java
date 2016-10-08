import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class mwd
  implements Runnable
{
  private WeakReference a;
  
  public mwd(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new WeakReference(paramTroopMemberListActivity);
  }
  
  public void run()
  {
    TroopMemberListActivity localTroopMemberListActivity = (TroopMemberListActivity)this.a.get();
    if (localTroopMemberListActivity != null)
    {
      localTroopMemberListActivity.e = false;
      int i = localTroopMemberListActivity.jdField_a_of_type_AndroidViewView.getHeight();
      localTroopMemberListActivity.jdField_a_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom(-i);
      localTroopMemberListActivity.jdField_a_of_type_AndroidViewView.setVisibility(0);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTroopMemberListActivity.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
      ((InputMethodManager)localTroopMemberListActivity.getSystemService("input_method")).hideSoftInputFromWindow(localTroopMemberListActivity.getWindow().peekDecorView().getWindowToken(), 0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mwd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */