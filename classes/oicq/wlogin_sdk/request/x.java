package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.b.ad;
import oicq.wlogin_sdk.b.ae;
import oicq.wlogin_sdk.b.bu;
import oicq.wlogin_sdk.b.cq;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.tools.util;

public class x
  extends oicq_request
{
  public x(t paramt)
  {
    this.t = 2064;
    this.u = 18;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(String paramString, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.u;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = a(paramString.getBytes(), paramInt1, paramInt2, paramArrayOfLong);
      a(this.h, this.t, this.i, this.x.f, this.l, this.m, j, this.o, arrayOfByte);
      int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      if (k != 0) {
        return k;
      }
      k = b();
      util.LOGI("retry num:" + i + " ret:" + k, "" + this.x.f);
      if (k != 180) {
        return k;
      }
      if (i >= 1) {
        return k;
      }
      i += 1;
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    int i = 0;
    int[] arrayOfInt = new int[5];
    int[] tmp10_8 = arrayOfInt;
    tmp10_8[0] = 'Ą';
    int[] tmp16_10 = tmp10_8;
    tmp16_10[1] = 8;
    int[] tmp21_16 = tmp16_10;
    tmp21_16[2] = 'ħ';
    int[] tmp27_21 = tmp21_16;
    tmp27_21[3] = 'Ƅ';
    int[] tmp33_27 = tmp27_21;
    tmp33_27[4] = 'Ė';
    tmp33_27;
    ArrayList localArrayList = new ArrayList();
    int i1 = arrayOfInt.length;
    int j = 0;
    async_context localasync_context = t.b(this.x.h);
    int n = 0;
    if (n < i1)
    {
      byte[] arrayOfByte = new byte[0];
      switch (arrayOfInt[n])
      {
      }
      for (;;)
      {
        int k = j;
        int m = i;
        if (arrayOfByte.length > 4)
        {
          m = i + 1;
          k = j + arrayOfByte.length;
          localArrayList.add(arrayOfByte);
        }
        n += 1;
        i = m;
        j = k;
        break;
        arrayOfByte = localasync_context._t104.a();
        continue;
        arrayOfByte = new cq().a(0, t.s, 0);
        continue;
        arrayOfByte = new ae().a(paramArrayOfByte, localasync_context._t126.f());
        continue;
        arrayOfByte = new bu().a(localasync_context._msalt, localasync_context._mpasswd);
        continue;
        arrayOfByte = new oicq.wlogin_sdk.b.t().a(paramInt1, paramInt2, paramArrayOfLong);
      }
    }
    paramArrayOfByte = new byte[j];
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      paramArrayOfLong = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte, paramInt2, paramArrayOfLong.length);
      paramInt2 += paramArrayOfLong.length;
      paramInt1 += 1;
    }
    return a(paramArrayOfByte, this.u, i);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */