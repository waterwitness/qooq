package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class CppSystemErrorException
  extends CppException
{
  int errorCode;
  
  @DoNotStrip
  public CppSystemErrorException(String paramString, int paramInt)
  {
    super(paramString);
    this.errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\jni\CppSystemErrorException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */