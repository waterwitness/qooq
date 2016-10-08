package com.facebook.imagepipeline.memory;

import java.io.Closeable;

public abstract interface PooledByteBuffer
  extends Closeable
{
  public abstract void close();
  
  public abstract long getNativePtr();
  
  public abstract boolean isClosed();
  
  public abstract byte read(int paramInt);
  
  public abstract void read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public abstract int size();
  
  public static class ClosedException
    extends RuntimeException
  {
    public ClosedException()
    {
      super();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\PooledByteBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */