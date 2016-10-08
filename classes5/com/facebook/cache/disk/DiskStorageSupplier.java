package com.facebook.cache.disk;

import java.io.IOException;

public abstract interface DiskStorageSupplier
{
  public abstract DiskStorage get()
    throws IOException;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\disk\DiskStorageSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */