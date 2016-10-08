package com.tencent.component.network.downloader.strategy;

import org.apache.http.HttpRequest;

public abstract interface DownloadPreprocessStrategy
{
  public abstract DownloadPool downloadPool(String paramString1, String paramString2);
  
  public abstract void prepareRequest(String paramString1, String paramString2, HttpRequest paramHttpRequest);
  
  public abstract String prepareUrl(String paramString);
  
  public static enum DownloadPool
  {
    private String a;
    
    private DownloadPool(String paramString1)
    {
      this.a = paramString1;
    }
    
    public static int size()
    {
      return 2;
    }
    
    public final String getName()
    {
      return this.a;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\strategy\DownloadPreprocessStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */