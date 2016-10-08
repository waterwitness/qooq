package com.facebook.stetho.server.http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public abstract class LightHttpBody
{
  public static LightHttpBody create(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = create(paramString1.getBytes("UTF-8"), paramString2);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
  }
  
  public static LightHttpBody create(final byte[] paramArrayOfByte, String paramString)
  {
    new LightHttpBody()
    {
      public int contentLength()
      {
        return paramArrayOfByte.length;
      }
      
      public String contentType()
      {
        return LightHttpBody.this;
      }
      
      public void writeTo(OutputStream paramAnonymousOutputStream)
        throws IOException
      {
        paramAnonymousOutputStream.write(paramArrayOfByte);
      }
    };
  }
  
  public abstract int contentLength();
  
  public abstract String contentType();
  
  public abstract void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\http\LightHttpBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */