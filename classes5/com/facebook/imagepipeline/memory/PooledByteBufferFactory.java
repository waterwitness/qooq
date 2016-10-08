package com.facebook.imagepipeline.memory;

import java.io.IOException;
import java.io.InputStream;

public abstract interface PooledByteBufferFactory
{
  public abstract PooledByteBuffer newByteBuffer(int paramInt);
  
  public abstract PooledByteBuffer newByteBuffer(InputStream paramInputStream)
    throws IOException;
  
  public abstract PooledByteBuffer newByteBuffer(InputStream paramInputStream, int paramInt)
    throws IOException;
  
  public abstract PooledByteBuffer newByteBuffer(byte[] paramArrayOfByte);
  
  public abstract PooledByteBufferOutputStream newOutputStream();
  
  public abstract PooledByteBufferOutputStream newOutputStream(int paramInt);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\memory\PooledByteBufferFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */