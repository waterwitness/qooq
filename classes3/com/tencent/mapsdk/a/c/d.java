package com.tencent.mapsdk.a.c;

import com.tencent.mapsdk.a.d.b;
import com.tencent.mapsdk.a.d.e;

public final class d
  extends a
{
  private float d;
  private float e;
  
  public final void a(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public final void a(e parame)
  {
    parame = parame.c();
    if (this.a)
    {
      parame.a((int)this.d, (int)this.e, this.b, this.c);
      return;
    }
    parame.scrollBy((int)this.d, (int)this.e);
  }
  
  public final void b(float paramFloat)
  {
    this.e = paramFloat;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */