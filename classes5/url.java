import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle;

public class url
  implements Runnable
{
  public url(CameraProxy paramCameraProxy, CameraProxy.WaitDoneBundle paramWaitDoneBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a.obtainMessage(2).sendToTarget();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a.post(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$WaitDoneBundle.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\url.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */