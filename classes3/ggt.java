import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.QavTextureView;
import com.tencent.av.camera.VcCamera;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ggt
  implements Runnable
{
  public ggt(CameraUtils paramCameraUtils)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "openCamera begin.");
    }
    CameraUtils.a(this.a).a(new Object[] { Integer.valueOf(1) });
    this.a.b = false;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.G = 0;
      this.a.jdField_a_of_type_ComTencentAvVideoController.g = false;
    }
    Object localObject;
    boolean bool;
    if (CameraUtils.a(this.a))
    {
      if (this.a.jdField_a_of_type_AndroidViewView == null) {
        break label424;
      }
      localObject = (QavTextureView)this.a.jdField_a_of_type_AndroidViewView;
      if (Build.VERSION.SDK_INT < 14) {
        break label419;
      }
      localObject = ((QavTextureView)localObject).getSurfaceTexture();
      bool = this.a.jdField_a_of_type_ComTencentAvCameraVcCamera.a((SurfaceTexture)localObject);
    }
    for (;;)
    {
      int j;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        j = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
        if (this.a.jdField_a_of_type_ComTencentAvCameraVcCamera.j() != 0) {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().l = true;
        }
        i = j;
        if (bool)
        {
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().i = false;
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().K = false;
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Boolean = true;
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 1) {
            break label363;
          }
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 2;
          this.a.jdField_a_of_type_ComTencentAvVideoController.f(2);
          label274:
          this.a.a("OpenCameraRunnable.run");
        }
      }
      for (int i = j;; i = 0)
      {
        CameraUtils.a(this.a).a(new Object[] { Integer.valueOf(2), Boolean.valueOf(bool), Integer.valueOf(i) });
        if (QLog.isColorLevel()) {
          QLog.d("CameraUtils", 2, "openCamera end.");
        }
        return;
        localObject = this.a.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
        bool = this.a.jdField_a_of_type_ComTencentAvCameraVcCamera.a((SurfaceHolder)localObject);
        break;
        label363:
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 3) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int != 4)) {
          break label274;
        }
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int = 4;
        break label274;
      }
      label419:
      localObject = null;
      break;
      label424:
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */