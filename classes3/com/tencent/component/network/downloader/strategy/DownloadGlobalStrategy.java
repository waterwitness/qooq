package com.tencent.component.network.downloader.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Process;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.utils.Base64;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadGlobalStrategy
{
  public static final StrategyInfo Strategy_BACKUPIP = new StrategyInfo(4, false, false, true);
  public static final StrategyInfo Strategy_DOMAIN_FORCE = new StrategyInfo(5, false, false, false, true);
  public static final StrategyInfo Strategy_DomainDirect = new StrategyInfo(1, false, false, false);
  public static final StrategyInfo Strategy_DomainProxy_CON;
  public static final StrategyInfo Strategy_DomainProxy_SYS = new StrategyInfo(2, true, false, false);
  private static ArrayList<StrategyInfo> a = new ArrayList();
  private static ArrayList<StrategyInfo> b = new ArrayList();
  private static ArrayList<StrategyInfo> c = new ArrayList();
  private static volatile DownloadGlobalStrategy d = null;
  private static final byte[] e = new byte[0];
  private static Context f;
  private SharedPreferences g;
  private ConcurrentHashMap<String, StrategyInfo> h = new ConcurrentHashMap();
  private PortConfigStrategy i;
  private volatile int j = 0;
  
  static
  {
    Strategy_DomainProxy_CON = new StrategyInfo(3, true, true, false);
  }
  
  private DownloadGlobalStrategy(Context paramContext)
  {
    this.i = DownloaderFactory.getInstance(paramContext).getPortStrategy();
    a.add(Strategy_DomainProxy_CON);
    a.add(Strategy_DomainDirect);
    a.add(Strategy_DomainDirect);
    a.add(Strategy_DOMAIN_FORCE);
    a.add(Strategy_DOMAIN_FORCE);
    a.add(Strategy_BACKUPIP);
    a.add(Strategy_BACKUPIP);
    a.add(Strategy_DomainProxy_SYS);
    b.add(Strategy_DomainProxy_SYS);
    b.add(Strategy_DomainDirect);
    b.add(Strategy_DomainDirect);
    b.add(Strategy_DOMAIN_FORCE);
    b.add(Strategy_DOMAIN_FORCE);
    b.add(Strategy_BACKUPIP);
    b.add(Strategy_BACKUPIP);
    b.add(Strategy_DomainProxy_CON);
    c.add(Strategy_DomainDirect);
    c.add(Strategy_DomainDirect);
    c.add(Strategy_DOMAIN_FORCE);
    c.add(Strategy_DOMAIN_FORCE);
    c.add(Strategy_BACKUPIP);
    c.add(Strategy_BACKUPIP);
    c.add(Strategy_DomainProxy_CON);
    c.add(Strategy_DomainProxy_SYS);
    f = paramContext;
    if (paramContext != null) {
      this.g = f.getSharedPreferences("downloa_stragegy", 0);
    }
    String str;
    if (this.g != null)
    {
      this.h.clear();
      str = this.g.getString("download_best_strategy", null);
      if (str != null) {
        paramContext = localParcel;
      }
    }
    try
    {
      localParcel = com.tencent.component.network.downloader.common.a.a(Base64.decode(str, 0));
      paramContext = localParcel;
      localObject = localParcel;
      localParcel.readMap(this.h, f.getClassLoader());
      if (localParcel != null) {
        localParcel.recycle();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        localObject = paramContext;
        com.tencent.component.network.downloader.common.a.a("DownloadGlobalStrategy", "loadStrategy", localThrowable);
      } while (paramContext == null);
      paramContext.recycle();
      return;
    }
    finally
    {
      if (localObject != null) {
        ((Parcel)localObject).recycle();
      }
    }
  }
  
  private static String a(String paramString1, String paramString2)
  {
    String str = "";
    if ("wifi".equals(paramString2))
    {
      str = NetworkManager.getBSSID();
      if (!TextUtils.isEmpty(str)) {
        break label54;
      }
    }
    label54:
    for (str = "";; str = "_" + str) {
      return paramString1 + "_" + paramString2 + str;
    }
  }
  
  public static DownloadGlobalStrategy getInstance(Context paramContext)
  {
    if (d == null) {}
    synchronized (e)
    {
      if (d == null) {
        d = new DownloadGlobalStrategy(paramContext);
      }
      return d;
    }
  }
  
  public static long getRecentIPValidCacheTime()
  {
    return 259200L;
  }
  
  public StrategyInfo getBestStrategyInfo(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      paramString1 = a(paramString2, NetworkManager.getApnValue());
      StrategyInfo localStrategyInfo = (StrategyInfo)this.h.get(paramString1);
      paramString1 = localStrategyInfo;
      if (localStrategyInfo != null)
      {
        paramString1 = localStrategyInfo;
        if (!localStrategyInfo.isIPValid())
        {
          if (com.tencent.component.network.downloader.common.a.b()) {
            com.tencent.component.network.downloader.common.a.b("DownloadGlobalStrategy", "best strategy invalid! domain:" + paramString2 + " threadId:" + Thread.currentThread().getId());
          }
          paramString1 = null;
        }
      }
      boolean bool1 = com.tencent.component.network.module.a.a.c().a();
      boolean bool2 = com.tencent.component.network.module.a.a.c().b();
      if (paramString1 == null) {}
      for (int k = 0; k == 0; k = 1) {
        return new StrategyInfo(bool1, bool2, false);
      }
    }
  }
  
  public StrategyLib getStrategyLib(String paramString1, String paramString2)
  {
    int m = 80;
    StrategyLib localStrategyLib = new StrategyLib();
    StrategyLib.a(localStrategyLib, getBestStrategyInfo(paramString1, paramString2));
    int k;
    if (!NetworkManager.isWap())
    {
      StrategyLib.a(localStrategyLib, c);
      k = m;
      if (this.i != null)
      {
        k = m;
        if (this.i.supportExtraPort(paramString2))
        {
          k = m;
          if (StrategyLib.a(localStrategyLib) != null)
          {
            k = m;
            if (StrategyLib.a(localStrategyLib).getIPInfo() != null)
            {
              k = m;
              if (StrategyLib.a(localStrategyLib).isIPValid())
              {
                k = StrategyLib.a(localStrategyLib).getIPInfo().port;
                if (com.tencent.component.network.downloader.common.a.a(k)) {
                  break label280;
                }
                k = m;
              }
            }
          }
        }
      }
    }
    label216:
    label280:
    for (;;)
    {
      localStrategyLib.setPort(k);
      if ((StrategyLib.a(localStrategyLib) != null) && (StrategyLib.a(localStrategyLib).getIPInfo() != null) && (StrategyLib.a(localStrategyLib).isIPValid()) && (!TextUtils.isEmpty(StrategyLib.a(localStrategyLib).getIPInfo().ip)))
      {
        if (StrategyLib.a(localStrategyLib).id != Strategy_BACKUPIP.id) {
          break label216;
        }
        localStrategyLib.setBackupIP(StrategyLib.a(localStrategyLib).getIPInfo().ip);
      }
      do
      {
        return localStrategyLib;
        StrategyLib.a(localStrategyLib, a);
        break;
        if (StrategyLib.a(localStrategyLib).id == Strategy_DOMAIN_FORCE.id)
        {
          localStrategyLib.setDnsIP(StrategyLib.a(localStrategyLib).getIPInfo().ip);
          return localStrategyLib;
        }
      } while (StrategyLib.a(localStrategyLib).id != Strategy_DomainDirect.id);
      localStrategyLib.setDirectIP(StrategyLib.a(localStrategyLib).getIPInfo().ip);
      return localStrategyLib;
    }
  }
  
  public void report(Context paramContext, String paramString1, String paramString2, StrategyInfo paramStrategyInfo, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramStrategyInfo == null)) {
      return;
    }
    paramString1 = NetworkManager.getApnValue();
    if (paramString2 != null)
    {
      paramString1 = a(paramString2, paramString1);
      paramString2 = (StrategyInfo)this.h.get(paramString1);
      if (!paramBoolean) {
        break label149;
      }
      if ((!paramStrategyInfo.equals(paramString2)) && (StrategyInfo.compare(paramStrategyInfo, paramString2) >= 0))
      {
        this.h.put(paramString1, paramStrategyInfo);
        this.j += 1;
        saveStrategy();
      }
    }
    for (;;)
    {
      if (this.j > 0) {
        saveStrategy();
      }
      if ((!paramBoolean) || ((paramStrategyInfo.id != Strategy_DomainProxy_CON.id) && (paramStrategyInfo.id != Strategy_DomainProxy_SYS.id))) {
        break;
      }
      com.tencent.component.network.module.a.a.c().a(paramContext, paramStrategyInfo.allowProxy, paramStrategyInfo.useConfigApn);
      return;
      label149:
      if (paramStrategyInfo.equals(paramString2))
      {
        this.h.remove(paramString1);
        this.j += 1;
        saveStrategy();
      }
    }
  }
  
  /* Error */
  public void saveStrategy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 109	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:g	Landroid/content/SharedPreferences;
    //   6: ifnull +14 -> 20
    //   9: aload_0
    //   10: getfield 81	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:j	I
    //   13: istore 5
    //   15: iload 5
    //   17: ifne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 337	com/tencent/component/network/downloader/impl/a:b	()I
    //   26: ifle +11 -> 37
    //   29: aload_0
    //   30: getfield 81	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:j	I
    //   33: iconst_5
    //   34: if_icmplt -14 -> 20
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 81	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:j	I
    //   42: invokestatic 338	com/tencent/component/network/downloader/common/a:a	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc -110
    //   50: ldc_w 340
    //   53: invokestatic 342	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aconst_null
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_1
    //   60: invokestatic 346	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   63: astore_3
    //   64: aload_3
    //   65: astore_1
    //   66: aload_3
    //   67: astore_2
    //   68: aload_3
    //   69: aload_0
    //   70: getfield 79	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:h	Ljava/util/concurrent/ConcurrentHashMap;
    //   73: invokevirtual 350	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   76: aload_3
    //   77: astore_1
    //   78: aload_3
    //   79: astore_2
    //   80: new 158	java/lang/String
    //   83: dup
    //   84: aload_3
    //   85: invokevirtual 354	android/os/Parcel:marshall	()[B
    //   88: iconst_0
    //   89: invokestatic 358	com/tencent/component/network/utils/Base64:encode	([BI)[B
    //   92: invokespecial 361	java/lang/String:<init>	([B)V
    //   95: astore 4
    //   97: aload_3
    //   98: astore_1
    //   99: aload_3
    //   100: astore_2
    //   101: aload_0
    //   102: getfield 109	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:g	Landroid/content/SharedPreferences;
    //   105: invokeinterface 365 1 0
    //   110: ldc 114
    //   112: aload 4
    //   114: invokeinterface 371 3 0
    //   119: invokeinterface 374 1 0
    //   124: pop
    //   125: aload_3
    //   126: ifnull -106 -> 20
    //   129: aload_3
    //   130: invokevirtual 144	android/os/Parcel:recycle	()V
    //   133: goto -113 -> 20
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    //   141: astore_3
    //   142: aload_1
    //   143: astore_2
    //   144: ldc -110
    //   146: ldc_w 375
    //   149: aload_3
    //   150: invokestatic 151	com/tencent/component/network/downloader/common/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_1
    //   154: ifnull -134 -> 20
    //   157: aload_1
    //   158: invokevirtual 144	android/os/Parcel:recycle	()V
    //   161: goto -141 -> 20
    //   164: astore_1
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 144	android/os/Parcel:recycle	()V
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	DownloadGlobalStrategy
    //   59	40	1	localObject1	Object
    //   136	22	1	localObject2	Object
    //   164	10	1	localObject3	Object
    //   57	113	2	localObject4	Object
    //   63	67	3	localParcel	Parcel
    //   141	9	3	localException	Exception
    //   95	18	4	str	String
    //   13	3	5	k	int
    // Exception table:
    //   from	to	target	type
    //   2	15	136	finally
    //   23	37	136	finally
    //   37	56	136	finally
    //   129	133	136	finally
    //   157	161	136	finally
    //   169	173	136	finally
    //   173	175	136	finally
    //   60	64	141	java/lang/Exception
    //   68	76	141	java/lang/Exception
    //   80	97	141	java/lang/Exception
    //   101	125	141	java/lang/Exception
    //   60	64	164	finally
    //   68	76	164	finally
    //   80	97	164	finally
    //   101	125	164	finally
    //   144	153	164	finally
  }
  
  public static class StrategyInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<StrategyInfo> CREATOR = new a();
    private IPInfo a;
    public boolean allowProxy;
    private long b;
    public boolean enableBackupIP;
    public boolean forceDomain = false;
    public int id;
    public DownloadResult result;
    public boolean useConfigApn;
    
    public StrategyInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this(paramInt, paramBoolean1, paramBoolean2, paramBoolean3, false);
    }
    
    public StrategyInfo(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.id = paramInt;
      this.allowProxy = paramBoolean1;
      this.useConfigApn = paramBoolean2;
      this.enableBackupIP = paramBoolean3;
      this.forceDomain = paramBoolean4;
      this.b = System.currentTimeMillis();
      if (this.enableBackupIP) {
        this.allowProxy = false;
      }
      if (!this.allowProxy) {
        this.useConfigApn = false;
      }
      if (equalValue(DownloadGlobalStrategy.Strategy_DomainDirect)) {
        this.id = DownloadGlobalStrategy.Strategy_DomainDirect.id;
      }
      do
      {
        return;
        if (equalValue(DownloadGlobalStrategy.Strategy_DomainProxy_CON))
        {
          this.id = DownloadGlobalStrategy.Strategy_DomainProxy_CON.id;
          return;
        }
        if (equalValue(DownloadGlobalStrategy.Strategy_DomainProxy_SYS))
        {
          this.id = DownloadGlobalStrategy.Strategy_DomainProxy_SYS.id;
          return;
        }
        if (equalValue(DownloadGlobalStrategy.Strategy_BACKUPIP))
        {
          this.id = DownloadGlobalStrategy.Strategy_BACKUPIP.id;
          return;
        }
      } while (!equalValue(DownloadGlobalStrategy.Strategy_DOMAIN_FORCE));
      this.id = DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id;
    }
    
    public StrategyInfo(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.id = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.allowProxy = bool1;
        if (paramParcel.readInt() != 1) {
          break label115;
        }
        bool1 = true;
        label49:
        this.useConfigApn = bool1;
        if (paramParcel.readInt() != 1) {
          break label120;
        }
        bool1 = true;
        label64:
        this.enableBackupIP = bool1;
        if (paramParcel.readInt() != 1) {
          break label125;
        }
      }
      label115:
      label120:
      label125:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.forceDomain = bool1;
        this.a = ((IPInfo)paramParcel.readParcelable(DownloadGlobalStrategy.a().getClassLoader()));
        this.b = paramParcel.readLong();
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label49;
        bool1 = false;
        break label64;
      }
    }
    
    public StrategyInfo(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this(0, paramBoolean1, paramBoolean2, paramBoolean3, false);
    }
    
    public static int compare(StrategyInfo paramStrategyInfo1, StrategyInfo paramStrategyInfo2)
    {
      float f4 = 0.0F;
      float f3 = 0.0F;
      float f1;
      if ((paramStrategyInfo1 != null) && (paramStrategyInfo1.result != null) && (paramStrategyInfo1.result.getProcess().duration > 0L)) {
        if (paramStrategyInfo1.result.getContent().realsize >= 0L) {
          f1 = (float)paramStrategyInfo1.result.getContent().realsize;
        }
      }
      for (f1 /= (float)paramStrategyInfo1.result.getProcess().duration;; f1 = 0.0F)
      {
        float f2 = f4;
        if (paramStrategyInfo2 != null)
        {
          f2 = f4;
          if (paramStrategyInfo2.result != null)
          {
            f2 = f4;
            if (paramStrategyInfo2.result.getProcess().duration > 0L)
            {
              f2 = f3;
              if (paramStrategyInfo2.result.getContent().realsize >= 0L) {
                f2 = (float)paramStrategyInfo2.result.getContent().realsize;
              }
              f2 /= (float)paramStrategyInfo2.result.getProcess().duration;
            }
          }
        }
        com.tencent.component.network.downloader.common.a.c("DownloadGlobalStrategy", "speed1:" + f1 + " speed2:" + f2);
        return (int)(f1 - f2);
        f1 = 0.0F;
        break;
      }
    }
    
    public StrategyInfo clone()
    {
      StrategyInfo localStrategyInfo = new StrategyInfo(this.id, this.allowProxy, this.useConfigApn, this.enableBackupIP);
      if (this.id > 0) {
        localStrategyInfo.id = this.id;
      }
      return localStrategyInfo;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equalValue(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof StrategyInfo))) {
          break;
        }
        paramObject = (StrategyInfo)paramObject;
      } while ((((StrategyInfo)paramObject).forceDomain == this.forceDomain) && (((StrategyInfo)paramObject).allowProxy == this.allowProxy) && (((StrategyInfo)paramObject).enableBackupIP == this.enableBackupIP) && (((StrategyInfo)paramObject).useConfigApn == this.useConfigApn) && (equalWith(((StrategyInfo)paramObject).a, this.a)));
      return false;
      return false;
    }
    
    public boolean equalWith(IPInfo paramIPInfo1, IPInfo paramIPInfo2)
    {
      if (paramIPInfo1 != null) {
        return paramIPInfo1.equals(paramIPInfo2);
      }
      return paramIPInfo2 == null;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof StrategyInfo))) {
          break;
        }
        paramObject = (StrategyInfo)paramObject;
      } while ((((StrategyInfo)paramObject).id == this.id) && (((StrategyInfo)paramObject).allowProxy == this.allowProxy) && (((StrategyInfo)paramObject).enableBackupIP == this.enableBackupIP) && (((StrategyInfo)paramObject).useConfigApn == this.useConfigApn) && (equalWith(((StrategyInfo)paramObject).a, this.a)));
      return false;
      return false;
    }
    
    public IPInfo getIPInfo()
    {
      return this.a;
    }
    
    public long getIPValidTime()
    {
      if (this.id == DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id) {
        return 1800000L;
      }
      return 3600000L;
    }
    
    public boolean isIPValid()
    {
      long l1 = getIPValidTime();
      long l2 = System.currentTimeMillis() - this.b;
      return (l2 >= 0L) && (l2 <= l1);
    }
    
    public void setIPInfo(IPInfo paramIPInfo)
    {
      this.a = paramIPInfo;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("(id:").append(this.id).append(",").append(this.allowProxy).append(",").append(this.useConfigApn).append(",").append(this.enableBackupIP).append(",");
      if (this.a != null) {}
      for (String str = this.a.toString();; str = "N/A") {
        return new String(str + ")");
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeInt(this.id);
      if (this.allowProxy)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.useConfigApn) {
          break label94;
        }
        paramInt = 1;
        label38:
        paramParcel.writeInt(paramInt);
        if (!this.enableBackupIP) {
          break label99;
        }
        paramInt = 1;
        label52:
        paramParcel.writeInt(paramInt);
        if (!this.forceDomain) {
          break label104;
        }
      }
      label94:
      label99:
      label104:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeParcelable(this.a, 0);
        paramParcel.writeLong(this.b);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label38;
        paramInt = 0;
        break label52;
      }
    }
  }
  
  public class StrategyLib
  {
    private ArrayList<DownloadGlobalStrategy.StrategyInfo> a;
    private DownloadGlobalStrategy.StrategyInfo b;
    private String c;
    private String d;
    private String e;
    private int f;
    private DownloadGlobalStrategy.StrategyInfo g;
    private boolean h = true;
    
    public StrategyLib()
    {
      if (this.a == null) {
        if (NetworkManager.isWap()) {
          break label36;
        }
      }
      label36:
      for (this.a = DownloadGlobalStrategy.b();; this.a = DownloadGlobalStrategy.c())
      {
        this.f = 80;
        return;
      }
    }
    
    private void a()
    {
      if (!this.h) {
        return;
      }
      boolean bool1 = com.tencent.component.network.module.a.a.c().a();
      boolean bool2 = com.tencent.component.network.module.a.a.c().b();
      if (!bool1)
      {
        this.a = DownloadGlobalStrategy.b();
        return;
      }
      if (bool2)
      {
        this.a = DownloadGlobalStrategy.c();
        return;
      }
      this.a = DownloadGlobalStrategy.d();
    }
    
    public void addStrategy(List<DownloadGlobalStrategy.StrategyInfo> paramList)
    {
      if ((this.a == null) || (paramList == null)) {
        return;
      }
      this.a.addAll(paramList);
    }
    
    public void copyStrageList()
    {
      if (this.a == null)
      {
        this.a = new ArrayList();
        return;
      }
      this.a = new ArrayList(this.a);
    }
    
    public void enableUpdate(boolean paramBoolean)
    {
      this.h = paramBoolean;
    }
    
    public String getBackupIP()
    {
      return this.d;
    }
    
    public int getBestId()
    {
      if (this.b != null) {
        return this.b.id;
      }
      return 0;
    }
    
    public DownloadGlobalStrategy.StrategyInfo getBestStrategy()
    {
      return this.b;
    }
    
    public String getDirectIP()
    {
      return this.c;
    }
    
    public String getDnsIP()
    {
      return this.e;
    }
    
    public DownloadGlobalStrategy.StrategyInfo getOldStrategyInfo()
    {
      return this.g;
    }
    
    public int getPort()
    {
      return this.f;
    }
    
    public DownloadGlobalStrategy.StrategyInfo getStrategyInfo(int paramInt)
    {
      int j = -1;
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo1;
      if (this.b == null) {
        localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.a.get(i % this.a.size());
      }
      for (;;)
      {
        DownloadGlobalStrategy.StrategyInfo localStrategyInfo2 = localStrategyInfo1;
        if (localStrategyInfo1 == null)
        {
          if (NetworkManager.isWap()) {
            localStrategyInfo2 = (DownloadGlobalStrategy.StrategyInfo)DownloadGlobalStrategy.c().get(0);
          }
        }
        else
        {
          return localStrategyInfo2;
          if (i <= 0)
          {
            localStrategyInfo1 = this.b;
            continue;
          }
          if ((this.b.id != DownloadGlobalStrategy.Strategy_DomainDirect.id) && (this.b.id != DownloadGlobalStrategy.Strategy_BACKUPIP.id) && (this.b.id != DownloadGlobalStrategy.Strategy_DOMAIN_FORCE.id))
          {
            if (i == 1) {
              a();
            }
            paramInt = 0;
            for (;;)
            {
              if (paramInt >= this.a.size()) {
                j = -1;
              }
              do
              {
                if ((i <= 0) || (i > j)) {
                  break label217;
                }
                localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.a.get(i - 1);
                break;
                j = paramInt;
              } while (((DownloadGlobalStrategy.StrategyInfo)this.a.get(paramInt)).id == this.b.id);
              paramInt += 1;
            }
            label217:
            localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.a.get(i % this.a.size());
            continue;
          }
          if (i == 1)
          {
            a();
            return this.b;
          }
          paramInt = 0;
          for (;;)
          {
            if (paramInt >= this.a.size())
            {
              if ((i <= 1) || (i > j)) {
                break label334;
              }
              localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.a.get(i - 2);
              break;
            }
            if (((DownloadGlobalStrategy.StrategyInfo)this.a.get(paramInt)).id == this.b.id) {
              j = paramInt;
            }
            paramInt += 1;
          }
          label334:
          if (i <= j) {
            break label376;
          }
          localStrategyInfo1 = (DownloadGlobalStrategy.StrategyInfo)this.a.get(i % this.a.size());
          continue;
        }
        return (DownloadGlobalStrategy.StrategyInfo)DownloadGlobalStrategy.b().get(0);
        label376:
        localStrategyInfo1 = null;
      }
    }
    
    public List<DownloadGlobalStrategy.StrategyInfo> getStrategyList()
    {
      return this.a;
    }
    
    public int getSuggestMaxTimes()
    {
      if (this.a != null) {
        return this.a.size();
      }
      return 0;
    }
    
    public void setBackupIP(String paramString)
    {
      this.d = paramString;
    }
    
    public void setDirectIP(String paramString)
    {
      this.c = paramString;
    }
    
    public void setDnsIP(String paramString)
    {
      this.e = paramString;
    }
    
    public void setOldStrategyInfo(DownloadGlobalStrategy.StrategyInfo paramStrategyInfo)
    {
      this.g = paramStrategyInfo;
    }
    
    public void setPort(int paramInt)
    {
      this.f = paramInt;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\downloader\strategy\DownloadGlobalStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */