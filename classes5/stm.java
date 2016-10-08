import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class stm
  implements Runnable
{
  stm(stl paramstl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.a.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\stm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */