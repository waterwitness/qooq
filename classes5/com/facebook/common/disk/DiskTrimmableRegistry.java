package com.facebook.common.disk;

public abstract interface DiskTrimmableRegistry
{
  public abstract void registerDiskTrimmable(DiskTrimmable paramDiskTrimmable);
  
  public abstract void unregisterDiskTrimmable(DiskTrimmable paramDiskTrimmable);
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\common\disk\DiskTrimmableRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */