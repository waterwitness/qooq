package com.facebook.react.bridge;

public abstract interface ReadableArray
{
  public abstract ReadableArray getArray(int paramInt);
  
  public abstract boolean getBoolean(int paramInt);
  
  public abstract double getDouble(int paramInt);
  
  public abstract int getInt(int paramInt);
  
  public abstract ReadableMap getMap(int paramInt);
  
  public abstract String getString(int paramInt);
  
  public abstract ReadableType getType(int paramInt);
  
  public abstract boolean isNull(int paramInt);
  
  public abstract int size();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\ReadableArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */