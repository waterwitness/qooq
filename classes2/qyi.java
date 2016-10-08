import com.tencent.mobileqq.camera.CameraManager.CameraAFCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.camera.report.QCameraRuntimeReport;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class qyi
  implements CameraManager.CameraAFCallback
{
  private qyi(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, CameraManager.CameraProxy paramCameraProxy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[onAutoFocus] + ENTER focus=" + paramBoolean);
    }
    if (paramBoolean) {
      QQCameraActivity.c(this.a, 0);
    }
    for (;;)
    {
      QQCameraActivity.a(this.a).a(paramBoolean);
      QQCameraActivity.a(this.a, 0);
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraActivity", 2, "[onAutoFocus] + END");
      }
      return;
      QQCameraActivity.c(this.a, 300);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */