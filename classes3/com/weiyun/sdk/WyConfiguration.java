package com.weiyun.sdk;

public class WyConfiguration
{
  private static final long MAX_DISK_CACHE_SIZE = 20971520L;
  private final String cachePath;
  private boolean debug = false;
  private long maxDiskCacheSize = 20971520L;
  private int maxTaskNum = 2;
  
  public WyConfiguration(String paramString)
  {
    this.cachePath = paramString;
  }
  
  public void enableDebugModel()
  {
    this.debug = true;
  }
  
  public String getCachePath()
  {
    return this.cachePath;
  }
  
  public long getMaxDiskCacheSize()
  {
    return this.maxDiskCacheSize;
  }
  
  public int getMaxTaskNum()
  {
    return this.maxTaskNum;
  }
  
  public int getTaskNum()
  {
    return this.maxTaskNum;
  }
  
  public boolean isDebugModel()
  {
    return this.debug;
  }
  
  public void setMaxDiskCacheSize(long paramLong)
  {
    this.maxDiskCacheSize = paramLong;
  }
  
  public void setMaxTaskNum(int paramInt)
  {
    this.maxTaskNum = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\WyConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */