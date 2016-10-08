package com.facebook.react.bridge;

public abstract interface Promise
{
  public abstract void reject(String paramString);
  
  public abstract void reject(Throwable paramThrowable);
  
  public abstract void resolve(Object paramObject);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\Promise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */