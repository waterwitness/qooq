package com.tencent.mobileqq.utils;

import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.ByteArrayOutputStream;

public class PoolingByteArrayOutputStream
  extends ByteArrayOutputStream
{
  private static final int jdField_a_of_type_Int = 256;
  private final ByteArrayPool jdField_a_of_type_ComTencentCommonsdkPoolByteArrayPool;
  
  public PoolingByteArrayOutputStream(ByteArrayPool paramByteArrayPool)
  {
    this(paramByteArrayPool, 256);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PoolingByteArrayOutputStream(ByteArrayPool paramByteArrayPool, int paramInt)
  {
    this.a = paramByteArrayPool;
    this.buf = this.a.getBuf(Math.max(paramInt, 256));
  }
  
  private void a(int paramInt)
  {
    if (this.count + paramInt <= this.buf.length) {
      return;
    }
    byte[] arrayOfByte = this.a.getBuf((this.count + paramInt) * 2);
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.a.returnBuf(this.buf);
    this.buf = arrayOfByte;
  }
  
  public byte[] a()
  {
    return this.buf;
  }
  
  public void close()
  {
    this.a.returnBuf(this.buf);
    this.buf = null;
    super.close();
  }
  
  public void finalize()
  {
    this.a.returnBuf(this.buf);
  }
  
  public void write(int paramInt)
  {
    try
    {
      a(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\PoolingByteArrayOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */