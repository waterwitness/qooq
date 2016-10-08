package com.facebook.stetho.inspector.console;

public abstract interface RuntimeRepl
{
  public abstract Object evaluate(String paramString)
    throws Throwable;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\console\RuntimeRepl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */