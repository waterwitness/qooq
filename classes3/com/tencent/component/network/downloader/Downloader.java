package com.tencent.component.network.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer;
import com.tencent.component.network.downloader.strategy.DownloadPreprocessStrategy;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.apache.http.HttpHost;

public abstract class Downloader
{
  protected Context mContext = null;
  protected IPStrategy pBackupIPConfig;
  protected com.tencent.component.network.downloader.handler.a pContentHandler;
  protected IPStrategy pDirectIPConfig;
  protected DownloadMode pDownloadMode = DownloadMode.FastMode;
  protected ReportHandler pExternalReportHandler;
  protected PriorityThreadPool pExternalThreadPool;
  protected com.tencent.component.network.downloader.handler.b pFileHandler;
  protected KeepAliveStrategy pKeepAliveStrategy;
  protected int pMaxConnection = 0;
  protected int pMaxConnectionPerRoute = 0;
  protected HttpHost pMobileProxy;
  protected String pName;
  protected NetworkFlowStatistics pNetworkFlowStatistics;
  protected PortConfigStrategy pPortConfigStrategy;
  protected DownloadPreprocessStrategy pProcessStrategy;
  protected ReportHandler pReportHandler;
  protected ResumeTransfer pResumeTransfer;
  protected com.tencent.component.network.module.cache.a.b pTmpFileCache;
  protected a pUrlKeyGenerator;
  
  public Downloader(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.pName = paramString;
    this.pTmpFileCache = com.tencent.component.network.module.cache.a.a(this.mContext);
  }
  
  public abstract void abort(String paramString, DownloadListener paramDownloadListener);
  
  public abstract void cancel(String paramString, DownloadListener paramDownloadListener);
  
  public abstract void cancelAll();
  
  public abstract void cleanCache();
  
  public abstract void cleanCache(String paramString);
  
  public abstract boolean download(DownloadRequest paramDownloadRequest, boolean paramBoolean);
  
  public final boolean download(String paramString1, String paramString2, DownloadListener paramDownloadListener)
  {
    return download(paramString1, paramString2, true, paramDownloadListener);
  }
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean, DownloadListener paramDownloadListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    return download(paramString1, paramString2, paramBoolean, paramDownloadListener, this.pDownloadMode);
  }
  
  public final boolean download(String paramString1, String paramString2, boolean paramBoolean, DownloadListener paramDownloadListener, DownloadMode paramDownloadMode)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    return download(paramString1, new String[] { paramString2 }, paramBoolean, paramDownloadListener, paramDownloadMode);
  }
  
  public final boolean download(String paramString, String[] paramArrayOfString, boolean paramBoolean, DownloadListener paramDownloadListener)
  {
    return download(paramString, paramArrayOfString, false, paramBoolean, paramDownloadListener, this.pDownloadMode);
  }
  
  public final boolean download(String paramString, String[] paramArrayOfString, boolean paramBoolean, DownloadListener paramDownloadListener, DownloadMode paramDownloadMode)
  {
    return download(paramString, paramArrayOfString, false, paramBoolean, paramDownloadListener, paramDownloadMode);
  }
  
  public final boolean download(String paramString, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, DownloadListener paramDownloadListener, DownloadMode paramDownloadMode)
  {
    if ((!com.tencent.component.network.downloader.common.a.a(paramString)) || (paramArrayOfString == null)) {
      return false;
    }
    paramString = new DownloadRequest(paramString, paramArrayOfString, paramBoolean1, paramDownloadListener);
    paramString.mode = paramDownloadMode;
    return download(paramString, paramBoolean2);
  }
  
  public void enableResumeTransfer()
  {
    enableResumeTransfer(false);
  }
  
  public void enableResumeTransfer(boolean paramBoolean)
  {
    enableResumeTransfer(paramBoolean, null, false);
  }
  
  public void enableResumeTransfer(boolean paramBoolean1, String[] paramArrayOfString, boolean paramBoolean2)
  {
    QzoneResumeTransfer localQzoneResumeTransfer = new QzoneResumeTransfer(this.mContext, "tmp_" + com.tencent.component.network.downloader.common.a.a(this.mContext) + "_" + this.pName, this.pTmpFileCache, true);
    localQzoneResumeTransfer.mForceEnable = paramBoolean1;
    localQzoneResumeTransfer.setUrlKeyGenerator(this.pUrlKeyGenerator);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      localQzoneResumeTransfer.setSupportDomains(paramArrayOfString, paramBoolean2);
    }
    this.pResumeTransfer = localQzoneResumeTransfer;
  }
  
  protected String generateStorageName(String paramString)
  {
    paramString = generateUrlKey(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return UUID.randomUUID().toString();
    }
    return String.valueOf(paramString.hashCode());
  }
  
  public String generateUrlKey(String paramString)
  {
    Object localObject = this.pUrlKeyGenerator;
    if (localObject == null) {}
    for (localObject = paramString; TextUtils.isEmpty((CharSequence)localObject); localObject = ((a)localObject).a(paramString)) {
      return paramString;
    }
    return (String)localObject;
  }
  
  public KeepAliveStrategy getKeepAliveStrategy()
  {
    return this.pKeepAliveStrategy;
  }
  
  public HttpHost getMobileProxy()
  {
    return this.pMobileProxy;
  }
  
  public DownloadPreprocessStrategy getPreprocessStrategy()
  {
    return this.pProcessStrategy;
  }
  
  public void setBackupIPConfigStrategy(IPStrategy paramIPStrategy)
  {
    this.pBackupIPConfig = paramIPStrategy;
    DownloaderFactory.getInstance(this.mContext).setBackupIPConfigStrategy(paramIPStrategy);
  }
  
  public void setContentHandler(com.tencent.component.network.downloader.handler.a parama)
  {
    this.pContentHandler = parama;
  }
  
  public void setDirectIPConfigStrategy(IPStrategy paramIPStrategy)
  {
    this.pDirectIPConfig = paramIPStrategy;
    DownloaderFactory.getInstance(this.mContext).setDirectIPConfigStrategy(paramIPStrategy);
  }
  
  public void setDownloadMode(DownloadMode paramDownloadMode)
  {
    this.pDownloadMode = paramDownloadMode;
  }
  
  public void setExecutor(Executor paramExecutor)
  {
    if (paramExecutor == null)
    {
      this.pExternalThreadPool = null;
      return;
    }
    this.pExternalThreadPool = new PriorityThreadPool(paramExecutor);
  }
  
  public void setExternalReportHandler(ReportHandler paramReportHandler)
  {
    this.pExternalReportHandler = paramReportHandler;
  }
  
  public void setFileHandler(com.tencent.component.network.downloader.handler.b paramb)
  {
    this.pFileHandler = paramb;
  }
  
  public void setHttpConnectionParam(int paramInt1, int paramInt2)
  {
    this.pMaxConnectionPerRoute = paramInt1;
    this.pMaxConnection = paramInt2;
  }
  
  public void setKeepAliveStrategy(KeepAliveStrategy paramKeepAliveStrategy)
  {
    this.pKeepAliveStrategy = paramKeepAliveStrategy;
  }
  
  public void setMobileProxy(HttpHost paramHttpHost)
  {
    this.pMobileProxy = paramHttpHost;
  }
  
  public void setNetworkFlowStatistics(NetworkFlowStatistics paramNetworkFlowStatistics)
  {
    this.pNetworkFlowStatistics = paramNetworkFlowStatistics;
  }
  
  public void setPortConfigStrategy(PortConfigStrategy paramPortConfigStrategy)
  {
    this.pPortConfigStrategy = paramPortConfigStrategy;
    DownloaderFactory.getInstance(this.mContext).setPortStrategy(this.pPortConfigStrategy);
  }
  
  public void setPreprocessStrategy(DownloadPreprocessStrategy paramDownloadPreprocessStrategy)
  {
    this.pProcessStrategy = paramDownloadPreprocessStrategy;
  }
  
  public void setReportHandler(ReportHandler paramReportHandler)
  {
    this.pReportHandler = paramReportHandler;
  }
  
  public void setUrlKeyGenerator(a parama)
  {
    this.pUrlKeyGenerator = parama;
    if (this.pResumeTransfer != null) {
      this.pResumeTransfer.setUrlKeyGenerator(this.pUrlKeyGenerator);
    }
  }
  
  public static abstract interface DownloadListener
  {
    public abstract void onDownloadCanceled(String paramString);
    
    public abstract void onDownloadFailed(String paramString, DownloadResult paramDownloadResult);
    
    public abstract void onDownloadProgress(String paramString, long paramLong, float paramFloat);
    
    public abstract void onDownloadSucceed(String paramString, DownloadResult paramDownloadResult);
  }
  
  public static enum DownloadMode {}
  
  public static abstract interface NetworkFlowStatistics
  {
    public abstract void onDownloadFlow(String paramString, long paramLong1, long paramLong2);
    
    public abstract void onUploadFlow(String paramString, long paramLong1, long paramLong2);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\Downloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */