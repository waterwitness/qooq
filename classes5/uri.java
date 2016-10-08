import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;

public class uri
  implements Runnable
{
  public uri(CameraProxy paramCameraProxy, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a.obtainMessage(6, this.jdField_a_of_type_Int, this.b, Integer.valueOf(this.c)).sendToTarget();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */