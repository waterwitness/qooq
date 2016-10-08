import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lgm
  implements Runnable
{
  lgm(lgl paramlgl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.offsetTopAndBottom(-this.a.jdField_a_of_type_Int);
    DiscussionMemberActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity).setVisibility(0);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getWindow().peekDecorView().getWindowToken(), 0);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */