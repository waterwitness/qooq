package com.tencent.mobileqq.app;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StringUtil;
import java.nio.ByteBuffer;
import oicq.wlogin_sdk.tools.MD5;

public class PhoneContactHelper
{
  public PhoneContactHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString.length());
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if ((c == ' ') || (c == '-') || (c == ')') || (c == '(') || (c == '_')) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(c);
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = paramString1.getBytes();
    byte[] arrayOfByte = paramString2.getBytes();
    if (paramString1.length > 10)
    {
      paramString2 = new byte[10];
      System.arraycopy(paramString1, 0, paramString2, 0, 10);
      paramString1 = paramString2;
    }
    for (;;)
    {
      return MD5.toMD5(ByteBuffer.allocate(paramString1.length + arrayOfByte.length).put(paramString1).put(arrayOfByte).array());
    }
  }
  
  public static String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (paramString = "#";; paramString = String.valueOf(paramString.charAt(0)).toUpperCase())
    {
      String str = paramString;
      if (!StringUtil.c(paramString.charAt(0))) {
        str = "#";
      }
      return str;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\PhoneContactHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */