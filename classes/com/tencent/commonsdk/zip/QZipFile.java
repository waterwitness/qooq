package com.tencent.commonsdk.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class QZipFile
  extends ZipFile
{
  public QZipFile(File paramFile)
    throws ZipException, IOException
  {
    super(paramFile);
  }
  
  public QZipFile(File paramFile, int paramInt)
    throws IOException
  {
    super(paramFile, paramInt);
  }
  
  public QZipFile(String paramString)
    throws IOException
  {
    super(paramString);
  }
  
  public InputStream getInputStream(ZipEntry paramZipEntry)
    throws IOException
  {
    if (QZipIOException.isInvalidEntry(paramZipEntry)) {
      throw new QZipIOException();
    }
    return super.getInputStream(paramZipEntry);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\commonsdk\zip\QZipFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */