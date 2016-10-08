package com.facebook.react.bridge;

public abstract interface WritableArray
  extends ReadableArray
{
  public abstract void pushArray(WritableArray paramWritableArray);
  
  public abstract void pushBoolean(boolean paramBoolean);
  
  public abstract void pushDouble(double paramDouble);
  
  public abstract void pushInt(int paramInt);
  
  public abstract void pushMap(WritableMap paramWritableMap);
  
  public abstract void pushNull();
  
  public abstract void pushString(String paramString);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\WritableArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */