package com.tencent.beacon.upload;

import android.content.Context;
import com.tencent.beacon.a.d;
import com.tencent.beacon.a.f;
import com.tencent.beacon.b.a.b;

public final class c
  extends a
{
  public c(Context paramContext)
  {
    super(paramContext, 0, 100);
  }
  
  public final b a()
  {
    Object localObject = d.m();
    byte[] arrayOfByte = "".getBytes();
    try
    {
      localObject = f.a(c(), (d)localObject, arrayOfByte, -1, -1);
      if (localObject != null) {
        return (b)localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.a(localThrowable);
      com.tencent.beacon.d.a.d("encode2RequestPackage failed", new Object[0]);
    }
    return null;
  }
  
  public final void b(boolean paramBoolean) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\upload\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */