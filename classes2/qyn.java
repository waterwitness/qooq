import android.content.Intent;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.text.TextUtils;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.camera.CameraManager.CameraPictureCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.mobileqq.camera.report.QCameraRuntimeReport;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class qyn
  implements CameraManager.CameraPictureCallback
{
  final String jdField_a_of_type_JavaLangString;
  
  public qyn(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "Q.camera.JpegPictureCallback";
  }
  
  public void a(byte[] paramArrayOfByte, CameraManager.CameraProxy paramCameraProxy)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onPictureTaken] + BEGIN jpgBytes=");
    int i;
    int j;
    if (paramArrayOfByte != null)
    {
      i = paramArrayOfByte.length;
      QLog.d("Q.camera.JpegPictureCallback", 1, i);
      QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).set(false);
      j = QQCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity);
      if (QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity) == null) {
        break label504;
      }
      QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).e();
      paramCameraProxy = paramCameraProxy.a().getPictureSize();
      if (paramCameraProxy != null) {
        QLog.i("Q.camera.JpegPictureCallback", 1, "[onPictureTaken] picSize(" + paramCameraProxy.width + "," + paramCameraProxy.height + ") orientation=" + j);
      }
      label142:
      i = -1;
      paramCameraProxy = QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity);
      if (paramArrayOfByte == null) {
        break label660;
      }
      if (!QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).a().d()) {
        break label515;
      }
      QQCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, 0);
      label182:
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.JpegPictureCallback", 2, "[onPictureTaken] mirror=" + QQCameraActivity.g(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity) + " frontFlip=" + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).a().c() + " jpegRotation=" + QQCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity));
      }
    }
    for (;;)
    {
      try
      {
        int k = QQCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity);
        if ((QQCameraActivity.g(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity)) && (!QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).a().c()))
        {
          bool = true;
          paramArrayOfByte = CameraUtils.a(paramArrayOfByte, k, bool);
        }
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        boolean bool;
        label504:
        label515:
        QLog.e("Q.camera.JpegPictureCallback", 2, "[onPictureTaken] createBitmap failed orientation:" + QQCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity) + ", " + paramArrayOfByte.getMessage(), paramArrayOfByte);
        CameraUtils.a(null);
        this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity.setResult(-2);
        return;
      }
      try
      {
        if ((!TextUtils.isEmpty(paramCameraProxy)) && (paramArrayOfByte != null))
        {
          ImageUtil.a(paramArrayOfByte, QQCameraActivity.g(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity), new File(paramCameraProxy));
          if (QLog.isColorLevel()) {
            QLog.i("Q.camera.JpegPictureCallback", 2, "[onPictureTaken] saveBitmapFileAsJPEG to " + paramCameraProxy);
          }
        }
      }
      catch (IOException localIOException)
      {
        QLog.e("Q.camera.JpegPictureCallback", 2, "[onPictureTaken] saveBitmapFileAsJPEG failed: " + localIOException.getMessage());
        CameraUtils.a(paramArrayOfByte);
        i = -2;
        continue;
      }
      finally
      {
        CameraUtils.a(paramArrayOfByte);
      }
      QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, 0);
      QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).z();
      QQCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, i);
      paramArrayOfByte = new Intent();
      paramArrayOfByte.putExtra("qcamera_photo_filepath", paramCameraProxy);
      paramArrayOfByte.putExtra("qcamera_rotate", j);
      paramArrayOfByte.putExtra("is_custom_camera", true);
      this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity.setResult(i, paramArrayOfByte);
      QLog.i("Q.camera.JpegPictureCallback", 1, "[onPictureTaken] + END orientation=" + j + " jpegRotation=" + QQCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity) + " resultCode=" + i);
      QQCameraActivity.g(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity);
      return;
      i = 0;
      break;
      QLog.e("Q.camera.JpegPictureCallback", 1, "null mCamera ");
      break label142;
      QQCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, CameraUtils.a(QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity), QQCameraActivity.d(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity), j));
      break label182;
      bool = false;
      continue;
      label660:
      i = -3;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */