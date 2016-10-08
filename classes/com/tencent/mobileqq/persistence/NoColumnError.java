package com.tencent.mobileqq.persistence;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class NoColumnError
  extends Error
{
  public String mColumnName;
  public Class mColumnType;
  
  public NoColumnError()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NoColumnError(String paramString)
  {
    super(paramString);
  }
  
  public NoColumnError(String paramString, Class paramClass)
  {
    super("No_Such_Column_" + paramString);
    this.mColumnName = paramString;
    this.mColumnType = paramClass;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\persistence\NoColumnError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */