import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.interact.RecordSVInteractActivity;

public class yql
  implements CameraExceptionHandler.Callback
{
  public yql(RecordSVInteractActivity paramRecordSVInteractActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecordSVInteractActivity", 2, "[onCameraException]", paramException);
    }
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecordSVInteractActivity", 2, "[onDispatchThreadException]", paramRuntimeException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */