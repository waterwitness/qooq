package com.facebook.soloader;

import java.io.File;

public class NoopSoSource
  extends SoSource
{
  public int loadLibrary(String paramString, int paramInt)
  {
    return 1;
  }
  
  public File unpackLibrary(String paramString)
  {
    throw new UnsupportedOperationException("unpacking not supported in test mode");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\soloader\NoopSoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */