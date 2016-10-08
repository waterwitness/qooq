package com.google.zxing;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class WriterException
  extends Exception
{
  public WriterException()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public WriterException(String paramString)
  {
    super(paramString);
  }
  
  public WriterException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\google\zxing\WriterException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */