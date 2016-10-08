package com.tribe.async.dispatch;

import android.os.HandlerThread;
import android.support.annotation.NonNull;

public class Dispatchers
{
  private static volatile Dispatcher sDispatcher;
  
  @NonNull
  public static Dispatcher get()
  {
    if (sDispatcher != null) {
      return sDispatcher;
    }
    try
    {
      if (sDispatcher != null)
      {
        Dispatcher localDispatcher = sDispatcher;
        return localDispatcher;
      }
    }
    finally {}
    Object localObject2 = new HandlerThread("dispatcher", 10);
    ((HandlerThread)localObject2).start();
    sDispatcher = new DefaultDispatcher(((HandlerThread)localObject2).getLooper());
    localObject2 = sDispatcher;
    return (Dispatcher)localObject2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tribe\async\dispatch\Dispatchers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */