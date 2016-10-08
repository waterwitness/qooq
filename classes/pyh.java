import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pyh
  extends BroadcastReceiver
{
  public pyh(GuardManager paramGuardManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("GuardManager", 2, paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      if (this.a.a > 0L) {
        this.a.a(false);
      }
    }
    while ((!"android.intent.action.SCREEN_ON".equals(paramContext)) || (this.a.a != 0L) || (!GuardManager.a(this.a))) {
      return;
    }
    this.a.a = SystemClock.uptimeMillis();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pyh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */