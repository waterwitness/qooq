package com.facebook.soloader;

import java.io.File;
import java.io.IOException;

public abstract class SoSource
{
  public static final int LOAD_FLAG_ALLOW_IMPLICIT_PROVISION = 1;
  public static final int LOAD_RESULT_IMPLICITLY_PROVIDED = 2;
  public static final int LOAD_RESULT_LOADED = 1;
  public static final int LOAD_RESULT_NOT_FOUND = 0;
  
  public abstract int loadLibrary(String paramString, int paramInt)
    throws IOException;
  
  public abstract File unpackLibrary(String paramString)
    throws IOException;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\soloader\SoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */