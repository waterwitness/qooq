import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class upl
  extends BroadcastReceiver
{
  public upl(CliNotifyPush paramCliNotifyPush)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (CliNotifyPush.a != true)
    {
      QLog.e("CliNotifyPush", 1, "receiver broadcast late");
      CliNotifyPush.a(this.a, 2013);
      return;
    }
    CliNotifyPush.a = false;
    if (paramIntent != null)
    {
      CliNotifyPush.a(this.a, paramIntent.getIntExtra("param_ret", 0));
      long l = paramIntent.getLongExtra("param_uin", 10000L);
      QLog.e("CliNotifyPush", 1, "receive broadcast from qzone, uin=" + l + " param_ret=" + CliNotifyPush.a(this.a));
      if ((CliNotifyPush.a(this.a) != 0) && (CliNotifyPush.a(this.a) != 10000)) {
        break label216;
      }
      if (l != this.a.getAppRuntime().getLongAccountUin()) {
        break label194;
      }
      CliNotifyPush.h = 0;
      CliNotifyPush.i = 0;
    }
    for (;;)
    {
      paramContext = (QQAppInterface)this.a.getAppRuntime();
      if (paramContext == null) {
        break;
      }
      paramContext.a(CliNotifyPush.class).removeCallbacks(CliNotifyPush.a(this.a));
      paramContext.a(CliNotifyPush.class).post(CliNotifyPush.a(this.a));
      return;
      label194:
      CliNotifyPush.a(this.a, 3001);
      CliNotifyPush.h += 1;
      continue;
      label216:
      CliNotifyPush.h += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\upl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */