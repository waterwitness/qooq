import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lgl
  implements DialogInterface.OnDismissListener
{
  public lgl(DiscussionMemberActivity paramDiscussionMemberActivity, int paramInt, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager, FriendListObserver paramFriendListObserver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.getHandler().postDelayed(new lgm(this), 150L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lgl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */