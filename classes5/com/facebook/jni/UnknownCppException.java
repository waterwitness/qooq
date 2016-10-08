package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class UnknownCppException
  extends CppException
{
  @DoNotStrip
  public UnknownCppException()
  {
    super("Unknown");
  }
  
  @DoNotStrip
  public UnknownCppException(String paramString)
  {
    super(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\jni\UnknownCppException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */