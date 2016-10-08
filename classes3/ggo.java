import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.av.camera.CameraUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ggo
  implements SurfaceHolder.Callback
{
  public ggo(CameraUtils paramCameraUtils)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "surfaceChanged");
    }
    if (paramSurfaceHolder.getSurface() == null) {
      return;
    }
    paramSurfaceHolder.setFixedSize(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "surfaceCreated");
    }
    CameraUtils.a(this.a);
    this.a.jdField_a_of_type_Boolean = true;
    if (this.a.b) {
      ThreadManager.a(this.a.jdField_a_of_type_Ggt, 8, null, false);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "surfaceDestroyed");
    }
    this.a.jdField_a_of_type_Boolean = false;
    this.a.b = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */