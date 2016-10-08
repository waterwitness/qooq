package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.qqsharpP.QQSharpPUtil;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class SignatureTemplateDownloader
  extends AbsDownloader
{
  public static final String a = "sig_zip";
  public static final String b = "sig_cover";
  public static final String d = "my_uin";
  public static final String e = "img_filename";
  private static final String f = "SignatureTemplateDownloader";
  
  public SignatureTemplateDownloader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = paramDownloadParams.url.getFile();
    if (paramOutputStream.startsWith(File.separator)) {
      paramOutputStream = paramOutputStream.substring(1);
    }
    for (;;)
    {
      String str = paramDownloadParams.url.getHost();
      Object localObject = paramDownloadParams.getHeader("my_uin");
      paramURLDrawableHandler = null;
      if (localObject != null) {
        paramURLDrawableHandler = ((Header)localObject).getValue();
      }
      paramURLDrawableHandler = (SignatureManager)((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(paramURLDrawableHandler)).getManager(57);
      localObject = new File(SignatureTemplateConfig.a(paramOutputStream, str));
      if (((File)localObject).exists()) {
        return (File)localObject;
      }
      if (paramDownloadParams.useSharpPImage)
      {
        localObject = new File(QQSharpPUtil.a((File)localObject));
        if (((File)localObject).exists()) {
          return (File)localObject;
        }
      }
      return paramURLDrawableHandler.a(paramOutputStream, str, paramDownloadParams.useSharpPImage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\SignatureTemplateDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */