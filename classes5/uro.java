import android.hardware.Camera.PreviewCallback;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

public class uro
  implements Runnable
{
  public uro(CameraProxy paramCameraProxy, boolean paramBoolean, Camera.PreviewCallback paramPreviewCallback)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    urq localurq = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localurq.obtainMessage(203, i, 0, this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback).sendToTarget();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */