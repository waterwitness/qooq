package com.facebook.stetho.common;

import java.util.ArrayList;

public final class ArrayListAccumulator<E>
  extends ArrayList<E>
  implements Accumulator<E>
{
  public void store(E paramE)
  {
    add(paramE);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\ArrayListAccumulator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */