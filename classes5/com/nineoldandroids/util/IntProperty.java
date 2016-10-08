package com.nineoldandroids.util;

public abstract class IntProperty<T>
  extends Property<T, Integer>
{
  public IntProperty(String paramString)
  {
    super(Integer.class, paramString);
  }
  
  public final void set(T paramT, Integer paramInteger)
  {
    set(paramT, Integer.valueOf(paramInteger.intValue()));
  }
  
  public abstract void setValue(T paramT, int paramInt);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\nineoldandroids\util\IntProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */