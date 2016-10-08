import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class uqv
  implements Camera.PictureCallback
{
  Handler jdField_a_of_type_AndroidOsHandler;
  
  public uqv(CameraControl paramCameraControl, File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i(CameraControl.b, 2, "onJpegTaken");
    }
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new uqw(this, paramArrayOfByte));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */