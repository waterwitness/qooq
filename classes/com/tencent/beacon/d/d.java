package com.tencent.beacon.d;

import android.util.SparseArray;

public final class d<E>
{
  public static SparseArray<E> a(SparseArray<E> paramSparseArray)
  {
    if (paramSparseArray != null)
    {
      SparseArray localSparseArray = new SparseArray(paramSparseArray.size());
      int i = 0;
      while (i < paramSparseArray.size())
      {
        int j = paramSparseArray.keyAt(i);
        localSparseArray.append(j, paramSparseArray.get(j));
        i += 1;
      }
      return localSparseArray;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\beacon\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */