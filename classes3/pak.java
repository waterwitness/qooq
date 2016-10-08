import android.os.Process;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pak
  implements Runnable
{
  public pak(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */