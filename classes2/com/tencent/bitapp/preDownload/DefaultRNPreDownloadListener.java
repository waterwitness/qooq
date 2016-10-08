package com.tencent.bitapp.preDownload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class DefaultRNPreDownloadListener
  implements IRNPreDownloadListener
{
  protected static final String a = "RNEarlyDOwnloadListener";
  
  public DefaultRNPreDownloadListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RNEarlyDOwnloadListener", 4, "DefaultRNPreDownloadListener onLoadSuccess");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RNEarlyDOwnloadListener", 4, "DefaultRNPreDownloadListener onLoadFail");
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RNEarlyDOwnloadListener", 4, "DefaultRNPreDownloadListener onProgress");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\preDownload\DefaultRNPreDownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */