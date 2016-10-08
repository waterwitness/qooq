package com.tencent.mobileqq.apollo.view;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;
import ptp;
import ptq;

public class QQFrameZipDecoder
  extends SimpleFrameZipDecoder
  implements SimpleFrameZipDecoder.IDownloadable
{
  public QQFrameZipDecoder(SimpleFrameZipDecoder.onFrameDecodeListener paramonFrameDecodeListener)
  {
    super(null, paramonFrameDecodeListener);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewSimpleFrameZipDecoder$IDownloadable = this;
  }
  
  public static String a(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    String str = ApolloConstant.o;
    return str + paramString + ".zip";
  }
  
  public void a(SimpleFrameZipDecoder paramSimpleFrameZipDecoder, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = 1;
    DownloadTask localDownloadTask = new DownloadTask(paramString1, new File(paramString2));
    localDownloadTask.n = false;
    localDownloadTask.l = true;
    localDownloadTask.f = "apollo_gif";
    localDownloadTask.A = 1;
    localDownloadTask.a(new ptp(this, paramString1, paramString2, paramString3));
    paramSimpleFrameZipDecoder = BaseApplicationImpl.a();
    if (paramSimpleFrameZipDecoder != null)
    {
      paramSimpleFrameZipDecoder = paramSimpleFrameZipDecoder.a();
      if (!(paramSimpleFrameZipDecoder instanceof QQAppInterface)) {}
    }
    for (paramSimpleFrameZipDecoder = (QQAppInterface)paramSimpleFrameZipDecoder;; paramSimpleFrameZipDecoder = null)
    {
      if (paramSimpleFrameZipDecoder != null)
      {
        paramSimpleFrameZipDecoder = (DownloaderFactory)paramSimpleFrameZipDecoder.getManager(46);
        if (paramSimpleFrameZipDecoder != null)
        {
          paramSimpleFrameZipDecoder = paramSimpleFrameZipDecoder.a(1);
          if (paramSimpleFrameZipDecoder != null) {
            paramSimpleFrameZipDecoder.a(localDownloadTask, localDownloadTask.a(), null);
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          ThreadManager.d(new ptq(this, localDownloadTask));
        }
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\QQFrameZipDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */