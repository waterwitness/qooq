import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class wgz
  extends BroadcastReceiver
{
  public wgz(WebProcessManager paramWebProcessManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessManager", 2, "action=" + paramContext);
        }
        if (!paramContext.equals("com.tencent.mobileqq.webprocess.restart_web_process")) {
          break;
        }
        this.a.f();
      } while (!paramIntent.getBooleanExtra("isPreloadWebProcess", false));
      this.a.g();
      return;
    } while (!paramContext.equals("com.tencent.mobileqq.webprocess.report"));
    this.a.g();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */