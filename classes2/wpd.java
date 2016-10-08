import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;

public final class wpd
  extends BroadcastReceiver
{
  public wpd()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramIntent.getIntExtra("type", 0) == 0)) {
      return;
    }
    MQPSensitiveMsgUtil.a(paramIntent.getStringExtra("account"));
    MQPSensitiveMsgUtil.b(MQPSensitiveMsgUtil.a());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wpd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */