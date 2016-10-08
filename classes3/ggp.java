import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.QavSurfaceTextureListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class ggp
  implements QavSurfaceTextureListener
{
  public ggp(CameraUtils paramCameraUtils)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (CameraUtils.a(this.a))
    {
      CameraUtils.a(this.a);
      this.a.jdField_a_of_type_Boolean = true;
      if (this.a.b) {
        ThreadManager.a(this.a.jdField_a_of_type_Ggt, 8, null, false);
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "onSurfaceTextureDestroyed");
    }
    this.a.jdField_a_of_type_Boolean = false;
    this.a.b = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */