package com.tencent.upload.network.b;

import java.io.Serializable;

public final class h
  implements Serializable
{
  private m a = null;
  private m b = null;
  private long c = 0L;
  
  public final m a()
  {
    return this.a;
  }
  
  public final void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final void a(m paramm)
  {
    int i = paramm.f();
    if (i == 2) {
      this.b = paramm;
    }
    while (i != 1) {
      return;
    }
    this.a = paramm;
  }
  
  public final m b()
  {
    return this.b;
  }
  
  public final long c()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return "mRecentTcpRoute = " + this.a + ", mRecentHttpRoute = " + this.b + ",mTimeStamp = " + this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */