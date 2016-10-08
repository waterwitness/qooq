package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class LocaleFileDownloader
  extends ProtocolDownloader.Adapter
{
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    Object localObject = null;
    try
    {
      paramDownloadParams = new File(paramDownloadParams.url.toURI().getPath());
      if ((paramDownloadParams != null) && (paramDownloadParams.exists())) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramDownloadParams = (DownloadParams)localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("URLDrawable_", 2, "[hasDiskFile]", localException);
          paramDownloadParams = (DownloadParams)localObject;
        }
      }
    }
    return false;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramURLDrawableHandler = new File(paramDownloadParams.url.toURI().getPath());
    if (paramURLDrawableHandler.exists()) {
      return paramURLDrawableHandler;
    }
    throw new IOException("File not Found. url: " + paramDownloadParams.url);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\LocaleFileDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */