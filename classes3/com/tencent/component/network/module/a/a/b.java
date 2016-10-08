package com.tencent.component.network.module.a.a;

import java.util.Comparator;

public final class b<V>
  extends a<V>
{
  private final Comparator<V> a;
  
  public b(Comparator<V> paramComparator)
  {
    super(100);
    this.a = paramComparator;
  }
  
  public final void add(int paramInt, V paramV)
  {
    if (paramV == null) {
      return;
    }
    if (this.a == null)
    {
      super.add(paramInt, paramV);
      return;
    }
    add(paramV);
  }
  
  public final boolean add(V paramV)
  {
    int i = 0;
    if (paramV == null) {
      return false;
    }
    if (this.a == null) {
      return super.add(paramV);
    }
    int j = size();
    for (;;)
    {
      if (i >= j) {}
      Object localObject;
      do
      {
        super.add(i, paramV);
        return true;
        localObject = get(i);
      } while ((localObject != null) && (this.a.compare(paramV, localObject) <= 0));
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */