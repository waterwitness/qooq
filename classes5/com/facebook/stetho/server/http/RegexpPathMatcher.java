package com.facebook.stetho.server.http;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpPathMatcher
  implements PathMatcher
{
  private final Pattern mPattern;
  
  public RegexpPathMatcher(Pattern paramPattern)
  {
    this.mPattern = paramPattern;
  }
  
  public boolean match(String paramString)
  {
    return this.mPattern.matcher(paramString).matches();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\http\RegexpPathMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */