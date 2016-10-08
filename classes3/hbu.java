import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.utils.SensorHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hbu
  extends BroadcastReceiver
{
  public hbu(SensorHelper paramSensorHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_ON"))
    {
      this.a.c = true;
      if ((this.a.h) && (this.a.a != null))
      {
        this.a.d(false);
        this.a.h = false;
      }
    }
    while (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
      return;
    }
    this.a.c = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */