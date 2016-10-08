package com.tencent.component.network.downloader.impl;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyInfo;
import com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy.StrategyLib;
import com.tencent.component.network.downloader.strategy.IPStrategy;
import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.component.network.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public final class h
  extends a
{
  private static List<DownloadGlobalStrategy.StrategyInfo> y;
  private static final Object z = new Object();
  private HttpResponse A = null;
  private boolean q;
  private boolean r;
  private String s;
  private String t;
  private int u = 0;
  private final long v = SystemClock.uptimeMillis();
  private int w = 4;
  private int[] x = new int[this.w];
  
  public h(Context paramContext, HttpClient paramHttpClient, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramHttpClient, paramString1, paramString2, paramBoolean);
  }
  
  private static int a(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {
      return 0;
    }
    try
    {
      long l = Long.parseLong(paramHttpResponse.getFirstHeader("X-ErrNo").getValue());
      return (int)l;
    }
    catch (Exception paramHttpResponse) {}
    return 0;
  }
  
  private static void a(HttpGet paramHttpGet, HttpResponse paramHttpResponse)
  {
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n/****************************************************/\n");
    int i;
    if (paramHttpGet != null)
    {
      localStringBuffer.append("<---------Request Content--------->\n").append(paramHttpGet.getRequestLine()).append("\n");
      paramHttpGet = paramHttpGet.getAllHeaders();
      if (paramHttpGet != null)
      {
        i = 0;
        if (i < paramHttpGet.length) {
          break label135;
        }
      }
    }
    if (paramHttpResponse != null)
    {
      localStringBuffer.append("<---------Response Headers--------->\n").append(paramHttpResponse.getStatusLine()).append("\n");
      paramHttpGet = paramHttpResponse.getAllHeaders();
      if (paramHttpGet != null) {
        i = j;
      }
    }
    for (;;)
    {
      if (i >= paramHttpGet.length)
      {
        localStringBuffer.append("/****************************************************/");
        com.tencent.component.network.downloader.common.a.c("downloader", "Http Details:" + localStringBuffer.toString());
        return;
        label135:
        localStringBuffer.append(paramHttpGet[i].getName()).append(": ").append(paramHttpGet[i].getValue()).append("\n");
        i += 1;
        break;
      }
      localStringBuffer.append(paramHttpGet[i].getName()).append(": ").append(paramHttpGet[i].getValue()).append("\n");
      i += 1;
    }
  }
  
  private static int b(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {
      return -1;
    }
    try
    {
      long l = Long.parseLong(paramHttpResponse.getFirstHeader("X-RtFlag").getValue());
      return (int)l;
    }
    catch (Exception paramHttpResponse) {}
    return -1;
  }
  
  private boolean b(int paramInt)
    throws Exception
  {
    if (this.e == null)
    {
      this.e = DownloadGlobalStrategy.getInstance(this.a).getStrategyLib(j(), k());
      if (y != null) {}
    }
    Object localObject4;
    int i;
    synchronized (z)
    {
      if (y == null)
      {
        y = new ArrayList();
        DownloadGlobalStrategy.StrategyInfo localStrategyInfo1 = new DownloadGlobalStrategy.StrategyInfo(6, false, false, false, true);
        localStrategyInfo1.id = 6;
        localObject4 = new DownloadGlobalStrategy.StrategyInfo(7, false, false, false, true);
        ((DownloadGlobalStrategy.StrategyInfo)localObject4).id = 7;
        DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = new DownloadGlobalStrategy.StrategyInfo(8, false, false, false, true);
        localStrategyInfo2.id = 8;
        DownloadGlobalStrategy.StrategyInfo localStrategyInfo3 = new DownloadGlobalStrategy.StrategyInfo(9, false, false, false, true);
        localStrategyInfo3.id = 9;
        y.add(localStrategyInfo1);
        y.add(localObject4);
        y.add(localStrategyInfo2);
        y.add(localStrategyInfo3);
      }
      this.e.copyStrageList();
      this.e.enableUpdate(false);
      this.e.addStrategy(y);
      this.f = this.g;
      this.g = this.e.getStrategyInfo(paramInt);
      if (com.tencent.component.network.downloader.common.a.b()) {
        com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: " + this.g.toString() + " currAttempCount:" + paramInt + " best:" + this.e.getBestId() + " url:" + j() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
      }
      this.q = this.g.allowProxy;
      this.r = this.g.useConfigApn;
      localObject4 = k();
      i = this.e.getPort();
      paramInt = i;
      if (!com.tencent.component.network.downloader.common.a.a(i))
      {
        this.e.setPort(80);
        paramInt = 80;
      }
      if (DownloadGlobalStrategy.Strategy_BACKUPIP.id != this.g.id) {
        break label801;
      }
      i = paramInt;
      if (this.f != null)
      {
        i = paramInt;
        if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.f.id)
        {
          if ((this.o == null) || (!this.o.supportExtraPort((String)localObject4))) {
            break label685;
          }
          i = this.o.changePort((String)localObject4, paramInt);
          if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
          {
            if (com.tencent.component.network.downloader.common.a.b()) {
              com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
            }
            return false;
          }
        }
      }
    }
    Object localObject3 = this.e.getBackupIP();
    ??? = localObject3;
    if (this.n != null)
    {
      ??? = localObject3;
      if (!this.n.isIPValid((String)localObject4, (String)localObject3))
      {
        this.e.setBackupIP(null);
        ??? = this.n.resolveIP((String)localObject4);
        if (TextUtils.isEmpty((CharSequence)???)) {
          break label720;
        }
        this.e.setBackupIP((String)???);
      }
    }
    if ((??? == null) || (((String)???).equals(this.e.getDirectIP())) || (((String)???).equals(this.e.getDnsIP())))
    {
      if (com.tencent.component.network.downloader.common.a.b()) {
        com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Backup IP 重复. threadId:" + Thread.currentThread().getId());
      }
      return false;
      label685:
      if (com.tencent.component.network.downloader.common.a.b()) {
        com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
      }
      return false;
      label720:
      if (com.tencent.component.network.downloader.common.a.b()) {
        com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
      }
      return false;
    }
    this.g = this.g.clone();
    this.g.setIPInfo(new IPInfo((String)???, i));
    paramInt = NetworkManager.getIspType();
    if ((paramInt <= 0) || (paramInt > this.w)) {}
    for (;;)
    {
      return true;
      label801:
      if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.g.id)
      {
        i = paramInt;
        if (this.f != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.f.id)
          {
            if ((this.o == null) || (!this.o.supportExtraPort((String)localObject4))) {
              break label1031;
            }
            i = this.o.changePort((String)localObject4, paramInt);
            if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
            {
              if (com.tencent.component.network.downloader.common.a.b()) {
                com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              }
              return false;
            }
          }
        }
        ??? = com.tencent.component.network.module.common.a.a().a((String)localObject4);
        if ((??? == null) || (((String)???).equals(this.e.getBackupIP())) || (((String)???).equals(this.e.getDirectIP())))
        {
          this.e.setDnsIP(null);
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          }
          return false;
          label1031:
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          }
          return false;
        }
        this.e.setDnsIP((String)???);
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)???, i));
        break;
      }
      if (6 == this.g.id)
      {
        ??? = null;
        if (this.m != null)
        {
          localObject3 = this.m.resolveIP((String)localObject4);
          ??? = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ??? = com.tencent.component.network.module.common.a.a().a((String)localObject4);
          }
        }
        if (??? == null)
        {
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: direct ip is null. Pass! 6 threadId:" + Thread.currentThread().getId());
          }
          return false;
        }
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)???, 80));
        break;
      }
      if (7 == this.g.id)
      {
        ??? = null;
        if (this.n != null)
        {
          localObject3 = this.n.resolveIP((String)localObject4);
          ??? = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ??? = com.tencent.component.network.module.common.a.a().a((String)localObject4);
          }
        }
        if (??? == null)
        {
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: backup ip is null. Pass! 7 threadId:" + Thread.currentThread().getId());
          }
          return false;
        }
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)???, 80));
        break;
      }
      if (8 == this.g.id)
      {
        ??? = null;
        do
        {
          paramInt = o();
          localObject3 = ???;
          if (paramInt == 0) {
            break;
          }
          localObject3 = ???;
          if (this.m != null) {
            localObject3 = this.m.resolveIP((String)localObject4, paramInt);
          }
          ??? = localObject3;
        } while (TextUtils.isEmpty((CharSequence)localObject3));
        ??? = localObject3;
        if (localObject3 == null) {
          ??? = com.tencent.component.network.module.common.a.a().a((String)localObject4);
        }
        if (??? == null)
        {
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy:  ip is null. Pass! 8 threadId:" + Thread.currentThread().getId());
          }
          return false;
        }
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)???, 80));
        break;
      }
      if (9 == this.g.id)
      {
        ??? = null;
        do
        {
          paramInt = o();
          localObject3 = ???;
          if (paramInt == 0) {
            break;
          }
          localObject3 = ???;
          if (this.m != null) {
            localObject3 = this.m.resolveIP((String)localObject4, paramInt);
          }
          ??? = localObject3;
        } while (TextUtils.isEmpty((CharSequence)localObject3));
        ??? = localObject3;
        if (localObject3 == null) {
          ??? = com.tencent.component.network.module.common.a.a().a((String)localObject4);
        }
        if (??? == null)
        {
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy:  ip is null. Pass! 9 threadId:" + Thread.currentThread().getId());
          }
          return false;
        }
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)???, 80));
        break;
      }
      if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.g.id)
      {
        i = paramInt;
        if (this.f != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.f.id)
          {
            if ((this.o == null) || (!this.o.supportExtraPort((String)localObject4))) {
              break label1911;
            }
            i = this.o.changePort((String)localObject4, paramInt);
            if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
            {
              if (com.tencent.component.network.downloader.common.a.b()) {
                com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              }
              return false;
            }
          }
        }
      }
      label1911:
      do
      {
        localObject3 = this.e.getDirectIP();
        ??? = localObject3;
        if (this.m != null)
        {
          ??? = localObject3;
          if (!this.m.isIPValid((String)localObject3, (String)localObject4))
          {
            this.e.setDirectIP(null);
            ??? = this.m.resolveIP((String)localObject4);
            if (TextUtils.isEmpty((CharSequence)???)) {
              break label2057;
            }
            this.e.setDirectIP((String)???);
          }
        }
        if ((??? != null) && (!((String)???).equals(this.e.getBackupIP())) && (!((String)???).equals(this.e.getDnsIP()))) {
          break label2092;
        }
        if (com.tencent.component.network.downloader.common.a.b()) {
          com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Direct IP 重复. threadId:" + Thread.currentThread().getId());
        }
        return false;
        if (com.tencent.component.network.downloader.common.a.b()) {
          com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
        }
        return false;
        if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == this.g.id) {
          break;
        }
        i = paramInt;
      } while (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != this.g.id);
      ??? = this.a;
      if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.g.id) {}
      for (boolean bool = true; NetworkUtils.getProxy((Context)???, bool) == null; bool = false)
      {
        if (com.tencent.component.network.downloader.common.a.b()) {
          com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
        }
        return false;
      }
      return true;
      label2057:
      if (com.tencent.component.network.downloader.common.a.b()) {
        com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
      }
      return false;
      label2092:
      this.g = this.g.clone();
      this.g.setIPInfo(new IPInfo((String)???, i));
      break;
      this.x[(paramInt - 1)] = 1;
    }
  }
  
  private int o()
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.w) {
        return 0;
      }
      if (this.x[i] == 0)
      {
        this.x[i] = 1;
        return i + 1;
      }
      i += 1;
    }
  }
  
  protected final void a()
  {
    super.a();
    this.t = com.tencent.component.network.downloader.common.a.c(j());
    this.u = com.tencent.component.network.downloader.common.a.d(j());
  }
  
  /* Error */
  public final void a(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: ldc_w 426
    //   6: astore_3
    //   7: iconst_2
    //   8: anewarray 28	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_2
    //   21: aastore
    //   22: invokestatic 431	com/tencent/component/network/downloader/impl/a$b:a	([Ljava/lang/Object;)I
    //   25: istore 12
    //   27: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   30: lstore 13
    //   32: aload_1
    //   33: invokeinterface 436 1 0
    //   38: ifeq +17 -> 55
    //   41: aload_0
    //   42: aload_1
    //   43: aload_2
    //   44: aconst_null
    //   45: invokevirtual 439	com/tencent/component/network/downloader/impl/h:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   48: return
    //   49: ldc2_w 440
    //   52: invokestatic 445	java/lang/Thread:sleep	(J)V
    //   55: aload_0
    //   56: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   59: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   62: ifne +16 -> 78
    //   65: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   68: lload 13
    //   70: lsub
    //   71: ldc2_w 450
    //   74: lcmp
    //   75: ifle -26 -> 49
    //   78: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   81: lload 13
    //   83: lsub
    //   84: ldc2_w 450
    //   87: lcmp
    //   88: ifgt +6369 -> 6457
    //   91: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   94: lstore 15
    //   96: new 453	com/tencent/component/network/downloader/DownloadReport
    //   99: dup
    //   100: invokespecial 454	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   103: astore 6
    //   105: aload 6
    //   107: iload 12
    //   109: putfield 455	com/tencent/component/network/downloader/DownloadReport:id	I
    //   112: aload 6
    //   114: aload_0
    //   115: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   118: putfield 458	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   121: aload 6
    //   123: aload_0
    //   124: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   127: putfield 461	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   130: aload 6
    //   132: invokestatic 466	java/lang/System:currentTimeMillis	()J
    //   135: putfield 469	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   138: aload_0
    //   139: aconst_null
    //   140: putfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   143: aload_0
    //   144: aconst_null
    //   145: putfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   148: aconst_null
    //   149: astore 5
    //   151: aconst_null
    //   152: astore 4
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   159: invokespecial 477	com/tencent/component/network/downloader/impl/h:b	(I)Z
    //   162: istore 17
    //   164: iload 17
    //   166: ifne +211 -> 377
    //   169: iload 10
    //   171: istore 9
    //   173: aload_0
    //   174: invokevirtual 479	com/tencent/component/network/downloader/impl/h:d	()Z
    //   177: ifne +6287 -> 6464
    //   180: aload_0
    //   181: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   184: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   187: ifne +12 -> 199
    //   190: aload_2
    //   191: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   194: bipush 6
    //   196: invokevirtual 490	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   199: aload_2
    //   200: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   203: invokevirtual 493	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   206: istore 10
    //   208: aload_2
    //   209: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   212: getfield 496	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   215: istore 11
    //   217: invokestatic 236	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   220: astore_1
    //   221: aload_2
    //   222: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   225: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   228: astore 4
    //   230: aload_2
    //   231: new 117	java/lang/StringBuilder
    //   234: dup
    //   235: ldc_w 507
    //   238: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: ldc_w 509
    //   244: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: ldc_w 511
    //   250: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 10
    //   255: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: ldc_w 511
    //   261: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: iload 11
    //   266: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: ldc_w 511
    //   272: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload 9
    //   277: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: ldc_w 511
    //   283: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_1
    //   287: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc_w 511
    //   293: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc_w 426
    //   299: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc_w 511
    //   305: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 4
    //   310: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc_w 511
    //   316: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_3
    //   320: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc_w 511
    //   326: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokestatic 241	com/tencent/component/network/NetworkManager:getIspType	()I
    //   332: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: ldc_w 511
    //   338: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   345: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   348: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   351: ldc_w 516
    //   354: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokevirtual 519	com/tencent/component/network/downloader/DownloadResult:setDescInfo	(Ljava/lang/String;)V
    //   363: return
    //   364: astore_1
    //   365: ldc 115
    //   367: ldc_w 426
    //   370: aload_1
    //   371: invokestatic 522	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   374: return
    //   375: astore 4
    //   377: aload 4
    //   379: ifnull +863 -> 1242
    //   382: aload 4
    //   384: athrow
    //   385: astore 4
    //   387: iconst_0
    //   388: istore 9
    //   390: aload_2
    //   391: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   394: aload 4
    //   396: invokevirtual 525	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   399: iload 10
    //   401: iconst_1
    //   402: iadd
    //   403: istore 10
    //   405: aload_2
    //   406: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   409: lload 15
    //   411: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   414: invokevirtual 535	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   417: aload_0
    //   418: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   421: invokestatic 540	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   424: invokevirtual 543	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   427: astore 7
    //   429: aload_0
    //   430: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   433: ifnull +3659 -> 4092
    //   436: aload_0
    //   437: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   440: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   443: ifnull +3649 -> 4092
    //   446: aload_0
    //   447: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   450: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   453: invokevirtual 548	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   456: astore 5
    //   458: aload 5
    //   460: ifnull +3640 -> 4100
    //   463: aload 5
    //   465: astore_3
    //   466: aload_2
    //   467: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   470: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   473: ifne +60 -> 533
    //   476: aload_0
    //   477: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   480: ifnull +24 -> 504
    //   483: aload_0
    //   484: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   487: aload_0
    //   488: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   491: aload_2
    //   492: invokevirtual 558	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   495: aload_0
    //   496: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   499: invokeinterface 564 4 0
    //   504: aload_0
    //   505: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   508: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   511: ifne +22 -> 533
    //   514: aload_0
    //   515: aload_0
    //   516: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   519: iconst_1
    //   520: isub
    //   521: putfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   524: aload_2
    //   525: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   528: bipush 6
    //   530: invokevirtual 490	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   533: aload_1
    //   534: invokeinterface 436 1 0
    //   539: ifne +682 -> 1221
    //   542: aload_2
    //   543: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   546: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   549: ifne +3576 -> 4125
    //   552: new 117	java/lang/StringBuilder
    //   555: dup
    //   556: ldc_w 566
    //   559: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   562: aload_0
    //   563: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   566: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: ldc_w 568
    //   572: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload 7
    //   577: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   580: ldc_w 573
    //   583: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload 5
    //   588: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: ldc_w 575
    //   594: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: ldc_w 577
    //   600: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: ldc_w 579
    //   606: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokestatic 249	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   612: invokevirtual 252	java/lang/Thread:getId	()J
    //   615: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   618: ldc_w 581
    //   621: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokestatic 236	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   627: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: ldc_w 583
    //   633: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_0
    //   637: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   640: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   643: ldc_w 585
    //   646: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload_0
    //   650: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   653: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   656: ldc_w 587
    //   659: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: astore 8
    //   664: aload_0
    //   665: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   668: ifeq +3439 -> 4107
    //   671: aload_0
    //   672: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   675: aload_0
    //   676: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   679: invokestatic 406	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   682: astore 5
    //   684: aload 8
    //   686: aload 5
    //   688: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   691: ldc_w 589
    //   694: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_0
    //   698: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   701: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   704: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   707: ldc_w 591
    //   710: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload_2
    //   714: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   717: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   720: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: ldc_w 593
    //   726: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload_2
    //   730: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   733: getfield 596	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   736: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   739: ldc_w 598
    //   742: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   748: aload_0
    //   749: getfield 47	com/tencent/component/network/downloader/impl/h:v	J
    //   752: lsub
    //   753: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   756: ldc_w 600
    //   759: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_2
    //   763: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   766: getfield 603	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   769: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   772: ldc_w 511
    //   775: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload_2
    //   779: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   782: getfield 606	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   785: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   788: ldc_w 608
    //   791: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: aload_2
    //   795: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   798: getfield 611	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   801: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   804: ldc_w 613
    //   807: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: aload_0
    //   811: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   814: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   817: ldc_w 511
    //   820: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload_0
    //   824: getfield 615	com/tencent/component/network/downloader/impl/h:b	I
    //   827: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: ldc_w 617
    //   833: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: iload 10
    //   838: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   841: ldc_w 619
    //   844: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload_2
    //   848: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   851: invokevirtual 493	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   854: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   857: ldc_w 621
    //   860: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: iload 9
    //   865: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   868: ldc_w 623
    //   871: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload_0
    //   875: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   878: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: ldc_w 627
    //   884: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: astore 5
    //   889: aload_0
    //   890: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   893: ifnull +3220 -> 4113
    //   896: aload_0
    //   897: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   900: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   903: istore 11
    //   905: aload 5
    //   907: iload 11
    //   909: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   912: ldc_w 629
    //   915: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload_2
    //   919: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   922: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   925: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: ldc_w 634
    //   931: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload_0
    //   935: invokevirtual 636	com/tencent/component/network/downloader/impl/h:n	()I
    //   938: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   941: ldc_w 638
    //   944: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: astore 8
    //   949: aload_0
    //   950: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   953: ifnull +3166 -> 4119
    //   956: aload_0
    //   957: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   960: invokeinterface 646 1 0
    //   965: astore 5
    //   967: ldc 115
    //   969: aload 8
    //   971: aload 5
    //   973: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   976: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   979: aload 4
    //   981: invokestatic 522	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   984: getstatic 279	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   987: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   990: aload_0
    //   991: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   994: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   997: if_icmpne +37 -> 1034
    //   1000: aload_0
    //   1001: getfield 306	com/tencent/component/network/downloader/impl/h:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1004: ifnull +30 -> 1034
    //   1007: aload_0
    //   1008: getfield 306	com/tencent/component/network/downloader/impl/h:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1011: aload_0
    //   1012: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1015: aload_0
    //   1016: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   1019: invokestatic 648	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1022: aload_2
    //   1023: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1026: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1029: invokeinterface 652 4 0
    //   1034: getstatic 389	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1037: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1040: aload_0
    //   1041: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1044: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   1047: if_icmpne +37 -> 1084
    //   1050: aload_0
    //   1051: getfield 373	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1054: ifnull +30 -> 1084
    //   1057: aload_0
    //   1058: getfield 373	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   1061: aload_0
    //   1062: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1065: aload_0
    //   1066: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   1069: invokestatic 648	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1072: aload_2
    //   1073: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1076: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1079: invokeinterface 652 4 0
    //   1084: aload 6
    //   1086: invokestatic 466	java/lang/System:currentTimeMillis	()J
    //   1089: putfield 655	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   1092: aload 6
    //   1094: aload_0
    //   1095: getfield 657	com/tencent/component/network/downloader/impl/h:d	J
    //   1098: putfield 660	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   1101: aload 6
    //   1103: aload_0
    //   1104: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   1107: putfield 663	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   1110: aload 6
    //   1112: iload 9
    //   1114: putfield 664	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   1117: aload 6
    //   1119: aload 4
    //   1121: putfield 668	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   1124: aload 7
    //   1126: ifnonnull +3454 -> 4580
    //   1129: aconst_null
    //   1130: astore 4
    //   1132: aload 6
    //   1134: aload 4
    //   1136: putfield 671	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   1139: aload_0
    //   1140: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1143: ifnull +3447 -> 4590
    //   1146: aload_0
    //   1147: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1150: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1153: ifnull +3437 -> 4590
    //   1156: aload_0
    //   1157: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1160: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1163: getfield 674	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   1166: astore 4
    //   1168: aload 6
    //   1170: aload 4
    //   1172: putfield 677	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   1175: aload 6
    //   1177: ldc_w 577
    //   1180: putfield 680	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1183: aload 6
    //   1185: aload_2
    //   1186: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1189: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1192: putfield 681	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1195: aload 6
    //   1197: aload_2
    //   1198: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1201: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1204: putfield 684	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1207: aload_2
    //   1208: aload 6
    //   1210: invokevirtual 688	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1213: aload_0
    //   1214: aload_1
    //   1215: aload_2
    //   1216: aload 6
    //   1218: invokevirtual 439	com/tencent/component/network/downloader/impl/h:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1221: aload_0
    //   1222: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1225: ifnull +5246 -> 6471
    //   1228: aload_0
    //   1229: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1232: invokevirtual 691	org/apache/http/client/methods/HttpGet:abort	()V
    //   1235: iload 10
    //   1237: istore 9
    //   1239: goto -1066 -> 173
    //   1242: getstatic 695	com/tencent/component/network/downloader/impl/h:i	Ljava/lang/ThreadLocal;
    //   1245: invokevirtual 701	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1248: checkcast 703	com/tencent/component/network/utils/a/e$b
    //   1251: astore 7
    //   1253: aload 7
    //   1255: aload_0
    //   1256: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   1259: putfield 705	com/tencent/component/network/utils/a/e$b:a	Z
    //   1262: aload 7
    //   1264: aload_0
    //   1265: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   1268: putfield 707	com/tencent/component/network/utils/a/e$b:b	Z
    //   1271: aload_0
    //   1272: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   1275: ifnull +1337 -> 2612
    //   1278: aload_0
    //   1279: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   1282: invokeinterface 646 1 0
    //   1287: astore_3
    //   1288: aload 7
    //   1290: aload_3
    //   1291: putfield 710	com/tencent/component/network/utils/a/e$b:c	Lorg/apache/http/HttpHost;
    //   1294: aload 6
    //   1296: iload 10
    //   1298: putfield 713	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   1301: aload_2
    //   1302: invokevirtual 716	com/tencent/component/network/downloader/DownloadResult:reset	()V
    //   1305: aload_0
    //   1306: aload_0
    //   1307: aload_0
    //   1308: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1311: invokevirtual 717	com/tencent/component/network/downloader/impl/h:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1314: putfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   1317: aload 7
    //   1319: getfield 710	com/tencent/component/network/utils/a/e$b:c	Lorg/apache/http/HttpHost;
    //   1322: ifnonnull +253 -> 1575
    //   1325: aload_0
    //   1326: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   1329: ldc_w 719
    //   1332: invokevirtual 722	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1335: ifne +240 -> 1575
    //   1338: aload_0
    //   1339: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1342: ifnull +233 -> 1575
    //   1345: aload_0
    //   1346: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1349: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1352: ifnull +223 -> 1575
    //   1355: aload_0
    //   1356: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1359: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1362: getfield 674	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   1365: invokestatic 325	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1368: ifne +207 -> 1575
    //   1371: aload_0
    //   1372: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1375: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1378: getfield 674	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   1381: astore 4
    //   1383: aload_0
    //   1384: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1387: astore_3
    //   1388: aload 4
    //   1390: invokestatic 724	com/tencent/component/network/downloader/common/a:e	(Ljava/lang/String;)I
    //   1393: iconst_2
    //   1394: if_icmpge +100 -> 1494
    //   1397: aload_0
    //   1398: getfield 39	com/tencent/component/network/downloader/impl/h:u	I
    //   1401: istore 9
    //   1403: iload 9
    //   1405: ifle +1212 -> 2617
    //   1408: aload_0
    //   1409: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1412: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1415: iload 9
    //   1417: putfield 727	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   1420: iload 9
    //   1422: istore 11
    //   1424: iload 9
    //   1426: invokestatic 272	com/tencent/component/network/downloader/common/a:a	(I)Z
    //   1429: ifne +7 -> 1436
    //   1432: bipush 80
    //   1434: istore 11
    //   1436: new 117	java/lang/StringBuilder
    //   1439: dup
    //   1440: aload 4
    //   1442: invokestatic 731	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1445: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1448: ldc_w 733
    //   1451: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: iload 11
    //   1456: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1459: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1462: astore 4
    //   1464: aload 4
    //   1466: astore_3
    //   1467: aload_0
    //   1468: getfield 417	com/tencent/component/network/downloader/impl/h:t	Ljava/lang/String;
    //   1471: ifnull +23 -> 1494
    //   1474: aload_0
    //   1475: aload_0
    //   1476: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   1479: aload_0
    //   1480: getfield 417	com/tencent/component/network/downloader/impl/h:t	Ljava/lang/String;
    //   1483: aload 4
    //   1485: invokevirtual 737	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1488: putfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   1491: aload 4
    //   1493: astore_3
    //   1494: aload 6
    //   1496: aload_0
    //   1497: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1500: invokevirtual 216	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1503: putfield 740	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1506: invokestatic 213	com/tencent/component/network/downloader/common/a:b	()Z
    //   1509: ifeq +66 -> 1575
    //   1512: ldc 115
    //   1514: new 117	java/lang/StringBuilder
    //   1517: dup
    //   1518: ldc_w 742
    //   1521: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1524: aload 6
    //   1526: getfield 740	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1529: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: ldc_w 744
    //   1535: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: aload_3
    //   1539: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: ldc -27
    //   1544: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: aload_0
    //   1548: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1551: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: ldc_w 299
    //   1557: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1560: invokestatic 249	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1563: invokevirtual 252	java/lang/Thread:getId	()J
    //   1566: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1569: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1572: invokestatic 257	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1575: aload_0
    //   1576: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1579: ifnull +15 -> 1594
    //   1582: aload 6
    //   1584: aload_0
    //   1585: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1588: invokevirtual 216	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1591: putfield 740	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1594: aload_0
    //   1595: aload_0
    //   1596: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   1599: aload_0
    //   1600: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1603: aload_0
    //   1604: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1607: aload_0
    //   1608: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   1611: aload 7
    //   1613: invokestatic 749	com/tencent/component/network/utils/a/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/a/e$b;)Lorg/apache/http/client/methods/HttpGet;
    //   1616: putfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1619: aload_0
    //   1620: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1623: ifnull +24 -> 1647
    //   1626: aload_0
    //   1627: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1630: aload_0
    //   1631: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1634: aload_0
    //   1635: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1638: aload_0
    //   1639: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1642: invokeinterface 753 4 0
    //   1647: aload_0
    //   1648: aload_0
    //   1649: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1652: aload_0
    //   1653: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1656: aload_0
    //   1657: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1660: invokevirtual 756	com/tencent/component/network/downloader/impl/h:a	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;)V
    //   1663: aload_0
    //   1664: aload_0
    //   1665: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1668: aload_0
    //   1669: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   1672: aload_0
    //   1673: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1676: invokevirtual 758	com/tencent/component/network/downloader/impl/h:b	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;)V
    //   1679: invokestatic 761	com/tencent/component/network/utils/a/e:a	()Lorg/apache/http/protocol/HttpContext;
    //   1682: astore_3
    //   1683: aload_0
    //   1684: aload_0
    //   1685: getfield 764	com/tencent/component/network/downloader/impl/h:j	Lorg/apache/http/client/HttpClient;
    //   1688: aload_0
    //   1689: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   1692: aload_3
    //   1693: invokeinterface 770 3 0
    //   1698: putfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   1701: aload_0
    //   1702: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   1705: ifnull +2373 -> 4078
    //   1708: aload_0
    //   1709: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   1712: invokeinterface 110 1 0
    //   1717: invokeinterface 775 1 0
    //   1722: istore 9
    //   1724: aload_2
    //   1725: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1728: iload 9
    //   1730: putfield 496	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   1733: sipush 200
    //   1736: iload 9
    //   1738: if_icmpeq +11 -> 1749
    //   1741: sipush 206
    //   1744: iload 9
    //   1746: if_icmpne +1390 -> 3136
    //   1749: aload_0
    //   1750: aload_0
    //   1751: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   1754: aload_2
    //   1755: aload_1
    //   1756: iload 9
    //   1758: invokevirtual 778	com/tencent/component/network/downloader/impl/h:a	(Lorg/apache/http/HttpResponse;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   1761: ifeq +4717 -> 6478
    //   1764: aload_2
    //   1765: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1768: invokevirtual 781	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   1771: iload 10
    //   1773: iconst_1
    //   1774: iadd
    //   1775: istore 10
    //   1777: aload_2
    //   1778: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1781: lload 15
    //   1783: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   1786: invokevirtual 535	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   1789: aload_0
    //   1790: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   1793: invokestatic 540	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   1796: invokevirtual 543	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   1799: astore 5
    //   1801: aload_0
    //   1802: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1805: ifnull +827 -> 2632
    //   1808: aload_0
    //   1809: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1812: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1815: ifnull +817 -> 2632
    //   1818: aload_0
    //   1819: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1822: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1825: invokevirtual 548	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   1828: astore 4
    //   1830: aload 4
    //   1832: ifnull +808 -> 2640
    //   1835: aload 4
    //   1837: astore_3
    //   1838: aload_2
    //   1839: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1842: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1845: ifne +60 -> 1905
    //   1848: aload_0
    //   1849: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1852: ifnull +24 -> 1876
    //   1855: aload_0
    //   1856: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1859: aload_0
    //   1860: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1863: aload_2
    //   1864: invokevirtual 558	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1867: aload_0
    //   1868: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   1871: invokeinterface 564 4 0
    //   1876: aload_0
    //   1877: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   1880: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   1883: ifne +22 -> 1905
    //   1886: aload_0
    //   1887: aload_0
    //   1888: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   1891: iconst_1
    //   1892: isub
    //   1893: putfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   1896: aload_2
    //   1897: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1900: bipush 6
    //   1902: invokevirtual 490	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   1905: aload_1
    //   1906: invokeinterface 436 1 0
    //   1911: ifne +680 -> 2591
    //   1914: aload_2
    //   1915: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1918: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1921: ifne +744 -> 2665
    //   1924: new 117	java/lang/StringBuilder
    //   1927: dup
    //   1928: ldc_w 566
    //   1931: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1934: aload_0
    //   1935: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   1938: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: ldc_w 568
    //   1944: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1947: aload 5
    //   1949: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1952: ldc_w 573
    //   1955: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: aload 4
    //   1960: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: ldc_w 575
    //   1966: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1969: ldc_w 577
    //   1972: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: ldc_w 579
    //   1978: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1981: invokestatic 249	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1984: invokevirtual 252	java/lang/Thread:getId	()J
    //   1987: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1990: ldc_w 581
    //   1993: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1996: invokestatic 236	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1999: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2002: ldc_w 583
    //   2005: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2008: aload_0
    //   2009: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   2012: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2015: ldc_w 585
    //   2018: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: aload_0
    //   2022: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   2025: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2028: ldc_w 587
    //   2031: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: astore 7
    //   2036: aload_0
    //   2037: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   2040: ifeq +607 -> 2647
    //   2043: aload_0
    //   2044: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   2047: aload_0
    //   2048: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   2051: invokestatic 406	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   2054: astore 4
    //   2056: aload 7
    //   2058: aload 4
    //   2060: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2063: ldc_w 589
    //   2066: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2069: aload_0
    //   2070: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   2073: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2076: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2079: ldc_w 591
    //   2082: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2085: aload_2
    //   2086: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2089: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2092: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2095: ldc_w 593
    //   2098: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2101: aload_2
    //   2102: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2105: getfield 596	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2108: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2111: ldc_w 598
    //   2114: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2117: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   2120: aload_0
    //   2121: getfield 47	com/tencent/component/network/downloader/impl/h:v	J
    //   2124: lsub
    //   2125: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2128: ldc_w 600
    //   2131: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2134: aload_2
    //   2135: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2138: getfield 603	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2141: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2144: ldc_w 511
    //   2147: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2150: aload_2
    //   2151: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2154: getfield 606	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2157: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2160: ldc_w 608
    //   2163: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2166: aload_2
    //   2167: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2170: getfield 611	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2173: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2176: ldc_w 613
    //   2179: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: aload_0
    //   2183: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   2186: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2189: ldc_w 511
    //   2192: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2195: aload_0
    //   2196: getfield 615	com/tencent/component/network/downloader/impl/h:b	I
    //   2199: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2202: ldc_w 617
    //   2205: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2208: iload 10
    //   2210: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2213: ldc_w 619
    //   2216: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2219: aload_2
    //   2220: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2223: invokevirtual 493	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   2226: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2229: ldc_w 621
    //   2232: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: iload 9
    //   2237: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2240: ldc_w 623
    //   2243: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: aload_0
    //   2247: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   2250: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2253: ldc_w 627
    //   2256: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2259: astore 4
    //   2261: aload_0
    //   2262: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2265: ifnull +388 -> 2653
    //   2268: aload_0
    //   2269: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2272: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2275: istore 11
    //   2277: aload 4
    //   2279: iload 11
    //   2281: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2284: ldc_w 629
    //   2287: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2290: aload_2
    //   2291: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2294: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2297: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2300: ldc_w 634
    //   2303: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2306: aload_0
    //   2307: invokevirtual 636	com/tencent/component/network/downloader/impl/h:n	()I
    //   2310: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2313: ldc_w 638
    //   2316: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2319: astore 7
    //   2321: aload_0
    //   2322: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   2325: ifnull +334 -> 2659
    //   2328: aload_0
    //   2329: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   2332: invokeinterface 646 1 0
    //   2337: astore 4
    //   2339: ldc 115
    //   2341: aload 7
    //   2343: aload 4
    //   2345: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2348: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2351: aconst_null
    //   2352: invokestatic 522	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2355: getstatic 279	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2358: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2361: aload_0
    //   2362: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2365: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2368: if_icmpne +37 -> 2405
    //   2371: aload_0
    //   2372: getfield 306	com/tencent/component/network/downloader/impl/h:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2375: ifnull +30 -> 2405
    //   2378: aload_0
    //   2379: getfield 306	com/tencent/component/network/downloader/impl/h:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2382: aload_0
    //   2383: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   2386: aload_0
    //   2387: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   2390: invokestatic 648	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2393: aload_2
    //   2394: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2397: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2400: invokeinterface 652 4 0
    //   2405: getstatic 389	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2408: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2411: aload_0
    //   2412: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2415: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2418: if_icmpne +37 -> 2455
    //   2421: aload_0
    //   2422: getfield 373	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2425: ifnull +30 -> 2455
    //   2428: aload_0
    //   2429: getfield 373	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2432: aload_0
    //   2433: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   2436: aload_0
    //   2437: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   2440: invokestatic 648	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2443: aload_2
    //   2444: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2447: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2450: invokeinterface 652 4 0
    //   2455: aload 6
    //   2457: invokestatic 466	java/lang/System:currentTimeMillis	()J
    //   2460: putfield 655	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   2463: aload 6
    //   2465: aload_0
    //   2466: getfield 657	com/tencent/component/network/downloader/impl/h:d	J
    //   2469: putfield 660	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   2472: aload 6
    //   2474: aload_0
    //   2475: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   2478: putfield 663	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   2481: aload 6
    //   2483: iload 9
    //   2485: putfield 664	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   2488: aload 6
    //   2490: aconst_null
    //   2491: putfield 668	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   2494: aload 5
    //   2496: ifnonnull +624 -> 3120
    //   2499: aconst_null
    //   2500: astore 4
    //   2502: aload 6
    //   2504: aload 4
    //   2506: putfield 671	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   2509: aload_0
    //   2510: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2513: ifnull +617 -> 3130
    //   2516: aload_0
    //   2517: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2520: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2523: ifnull +607 -> 3130
    //   2526: aload_0
    //   2527: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2530: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2533: getfield 674	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   2536: astore 4
    //   2538: aload 6
    //   2540: aload 4
    //   2542: putfield 677	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   2545: aload 6
    //   2547: ldc_w 577
    //   2550: putfield 680	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   2553: aload 6
    //   2555: aload_2
    //   2556: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2559: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2562: putfield 681	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   2565: aload 6
    //   2567: aload_2
    //   2568: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2571: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2574: putfield 684	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   2577: aload_2
    //   2578: aload 6
    //   2580: invokevirtual 688	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   2583: aload_0
    //   2584: aload_1
    //   2585: aload_2
    //   2586: aload 6
    //   2588: invokevirtual 439	com/tencent/component/network/downloader/impl/h:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   2591: aload_0
    //   2592: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   2595: ifnull +3886 -> 6481
    //   2598: aload_0
    //   2599: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   2602: invokevirtual 691	org/apache/http/client/methods/HttpGet:abort	()V
    //   2605: iload 10
    //   2607: istore 9
    //   2609: goto -2429 -> 180
    //   2612: aconst_null
    //   2613: astore_3
    //   2614: goto -1326 -> 1288
    //   2617: aload_0
    //   2618: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2621: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2624: getfield 727	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   2627: istore 9
    //   2629: goto -1209 -> 1420
    //   2632: ldc_w 577
    //   2635: astore 4
    //   2637: goto -807 -> 1830
    //   2640: ldc_w 783
    //   2643: astore_3
    //   2644: goto -806 -> 1838
    //   2647: aconst_null
    //   2648: astore 4
    //   2650: goto -594 -> 2056
    //   2653: iconst_0
    //   2654: istore 11
    //   2656: goto -379 -> 2277
    //   2659: aconst_null
    //   2660: astore 4
    //   2662: goto -323 -> 2339
    //   2665: invokestatic 213	com/tencent/component/network/downloader/common/a:b	()Z
    //   2668: ifeq -313 -> 2355
    //   2671: new 117	java/lang/StringBuilder
    //   2674: dup
    //   2675: ldc_w 785
    //   2678: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2681: aload_0
    //   2682: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   2685: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2688: ldc_w 568
    //   2691: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2694: aload 5
    //   2696: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2699: ldc_w 573
    //   2702: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2705: aload 4
    //   2707: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2710: ldc_w 575
    //   2713: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2716: ldc_w 577
    //   2719: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2722: ldc_w 579
    //   2725: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2728: invokestatic 249	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2731: invokevirtual 252	java/lang/Thread:getId	()J
    //   2734: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2737: ldc_w 581
    //   2740: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2743: invokestatic 236	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2746: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2749: ldc_w 583
    //   2752: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2755: aload_0
    //   2756: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   2759: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2762: ldc_w 585
    //   2765: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2768: aload_0
    //   2769: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   2772: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2775: ldc_w 587
    //   2778: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2781: astore 7
    //   2783: aload_0
    //   2784: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   2787: ifeq +285 -> 3072
    //   2790: aload_0
    //   2791: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   2794: aload_0
    //   2795: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   2798: invokestatic 406	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   2801: astore 4
    //   2803: aload 7
    //   2805: aload 4
    //   2807: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2810: ldc_w 593
    //   2813: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: aload_2
    //   2817: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2820: getfield 596	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2823: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2826: ldc_w 598
    //   2829: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2832: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   2835: aload_0
    //   2836: getfield 47	com/tencent/component/network/downloader/impl/h:v	J
    //   2839: lsub
    //   2840: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2843: ldc_w 600
    //   2846: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2849: aload_2
    //   2850: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2853: getfield 603	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2856: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2859: ldc_w 511
    //   2862: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2865: aload_2
    //   2866: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2869: getfield 606	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2872: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2875: ldc_w 608
    //   2878: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2881: aload_2
    //   2882: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2885: getfield 611	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2888: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2891: ldc_w 613
    //   2894: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2897: aload_0
    //   2898: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   2901: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2904: ldc_w 511
    //   2907: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2910: aload_0
    //   2911: getfield 615	com/tencent/component/network/downloader/impl/h:b	I
    //   2914: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2917: ldc_w 617
    //   2920: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2923: iload 10
    //   2925: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2928: ldc_w 787
    //   2931: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2934: iload 9
    //   2936: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2939: ldc_w 591
    //   2942: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2945: aload_2
    //   2946: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2949: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2952: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2955: ldc_w 623
    //   2958: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2961: aload_0
    //   2962: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   2965: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2968: ldc_w 627
    //   2971: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2974: astore 4
    //   2976: aload_0
    //   2977: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2980: ifnull +98 -> 3078
    //   2983: aload_0
    //   2984: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2987: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2990: istore 11
    //   2992: aload 4
    //   2994: iload 11
    //   2996: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2999: ldc_w 629
    //   3002: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3005: aload_2
    //   3006: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3009: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3012: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3015: ldc_w 634
    //   3018: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3021: aload_0
    //   3022: invokevirtual 636	com/tencent/component/network/downloader/impl/h:n	()I
    //   3025: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3028: ldc_w 638
    //   3031: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3034: astore 7
    //   3036: aload_0
    //   3037: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   3040: ifnull +44 -> 3084
    //   3043: aload_0
    //   3044: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   3047: invokeinterface 646 1 0
    //   3052: astore 4
    //   3054: ldc 115
    //   3056: aload 7
    //   3058: aload 4
    //   3060: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3063: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3066: invokestatic 257	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3069: goto -714 -> 2355
    //   3072: aconst_null
    //   3073: astore 4
    //   3075: goto -272 -> 2803
    //   3078: iconst_0
    //   3079: istore 11
    //   3081: goto -89 -> 2992
    //   3084: aconst_null
    //   3085: astore 4
    //   3087: goto -33 -> 3054
    //   3090: astore 4
    //   3092: ldc 115
    //   3094: ldc_w 788
    //   3097: aload 4
    //   3099: invokestatic 790	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3102: goto -697 -> 2405
    //   3105: astore 4
    //   3107: ldc 115
    //   3109: ldc_w 791
    //   3112: aload 4
    //   3114: invokestatic 790	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3117: goto -662 -> 2455
    //   3120: aload 5
    //   3122: invokevirtual 794	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   3125: astore 4
    //   3127: goto -625 -> 2502
    //   3130: aconst_null
    //   3131: astore 4
    //   3133: goto -595 -> 2538
    //   3136: aload_0
    //   3137: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   3140: aload_0
    //   3141: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   3144: invokestatic 796	com/tencent/component/network/downloader/impl/h:a	(Lorg/apache/http/client/methods/HttpGet;Lorg/apache/http/HttpResponse;)V
    //   3147: aload_0
    //   3148: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   3151: invokestatic 798	com/tencent/component/network/downloader/impl/h:b	(Lorg/apache/http/HttpResponse;)I
    //   3154: ifne +8 -> 3162
    //   3157: aload_0
    //   3158: iconst_0
    //   3159: invokevirtual 800	com/tencent/component/network/downloader/impl/h:a	(I)V
    //   3162: sipush 404
    //   3165: iload 9
    //   3167: if_icmpne +41 -> 3208
    //   3170: aload_0
    //   3171: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   3174: invokestatic 802	com/tencent/component/network/downloader/impl/h:a	(Lorg/apache/http/HttpResponse;)I
    //   3177: istore 11
    //   3179: iload 11
    //   3181: sipush 59435
    //   3184: if_icmpeq +19 -> 3203
    //   3187: iload 11
    //   3189: sipush 60474
    //   3192: if_icmpeq +11 -> 3203
    //   3195: iload 11
    //   3197: sipush 60513
    //   3200: if_icmpne +8 -> 3208
    //   3203: aload_0
    //   3204: iconst_0
    //   3205: invokevirtual 800	com/tencent/component/network/downloader/impl/h:a	(I)V
    //   3208: aload_2
    //   3209: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3212: iconst_3
    //   3213: invokevirtual 490	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3216: aload_0
    //   3217: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3220: ifnull +3258 -> 6478
    //   3223: aload_0
    //   3224: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3227: aload_0
    //   3228: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   3231: iconst_1
    //   3232: invokeinterface 806 3 0
    //   3237: iload 10
    //   3239: iconst_1
    //   3240: iadd
    //   3241: istore 11
    //   3243: aload_2
    //   3244: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3247: lload 15
    //   3249: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   3252: invokevirtual 535	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3255: aload_0
    //   3256: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   3259: invokestatic 540	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   3262: invokevirtual 543	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3265: astore 5
    //   3267: aload_0
    //   3268: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3271: ifnull +2660 -> 5931
    //   3274: aload_0
    //   3275: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3278: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3281: ifnull +2650 -> 5931
    //   3284: aload_0
    //   3285: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3288: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3291: invokevirtual 548	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   3294: astore 4
    //   3296: aload 4
    //   3298: ifnull +2641 -> 5939
    //   3301: aload 4
    //   3303: astore_3
    //   3304: aload_2
    //   3305: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3308: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3311: ifne +60 -> 3371
    //   3314: aload_0
    //   3315: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3318: ifnull +24 -> 3342
    //   3321: aload_0
    //   3322: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3325: aload_0
    //   3326: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   3329: aload_2
    //   3330: invokevirtual 558	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   3333: aload_0
    //   3334: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   3337: invokeinterface 564 4 0
    //   3342: aload_0
    //   3343: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   3346: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3349: ifne +22 -> 3371
    //   3352: aload_0
    //   3353: aload_0
    //   3354: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   3357: iconst_1
    //   3358: isub
    //   3359: putfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   3362: aload_2
    //   3363: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3366: bipush 6
    //   3368: invokevirtual 490	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3371: aload_1
    //   3372: invokeinterface 436 1 0
    //   3377: ifne +680 -> 4057
    //   3380: aload_2
    //   3381: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3384: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3387: ifne +2577 -> 5964
    //   3390: new 117	java/lang/StringBuilder
    //   3393: dup
    //   3394: ldc_w 566
    //   3397: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3400: aload_0
    //   3401: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   3404: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3407: ldc_w 568
    //   3410: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3413: aload 5
    //   3415: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3418: ldc_w 573
    //   3421: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3424: aload 4
    //   3426: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3429: ldc_w 575
    //   3432: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3435: ldc_w 577
    //   3438: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3441: ldc_w 579
    //   3444: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3447: invokestatic 249	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3450: invokevirtual 252	java/lang/Thread:getId	()J
    //   3453: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3456: ldc_w 581
    //   3459: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3462: invokestatic 236	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3465: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3468: ldc_w 583
    //   3471: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3474: aload_0
    //   3475: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   3478: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3481: ldc_w 585
    //   3484: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3487: aload_0
    //   3488: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   3491: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3494: ldc_w 587
    //   3497: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3500: astore 7
    //   3502: aload_0
    //   3503: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   3506: ifeq +2440 -> 5946
    //   3509: aload_0
    //   3510: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   3513: aload_0
    //   3514: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   3517: invokestatic 406	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   3520: astore 4
    //   3522: aload 7
    //   3524: aload 4
    //   3526: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3529: ldc_w 589
    //   3532: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3535: aload_0
    //   3536: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   3539: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3542: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3545: ldc_w 591
    //   3548: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3551: aload_2
    //   3552: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3555: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3558: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3561: ldc_w 593
    //   3564: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3567: aload_2
    //   3568: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3571: getfield 596	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3574: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3577: ldc_w 598
    //   3580: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3583: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   3586: aload_0
    //   3587: getfield 47	com/tencent/component/network/downloader/impl/h:v	J
    //   3590: lsub
    //   3591: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3594: ldc_w 600
    //   3597: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3600: aload_2
    //   3601: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3604: getfield 603	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3607: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3610: ldc_w 511
    //   3613: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3616: aload_2
    //   3617: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3620: getfield 606	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3623: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3626: ldc_w 608
    //   3629: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3632: aload_2
    //   3633: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3636: getfield 611	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3639: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3642: ldc_w 613
    //   3645: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3648: aload_0
    //   3649: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   3652: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3655: ldc_w 511
    //   3658: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3661: aload_0
    //   3662: getfield 615	com/tencent/component/network/downloader/impl/h:b	I
    //   3665: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3668: ldc_w 617
    //   3671: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3674: iload 11
    //   3676: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3679: ldc_w 619
    //   3682: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3685: aload_2
    //   3686: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3689: invokevirtual 493	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3692: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3695: ldc_w 621
    //   3698: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3701: iload 9
    //   3703: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3706: ldc_w 623
    //   3709: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3712: aload_0
    //   3713: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   3716: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3719: ldc_w 627
    //   3722: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3725: astore 4
    //   3727: aload_0
    //   3728: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3731: ifnull +2221 -> 5952
    //   3734: aload_0
    //   3735: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3738: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3741: istore 10
    //   3743: aload 4
    //   3745: iload 10
    //   3747: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3750: ldc_w 629
    //   3753: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3756: aload_2
    //   3757: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3760: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3763: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3766: ldc_w 634
    //   3769: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3772: aload_0
    //   3773: invokevirtual 636	com/tencent/component/network/downloader/impl/h:n	()I
    //   3776: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3779: ldc_w 638
    //   3782: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3785: astore 7
    //   3787: aload_0
    //   3788: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   3791: ifnull +2167 -> 5958
    //   3794: aload_0
    //   3795: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   3798: invokeinterface 646 1 0
    //   3803: astore 4
    //   3805: ldc 115
    //   3807: aload 7
    //   3809: aload 4
    //   3811: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3814: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3817: aconst_null
    //   3818: invokestatic 522	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3821: getstatic 279	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3824: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3827: aload_0
    //   3828: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3831: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3834: if_icmpne +37 -> 3871
    //   3837: aload_0
    //   3838: getfield 306	com/tencent/component/network/downloader/impl/h:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3841: ifnull +30 -> 3871
    //   3844: aload_0
    //   3845: getfield 306	com/tencent/component/network/downloader/impl/h:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3848: aload_0
    //   3849: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   3852: aload_0
    //   3853: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   3856: invokestatic 648	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3859: aload_2
    //   3860: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3863: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3866: invokeinterface 652 4 0
    //   3871: getstatic 389	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3874: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3877: aload_0
    //   3878: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3881: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3884: if_icmpne +37 -> 3921
    //   3887: aload_0
    //   3888: getfield 373	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3891: ifnull +30 -> 3921
    //   3894: aload_0
    //   3895: getfield 373	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3898: aload_0
    //   3899: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   3902: aload_0
    //   3903: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   3906: invokestatic 648	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3909: aload_2
    //   3910: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3913: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3916: invokeinterface 652 4 0
    //   3921: aload 6
    //   3923: invokestatic 466	java/lang/System:currentTimeMillis	()J
    //   3926: putfield 655	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   3929: aload 6
    //   3931: aload_0
    //   3932: getfield 657	com/tencent/component/network/downloader/impl/h:d	J
    //   3935: putfield 660	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   3938: aload 6
    //   3940: aload_0
    //   3941: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   3944: putfield 663	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   3947: aload 6
    //   3949: iload 9
    //   3951: putfield 664	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   3954: aload 6
    //   3956: aconst_null
    //   3957: putfield 668	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   3960: aload 5
    //   3962: ifnonnull +2457 -> 6419
    //   3965: aconst_null
    //   3966: astore 4
    //   3968: aload 6
    //   3970: aload 4
    //   3972: putfield 671	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   3975: aload_0
    //   3976: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3979: ifnull +2450 -> 6429
    //   3982: aload_0
    //   3983: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3986: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3989: ifnull +2440 -> 6429
    //   3992: aload_0
    //   3993: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3996: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   3999: getfield 674	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   4002: astore 4
    //   4004: aload 6
    //   4006: aload 4
    //   4008: putfield 677	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   4011: aload 6
    //   4013: ldc_w 577
    //   4016: putfield 680	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   4019: aload 6
    //   4021: aload_2
    //   4022: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4025: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4028: putfield 681	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   4031: aload 6
    //   4033: aload_2
    //   4034: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4037: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4040: putfield 684	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4043: aload_2
    //   4044: aload 6
    //   4046: invokevirtual 688	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4049: aload_0
    //   4050: aload_1
    //   4051: aload_2
    //   4052: aload 6
    //   4054: invokevirtual 439	com/tencent/component/network/downloader/impl/h:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4057: aload_0
    //   4058: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   4061: ifnull +10 -> 4071
    //   4064: aload_0
    //   4065: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   4068: invokevirtual 691	org/apache/http/client/methods/HttpGet:abort	()V
    //   4071: iload 11
    //   4073: istore 9
    //   4075: goto -3902 -> 173
    //   4078: aload_2
    //   4079: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4082: iconst_3
    //   4083: invokevirtual 490	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   4086: iconst_0
    //   4087: istore 9
    //   4089: goto -852 -> 3237
    //   4092: ldc_w 577
    //   4095: astore 5
    //   4097: goto -3639 -> 458
    //   4100: ldc_w 783
    //   4103: astore_3
    //   4104: goto -3638 -> 466
    //   4107: aconst_null
    //   4108: astore 5
    //   4110: goto -3426 -> 684
    //   4113: iconst_0
    //   4114: istore 11
    //   4116: goto -3211 -> 905
    //   4119: aconst_null
    //   4120: astore 5
    //   4122: goto -3155 -> 967
    //   4125: invokestatic 213	com/tencent/component/network/downloader/common/a:b	()Z
    //   4128: ifeq -3144 -> 984
    //   4131: new 117	java/lang/StringBuilder
    //   4134: dup
    //   4135: ldc_w 785
    //   4138: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4141: aload_0
    //   4142: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   4145: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4148: ldc_w 568
    //   4151: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4154: aload 7
    //   4156: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4159: ldc_w 573
    //   4162: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4165: aload 5
    //   4167: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4170: ldc_w 575
    //   4173: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4176: ldc_w 577
    //   4179: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4182: ldc_w 579
    //   4185: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4188: invokestatic 249	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4191: invokevirtual 252	java/lang/Thread:getId	()J
    //   4194: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4197: ldc_w 581
    //   4200: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4203: invokestatic 236	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4206: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4209: ldc_w 583
    //   4212: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4215: aload_0
    //   4216: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   4219: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4222: ldc_w 585
    //   4225: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4228: aload_0
    //   4229: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   4232: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4235: ldc_w 587
    //   4238: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4241: astore 8
    //   4243: aload_0
    //   4244: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   4247: ifeq +285 -> 4532
    //   4250: aload_0
    //   4251: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   4254: aload_0
    //   4255: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   4258: invokestatic 406	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   4261: astore 5
    //   4263: aload 8
    //   4265: aload 5
    //   4267: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4270: ldc_w 593
    //   4273: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4276: aload_2
    //   4277: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4280: getfield 596	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4283: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4286: ldc_w 598
    //   4289: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4292: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   4295: aload_0
    //   4296: getfield 47	com/tencent/component/network/downloader/impl/h:v	J
    //   4299: lsub
    //   4300: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4303: ldc_w 600
    //   4306: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4309: aload_2
    //   4310: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4313: getfield 603	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4316: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4319: ldc_w 511
    //   4322: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4325: aload_2
    //   4326: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4329: getfield 606	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4332: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4335: ldc_w 608
    //   4338: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4341: aload_2
    //   4342: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4345: getfield 611	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4348: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4351: ldc_w 613
    //   4354: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4357: aload_0
    //   4358: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   4361: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4364: ldc_w 511
    //   4367: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4370: aload_0
    //   4371: getfield 615	com/tencent/component/network/downloader/impl/h:b	I
    //   4374: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4377: ldc_w 617
    //   4380: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4383: iload 10
    //   4385: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4388: ldc_w 787
    //   4391: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4394: iload 9
    //   4396: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4399: ldc_w 591
    //   4402: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4405: aload_2
    //   4406: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4409: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4412: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4415: ldc_w 623
    //   4418: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4421: aload_0
    //   4422: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   4425: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4428: ldc_w 627
    //   4431: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4434: astore 5
    //   4436: aload_0
    //   4437: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4440: ifnull +98 -> 4538
    //   4443: aload_0
    //   4444: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4447: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4450: istore 11
    //   4452: aload 5
    //   4454: iload 11
    //   4456: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4459: ldc_w 629
    //   4462: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4465: aload_2
    //   4466: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4469: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4472: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4475: ldc_w 634
    //   4478: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4481: aload_0
    //   4482: invokevirtual 636	com/tencent/component/network/downloader/impl/h:n	()I
    //   4485: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4488: ldc_w 638
    //   4491: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4494: astore 8
    //   4496: aload_0
    //   4497: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   4500: ifnull +44 -> 4544
    //   4503: aload_0
    //   4504: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   4507: invokeinterface 646 1 0
    //   4512: astore 5
    //   4514: ldc 115
    //   4516: aload 8
    //   4518: aload 5
    //   4520: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4523: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4526: invokestatic 257	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   4529: goto -3545 -> 984
    //   4532: aconst_null
    //   4533: astore 5
    //   4535: goto -272 -> 4263
    //   4538: iconst_0
    //   4539: istore 11
    //   4541: goto -89 -> 4452
    //   4544: aconst_null
    //   4545: astore 5
    //   4547: goto -33 -> 4514
    //   4550: astore 5
    //   4552: ldc 115
    //   4554: ldc_w 788
    //   4557: aload 5
    //   4559: invokestatic 790	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4562: goto -3528 -> 1034
    //   4565: astore 5
    //   4567: ldc 115
    //   4569: ldc_w 791
    //   4572: aload 5
    //   4574: invokestatic 790	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4577: goto -3493 -> 1084
    //   4580: aload 7
    //   4582: invokevirtual 794	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   4585: astore 4
    //   4587: goto -3455 -> 1132
    //   4590: aconst_null
    //   4591: astore 4
    //   4593: goto -3425 -> 1168
    //   4596: astore_3
    //   4597: iconst_0
    //   4598: istore 9
    //   4600: aload 5
    //   4602: astore 4
    //   4604: iload 10
    //   4606: iconst_1
    //   4607: iadd
    //   4608: istore 10
    //   4610: aload_2
    //   4611: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4614: lload 15
    //   4616: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   4619: invokevirtual 535	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4622: aload_0
    //   4623: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   4626: invokestatic 540	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   4629: invokevirtual 543	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4632: astore 7
    //   4634: aload_0
    //   4635: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4638: ifnull +796 -> 5434
    //   4641: aload_0
    //   4642: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4645: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4648: ifnull +786 -> 5434
    //   4651: aload_0
    //   4652: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4655: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   4658: invokevirtual 548	com/tencent/component/network/downloader/common/IPInfo:toString	()Ljava/lang/String;
    //   4661: astore 5
    //   4663: aload_2
    //   4664: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4667: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4670: ifne +60 -> 4730
    //   4673: aload_0
    //   4674: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4677: ifnull +24 -> 4701
    //   4680: aload_0
    //   4681: getfield 555	com/tencent/component/network/downloader/impl/h:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4684: aload_0
    //   4685: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   4688: aload_2
    //   4689: invokevirtual 558	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   4692: aload_0
    //   4693: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   4696: invokeinterface 564 4 0
    //   4701: aload_0
    //   4702: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   4705: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4708: ifne +22 -> 4730
    //   4711: aload_0
    //   4712: aload_0
    //   4713: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   4716: iconst_1
    //   4717: isub
    //   4718: putfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   4721: aload_2
    //   4722: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4725: bipush 6
    //   4727: invokevirtual 490	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   4730: aload_1
    //   4731: invokeinterface 436 1 0
    //   4736: ifne +682 -> 5418
    //   4739: aload_2
    //   4740: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4743: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4746: ifne +714 -> 5460
    //   4749: new 117	java/lang/StringBuilder
    //   4752: dup
    //   4753: ldc_w 566
    //   4756: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4759: aload_0
    //   4760: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   4763: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4766: ldc_w 568
    //   4769: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4772: aload 7
    //   4774: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4777: ldc_w 573
    //   4780: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4783: aload 5
    //   4785: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4788: ldc_w 575
    //   4791: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4794: ldc_w 577
    //   4797: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4800: ldc_w 579
    //   4803: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4806: invokestatic 249	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4809: invokevirtual 252	java/lang/Thread:getId	()J
    //   4812: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4815: ldc_w 581
    //   4818: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4821: invokestatic 236	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4824: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4827: ldc_w 583
    //   4830: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4833: aload_0
    //   4834: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   4837: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4840: ldc_w 585
    //   4843: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4846: aload_0
    //   4847: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   4850: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4853: ldc_w 587
    //   4856: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4859: astore 8
    //   4861: aload_0
    //   4862: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   4865: ifeq +577 -> 5442
    //   4868: aload_0
    //   4869: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   4872: aload_0
    //   4873: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   4876: invokestatic 406	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   4879: astore 5
    //   4881: aload 8
    //   4883: aload 5
    //   4885: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4888: ldc_w 589
    //   4891: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4894: aload_0
    //   4895: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   4898: invokestatic 449	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4901: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4904: ldc_w 591
    //   4907: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4910: aload_2
    //   4911: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4914: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4917: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4920: ldc_w 593
    //   4923: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4926: aload_2
    //   4927: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4930: getfield 596	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4933: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4936: ldc_w 598
    //   4939: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4942: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   4945: aload_0
    //   4946: getfield 47	com/tencent/component/network/downloader/impl/h:v	J
    //   4949: lsub
    //   4950: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4953: ldc_w 600
    //   4956: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4959: aload_2
    //   4960: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4963: getfield 603	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4966: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4969: ldc_w 511
    //   4972: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4975: aload_2
    //   4976: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4979: getfield 606	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4982: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4985: ldc_w 608
    //   4988: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4991: aload_2
    //   4992: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4995: getfield 611	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4998: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5001: ldc_w 613
    //   5004: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5007: aload_0
    //   5008: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   5011: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5014: ldc_w 511
    //   5017: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5020: aload_0
    //   5021: getfield 615	com/tencent/component/network/downloader/impl/h:b	I
    //   5024: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5027: ldc_w 617
    //   5030: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5033: iload 10
    //   5035: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5038: ldc_w 619
    //   5041: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5044: aload_2
    //   5045: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5048: invokevirtual 493	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5051: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5054: ldc_w 621
    //   5057: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5060: iload 9
    //   5062: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5065: ldc_w 623
    //   5068: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5071: aload_0
    //   5072: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   5075: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5078: ldc_w 627
    //   5081: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5084: astore 5
    //   5086: aload_0
    //   5087: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5090: ifnull +358 -> 5448
    //   5093: aload_0
    //   5094: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5097: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5100: istore 10
    //   5102: aload 5
    //   5104: iload 10
    //   5106: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5109: ldc_w 629
    //   5112: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5115: aload_2
    //   5116: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5119: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5122: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5125: ldc_w 634
    //   5128: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5131: aload_0
    //   5132: invokevirtual 636	com/tencent/component/network/downloader/impl/h:n	()I
    //   5135: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5138: ldc_w 638
    //   5141: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5144: astore 8
    //   5146: aload_0
    //   5147: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5150: ifnull +304 -> 5454
    //   5153: aload_0
    //   5154: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5157: invokeinterface 646 1 0
    //   5162: astore 5
    //   5164: ldc 115
    //   5166: aload 8
    //   5168: aload 5
    //   5170: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5173: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5176: aload 4
    //   5178: invokestatic 522	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5181: getstatic 279	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5184: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5187: aload_0
    //   5188: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5191: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5194: if_icmpne +37 -> 5231
    //   5197: aload_0
    //   5198: getfield 306	com/tencent/component/network/downloader/impl/h:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5201: ifnull +30 -> 5231
    //   5204: aload_0
    //   5205: getfield 306	com/tencent/component/network/downloader/impl/h:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5208: aload_0
    //   5209: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   5212: aload_0
    //   5213: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   5216: invokestatic 648	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5219: aload_2
    //   5220: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5223: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5226: invokeinterface 652 4 0
    //   5231: getstatic 389	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5234: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5237: aload_0
    //   5238: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5241: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5244: if_icmpne +37 -> 5281
    //   5247: aload_0
    //   5248: getfield 373	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5251: ifnull +30 -> 5281
    //   5254: aload_0
    //   5255: getfield 373	com/tencent/component/network/downloader/impl/h:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5258: aload_0
    //   5259: invokevirtual 163	com/tencent/component/network/downloader/impl/h:k	()Ljava/lang/String;
    //   5262: aload_0
    //   5263: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   5266: invokestatic 648	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5269: aload_2
    //   5270: invokevirtual 485	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5273: invokevirtual 551	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5276: invokeinterface 652 4 0
    //   5281: aload 6
    //   5283: invokestatic 466	java/lang/System:currentTimeMillis	()J
    //   5286: putfield 655	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   5289: aload 6
    //   5291: aload_0
    //   5292: getfield 657	com/tencent/component/network/downloader/impl/h:d	J
    //   5295: putfield 660	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   5298: aload 6
    //   5300: aload_0
    //   5301: getfield 53	com/tencent/component/network/downloader/impl/h:A	Lorg/apache/http/HttpResponse;
    //   5304: putfield 663	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   5307: aload 6
    //   5309: iload 9
    //   5311: putfield 664	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   5314: aload 6
    //   5316: aload 4
    //   5318: putfield 668	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   5321: aload 7
    //   5323: ifnonnull +592 -> 5915
    //   5326: aconst_null
    //   5327: astore 4
    //   5329: aload 6
    //   5331: aload 4
    //   5333: putfield 671	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   5336: aload_0
    //   5337: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5340: ifnull +585 -> 5925
    //   5343: aload_0
    //   5344: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5347: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5350: ifnull +575 -> 5925
    //   5353: aload_0
    //   5354: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5357: invokevirtual 547	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   5360: getfield 674	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   5363: astore 4
    //   5365: aload 6
    //   5367: aload 4
    //   5369: putfield 677	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   5372: aload 6
    //   5374: ldc_w 577
    //   5377: putfield 680	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   5380: aload 6
    //   5382: aload_2
    //   5383: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5386: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5389: putfield 681	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   5392: aload 6
    //   5394: aload_2
    //   5395: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5398: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5401: putfield 684	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   5404: aload_2
    //   5405: aload 6
    //   5407: invokevirtual 688	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5410: aload_0
    //   5411: aload_1
    //   5412: aload_2
    //   5413: aload 6
    //   5415: invokevirtual 439	com/tencent/component/network/downloader/impl/h:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5418: aload_0
    //   5419: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   5422: ifnull +10 -> 5432
    //   5425: aload_0
    //   5426: getfield 473	com/tencent/component/network/downloader/impl/h:h	Lorg/apache/http/client/methods/HttpGet;
    //   5429: invokevirtual 691	org/apache/http/client/methods/HttpGet:abort	()V
    //   5432: aload_3
    //   5433: athrow
    //   5434: ldc_w 577
    //   5437: astore 5
    //   5439: goto -776 -> 4663
    //   5442: aconst_null
    //   5443: astore 5
    //   5445: goto -564 -> 4881
    //   5448: iconst_0
    //   5449: istore 10
    //   5451: goto -349 -> 5102
    //   5454: aconst_null
    //   5455: astore 5
    //   5457: goto -293 -> 5164
    //   5460: invokestatic 213	com/tencent/component/network/downloader/common/a:b	()Z
    //   5463: ifeq -282 -> 5181
    //   5466: new 117	java/lang/StringBuilder
    //   5469: dup
    //   5470: ldc_w 785
    //   5473: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5476: aload_0
    //   5477: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   5480: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5483: ldc_w 568
    //   5486: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5489: aload 7
    //   5491: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5494: ldc_w 573
    //   5497: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5500: aload 5
    //   5502: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5505: ldc_w 575
    //   5508: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5511: ldc_w 577
    //   5514: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5517: ldc_w 579
    //   5520: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5523: invokestatic 249	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5526: invokevirtual 252	java/lang/Thread:getId	()J
    //   5529: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5532: ldc_w 581
    //   5535: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5538: invokestatic 236	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5541: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5544: ldc_w 583
    //   5547: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5550: aload_0
    //   5551: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   5554: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5557: ldc_w 585
    //   5560: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5563: aload_0
    //   5564: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   5567: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5570: ldc_w 587
    //   5573: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5576: astore 8
    //   5578: aload_0
    //   5579: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   5582: ifeq +285 -> 5867
    //   5585: aload_0
    //   5586: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   5589: aload_0
    //   5590: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   5593: invokestatic 406	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   5596: astore 5
    //   5598: aload 8
    //   5600: aload 5
    //   5602: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5605: ldc_w 593
    //   5608: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5611: aload_2
    //   5612: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5615: getfield 596	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5618: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5621: ldc_w 598
    //   5624: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5627: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   5630: aload_0
    //   5631: getfield 47	com/tencent/component/network/downloader/impl/h:v	J
    //   5634: lsub
    //   5635: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5638: ldc_w 600
    //   5641: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5644: aload_2
    //   5645: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5648: getfield 603	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5651: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5654: ldc_w 511
    //   5657: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5660: aload_2
    //   5661: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5664: getfield 606	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5667: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5670: ldc_w 608
    //   5673: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5676: aload_2
    //   5677: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5680: getfield 611	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5683: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5686: ldc_w 613
    //   5689: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5692: aload_0
    //   5693: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   5696: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5699: ldc_w 511
    //   5702: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5705: aload_0
    //   5706: getfield 615	com/tencent/component/network/downloader/impl/h:b	I
    //   5709: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5712: ldc_w 617
    //   5715: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5718: iload 10
    //   5720: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5723: ldc_w 787
    //   5726: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5729: iload 9
    //   5731: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5734: ldc_w 591
    //   5737: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5740: aload_2
    //   5741: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5744: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5747: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5750: ldc_w 623
    //   5753: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5756: aload_0
    //   5757: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   5760: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5763: ldc_w 627
    //   5766: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5769: astore 5
    //   5771: aload_0
    //   5772: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5775: ifnull +98 -> 5873
    //   5778: aload_0
    //   5779: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5782: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5785: istore 10
    //   5787: aload 5
    //   5789: iload 10
    //   5791: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5794: ldc_w 629
    //   5797: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5800: aload_2
    //   5801: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5804: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5807: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5810: ldc_w 634
    //   5813: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5816: aload_0
    //   5817: invokevirtual 636	com/tencent/component/network/downloader/impl/h:n	()I
    //   5820: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5823: ldc_w 638
    //   5826: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5829: astore 8
    //   5831: aload_0
    //   5832: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5835: ifnull +44 -> 5879
    //   5838: aload_0
    //   5839: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5842: invokeinterface 646 1 0
    //   5847: astore 5
    //   5849: ldc 115
    //   5851: aload 8
    //   5853: aload 5
    //   5855: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5858: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5861: invokestatic 257	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   5864: goto -683 -> 5181
    //   5867: aconst_null
    //   5868: astore 5
    //   5870: goto -272 -> 5598
    //   5873: iconst_0
    //   5874: istore 10
    //   5876: goto -89 -> 5787
    //   5879: aconst_null
    //   5880: astore 5
    //   5882: goto -33 -> 5849
    //   5885: astore 5
    //   5887: ldc 115
    //   5889: ldc_w 788
    //   5892: aload 5
    //   5894: invokestatic 790	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5897: goto -666 -> 5231
    //   5900: astore 5
    //   5902: ldc 115
    //   5904: ldc_w 791
    //   5907: aload 5
    //   5909: invokestatic 790	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5912: goto -631 -> 5281
    //   5915: aload 7
    //   5917: invokevirtual 794	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   5920: astore 4
    //   5922: goto -593 -> 5329
    //   5925: aconst_null
    //   5926: astore 4
    //   5928: goto -563 -> 5365
    //   5931: ldc_w 577
    //   5934: astore 4
    //   5936: goto -2640 -> 3296
    //   5939: ldc_w 783
    //   5942: astore_3
    //   5943: goto -2639 -> 3304
    //   5946: aconst_null
    //   5947: astore 4
    //   5949: goto -2427 -> 3522
    //   5952: iconst_0
    //   5953: istore 10
    //   5955: goto -2212 -> 3743
    //   5958: aconst_null
    //   5959: astore 4
    //   5961: goto -2156 -> 3805
    //   5964: invokestatic 213	com/tencent/component/network/downloader/common/a:b	()Z
    //   5967: ifeq -2146 -> 3821
    //   5970: new 117	java/lang/StringBuilder
    //   5973: dup
    //   5974: ldc_w 785
    //   5977: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5980: aload_0
    //   5981: invokevirtual 160	com/tencent/component/network/downloader/impl/h:j	()Ljava/lang/String;
    //   5984: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5987: ldc_w 568
    //   5990: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5993: aload 5
    //   5995: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5998: ldc_w 573
    //   6001: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6004: aload 4
    //   6006: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6009: ldc_w 575
    //   6012: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6015: ldc_w 577
    //   6018: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6021: ldc_w 579
    //   6024: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6027: invokestatic 249	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6030: invokevirtual 252	java/lang/Thread:getId	()J
    //   6033: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6036: ldc_w 581
    //   6039: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6042: invokestatic 236	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6045: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6048: ldc_w 583
    //   6051: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6054: aload_0
    //   6055: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   6058: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6061: ldc_w 585
    //   6064: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6067: aload_0
    //   6068: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   6071: invokevirtual 514	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6074: ldc_w 587
    //   6077: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6080: astore 7
    //   6082: aload_0
    //   6083: getfield 262	com/tencent/component/network/downloader/impl/h:q	Z
    //   6086: ifeq +285 -> 6371
    //   6089: aload_0
    //   6090: getfield 151	com/tencent/component/network/downloader/impl/h:a	Landroid/content/Context;
    //   6093: aload_0
    //   6094: getfield 267	com/tencent/component/network/downloader/impl/h:r	Z
    //   6097: invokestatic 406	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   6100: astore 4
    //   6102: aload 7
    //   6104: aload 4
    //   6106: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6109: ldc_w 593
    //   6112: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6115: aload_2
    //   6116: invokevirtual 529	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6119: getfield 596	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6122: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6125: ldc_w 598
    //   6128: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6131: invokestatic 45	android/os/SystemClock:uptimeMillis	()J
    //   6134: aload_0
    //   6135: getfield 47	com/tencent/component/network/downloader/impl/h:v	J
    //   6138: lsub
    //   6139: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6142: ldc_w 600
    //   6145: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6148: aload_2
    //   6149: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6152: getfield 603	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6155: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6158: ldc_w 511
    //   6161: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6164: aload_2
    //   6165: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6168: getfield 606	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6171: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6174: ldc_w 608
    //   6177: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6180: aload_2
    //   6181: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6184: getfield 611	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6187: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6190: ldc_w 613
    //   6193: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6196: aload_0
    //   6197: getfield 475	com/tencent/component/network/downloader/impl/h:c	I
    //   6200: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6203: ldc_w 511
    //   6206: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6209: aload_0
    //   6210: getfield 615	com/tencent/component/network/downloader/impl/h:b	I
    //   6213: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6216: ldc_w 617
    //   6219: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6222: iload 11
    //   6224: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6227: ldc_w 787
    //   6230: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6233: iload 9
    //   6235: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6238: ldc_w 591
    //   6241: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6244: aload_2
    //   6245: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6248: getfield 505	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6251: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6254: ldc_w 623
    //   6257: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6260: aload_0
    //   6261: getfield 625	com/tencent/component/network/downloader/impl/h:s	Ljava/lang/String;
    //   6264: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6267: ldc_w 627
    //   6270: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6273: astore 4
    //   6275: aload_0
    //   6276: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6279: ifnull +98 -> 6377
    //   6282: aload_0
    //   6283: getfield 203	com/tencent/component/network/downloader/impl/h:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6286: getfield 180	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6289: istore 10
    //   6291: aload 4
    //   6293: iload 10
    //   6295: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6298: ldc_w 629
    //   6301: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6304: aload_2
    //   6305: invokevirtual 500	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6308: getfield 632	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6311: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6314: ldc_w 634
    //   6317: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6320: aload_0
    //   6321: invokevirtual 636	com/tencent/component/network/downloader/impl/h:n	()I
    //   6324: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6327: ldc_w 638
    //   6330: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6333: astore 7
    //   6335: aload_0
    //   6336: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   6339: ifnull +44 -> 6383
    //   6342: aload_0
    //   6343: getfield 641	com/tencent/component/network/downloader/impl/h:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   6346: invokeinterface 646 1 0
    //   6351: astore 4
    //   6353: ldc 115
    //   6355: aload 7
    //   6357: aload 4
    //   6359: invokevirtual 571	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6362: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6365: invokestatic 257	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6368: goto -2547 -> 3821
    //   6371: aconst_null
    //   6372: astore 4
    //   6374: goto -272 -> 6102
    //   6377: iconst_0
    //   6378: istore 10
    //   6380: goto -89 -> 6291
    //   6383: aconst_null
    //   6384: astore 4
    //   6386: goto -33 -> 6353
    //   6389: astore 4
    //   6391: ldc 115
    //   6393: ldc_w 788
    //   6396: aload 4
    //   6398: invokestatic 790	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6401: goto -2530 -> 3871
    //   6404: astore 4
    //   6406: ldc 115
    //   6408: ldc_w 791
    //   6411: aload 4
    //   6413: invokestatic 790	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6416: goto -2495 -> 3921
    //   6419: aload 5
    //   6421: invokevirtual 794	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   6424: astore 4
    //   6426: goto -2458 -> 3968
    //   6429: aconst_null
    //   6430: astore 4
    //   6432: goto -2428 -> 4004
    //   6435: astore 4
    //   6437: goto -6382 -> 55
    //   6440: astore_3
    //   6441: aload 5
    //   6443: astore 4
    //   6445: goto -1841 -> 4604
    //   6448: astore_3
    //   6449: goto -1845 -> 4604
    //   6452: astore 4
    //   6454: goto -6064 -> 390
    //   6457: iload 10
    //   6459: istore 9
    //   6461: goto -6281 -> 180
    //   6464: iload 9
    //   6466: istore 10
    //   6468: goto -6436 -> 32
    //   6471: iload 10
    //   6473: istore 9
    //   6475: goto -6302 -> 173
    //   6478: goto -3241 -> 3237
    //   6481: iload 10
    //   6483: istore 9
    //   6485: goto -6305 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6488	0	this	h
    //   0	6488	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	6488	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   6	4098	3	localObject1	Object
    //   4596	837	3	localObject2	Object
    //   5942	1	3	str1	String
    //   6440	1	3	localObject3	Object
    //   6448	1	3	localObject4	Object
    //   152	157	4	str2	String
    //   375	8	4	localThrowable1	Throwable
    //   385	735	4	localThrowable2	Throwable
    //   1130	1956	4	localObject5	Object
    //   3090	8	4	localException1	Exception
    //   3105	8	4	localException2	Exception
    //   3125	3260	4	localObject6	Object
    //   6389	8	4	localException3	Exception
    //   6404	8	4	localException4	Exception
    //   6424	7	4	str3	String
    //   6435	1	4	localException5	Exception
    //   6443	1	4	localException6	Exception
    //   6452	1	4	localThrowable3	Throwable
    //   149	4397	5	localObject7	Object
    //   4550	8	5	localException7	Exception
    //   4565	36	5	localException8	Exception
    //   4661	1220	5	localObject8	Object
    //   5885	8	5	localException9	Exception
    //   5900	542	5	localException10	Exception
    //   103	5311	6	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   427	5929	7	localObject9	Object
    //   662	5190	8	localStringBuilder	StringBuilder
    //   171	6313	9	i	int
    //   1	6481	10	j	int
    //   215	6008	11	k	int
    //   25	83	12	m	int
    //   30	52	13	l1	long
    //   94	4521	15	l2	long
    //   162	3	17	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   180	199	364	java/lang/Throwable
    //   199	363	364	java/lang/Throwable
    //   154	164	375	java/lang/Throwable
    //   382	385	385	java/lang/Throwable
    //   1242	1288	385	java/lang/Throwable
    //   1288	1388	385	java/lang/Throwable
    //   1388	1403	385	java/lang/Throwable
    //   1408	1420	385	java/lang/Throwable
    //   1424	1432	385	java/lang/Throwable
    //   1436	1464	385	java/lang/Throwable
    //   1467	1491	385	java/lang/Throwable
    //   1494	1575	385	java/lang/Throwable
    //   1575	1594	385	java/lang/Throwable
    //   1594	1647	385	java/lang/Throwable
    //   1647	1724	385	java/lang/Throwable
    //   2617	2629	385	java/lang/Throwable
    //   4078	4086	385	java/lang/Throwable
    //   2378	2405	3090	java/lang/Exception
    //   2428	2455	3105	java/lang/Exception
    //   1007	1034	4550	java/lang/Exception
    //   1057	1084	4565	java/lang/Exception
    //   382	385	4596	finally
    //   1242	1288	4596	finally
    //   1288	1388	4596	finally
    //   1388	1403	4596	finally
    //   1408	1420	4596	finally
    //   1424	1432	4596	finally
    //   1436	1464	4596	finally
    //   1467	1491	4596	finally
    //   1494	1575	4596	finally
    //   1575	1594	4596	finally
    //   1594	1647	4596	finally
    //   1647	1724	4596	finally
    //   2617	2629	4596	finally
    //   4078	4086	4596	finally
    //   5204	5231	5885	java/lang/Exception
    //   5254	5281	5900	java/lang/Exception
    //   3844	3871	6389	java/lang/Exception
    //   3894	3921	6404	java/lang/Exception
    //   49	55	6435	java/lang/Exception
    //   1724	1733	6440	finally
    //   1749	1771	6440	finally
    //   3136	3162	6440	finally
    //   3170	3179	6440	finally
    //   3203	3208	6440	finally
    //   3208	3237	6440	finally
    //   390	399	6448	finally
    //   1724	1733	6452	java/lang/Throwable
    //   1749	1771	6452	java/lang/Throwable
    //   3136	3162	6452	java/lang/Throwable
    //   3170	3179	6452	java/lang/Throwable
    //   3203	3208	6452	java/lang/Throwable
    //   3208	3237	6452	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\impl\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */