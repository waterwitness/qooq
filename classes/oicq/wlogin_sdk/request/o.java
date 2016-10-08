package oicq.wlogin_sdk.request;

import java.util.ArrayList;
import oicq.wlogin_sdk.b.a;
import oicq.wlogin_sdk.b.bi;
import oicq.wlogin_sdk.b.bo;
import oicq.wlogin_sdk.b.cl;
import oicq.wlogin_sdk.b.cm;
import oicq.wlogin_sdk.b.cn;
import oicq.wlogin_sdk.b.cq;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.tools.util;

public class o
  extends oicq_request
{
  public o(t paramt)
  {
    this.t = 2064;
    this.u = 7;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.u;
    async_context localasync_context = t.b(this.x.h);
    f localf = localasync_context._t104;
    if (localf == null) {
      localf = new f();
    }
    for (;;)
    {
      bi localbi = localasync_context._t174;
      if (localbi == null) {
        localbi = new bi();
      }
      for (;;)
      {
        Object localObject2 = localasync_context._t402;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new cm();
        }
        cn localcn = localasync_context._t403;
        localObject2 = localcn;
        if (localcn == null) {
          localObject2 = new cn();
        }
        localasync_context._dpwd = util.get_mpasswd().getBytes();
        localasync_context._G = b(t.y, localasync_context._dpwd, ((cm)localObject1).b());
        if ((((cm)localObject1).c() > 0) && (((cn)localObject2).c() > 0)) {
          localasync_context._sec_guid_flag = true;
        }
        int i = 0;
        for (;;)
        {
          localObject1 = a(localf.b(), paramArrayOfByte, localbi.b(), paramInt1, paramInt2, paramArrayOfLong, localasync_context._G);
          a(this.h, this.t, this.i, this.x.f, this.l, this.m, j, this.o, (byte[])localObject1);
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
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, long[] paramArrayOfLong, byte[] paramArrayOfByte4)
  {
    int[] arrayOfInt = new int[7];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 8;
    int[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 'Ą';
    int[] tmp19_13 = tmp13_8;
    tmp19_13[2] = 'Ė';
    int[] tmp25_19 = tmp19_13;
    tmp25_19[3] = 'Ŵ';
    int[] tmp31_25 = tmp25_19;
    tmp31_25[4] = 'ż';
    int[] tmp37_31 = tmp31_25;
    tmp37_31[5] = 'Ё';
    int[] tmp43_37 = tmp37_31;
    tmp43_37[6] = 'Ƙ';
    tmp43_37;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    if (j < arrayOfInt.length)
    {
      Object localObject = null;
      switch (arrayOfInt[j])
      {
      }
      for (;;)
      {
        int k = i;
        if (localObject != null)
        {
          localArrayList.add(localObject);
          k = i + localObject.length;
        }
        j += 1;
        i = k;
        break;
        localObject = new cq().a(0, t.s, 0);
        continue;
        localObject = new f().a(paramArrayOfByte1);
        continue;
        localObject = new oicq.wlogin_sdk.b.t().a(paramInt1, paramInt2, paramArrayOfLong);
        continue;
        localObject = new bi().a(paramArrayOfByte3);
        continue;
        localObject = new bo().a(paramArrayOfByte2);
        continue;
        localObject = new cl().a(paramArrayOfByte4);
        continue;
        localObject = new a(408);
        ((a)localObject).a(new byte[] { (byte)r.E }, 1);
        localObject = ((a)localObject).a();
      }
    }
    j = localArrayList.size();
    paramArrayOfByte1 = new byte[i];
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte2 = (byte[])localArrayList.get(paramInt1);
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt2, paramArrayOfByte2.length);
      paramInt2 += paramArrayOfByte2.length;
      paramInt1 += 1;
    }
    return a(paramArrayOfByte1, this.u, j);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */