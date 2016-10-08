package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class k
  extends BroadcastReceiver
{
  k(j paramj) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      o.a().a(new j.b(this.a, paramIntent));
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */