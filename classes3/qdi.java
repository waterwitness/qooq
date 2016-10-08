import android.os.Process;
import com.tencent.mobileqq.app.ProcessExitReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class qdi
  implements Runnable
{
  public qdi(ProcessExitReceiver paramProcessExitReceiver)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProcessExitReceiver", 2, "Kill process " + MobileQQ.getMobileQQ().getProcessName());
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qdi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */