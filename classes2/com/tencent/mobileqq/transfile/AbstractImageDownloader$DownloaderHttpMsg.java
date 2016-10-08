package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

public class AbstractImageDownloader$DownloaderHttpMsg
  extends HttpMsg
{
  boolean a;
  
  public AbstractImageDownloader$DownloaderHttpMsg(String paramString, byte[] paramArrayOfByte, IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    super(paramString, paramArrayOfByte, paramIHttpCommunicatorListener);
    this.a = false;
  }
  
  public AbstractImageDownloader$DownloaderHttpMsg(String paramString, byte[] paramArrayOfByte, IHttpCommunicatorListener paramIHttpCommunicatorListener, boolean paramBoolean)
  {
    super(paramString, paramArrayOfByte, paramIHttpCommunicatorListener, paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\AbstractImageDownloader$DownloaderHttpMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */