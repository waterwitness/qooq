package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.RandomAccessFile;

public class EmosmRandomAccessFile
  extends RandomAccessFile
{
  private final byte[] a;
  
  public EmosmRandomAccessFile(String paramString1, String paramString2)
  {
    super(new File(paramString1), paramString2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new byte[8];
  }
  
  public int read()
  {
    int i = -1;
    if (read(this.a, 0, 1) != -1) {
      i = this.a[0] & 0xFF;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = super.getFilePointer();
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > -1) {
      EmosmUtils.a(paramArrayOfByte, paramInt1, paramInt2, l);
    }
    return paramInt2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\EmosmRandomAccessFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */