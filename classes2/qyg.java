import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class qyg
  implements View.OnTouchListener
{
  private long jdField_a_of_type_Long;
  
  public qyg(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).get()) || (QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).get() != 0)) {
      return false;
    }
    if (paramMotionEvent.getAction() == 0) {
      if (QQCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity) == 0)
      {
        if (QQCameraActivity.c(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity) > 0) {
          QQCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).width() / 2 / QQCameraActivity.c(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity));
        }
      }
      else
      {
        QQCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, (int)paramMotionEvent.getX());
        QQCameraActivity.g(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, (int)paramMotionEvent.getY());
        if (QQCameraActivity.h(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity))
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          paramView = QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).obtainMessage(15, paramMotionEvent);
          QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).sendMessageDelayed(paramView, 500L);
        }
      }
    }
    label290:
    do
    {
      for (;;)
      {
        QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).onTouchEvent(paramMotionEvent);
        return true;
        QQCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, 5);
        break;
        if (paramMotionEvent.getAction() != 2) {
          break label290;
        }
        if (QQCameraActivity.h(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity))
        {
          j = (int)paramMotionEvent.getX();
          i = (int)paramMotionEvent.getY();
          j = Math.abs(j - QQCameraActivity.h(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity));
          i = Math.abs(i - QQCameraActivity.i(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity));
          if ((j > 5) && (i > 5) && (System.currentTimeMillis() < this.jdField_a_of_type_Long + 500L))
          {
            QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, false);
            QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).removeMessages(15);
          }
        }
      }
    } while (paramMotionEvent.getAction() != 1);
    int j = (int)paramMotionEvent.getX();
    int i = (int)paramMotionEvent.getY();
    j = Math.abs(j - QQCameraActivity.h(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity));
    i = Math.abs(i - QQCameraActivity.i(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity));
    if (QQCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity)) {
      QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).sendEmptyMessageDelayed(11, 5000L);
    }
    for (;;)
    {
      QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, false);
      break;
      QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).removeMessages(15);
      if ((QQCameraActivity.h(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity)) && (j <= 5) && (i <= 5))
      {
        QQCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity);
        paramView = QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).obtainMessage(3, paramMotionEvent);
        QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).sendMessageDelayed(paramView, QQCameraActivity.j(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity));
        QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, System.currentTimeMillis());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */