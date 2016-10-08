package com.facebook.stetho.server.http;

public class ExactPathMatcher
  implements PathMatcher
{
  private final String mPath;
  
  public ExactPathMatcher(String paramString)
  {
    this.mPath = paramString;
  }
  
  public boolean match(String paramString)
  {
    return this.mPath.equals(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\http\ExactPathMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */