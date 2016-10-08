package com.tencent.upload.common;

public final class d
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length << 1);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(a[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i < paramInt) {}
      try
      {
        localStringBuilder.append((char)((paramArrayOfByte[i] + 256) % 256));
        i += 1;
      }
      catch (Exception paramArrayOfByte) {}
    }
    paramArrayOfByte = localStringBuilder.toString();
    return paramArrayOfByte;
    return null;
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      paramString = paramString.split("\\.");
      if ((paramString != null) && (paramString.length == 4)) {
        try
        {
          int i = Integer.parseInt(paramString[0]);
          if ((i > 0) && (i <= 255))
          {
            i = Integer.parseInt(paramString[1]);
            if ((i >= 0) && (i <= 255))
            {
              i = Integer.parseInt(paramString[2]);
              if ((i >= 0) && (i <= 255))
              {
                i = Integer.parseInt(paramString[3]);
                if ((i >= 0) && (i <= 255)) {
                  return true;
                }
              }
            }
          }
        }
        catch (NumberFormatException paramString) {}
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\common\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */