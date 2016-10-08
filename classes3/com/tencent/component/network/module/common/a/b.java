package com.tencent.component.network.module.common.a;

import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static b a = null;
  private static AtomicInteger b = new AtomicInteger(100);
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  public final int b()
  {
    try
    {
      int j = b.getAndIncrement();
      int i = j;
      if (j >= 65535)
      {
        AtomicInteger localAtomicInteger = new AtomicInteger(100);
        b = localAtomicInteger;
        i = localAtomicInteger.getAndIncrement();
      }
      return i;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\common\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */