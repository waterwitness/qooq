package com.facebook.react.bridge;

public abstract interface WritableMap
  extends ReadableMap
{
  public abstract void merge(ReadableMap paramReadableMap);
  
  public abstract void putArray(String paramString, WritableArray paramWritableArray);
  
  public abstract void putBoolean(String paramString, boolean paramBoolean);
  
  public abstract void putDouble(String paramString, double paramDouble);
  
  public abstract void putInt(String paramString, int paramInt);
  
  public abstract void putMap(String paramString, WritableMap paramWritableMap);
  
  public abstract void putNull(String paramString);
  
  public abstract void putString(String paramString1, String paramString2);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\WritableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */