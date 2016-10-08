package com.facebook.common.internal;

import com.android.internal.util.facebook.Predicate;

public class AndroidPredicates
{
  public static <T> Predicate<T> False()
  {
    new Predicate()
    {
      public boolean apply(T paramAnonymousT)
      {
        return false;
      }
    };
  }
  
  public static <T> Predicate<T> True()
  {
    new Predicate()
    {
      public boolean apply(T paramAnonymousT)
      {
        return true;
      }
    };
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\internal\AndroidPredicates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */