package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ThreadBound;

public abstract interface DocumentProviderFactory
  extends ThreadBound
{
  public abstract DocumentProvider create();
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\DocumentProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */