import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.t9search.KeyboardButton;
import com.tencent.mobileqq.t9search.T9KeyBoard;
import com.tencent.mobileqq.t9search.T9KeyBoard.onKeyClickListener;

public class uyf
  implements View.OnTouchListener
{
  long jdField_a_of_type_Long;
  long b;
  
  private uyf(T9KeyBoard paramT9KeyBoard)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return false;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.jdField_a_of_type_AndroidOsHandler.postDelayed(T9KeyBoard.a(this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard), 800L);
      return false;
      this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.jdField_a_of_type_AndroidOsHandler.removeCallbacks(T9KeyBoard.a(this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard));
      this.b = SystemClock.uptimeMillis();
    } while (this.b - this.jdField_a_of_type_Long < 800L);
    if (this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener.a(this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.jdField_a_of_type_JavaLangStringBuilder.toString(), true);
      int i = this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.jdField_a_of_type_JavaLangStringBuilder.length() - 1;
      if (i >= 0) {
        this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard$onKeyClickListener.a(this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard.jdField_a_of_type_JavaLangStringBuilder.charAt(i));
      }
    }
    T9KeyBoard.a(this.jdField_a_of_type_ComTencentMobileqqT9searchT9KeyBoard).setPressed(false);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uyf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */