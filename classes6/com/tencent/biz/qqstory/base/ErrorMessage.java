package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ErrorMessage
  extends Error
{
  public static final int NO_ERROR = 0;
  public static final int NO_ERROR_FROM_MSF = 1000;
  public int errorCode;
  public String errorMsg;
  public String extraMsg;
  
  public ErrorMessage()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.errorCode = 0;
    this.errorMsg = "";
  }
  
  public ErrorMessage(int paramInt, String paramString)
  {
    int i = paramInt;
    if (paramInt == 1000) {
      i = 0;
    }
    this.errorCode = i;
    this.errorMsg = paramString;
  }
  
  public String getErrorMessage()
  {
    return String.format("%s(%d)", new Object[] { this.errorMsg, Integer.valueOf(this.errorCode) });
  }
  
  public String getErrorMessage(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      str = "无法连接网络,请稍后重试";
    }
    return String.format("%s(%d)", new Object[] { str, Integer.valueOf(this.errorCode) });
  }
  
  public boolean isFail()
  {
    return this.errorCode != 0;
  }
  
  public boolean isSuccess()
  {
    return this.errorCode == 0;
  }
  
  public String toString()
  {
    return "ErrorMessage{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\ErrorMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */