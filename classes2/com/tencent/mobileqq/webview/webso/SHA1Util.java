package com.tencent.mobileqq.webview.webso;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.security.MessageDigest;

public class SHA1Util
{
  private static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = a(paramString.getBytes(), "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(a[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    paramString = MessageDigest.getInstance(paramString);
    paramString.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    return a(paramString.digest());
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\webso\SHA1Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */