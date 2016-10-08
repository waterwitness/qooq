package com.tencent.imageservice;

import android.util.Log;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PNGReader
{
  public static final long SIGNATURE = -8552249625308161526L;
  private byte a;
  private byte b;
  
  private static int a(InputStream paramInputStream)
    throws Exception
  {
    byte[] arrayOfByte = new byte[4];
    paramInputStream.read(arrayOfByte, 0, 4);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    int k = arrayOfByte[2];
    return arrayOfByte[3] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public boolean isTransparentPng(String paramString)
  {
    try
    {
      unpackImage(new FileInputStream(paramString));
      if (((this.a == 8) || (this.a == 16)) && (this.b == 6)) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w("ImageProcessService", paramString.toString());
      }
    }
    return false;
  }
  
  public void unpackImage(InputStream paramInputStream)
    throws Exception
  {
    int i = 1;
    byte[] arrayOfByte = new byte[8];
    paramInputStream.read(arrayOfByte, 0, 8);
    if (((arrayOfByte[0] & 0xFF) << 56 | (arrayOfByte[1] & 0xFF) << 48 | (arrayOfByte[2] & 0xFF) << 40 | (arrayOfByte[3] & 0xFF) << 32 | (arrayOfByte[4] & 0xFF) << 24 | (arrayOfByte[5] & 0xFF) << 16 | (arrayOfByte[6] & 0xFF) << 8 | arrayOfByte[7] & 0xFF) != -8552249625308161526L) {}
    for (;;)
    {
      return;
      if ((a(paramInputStream) != 13) || (a(paramInputStream) != 1229472850)) {
        i = 0;
      }
      while (i == 0)
      {
        throw new IOException("NOT A VALID PNG IMAGE");
        arrayOfByte = new byte[13];
        paramInputStream.read(arrayOfByte, 0, 13);
        this.a = arrayOfByte[8];
        this.b = arrayOfByte[9];
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\imageservice\PNGReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */