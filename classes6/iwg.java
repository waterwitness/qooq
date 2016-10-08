import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;

public class iwg
  implements CameraExceptionHandler.Callback
{
  public iwg(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Exception paramException)
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "[onCameraException]", paramException);
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "[onDispatchThreadException]", paramRuntimeException);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iwg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */