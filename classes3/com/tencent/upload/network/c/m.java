package com.tencent.upload.network.c;

import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.a.b.a;
import java.lang.ref.WeakReference;

final class m
  implements b.a
{
  m(c paramc) {}
  
  public final void a()
  {
    com.tencent.upload.a.b.b("Session", c.b(this.a) + " onFailtoUnpackHandshake");
    b localb = (b)c.e(this.a).get();
    if (localb != null) {
      localb.a(this.a, 2, false);
    }
  }
  
  public final void a(com.tencent.upload.network.a.b paramb)
  {
    com.tencent.upload.a.b.b("Session", c.b(this.a) + " onShakeHands");
    com.tencent.upload.network.b.m localm = paramb.a();
    if (localm != null) {
      com.tencent.upload.a.b.b("Session", c.b(this.a) + " onShakeHands getRedirectRoute = " + localm);
    }
    if ((localm != null) && (c.c(this.a) != null)) {
      localm.c(c.c(this.a).f());
    }
    c.a(this.a, localm);
    UploadConfiguration.setUploadServerTimePair(paramb.c());
    c.a(this.a, paramb.b());
    c.d(this.a);
    paramb = (b)c.e(this.a).get();
    if (paramb != null) {
      paramb.a(this.a);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    com.tencent.upload.a.b.b("Session", c.b(this.a) + " onFailtoShakeHands");
    b localb = (b)c.e(this.a).get();
    if (localb != null) {
      localb.a(this.a, 1, paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\network\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */