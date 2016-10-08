package com.tencent.tmdownloader.internal.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.tmassistantbase.a.f;

class b
  implements Runnable
{
  b(a parama) {}
  
  public void run()
  {
    Intent localIntent = new Intent("com.tencent.android.qqdownloader.SDKService");
    localIntent.setClassName(f.a().b().getPackageName(), "com.tencent.assistant.sdk.SDKSupportService");
    f.a().b().startService(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */