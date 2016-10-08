package com.tencent.commonsdk.zip;

import java.io.IOException;
import java.util.zip.ZipEntry;

public class QZipIOException
  extends IOException
{
  public static boolean isInvalidEntry(ZipEntry paramZipEntry)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramZipEntry != null)
    {
      paramZipEntry = paramZipEntry.getName();
      bool1 = bool2;
      if (paramZipEntry != null) {
        if (!paramZipEntry.contains("../"))
        {
          bool1 = bool2;
          if (!paramZipEntry.contains("..\\")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\zip\QZipIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */