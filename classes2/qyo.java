import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.animation.Animation;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.camera.report.QCameraRuntimeReport;
import com.tencent.mobileqq.camera.ui.PreviewBackground;
import com.tencent.mobileqq.camera.ui.QProgressZoomUI;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class qyo
  extends Handler
{
  public qyo(QQCameraActivity paramQQCameraActivity, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[handleMessage] what=" + paramMessage.what + " arg1=" + paramMessage.arg1 + " arg2=" + paramMessage.arg2 + " obj=" + paramMessage.obj);
    }
    switch (paramMessage.what)
    {
    case 13: 
    case 14: 
    default: 
    case 4: 
    case 6: 
    case 7: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 8: 
    case 9: 
    case 10: 
      do
      {
        do
        {
          for (;;)
          {
            return;
            QQCameraActivity.a(this.a, true);
            return;
            try
            {
              int i = QQCameraActivity.a(this.a).get();
              if ((QQCameraActivity.a(this.a)) && (QQCameraActivity.b(this.a)) && (QQCameraActivity.c(this.a)) && (i == 4))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.camera.CameraActivity", 2, "switch camera finish recycle bg");
                }
                QQCameraActivity.a(this.a).a = null;
                CameraUtils.a(QQCameraActivity.a(this.a));
                QQCameraActivity.a(this.a).invalidate();
                QQCameraActivity.a(this.a).u();
                return;
              }
            }
            catch (Exception paramMessage)
            {
              QLog.e("Q.camera.CameraActivity", 2, "[START_CAMERA] " + paramMessage.getMessage(), paramMessage);
              paramMessage.printStackTrace();
              return;
            }
          }
          QQCameraActivity.a(this.a);
          this.a.e();
          QQCameraActivity.b(this.a);
          QQCameraActivity.a(this.a, 6);
          return;
          removeMessages(1);
          QQCameraActivity.d(this.a);
          return;
          removeMessages(2);
          this.a.a();
          return;
          removeMessages(3);
          QQCameraActivity.a(this.a, (MotionEvent)paramMessage.obj);
          return;
        } while (this.a.c());
        QQCameraActivity.a(this.a).set(true);
        return;
        if ((QQCameraActivity.a(this.a) != null) && (QQCameraActivity.a(this.a).hasStarted())) {
          QQCameraActivity.a(this.a).cancel();
        }
        QQCameraActivity.a(this.a).setVisibility(0);
        sendEmptyMessageDelayed(9, 500L);
        return;
        QQCameraActivity.a(this.a).setVisibility(4);
        return;
        QQCameraActivity.a(this.a, paramMessage.arg1, paramMessage.arg2);
      } while (QQCameraActivity.e(this.a));
      sendEmptyMessageDelayed(11, 5000L);
      return;
    case 11: 
      QQCameraActivity.c(this.a);
      sendEmptyMessageDelayed(12, 5000L);
      return;
    case 12: 
      QQCameraActivity.d(this.a);
      return;
    }
    QQCameraActivity.e(this.a);
    QQCameraActivity.a(this.a, true);
    QQCameraActivity.a(this.a, (MotionEvent)paramMessage.obj);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */