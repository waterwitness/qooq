import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.camera.CameraManager.CameraShutterCallback;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class qyt
  implements CameraManager.CameraShutterCallback
{
  private qyt(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(CameraManager.CameraProxy paramCameraProxy)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[onShutter] + BEGIN");
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[onShutter] + end");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */