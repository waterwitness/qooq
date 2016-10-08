package com.facebook.stetho;

import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;

public abstract interface InspectorModulesProvider
{
  public abstract Iterable<ChromeDevtoolsDomain> get();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\InspectorModulesProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */