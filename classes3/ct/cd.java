package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class cd
  extends BroadcastReceiver
{
  final bl a;
  boolean b;
  
  public cd(bl parambl)
  {
    this.a = parambl;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getBooleanExtra("noConnectivity", false))
    {
      this.a.c(Integer.valueOf(-1));
      return;
    }
    if (b.b(paramContext))
    {
      this.a.c(Integer.valueOf(1));
      return;
    }
    this.a.c(Integer.valueOf(0));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */