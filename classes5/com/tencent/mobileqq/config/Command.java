package com.tencent.mobileqq.config;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class Command
{
  public static final int a = 1;
  public static final int b = 2;
  private String a;
  
  public Command(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Command))) {}
    while (!toString().equals(paramObject.toString())) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\config\Command.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */