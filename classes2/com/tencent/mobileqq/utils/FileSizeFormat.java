package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FileSizeFormat
{
  private static final long jdField_a_of_type_Long = 1024L;
  private static char[] jdField_a_of_type_ArrayOfChar;
  private static final long jdField_b_of_type_Long = 1048576L;
  private static final char[] jdField_b_of_type_ArrayOfChar;
  private static final long c = 1073741824L;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new char[32];
    b = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, 160);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    double d = l;
    int i;
    int m;
    int j;
    label63:
    int k;
    label96:
    char[] arrayOfChar;
    if (l < 1048576L) {
      if (l < 1024L)
      {
        i = 66;
        m = (int)(0.005D + d);
        if (m >= 100) {
          break label258;
        }
        if (m >= 10) {
          break label252;
        }
        j = 1;
        if (i == 66) {
          break label317;
        }
        if ((FontSettingManager.a() <= 18.0F) || (paramInt >= 160)) {
          break label292;
        }
        k = j + 2;
        j = m;
        if (k <= a.length) {
          break label330;
        }
        arrayOfChar = new char[k];
        label111:
        m = k - 1;
        arrayOfChar[m] = 'B';
        if (i == 66) {
          break label410;
        }
        if ((FontSettingManager.a() <= 18.0F) || (paramInt >= 160)) {
          break label338;
        }
        paramInt = m - 1;
        arrayOfChar[paramInt] = i;
      }
    }
    for (;;)
    {
      paramInt -= 1;
      arrayOfChar[paramInt] = b[(j % 10)];
      m = j / 10;
      j = m;
      if (m <= 0)
      {
        return new String(arrayOfChar, 0, k);
        d /= 1024.0D;
        i = 75;
        break;
        if (l < 1073741824L)
        {
          d /= 1048576.0D;
          i = 77;
          break;
        }
        d /= 1.073741824E9D;
        i = 71;
        break;
        label252:
        j = 2;
        break label63;
        label258:
        if (m < 1000)
        {
          j = 3;
          break label63;
        }
        if (m < 10000)
        {
          j = 4;
          break label63;
        }
        j = 5;
        break label63;
        label292:
        m = (int)(d * 100.0D + 0.5D);
        k = j + 5;
        j = m;
        break label96;
        label317:
        k = j + 1;
        j = m;
        break label96;
        label330:
        arrayOfChar = a;
        break label111;
        label338:
        paramInt = m - 1;
        arrayOfChar[paramInt] = i;
        paramInt -= 1;
        arrayOfChar[paramInt] = b[(j % 10)];
        j /= 10;
        paramInt -= 1;
        arrayOfChar[paramInt] = b[(j % 10)];
        j /= 10;
        paramInt -= 1;
        arrayOfChar[paramInt] = '.';
        continue;
        label410:
        paramInt = m;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\FileSizeFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */