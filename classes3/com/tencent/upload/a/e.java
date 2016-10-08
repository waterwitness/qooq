package com.tencent.upload.a;

import com.tencent.upload.network.a.d;
import java.io.File;

public final class e
  implements d
{
  private final byte[] a;
  private final File b;
  private final boolean c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  
  public e(byte[] paramArrayOfByte, File paramFile, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a = paramArrayOfByte;
    this.b = paramFile;
    this.c = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.h = paramInt4;
    this.g = paramInt5;
  }
  
  public final byte[] a()
  {
    return this.a;
  }
  
  public final File b()
  {
    return this.b;
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public final int f()
  {
    return this.f;
  }
  
  public final int g()
  {
    return this.h;
  }
  
  public final int h()
  {
    return this.g;
  }
  
  public final String toString()
  {
    return "UploadActionRequest [mPartFileMode=" + this.c + ", mFileOffset=" + this.d + ", mFileSendCount=" + this.e + ", mActionId=" + this.f + ", mCommandId=" + this.h + "]";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */