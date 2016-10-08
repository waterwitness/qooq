import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qwv
  implements Camera.AutoFocusCallback
{
  public qwv(CameraHelper paramCameraHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    paramCamera = this.a.a();
    this.a.a(paramCamera);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qwv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */