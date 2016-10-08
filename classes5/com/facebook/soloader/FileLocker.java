package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public final class FileLocker
  implements Closeable
{
  private final FileLock mLock;
  private final FileOutputStream mLockFileOutputStream;
  
  private FileLocker(File paramFile)
    throws IOException
  {
    this.mLockFileOutputStream = new FileOutputStream(paramFile);
    try
    {
      paramFile = this.mLockFileOutputStream.getChannel().lock();
      if (paramFile == null) {
        this.mLockFileOutputStream.close();
      }
      this.mLock = paramFile;
      return;
    }
    finally
    {
      if (0 == 0) {
        this.mLockFileOutputStream.close();
      }
    }
  }
  
  public static FileLocker lock(File paramFile)
    throws IOException
  {
    return new FileLocker(paramFile);
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.mLock.release();
      return;
    }
    finally
    {
      this.mLockFileOutputStream.close();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\soloader\FileLocker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */