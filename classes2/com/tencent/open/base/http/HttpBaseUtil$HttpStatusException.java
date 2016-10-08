package com.tencent.open.base.http;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class HttpBaseUtil$HttpStatusException
  extends Exception
{
  public static final String ERROR_INFO = "http status code error:";
  
  public HttpBaseUtil$HttpStatusException(String paramString)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\http\HttpBaseUtil$HttpStatusException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */