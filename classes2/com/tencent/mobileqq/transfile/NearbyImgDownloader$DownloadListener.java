package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HttpDownloadUtil.DownloadInfoListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class NearbyImgDownloader$DownloadListener
  implements HttpDownloadUtil.DownloadInfoListener
{
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  private DiskCache.Editor jdField_a_of_type_ComTencentMobileqqTransfileDiskCache$Editor;
  
  public NearbyImgDownloader$DownloadListener(NearbyImgDownloader paramNearbyImgDownloader, DiskCache.Editor paramEditor, URLDrawableHandler paramURLDrawableHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTransfileDiskCache$Editor = paramEditor;
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
  }
  
  public boolean a(DownloadInfo paramDownloadInfo)
  {
    boolean bool = false;
    if ((paramDownloadInfo.b != 0) || (paramDownloadInfo.a != null)) {
      try
      {
        InputStream localInputStream = paramDownloadInfo.a.getInputStream();
        if (localInputStream != null)
        {
          bool = NearbyImgDownloader.a(this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyImgDownloader, localInputStream, paramDownloadInfo.e, this.jdField_a_of_type_ComTencentMobileqqTransfileDiskCache$Editor, this.jdField_a_of_type_ComTencentImageURLDrawableHandler);
          return bool;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w(NearbyImgDownloader.a, 2, localIOException.toString());
          }
          Object localObject = null;
        }
        paramDownloadInfo.b = 11;
        return false;
      }
    }
    paramDownloadInfo.b = 11;
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\NearbyImgDownloader$DownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */