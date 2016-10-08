package com.facebook.binaryresource;

import java.io.IOException;
import java.io.InputStream;

public abstract interface BinaryResource
{
  public abstract InputStream openStream()
    throws IOException;
  
  public abstract byte[] read()
    throws IOException;
  
  public abstract long size();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\binaryresource\BinaryResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */