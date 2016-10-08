package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class m
  extends BroadcastReceiver
{
  m(j paramj) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    new StringBuilder("onAccessSchedulerTriggered by timer, curTime:").append(System.currentTimeMillis());
    bc.a();
    o.a().a(new j.a(this.a, (byte)0));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */