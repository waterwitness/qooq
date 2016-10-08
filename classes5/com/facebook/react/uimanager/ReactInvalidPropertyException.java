package com.facebook.react.uimanager;

public class ReactInvalidPropertyException
  extends RuntimeException
{
  public ReactInvalidPropertyException(String paramString1, String paramString2, String paramString3)
  {
    super("Invalid React property `" + paramString1 + "` with value `" + paramString2 + "`, expected " + paramString3);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\ReactInvalidPropertyException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */