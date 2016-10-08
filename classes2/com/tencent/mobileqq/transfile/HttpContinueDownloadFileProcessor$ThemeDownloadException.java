package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HttpContinueDownloadFileProcessor$ThemeDownloadException
  extends Exception
{
  private int errCode;
  
  public HttpContinueDownloadFileProcessor$ThemeDownloadException()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HttpContinueDownloadFileProcessor$ThemeDownloadException(int paramInt, String paramString)
  {
    super(paramString);
    this.errCode = paramInt;
  }
  
  public HttpContinueDownloadFileProcessor$ThemeDownloadException(String paramString)
  {
    super(paramString);
  }
  
  public HttpContinueDownloadFileProcessor$ThemeDownloadException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public HttpContinueDownloadFileProcessor$ThemeDownloadException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\HttpContinueDownloadFileProcessor$ThemeDownloadException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */