package com.facebook.stetho.common;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Utf8Charset
{
  public static final Charset INSTANCE = Charset.forName("UTF-8");
  public static final String NAME = "UTF-8";
  
  public static String decodeUTF8(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, INSTANCE);
  }
  
  public static byte[] encodeUTF8(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\Utf8Charset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */