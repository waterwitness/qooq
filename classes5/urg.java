import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

public class urg
  implements Runnable
{
  public urg(CameraProxy paramCameraProxy, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    urq localurq = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      localurq.obtainMessage(401, i, 0).sendToTarget();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\urg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */