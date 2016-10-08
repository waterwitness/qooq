package com.tencent.mobileqq.app.soso;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class SosoInterface$SosoWifi
{
  public int a;
  public long a;
  
  public SosoInterface$SosoWifi(String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = a(paramString);
  }
  
  public static long a(String paramString)
  {
    try
    {
      paramString = paramString.split(":");
      if (paramString.length == 6)
      {
        int j = 40;
        int i = 0;
        long l1 = 0L;
        while (i < paramString.length)
        {
          long l2 = Long.parseLong(paramString[i], 16);
          long l3 = l2;
          if (j > 0) {
            l3 = l2 << j;
          }
          l1 += l3;
          j -= 8;
          i += 1;
        }
        return l1;
      }
    }
    catch (Exception paramString)
    {
      return 0L;
    }
    return 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\soso\SosoInterface$SosoWifi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */