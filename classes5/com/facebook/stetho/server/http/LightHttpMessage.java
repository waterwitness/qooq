package com.facebook.stetho.server.http;

import java.util.ArrayList;
import javax.annotation.Nullable;

public class LightHttpMessage
{
  public final ArrayList<String> headerNames = new ArrayList();
  public final ArrayList<String> headerValues = new ArrayList();
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.headerNames.add(paramString1);
    this.headerValues.add(paramString2);
  }
  
  @Nullable
  public String getFirstHeaderValue(String paramString)
  {
    int i = 0;
    int j = this.headerNames.size();
    for (;;)
    {
      if (i >= j) {
        return null;
      }
      if (paramString.equals(this.headerNames.get(i))) {
        return (String)this.headerValues.get(i);
      }
      i += 1;
    }
  }
  
  public void reset()
  {
    this.headerNames.clear();
    this.headerValues.clear();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\server\http\LightHttpMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */