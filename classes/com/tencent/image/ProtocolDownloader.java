package com.tencent.image;

import java.io.File;

public abstract interface ProtocolDownloader
{
  public abstract Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception;
  
  public abstract boolean gifHasDifferentState();
  
  public abstract boolean hasDiskFile(DownloadParams paramDownloadParams);
  
  public abstract File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception;
  
  public static abstract class Adapter
    implements ProtocolDownloader
  {
    public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
      throws Exception
    {
      return null;
    }
    
    public boolean gifHasDifferentState()
    {
      return false;
    }
    
    public boolean hasDiskFile(DownloadParams paramDownloadParams)
    {
      return false;
    }
    
    public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
      throws Exception
    {
      return null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\ProtocolDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */