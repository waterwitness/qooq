import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle;

public class urj
  implements Runnable
{
  public urj(CameraProxy paramCameraProxy, CameraProxy.WaitDoneBundle paramWaitDoneBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a.obtainMessage(205).sendToTarget();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a.post(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$WaitDoneBundle.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\urj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */