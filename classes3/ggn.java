import android.opengl.GLSurfaceView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.camera.AndroidCamera.CameraPreviewCallback;
import com.tencent.av.camera.CameraUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ggn
  implements AndroidCamera.CameraPreviewCallback
{
  public ggn(CameraUtils paramCameraUtils)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.a.b("onPreviewData");
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramArrayOfByte, paramInt, paramLong, paramBoolean);
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().K == 0) && (this.a.jdField_a_of_type_AndroidOpenglGLSurfaceView != null)) {
        this.a.jdField_a_of_type_AndroidOpenglGLSurfaceView.requestRender();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ggn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */