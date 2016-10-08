import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

public class urn
  implements Runnable
{
  public urn(CameraProxy paramCameraProxy, SurfaceHolder paramSurfaceHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a.obtainMessage(202, this.jdField_a_of_type_AndroidViewSurfaceHolder).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\urn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */