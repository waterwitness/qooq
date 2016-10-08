package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.NetworkManager.NetStatusListener;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.Downloader.NetworkFlowStatistics;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.BytesBufferPool;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.a.e.b;
import com.tencent.component.network.utils.a.g;
import com.tencent.component.network.utils.thread.PriorityThreadPool.Priority;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public abstract class a
  implements NetworkManager.NetStatusListener, ThreadPool.Job<DownloadResult>
{
  private static volatile long A = System.currentTimeMillis();
  private static volatile int G = 0;
  protected static final ThreadLocal<e.b> i;
  private static final BytesBufferPool q = new BytesBufferPool(4, 8192);
  private static ConcurrentHashMap<String, Integer> y = new ConcurrentHashMap();
  private static final Object z;
  private ReportHandler B;
  private ReportHandler C;
  private com.tencent.component.network.module.cache.a.b D;
  private Downloader.NetworkFlowStatistics E;
  private Map<String, String> F;
  protected final Context a;
  protected int b = 1;
  protected int c = 0;
  protected long d;
  protected DownloadGlobalStrategy.StrategyLib e = null;
  protected DownloadGlobalStrategy.StrategyInfo f = null;
  protected DownloadGlobalStrategy.StrategyInfo g = null;
  protected HttpGet h = null;
  protected HttpClient j;
  protected a k;
  protected ResumeTransfer l;
  protected IPStrategy m;
  protected IPStrategy n;
  protected PortConfigStrategy o;
  protected long p = 0L;
  private final String r;
  private final String s;
  private PriorityThreadPool.Priority t;
  private String u;
  private long v = -1L;
  private boolean w = true;
  private List<ReportHandler.DownloadReportObject> x = new ArrayList();
  
  static
  {
    i = new b();
    z = new Object();
  }
  
  public a(Context paramContext, HttpClient paramHttpClient, String paramString1, String paramString2, boolean paramBoolean)
  {
    AssertUtil.assertTrue(com.tencent.component.network.downloader.common.a.a(paramString1));
    this.a = paramContext;
    this.r = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.s = paramString2;
      this.j = paramHttpClient;
      if (!paramBoolean) {
        break label119;
      }
    }
    label119:
    for (paramContext = PriorityThreadPool.Priority.HIGH;; paramContext = PriorityThreadPool.Priority.NORMAL)
    {
      this.t = paramContext;
      return;
      paramString2 = paramString1;
      break;
    }
  }
  
  private DownloadResult a(ThreadPool.JobContext paramJobContext)
  {
    Object localObject = null;
    DownloadResult localDownloadResult = new DownloadResult(this.r);
    if (paramJobContext.isCancelled())
    {
      a(paramJobContext, localDownloadResult, null);
      return localDownloadResult;
    }
    if (this.k != null) {
      localObject = this.k.a(this.r);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (com.tencent.component.network.downloader.common.a.b()) {
        com.tencent.component.network.downloader.common.a.b("downloader", "find cache entry:" + (String)localObject + " url:" + this.r);
      }
      localDownloadResult.setPath((String)localObject);
      localDownloadResult.getStatus().setSucceed();
      return localDownloadResult;
    }
    paramJobContext.setMode(2);
    try
    {
      a();
      NetworkManager.registNetStatusListener(this);
      a(paramJobContext, localDownloadResult);
      if (!NetworkUtils.isNetworkAvailable(this.a))
      {
        this.w = false;
        localDownloadResult.getStatus().setFailed(6);
      }
      if (!localDownloadResult.getStatus().isFailed()) {
        break label418;
      }
      if (localDownloadResult.getStatus().getFailException() == null) {
        break label306;
      }
      localObject = Log.getStackTraceString(localDownloadResult.getStatus().getFailException());
      if ((localObject == null) || (!((String)localObject).contains("refused"))) {
        break label418;
      }
      G -= 1;
      if (!localDownloadResult.getStatus().isSucceed()) {
        break label563;
      }
      this.g.result = localDownloadResult;
      DownloadGlobalStrategy.getInstance(this.a).report(this.a, this.r, this.u, this.g, localDownloadResult.getStatus().isSucceed());
      label263:
      if (localDownloadResult.getStatus().isSucceed()) {
        com.tencent.component.network.module.a.b.a().a(localDownloadResult.getContent().size, localDownloadResult.getProcess().startTime, localDownloadResult.getProcess().endTime);
      }
    }
    catch (Throwable paramJobContext)
    {
      for (;;)
      {
        String str;
        com.tencent.component.network.downloader.common.a.b("downloader", "exception when execute DownloadTask. ", paramJobContext);
        NetworkManager.unregistNetStatusListener(this);
        continue;
        i1 = 0;
        break label630;
        if (404 == localDownloadResult.getStatus().httpStatus)
        {
          localObject = (Integer)y.get(this.r);
          if (localObject != null) {
            break;
          }
          y.put(this.r, Integer.valueOf(1));
          com.tencent.component.network.downloader.common.a.b("downloader", "save 404 url at first time.");
        }
      }
    }
    finally
    {
      NetworkManager.unregistNetStatusListener(this);
    }
    return localDownloadResult;
    label306:
    int i1;
    if ((localDownloadResult.getStatus().getFailException() != null) && ((localDownloadResult.getStatus().getFailException() instanceof SocketException)))
    {
      localObject = Log.getStackTraceString(localDownloadResult.getStatus().getFailException());
      if ((localObject != null) && (((String)localObject).contains("Permission denied")))
      {
        localObject = Build.BRAND;
        str = Build.MODEL;
        com.tencent.component.network.downloader.common.a.b("downloader", "brand:" + (String)localObject + " model:" + str);
        if ((str == null) || (!str.startsWith("MI"))) {
          break label443;
        }
        i1 = 1;
        break label630;
      }
    }
    for (;;)
    {
      label418:
      b(paramJobContext);
      break;
      label443:
      y.put(this.r, Integer.valueOf(((Integer)localObject).intValue() + 1));
      com.tencent.component.network.downloader.common.a.b("downloader", "save 404 url " + (((Integer)localObject).intValue() + 1));
      break;
      label563:
      if ((this.e == null) || (this.e.getBestStrategy() == null)) {
        break label263;
      }
      this.e.getBestStrategy().result = localDownloadResult;
      DownloadGlobalStrategy.getInstance(this.a).report(this.a, this.r, this.u, this.e.getBestStrategy(), localDownloadResult.getStatus().isSucceed());
      break label263;
      label630:
      if (i1 != 0) {
        break;
      }
    }
  }
  
  private void a(String paramString, long paramLong, float paramFloat)
  {
    if (this.k == null) {
      return;
    }
    this.k.a(paramString, paramLong, paramFloat);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new File(paramString);
        if (b.a(paramString, true))
        {
          this.D.c(paramString.getName());
          if (paramLong <= 0L) {
            return true;
          }
          while (!paramString.exists()) {
            paramString = paramString.getParentFile();
          }
          paramString = new StatFs(paramString.getAbsolutePath());
          long l1 = paramString.getAvailableBlocks();
          int i1 = paramString.getBlockSize();
          if (i1 * l1 > paramLong) {
            return true;
          }
        }
      }
      catch (IOException paramString) {}
    }
    return false;
  }
  
  private boolean a(HttpResponse paramHttpResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext)
  {
    Object localObject = paramHttpResponse.getEntity();
    this.d = ((HttpEntity)localObject).getContentLength();
    paramDownloadResult.getContent().length = this.d;
    Header localHeader = ((HttpEntity)localObject).getContentType();
    if (localHeader != null) {
      paramDownloadResult.getContent().type = localHeader.getValue();
    }
    localObject = ((HttpEntity)localObject).getContentEncoding();
    if (localObject != null) {
      paramDownloadResult.getContent().encoding = ((Header)localObject).getValue();
    }
    localObject = paramHttpResponse.getAllHeaders();
    int i2;
    int i1;
    if (localObject != null)
    {
      i2 = localObject.length;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= i2)
      {
        label114:
        localObject = paramHttpResponse.getFirstHeader("Size");
        if (localObject == null) {
          break label245;
        }
      }
      try
      {
        this.v = Integer.parseInt(((Header)localObject).getValue());
        paramDownloadResult.getContent().realsize = this.v;
        localObject = paramHttpResponse.getFirstHeader("Last-Modified");
        if (localObject != null) {}
        try
        {
          paramDownloadResult.getContent().lastModified = ((Header)localObject).getValue();
          if (paramJobContext.isCancelled())
          {
            return false;
            if ("Client-Ip".equalsIgnoreCase(localObject[i1].getName()))
            {
              paramDownloadResult.getContent().clientip = localObject[i1].getValue();
              break label114;
            }
            i1 += 1;
            continue;
            label245:
            this.v = -1L;
            paramDownloadResult.getContent().realsize = -1L;
          }
        }
        catch (Exception localException)
        {
          HeaderIterator localHeaderIterator;
          label301:
          do
          {
            for (;;)
            {
              localException.printStackTrace();
            }
            localHeaderIterator = paramHttpResponse.headerIterator("Cache-Control");
            if ((localHeaderIterator != null) && (localHeaderIterator.hasNext())) {
              break;
            }
          } while (paramJobContext.isCancelled());
          if (this.k == null) {}
          for (boolean bool = true;; bool = this.k.a(paramDownloadResult, paramHttpResponse))
          {
            if (bool) {
              break label392;
            }
            paramDownloadResult.getStatus().setFailed(5);
            return false;
            localHeader = localHeaderIterator.nextHeader();
            if ((localHeader == null) || (!"no-cache".equalsIgnoreCase(localHeader.getValue()))) {
              break;
            }
            paramDownloadResult.getContent().noCache = true;
            break label301;
          }
          label392:
          if ((this.l != null) && (!this.l.handleResponse(this.r, this.u, paramHttpResponse)))
          {
            com.tencent.component.network.downloader.common.a.c("downloader", "download 断线续传 response not valid.");
            this.l.onDownloadResult(this.r, true);
            return false;
          }
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
  }
  
  public static int b()
  {
    return G;
  }
  
  private void b(ThreadPool.JobContext paramJobContext)
  {
    if (this.B == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext())
      {
        ReportHandler.DownloadReportObject localDownloadReportObject = (ReportHandler.DownloadReportObject)localIterator.next();
        if ((localDownloadReportObject != null) && (((this.w) && (!paramJobContext.isCancelled())) || ((localDownloadReportObject.retCode == 0) && (this.B != null)))) {
          this.B.uploadReport(localDownloadReportObject);
        }
      }
    }
  }
  
  public static void c()
  {
    G += 1;
  }
  
  protected void a()
  {
    if (this.u == null) {
      this.u = com.tencent.component.network.downloader.common.a.b(this.r);
    }
  }
  
  public final void a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt <= 0) {
      i1 = 1;
    }
    this.b = i1;
  }
  
  public final void a(a parama, IPStrategy paramIPStrategy1, IPStrategy paramIPStrategy2, PortConfigStrategy paramPortConfigStrategy, ResumeTransfer paramResumeTransfer, ReportHandler paramReportHandler1, ReportHandler paramReportHandler2, Downloader.NetworkFlowStatistics paramNetworkFlowStatistics, com.tencent.component.network.module.cache.a.b paramb)
  {
    this.k = parama;
    this.l = paramResumeTransfer;
    this.B = paramReportHandler1;
    this.C = paramReportHandler2;
    this.D = paramb;
    this.E = paramNetworkFlowStatistics;
    this.m = paramIPStrategy1;
    this.n = paramIPStrategy2;
    this.o = paramPortConfigStrategy;
  }
  
  public abstract void a(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult);
  
  protected final void a(ThreadPool.JobContext paramJobContext, DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    if (this.C != null)
    {
      if (paramJobContext.isCancelled()) {
        paramDownloadResult.getStatus().state = 4;
      }
      this.C.handleReport(paramDownloadResult, paramDownloadReport);
    }
    if (paramJobContext.isCancelled()) {}
    while (this.B == null) {
      return;
    }
    paramJobContext = this.B.obtainReportObj(paramDownloadResult, paramDownloadReport);
    this.x.add(paramJobContext);
  }
  
  public final void a(String paramString)
  {
    this.F.remove(paramString);
  }
  
  protected final void a(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    if (this.k == null) {
      return;
    }
    Iterator localIterator;
    if ((this.F != null) && (paramHttpRequest != null)) {
      localIterator = this.F.entrySet().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.k.a(paramString1, paramString2, paramHttpRequest);
        return;
      }
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        paramHttpRequest.addHeader(str, (String)localObject);
      }
    }
  }
  
  public final void a(Map<String, String> paramMap)
  {
    this.F = paramMap;
  }
  
  /* Error */
  protected final boolean a(HttpResponse paramHttpResponse, DownloadResult paramDownloadResult, ThreadPool.JobContext paramJobContext, int paramInt)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: invokespecial 624	com/tencent/component/network/downloader/impl/a:a	(Lorg/apache/http/HttpResponse;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;)Z
    //   7: ifne +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   15: lstore 17
    //   17: iload 4
    //   19: sipush 206
    //   22: if_icmpne +153 -> 175
    //   25: aload_0
    //   26: getfield 521	com/tencent/component/network/downloader/impl/a:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   29: ifnull +136 -> 165
    //   32: aload_0
    //   33: getfield 521	com/tencent/component/network/downloader/impl/a:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   36: aload_0
    //   37: getfield 149	com/tencent/component/network/downloader/impl/a:r	Ljava/lang/String;
    //   40: invokeinterface 627 2 0
    //   45: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifne +117 -> 165
    //   51: aload_2
    //   52: aload_0
    //   53: getfield 521	com/tencent/component/network/downloader/impl/a:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   56: aload_0
    //   57: getfield 149	com/tencent/component/network/downloader/impl/a:r	Ljava/lang/String;
    //   60: invokeinterface 627 2 0
    //   65: invokevirtual 216	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   68: iconst_1
    //   69: istore 23
    //   71: aconst_null
    //   72: astore 5
    //   74: getstatic 83	com/tencent/component/network/downloader/impl/a:q	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   77: invokevirtual 630	com/tencent/component/network/utils/BytesBufferPool:get	()Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;
    //   80: astore 6
    //   82: lconst_0
    //   83: lstore 13
    //   85: aload_0
    //   86: getfield 442	com/tencent/component/network/downloader/impl/a:d	J
    //   89: lstore 19
    //   91: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   94: lstore 15
    //   96: new 394	java/io/File
    //   99: dup
    //   100: aload_2
    //   101: invokevirtual 633	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   104: invokespecial 395	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: astore 7
    //   109: aload 7
    //   111: iconst_0
    //   112: invokestatic 398	com/tencent/component/network/downloader/impl/a$b:a	(Ljava/io/File;Z)Z
    //   115: pop
    //   116: aload_3
    //   117: invokeinterface 183 1 0
    //   122: istore 24
    //   124: iload 24
    //   126: ifeq +260 -> 386
    //   129: getstatic 83	com/tencent/component/network/downloader/impl/a:q	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   132: aload 6
    //   134: invokevirtual 637	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   137: aload_0
    //   138: getfield 568	com/tencent/component/network/downloader/impl/a:E	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   141: ifnull +22 -> 163
    //   144: aload_0
    //   145: getfield 568	com/tencent/component/network/downloader/impl/a:E	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   148: invokestatic 640	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   151: lconst_0
    //   152: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   155: lload 15
    //   157: lsub
    //   158: invokeinterface 646 6 0
    //   163: iconst_0
    //   164: ireturn
    //   165: ldc -61
    //   167: ldc_w 648
    //   170: invokestatic 531	com/tencent/component/network/downloader/common/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: iconst_0
    //   174: ireturn
    //   175: aload_0
    //   176: getfield 521	com/tencent/component/network/downloader/impl/a:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   179: ifnull +44 -> 223
    //   182: aload_0
    //   183: getfield 521	com/tencent/component/network/downloader/impl/a:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   186: aload_0
    //   187: getfield 149	com/tencent/component/network/downloader/impl/a:r	Ljava/lang/String;
    //   190: invokeinterface 627 2 0
    //   195: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifne +25 -> 223
    //   201: iload 4
    //   203: sipush 200
    //   206: if_icmpne +17 -> 223
    //   209: aload_0
    //   210: getfield 521	com/tencent/component/network/downloader/impl/a:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   213: aload_0
    //   214: getfield 149	com/tencent/component/network/downloader/impl/a:r	Ljava/lang/String;
    //   217: iconst_1
    //   218: invokeinterface 535 3 0
    //   223: aload_0
    //   224: getfield 188	com/tencent/component/network/downloader/impl/a:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   227: ifnull +96 -> 323
    //   230: aload_0
    //   231: getfield 188	com/tencent/component/network/downloader/impl/a:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   234: aload_0
    //   235: getfield 149	com/tencent/component/network/downloader/impl/a:r	Ljava/lang/String;
    //   238: invokeinterface 649 2 0
    //   243: astore 6
    //   245: aload 6
    //   247: astore 5
    //   249: aload 6
    //   251: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   254: ifeq +21 -> 275
    //   257: aload_0
    //   258: getfield 149	com/tencent/component/network/downloader/impl/a:r	Ljava/lang/String;
    //   261: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   264: ifeq +65 -> 329
    //   267: invokestatic 655	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   270: invokevirtual 656	java/util/UUID:toString	()Ljava/lang/String;
    //   273: astore 5
    //   275: aload_0
    //   276: getfield 400	com/tencent/component/network/downloader/impl/a:D	Lcom/tencent/component/network/module/cache/a/b;
    //   279: aload 5
    //   281: invokevirtual 657	com/tencent/component/network/module/cache/a/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   284: astore 6
    //   286: aload_0
    //   287: getfield 400	com/tencent/component/network/downloader/impl/a:D	Lcom/tencent/component/network/module/cache/a/b;
    //   290: aload 5
    //   292: iconst_0
    //   293: invokevirtual 660	com/tencent/component/network/module/cache/a/b:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   296: astore 5
    //   298: aload_0
    //   299: aload 6
    //   301: aload_0
    //   302: getfield 442	com/tencent/component/network/downloader/impl/a:d	J
    //   305: invokespecial 662	com/tencent/component/network/downloader/impl/a:a	(Ljava/lang/String;J)Z
    //   308: ifeq +36 -> 344
    //   311: aload_2
    //   312: aload 6
    //   314: invokevirtual 216	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   317: iconst_0
    //   318: istore 23
    //   320: goto -249 -> 71
    //   323: aconst_null
    //   324: astore 6
    //   326: goto -81 -> 245
    //   329: aload_0
    //   330: getfield 149	com/tencent/component/network/downloader/impl/a:r	Ljava/lang/String;
    //   333: invokevirtual 665	java/lang/String:hashCode	()I
    //   336: invokestatic 668	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   339: astore 5
    //   341: goto -66 -> 275
    //   344: aload 6
    //   346: aload 5
    //   348: invokestatic 672	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   351: ifne +25 -> 376
    //   354: aload_0
    //   355: aload 5
    //   357: aload_0
    //   358: getfield 442	com/tencent/component/network/downloader/impl/a:d	J
    //   361: invokespecial 662	com/tencent/component/network/downloader/impl/a:a	(Ljava/lang/String;J)Z
    //   364: ifeq +12 -> 376
    //   367: aload_2
    //   368: aload 5
    //   370: invokevirtual 216	com/tencent/component/network/downloader/DownloadResult:setPath	(Ljava/lang/String;)V
    //   373: goto -56 -> 317
    //   376: aload_2
    //   377: invokevirtual 220	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   380: iconst_2
    //   381: invokevirtual 250	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   384: iconst_0
    //   385: ireturn
    //   386: aload_1
    //   387: invokeinterface 435 1 0
    //   392: invokeinterface 675 1 0
    //   397: astore_1
    //   398: new 677	java/io/FileOutputStream
    //   401: dup
    //   402: aload 7
    //   404: iload 23
    //   406: invokespecial 680	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   409: astore 5
    //   411: lload 13
    //   413: lstore 9
    //   415: lload 15
    //   417: lstore 11
    //   419: aload 7
    //   421: invokevirtual 682	java/io/File:length	()J
    //   424: lstore 21
    //   426: iconst_0
    //   427: istore 4
    //   429: lload 13
    //   431: lstore 9
    //   433: lload 15
    //   435: lstore 11
    //   437: aload_1
    //   438: aload 6
    //   440: getfield 688	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   443: iload 4
    //   445: sipush 8192
    //   448: iload 4
    //   450: isub
    //   451: invokevirtual 694	java/io/InputStream:read	([BII)I
    //   454: istore 8
    //   456: iload 8
    //   458: ifgt +148 -> 606
    //   461: iload 8
    //   463: ifgt +29 -> 492
    //   466: iload 4
    //   468: ifle +24 -> 492
    //   471: lload 13
    //   473: lstore 9
    //   475: lload 15
    //   477: lstore 11
    //   479: aload 5
    //   481: aload 6
    //   483: getfield 688	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   486: iconst_0
    //   487: iload 4
    //   489: invokevirtual 700	java/io/OutputStream:write	([BII)V
    //   492: lload 13
    //   494: lstore 9
    //   496: lload 15
    //   498: lstore 11
    //   500: aload_0
    //   501: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   504: lload 17
    //   506: lsub
    //   507: putfield 134	com/tencent/component/network/downloader/impl/a:p	J
    //   510: lload 19
    //   512: lconst_0
    //   513: lcmp
    //   514: ifgt +25 -> 539
    //   517: lload 13
    //   519: lstore 9
    //   521: lload 15
    //   523: lstore 11
    //   525: aload_0
    //   526: aload_0
    //   527: getfield 157	com/tencent/component/network/downloader/impl/a:s	Ljava/lang/String;
    //   530: lload 19
    //   532: lload 21
    //   534: ladd
    //   535: fconst_1
    //   536: invokespecial 701	com/tencent/component/network/downloader/impl/a:a	(Ljava/lang/String;JF)V
    //   539: lload 13
    //   541: lstore 9
    //   543: lload 15
    //   545: lstore 11
    //   547: aload_2
    //   548: invokevirtual 300	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   551: lload 13
    //   553: putfield 305	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   556: aload_1
    //   557: ifnull +7 -> 564
    //   560: aload_1
    //   561: invokevirtual 704	java/io/InputStream:close	()V
    //   564: aload 5
    //   566: invokevirtual 705	java/io/OutputStream:close	()V
    //   569: getstatic 83	com/tencent/component/network/downloader/impl/a:q	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   572: aload 6
    //   574: invokevirtual 637	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   577: aload_0
    //   578: getfield 568	com/tencent/component/network/downloader/impl/a:E	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   581: ifnull +23 -> 604
    //   584: aload_0
    //   585: getfield 568	com/tencent/component/network/downloader/impl/a:E	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   588: invokestatic 640	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   591: lload 13
    //   593: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   596: lload 15
    //   598: lsub
    //   599: invokeinterface 646 6 0
    //   604: iconst_1
    //   605: ireturn
    //   606: iload 8
    //   608: iload 4
    //   610: iadd
    //   611: sipush 8192
    //   614: if_icmpne +112 -> 726
    //   617: lload 13
    //   619: lstore 9
    //   621: lload 15
    //   623: lstore 11
    //   625: aload 5
    //   627: aload 6
    //   629: getfield 688	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:data	[B
    //   632: iconst_0
    //   633: iload 4
    //   635: iload 8
    //   637: iadd
    //   638: invokevirtual 700	java/io/OutputStream:write	([BII)V
    //   641: iconst_0
    //   642: istore 4
    //   644: lload 13
    //   646: iload 8
    //   648: i2l
    //   649: ladd
    //   650: lstore 13
    //   652: lload 13
    //   654: lstore 9
    //   656: lload 15
    //   658: lstore 11
    //   660: aload_2
    //   661: invokevirtual 300	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   664: lload 13
    //   666: putfield 305	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   669: lload 19
    //   671: lconst_0
    //   672: lcmp
    //   673: ifle +37 -> 710
    //   676: lload 13
    //   678: lstore 9
    //   680: lload 15
    //   682: lstore 11
    //   684: aload_0
    //   685: aload_0
    //   686: getfield 157	com/tencent/component/network/downloader/impl/a:s	Ljava/lang/String;
    //   689: lload 19
    //   691: lload 21
    //   693: ladd
    //   694: lload 13
    //   696: lload 21
    //   698: ladd
    //   699: l2f
    //   700: lload 19
    //   702: lload 21
    //   704: ladd
    //   705: l2f
    //   706: fdiv
    //   707: invokespecial 701	com/tencent/component/network/downloader/impl/a:a	(Ljava/lang/String;JF)V
    //   710: lload 13
    //   712: lstore 9
    //   714: lload 15
    //   716: lstore 11
    //   718: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   721: lstore 15
    //   723: goto -294 -> 429
    //   726: iload 4
    //   728: iload 8
    //   730: iadd
    //   731: istore 4
    //   733: goto -89 -> 644
    //   736: astore_3
    //   737: aconst_null
    //   738: astore_1
    //   739: lload 15
    //   741: lstore 11
    //   743: lload 13
    //   745: lstore 9
    //   747: aload 5
    //   749: astore_2
    //   750: aload_2
    //   751: ifnull +7 -> 758
    //   754: aload_2
    //   755: invokevirtual 704	java/io/InputStream:close	()V
    //   758: aload_1
    //   759: ifnull +7 -> 766
    //   762: aload_1
    //   763: invokevirtual 705	java/io/OutputStream:close	()V
    //   766: getstatic 83	com/tencent/component/network/downloader/impl/a:q	Lcom/tencent/component/network/utils/BytesBufferPool;
    //   769: aload 6
    //   771: invokevirtual 637	com/tencent/component/network/utils/BytesBufferPool:recycle	(Lcom/tencent/component/network/utils/BytesBufferPool$BytesBuffer;)V
    //   774: aload_0
    //   775: getfield 568	com/tencent/component/network/downloader/impl/a:E	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   778: ifnull +23 -> 801
    //   781: aload_0
    //   782: getfield 568	com/tencent/component/network/downloader/impl/a:E	Lcom/tencent/component/network/downloader/Downloader$NetworkFlowStatistics;
    //   785: invokestatic 640	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   788: lload 9
    //   790: invokestatic 103	java/lang/System:currentTimeMillis	()J
    //   793: lload 11
    //   795: lsub
    //   796: invokeinterface 646 6 0
    //   801: aload_3
    //   802: athrow
    //   803: astore_3
    //   804: aload_1
    //   805: astore_2
    //   806: aconst_null
    //   807: astore_1
    //   808: lload 13
    //   810: lstore 9
    //   812: lload 15
    //   814: lstore 11
    //   816: goto -66 -> 750
    //   819: astore_3
    //   820: aload 5
    //   822: astore_2
    //   823: aload_1
    //   824: astore 5
    //   826: aload_2
    //   827: astore_1
    //   828: aload 5
    //   830: astore_2
    //   831: goto -81 -> 750
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	834	0	this	a
    //   0	834	1	paramHttpResponse	HttpResponse
    //   0	834	2	paramDownloadResult	DownloadResult
    //   0	834	3	paramJobContext	ThreadPool.JobContext
    //   0	834	4	paramInt	int
    //   72	757	5	localObject1	Object
    //   80	690	6	localObject2	Object
    //   107	313	7	localFile	File
    //   454	277	8	i1	int
    //   413	398	9	l1	long
    //   417	398	11	l2	long
    //   83	726	13	l3	long
    //   94	719	15	l4	long
    //   15	490	17	l5	long
    //   89	612	19	l6	long
    //   424	279	21	l7	long
    //   69	336	23	bool1	boolean
    //   122	3	24	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   96	124	736	finally
    //   386	398	736	finally
    //   398	411	803	finally
    //   419	426	819	finally
    //   437	456	819	finally
    //   479	492	819	finally
    //   500	510	819	finally
    //   525	539	819	finally
    //   547	556	819	finally
    //   625	641	819	finally
    //   660	669	819	finally
    //   684	710	819	finally
    //   718	723	819	finally
  }
  
  protected final String b(String paramString)
  {
    if (this.k == null) {}
    String str;
    do
    {
      return paramString;
      str = this.k.c(paramString);
    } while (TextUtils.isEmpty(str));
    return str;
  }
  
  protected final void b(String paramString1, String paramString2, HttpRequest paramHttpRequest)
  {
    if (this.k == null) {
      return;
    }
    this.k.b(paramString1, paramString2, paramHttpRequest);
  }
  
  protected final boolean d()
  {
    int i1 = this.c + 1;
    this.c = i1;
    return i1 < this.b;
  }
  
  protected final int e()
  {
    return this.c;
  }
  
  protected final int f()
  {
    return this.b;
  }
  
  protected final long g()
  {
    return this.d;
  }
  
  public final void h()
  {
    if (com.tencent.component.network.downloader.common.a.b()) {
      com.tencent.component.network.downloader.common.a.b("downloader", "downloader abort:" + this.r);
    }
    this.w = false;
    if (this.h != null) {}
    try
    {
      this.h.abort();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.component.network.downloader.common.a.a("downloader", "downloader abort Exception", localException);
    }
  }
  
  public final PriorityThreadPool.Priority i()
  {
    return this.t;
  }
  
  public final String j()
  {
    return this.r;
  }
  
  public final String k()
  {
    if (this.u == null) {
      this.u = com.tencent.component.network.downloader.common.a.b(this.r);
    }
    return this.u;
  }
  
  public final String l()
  {
    return this.s;
  }
  
  protected final void m()
  {
    if (this.j == null) {}
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis() - A;
    } while ((l1 >= 0L) && (l1 < 30000L));
    synchronized (z)
    {
      l1 = System.currentTimeMillis() - A;
      if ((l1 >= 0L) && (l1 < 30000L)) {
        return;
      }
    }
    Object localObject3 = this.j.getConnectionManager();
    if ((localObject3 != null) && ((localObject3 instanceof g)))
    {
      localObject3 = (g)localObject3;
      if (localObject3 == null) {}
    }
    try
    {
      ((g)localObject3).closeExpiredConnections();
      A = System.currentTimeMillis();
      if (com.tencent.component.network.downloader.common.a.a()) {
        com.tencent.component.network.downloader.common.a.a("downloader", "download cleanExpireConnection.");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException = localException;
        A = System.currentTimeMillis();
        if (com.tencent.component.network.downloader.common.a.a()) {
          com.tencent.component.network.downloader.common.a.a("downloader", "download cleanExpireConnection.");
        }
      }
    }
    finally
    {
      localObject4 = finally;
      A = System.currentTimeMillis();
      if (!com.tencent.component.network.downloader.common.a.a()) {
        break label168;
      }
      com.tencent.component.network.downloader.common.a.a("downloader", "download cleanExpireConnection.");
      throw ((Throwable)localObject4);
    }
  }
  
  protected final int n()
  {
    if (this.k != null) {
      return this.k.a();
    }
    return 1;
  }
  
  public void onNetworkChanged(String paramString1, String paramString2)
  {
    this.w = false;
  }
  
  public static abstract interface a
  {
    public abstract int a();
    
    public abstract String a(String paramString);
    
    public abstract void a(String paramString, long paramLong, float paramFloat);
    
    public abstract void a(String paramString1, String paramString2, HttpRequest paramHttpRequest);
    
    public abstract boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse);
    
    public abstract String b(String paramString);
    
    public abstract HttpHost b();
    
    public abstract void b(String paramString1, String paramString2, HttpRequest paramHttpRequest);
    
    public abstract String c(String paramString);
  }
  
  static final class b
  {
    private static final Random a = new Random();
    
    public static int a(Object... paramVarArgs)
    {
      int i = 17;
      int j = i;
      int m;
      if (paramVarArgs != null)
      {
        m = paramVarArgs.length;
        j = 0;
      }
      for (;;)
      {
        if (j >= m)
        {
          j = i;
          return j * 31 + a.nextInt();
        }
        Object localObject = paramVarArgs[j];
        int k = i;
        if (localObject != null) {
          k = i * 31 + localObject.hashCode();
        }
        j += 1;
        i = k;
      }
    }
    
    public static String a()
    {
      return null;
    }
    
    public static boolean a(File paramFile, boolean paramBoolean)
      throws IOException
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramFile == null) {
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        try
        {
          File localFile = paramFile.getParentFile();
          if ((localFile.exists()) && (localFile.isFile())) {
            FileUtils.delete(localFile);
          }
          if (!localFile.exists())
          {
            bool1 = bool2;
            if (!localFile.mkdirs()) {
              continue;
            }
          }
          if ((paramBoolean) && (paramFile.exists())) {
            FileUtils.delete(paramFile);
          }
          if (!paramFile.exists())
          {
            paramBoolean = paramFile.createNewFile();
            bool1 = bool2;
            if (!paramBoolean) {
              continue;
            }
          }
          bool1 = true;
        }
        finally {}
      }
    }
    
    public static String b()
    {
      return null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\impl\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */