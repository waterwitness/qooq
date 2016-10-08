package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

public class AvatarPendantDownloader
  extends AbsDownloader
{
  public static final String a = "protocol_pendant_image";
  
  public AvatarPendantDownloader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams == null) || (paramDownloadParams.url == null)) {
      paramOutputStream = null;
    }
    String str;
    Object localObject2;
    do
    {
      return paramOutputStream;
      paramOutputStream = paramDownloadParams.url.getHost();
      str = paramDownloadParams.url.getFile();
      if (!"DEFAULT_HEAD".equals(paramOutputStream)) {
        break;
      }
      localObject2 = AppConstants.bj + "avatarPendantDefaultHead" + str;
      localObject1 = new File((String)localObject2);
      paramOutputStream = (OutputStream)localObject1;
    } while (((File)localObject1).exists());
    Object localObject1 = "http://i.gtimg.cn/qqshow/admindata/comdata/mobileDefaultHead/" + str;
    paramOutputStream = (OutputStream)localObject2;
    for (;;)
    {
      if (localObject1 != null)
      {
        paramDownloadParams.url = new URL((String)localObject1);
        if (QLog.isDevelopLevel()) {
          QLog.d("AvatarPendantDownloader", 4, "downloadImage pendant: " + (String)localObject1 + " -> " + paramOutputStream);
        }
        paramURLDrawableHandler.publishProgress(0);
        localObject2 = new FileOutputStream(paramOutputStream);
        try
        {
          new HttpDownloader().a((OutputStream)localObject2, paramDownloadParams, paramURLDrawableHandler);
          ((FileOutputStream)localObject2).close();
          paramDownloadParams = new File(paramOutputStream);
          paramOutputStream = paramDownloadParams;
          if (paramDownloadParams.exists()) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("AvatarPendantDownloader", 2, "downloadImage pendant fail.-> " + (String)localObject1);
          }
          return null;
          if ((!"AIO_STATIC".equals(paramOutputStream)) || (TextUtils.isEmpty(str))) {
            break label410;
          }
          paramOutputStream = new File(AppConstants.bY + str);
          if (!paramOutputStream.exists()) {
            paramOutputStream.mkdir();
          }
          long l = Long.valueOf(str.split("/")[1]).longValue();
          localObject1 = AvatarPendantUtil.a(l, 5);
          localObject2 = new File((String)localObject1);
          paramOutputStream = (OutputStream)localObject2;
          if (((File)localObject2).exists()) {
            break;
          }
          localObject2 = AvatarPendantUtil.b(l, 5);
          paramOutputStream = (OutputStream)localObject1;
          localObject1 = localObject2;
        }
        catch (Exception paramDownloadParams)
        {
          for (;;)
          {
            ((FileOutputStream)localObject2).close();
            new File(paramOutputStream).delete();
          }
        }
      }
      return null;
      label410:
      paramOutputStream = null;
      localObject1 = null;
    }
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\AvatarPendantDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */