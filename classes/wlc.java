import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.ClearableEditText.OnTextClearedListener;

public class wlc
  implements View.OnTouchListener
{
  public wlc(ClearableEditText paramClearableEditText)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 1;
    if (this.a.getCompoundDrawables()[2] == null) {}
    label107:
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 1)
      {
        if (paramMotionEvent.getX() > this.a.getWidth() - this.a.getPaddingRight() - this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()) {}
        for (;;)
        {
          if (i == 0) {
            break label107;
          }
          this.a.setText("");
          this.a.setClearButtonVisible(false);
          if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener == null) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText$OnTextClearedListener.a();
          return false;
          i = 0;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */