import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.QQMapActivity.MapRuntime;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class mew
  extends BroadcastReceiver
{
  public mew(QQMapActivity.MapRuntime paramMapRuntime)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 1;
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    for (;;)
    {
      return;
      int i;
      if (paramContext.equals("com.tencent.process.exit"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQMapActivity", 2, "receive kill map process broadcast");
        }
        paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
        if ((!QQMapActivity.a(paramIntent.getExtras().getString("verify"), paramContext)) || (!CommonUtil.a(paramContext, MobileQQ.getContext()))) {
          break label144;
        }
        i = j;
      }
      while (i != 0)
      {
        Process.killProcess(Process.myPid());
        return;
        i = j;
        if (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED"))
        {
          i = j;
          if (!paramContext.equals("mqq.intent.action.LOGOUT"))
          {
            i = j;
            if (!paramContext.equals("mqq.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName())) {
              label144:
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */