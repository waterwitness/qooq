package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.b.cb;
import oicq.wlogin_sdk.b.cf;
import oicq.wlogin_sdk.b.cq;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.g;
import oicq.wlogin_sdk.tools.util;

public class n
  extends oicq_request
{
  public static boolean E = false;
  
  public n(t paramt)
  {
    this.t = 2064;
    this.u = 2;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.u;
    Object localObject = t.b(this.x.h);
    f localf = ((async_context)localObject)._t104;
    if (localf == null) {
      localf = new f();
    }
    for (;;)
    {
      localObject = ((async_context)localObject)._t105;
      if (localObject == null) {
        localObject = new g();
      }
      for (;;)
      {
        int i = 0;
        for (;;)
        {
          byte[] arrayOfByte = a(localf.b(), paramArrayOfByte, ((g)localObject).g(), paramInt1, paramInt2, paramArrayOfLong);
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
    }
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    cf localcf = new cf();
    Object localObject1 = new cq();
    Object localObject2 = new f();
    oicq.wlogin_sdk.b.t localt = new oicq.wlogin_sdk.b.t();
    cb localcb = new cb();
    localObject1 = ((cq)localObject1).a(0, t.s, 0);
    localObject2 = ((f)localObject2).a(paramArrayOfByte1);
    paramArrayOfLong = localt.a(paramInt1, paramInt2, paramArrayOfLong);
    if (E) {}
    for (paramArrayOfByte1 = localcb.a(paramArrayOfByte2);; paramArrayOfByte1 = localcf.a(paramArrayOfByte2, paramArrayOfByte3))
    {
      paramArrayOfByte2 = new byte[paramArrayOfByte1.length + localObject1.length + localObject2.length + paramArrayOfLong.length];
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 0;
      System.arraycopy(localObject1, 0, paramArrayOfByte2, paramInt1, localObject1.length);
      paramInt1 += localObject1.length;
      System.arraycopy(localObject2, 0, paramArrayOfByte2, paramInt1, localObject2.length);
      paramInt1 += localObject2.length;
      System.arraycopy(paramArrayOfLong, 0, paramArrayOfByte2, paramInt1, paramArrayOfLong.length);
      paramInt1 = paramArrayOfLong.length;
      return a(paramArrayOfByte2, this.u, 4);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\request\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */