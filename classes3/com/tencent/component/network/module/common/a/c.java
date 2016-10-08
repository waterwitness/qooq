package com.tencent.component.network.module.common.a;

import java.text.DecimalFormat;

public final class c
{
  private static final DecimalFormat a = new DecimalFormat();
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i >= paramInt) {
      return localStringBuffer.toString();
    }
    int j = paramArrayOfByte[i] & 0xFF;
    if ((j <= 32) || (j >= 127))
    {
      localStringBuffer.append('\\');
      localStringBuffer.append(a.format(j));
    }
    for (;;)
    {
      i += 1;
      break;
      if ((j == 34) || (j == 40) || (j == 41) || (j == 46) || (j == 59) || (j == 92) || (j == 64) || (j == 36))
      {
        localStringBuffer.append('\\');
        localStringBuffer.append((char)j);
      }
      else
      {
        localStringBuffer.append((char)j);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\common\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */