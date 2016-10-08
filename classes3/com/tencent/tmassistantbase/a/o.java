package com.tencent.tmassistantbase.a;

import java.util.concurrent.atomic.AtomicBoolean;

final class o
  implements Runnable
{
  public void run()
  {
    if ((m.h == null) || (!m.g()) || (m.t.get())) {
      return;
    }
    new p(this, "TMLogInitThread").start();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistantbase\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */