package com.facebook.react.bridge;

public abstract interface ReadableMap
{
  public abstract ReadableArray getArray(String paramString);
  
  public abstract boolean getBoolean(String paramString);
  
  public abstract double getDouble(String paramString);
  
  public abstract int getInt(String paramString);
  
  public abstract ReadableMap getMap(String paramString);
  
  public abstract String getString(String paramString);
  
  public abstract ReadableType getType(String paramString);
  
  public abstract boolean hasKey(String paramString);
  
  public abstract boolean isNull(String paramString);
  
  public abstract ReadableMapKeySetIterator keySetIterator();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\ReadableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */