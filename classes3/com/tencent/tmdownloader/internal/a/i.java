package com.tencent.tmdownloader.internal.a;

import java.util.Comparator;

class i
  implements Comparator<g>
{
  i(h paramh) {}
  
  public int a(g paramg1, g paramg2)
  {
    if (paramg1.d() > paramg2.d()) {
      return 1;
    }
    if (paramg1.d() == paramg2.d()) {
      return 0;
    }
    return -1;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmdownloader\internal\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */