import android.graphics.Rect;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

public class ure
  implements Runnable
{
  public ure(CameraProxy paramCameraProxy, Rect paramRect)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a.obtainMessage(103);
    localMessage.obj = this.jdField_a_of_type_AndroidGraphicsRect;
    localMessage.sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */