package com.sixgod.pluginsdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sixgod.pluginsdk.apkmanager.a;

final class e
  extends Handler
{
  e(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return;
    case 1000: 
      this.a.a();
      return;
    }
    this.a.e.b();
    synchronized (this.a.t)
    {
      this.a.t.notifyAll();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */