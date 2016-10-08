package com.tencent.component.network.module.report;

import android.os.Handler;
import android.os.HandlerThread;

public final class b
  extends HandlerThread
{
  private Handler a;
  
  public b(String paramString)
  {
    super(paramString, 10);
    start();
  }
  
  public final void a(Runnable paramRunnable)
  {
    try
    {
      if (this.a == null) {
        this.a = new Handler(getLooper());
      }
      this.a.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public final void b(Runnable paramRunnable)
  {
    try
    {
      if (this.a == null) {
        this.a = new Handler(getLooper());
      }
      this.a.postDelayed(paramRunnable, 120000L);
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\report\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */