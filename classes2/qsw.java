import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.qphone.base.util.QLog;

public class qsw
  implements CameraExceptionHandler.Callback
{
  public qsw(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.i(DynamicAvatarRecordActivity.a(), 2, "[onCameraException]", paramException);
    }
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i(DynamicAvatarRecordActivity.a(), 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qsw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */