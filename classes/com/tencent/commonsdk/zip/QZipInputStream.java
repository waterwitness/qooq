package com.tencent.commonsdk.zip;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class QZipInputStream
  extends ZipInputStream
{
  public QZipInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public ZipEntry getNextEntry()
    throws IOException
  {
    ZipEntry localZipEntry = super.getNextEntry();
    if (QZipIOException.isInvalidEntry(localZipEntry)) {
      throw new QZipIOException();
    }
    return localZipEntry;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\zip\QZipInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */