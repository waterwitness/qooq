package com.tencent.biz.qqstory.model.pendant;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class JsonFormatException
  extends Exception
{
  public JsonFormatException()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public JsonFormatException(String paramString)
  {
    super(paramString);
  }
  
  public JsonFormatException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public JsonFormatException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\pendant\JsonFormatException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */