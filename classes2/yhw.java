import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqhotspot.hotspotnode.ShowNodeTaskManager;

public class yhw
  extends BroadcastReceiver
{
  public yhw(ShowNodeTaskManager paramShowNodeTaskManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShowNodeTaskManager", 2, "OnScreen open");
      }
      ShowNodeTaskManager.a().a(ShowNodeTaskManager.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */