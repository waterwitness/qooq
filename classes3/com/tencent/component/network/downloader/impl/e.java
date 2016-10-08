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
import com.tencent.component.network.utils.NetworkUtils.NetworkProxy;
import java.net.UnknownHostException;
import org.apache.http.client.HttpClient;

public final class e
  extends a
{
  private boolean q;
  private boolean r;
  private final long s = SystemClock.uptimeMillis();
  private String t;
  private String u;
  private int v = 0;
  private String w;
  private NetworkUtils.NetworkProxy x;
  private String y = "";
  
  public e(Context paramContext, HttpClient paramHttpClient, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramHttpClient, paramString1, paramString2, paramBoolean);
  }
  
  private boolean b(int paramInt)
    throws UnknownHostException
  {
    int i = 80;
    String str2 = k();
    if (this.e == null) {
      this.e = DownloadGlobalStrategy.getInstance(this.a).getStrategyLib(j(), k());
    }
    this.f = this.g;
    this.g = this.e.getStrategyInfo(paramInt);
    if (com.tencent.component.network.downloader.common.a.b()) {
      com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: " + this.g.toString() + " currAttempCount:" + paramInt + " best:" + this.e.getBestId() + " url:" + j() + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
    }
    this.q = this.g.allowProxy;
    this.r = this.g.useConfigApn;
    paramInt = this.e.getPort();
    if (!com.tencent.component.network.downloader.common.a.a(paramInt))
    {
      this.e.setPort(80);
      paramInt = i;
    }
    for (;;)
    {
      String str1;
      Object localObject;
      if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.g.id)
      {
        i = paramInt;
        if (this.f != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == this.f.id)
          {
            if ((this.o == null) || (!this.o.supportExtraPort(str2))) {
              break label491;
            }
            i = this.o.changePort(str2, paramInt);
            if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i))) {
              if (com.tencent.component.network.downloader.common.a.b()) {
                com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              }
            }
          }
        }
        label491:
        do
        {
          do
          {
            do
            {
              return false;
              str1 = this.e.getBackupIP();
              localObject = str1;
              if (this.n != null)
              {
                localObject = str1;
                if (!this.n.isIPValid(str2, str1))
                {
                  this.e.setBackupIP(null);
                  localObject = this.n.resolveIP(str2);
                  if (TextUtils.isEmpty((CharSequence)localObject)) {
                    break;
                  }
                  this.e.setBackupIP((String)localObject);
                }
              }
              if ((localObject != null) && (!((String)localObject).equals(this.e.getDirectIP())) && (!((String)localObject).equals(this.e.getDnsIP()))) {
                break label559;
              }
            } while (!com.tencent.component.network.downloader.common.a.b());
            com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
          } while (!com.tencent.component.network.downloader.common.a.b());
          com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          return false;
        } while (!com.tencent.component.network.downloader.common.a.b());
        com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label559:
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)localObject, i));
      }
      for (;;)
      {
        return true;
        if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.g.id)
        {
          i = paramInt;
          if (this.f != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == this.f.id)
            {
              if ((this.o == null) || (!this.o.supportExtraPort(str2))) {
                break label815;
              }
              i = this.o.changePort(str2, paramInt);
              if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
              {
                if (!com.tencent.component.network.downloader.common.a.b()) {
                  break;
                }
                com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return false;
              }
            }
          }
          localObject = com.tencent.component.network.module.common.a.a().a(str2);
          if ((localObject == null) || (((String)localObject).equals(this.e.getBackupIP())) || (((String)localObject).equals(this.e.getDirectIP())))
          {
            this.e.setDnsIP(null);
            if (!com.tencent.component.network.downloader.common.a.b()) {
              break;
            }
            com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            return false;
            label815:
            if (!com.tencent.component.network.downloader.common.a.b()) {
              break;
            }
            com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            return false;
          }
          this.e.setDnsIP((String)localObject);
          this.g = this.g.clone();
          this.g.setIPInfo(new IPInfo((String)localObject, i));
          continue;
        }
        if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.g.id)
        {
          i = paramInt;
          if (this.f != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DomainDirect.id == this.f.id)
            {
              if ((this.o == null) || (!this.o.supportExtraPort(str2))) {
                break label1166;
              }
              i = this.o.changePort(str2, paramInt);
              if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
              {
                if (!com.tencent.component.network.downloader.common.a.b()) {
                  break;
                }
                com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                return false;
              }
            }
          }
        }
        label1166:
        do
        {
          str1 = this.e.getDirectIP();
          localObject = str1;
          if (this.m != null)
          {
            localObject = str1;
            if (!this.m.isIPValid(str2, str1))
            {
              this.e.setDirectIP(null);
              localObject = this.m.resolveIP(str2);
              if (TextUtils.isEmpty((CharSequence)localObject)) {
                break label1364;
              }
              this.e.setDirectIP((String)localObject);
            }
          }
          if ((localObject != null) && (!((String)localObject).equals(this.e.getBackupIP())) && (!((String)localObject).equals(this.e.getDnsIP()))) {
            break label1399;
          }
          if (!com.tencent.component.network.downloader.common.a.b()) {
            break;
          }
          com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          return false;
          if (!com.tencent.component.network.downloader.common.a.b()) {
            break;
          }
          com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          return false;
          if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == this.g.id) {
            break label1235;
          }
          i = paramInt;
        } while (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != this.g.id);
        label1235:
        localObject = this.a;
        if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == this.g.id) {}
        for (boolean bool = true;; bool = false)
        {
          localObject = NetworkUtils.getProxy((Context)localObject, bool);
          if (localObject != null) {
            break label1311;
          }
          if (!com.tencent.component.network.downloader.common.a.b()) {
            break;
          }
          com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        label1311:
        if (((NetworkUtils.NetworkProxy)localObject).equals(this.x))
        {
          if (!com.tencent.component.network.downloader.common.a.b()) {
            break;
          }
          com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: proxy 重复. Pass! threadId:" + Thread.currentThread().getId());
          return false;
        }
        this.x = ((NetworkUtils.NetworkProxy)localObject);
        return true;
        label1364:
        if (!com.tencent.component.network.downloader.common.a.b()) {
          break;
        }
        com.tencent.component.network.downloader.common.a.b("downloader", "downloader strategy: direct ip is null. Pass! threadId:" + Thread.currentThread().getId());
        return false;
        label1399:
        this.g = this.g.clone();
        this.g.setIPInfo(new IPInfo((String)localObject, i));
      }
    }
  }
  
  protected final void a()
  {
    super.a();
    this.u = com.tencent.component.network.downloader.common.a.c(j());
    this.v = com.tencent.component.network.downloader.common.a.d(j());
    this.w = com.tencent.component.network.utils.a.e.a(j());
  }
  
  /* Error */
  public final void a(com.tencent.component.network.utils.thread.ThreadPool.JobContext paramJobContext, com.tencent.component.network.downloader.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: iconst_2
    //   1: anewarray 317	java/lang/Object
    //   4: dup
    //   5: iconst_0
    //   6: aload_0
    //   7: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   10: aastore
    //   11: dup
    //   12: iconst_1
    //   13: aload_2
    //   14: aastore
    //   15: invokestatic 322	com/tencent/component/network/downloader/impl/a$b:a	([Ljava/lang/Object;)I
    //   18: istore 13
    //   20: iconst_0
    //   21: istore 11
    //   23: lconst_0
    //   24: lstore 14
    //   26: aload_1
    //   27: invokeinterface 327 1 0
    //   32: ifeq +11 -> 43
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: aconst_null
    //   39: invokevirtual 330	com/tencent/component/network/downloader/impl/e:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   42: return
    //   43: aload_0
    //   44: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   47: invokestatic 334	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   50: ifne +37 -> 87
    //   53: iload 11
    //   55: aload_0
    //   56: getfield 336	com/tencent/component/network/downloader/impl/e:b	I
    //   59: iconst_1
    //   60: isub
    //   61: if_icmpne +20 -> 81
    //   64: aload_2
    //   65: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   68: bipush 6
    //   70: invokevirtual 347	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   73: aload_0
    //   74: aload_1
    //   75: aload_2
    //   76: aconst_null
    //   77: invokevirtual 330	com/tencent/component/network/downloader/impl/e:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   80: return
    //   81: ldc2_w 348
    //   84: invokestatic 353	java/lang/Thread:sleep	(J)V
    //   87: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   90: lstore 16
    //   92: new 355	com/tencent/component/network/downloader/DownloadReport
    //   95: dup
    //   96: invokespecial 357	com/tencent/component/network/downloader/DownloadReport:<init>	()V
    //   99: astore 7
    //   101: aload 7
    //   103: iload 13
    //   105: putfield 358	com/tencent/component/network/downloader/DownloadReport:id	I
    //   108: aload 7
    //   110: aload_0
    //   111: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   114: putfield 361	com/tencent/component/network/downloader/DownloadReport:url	Ljava/lang/String;
    //   117: aload 7
    //   119: aload_0
    //   120: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   123: putfield 364	com/tencent/component/network/downloader/DownloadReport:domain	Ljava/lang/String;
    //   126: aload 7
    //   128: invokestatic 369	java/lang/System:currentTimeMillis	()J
    //   131: putfield 372	com/tencent/component/network/downloader/DownloadReport:startTime	J
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   139: aconst_null
    //   140: astore 6
    //   142: aconst_null
    //   143: astore 5
    //   145: aconst_null
    //   146: astore_3
    //   147: aload_0
    //   148: ldc 34
    //   150: putfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   153: invokestatic 369	java/lang/System:currentTimeMillis	()J
    //   156: lstore 18
    //   158: aload_0
    //   159: aload_0
    //   160: invokevirtual 378	com/tencent/component/network/downloader/impl/e:e	()I
    //   163: invokespecial 380	com/tencent/component/network/downloader/impl/e:b	(I)Z
    //   166: istore 22
    //   168: iload 22
    //   170: ifne +34 -> 204
    //   173: iload 11
    //   175: istore 10
    //   177: aload_0
    //   178: invokevirtual 382	com/tencent/component/network/downloader/impl/e:d	()Z
    //   181: ifeq -139 -> 42
    //   184: iload 10
    //   186: istore 11
    //   188: goto -162 -> 26
    //   191: astore_3
    //   192: ldc 86
    //   194: ldc_w 384
    //   197: invokestatic 386	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: goto -113 -> 87
    //   203: astore_3
    //   204: aload_3
    //   205: ifnull +950 -> 1155
    //   208: aload_3
    //   209: athrow
    //   210: astore 5
    //   212: iconst_0
    //   213: istore 10
    //   215: aconst_null
    //   216: astore_3
    //   217: ldc 86
    //   219: ldc 34
    //   221: aload 5
    //   223: invokestatic 389	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_2
    //   227: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   230: aload 5
    //   232: invokevirtual 392	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(Ljava/lang/Throwable;)V
    //   235: aload_2
    //   236: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   239: lload 16
    //   241: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   244: invokevirtual 402	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   247: aload_0
    //   248: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   251: invokestatic 407	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   254: invokevirtual 410	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   257: astore 6
    //   259: invokestatic 412	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   262: pop
    //   263: invokestatic 412	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   266: pop
    //   267: aload_2
    //   268: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   271: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   274: ifne +28 -> 302
    //   277: aload_0
    //   278: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   281: ifnull +21 -> 302
    //   284: aload_0
    //   285: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   288: aload_0
    //   289: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   292: aload_2
    //   293: invokevirtual 422	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   296: aload_3
    //   297: invokeinterface 428 4 0
    //   302: aload_1
    //   303: invokeinterface 327 1 0
    //   308: ifne +807 -> 1115
    //   311: aload_0
    //   312: new 88	java/lang/StringBuilder
    //   315: dup
    //   316: aload_0
    //   317: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   320: invokestatic 432	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   323: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   326: ldc_w 434
    //   329: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_2
    //   333: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   336: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   339: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   342: ldc_w 445
    //   345: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_0
    //   349: getfield 448	com/tencent/component/network/downloader/impl/e:p	J
    //   352: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: ldc_w 450
    //   358: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: putfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   367: aload_2
    //   368: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   371: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   374: ifne +3768 -> 4142
    //   377: new 88	java/lang/StringBuilder
    //   380: dup
    //   381: ldc_w 452
    //   384: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   387: aload_0
    //   388: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   391: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc_w 454
    //   397: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload 6
    //   402: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 459
    //   408: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aconst_null
    //   412: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc_w 461
    //   418: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aconst_null
    //   422: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 463
    //   428: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokestatic 135	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   434: invokevirtual 138	java/lang/Thread:getId	()J
    //   437: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   440: ldc_w 465
    //   443: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokestatic 122	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   449: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc_w 467
    //   455: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_0
    //   459: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   462: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   465: ldc_w 472
    //   468: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload_0
    //   472: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   475: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   478: ldc_w 474
    //   481: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: astore 8
    //   486: aload_0
    //   487: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   490: ifeq +3634 -> 4124
    //   493: aload_0
    //   494: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   497: aload_0
    //   498: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   501: invokestatic 281	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   504: astore 4
    //   506: aload 8
    //   508: aload 4
    //   510: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   513: ldc_w 476
    //   516: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload_0
    //   520: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   523: invokestatic 334	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   526: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   529: ldc_w 478
    //   532: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload_2
    //   536: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   539: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   542: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: ldc_w 483
    //   548: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_2
    //   552: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   555: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   558: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   561: ldc_w 488
    //   564: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   570: aload_0
    //   571: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   574: lsub
    //   575: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   578: ldc_w 490
    //   581: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload_2
    //   585: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   588: getfield 493	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   591: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   594: ldc_w 445
    //   597: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_2
    //   601: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   604: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   607: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   610: ldc_w 495
    //   613: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload_2
    //   617: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   620: getfield 498	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   623: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   626: ldc_w 500
    //   629: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: aload_0
    //   633: invokevirtual 378	com/tencent/component/network/downloader/impl/e:e	()I
    //   636: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   639: ldc_w 445
    //   642: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload_0
    //   646: invokevirtual 502	com/tencent/component/network/downloader/impl/e:f	()I
    //   649: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   652: ldc_w 504
    //   655: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload_2
    //   659: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   662: invokevirtual 507	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   665: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   668: ldc_w 509
    //   671: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: iload 10
    //   676: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   679: ldc_w 511
    //   682: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_0
    //   686: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   689: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: ldc_w 515
    //   695: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: astore 4
    //   700: aload_0
    //   701: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   704: ifnull +3426 -> 4130
    //   707: aload_0
    //   708: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   711: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   714: istore 12
    //   716: aload 4
    //   718: iload 12
    //   720: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   723: ldc_w 517
    //   726: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload_2
    //   730: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   733: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   736: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: ldc_w 522
    //   742: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: lload 14
    //   747: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   750: ldc_w 524
    //   753: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: lconst_0
    //   757: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   760: ldc_w 526
    //   763: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: ldc_w 528
    //   769: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: aload_0
    //   773: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   776: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: ldc_w 530
    //   782: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: aload_0
    //   786: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   789: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   792: ldc_w 534
    //   795: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: astore 8
    //   800: aload_0
    //   801: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   804: ifnull +3332 -> 4136
    //   807: aload_0
    //   808: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   811: invokeinterface 542 1 0
    //   816: astore 4
    //   818: ldc 86
    //   820: aload 8
    //   822: aload 4
    //   824: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: aload 5
    //   832: invokestatic 389	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   835: getstatic 167	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   838: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   841: aload_0
    //   842: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   845: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   848: if_icmpne +37 -> 885
    //   851: aload_0
    //   852: getfield 197	com/tencent/component/network/downloader/impl/e:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   855: ifnull +30 -> 885
    //   858: aload_0
    //   859: getfield 197	com/tencent/component/network/downloader/impl/e:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   862: aload_0
    //   863: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   866: aload_0
    //   867: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   870: invokestatic 544	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   873: aload_2
    //   874: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   877: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   880: invokeinterface 548 4 0
    //   885: getstatic 263	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   888: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   891: aload_0
    //   892: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   895: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   898: if_icmpne +37 -> 935
    //   901: aload_0
    //   902: getfield 266	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   905: ifnull +30 -> 935
    //   908: aload_0
    //   909: getfield 266	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   912: aload_0
    //   913: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   916: aload_0
    //   917: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   920: invokestatic 544	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   923: aload_2
    //   924: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   927: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   930: invokeinterface 548 4 0
    //   935: aload 7
    //   937: invokestatic 369	java/lang/System:currentTimeMillis	()J
    //   940: putfield 551	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   943: aload 7
    //   945: aload_0
    //   946: invokevirtual 553	com/tencent/component/network/downloader/impl/e:g	()J
    //   949: putfield 556	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   952: aload 7
    //   954: aload_3
    //   955: putfield 560	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   958: aload 7
    //   960: iload 10
    //   962: putfield 563	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   965: aload 7
    //   967: aload 5
    //   969: putfield 567	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   972: aload 6
    //   974: ifnonnull +3649 -> 4623
    //   977: aconst_null
    //   978: astore_3
    //   979: aload 7
    //   981: aload_3
    //   982: putfield 570	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   985: invokestatic 572	com/tencent/component/network/downloader/impl/a$b:b	()Ljava/lang/String;
    //   988: pop
    //   989: aconst_null
    //   990: invokestatic 216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   993: ifne +9 -> 1002
    //   996: aload 7
    //   998: aconst_null
    //   999: putfield 575	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   1002: aload 7
    //   1004: aconst_null
    //   1005: putfield 578	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   1008: aload 7
    //   1010: aload_2
    //   1011: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1014: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   1017: putfield 579	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   1020: aload 7
    //   1022: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   1025: aload_0
    //   1026: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   1029: lsub
    //   1030: putfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   1033: aload 7
    //   1035: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   1038: aload_0
    //   1039: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   1042: lsub
    //   1043: aload_2
    //   1044: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1047: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   1050: lsub
    //   1051: putfield 585	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   1054: aload 7
    //   1056: lload 14
    //   1058: putfield 588	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   1061: aload 7
    //   1063: lconst_0
    //   1064: putfield 591	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   1067: aload 7
    //   1069: lconst_0
    //   1070: putfield 594	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   1073: aload 7
    //   1075: aload_0
    //   1076: getfield 448	com/tencent/component/network/downloader/impl/e:p	J
    //   1079: putfield 597	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   1082: aload 7
    //   1084: lconst_0
    //   1085: putfield 600	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   1088: aload 7
    //   1090: aload_0
    //   1091: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   1094: putfield 603	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   1097: aload 7
    //   1099: aload_2
    //   1100: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1103: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1106: putfield 606	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   1109: aload_2
    //   1110: aload 7
    //   1112: invokevirtual 610	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1115: aload_0
    //   1116: aload_1
    //   1117: aload_2
    //   1118: aload 7
    //   1120: invokevirtual 330	com/tencent/component/network/downloader/impl/e:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   1123: aload_0
    //   1124: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1127: ifnull +15 -> 1142
    //   1130: aload_0
    //   1131: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1134: invokevirtual 615	org/apache/http/client/methods/HttpGet:abort	()V
    //   1137: aload_0
    //   1138: aconst_null
    //   1139: putfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1142: aload_0
    //   1143: invokevirtual 617	com/tencent/component/network/downloader/impl/e:m	()V
    //   1146: iload 11
    //   1148: iconst_1
    //   1149: iadd
    //   1150: istore 10
    //   1152: goto -975 -> 177
    //   1155: getstatic 621	com/tencent/component/network/downloader/impl/e:i	Ljava/lang/ThreadLocal;
    //   1158: invokevirtual 627	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   1161: checkcast 629	com/tencent/component/network/utils/a/e$b
    //   1164: astore 8
    //   1166: aload 8
    //   1168: aload_0
    //   1169: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   1172: putfield 631	com/tencent/component/network/utils/a/e$b:a	Z
    //   1175: aload 8
    //   1177: aload_0
    //   1178: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   1181: putfield 633	com/tencent/component/network/utils/a/e$b:b	Z
    //   1184: aload_0
    //   1185: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   1188: ifnull +1408 -> 2596
    //   1191: aload_0
    //   1192: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   1195: invokeinterface 542 1 0
    //   1200: astore_3
    //   1201: aload 8
    //   1203: aload_3
    //   1204: putfield 636	com/tencent/component/network/utils/a/e$b:c	Lorg/apache/http/HttpHost;
    //   1207: aload 7
    //   1209: iload 11
    //   1211: putfield 639	com/tencent/component/network/downloader/DownloadReport:currAttempCount	I
    //   1214: aload 7
    //   1216: aload_0
    //   1217: getfield 310	com/tencent/component/network/downloader/impl/e:w	Ljava/lang/String;
    //   1220: putfield 642	com/tencent/component/network/downloader/DownloadReport:refer	Ljava/lang/String;
    //   1223: aload_0
    //   1224: aload_0
    //   1225: aload_0
    //   1226: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1229: invokevirtual 643	com/tencent/component/network/downloader/impl/e:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1232: putfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   1235: aload 8
    //   1237: getfield 636	com/tencent/component/network/utils/a/e$b:c	Lorg/apache/http/HttpHost;
    //   1240: ifnonnull +259 -> 1499
    //   1243: aload_0
    //   1244: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   1247: ldc_w 645
    //   1250: invokevirtual 648	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1253: ifne +246 -> 1499
    //   1256: aload_0
    //   1257: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1260: ifnull +239 -> 1499
    //   1263: aload_0
    //   1264: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1267: invokevirtual 652	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1270: ifnull +229 -> 1499
    //   1273: aload_0
    //   1274: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1277: invokevirtual 652	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1280: getfield 655	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   1283: invokestatic 216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1286: ifne +213 -> 1499
    //   1289: aload_0
    //   1290: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1293: invokevirtual 652	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1296: getfield 655	com/tencent/component/network/downloader/common/IPInfo:ip	Ljava/lang/String;
    //   1299: astore 4
    //   1301: aload 7
    //   1303: aload 4
    //   1305: putfield 575	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   1308: aload_0
    //   1309: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   1312: astore_3
    //   1313: aload 4
    //   1315: invokestatic 657	com/tencent/component/network/downloader/common/a:e	(Ljava/lang/String;)I
    //   1318: iconst_2
    //   1319: if_icmpge +100 -> 1419
    //   1322: aload_0
    //   1323: getfield 32	com/tencent/component/network/downloader/impl/e:v	I
    //   1326: istore 10
    //   1328: iload 10
    //   1330: ifle +1271 -> 2601
    //   1333: aload_0
    //   1334: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1337: invokevirtual 652	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   1340: iload 10
    //   1342: putfield 660	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   1345: iload 10
    //   1347: istore 12
    //   1349: iload 10
    //   1351: invokestatic 160	com/tencent/component/network/downloader/common/a:a	(I)Z
    //   1354: ifne +7 -> 1361
    //   1357: bipush 80
    //   1359: istore 12
    //   1361: new 88	java/lang/StringBuilder
    //   1364: dup
    //   1365: aload 4
    //   1367: invokestatic 432	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1370: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1373: ldc_w 662
    //   1376: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: iload 12
    //   1381: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: astore 4
    //   1389: aload 4
    //   1391: astore_3
    //   1392: aload_0
    //   1393: getfield 301	com/tencent/component/network/downloader/impl/e:u	Ljava/lang/String;
    //   1396: ifnull +23 -> 1419
    //   1399: aload_0
    //   1400: aload_0
    //   1401: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   1404: aload_0
    //   1405: getfield 301	com/tencent/component/network/downloader/impl/e:u	Ljava/lang/String;
    //   1408: aload 4
    //   1410: invokevirtual 666	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1413: putfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   1416: aload 4
    //   1418: astore_3
    //   1419: aload 7
    //   1421: aload_0
    //   1422: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   1425: invokevirtual 98	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:toString	()Ljava/lang/String;
    //   1428: putfield 669	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1431: invokestatic 671	com/tencent/component/network/downloader/common/a:a	()Z
    //   1434: ifeq +65 -> 1499
    //   1437: ldc 86
    //   1439: new 88	java/lang/StringBuilder
    //   1442: dup
    //   1443: ldc_w 673
    //   1446: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1449: aload 7
    //   1451: getfield 669	com/tencent/component/network/downloader/DownloadReport:strategyInfo	Ljava/lang/String;
    //   1454: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: ldc_w 675
    //   1460: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: aload_3
    //   1464: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: ldc 115
    //   1469: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: aload_0
    //   1473: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1476: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: ldc -66
    //   1481: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: invokestatic 135	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1487: invokevirtual 138	java/lang/Thread:getId	()J
    //   1490: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1493: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1496: invokestatic 386	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1499: aload_0
    //   1500: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   1503: astore_3
    //   1504: aload_0
    //   1505: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1508: pop
    //   1509: aload_0
    //   1510: aload_3
    //   1511: aload_0
    //   1512: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   1515: aload_0
    //   1516: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   1519: aload_0
    //   1520: getfield 310	com/tencent/component/network/downloader/impl/e:w	Ljava/lang/String;
    //   1523: aload 8
    //   1525: invokestatic 678	com/tencent/component/network/utils/a/e:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/component/network/utils/a/e$b;)Lorg/apache/http/client/methods/HttpGet;
    //   1528: putfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1531: aload_0
    //   1532: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1535: ifnull +24 -> 1559
    //   1538: aload_0
    //   1539: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1542: aload_0
    //   1543: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1546: aload_0
    //   1547: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1550: aload_0
    //   1551: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   1554: invokeinterface 682 4 0
    //   1559: aload_0
    //   1560: aload_0
    //   1561: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1564: aload_0
    //   1565: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   1568: aload_0
    //   1569: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1572: invokevirtual 685	com/tencent/component/network/downloader/impl/e:a	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;)V
    //   1575: aload_0
    //   1576: aload_0
    //   1577: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1580: aload_0
    //   1581: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   1584: aload_0
    //   1585: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1588: invokevirtual 687	com/tencent/component/network/downloader/impl/e:b	(Ljava/lang/String;Ljava/lang/String;Lorg/apache/http/HttpRequest;)V
    //   1591: invokestatic 690	com/tencent/component/network/utils/a/e:a	()Lorg/apache/http/protocol/HttpContext;
    //   1594: astore_3
    //   1595: invokestatic 369	java/lang/System:currentTimeMillis	()J
    //   1598: lstore 20
    //   1600: lload 20
    //   1602: lload 18
    //   1604: lsub
    //   1605: lstore 14
    //   1607: aload_0
    //   1608: getfield 693	com/tencent/component/network/downloader/impl/e:j	Lorg/apache/http/client/HttpClient;
    //   1611: aload_0
    //   1612: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   1615: aload_3
    //   1616: invokeinterface 699 3 0
    //   1621: astore_3
    //   1622: aload_3
    //   1623: ifnull +2484 -> 4107
    //   1626: aload_3
    //   1627: astore 6
    //   1629: aload_3
    //   1630: invokeinterface 705 1 0
    //   1635: invokeinterface 710 1 0
    //   1640: istore 10
    //   1642: aload_2
    //   1643: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1646: iload 10
    //   1648: putfield 711	com/tencent/component/network/downloader/DownloadResult$Status:httpStatus	I
    //   1651: sipush 200
    //   1654: iload 10
    //   1656: if_icmpeq +11 -> 1667
    //   1659: sipush 206
    //   1662: iload 10
    //   1664: if_icmpne +1460 -> 3124
    //   1667: aload_0
    //   1668: aload_3
    //   1669: aload_2
    //   1670: aload_1
    //   1671: iload 10
    //   1673: invokevirtual 714	com/tencent/component/network/downloader/impl/e:a	(Lorg/apache/http/HttpResponse;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;I)Z
    //   1676: ifeq +4954 -> 6630
    //   1679: aload_2
    //   1680: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1683: invokevirtual 717	com/tencent/component/network/downloader/DownloadResult$Status:setSucceed	()V
    //   1686: aload_2
    //   1687: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   1690: lload 16
    //   1692: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   1695: invokevirtual 402	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   1698: aload_0
    //   1699: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   1702: invokestatic 407	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   1705: invokevirtual 410	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   1708: astore 5
    //   1710: invokestatic 412	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   1713: pop
    //   1714: invokestatic 412	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   1717: pop
    //   1718: aload_2
    //   1719: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1722: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1725: ifne +28 -> 1753
    //   1728: aload_0
    //   1729: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1732: ifnull +21 -> 1753
    //   1735: aload_0
    //   1736: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   1739: aload_0
    //   1740: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1743: aload_2
    //   1744: invokevirtual 422	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   1747: aload_3
    //   1748: invokeinterface 428 4 0
    //   1753: aload_1
    //   1754: invokeinterface 327 1 0
    //   1759: ifne +805 -> 2564
    //   1762: aload_0
    //   1763: new 88	java/lang/StringBuilder
    //   1766: dup
    //   1767: aload_0
    //   1768: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   1771: invokestatic 432	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1774: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1777: ldc_w 434
    //   1780: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: aload_2
    //   1784: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1787: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   1790: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1793: ldc_w 445
    //   1796: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1799: aload_0
    //   1800: getfield 448	com/tencent/component/network/downloader/impl/e:p	J
    //   1803: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1806: ldc_w 450
    //   1809: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1812: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1815: putfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   1818: aload_2
    //   1819: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   1822: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   1825: ifne +809 -> 2634
    //   1828: new 88	java/lang/StringBuilder
    //   1831: dup
    //   1832: ldc_w 452
    //   1835: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1838: aload_0
    //   1839: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   1842: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: ldc_w 454
    //   1848: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1851: aload 5
    //   1853: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1856: ldc_w 459
    //   1859: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: aconst_null
    //   1863: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1866: ldc_w 461
    //   1869: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1872: aconst_null
    //   1873: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: ldc_w 463
    //   1879: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1882: invokestatic 135	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1885: invokevirtual 138	java/lang/Thread:getId	()J
    //   1888: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1891: ldc_w 465
    //   1894: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1897: invokestatic 122	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   1900: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: ldc_w 467
    //   1906: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: aload_0
    //   1910: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   1913: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1916: ldc_w 472
    //   1919: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1922: aload_0
    //   1923: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   1926: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1929: ldc_w 474
    //   1932: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1935: astore 6
    //   1937: aload_0
    //   1938: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   1941: ifeq +675 -> 2616
    //   1944: aload_0
    //   1945: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   1948: aload_0
    //   1949: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   1952: invokestatic 281	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   1955: astore 4
    //   1957: aload 6
    //   1959: aload 4
    //   1961: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1964: ldc_w 476
    //   1967: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1970: aload_0
    //   1971: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   1974: invokestatic 334	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   1977: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1980: ldc_w 478
    //   1983: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1986: aload_2
    //   1987: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   1990: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   1993: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1996: ldc_w 483
    //   1999: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2002: aload_2
    //   2003: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2006: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2009: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2012: ldc_w 488
    //   2015: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2018: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2021: aload_0
    //   2022: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   2025: lsub
    //   2026: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2029: ldc_w 490
    //   2032: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2035: aload_2
    //   2036: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2039: getfield 493	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2042: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2045: ldc_w 445
    //   2048: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2051: aload_2
    //   2052: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2055: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2058: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2061: ldc_w 495
    //   2064: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2067: aload_2
    //   2068: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2071: getfield 498	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2074: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2077: ldc_w 500
    //   2080: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2083: aload_0
    //   2084: invokevirtual 378	com/tencent/component/network/downloader/impl/e:e	()I
    //   2087: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2090: ldc_w 445
    //   2093: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2096: aload_0
    //   2097: invokevirtual 502	com/tencent/component/network/downloader/impl/e:f	()I
    //   2100: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2103: ldc_w 504
    //   2106: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2109: aload_2
    //   2110: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2113: invokevirtual 507	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   2116: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2119: ldc_w 509
    //   2122: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2125: iload 10
    //   2127: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2130: ldc_w 511
    //   2133: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2136: aload_0
    //   2137: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   2140: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: ldc_w 515
    //   2146: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2149: astore 4
    //   2151: aload_0
    //   2152: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2155: ifnull +467 -> 2622
    //   2158: aload_0
    //   2159: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2162: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2165: istore 11
    //   2167: aload 4
    //   2169: iload 11
    //   2171: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2174: ldc_w 517
    //   2177: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2180: aload_2
    //   2181: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2184: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2187: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2190: ldc_w 522
    //   2193: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: lload 14
    //   2198: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2201: ldc_w 524
    //   2204: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2207: lconst_0
    //   2208: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2211: ldc_w 526
    //   2214: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: ldc_w 528
    //   2220: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: aload_0
    //   2224: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   2227: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2230: ldc_w 530
    //   2233: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2236: aload_0
    //   2237: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   2240: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2243: ldc_w 534
    //   2246: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: astore 6
    //   2251: aload_0
    //   2252: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   2255: ifnull +373 -> 2628
    //   2258: aload_0
    //   2259: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   2262: invokeinterface 542 1 0
    //   2267: astore 4
    //   2269: ldc 86
    //   2271: aload 6
    //   2273: aload 4
    //   2275: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2278: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2281: aconst_null
    //   2282: invokestatic 389	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2285: getstatic 167	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2288: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2291: aload_0
    //   2292: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2295: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2298: if_icmpne +37 -> 2335
    //   2301: aload_0
    //   2302: getfield 197	com/tencent/component/network/downloader/impl/e:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2305: ifnull +30 -> 2335
    //   2308: aload_0
    //   2309: getfield 197	com/tencent/component/network/downloader/impl/e:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2312: aload_0
    //   2313: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   2316: aload_0
    //   2317: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   2320: invokestatic 544	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2323: aload_2
    //   2324: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2327: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2330: invokeinterface 548 4 0
    //   2335: getstatic 263	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2338: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2341: aload_0
    //   2342: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2345: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2348: if_icmpne +37 -> 2385
    //   2351: aload_0
    //   2352: getfield 266	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2355: ifnull +30 -> 2385
    //   2358: aload_0
    //   2359: getfield 266	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   2362: aload_0
    //   2363: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   2366: aload_0
    //   2367: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   2370: invokestatic 544	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2373: aload_2
    //   2374: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   2377: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   2380: invokeinterface 548 4 0
    //   2385: aload 7
    //   2387: invokestatic 369	java/lang/System:currentTimeMillis	()J
    //   2390: putfield 551	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   2393: aload 7
    //   2395: aload_0
    //   2396: invokevirtual 553	com/tencent/component/network/downloader/impl/e:g	()J
    //   2399: putfield 556	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   2402: aload 7
    //   2404: aload_3
    //   2405: putfield 560	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   2408: aload 7
    //   2410: iload 10
    //   2412: putfield 563	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   2415: aload 7
    //   2417: aconst_null
    //   2418: putfield 567	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   2421: aload 5
    //   2423: ifnonnull +692 -> 3115
    //   2426: aconst_null
    //   2427: astore_3
    //   2428: aload 7
    //   2430: aload_3
    //   2431: putfield 570	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   2434: invokestatic 572	com/tencent/component/network/downloader/impl/a$b:b	()Ljava/lang/String;
    //   2437: pop
    //   2438: aconst_null
    //   2439: invokestatic 216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2442: ifne +9 -> 2451
    //   2445: aload 7
    //   2447: aconst_null
    //   2448: putfield 575	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   2451: aload 7
    //   2453: aconst_null
    //   2454: putfield 578	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   2457: aload 7
    //   2459: aload_2
    //   2460: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2463: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2466: putfield 579	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   2469: aload 7
    //   2471: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2474: aload_0
    //   2475: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   2478: lsub
    //   2479: putfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   2482: aload 7
    //   2484: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2487: aload_0
    //   2488: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   2491: lsub
    //   2492: aload_2
    //   2493: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2496: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2499: lsub
    //   2500: putfield 585	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   2503: aload 7
    //   2505: lload 14
    //   2507: putfield 588	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   2510: aload 7
    //   2512: lconst_0
    //   2513: putfield 591	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   2516: aload 7
    //   2518: lconst_0
    //   2519: putfield 594	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   2522: aload 7
    //   2524: aload_0
    //   2525: getfield 448	com/tencent/component/network/downloader/impl/e:p	J
    //   2528: putfield 597	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   2531: aload 7
    //   2533: lconst_0
    //   2534: putfield 600	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   2537: aload 7
    //   2539: aload_0
    //   2540: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   2543: putfield 603	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   2546: aload 7
    //   2548: aload_2
    //   2549: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2552: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2555: putfield 606	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   2558: aload_2
    //   2559: aload 7
    //   2561: invokevirtual 610	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   2564: aload_0
    //   2565: aload_1
    //   2566: aload_2
    //   2567: aload 7
    //   2569: invokevirtual 330	com/tencent/component/network/downloader/impl/e:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   2572: aload_0
    //   2573: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   2576: ifnull +15 -> 2591
    //   2579: aload_0
    //   2580: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   2583: invokevirtual 615	org/apache/http/client/methods/HttpGet:abort	()V
    //   2586: aload_0
    //   2587: aconst_null
    //   2588: putfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   2591: aload_0
    //   2592: invokevirtual 617	com/tencent/component/network/downloader/impl/e:m	()V
    //   2595: return
    //   2596: aconst_null
    //   2597: astore_3
    //   2598: goto -1397 -> 1201
    //   2601: aload_0
    //   2602: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2605: invokevirtual 652	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:getIPInfo	()Lcom/tencent/component/network/downloader/common/IPInfo;
    //   2608: getfield 660	com/tencent/component/network/downloader/common/IPInfo:port	I
    //   2611: istore 10
    //   2613: goto -1268 -> 1345
    //   2616: aconst_null
    //   2617: astore 4
    //   2619: goto -662 -> 1957
    //   2622: iconst_0
    //   2623: istore 11
    //   2625: goto -458 -> 2167
    //   2628: aconst_null
    //   2629: astore 4
    //   2631: goto -362 -> 2269
    //   2634: invokestatic 84	com/tencent/component/network/downloader/common/a:b	()Z
    //   2637: ifeq -352 -> 2285
    //   2640: new 88	java/lang/StringBuilder
    //   2643: dup
    //   2644: ldc_w 719
    //   2647: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2650: aload_0
    //   2651: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   2654: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2657: ldc_w 454
    //   2660: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2663: aload 5
    //   2665: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2668: ldc_w 459
    //   2671: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2674: aconst_null
    //   2675: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2678: ldc_w 461
    //   2681: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2684: aconst_null
    //   2685: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2688: ldc_w 463
    //   2691: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2694: invokestatic 135	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2697: invokevirtual 138	java/lang/Thread:getId	()J
    //   2700: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2703: ldc_w 465
    //   2706: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2709: invokestatic 122	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   2712: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2715: ldc_w 467
    //   2718: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2721: aload_0
    //   2722: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   2725: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2728: ldc_w 472
    //   2731: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2734: aload_0
    //   2735: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   2738: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2741: ldc_w 474
    //   2744: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2747: astore 6
    //   2749: aload_0
    //   2750: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   2753: ifeq +314 -> 3067
    //   2756: aload_0
    //   2757: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   2760: aload_0
    //   2761: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   2764: invokestatic 281	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   2767: astore 4
    //   2769: aload 6
    //   2771: aload 4
    //   2773: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2776: ldc_w 483
    //   2779: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2782: aload_2
    //   2783: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   2786: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   2789: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2792: ldc_w 488
    //   2795: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2798: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   2801: aload_0
    //   2802: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   2805: lsub
    //   2806: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2809: ldc_w 490
    //   2812: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2815: aload_2
    //   2816: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2819: getfield 493	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   2822: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2825: ldc_w 445
    //   2828: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2831: aload_2
    //   2832: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2835: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   2838: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2841: ldc_w 495
    //   2844: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2847: aload_2
    //   2848: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2851: getfield 498	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   2854: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2857: ldc_w 500
    //   2860: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2863: aload_0
    //   2864: invokevirtual 378	com/tencent/component/network/downloader/impl/e:e	()I
    //   2867: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2870: ldc_w 445
    //   2873: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2876: aload_0
    //   2877: invokevirtual 502	com/tencent/component/network/downloader/impl/e:f	()I
    //   2880: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2883: ldc_w 721
    //   2886: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2889: iload 10
    //   2891: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2894: ldc_w 478
    //   2897: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2900: aload_2
    //   2901: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2904: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   2907: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2910: ldc_w 511
    //   2913: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2916: aload_0
    //   2917: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   2920: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2923: ldc_w 515
    //   2926: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2929: astore 4
    //   2931: aload_0
    //   2932: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2935: ifnull +138 -> 3073
    //   2938: aload_0
    //   2939: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   2942: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   2945: istore 11
    //   2947: aload 4
    //   2949: iload 11
    //   2951: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2954: ldc_w 517
    //   2957: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2960: aload_2
    //   2961: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   2964: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   2967: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2970: ldc_w 522
    //   2973: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2976: lload 14
    //   2978: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2981: ldc_w 524
    //   2984: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2987: lconst_0
    //   2988: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2991: ldc_w 526
    //   2994: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2997: ldc_w 528
    //   3000: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3003: aload_0
    //   3004: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   3007: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3010: ldc_w 530
    //   3013: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3016: aload_0
    //   3017: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   3020: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3023: ldc_w 534
    //   3026: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3029: astore 6
    //   3031: aload_0
    //   3032: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   3035: ifnull +44 -> 3079
    //   3038: aload_0
    //   3039: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   3042: invokeinterface 542 1 0
    //   3047: astore 4
    //   3049: ldc 86
    //   3051: aload 6
    //   3053: aload 4
    //   3055: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3058: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3061: invokestatic 145	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3064: goto -779 -> 2285
    //   3067: aconst_null
    //   3068: astore 4
    //   3070: goto -301 -> 2769
    //   3073: iconst_0
    //   3074: istore 11
    //   3076: goto -129 -> 2947
    //   3079: aconst_null
    //   3080: astore 4
    //   3082: goto -33 -> 3049
    //   3085: astore 4
    //   3087: ldc 86
    //   3089: ldc_w 723
    //   3092: aload 4
    //   3094: invokestatic 725	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3097: goto -762 -> 2335
    //   3100: astore 4
    //   3102: ldc 86
    //   3104: ldc_w 727
    //   3107: aload 4
    //   3109: invokestatic 725	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3112: goto -727 -> 2385
    //   3115: aload 5
    //   3117: invokevirtual 730	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   3120: astore_3
    //   3121: goto -693 -> 2428
    //   3124: sipush 416
    //   3127: iload 10
    //   3129: if_icmpne +962 -> 4091
    //   3132: aload_0
    //   3133: ldc_w 732
    //   3136: invokevirtual 734	com/tencent/component/network/downloader/impl/e:a	(Ljava/lang/String;)V
    //   3139: aload_2
    //   3140: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3143: bipush 7
    //   3145: invokevirtual 347	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   3148: aload_0
    //   3149: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3152: ifnull +3478 -> 6630
    //   3155: aload_0
    //   3156: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3159: aload_0
    //   3160: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   3163: iconst_1
    //   3164: invokeinterface 738 3 0
    //   3169: iload 11
    //   3171: iconst_1
    //   3172: iadd
    //   3173: istore 12
    //   3175: aload_2
    //   3176: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3179: lload 16
    //   3181: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   3184: invokevirtual 402	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   3187: aload_0
    //   3188: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   3191: invokestatic 407	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   3194: invokevirtual 410	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   3197: astore 5
    //   3199: invokestatic 412	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   3202: pop
    //   3203: invokestatic 412	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   3206: pop
    //   3207: aload_2
    //   3208: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3211: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3214: ifne +28 -> 3242
    //   3217: aload_0
    //   3218: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3221: ifnull +21 -> 3242
    //   3224: aload_0
    //   3225: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   3228: aload_0
    //   3229: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   3232: aload_2
    //   3233: invokevirtual 422	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   3236: aload_3
    //   3237: invokeinterface 428 4 0
    //   3242: aload_1
    //   3243: invokeinterface 327 1 0
    //   3248: ifne +805 -> 4053
    //   3251: aload_0
    //   3252: new 88	java/lang/StringBuilder
    //   3255: dup
    //   3256: aload_0
    //   3257: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   3260: invokestatic 432	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3263: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3266: ldc_w 434
    //   3269: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3272: aload_2
    //   3273: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3276: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3279: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3282: ldc_w 445
    //   3285: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3288: aload_0
    //   3289: getfield 448	com/tencent/component/network/downloader/impl/e:p	J
    //   3292: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3295: ldc_w 450
    //   3298: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3301: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3304: putfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   3307: aload_2
    //   3308: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3311: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3314: ifne +2773 -> 6087
    //   3317: new 88	java/lang/StringBuilder
    //   3320: dup
    //   3321: ldc_w 452
    //   3324: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3327: aload_0
    //   3328: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   3331: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3334: ldc_w 454
    //   3337: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3340: aload 5
    //   3342: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3345: ldc_w 459
    //   3348: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3351: aconst_null
    //   3352: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3355: ldc_w 461
    //   3358: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3361: aconst_null
    //   3362: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3365: ldc_w 463
    //   3368: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3371: invokestatic 135	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3374: invokevirtual 138	java/lang/Thread:getId	()J
    //   3377: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3380: ldc_w 465
    //   3383: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3386: invokestatic 122	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   3389: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3392: ldc_w 467
    //   3395: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3398: aload_0
    //   3399: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   3402: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3405: ldc_w 472
    //   3408: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3411: aload_0
    //   3412: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   3415: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3418: ldc_w 474
    //   3421: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3424: astore 6
    //   3426: aload_0
    //   3427: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   3430: ifeq +2639 -> 6069
    //   3433: aload_0
    //   3434: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   3437: aload_0
    //   3438: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   3441: invokestatic 281	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   3444: astore 4
    //   3446: aload 6
    //   3448: aload 4
    //   3450: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3453: ldc_w 476
    //   3456: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3459: aload_0
    //   3460: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   3463: invokestatic 334	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   3466: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3469: ldc_w 478
    //   3472: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3475: aload_2
    //   3476: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3479: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   3482: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3485: ldc_w 483
    //   3488: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3491: aload_2
    //   3492: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3495: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3498: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3501: ldc_w 488
    //   3504: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3507: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   3510: aload_0
    //   3511: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   3514: lsub
    //   3515: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3518: ldc_w 490
    //   3521: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3524: aload_2
    //   3525: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3528: getfield 493	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   3531: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3534: ldc_w 445
    //   3537: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3540: aload_2
    //   3541: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3544: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   3547: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3550: ldc_w 495
    //   3553: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3556: aload_2
    //   3557: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3560: getfield 498	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   3563: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3566: ldc_w 500
    //   3569: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3572: aload_0
    //   3573: invokevirtual 378	com/tencent/component/network/downloader/impl/e:e	()I
    //   3576: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3579: ldc_w 445
    //   3582: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3585: aload_0
    //   3586: invokevirtual 502	com/tencent/component/network/downloader/impl/e:f	()I
    //   3589: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3592: ldc_w 504
    //   3595: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3598: aload_2
    //   3599: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3602: invokevirtual 507	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   3605: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3608: ldc_w 509
    //   3611: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3614: iload 10
    //   3616: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3619: ldc_w 511
    //   3622: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3625: aload_0
    //   3626: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   3629: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3632: ldc_w 515
    //   3635: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3638: astore 4
    //   3640: aload_0
    //   3641: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3644: ifnull +2431 -> 6075
    //   3647: aload_0
    //   3648: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3651: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3654: istore 11
    //   3656: aload 4
    //   3658: iload 11
    //   3660: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3663: ldc_w 517
    //   3666: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3669: aload_2
    //   3670: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3673: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3676: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3679: ldc_w 522
    //   3682: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3685: lload 14
    //   3687: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3690: ldc_w 524
    //   3693: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3696: lconst_0
    //   3697: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3700: ldc_w 526
    //   3703: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3706: ldc_w 528
    //   3709: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3712: aload_0
    //   3713: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   3716: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3719: ldc_w 530
    //   3722: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3725: aload_0
    //   3726: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   3729: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3732: ldc_w 534
    //   3735: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3738: astore 6
    //   3740: aload_0
    //   3741: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   3744: ifnull +2337 -> 6081
    //   3747: aload_0
    //   3748: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   3751: invokeinterface 542 1 0
    //   3756: astore 4
    //   3758: ldc 86
    //   3760: aload 6
    //   3762: aload 4
    //   3764: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3767: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3770: aconst_null
    //   3771: invokestatic 389	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3774: getstatic 167	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3777: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3780: aload_0
    //   3781: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3784: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3787: if_icmpne +37 -> 3824
    //   3790: aload_0
    //   3791: getfield 197	com/tencent/component/network/downloader/impl/e:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3794: ifnull +30 -> 3824
    //   3797: aload_0
    //   3798: getfield 197	com/tencent/component/network/downloader/impl/e:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3801: aload_0
    //   3802: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   3805: aload_0
    //   3806: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   3809: invokestatic 544	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3812: aload_2
    //   3813: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3816: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3819: invokeinterface 548 4 0
    //   3824: getstatic 263	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3827: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3830: aload_0
    //   3831: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   3834: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   3837: if_icmpne +37 -> 3874
    //   3840: aload_0
    //   3841: getfield 266	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3844: ifnull +30 -> 3874
    //   3847: aload_0
    //   3848: getfield 266	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   3851: aload_0
    //   3852: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   3855: aload_0
    //   3856: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   3859: invokestatic 544	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3862: aload_2
    //   3863: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   3866: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   3869: invokeinterface 548 4 0
    //   3874: aload 7
    //   3876: invokestatic 369	java/lang/System:currentTimeMillis	()J
    //   3879: putfield 551	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   3882: aload 7
    //   3884: aload_0
    //   3885: invokevirtual 553	com/tencent/component/network/downloader/impl/e:g	()J
    //   3888: putfield 556	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   3891: aload 7
    //   3893: aload_3
    //   3894: putfield 560	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   3897: aload 7
    //   3899: iload 10
    //   3901: putfield 563	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   3904: aload 7
    //   3906: aconst_null
    //   3907: putfield 567	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   3910: aload 5
    //   3912: ifnonnull +2656 -> 6568
    //   3915: aconst_null
    //   3916: astore_3
    //   3917: aload 7
    //   3919: aload_3
    //   3920: putfield 570	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   3923: invokestatic 572	com/tencent/component/network/downloader/impl/a$b:b	()Ljava/lang/String;
    //   3926: pop
    //   3927: aconst_null
    //   3928: invokestatic 216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3931: ifne +9 -> 3940
    //   3934: aload 7
    //   3936: aconst_null
    //   3937: putfield 575	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   3940: aload 7
    //   3942: aconst_null
    //   3943: putfield 578	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   3946: aload 7
    //   3948: aload_2
    //   3949: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   3952: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   3955: putfield 579	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   3958: aload 7
    //   3960: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   3963: aload_0
    //   3964: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   3967: lsub
    //   3968: putfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   3971: aload 7
    //   3973: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   3976: aload_0
    //   3977: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   3980: lsub
    //   3981: aload_2
    //   3982: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   3985: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   3988: lsub
    //   3989: putfield 585	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   3992: aload 7
    //   3994: lload 14
    //   3996: putfield 588	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   3999: aload 7
    //   4001: lconst_0
    //   4002: putfield 591	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   4005: aload 7
    //   4007: lconst_0
    //   4008: putfield 594	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   4011: aload 7
    //   4013: aload_0
    //   4014: getfield 448	com/tencent/component/network/downloader/impl/e:p	J
    //   4017: putfield 597	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   4020: aload 7
    //   4022: lconst_0
    //   4023: putfield 600	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   4026: aload 7
    //   4028: aload_0
    //   4029: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   4032: putfield 603	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   4035: aload 7
    //   4037: aload_2
    //   4038: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4041: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4044: putfield 606	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   4047: aload_2
    //   4048: aload 7
    //   4050: invokevirtual 610	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4053: aload_0
    //   4054: aload_1
    //   4055: aload_2
    //   4056: aload 7
    //   4058: invokevirtual 330	com/tencent/component/network/downloader/impl/e:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   4061: aload_0
    //   4062: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   4065: ifnull +15 -> 4080
    //   4068: aload_0
    //   4069: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   4072: invokevirtual 615	org/apache/http/client/methods/HttpGet:abort	()V
    //   4075: aload_0
    //   4076: aconst_null
    //   4077: putfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   4080: aload_0
    //   4081: invokevirtual 617	com/tencent/component/network/downloader/impl/e:m	()V
    //   4084: iload 12
    //   4086: istore 10
    //   4088: goto -3911 -> 177
    //   4091: aload_2
    //   4092: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4095: iconst_3
    //   4096: invokevirtual 347	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   4099: goto -951 -> 3148
    //   4102: astore 5
    //   4104: goto -3887 -> 217
    //   4107: aload_3
    //   4108: astore 6
    //   4110: aload_2
    //   4111: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4114: iconst_3
    //   4115: invokevirtual 347	com/tencent/component/network/downloader/DownloadResult$Status:setFailed	(I)V
    //   4118: iconst_0
    //   4119: istore 10
    //   4121: goto -952 -> 3169
    //   4124: aconst_null
    //   4125: astore 4
    //   4127: goto -3621 -> 506
    //   4130: iconst_0
    //   4131: istore 12
    //   4133: goto -3417 -> 716
    //   4136: aconst_null
    //   4137: astore 4
    //   4139: goto -3321 -> 818
    //   4142: invokestatic 84	com/tencent/component/network/downloader/common/a:b	()Z
    //   4145: ifeq -3310 -> 835
    //   4148: new 88	java/lang/StringBuilder
    //   4151: dup
    //   4152: ldc_w 719
    //   4155: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4158: aload_0
    //   4159: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   4162: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4165: ldc_w 454
    //   4168: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4171: aload 6
    //   4173: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4176: ldc_w 459
    //   4179: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4182: aconst_null
    //   4183: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4186: ldc_w 461
    //   4189: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4192: aconst_null
    //   4193: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4196: ldc_w 463
    //   4199: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4202: invokestatic 135	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4205: invokevirtual 138	java/lang/Thread:getId	()J
    //   4208: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4211: ldc_w 465
    //   4214: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4217: invokestatic 122	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4220: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4223: ldc_w 467
    //   4226: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4229: aload_0
    //   4230: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   4233: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4236: ldc_w 472
    //   4239: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4242: aload_0
    //   4243: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   4246: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4249: ldc_w 474
    //   4252: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4255: astore 8
    //   4257: aload_0
    //   4258: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   4261: ifeq +314 -> 4575
    //   4264: aload_0
    //   4265: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   4268: aload_0
    //   4269: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   4272: invokestatic 281	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   4275: astore 4
    //   4277: aload 8
    //   4279: aload 4
    //   4281: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4284: ldc_w 483
    //   4287: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4290: aload_2
    //   4291: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4294: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4297: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4300: ldc_w 488
    //   4303: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4306: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4309: aload_0
    //   4310: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   4313: lsub
    //   4314: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4317: ldc_w 490
    //   4320: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4323: aload_2
    //   4324: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4327: getfield 493	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   4330: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4333: ldc_w 445
    //   4336: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4339: aload_2
    //   4340: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4343: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4346: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4349: ldc_w 495
    //   4352: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4355: aload_2
    //   4356: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4359: getfield 498	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   4362: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4365: ldc_w 500
    //   4368: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4371: aload_0
    //   4372: invokevirtual 378	com/tencent/component/network/downloader/impl/e:e	()I
    //   4375: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4378: ldc_w 445
    //   4381: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4384: aload_0
    //   4385: invokevirtual 502	com/tencent/component/network/downloader/impl/e:f	()I
    //   4388: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4391: ldc_w 721
    //   4394: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4397: iload 10
    //   4399: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4402: ldc_w 478
    //   4405: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4408: aload_2
    //   4409: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4412: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4415: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4418: ldc_w 511
    //   4421: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4424: aload_0
    //   4425: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   4428: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4431: ldc_w 515
    //   4434: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4437: astore 4
    //   4439: aload_0
    //   4440: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4443: ifnull +138 -> 4581
    //   4446: aload_0
    //   4447: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   4450: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   4453: istore 12
    //   4455: aload 4
    //   4457: iload 12
    //   4459: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4462: ldc_w 517
    //   4465: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4468: aload_2
    //   4469: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4472: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   4475: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4478: ldc_w 522
    //   4481: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4484: lload 14
    //   4486: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4489: ldc_w 524
    //   4492: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4495: lconst_0
    //   4496: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4499: ldc_w 526
    //   4502: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4505: ldc_w 528
    //   4508: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4511: aload_0
    //   4512: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   4515: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4518: ldc_w 530
    //   4521: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4524: aload_0
    //   4525: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   4528: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4531: ldc_w 534
    //   4534: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4537: astore 8
    //   4539: aload_0
    //   4540: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   4543: ifnull +44 -> 4587
    //   4546: aload_0
    //   4547: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   4550: invokeinterface 542 1 0
    //   4555: astore 4
    //   4557: ldc 86
    //   4559: aload 8
    //   4561: aload 4
    //   4563: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4566: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4569: invokestatic 145	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   4572: goto -3737 -> 835
    //   4575: aconst_null
    //   4576: astore 4
    //   4578: goto -301 -> 4277
    //   4581: iconst_0
    //   4582: istore 12
    //   4584: goto -129 -> 4455
    //   4587: aconst_null
    //   4588: astore 4
    //   4590: goto -33 -> 4557
    //   4593: astore 4
    //   4595: ldc 86
    //   4597: ldc_w 723
    //   4600: aload 4
    //   4602: invokestatic 725	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4605: goto -3720 -> 885
    //   4608: astore 4
    //   4610: ldc 86
    //   4612: ldc_w 727
    //   4615: aload 4
    //   4617: invokestatic 725	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4620: goto -3685 -> 935
    //   4623: aload 6
    //   4625: invokevirtual 730	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   4628: astore_3
    //   4629: goto -3650 -> 979
    //   4632: astore 4
    //   4634: iconst_0
    //   4635: istore 10
    //   4637: aconst_null
    //   4638: astore 6
    //   4640: aload 5
    //   4642: astore_3
    //   4643: aload 6
    //   4645: astore 5
    //   4647: aload_2
    //   4648: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4651: lload 16
    //   4653: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4656: invokevirtual 402	com/tencent/component/network/downloader/DownloadResult$Process:setDuration	(JJ)V
    //   4659: aload_0
    //   4660: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   4663: invokestatic 407	com/tencent/component/network/module/common/b:a	(Landroid/content/Context;)Lcom/tencent/component/network/module/common/b;
    //   4666: invokevirtual 410	com/tencent/component/network/module/common/b:a	()Lcom/tencent/component/network/utils/NetworkUtils$DNS;
    //   4669: astore 8
    //   4671: invokestatic 412	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   4674: pop
    //   4675: invokestatic 412	com/tencent/component/network/downloader/impl/a$b:a	()Ljava/lang/String;
    //   4678: pop
    //   4679: aload_2
    //   4680: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4683: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4686: ifne +28 -> 4714
    //   4689: aload_0
    //   4690: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4693: ifnull +21 -> 4714
    //   4696: aload_0
    //   4697: getfield 419	com/tencent/component/network/downloader/impl/e:l	Lcom/tencent/component/network/downloader/strategy/ResumeTransfer;
    //   4700: aload_0
    //   4701: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   4704: aload_2
    //   4705: invokevirtual 422	com/tencent/component/network/downloader/DownloadResult:getPath	()Ljava/lang/String;
    //   4708: aload_3
    //   4709: invokeinterface 428 4 0
    //   4714: aload_1
    //   4715: invokeinterface 327 1 0
    //   4720: ifne +807 -> 5527
    //   4723: aload_0
    //   4724: new 88	java/lang/StringBuilder
    //   4727: dup
    //   4728: aload_0
    //   4729: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   4732: invokestatic 432	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4735: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4738: ldc_w 434
    //   4741: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4744: aload_2
    //   4745: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4748: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   4751: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4754: ldc_w 445
    //   4757: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4760: aload_0
    //   4761: getfield 448	com/tencent/component/network/downloader/impl/e:p	J
    //   4764: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4767: ldc_w 450
    //   4770: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4773: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4776: putfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   4779: aload_2
    //   4780: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   4783: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   4786: ifne +793 -> 5579
    //   4789: new 88	java/lang/StringBuilder
    //   4792: dup
    //   4793: ldc_w 452
    //   4796: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4799: aload_0
    //   4800: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   4803: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4806: ldc_w 454
    //   4809: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4812: aload 8
    //   4814: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4817: ldc_w 459
    //   4820: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4823: aconst_null
    //   4824: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4827: ldc_w 461
    //   4830: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4833: aconst_null
    //   4834: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4837: ldc_w 463
    //   4840: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4843: invokestatic 135	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   4846: invokevirtual 138	java/lang/Thread:getId	()J
    //   4849: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4852: ldc_w 465
    //   4855: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4858: invokestatic 122	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   4861: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4864: ldc_w 467
    //   4867: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4870: aload_0
    //   4871: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   4874: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4877: ldc_w 472
    //   4880: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4883: aload_0
    //   4884: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   4887: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4890: ldc_w 474
    //   4893: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4896: astore 9
    //   4898: aload_0
    //   4899: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   4902: ifeq +659 -> 5561
    //   4905: aload_0
    //   4906: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   4909: aload_0
    //   4910: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   4913: invokestatic 281	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   4916: astore 6
    //   4918: aload 9
    //   4920: aload 6
    //   4922: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4925: ldc_w 476
    //   4928: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4931: aload_0
    //   4932: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   4935: invokestatic 334	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   4938: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4941: ldc_w 478
    //   4944: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4947: aload_2
    //   4948: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   4951: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   4954: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4957: ldc_w 483
    //   4960: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4963: aload_2
    //   4964: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   4967: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   4970: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4973: ldc_w 488
    //   4976: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4979: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   4982: aload_0
    //   4983: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   4986: lsub
    //   4987: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4990: ldc_w 490
    //   4993: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4996: aload_2
    //   4997: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5000: getfield 493	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5003: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5006: ldc_w 445
    //   5009: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5012: aload_2
    //   5013: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5016: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5019: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5022: ldc_w 495
    //   5025: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5028: aload_2
    //   5029: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5032: getfield 498	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5035: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5038: ldc_w 500
    //   5041: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5044: aload_0
    //   5045: invokevirtual 378	com/tencent/component/network/downloader/impl/e:e	()I
    //   5048: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5051: ldc_w 445
    //   5054: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5057: aload_0
    //   5058: invokevirtual 502	com/tencent/component/network/downloader/impl/e:f	()I
    //   5061: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5064: ldc_w 504
    //   5067: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5070: aload_2
    //   5071: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5074: invokevirtual 507	com/tencent/component/network/downloader/DownloadResult$Status:getFailReason	()I
    //   5077: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5080: ldc_w 509
    //   5083: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5086: iload 10
    //   5088: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5091: ldc_w 511
    //   5094: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5097: aload_0
    //   5098: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   5101: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5104: ldc_w 515
    //   5107: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5110: astore 6
    //   5112: aload_0
    //   5113: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5116: ifnull +451 -> 5567
    //   5119: aload_0
    //   5120: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5123: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5126: istore 11
    //   5128: aload 6
    //   5130: iload 11
    //   5132: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5135: ldc_w 517
    //   5138: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5141: aload_2
    //   5142: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5145: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5148: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5151: ldc_w 522
    //   5154: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5157: lload 14
    //   5159: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5162: ldc_w 524
    //   5165: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5168: lconst_0
    //   5169: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5172: ldc_w 526
    //   5175: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5178: ldc_w 528
    //   5181: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5184: aload_0
    //   5185: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   5188: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5191: ldc_w 530
    //   5194: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5197: aload_0
    //   5198: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   5201: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5204: ldc_w 534
    //   5207: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5210: astore 9
    //   5212: aload_0
    //   5213: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5216: ifnull +357 -> 5573
    //   5219: aload_0
    //   5220: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5223: invokeinterface 542 1 0
    //   5228: astore 6
    //   5230: ldc 86
    //   5232: aload 9
    //   5234: aload 6
    //   5236: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5239: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5242: aload 5
    //   5244: invokestatic 389	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5247: getstatic 167	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_BACKUPIP	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5250: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5253: aload_0
    //   5254: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5257: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5260: if_icmpne +37 -> 5297
    //   5263: aload_0
    //   5264: getfield 197	com/tencent/component/network/downloader/impl/e:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5267: ifnull +30 -> 5297
    //   5270: aload_0
    //   5271: getfield 197	com/tencent/component/network/downloader/impl/e:n	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5274: aload_0
    //   5275: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   5278: aload_0
    //   5279: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   5282: invokestatic 544	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5285: aload_2
    //   5286: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5289: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5292: invokeinterface 548 4 0
    //   5297: getstatic 263	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:Strategy_DomainDirect	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5300: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5303: aload_0
    //   5304: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5307: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5310: if_icmpne +37 -> 5347
    //   5313: aload_0
    //   5314: getfield 266	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5317: ifnull +30 -> 5347
    //   5320: aload_0
    //   5321: getfield 266	com/tencent/component/network/downloader/impl/e:m	Lcom/tencent/component/network/downloader/strategy/IPStrategy;
    //   5324: aload_0
    //   5325: invokevirtual 45	com/tencent/component/network/downloader/impl/e:k	()Ljava/lang/String;
    //   5328: aload_0
    //   5329: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   5332: invokestatic 544	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5335: aload_2
    //   5336: invokevirtual 342	com/tencent/component/network/downloader/DownloadResult:getStatus	()Lcom/tencent/component/network/downloader/DownloadResult$Status;
    //   5339: invokevirtual 415	com/tencent/component/network/downloader/DownloadResult$Status:isSucceed	()Z
    //   5342: invokeinterface 548 4 0
    //   5347: aload 7
    //   5349: invokestatic 369	java/lang/System:currentTimeMillis	()J
    //   5352: putfield 551	com/tencent/component/network/downloader/DownloadReport:endTime	J
    //   5355: aload 7
    //   5357: aload_0
    //   5358: invokevirtual 553	com/tencent/component/network/downloader/impl/e:g	()J
    //   5361: putfield 556	com/tencent/component/network/downloader/DownloadReport:fileSize	J
    //   5364: aload 7
    //   5366: aload_3
    //   5367: putfield 560	com/tencent/component/network/downloader/DownloadReport:response	Lorg/apache/http/HttpResponse;
    //   5370: aload 7
    //   5372: iload 10
    //   5374: putfield 563	com/tencent/component/network/downloader/DownloadReport:httpStatus	I
    //   5377: aload 7
    //   5379: aload 5
    //   5381: putfield 567	com/tencent/component/network/downloader/DownloadReport:exception	Ljava/lang/Throwable;
    //   5384: aload 8
    //   5386: ifnonnull +674 -> 6060
    //   5389: aconst_null
    //   5390: astore_3
    //   5391: aload 7
    //   5393: aload_3
    //   5394: putfield 570	com/tencent/component/network/downloader/DownloadReport:dns	Ljava/lang/String;
    //   5397: invokestatic 572	com/tencent/component/network/downloader/impl/a$b:b	()Ljava/lang/String;
    //   5400: pop
    //   5401: aconst_null
    //   5402: invokestatic 216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5405: ifne +9 -> 5414
    //   5408: aload 7
    //   5410: aconst_null
    //   5411: putfield 575	com/tencent/component/network/downloader/DownloadReport:remoteAddress	Ljava/lang/String;
    //   5414: aload 7
    //   5416: aconst_null
    //   5417: putfield 578	com/tencent/component/network/downloader/DownloadReport:localAddress	Ljava/lang/String;
    //   5420: aload 7
    //   5422: aload_2
    //   5423: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5426: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5429: putfield 579	com/tencent/component/network/downloader/DownloadReport:clientip	Ljava/lang/String;
    //   5432: aload 7
    //   5434: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   5437: aload_0
    //   5438: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   5441: lsub
    //   5442: putfield 582	com/tencent/component/network/downloader/DownloadReport:totaltime	J
    //   5445: aload 7
    //   5447: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   5450: aload_0
    //   5451: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   5454: lsub
    //   5455: aload_2
    //   5456: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5459: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5462: lsub
    //   5463: putfield 585	com/tencent/component/network/downloader/DownloadReport:t_wait	J
    //   5466: aload 7
    //   5468: lload 14
    //   5470: putfield 588	com/tencent/component/network/downloader/DownloadReport:t_prepare	J
    //   5473: aload 7
    //   5475: lconst_0
    //   5476: putfield 591	com/tencent/component/network/downloader/DownloadReport:t_conn	J
    //   5479: aload 7
    //   5481: lconst_0
    //   5482: putfield 594	com/tencent/component/network/downloader/DownloadReport:t_recvrsp	J
    //   5485: aload 7
    //   5487: aload_0
    //   5488: getfield 448	com/tencent/component/network/downloader/impl/e:p	J
    //   5491: putfield 597	com/tencent/component/network/downloader/DownloadReport:t_recvdata	J
    //   5494: aload 7
    //   5496: lconst_0
    //   5497: putfield 600	com/tencent/component/network/downloader/DownloadReport:t_process	J
    //   5500: aload 7
    //   5502: aload_0
    //   5503: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   5506: putfield 603	com/tencent/component/network/downloader/DownloadReport:concurrent	I
    //   5509: aload 7
    //   5511: aload_2
    //   5512: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5515: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5518: putfield 606	com/tencent/component/network/downloader/DownloadReport:content_type	Ljava/lang/String;
    //   5521: aload_2
    //   5522: aload 7
    //   5524: invokevirtual 610	com/tencent/component/network/downloader/DownloadResult:setReport	(Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5527: aload_0
    //   5528: aload_1
    //   5529: aload_2
    //   5530: aload 7
    //   5532: invokevirtual 330	com/tencent/component/network/downloader/impl/e:a	(Lcom/tencent/component/network/utils/thread/ThreadPool$JobContext;Lcom/tencent/component/network/downloader/DownloadResult;Lcom/tencent/component/network/downloader/DownloadReport;)V
    //   5535: aload_0
    //   5536: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   5539: ifnull +15 -> 5554
    //   5542: aload_0
    //   5543: getfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   5546: invokevirtual 615	org/apache/http/client/methods/HttpGet:abort	()V
    //   5549: aload_0
    //   5550: aconst_null
    //   5551: putfield 376	com/tencent/component/network/downloader/impl/e:h	Lorg/apache/http/client/methods/HttpGet;
    //   5554: aload_0
    //   5555: invokevirtual 617	com/tencent/component/network/downloader/impl/e:m	()V
    //   5558: aload 4
    //   5560: athrow
    //   5561: aconst_null
    //   5562: astore 6
    //   5564: goto -646 -> 4918
    //   5567: iconst_0
    //   5568: istore 11
    //   5570: goto -442 -> 5128
    //   5573: aconst_null
    //   5574: astore 6
    //   5576: goto -346 -> 5230
    //   5579: invokestatic 84	com/tencent/component/network/downloader/common/a:b	()Z
    //   5582: ifeq -335 -> 5247
    //   5585: new 88	java/lang/StringBuilder
    //   5588: dup
    //   5589: ldc_w 719
    //   5592: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5595: aload_0
    //   5596: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   5599: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5602: ldc_w 454
    //   5605: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5608: aload 8
    //   5610: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5613: ldc_w 459
    //   5616: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5619: aconst_null
    //   5620: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5623: ldc_w 461
    //   5626: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5629: aconst_null
    //   5630: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5633: ldc_w 463
    //   5636: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5639: invokestatic 135	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5642: invokevirtual 138	java/lang/Thread:getId	()J
    //   5645: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5648: ldc_w 465
    //   5651: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5654: invokestatic 122	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   5657: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5660: ldc_w 467
    //   5663: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5666: aload_0
    //   5667: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   5670: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5673: ldc_w 472
    //   5676: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5679: aload_0
    //   5680: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   5683: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5686: ldc_w 474
    //   5689: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5692: astore 9
    //   5694: aload_0
    //   5695: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   5698: ifeq +314 -> 6012
    //   5701: aload_0
    //   5702: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   5705: aload_0
    //   5706: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   5709: invokestatic 281	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   5712: astore 6
    //   5714: aload 9
    //   5716: aload 6
    //   5718: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5721: ldc_w 483
    //   5724: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5727: aload_2
    //   5728: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   5731: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   5734: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5737: ldc_w 488
    //   5740: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5743: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   5746: aload_0
    //   5747: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   5750: lsub
    //   5751: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5754: ldc_w 490
    //   5757: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5760: aload_2
    //   5761: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5764: getfield 493	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   5767: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5770: ldc_w 445
    //   5773: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5776: aload_2
    //   5777: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5780: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   5783: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5786: ldc_w 495
    //   5789: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5792: aload_2
    //   5793: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5796: getfield 498	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   5799: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5802: ldc_w 500
    //   5805: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5808: aload_0
    //   5809: invokevirtual 378	com/tencent/component/network/downloader/impl/e:e	()I
    //   5812: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5815: ldc_w 445
    //   5818: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5821: aload_0
    //   5822: invokevirtual 502	com/tencent/component/network/downloader/impl/e:f	()I
    //   5825: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5828: ldc_w 721
    //   5831: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5834: iload 10
    //   5836: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5839: ldc_w 478
    //   5842: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5845: aload_2
    //   5846: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5849: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   5852: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5855: ldc_w 511
    //   5858: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5861: aload_0
    //   5862: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   5865: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5868: ldc_w 515
    //   5871: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5874: astore 6
    //   5876: aload_0
    //   5877: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5880: ifnull +138 -> 6018
    //   5883: aload_0
    //   5884: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   5887: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   5890: istore 11
    //   5892: aload 6
    //   5894: iload 11
    //   5896: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5899: ldc_w 517
    //   5902: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5905: aload_2
    //   5906: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   5909: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   5912: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5915: ldc_w 522
    //   5918: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5921: lload 14
    //   5923: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5926: ldc_w 524
    //   5929: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5932: lconst_0
    //   5933: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5936: ldc_w 526
    //   5939: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5942: ldc_w 528
    //   5945: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5948: aload_0
    //   5949: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   5952: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5955: ldc_w 530
    //   5958: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5961: aload_0
    //   5962: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   5965: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5968: ldc_w 534
    //   5971: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5974: astore 9
    //   5976: aload_0
    //   5977: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5980: ifnull +44 -> 6024
    //   5983: aload_0
    //   5984: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   5987: invokeinterface 542 1 0
    //   5992: astore 6
    //   5994: ldc 86
    //   5996: aload 9
    //   5998: aload 6
    //   6000: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6003: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6006: invokestatic 145	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6009: goto -762 -> 5247
    //   6012: aconst_null
    //   6013: astore 6
    //   6015: goto -301 -> 5714
    //   6018: iconst_0
    //   6019: istore 11
    //   6021: goto -129 -> 5892
    //   6024: aconst_null
    //   6025: astore 6
    //   6027: goto -33 -> 5994
    //   6030: astore 6
    //   6032: ldc 86
    //   6034: ldc_w 723
    //   6037: aload 6
    //   6039: invokestatic 725	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6042: goto -745 -> 5297
    //   6045: astore 6
    //   6047: ldc 86
    //   6049: ldc_w 727
    //   6052: aload 6
    //   6054: invokestatic 725	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6057: goto -710 -> 5347
    //   6060: aload 8
    //   6062: invokevirtual 730	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   6065: astore_3
    //   6066: goto -675 -> 5391
    //   6069: aconst_null
    //   6070: astore 4
    //   6072: goto -2626 -> 3446
    //   6075: iconst_0
    //   6076: istore 11
    //   6078: goto -2422 -> 3656
    //   6081: aconst_null
    //   6082: astore 4
    //   6084: goto -2326 -> 3758
    //   6087: invokestatic 84	com/tencent/component/network/downloader/common/a:b	()Z
    //   6090: ifeq -2316 -> 3774
    //   6093: new 88	java/lang/StringBuilder
    //   6096: dup
    //   6097: ldc_w 719
    //   6100: invokespecial 93	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6103: aload_0
    //   6104: invokevirtual 62	com/tencent/component/network/downloader/impl/e:j	()Ljava/lang/String;
    //   6107: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6110: ldc_w 454
    //   6113: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6116: aload 5
    //   6118: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6121: ldc_w 459
    //   6124: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6127: aconst_null
    //   6128: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6131: ldc_w 461
    //   6134: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6137: aconst_null
    //   6138: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6141: ldc_w 463
    //   6144: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6147: invokestatic 135	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6150: invokevirtual 138	java/lang/Thread:getId	()J
    //   6153: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6156: ldc_w 465
    //   6159: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6162: invokestatic 122	com/tencent/component/network/NetworkManager:getApnValue	()Ljava/lang/String;
    //   6165: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6168: ldc_w 467
    //   6171: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6174: aload_0
    //   6175: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   6178: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6181: ldc_w 472
    //   6184: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6187: aload_0
    //   6188: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   6191: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6194: ldc_w 474
    //   6197: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6200: astore 6
    //   6202: aload_0
    //   6203: getfield 150	com/tencent/component/network/downloader/impl/e:q	Z
    //   6206: ifeq +314 -> 6520
    //   6209: aload_0
    //   6210: getfield 53	com/tencent/component/network/downloader/impl/e:a	Landroid/content/Context;
    //   6213: aload_0
    //   6214: getfield 155	com/tencent/component/network/downloader/impl/e:r	Z
    //   6217: invokestatic 281	com/tencent/component/network/utils/NetworkUtils:getProxy	(Landroid/content/Context;Z)Lcom/tencent/component/network/utils/NetworkUtils$NetworkProxy;
    //   6220: astore 4
    //   6222: aload 6
    //   6224: aload 4
    //   6226: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6229: ldc_w 483
    //   6232: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6235: aload_2
    //   6236: invokevirtual 396	com/tencent/component/network/downloader/DownloadResult:getProcess	()Lcom/tencent/component/network/downloader/DownloadResult$Process;
    //   6239: getfield 486	com/tencent/component/network/downloader/DownloadResult$Process:duration	J
    //   6242: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6245: ldc_w 488
    //   6248: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6251: invokestatic 28	android/os/SystemClock:uptimeMillis	()J
    //   6254: aload_0
    //   6255: getfield 30	com/tencent/component/network/downloader/impl/e:s	J
    //   6258: lsub
    //   6259: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6262: ldc_w 490
    //   6265: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6268: aload_2
    //   6269: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6272: getfield 493	com/tencent/component/network/downloader/DownloadResult$Content:length	J
    //   6275: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6278: ldc_w 445
    //   6281: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6284: aload_2
    //   6285: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6288: getfield 443	com/tencent/component/network/downloader/DownloadResult$Content:size	J
    //   6291: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6294: ldc_w 495
    //   6297: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6300: aload_2
    //   6301: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6304: getfield 498	com/tencent/component/network/downloader/DownloadResult$Content:realsize	J
    //   6307: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6310: ldc_w 500
    //   6313: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6316: aload_0
    //   6317: invokevirtual 378	com/tencent/component/network/downloader/impl/e:e	()I
    //   6320: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6323: ldc_w 445
    //   6326: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6329: aload_0
    //   6330: invokevirtual 502	com/tencent/component/network/downloader/impl/e:f	()I
    //   6333: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6336: ldc_w 721
    //   6339: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6342: iload 10
    //   6344: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6347: ldc_w 478
    //   6350: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6353: aload_2
    //   6354: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6357: getfield 481	com/tencent/component/network/downloader/DownloadResult$Content:type	Ljava/lang/String;
    //   6360: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6363: ldc_w 511
    //   6366: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6369: aload_0
    //   6370: getfield 513	com/tencent/component/network/downloader/impl/e:t	Ljava/lang/String;
    //   6373: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6376: ldc_w 515
    //   6379: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6382: astore 4
    //   6384: aload_0
    //   6385: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6388: ifnull +138 -> 6526
    //   6391: aload_0
    //   6392: getfield 70	com/tencent/component/network/downloader/impl/e:g	Lcom/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo;
    //   6395: getfield 170	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy$StrategyInfo:id	I
    //   6398: istore 11
    //   6400: aload 4
    //   6402: iload 11
    //   6404: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6407: ldc_w 517
    //   6410: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6413: aload_2
    //   6414: invokevirtual 438	com/tencent/component/network/downloader/DownloadResult:getContent	()Lcom/tencent/component/network/downloader/DownloadResult$Content;
    //   6417: getfield 520	com/tencent/component/network/downloader/DownloadResult$Content:clientip	Ljava/lang/String;
    //   6420: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6423: ldc_w 522
    //   6426: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6429: lload 14
    //   6431: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6434: ldc_w 524
    //   6437: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6440: lconst_0
    //   6441: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6444: ldc_w 526
    //   6447: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6450: ldc_w 528
    //   6453: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6456: aload_0
    //   6457: getfield 36	com/tencent/component/network/downloader/impl/e:y	Ljava/lang/String;
    //   6460: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6463: ldc_w 530
    //   6466: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6469: aload_0
    //   6470: invokevirtual 532	com/tencent/component/network/downloader/impl/e:n	()I
    //   6473: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6476: ldc_w 534
    //   6479: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6482: astore 6
    //   6484: aload_0
    //   6485: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   6488: ifnull +44 -> 6532
    //   6491: aload_0
    //   6492: getfield 537	com/tencent/component/network/downloader/impl/e:k	Lcom/tencent/component/network/downloader/impl/a$a;
    //   6495: invokeinterface 542 1 0
    //   6500: astore 4
    //   6502: ldc 86
    //   6504: aload 6
    //   6506: aload 4
    //   6508: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6511: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6514: invokestatic 145	com/tencent/component/network/downloader/common/a:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   6517: goto -2743 -> 3774
    //   6520: aconst_null
    //   6521: astore 4
    //   6523: goto -301 -> 6222
    //   6526: iconst_0
    //   6527: istore 11
    //   6529: goto -129 -> 6400
    //   6532: aconst_null
    //   6533: astore 4
    //   6535: goto -33 -> 6502
    //   6538: astore 4
    //   6540: ldc 86
    //   6542: ldc_w 723
    //   6545: aload 4
    //   6547: invokestatic 725	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6550: goto -2726 -> 3824
    //   6553: astore 4
    //   6555: ldc 86
    //   6557: ldc_w 727
    //   6560: aload 4
    //   6562: invokestatic 725	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   6565: goto -2691 -> 3874
    //   6568: aload 5
    //   6570: invokevirtual 730	com/tencent/component/network/utils/NetworkUtils$DNS:toString	()Ljava/lang/String;
    //   6573: astore_3
    //   6574: goto -2657 -> 3917
    //   6577: astore 4
    //   6579: iconst_0
    //   6580: istore 10
    //   6582: aconst_null
    //   6583: astore 5
    //   6585: aload 6
    //   6587: astore_3
    //   6588: goto -1941 -> 4647
    //   6591: astore 4
    //   6593: aconst_null
    //   6594: astore 5
    //   6596: goto -1949 -> 4647
    //   6599: astore 4
    //   6601: aconst_null
    //   6602: astore 5
    //   6604: goto -1957 -> 4647
    //   6607: astore 4
    //   6609: goto -1962 -> 4647
    //   6612: astore 5
    //   6614: iconst_0
    //   6615: istore 10
    //   6617: aconst_null
    //   6618: astore_3
    //   6619: goto -6402 -> 217
    //   6622: astore 5
    //   6624: iconst_0
    //   6625: istore 10
    //   6627: goto -6410 -> 217
    //   6630: goto -3461 -> 3169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6633	0	this	e
    //   0	6633	1	paramJobContext	com.tencent.component.network.utils.thread.ThreadPool.JobContext
    //   0	6633	2	paramDownloadResult	com.tencent.component.network.downloader.DownloadResult
    //   146	1	3	localObject1	Object
    //   191	1	3	localException1	Exception
    //   203	6	3	localUnknownHostException	UnknownHostException
    //   216	6403	3	localObject2	Object
    //   504	2577	4	localObject3	Object
    //   3085	8	4	localException2	Exception
    //   3100	8	4	localException3	Exception
    //   3444	1145	4	localObject4	Object
    //   4593	8	4	localException4	Exception
    //   4608	8	4	localException5	Exception
    //   4632	927	4	localObject5	Object
    //   6070	464	4	localObject6	Object
    //   6538	8	4	localException6	Exception
    //   6553	8	4	localException7	Exception
    //   6577	1	4	localObject7	Object
    //   6591	1	4	localObject8	Object
    //   6599	1	4	localObject9	Object
    //   6607	1	4	localObject10	Object
    //   143	1	5	localObject11	Object
    //   210	758	5	localThrowable1	Throwable
    //   1708	2203	5	localDNS	com.tencent.component.network.utils.NetworkUtils.DNS
    //   4102	539	5	localThrowable2	Throwable
    //   4645	1958	5	localObject12	Object
    //   6612	1	5	localThrowable3	Throwable
    //   6622	1	5	localThrowable4	Throwable
    //   140	5886	6	localObject13	Object
    //   6030	8	6	localException8	Exception
    //   6045	8	6	localException9	Exception
    //   6200	386	6	localStringBuilder1	StringBuilder
    //   99	5432	7	localDownloadReport	com.tencent.component.network.downloader.DownloadReport
    //   484	5577	8	localObject14	Object
    //   4896	1101	9	localStringBuilder2	StringBuilder
    //   175	6451	10	i	int
    //   21	6507	11	j	int
    //   714	3869	12	k	int
    //   18	86	13	m	int
    //   24	6406	14	l1	long
    //   90	4562	16	l2	long
    //   156	1447	18	l3	long
    //   1598	3	20	l4	long
    //   166	3	22	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   81	87	191	java/lang/Exception
    //   158	168	203	java/net/UnknownHostException
    //   208	210	210	java/lang/Throwable
    //   1155	1201	210	java/lang/Throwable
    //   1201	1313	210	java/lang/Throwable
    //   1313	1328	210	java/lang/Throwable
    //   1333	1345	210	java/lang/Throwable
    //   1349	1357	210	java/lang/Throwable
    //   1361	1389	210	java/lang/Throwable
    //   1392	1416	210	java/lang/Throwable
    //   1419	1499	210	java/lang/Throwable
    //   1499	1559	210	java/lang/Throwable
    //   1559	1600	210	java/lang/Throwable
    //   2601	2613	210	java/lang/Throwable
    //   2308	2335	3085	java/lang/Exception
    //   2358	2385	3100	java/lang/Exception
    //   1642	1651	4102	java/lang/Throwable
    //   1667	1686	4102	java/lang/Throwable
    //   3132	3148	4102	java/lang/Throwable
    //   3148	3169	4102	java/lang/Throwable
    //   4091	4099	4102	java/lang/Throwable
    //   858	885	4593	java/lang/Exception
    //   908	935	4608	java/lang/Exception
    //   208	210	4632	finally
    //   1155	1201	4632	finally
    //   1201	1313	4632	finally
    //   1313	1328	4632	finally
    //   1333	1345	4632	finally
    //   1349	1357	4632	finally
    //   1361	1389	4632	finally
    //   1392	1416	4632	finally
    //   1419	1499	4632	finally
    //   1499	1559	4632	finally
    //   1559	1600	4632	finally
    //   2601	2613	4632	finally
    //   5270	5297	6030	java/lang/Exception
    //   5320	5347	6045	java/lang/Exception
    //   3797	3824	6538	java/lang/Exception
    //   3847	3874	6553	java/lang/Exception
    //   1607	1622	6577	finally
    //   1629	1642	6577	finally
    //   4110	4118	6577	finally
    //   1642	1651	6591	finally
    //   1667	1686	6591	finally
    //   3132	3148	6591	finally
    //   3148	3169	6591	finally
    //   4091	4099	6591	finally
    //   217	226	6599	finally
    //   226	235	6607	finally
    //   1607	1622	6612	java/lang/Throwable
    //   1629	1642	6622	java/lang/Throwable
    //   4110	4118	6622	java/lang/Throwable
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\impl\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */