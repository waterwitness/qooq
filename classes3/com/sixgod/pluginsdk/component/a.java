package com.sixgod.pluginsdk.component;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  List a = new ArrayList();
  protected Context b;
  protected com.sixgod.pluginsdk.apkmanager.a c;
  
  public a(Context paramContext, com.sixgod.pluginsdk.apkmanager.a parama)
  {
    this.b = paramContext;
    this.c = parama;
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      this.b.unregisterReceiver(localb);
    }
  }
  
  public final void a(ActivityInfo paramActivityInfo, List paramList)
  {
    paramActivityInfo = new b(this, paramActivityInfo);
    this.a.add(paramActivityInfo);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IntentFilter localIntentFilter = (IntentFilter)paramList.next();
      this.b.registerReceiver(paramActivityInfo, localIntentFilter);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\component\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */