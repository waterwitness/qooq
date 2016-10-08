import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.view.SurfaceView;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.QavTextureView;
import com.tencent.av.camera.VcCamera;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ggu
  implements Runnable
{
  public ggu(CameraUtils paramCameraUtils)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "switchCamera begin.");
    }
    CameraUtils.a(this.a).a(new Object[] { Integer.valueOf(5) });
    if (this.a.jdField_a_of_type_ComTencentAvCameraVcCamera != null)
    {
      if (!CameraUtils.a(this.a)) {
        break label145;
      }
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = (QavTextureView)this.a.jdField_a_of_type_AndroidViewView;
        if (Build.VERSION.SDK_INT < 14) {
          break label169;
        }
      }
    }
    label145:
    label169:
    for (Object localObject = ((QavTextureView)localObject).getSurfaceTexture();; localObject = null)
    {
      this.a.jdField_a_of_type_ComTencentAvCameraVcCamera.b((SurfaceTexture)localObject);
      for (;;)
      {
        CameraUtils.a(this.a).a(new Object[] { Integer.valueOf(6), Boolean.valueOf(true) });
        if (QLog.isColorLevel()) {
          QLog.d("CameraUtils", 2, "switchCamera end.");
        }
        return;
        this.a.jdField_a_of_type_ComTencentAvCameraVcCamera.b(this.a.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */