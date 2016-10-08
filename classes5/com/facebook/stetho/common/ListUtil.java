package com.facebook.stetho.common;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class ListUtil
{
  public static <T> List<T> copyToImmutableList(List<T> paramList)
  {
    if ((paramList instanceof ImmutableList)) {
      return paramList;
    }
    switch (paramList.size())
    {
    default: 
      return new ImmutableArrayList(paramList.toArray());
    case 0: 
      return Collections.emptyList();
    case 1: 
      return new OneItemImmutableList(paramList.get(0));
    case 2: 
      return new TwoItemImmutableList(paramList.get(0), paramList.get(1));
    case 3: 
      return new ThreeItemImmutableList(paramList.get(0), paramList.get(1), paramList.get(2));
    case 4: 
      return new FourItemImmutableList(paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3));
    }
    return new FiveItemImmutableList(paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3), paramList.get(4));
  }
  
  public static <T> boolean identityEquals(List<? extends T> paramList1, List<? extends T> paramList2)
  {
    if (paramList1 == paramList2) {}
    for (;;)
    {
      return true;
      int j = paramList1.size();
      if (j != paramList2.size()) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        if (paramList1.get(i) != paramList2.get(i)) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public static <T> List<T> newImmutableList(T paramT)
  {
    return new OneItemImmutableList(paramT);
  }
  
  private static final class FiveItemImmutableList<E>
    extends AbstractList<E>
    implements ListUtil.ImmutableList<E>
  {
    private final E mItem0;
    private final E mItem1;
    private final E mItem2;
    private final E mItem3;
    private final E mItem4;
    
    public FiveItemImmutableList(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
    {
      this.mItem0 = paramE1;
      this.mItem1 = paramE2;
      this.mItem2 = paramE3;
      this.mItem3 = paramE4;
      this.mItem4 = paramE5;
    }
    
    public E get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IndexOutOfBoundsException();
      case 0: 
        return (E)this.mItem0;
      case 1: 
        return (E)this.mItem1;
      case 2: 
        return (E)this.mItem2;
      case 3: 
        return (E)this.mItem3;
      }
      return (E)this.mItem4;
    }
    
    public int size()
    {
      return 5;
    }
  }
  
  private static final class FourItemImmutableList<E>
    extends AbstractList<E>
    implements ListUtil.ImmutableList<E>
  {
    private final E mItem0;
    private final E mItem1;
    private final E mItem2;
    private final E mItem3;
    
    public FourItemImmutableList(E paramE1, E paramE2, E paramE3, E paramE4)
    {
      this.mItem0 = paramE1;
      this.mItem1 = paramE2;
      this.mItem2 = paramE3;
      this.mItem3 = paramE4;
    }
    
    public E get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IndexOutOfBoundsException();
      case 0: 
        return (E)this.mItem0;
      case 1: 
        return (E)this.mItem1;
      case 2: 
        return (E)this.mItem2;
      }
      return (E)this.mItem3;
    }
    
    public int size()
    {
      return 4;
    }
  }
  
  private static final class ImmutableArrayList<E>
    extends AbstractList<E>
    implements ListUtil.ImmutableList<E>
  {
    private final Object[] mArray;
    
    public ImmutableArrayList(Object[] paramArrayOfObject)
    {
      this.mArray = paramArrayOfObject;
    }
    
    public E get(int paramInt)
    {
      return (E)this.mArray[paramInt];
    }
    
    public int size()
    {
      return this.mArray.length;
    }
  }
  
  private static abstract interface ImmutableList<E>
    extends List<E>, RandomAccess
  {}
  
  private static final class OneItemImmutableList<E>
    extends AbstractList<E>
    implements ListUtil.ImmutableList<E>
  {
    private final E mItem;
    
    public OneItemImmutableList(E paramE)
    {
      this.mItem = paramE;
    }
    
    public E get(int paramInt)
    {
      if (paramInt == 0) {
        return (E)this.mItem;
      }
      throw new IndexOutOfBoundsException();
    }
    
    public int size()
    {
      return 1;
    }
  }
  
  private static final class ThreeItemImmutableList<E>
    extends AbstractList<E>
    implements ListUtil.ImmutableList<E>
  {
    private final E mItem0;
    private final E mItem1;
    private final E mItem2;
    
    public ThreeItemImmutableList(E paramE1, E paramE2, E paramE3)
    {
      this.mItem0 = paramE1;
      this.mItem1 = paramE2;
      this.mItem2 = paramE3;
    }
    
    public E get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IndexOutOfBoundsException();
      case 0: 
        return (E)this.mItem0;
      case 1: 
        return (E)this.mItem1;
      }
      return (E)this.mItem2;
    }
    
    public int size()
    {
      return 3;
    }
  }
  
  private static final class TwoItemImmutableList<E>
    extends AbstractList<E>
    implements ListUtil.ImmutableList<E>
  {
    private final E mItem0;
    private final E mItem1;
    
    public TwoItemImmutableList(E paramE1, E paramE2)
    {
      this.mItem0 = paramE1;
      this.mItem1 = paramE2;
    }
    
    public E get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IndexOutOfBoundsException();
      case 0: 
        return (E)this.mItem0;
      }
      return (E)this.mItem1;
    }
    
    public int size()
    {
      return 2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\ListUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */