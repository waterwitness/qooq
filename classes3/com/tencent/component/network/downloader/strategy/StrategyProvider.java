package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.Global;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.component.network.utils.a.e;
import com.tencent.component.network.utils.a.e.a;
import com.tencent.component.network.utils.a.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class StrategyProvider
{
  private static e.a a = new e.a((byte)0);
  private static HttpClient b = null;
  public static IPConfigStrategy backupIPConfigStrategy;
  private static final ThreadLocal<e.b> c = new b();
  public static IPConfigStrategy directIPConfigStrategy;
  public static PortConfigStrategy portConfigStrategy;
  
  private static HttpClient a(e.a parama)
  {
    if (b != null) {
      return b;
    }
    if (parama != null) {}
    for (;;)
    {
      try
      {
        parama = e.a(parama);
        b = parama;
        if ((parama != null) && ((parama instanceof AbstractHttpClient))) {
          ((AbstractHttpClient)parama).setReuseStrategy(new DownloadConnectionReuseStrategy());
        }
        return b;
      }
      finally {}
      parama = a;
    }
  }
  
  public static ExecuteResult exeHttpRequest(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt, RequestProcessor paramRequestProcessor, HttpRequest paramHttpRequest, DownloadResult paramDownloadResult, DownloadReport paramDownloadReport, HttpHost paramHttpHost, e.a parama)
  {
    ExecuteResult localExecuteResult = new ExecuteResult();
    Object localObject6 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    paramHttpRequest = null;
    Object localObject1 = localObject5;
    Object localObject3 = localObject6;
    for (;;)
    {
      try
      {
        paramStrategyLib = generateStrategyInfo(paramString, paramStrategyLib, paramInt);
        if (paramStrategyLib == null)
        {
          localExecuteResult.request = null;
          localExecuteResult.response = null;
          localExecuteResult.strategyInfo = paramStrategyLib;
          return null;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        e.b localb = (e.b)c.get();
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localb.a = paramStrategyLib.allowProxy;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localb.b = paramStrategyLib.useConfigApn;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localb.c = paramHttpHost;
        if (paramStrategyLib == null) {
          break label785;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (paramStrategyLib.getIPInfo() == null) {
          break label785;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (TextUtils.isEmpty(paramStrategyLib.getIPInfo().ip)) {
          break label785;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramHttpHost = paramStrategyLib.getIPInfo().ip;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (com.tencent.component.network.downloader.common.a.e(paramHttpHost) >= 2) {
          break label779;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramInt = com.tencent.component.network.downloader.common.a.d(paramString);
        if (paramInt <= 0) {
          continue;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramStrategyLib.getIPInfo().port = paramInt;
        int i = paramInt;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (!com.tencent.component.network.downloader.common.a.a(paramInt)) {
          i = 80;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        String str = paramHttpHost + ":" + i;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        localObject4 = paramString.replaceFirst(com.tencent.component.network.downloader.common.a.c(paramString), str);
        paramHttpHost = (HttpHost)localObject4;
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        if (com.tencent.component.network.downloader.common.a.b())
        {
          paramHttpRequest = paramStrategyLib;
          localObject1 = localObject5;
          localObject2 = paramStrategyLib;
          localObject3 = localObject6;
          com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy run: " + paramStrategyLib.toString() + " domain:" + str + " url:" + paramString + " threadId:" + Thread.currentThread().getId());
          paramHttpHost = (HttpHost)localObject4;
        }
        localObject4 = paramHttpHost;
        if (paramDownloadReport != null)
        {
          paramHttpRequest = paramStrategyLib;
          localObject1 = localObject5;
          localObject2 = paramStrategyLib;
          localObject3 = localObject6;
          paramDownloadReport.strategyInfo = paramStrategyLib.toString();
          localObject4 = paramHttpHost;
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = localObject5;
        localObject2 = paramStrategyLib;
        localObject3 = localObject6;
        paramDownloadReport = e.a(Global.getContext(), paramString, com.tencent.component.network.downloader.common.a.b(paramString), (String)localObject4, localb);
        if (paramRequestProcessor != null)
        {
          paramHttpRequest = paramStrategyLib;
          localObject1 = paramDownloadReport;
          localObject2 = paramStrategyLib;
          localObject3 = paramDownloadReport;
          paramRequestProcessor.prepareRequest(paramString, paramDownloadReport);
        }
        paramHttpRequest = paramStrategyLib;
        localObject1 = paramDownloadReport;
        localObject2 = paramStrategyLib;
        localObject3 = paramDownloadReport;
        paramString = e.a();
        paramHttpRequest = paramStrategyLib;
        localObject1 = paramDownloadReport;
        localObject2 = paramStrategyLib;
        localObject3 = paramDownloadReport;
        localExecuteResult.context = paramString;
        paramHttpRequest = paramStrategyLib;
        localObject1 = paramDownloadReport;
        localObject2 = paramStrategyLib;
        localObject3 = paramDownloadReport;
        paramString = a(parama).execute(paramDownloadReport, paramString);
        localExecuteResult.request = paramDownloadReport;
        localExecuteResult.response = paramString;
        localExecuteResult.strategyInfo = paramStrategyLib;
      }
      catch (Throwable paramString)
      {
        if (paramDownloadResult == null) {
          continue;
        }
        localObject2 = paramHttpRequest;
        localObject3 = localObject1;
        paramDownloadResult.getStatus().setFailed(paramString);
        localObject2 = paramHttpRequest;
        localObject3 = localObject1;
        localExecuteResult.exception = paramString;
        localExecuteResult.request = ((HttpGet)localObject1);
        localExecuteResult.response = null;
        localExecuteResult.strategyInfo = paramHttpRequest;
        continue;
      }
      finally
      {
        localExecuteResult.request = ((HttpGet)localObject3);
        localExecuteResult.response = null;
        localExecuteResult.strategyInfo = ((DownloadGlobalStrategy.StrategyInfo)localObject2);
      }
      return localExecuteResult;
      paramHttpRequest = paramStrategyLib;
      localObject1 = localObject5;
      localObject2 = paramStrategyLib;
      localObject3 = localObject6;
      paramInt = paramStrategyLib.getIPInfo().port;
      continue;
      label779:
      paramHttpHost = paramString;
      continue;
      label785:
      Object localObject4 = paramString;
    }
  }
  
  public static DownloadGlobalStrategy.StrategyInfo generateStrategyInfo(String paramString, DownloadGlobalStrategy.StrategyLib paramStrategyLib, int paramInt)
  {
    int i = 80;
    if ((TextUtils.isEmpty(paramString)) || (paramStrategyLib == null) || (paramInt < 0)) {
      return null;
    }
    Object localObject = paramStrategyLib.getOldStrategyInfo();
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo = paramStrategyLib.getStrategyInfo(paramInt);
    paramStrategyLib.setOldStrategyInfo(localStrategyInfo);
    if (com.tencent.component.network.downloader.common.a.b()) {
      com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: " + localStrategyInfo.toString() + " currAttempCount:" + paramInt + " best:" + paramStrategyLib.getBestId() + " url:" + paramString + " Apn:" + NetworkManager.getApnValue() + " ISP:" + NetworkManager.getIspType() + " threadid:" + Thread.currentThread().getId());
    }
    String str = com.tencent.component.network.downloader.common.a.b(paramString);
    paramInt = paramStrategyLib.getPort();
    if (!com.tencent.component.network.downloader.common.a.a(paramInt))
    {
      paramStrategyLib.setPort(80);
      paramInt = i;
    }
    for (;;)
    {
      if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == localStrategyInfo.id)
      {
        i = paramInt;
        if (localObject != null)
        {
          i = paramInt;
          if (DownloadGlobalStrategy.Strategy_BACKUPIP.id == ((DownloadGlobalStrategy.StrategyInfo)localObject).id)
          {
            if ((portConfigStrategy == null) || (!portConfigStrategy.supportExtraPort(str))) {
              break label413;
            }
            i = portConfigStrategy.changePort(str, paramInt);
            if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
            {
              if (com.tencent.component.network.downloader.common.a.b()) {
                com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
              }
              return null;
            }
          }
        }
        paramString = paramStrategyLib.getBackupIP();
        if ((backupIPConfigStrategy == null) || (backupIPConfigStrategy.isIPValid(paramString, str))) {
          break label1248;
        }
        paramStrategyLib.setBackupIP(null);
        paramString = backupIPConfigStrategy.resolveIP(str);
        if (!TextUtils.isEmpty(paramString)) {
          paramStrategyLib.setBackupIP(paramString);
        }
      }
      label413:
      label709:
      label1016:
      label1156:
      label1245:
      label1248:
      for (;;)
      {
        if ((paramString == null) || (paramString.equals(paramStrategyLib.getDirectIP())) || (paramString.equals(paramStrategyLib.getDnsIP())))
        {
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
          }
          return null;
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
          }
          return null;
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: backup ip is null. Pass! threadId:" + Thread.currentThread().getId());
          }
          return null;
        }
        paramStrategyLib = localStrategyInfo.clone();
        paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
        return paramStrategyLib;
        if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == localStrategyInfo.id)
        {
          i = paramInt;
          if (localObject != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id == ((DownloadGlobalStrategy.StrategyInfo)localObject).id)
            {
              if ((portConfigStrategy == null) || (!portConfigStrategy.supportExtraPort(str))) {
                break label709;
              }
              i = portConfigStrategy.changePort(str, paramInt);
              if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
              {
                if (com.tencent.component.network.downloader.common.a.b()) {
                  com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                }
                return null;
              }
            }
          }
          paramString = com.tencent.component.network.module.common.a.a().a(str);
          if ((paramString == null) || (paramString.equals(paramStrategyLib.getBackupIP())) || (paramString.equals(paramStrategyLib.getDirectIP())))
          {
            if (com.tencent.component.network.downloader.common.a.b()) {
              com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            }
            return null;
            if (com.tencent.component.network.downloader.common.a.b()) {
              com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            }
            return null;
          }
          paramStrategyLib.setDnsIP(paramString);
          paramStrategyLib = localStrategyInfo.clone();
          paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
          return paramStrategyLib;
        }
        if (DownloadGlobalStrategy.Strategy_DomainDirect.id == localStrategyInfo.id)
        {
          i = paramInt;
          if (localObject != null)
          {
            i = paramInt;
            if (DownloadGlobalStrategy.Strategy_DomainDirect.id == ((DownloadGlobalStrategy.StrategyInfo)localObject).id)
            {
              if ((portConfigStrategy == null) || (!portConfigStrategy.supportExtraPort(str))) {
                break label1016;
              }
              i = portConfigStrategy.changePort(str, paramInt);
              if ((i == paramInt) || (!com.tencent.component.network.downloader.common.a.a(i)))
              {
                if (com.tencent.component.network.downloader.common.a.b()) {
                  com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: Pass! port:" + paramInt + " newport:" + i + " threadId:" + Thread.currentThread().getId());
                }
                return null;
              }
            }
          }
          localObject = paramStrategyLib.getDirectIP();
          paramString = (String)localObject;
          if (directIPConfigStrategy == null) {
            break label1245;
          }
          paramString = (String)localObject;
          if (directIPConfigStrategy.isIPValid((String)localObject, str)) {
            break label1245;
          }
          localObject = directIPConfigStrategy.resolveIP(str);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label1156;
          }
          paramStrategyLib.setDirectIP((String)localObject);
          paramString = (String)localObject;
        }
        for (;;)
        {
          if ((paramString == null) || (paramString.equals(paramStrategyLib.getBackupIP())) || (paramString.equals(paramStrategyLib.getDnsIP())))
          {
            if (com.tencent.component.network.downloader.common.a.b()) {
              com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: Pass! Domain IP 重复. threadId:" + Thread.currentThread().getId());
            }
            return null;
            if (com.tencent.component.network.downloader.common.a.b()) {
              com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: Pass! Not support !80. threadId:" + Thread.currentThread().getId());
            }
            return null;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id != localStrategyInfo.id)
            {
              i = paramInt;
              if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id != localStrategyInfo.id) {
                break;
              }
            }
            paramString = Global.getContext();
            if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == localStrategyInfo.id) {}
            for (boolean bool = true; NetworkUtils.getProxy(paramString, bool) == null; bool = false)
            {
              if (com.tencent.component.network.downloader.common.a.b()) {
                com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: proxy is null. Pass! threadId:" + Thread.currentThread().getId());
              }
              return null;
            }
            return localStrategyInfo;
            if (com.tencent.component.network.downloader.common.a.b()) {
              com.tencent.component.network.downloader.common.a.b("StrategyProvider", "downloader strategy: resolve ip failed! threadId:" + Thread.currentThread().getId());
            }
            paramString = (String)localObject;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id == localStrategyInfo.id) {
              break label1245;
            }
            paramString = (String)localObject;
            if (DownloadGlobalStrategy.Strategy_DomainProxy_CON.id == localStrategyInfo.id) {
              break label1245;
            }
            return null;
          }
          paramStrategyLib = localStrategyInfo.clone();
          paramStrategyLib.setIPInfo(new IPInfo(paramString, i));
          return paramStrategyLib;
        }
      }
    }
  }
  
  public static void onIPDownloadResult(String paramString, IPInfo paramIPInfo, boolean paramBoolean)
  {
    String str = com.tencent.component.network.downloader.common.a.b(paramString);
    if ((TextUtils.isEmpty(str)) || (paramIPInfo == null)) {
      return;
    }
    if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null) {
      DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().onIPAccessResult(str, paramIPInfo.ip, paramBoolean);
    }
    if (DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy() != null) {
      DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy().onIPAccessResult(str, paramIPInfo.ip, paramBoolean);
    }
    DownloadGlobalStrategy.StrategyInfo localStrategyInfo = new DownloadGlobalStrategy.StrategyInfo(false, false, false);
    localStrategyInfo.id = 0;
    localStrategyInfo.setIPInfo(paramIPInfo);
    DownloadGlobalStrategy.getInstance(Global.getContext()).report(Global.getContext(), paramString, str, localStrategyInfo, paramBoolean);
  }
  
  public static List<IPInfo> provideIPList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject2;
    do
    {
      return null;
      localObject2 = com.tencent.component.network.downloader.common.a.b(paramString);
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = DownloadGlobalStrategy.getInstance(Global.getContext()).getBestStrategyInfo(paramString, (String)localObject2);
    int i;
    if ((localObject3 != null) && (((DownloadGlobalStrategy.StrategyInfo)localObject3).getIPInfo() != null) && (((DownloadGlobalStrategy.StrategyInfo)localObject3).isIPValid()))
    {
      paramString = ((DownloadGlobalStrategy.StrategyInfo)localObject3).getIPInfo().ip;
      ((List)localObject1).add(paramString);
      if (((DownloadGlobalStrategy.StrategyInfo)localObject3).getIPInfo().port != 0)
      {
        i = ((DownloadGlobalStrategy.StrategyInfo)localObject3).getIPInfo().port;
        localArrayList2.add(Integer.valueOf(i));
      }
    }
    for (;;)
    {
      if (DownloaderFactory.getInstance(Global.getContext()).getPortStrategy() != null)
      {
        if (localArrayList2.size() <= 0) {
          break label349;
        }
        i = DownloaderFactory.getInstance(Global.getContext()).getPortStrategy().changePort((String)localObject2, ((Integer)localArrayList2.get(0)).intValue());
        if (i != ((Integer)localArrayList2.get(0)).intValue()) {
          localArrayList2.add(Integer.valueOf(i));
        }
      }
      label212:
      if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null)
      {
        localObject3 = DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().resolveIP((String)localObject2);
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equalsIgnoreCase(paramString))) {
          ((List)localObject1).add(localObject3);
        }
      }
      if (DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy() != null)
      {
        localObject2 = DownloaderFactory.getInstance(Global.getContext()).getBackupIpStrategy().resolveIP((String)localObject2);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equalsIgnoreCase(paramString))) {
          ((List)localObject1).add(localObject2);
        }
      }
      paramString = ((List)localObject1).iterator();
      for (;;)
      {
        if (!paramString.hasNext())
        {
          return localArrayList1;
          i = 80;
          break;
          label349:
          localArrayList2.add(Integer.valueOf(80));
          break label212;
        }
        localObject1 = (String)paramString.next();
        localObject2 = localArrayList2.iterator();
        while (((Iterator)localObject2).hasNext()) {
          localArrayList1.add(new IPInfo((String)localObject1, ((Integer)((Iterator)localObject2).next()).intValue()));
        }
      }
      paramString = null;
    }
  }
  
  public static DownloadGlobalStrategy.StrategyLib provideStrategyLib(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = com.tencent.component.network.downloader.common.a.b(paramString);
    return DownloadGlobalStrategy.getInstance(Global.getContext()).getStrategyLib(paramString, str);
  }
  
  public static List<IPInfo> provideVideoIPList(String paramString)
  {
    ArrayList localArrayList = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = localArrayList;
    }
    for (;;)
    {
      return paramString;
      String str = com.tencent.component.network.downloader.common.a.b(paramString);
      paramString = localArrayList;
      if (!TextUtils.isEmpty(str)) {
        localArrayList = new ArrayList();
      }
      try
      {
        if (DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy() != null)
        {
          paramString = DownloaderFactory.getInstance(Global.getContext()).getDirectIpStrategy().resolveVideoIP(str);
          if (paramString != null)
          {
            int i = paramString.size();
            if (i > 0) {
              continue;
            }
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("StrategyProvider", "provide video ip list error = " + paramString.toString());
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static class ExecuteResult
  {
    public HttpContext context;
    public Throwable exception;
    public HttpGet request;
    public HttpResponse response;
    public DownloadGlobalStrategy.StrategyInfo strategyInfo;
  }
  
  public static abstract interface RequestProcessor
  {
    public abstract void prepareRequest(String paramString, HttpRequest paramHttpRequest);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\strategy\StrategyProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */