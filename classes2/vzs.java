import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class vzs
  extends BroadcastReceiver
{
  vzs()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      if ("tencent.video.q2v.debug".equals(paramIntent.getAction()))
      {
        if (paramIntent.getBooleanExtra("debugkeeptoolbar_flag", false)) {
          if (!paramIntent.getBooleanExtra("debugkeeptoolbar", false)) {
            break label73;
          }
        }
        label73:
        for (com.tencent.mobileqq.utils.AudioHelper.i = 1; paramIntent.getBooleanExtra("debugmode_flag", false); com.tencent.mobileqq.utils.AudioHelper.i = 0)
        {
          if (!paramIntent.getBooleanExtra("debugmode", false)) {
            break label80;
          }
          com.tencent.mobileqq.utils.AudioHelper.h = 1;
          return;
        }
      }
    }
    label80:
    com.tencent.mobileqq.utils.AudioHelper.h = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */