package com.facebook.soloader;

import java.io.File;
import java.io.IOException;

public class DirectorySoSource
  extends SoSource
{
  public static final int ON_LD_LIBRARY_PATH = 2;
  public static final int RESOLVE_DEPENDENCIES = 1;
  private final int flags;
  protected final File soDirectory;
  
  public DirectorySoSource(File paramFile, int paramInt)
  {
    this.soDirectory = paramFile;
    this.flags = paramInt;
  }
  
  protected void load(String paramString)
  {
    System.load(paramString);
  }
  
  public int loadLibrary(String paramString, int paramInt)
    throws IOException
  {
    paramString = new File(this.soDirectory, paramString);
    if (!paramString.exists()) {
      return 0;
    }
    if (((paramInt & 0x1) != 0) && ((this.flags & 0x2) != 0)) {
      return 2;
    }
    if ((this.flags & 0x1) != 0)
    {
      String[] arrayOfString = MinElf.extract_DT_NEEDED(paramString);
      int i = 0;
      if (i < arrayOfString.length)
      {
        String str = arrayOfString[i];
        if (str.startsWith("/")) {}
        for (;;)
        {
          i += 1;
          break;
          SoLoader.loadLibraryBySoName(str, paramInt | 0x1);
        }
      }
    }
    load(paramString.getAbsolutePath());
    return 1;
  }
  
  public File unpackLibrary(String paramString)
    throws IOException
  {
    paramString = new File(this.soDirectory, paramString);
    if (paramString.exists()) {
      return paramString;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\soloader\DirectorySoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */