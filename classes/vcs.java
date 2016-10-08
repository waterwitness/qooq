import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.trick.TrickHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class vcs
  extends BroadcastReceiver
{
  private vcs(TrickHelper paramTrickHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("TrickHelper", 2, "received with " + paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      TrickHelper.b = false;
      ThreadManager.a().removeCallbacks(TrickHelper.a(this.a));
    }
    while (!"android.intent.action.SCREEN_ON".equals(paramContext)) {
      return;
    }
    TrickHelper.b = true;
    ThreadManager.a().postDelayed(TrickHelper.a(this.a), 2000L);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\vcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */