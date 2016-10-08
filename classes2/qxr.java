import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.camera.CameraManager;
import com.tencent.mobileqq.camera.CameraManager.CameraOpenErrorCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qxr
  implements CameraManager.CameraOpenErrorCallback
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CameraManager.CameraOpenErrorCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraOpenErrorCallback;
  
  private qxr(Handler paramHandler, CameraManager.CameraOpenErrorCallback paramCameraOpenErrorCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraOpenErrorCallback = paramCameraOpenErrorCallback;
  }
  
  public static qxr a(Handler paramHandler, CameraManager.CameraOpenErrorCallback paramCameraOpenErrorCallback)
  {
    if ((paramHandler == null) || (paramCameraOpenErrorCallback == null)) {
      return null;
    }
    return new qxr(paramHandler, paramCameraOpenErrorCallback);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new qxs(this, paramInt));
  }
  
  public void a(CameraManager paramCameraManager)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new qxu(this, paramCameraManager));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new qxt(this, paramInt));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qxr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */