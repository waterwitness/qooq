import com.tencent.mobileqq.activity.BlessPTVActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.qphone.base.util.QLog;

public class kqt
  implements CameraExceptionHandler.Callback
{
  public kqt(BlessPTVActivity paramBlessPTVActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BlessPTVActivity", 2, "[onCameraException]", paramException);
    }
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BlessPTVActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */