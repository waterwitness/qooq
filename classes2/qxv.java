import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManager.CameraFaceDetectionCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qxv
  implements Camera.FaceDetectionListener
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraFaceDetectionCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraFaceDetectionCallback;
  private final CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  
  private qxv(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraFaceDetectionCallback paramCameraFaceDetectionCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = paramCameraProxy;
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraFaceDetectionCallback = paramCameraFaceDetectionCallback;
  }
  
  public static qxv a(Handler paramHandler, CameraManager.CameraProxy paramCameraProxy, CameraManager.CameraFaceDetectionCallback paramCameraFaceDetectionCallback)
  {
    if ((paramHandler == null) || (paramCameraProxy == null) || (paramCameraFaceDetectionCallback == null)) {
      return null;
    }
    return new qxv(paramHandler, paramCameraProxy, paramCameraFaceDetectionCallback);
  }
  
  public void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera)
  {
    QLog.d("Q.camera.CameraManagerImpl", 2, "[onFaceDetection] faces = " + paramArrayOfFace + ", length = " + paramArrayOfFace.length);
    this.jdField_a_of_type_AndroidOsHandler.post(new qxw(this, paramArrayOfFace));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qxv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */