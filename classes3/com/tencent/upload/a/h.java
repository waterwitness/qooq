package com.tencent.upload.a;

import android.os.Message;
import com.tencent.upload.common.c;
import com.tencent.upload.common.f;
import com.tencent.upload.network.a;
import com.tencent.upload.network.b.m;
import com.tencent.upload.uinterface.IUploadReport;

final class h
  implements a
{
  h(g paramg) {}
  
  public final void a(m paramm, String paramString)
  {
    f.c().openSessionReport(900, paramString, paramm.b(), paramm.c());
  }
  
  public final void a(boolean paramBoolean)
  {
    b.c("ServiceImpl", "onSessionServiceStateChange() idle=" + paramBoolean);
    c localc = g.a(this.a);
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localc.obtainMessage(6, i, 0).sendToTarget();
      return;
    }
  }
  
  public final void b(m paramm, String paramString)
  {
    IUploadReport localIUploadReport = f.c();
    int i;
    switch (paramm.a())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      localIUploadReport.openSessionReport(i, paramString, paramm.b(), paramm.c());
      return;
      i = 541;
      continue;
      i = 542;
      continue;
      i = 543;
      continue;
      i = 544;
      continue;
      i = 545;
      continue;
      i = 546;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */