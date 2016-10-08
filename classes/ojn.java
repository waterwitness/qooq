import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class ojn
  implements View.OnTouchListener
{
  protected float a;
  protected float b;
  
  public ojn(NotificationView paramNotificationView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a(paramMotionEvent.getRawY()))
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
        this.b = paramMotionEvent.getRawY();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a.removeMessages(1013);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a.sendEmptyMessageDelayed(1013, 500L);
      }
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a.removeMessages(1013);
      continue;
      if (paramMotionEvent.getAction() == 2)
      {
        if ((Math.abs(paramMotionEvent.getRawX() - this.jdField_a_of_type_Float) > 60.0F) || (Math.abs(paramMotionEvent.getRawY() - this.b) > 60.0F)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a.removeMessages(1013);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.a.removeMessages(1013);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */