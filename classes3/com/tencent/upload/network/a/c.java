package com.tencent.upload.network.a;

import FileUpload.FileUploadHandShakeReq;
import FileUpload.SvcRequestHead;
import com.tencent.upload.a.b;
import com.tencent.upload.b.a.a;
import com.tencent.upload.common.UploadConfiguration;
import java.io.File;

public class c
  implements d
{
  private final SvcRequestHead a;
  private final int b;
  private final int c;
  private final int d;
  
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt3;
    this.b = paramInt1;
    this.c = paramInt2;
    this.a = new SvcRequestHead();
    this.a.y = a.a(paramInt1, paramInt2);
  }
  
  public final byte[] a()
  {
    Object localObject1 = new FileUploadHandShakeReq();
    ((FileUploadHandShakeReq)localObject1).a = this.d;
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject1 = a.a(localObject1.getClass().getSimpleName(), localObject1);
        if (localObject1 == null) {
          return null;
        }
      }
      catch (Exception localException1)
      {
        b.a(c.class.getSimpleName(), localException1);
        localObject2 = null;
        continue;
        this.a.a = 3;
        this.a.g = 1000;
        this.a.b = UploadConfiguration.getCurrentUin();
        this.a.e = new byte[0];
        this.a.q = new byte[0];
      }
      try
      {
        byte[] arrayOfByte1 = a.a(this.a.getClass().getSimpleName(), this.a);
        if (arrayOfByte1 == null) {
          continue;
        }
        byte[] arrayOfByte2 = new byte[localObject2.length + arrayOfByte1.length];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
        System.arraycopy(localObject2, 0, arrayOfByte2, arrayOfByte1.length, localObject2.length);
        return arrayOfByte2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          b.a(c.class.getSimpleName(), localException2);
          Object localObject3 = null;
        }
      }
    }
  }
  
  public final File b()
  {
    return null;
  }
  
  public final boolean c()
  {
    return false;
  }
  
  public final int d()
  {
    return 0;
  }
  
  public final int e()
  {
    return 0;
  }
  
  public final int f()
  {
    return this.b;
  }
  
  public final int g()
  {
    return 1000;
  }
  
  public final int h()
  {
    return this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */