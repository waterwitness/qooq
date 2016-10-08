package com.tencent.mapsdk.a.c;

import com.tencent.mapsdk.a.d.e;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

public abstract class a
{
  protected boolean a = true;
  protected long b = 1000L;
  protected CancelableCallback c = null;
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public abstract void a(e parame);
  
  public final void a(CancelableCallback paramCancelableCallback)
  {
    this.c = paramCancelableCallback;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */