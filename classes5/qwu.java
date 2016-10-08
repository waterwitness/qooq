import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper.CameraHelperCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class qwu
  implements Camera.PictureCallback
{
  public qwu(CameraHelper paramCameraHelper, File paramFile, Rect paramRect1, Rect paramRect2, CameraHelper.CameraHelperCallback paramCameraHelperCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(CameraHelper.a, 2, "onPictureTaken data is null");
      }
      return;
    }
    new qwx(this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper, paramArrayOfByte, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_ComTencentMobileqqBusinessCardHelpersCameraHelper$CameraHelperCallback).execute(new Void[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */