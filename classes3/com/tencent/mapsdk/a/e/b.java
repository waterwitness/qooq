package com.tencent.mapsdk.a.e;

import android.graphics.Bitmap;
import android.graphics.PointF;

public final class b
{
  public final int a;
  public final int b;
  public final int c;
  public PointF d;
  public int e = 1;
  public Bitmap f = null;
  public volatile boolean g = false;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public final void a()
  {
    if ((this.f != null) && (!this.f.isRecycled()))
    {
      this.f.recycle();
      this.f = null;
    }
    this.g = true;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
    } while ((this.a == ((b)paramObject).a) && (this.b == ((b)paramObject).b) && (this.c == ((b)paramObject).c) && (this.e == ((b)paramObject).e));
    return false;
  }
  
  public final int hashCode()
  {
    return this.a * 7 + this.b * 11 + this.c * 13 + this.e;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(24);
    localStringBuilder.append(this.a);
    localStringBuilder.append("-");
    localStringBuilder.append(this.b);
    localStringBuilder.append("-");
    localStringBuilder.append(this.c);
    localStringBuilder.append("-");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mapsdk\a\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */