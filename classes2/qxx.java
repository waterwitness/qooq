import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManager.CameraPictureCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qxx
  implements Camera.PictureCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraPictureCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraPictureCallback;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  
  private qxx(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraPictureCallback paramCameraPictureCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = paramCameraProxy;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraPictureCallback = paramCameraPictureCallback;
  }
  
  public static qxx a(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraPictureCallback paramCameraPictureCallback)
  {
    if ((paramHandler == null) || (paramCameraProxy == null) || (paramCameraPictureCallback == null)) {
      return null;
    }
    return new qxx(paramHandler, paramCameraProxy, paramCameraPictureCallback);
  }
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new qxy(this, paramArrayOfByte));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qxx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */