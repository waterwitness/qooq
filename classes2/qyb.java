import android.hardware.Camera.ShutterCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.camera.CameraManager.CameraShutterCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qyb
  implements Camera.ShutterCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  private final CameraManager.CameraShutterCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraShutterCallback;
  
  private qyb(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraShutterCallback paramCameraShutterCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = paramCameraProxy;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraShutterCallback = paramCameraShutterCallback;
  }
  
  public static qyb a(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraShutterCallback paramCameraShutterCallback)
  {
    if ((paramHandler == null) || (paramCameraProxy == null) || (paramCameraShutterCallback == null)) {
      return null;
    }
    return new qyb(paramHandler, paramCameraProxy, paramCameraShutterCallback);
  }
  
  public void onShutter()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new qyc(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */