package com.facebook.stetho.dumpapp;

public abstract interface DumperPlugin
{
  public abstract void dump(DumperContext paramDumperContext)
    throws DumpException;
  
  public abstract String getName();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\dumpapp\DumperPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */