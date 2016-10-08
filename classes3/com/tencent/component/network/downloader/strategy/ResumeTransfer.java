package com.tencent.component.network.downloader.strategy;

import com.tencent.component.network.downloader.a;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public abstract interface ResumeTransfer
{
  public abstract void addCacheTmpFile(String paramString1, String paramString2, HttpResponse paramHttpResponse);
  
  public abstract void cleanCache();
  
  public abstract void cleanCache(String paramString);
  
  public abstract String getResumeTmpFile(String paramString);
  
  public abstract boolean handleResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse);
  
  public abstract void onDownloadResult(String paramString, boolean paramBoolean);
  
  public abstract void prepareRequest(HttpGet paramHttpGet, String paramString1, String paramString2);
  
  public abstract void setSupportDomains(String[] paramArrayOfString, boolean paramBoolean);
  
  public abstract void setUrlKeyGenerator(a parama);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\strategy\ResumeTransfer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */