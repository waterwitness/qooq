import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.VcCamera;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ggr
  implements Runnable
{
  private boolean jdField_a_of_type_Boolean;
  
  public ggr(CameraUtils paramCameraUtils)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "closeCamera begin.");
    }
    CameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraUtils).a(new Object[] { Integer.valueOf(3) });
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvCameraVcCamera.d();
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b("CloseCameraRunnable.run");
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 2) {
        break label211;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = false;
        if (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().g)
        {
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.f(1);
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().K = true;
        }
      }
    }
    for (;;)
    {
      CameraUtils.a(this.jdField_a_of_type_ComTencentAvCameraCameraUtils).a(new Object[] { Integer.valueOf(4), Boolean.valueOf(true) });
      if (QLog.isColorLevel()) {
        QLog.d("CameraUtils", 2, "closeCamera end.");
      }
      return;
      label211:
      if ((this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int == 4) && (!this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().g)) {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 3;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */