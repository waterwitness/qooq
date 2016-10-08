package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;

public class UinUtils
{
  public UinUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a(String paramString)
  {
    try
    {
      long l = new BigInteger(paramString).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w(UinUtils.class.getSimpleName(), 2, "failed to long:" + paramString);
      }
    }
    return 0L;
  }
  
  public static String a(int paramInt)
  {
    return String.valueOf(paramInt & 0xFFFFFFFF);
  }
  
  public static String a(long paramLong)
  {
    BigInteger localBigInteger2 = BigInteger.valueOf(paramLong);
    BigInteger localBigInteger1 = localBigInteger2;
    if (localBigInteger2.signum() < 0) {
      localBigInteger1 = localBigInteger2.add(BigInteger.ONE.shiftLeft(64));
    }
    return localBigInteger1.toString();
  }
  
  public static String a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    int m = paramString.length() - 4;
    int k = m - 4;
    int i = m;
    if (m < 0) {
      i = 0;
    }
    if (k < 0) {}
    for (;;)
    {
      if ((j < i) && (i > 0)) {
        localStringBuffer.replace(j, i, "*");
      }
      return localStringBuffer.toString();
      j = k;
    }
  }
  
  public static long b(String paramString)
  {
    try
    {
      long l = new BigInteger(paramString).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(UinUtils.class.getSimpleName(), 2, "failed getLong, uin = " + paramString);
      }
    }
    return 0L;
  }
  
  public static String b(long paramLong)
  {
    return a(a(paramLong));
  }
  
  public static long c(String paramString)
  {
    long l = b(paramString);
    if (l == 0L) {
      try
      {
        l = Long.valueOf(paramString).longValue();
        return l;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return 0L;
      }
    }
    return l;
  }
  
  @Deprecated
  public static long d(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\UinUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */