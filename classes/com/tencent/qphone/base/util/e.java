package com.tencent.qphone.base.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class e
{
  public static int a(int paramInt)
  {
    return (0xFF00 & paramInt) >> 8 | (paramInt & 0xFF) << 8;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      int i = 0;
      if (i < paramString.length())
      {
        String str = Integer.toHexString(paramString.charAt(i));
        if (str.length() % 2 == 0) {
          localStringBuilder.append(str);
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append("0").append(str);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static InetAddress a(long paramLong)
    throws UnknownHostException
  {
    int i = (byte)(int)(paramLong >> 24 & 0xFF);
    int j = (byte)(int)(paramLong >> 16 & 0xFF);
    int k = (byte)(int)(paramLong >> 8 & 0xFF);
    return InetAddress.getByAddress(new byte[] { (byte)(int)(paramLong & 0xFF), k, j, i });
  }
  
  public static final long b(String paramString)
  {
    paramString = paramString.split("\\.");
    return (Long.parseLong(paramString[3]) << 24) + (Long.parseLong(paramString[2]) << 16) + (Long.parseLong(paramString[1]) << 8) + Long.parseLong(paramString[0]);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\qphone\base\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */