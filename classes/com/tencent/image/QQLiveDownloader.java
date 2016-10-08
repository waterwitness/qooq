package com.tencent.image;

import java.io.File;

public class QQLiveDownloader
  extends ProtocolDownloader.Adapter
{
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    return new QQLiveImage(paramDownloadParams.urlStr, paramDownloadParams.mExtraInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\QQLiveDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */