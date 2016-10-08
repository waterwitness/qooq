import android.graphics.SurfaceTexture;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

public class urm
  implements Runnable
{
  public urm(CameraProxy paramCameraProxy, SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a.obtainMessage(201, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\urm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */