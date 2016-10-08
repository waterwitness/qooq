import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManager.CameraPreviewDataCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qxz
  implements Camera.PreviewCallback
{
  private static long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraPreviewDataCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraPreviewDataCallback;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  
  private qxz(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraPreviewDataCallback paramCameraPreviewDataCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = paramCameraProxy;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraPreviewDataCallback = paramCameraPreviewDataCallback;
  }
  
  public static qxz a(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraPreviewDataCallback paramCameraPreviewDataCallback)
  {
    if ((paramHandler == null) || (paramCameraProxy == null) || (paramCameraPreviewDataCallback == null)) {
      return null;
    }
    return new qxz(paramHandler, paramCameraProxy, paramCameraPreviewDataCallback);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new qya(this, paramArrayOfByte));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qxz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */