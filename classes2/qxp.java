import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import com.tencent.mobileqq.camera.CameraManagerImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class qxp
  implements Runnable
{
  qxp(qxo paramqxo, Camera.ShutterCallback paramShutterCallback, Camera.PictureCallback paramPictureCallback1, Camera.PictureCallback paramPictureCallback2, Camera.PictureCallback paramPictureCallback3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      CameraManagerImpl.a(this.jdField_a_of_type_Qxo.a).takePicture(this.jdField_a_of_type_AndroidHardwareCamera$ShutterCallback, this.jdField_a_of_type_AndroidHardwareCamera$PictureCallback, this.b, this.c);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e(qxo.a(this.jdField_a_of_type_Qxo), 2, "take picture failed.");
      throw localRuntimeException;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qxp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */