import com.tencent.mobileqq.camera.CameraManager.CameraPictureCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class qyr
  implements CameraManager.CameraPictureCallback
{
  final String jdField_a_of_type_JavaLangString;
  
  private qyr(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = qyr.class.getSimpleName();
  }
  
  public void a(byte[] paramArrayOfByte, CameraManager.CameraProxy paramCameraProxy)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "[onPictureTaken] + BEGIN");
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "[onPictureTaken] + end");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */