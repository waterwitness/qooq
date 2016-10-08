package com.facebook.common.internal;

public class Suppliers
{
  public static <T> Supplier<T> of(T paramT)
  {
    new Supplier()
    {
      public T get()
      {
        return Suppliers.this;
      }
    };
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\internal\Suppliers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */