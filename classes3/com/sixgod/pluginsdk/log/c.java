package com.sixgod.pluginsdk.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class c
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (SixGodReporter.sReportImpl != null))
    {
      paramContext = paramIntent.getSerializableExtra("report_info");
      if ((paramContext instanceof b))
      {
        a.a("SixGod_PluginSdk.report", "onReceive");
        paramContext = (b)paramContext;
        SixGodReporter.sReportImpl.report(paramContext.a, paramContext.b, paramContext.c, paramContext.d, paramContext.e, paramContext.f, paramContext.g, paramContext.h, paramContext.i, paramContext.j, paramContext.k);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\log\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */