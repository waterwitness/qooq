package com.facebook.stetho;

import com.facebook.stetho.dumpapp.DumperPlugin;

public abstract interface DumperPluginsProvider
{
  public abstract Iterable<DumperPlugin> get();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\DumperPluginsProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */