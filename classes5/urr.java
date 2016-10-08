import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class urr
  implements Camera.AutoFocusCallback
{
  urr(urq paramurq)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "Request Focus onAutoFocus");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\urr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */