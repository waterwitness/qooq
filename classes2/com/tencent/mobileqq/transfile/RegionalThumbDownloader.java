package com.tencent.mobileqq.transfile;

import android.app.Application;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.RegionalThumbDecoder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class RegionalThumbDownloader
  extends ProtocolDownloader.Adapter
{
  public RegionalThumbDownloader(Application paramApplication)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.a = paramString;
    paramString = new File(paramString);
    if (paramString.exists()) {
      localLocalMediaInfo.d = paramString.lastModified();
    }
    localLocalMediaInfo.f = paramInt1;
    localLocalMediaInfo.g = paramInt2;
    try
    {
      paramString = new URL("regionalthumb", null, LocalMediaInfo.a(localLocalMediaInfo));
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new RegionalThumbDecoder().a(paramDownloadParams.url);
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    boolean bool2 = false;
    paramDownloadParams = LocalMediaInfo.a(paramDownloadParams.url);
    boolean bool1 = bool2;
    if (paramDownloadParams != null)
    {
      bool1 = bool2;
      if (new File(paramDownloadParams.a).exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = LocalMediaInfo.a(paramDownloadParams.url);
    if (paramDownloadParams != null)
    {
      paramDownloadParams = new File(paramDownloadParams.a);
      if (paramDownloadParams.exists()) {
        return paramDownloadParams;
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\RegionalThumbDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */