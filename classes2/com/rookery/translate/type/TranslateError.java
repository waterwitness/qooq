package com.rookery.translate.type;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TranslateError
  extends Exception
{
  private static final long serialVersionUID = 221843528590808183L;
  
  public TranslateError(Exception paramException)
  {
    super(paramException);
  }
  
  public TranslateError(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public TranslateError(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\rookery\translate\type\TranslateError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */