package com.tencent.tmassistantsdk.internal.c;

import com.tencent.tmassistantbase.a.m;

class f
  implements com.tencent.tmassistantbase.network.b
{
  f(e parame) {}
  
  public void a()
  {
    m.c("LogReportManager", "onNetworkChanged,netState:" + com.tencent.tmassistantbase.a.f.n());
    Class[] arrayOfClass = e.e();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(b.class)) {
            b.h().d();
          }
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    new Thread(new g(this)).start();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\internal\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */