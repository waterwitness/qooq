package com.tencent.component.network.module.a.a;

import java.util.LinkedList;

public class a<V>
  extends LinkedList<V>
{
  private final int a;
  private final boolean b;
  
  public a(int paramInt)
  {
    this.a = paramInt;
    this.b = false;
  }
  
  private void a()
  {
    for (;;)
    {
      if ((this.a <= 0) || (size() <= this.a)) {
        return;
      }
      removeLast();
    }
  }
  
  public void add(int paramInt, V paramV)
  {
    if (paramV == null) {
      return;
    }
    super.add(paramInt, paramV);
    a();
  }
  
  public boolean add(V paramV)
  {
    if (paramV == null) {
      return false;
    }
    boolean bool = super.add(paramV);
    a();
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\module\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */