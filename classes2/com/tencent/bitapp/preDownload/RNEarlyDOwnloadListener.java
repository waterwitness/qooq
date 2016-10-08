package com.tencent.bitapp.preDownload;

import com.tencent.mobileqq.earlydownload.EarlyDownloadManager.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class RNEarlyDOwnloadListener
  implements EarlyDownloadManager.EarlyDownLoadListener
{
  protected static final String a = "RNEarlyDOwnloadListener";
  
  public RNEarlyDOwnloadListener()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RNEarlyDOwnloadListener", 4, "RNEarlyDOwnloadListener onDownloadBegin");
    }
  }
  
  public void a(XmlData paramXmlData, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      int i = (int)(100L * paramLong1 / paramLong2);
      QLog.d("RNEarlyDOwnloadListener", 4, "RNEarlyDOwnloadListener onDownloadProgress curOffset: " + paramLong1 + " | totalLen: " + paramLong2 + " | progress: " + i);
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RNEarlyDOwnloadListener", 4, "RNEarlyDOwnloadListener onDownloadFinish, result: " + paramBoolean1 + " | errCode: " + paramInt + " | filepath: " + paramString);
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RNEarlyDOwnloadListener", 4, "RNEarlyDOwnloadListener onDownloadCancel");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\preDownload\RNEarlyDOwnloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */