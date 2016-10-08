import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.FriendChooser;

public class wqz
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float;
  float b;
  
  public wqz(FriendChooser paramFriendChooser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Float = 0.0F;
    this.b = 0.0F;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.b = paramMotionEvent.getRawY();
    }
    while ((i != 2) || ((paramMotionEvent.getRawX() - this.jdField_a_of_type_Float <= 10.0F) && (paramMotionEvent.getRawY() - this.b <= 10.0F))) {
      return false;
    }
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */