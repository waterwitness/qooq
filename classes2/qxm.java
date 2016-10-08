import android.hardware.Camera;
import android.hardware.Camera.AutoFocusMoveCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManager.CameraAFMoveCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qxm
  implements Camera.AutoFocusMoveCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraAFMoveCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraAFMoveCallback;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  
  private qxm(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraAFMoveCallback paramCameraAFMoveCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = paramCameraProxy;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraAFMoveCallback = paramCameraAFMoveCallback;
  }
  
  public static qxm a(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraAFMoveCallback paramCameraAFMoveCallback)
  {
    if ((paramHandler == null) || (paramCameraProxy == null) || (paramCameraAFMoveCallback == null)) {
      return null;
    }
    return new qxm(paramHandler, paramCameraProxy, paramCameraAFMoveCallback);
  }
  
  public void onAutoFocusMoving(boolean paramBoolean, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new qxn(this, paramBoolean));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qxm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */