package com.tribe.async.async;

import android.content.Context;
import android.support.annotation.NonNull;

public class Bosses
{
  private static Context sApp;
  private static volatile Boss sBoss;
  
  @NonNull
  public static Boss get()
  {
    if (sBoss != null) {
      return sBoss;
    }
    try
    {
      if (sBoss != null)
      {
        Boss localBoss1 = sBoss;
        return localBoss1;
      }
    }
    finally {}
    sBoss = new BossImp(sApp);
    Boss localBoss2 = sBoss;
    return localBoss2;
  }
  
  public static void init(Context paramContext)
  {
    sApp = paramContext.getApplicationContext();
  }
  
  public static void initWithBoss(Context paramContext, Boss paramBoss)
  {
    sApp = paramContext.getApplicationContext();
    try
    {
      sBoss = paramBoss;
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\async\Bosses.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */