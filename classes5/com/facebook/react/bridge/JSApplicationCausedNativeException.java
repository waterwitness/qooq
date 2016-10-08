package com.facebook.react.bridge;

import javax.annotation.Nullable;

public class JSApplicationCausedNativeException
  extends RuntimeException
{
  public JSApplicationCausedNativeException(String paramString)
  {
    super(paramString);
  }
  
  public JSApplicationCausedNativeException(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\JSApplicationCausedNativeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */