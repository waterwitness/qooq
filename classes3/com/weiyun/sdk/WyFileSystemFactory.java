package com.weiyun.sdk;

import com.weiyun.sdk.impl.WyFileSystem;

public class WyFileSystemFactory
{
  private static volatile IWyFileSystem sFileSystem;
  
  public static IWyFileSystem getWyFileSystem()
  {
    if (sFileSystem == null) {}
    try
    {
      if (sFileSystem == null) {
        sFileSystem = new WyFileSystem();
      }
      return sFileSystem;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\WyFileSystemFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */