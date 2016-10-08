import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.camera.report.QCameraRuntimeReport;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class qyf
  implements View.OnClickListener
{
  public qyf(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131300770: 
    case 2131300769: 
    case 2131300771: 
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.camera.CameraActivity", 2, "[onClick] flash light");
            }
          } while (!QQCameraActivity.a(this.a).compareAndSet(true, false));
          QQCameraActivity.h(this.a);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.camera.CameraActivity", 2, "[onClick] front-back cameraId=" + QQCameraActivity.d(this.a));
          }
        } while (!QQCameraActivity.a(this.a).compareAndSet(true, false));
        QQCameraActivity.i(this.a);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.camera.CameraActivity", 2, "[onClick] capture autoFocus=" + QQCameraActivity.h(this.a));
        }
      } while (!QQCameraActivity.a(this.a).compareAndSet(true, false));
      QQCameraActivity.a(this.a).obtainMessage(5).sendToTarget();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[onClick] cancel");
    }
    QQCameraActivity.a(this.a).e(2);
    ReportController.b(null, "dc00898", "", "", "0X8007122", "0X8007122", 0, 0, "", "", "", "");
    QQCameraActivity.g(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */