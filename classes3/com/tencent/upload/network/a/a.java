package com.tencent.upload.network.a;

import FileUpload.SvcResponsePacket;
import android.util.Log;
import com.tencent.upload.a.b;

public final class a
{
  private SvcResponsePacket a;
  private int b;
  private int c;
  
  public final SvcResponsePacket a()
  {
    return this.a;
  }
  
  public final boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      this.a = ((SvcResponsePacket)com.tencent.upload.b.a.a.a(SvcResponsePacket.class.getSimpleName(), paramArrayOfByte));
      paramArrayOfByte = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        paramArrayOfByte = Log.getStackTraceString(localException);
        b.a(a.class.getSimpleName(), localException);
      }
      paramArrayOfByte = com.tencent.upload.b.a.a.a(this.a.g);
      this.b = paramArrayOfByte[0];
      this.c = paramArrayOfByte[1];
    }
    if (this.a == null)
    {
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = "ImageUploadAction() unpack mResponsePacket=null. " + this.a;
      }
      b.e(a.class.getSimpleName(), (String)localObject);
      this.a = new SvcResponsePacket();
      this.a.a = -8;
      this.a.c = ((String)localObject);
      return false;
    }
    return true;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    if (this.a == null) {}
    while ((this.a.a != 0) || (this.a.e != 1)) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */