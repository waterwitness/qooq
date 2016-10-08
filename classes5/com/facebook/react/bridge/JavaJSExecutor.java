package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract interface JavaJSExecutor
{
  public abstract void close();
  
  @DoNotStrip
  public abstract void executeApplicationScript(String paramString1, String paramString2)
    throws JavaJSExecutor.ProxyExecutorException;
  
  @DoNotStrip
  public abstract String executeJSCall(String paramString1, String paramString2)
    throws JavaJSExecutor.ProxyExecutorException;
  
  @DoNotStrip
  public abstract void setGlobalVariable(String paramString1, String paramString2);
  
  public static class ProxyExecutorException
    extends Exception
  {
    public ProxyExecutorException(Throwable paramThrowable)
    {
      super();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\JavaJSExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */