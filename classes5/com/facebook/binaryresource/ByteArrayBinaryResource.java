package com.facebook.binaryresource;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayBinaryResource
  implements BinaryResource
{
  private final byte[] mBytes;
  
  public ByteArrayBinaryResource(byte[] paramArrayOfByte)
  {
    this.mBytes = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
  }
  
  public InputStream openStream()
    throws IOException
  {
    return new ByteArrayInputStream(this.mBytes);
  }
  
  public byte[] read()
  {
    return this.mBytes;
  }
  
  public long size()
  {
    return this.mBytes.length;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\binaryresource\ByteArrayBinaryResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */