package com.tencent.securitysdk.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class MD5
{
  public static final String a = "andygzyu-MD5";
  public static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    return a(a(paramString));
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 16))
    {
      char[] arrayOfChar = new char[32];
      int j = 0;
      while (i < 16)
      {
        int k = paramArrayOfByte[i];
        int m = j + 1;
        arrayOfChar[j] = a[(k >>> 4 & 0xF)];
        j = m + 1;
        arrayOfChar[m] = a[(k & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar);
    }
    return "";
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return null;
    }
    catch (Exception paramString)
    {
      try
      {
        paramString = paramString.getBytes("UTF-8");
        return localMessageDigest.digest(paramString);
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
      paramString = paramString;
      paramString.printStackTrace();
      return null;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return a(a(paramArrayOfByte));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\securitysdk\utils\MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */