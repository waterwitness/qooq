package com.tencent.open.downloadnew;

import java.util.List;

public abstract interface DownloadListener
{
  public abstract void a(DownloadInfo paramDownloadInfo);
  
  public abstract void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(List paramList);
  
  public abstract void b(DownloadInfo paramDownloadInfo);
  
  public abstract void b(String paramString1, String paramString2);
  
  public abstract void c(DownloadInfo paramDownloadInfo);
  
  public abstract void c(String paramString1, String paramString2);
  
  public abstract void d(DownloadInfo paramDownloadInfo);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\DownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */