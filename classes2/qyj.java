import android.os.Handler;
import com.tencent.mobileqq.camera.CameraHolder;
import com.tencent.mobileqq.camera.CameraManager.CameraPreviewDataCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.mobileqq.camera.report.QCameraRuntimeReport;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class qyj
  implements CameraManager.CameraPreviewDataCallback
{
  String jdField_a_of_type_JavaLangString;
  
  private qyj(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "Q.camera.CameraPreviewDataCallback";
  }
  
  public void a(byte[] paramArrayOfByte, CameraManager.CameraProxy paramCameraProxy, int paramInt)
  {
    if (QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).compareAndSet(3, 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[onPreviewFrame] startPreview OK " + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).get());
      }
      QQCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[onPreviewFrame] focusAfterPreview " + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).a().b());
      }
      if ((QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).a().b()) && (QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).get() == 0)) {
        QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).sendEmptyMessageDelayed(1, 300L);
      }
    }
    if (QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).a())
    {
      QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).g();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[onPreviewFrame] preview has ready");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */