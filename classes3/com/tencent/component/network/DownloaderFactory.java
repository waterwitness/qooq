package com.tencent.component.network;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.downloader.handler.b;
import com.tencent.component.network.downloader.impl.c;
import com.tencent.component.network.downloader.impl.c.a;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import com.tencent.component.network.module.base.inter.Log;
import java.util.concurrent.Executor;

public class DownloaderFactory
{
  private static volatile DownloaderFactory a = null;
  private static final byte[] b = new byte[0];
  private Downloader c;
  private Downloader d;
  private PortConfigStrategy e;
  private b f = new DownloaderFactory.1();
  protected IPStrategy pBackupIPConfig;
  protected IPStrategy pDirectIPConfig;
  
  private DownloaderFactory(Context paramContext)
  {
    Global.init(paramContext.getApplicationContext());
  }
  
  public static Downloader createDownloader(String paramString)
  {
    return createDownloader(paramString, null, null);
  }
  
  public static Downloader createDownloader(String paramString, Executor paramExecutor1, Executor paramExecutor2)
  {
    if ((Global.getContext() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    com.tencent.component.network.module.common.a.a().a(paramExecutor2);
    paramString = new c(Global.getContext(), paramString);
    paramString.setExecutor(paramExecutor1);
    return paramString;
  }
  
  public static Downloader createImageDownloader(String paramString)
  {
    return createImageDownloader(paramString, null, null);
  }
  
  public static Downloader createImageDownloader(String paramString, Executor paramExecutor1, Executor paramExecutor2)
  {
    if ((Global.getContext() == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    com.tencent.component.network.module.common.a.a().a(paramExecutor2);
    paramString = new c(Global.getContext(), paramString);
    paramString.setExecutor(paramExecutor1);
    c.a.a(paramString);
    return paramString;
  }
  
  public static DownloaderFactory getInstance(Context paramContext)
  {
    if (a == null) {}
    synchronized (b)
    {
      if (a == null) {
        a = new DownloaderFactory(paramContext);
      }
      return a;
    }
  }
  
  public static void init(IDownloadConfig paramIDownloadConfig, Log paramLog)
  {
    com.tencent.component.network.module.base.a.a(paramIDownloadConfig);
    com.tencent.component.network.downloader.common.a.a(paramLog);
  }
  
  public IPStrategy getBackupIpStrategy()
  {
    return this.pBackupIPConfig;
  }
  
  public Downloader getCommonDownloader()
  {
    if (this.c != null) {
      return this.c;
    }
    try
    {
      if (this.c != null)
      {
        Downloader localDownloader = this.c;
        return localDownloader;
      }
    }
    finally {}
    c localc = new c(Global.getContext(), "common");
    localc.setUrlKeyGenerator(com.tencent.component.network.downloader.a.a);
    localc.enableResumeTransfer();
    this.c = localc;
    return localc;
  }
  
  public IPStrategy getDirectIpStrategy()
  {
    return this.pDirectIPConfig;
  }
  
  public Downloader getImageDownloader()
  {
    if (this.d != null) {
      return this.d;
    }
    try
    {
      if (this.d != null)
      {
        Downloader localDownloader = this.d;
        return localDownloader;
      }
    }
    finally {}
    c localc = new c(Global.getContext(), "image");
    localc.setUrlKeyGenerator(com.tencent.component.network.downloader.a.a);
    localc.setFileHandler(this.f);
    localc.enableResumeTransfer();
    localc.setContentHandler(new DownloaderFactory.2());
    this.d = localc;
    return localc;
  }
  
  public PortConfigStrategy getPortStrategy()
  {
    return this.e;
  }
  
  public void setBackupIPConfigStrategy(IPStrategy paramIPStrategy)
  {
    this.pBackupIPConfig = paramIPStrategy;
  }
  
  public void setDirectIPConfigStrategy(IPStrategy paramIPStrategy)
  {
    this.pDirectIPConfig = paramIPStrategy;
  }
  
  public void setPortStrategy(PortConfigStrategy paramPortConfigStrategy)
  {
    this.e = paramPortConfigStrategy;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\DownloaderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */