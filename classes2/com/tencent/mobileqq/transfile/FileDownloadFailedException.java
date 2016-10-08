package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class FileDownloadFailedException
  extends RuntimeException
{
  int errorCode;
  long errorDetailCode;
  boolean needReport = true;
  private boolean needRetry;
  
  public FileDownloadFailedException(int paramInt1, int paramInt2, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    super(paramString, paramThrowable);
    this.errorCode = paramInt1;
    this.errorDetailCode = paramInt2;
    this.needRetry = paramBoolean;
  }
  
  public FileDownloadFailedException(int paramInt, long paramLong, String paramString, boolean paramBoolean)
  {
    this(paramInt, paramLong, paramString, paramBoolean, true);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FileDownloadFailedException(int paramInt, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramString);
    this.errorCode = paramInt;
    this.errorDetailCode = paramLong;
    this.needRetry = paramBoolean1;
    this.needReport = paramBoolean2;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\FileDownloadFailedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */