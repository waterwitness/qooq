import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManager.CameraAFCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qxk
  implements Camera.AutoFocusCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraAFCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraAFCallback;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  
  private qxk(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraAFCallback paramCameraAFCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = paramCameraProxy;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraAFCallback = paramCameraAFCallback;
  }
  
  public static qxk a(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraAFCallback paramCameraAFCallback)
  {
    if ((paramHandler == null) || (paramCameraProxy == null) || (paramCameraAFCallback == null)) {
      return null;
    }
    return new qxk(paramHandler, paramCameraProxy, paramCameraAFCallback);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new qxl(this, paramBoolean));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qxk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */