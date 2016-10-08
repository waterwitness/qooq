package com.tencent.mobileqq.nearby;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Baze64;
import com.tencent.qphone.base.util.QLog;

public class NearbyURLSafeUtil
{
  public static final String a = NearbyURLSafeUtil.class.getSimpleName();
  public static final String b = "*S1*";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = "*S1*" + Baze64.a(paramString.getBytes(), 11);
    if (QLog.isDevelopLevel()) {
      QLog.i(a, 4, "encode:" + paramString + " to:" + str);
    }
    return str;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("isBase64 src should not be null");
    }
    return paramString.startsWith("*S1*");
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("decode src should not be null");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(a, 4, "decode src:" + paramString);
    }
    String str = paramString;
    if (a(paramString))
    {
      paramString = new String(Baze64.a(paramString.substring("*S1*".length()), 11));
      str = paramString;
      if (QLog.isDevelopLevel())
      {
        QLog.i(a, 4, "decode result:" + paramString);
        str = paramString;
      }
    }
    return str;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyURLSafeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */