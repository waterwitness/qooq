package com.tencent.tmassistantsdk.internal.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.tmassistantbase.a.m;

class d
  implements Runnable
{
  d(b paramb, Handler paramHandler) {}
  
  public void run()
  {
    try
    {
      Object localObject = this.b.getBindServiceIntent();
      this.b.a = b.a(this.b).bindService((Intent)localObject, this.b, 1);
      localObject = this.b;
      ((b)localObject).b += 1;
      m.c("TMAssistantDownloadOpenSDKClient", "retry bind service! retryBindResult:" + this.b.a + ",retryCount:" + this.b.b);
      if ((!this.b.a) && (this.b.b < 3)) {
        this.a.postDelayed(this, 1000L);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        m.c("TMAssistantDownloadOpenSDKClient", "retry bind service Exception:", localException);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantsdk\internal\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */