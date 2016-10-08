package com.tencent.tmdownloader.internal.downloadclient;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SyncSDKHandShakeRequest;

class d
  implements Runnable
{
  d(b paramb) {}
  
  public void run()
  {
    if (b.a(this.a) == null) {}
    for (;;)
    {
      return;
      Object localObject = new SyncSDKHandShakeRequest();
      ((SyncSDKHandShakeRequest)localObject).extra = "hello YYB";
      localObject = b.a((JceStruct)localObject, "");
      if ((localObject != null) && (localObject.length > 0)) {
        try
        {
          if (b.a(this.a) != null)
          {
            b.a(this.a).b((byte[])localObject);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\downloadclient\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */