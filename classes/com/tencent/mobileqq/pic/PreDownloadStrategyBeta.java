package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.activity.PredownloadTest.ConfigInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.asyncdb.cache.TroopStatisticsCache;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class PreDownloadStrategyBeta
  extends BaseStrategy
  implements DeviceProfileManager.DPCObserver
{
  public static final String A = "xgFlowWasteBalance";
  public static final String B = "requestListOverLimitCount";
  public static final String C = "PicDPy471";
  public static final String D = "AMaxWFlow3G";
  public static final String E = "AMaxPDFlow3G";
  public static final String F = "AFBFlowHit3G";
  public static final String G = "AFBFlowMiss3G";
  public static final String H = "APicAvgSize";
  public static final String I = "APicMaxSize";
  public static final String J = "enablePeakFlow";
  public static final String K = "PeakFlowTimePeriod";
  public static final String L = "PeakFlowMaxPicSize";
  private static final String M = "PIC_TAG_PRELOAD.PreDownloadStrategyBeta";
  public static String h = "PRE_DOWNLOAD_TROOP_STATISTICS_KEY";
  public static String i = "PRE_DOWNLOAD_TROOP_STATISTICS_TIME";
  public static final String j = "4gFlowPre";
  public static final String k = "4gFlowWaste";
  public static final String l = "xgFlowPre";
  public static final String m = "xgFlowWaste";
  public static final String n = "xgPreDownCount";
  public static final String o = "xgHitCount";
  public static final String p = "xgMissCount";
  public static final String q = "xgManulClickCount";
  public static final String r = "wifiPreDownCout";
  public static final String s = "wifiHitCount";
  public static final String t = "wifiMissCount";
  public static final String u = "wifiManulClickCount";
  public static final String v = "accFlowPreTotal";
  public static final String w = "accFlowWasteTotal";
  public static final String x = "accDays";
  public static final String y = "accStartDay";
  public static final String z = "lastDayTime";
  public long A;
  public long B;
  public long C;
  public long D;
  public long E;
  public long F;
  public long G = -1L;
  public long H;
  public long I;
  public long J;
  public long K;
  public long L;
  public long M;
  public long N;
  public long O;
  public long P;
  public long Q;
  public long R;
  public long S;
  public long T;
  public long U = 2147483647L;
  public long V = 2147483647L;
  public long W = 2147483647L;
  public long X = 2147483647L;
  public long Y;
  public long Z;
  public float a;
  public int a;
  public TroopStatisticsCache a;
  private PicStatisticsManager a;
  public AtomicBoolean a;
  public boolean a;
  public long[] a;
  private QQAppInterface b;
  public long m;
  public long n;
  public long o;
  public long p;
  public long q;
  public long r;
  public long s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  public long y;
  public long z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PreDownloadStrategyBeta()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = 100;
  }
  
  private long a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == 0L)
    {
      paramLong = this.q;
      l1 = paramLong;
      if (QLog.isColorLevel())
      {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "picSize==0,fix by pisSizeAvg");
        l1 = paramLong;
      }
    }
    return l1;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramInt == 1)
    {
      l2 = this.E;
      l1 = this.F;
      this.E += paramLong1;
      this.F += paramLong2;
      if (this.E > this.w)
      {
        paramLong1 = this.w;
        this.E = paramLong1;
        if (this.E >= 0L) {
          break label204;
        }
        paramLong1 = 0L;
        label71:
        this.E = paramLong1;
        if (this.F >= 0L) {
          break label212;
        }
      }
      label204:
      label212:
      for (paramLong1 = 0L;; paramLong1 = this.F)
      {
        this.F = paramLong1;
        paramLong2 = this.E;
        paramLong1 = this.F;
        PicPreDownloadUtils.a("4gFlowPre", this.E, false);
        PicPreDownloadUtils.a("4gFlowWaste", this.F, paramBoolean);
        if (QLog.isColorLevel()) {
          Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "updateFlow", "networkType=" + paramInt + ", preFlowPre=" + l2 + " preFlowWaste=" + l1 + "flowPre=" + paramLong2 + ", flowWaste:" + paramLong1);
        }
        return;
        paramLong1 = this.E;
        break;
        paramLong1 = this.E;
        break label71;
      }
    }
    long l2 = this.G;
    long l1 = this.H;
    this.G += paramLong1;
    this.H += paramLong2;
    if (this.G > this.C)
    {
      paramLong1 = this.C;
      label270:
      this.G = paramLong1;
      if (this.G >= 0L) {
        break label350;
      }
      paramLong1 = 0L;
      label286:
      this.G = paramLong1;
      if (this.H >= 0L) {
        break label358;
      }
    }
    label350:
    label358:
    for (paramLong1 = 0L;; paramLong1 = this.H)
    {
      this.H = paramLong1;
      paramLong2 = this.G;
      paramLong1 = this.H;
      PicPreDownloadUtils.a("xgFlowPre", this.G, false);
      PicPreDownloadUtils.a("xgFlowWaste", this.H, paramBoolean);
      break;
      paramLong1 = this.G;
      break label270;
      paramLong1 = this.G;
      break label286;
    }
  }
  
  private void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramInt1, paramInt2, paramMessageForPic.mNotPredownloadReason);
    paramMessageForPic.preDownState = 2;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.Q += 1L;
      PicPreDownloadUtils.a("wifiHitCount", this.Q, true);
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt1 + ",wifiHitCount:" + this.Q + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      paramLong = a(paramLong);
      a(paramInt1, this.n * paramLong / 100L, -paramLong, false);
      this.M += 1L;
      this.J -= paramLong;
      PicPreDownloadUtils.a("accFlowWasteTotal", this.J, false);
      PicPreDownloadUtils.a("xgHitCount", this.M, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + paramInt1 + ",xgHitCount:" + this.M + ",uniseq:" + paramMessageForPic.uniseq);
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "accFlowPreTotal:" + this.I + ",accFlowWasteTotal:" + this.J);
  }
  
  private void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    if (this.b != null)
    {
      PicPreDownloader localPicPreDownloader = this.b.a();
      if (localPicPreDownloader != null)
      {
        if ((paramMessageForPic.mNotPredownloadReason != 0) && (paramMessageForPic.mNotPredownloadReason != 1)) {
          break label166;
        }
        int i1 = localPicPreDownloader.a(paramMessageForPic);
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.e(paramInt1, i1);
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramInt1, i1);
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.c(paramInt1, paramInt2);
      }
    }
    paramMessageForPic.preDownState = 3;
    a(paramMessageForPic);
    if (paramInt1 == 0)
    {
      this.R += 1L;
      PicPreDownloadUtils.a("wifiMissCount", this.R, true);
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt1 + ",wifiMissCount:" + this.R + ",uniseq:" + paramMessageForPic.uniseq);
    }
    label166:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramMessageForPic.preDownNetworkType, paramMessageForPic.mNotPredownloadReason);
      if (paramMessageForPic.mNotPredownloadReason == -1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.c(paramInt1, paramInt2);
      break;
      a(paramInt1, this.o, 0L, false);
      this.N += 1L;
      PicPreDownloadUtils.a("xgMissCount", this.N, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + paramInt1 + ", xgMissCount:" + this.N + ", uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void c(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    paramMessageForPic.preDownState = 5;
    a(paramMessageForPic);
    if (paramInt1 == 0) {
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt1 + ",wifiHitCount:" + this.Q + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      a(paramInt1, this.p, 0L, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + paramInt1 + ",xgHitCount:" + this.M + ",uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void d(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.d(paramInt1, paramInt2);
    paramMessageForPic.preDownState = 6;
    a(paramMessageForPic);
    if (paramInt1 == 0) {
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt1 + ",wifiHitCount:" + this.Q + ",uniseq:" + paramMessageForPic.uniseq);
      }
    }
    do
    {
      return;
      a(paramInt1, this.p, 0L, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + paramInt1 + ",xgHitCount:" + this.M + ", uniseq:" + paramMessageForPic.uniseq);
  }
  
  private void e()
  {
    this.E = PicPreDownloadUtils.a("4gFlowPre", this.w);
    this.F = PicPreDownloadUtils.a("4gFlowWaste", 0L);
    this.G = PicPreDownloadUtils.a("xgFlowPre", this.C);
    this.H = PicPreDownloadUtils.a("xgFlowWaste", 0L);
    this.Q = PicPreDownloadUtils.a("wifiHitCount", this.Q);
    this.R = PicPreDownloadUtils.a("wifiMissCount", this.R);
    this.S = PicPreDownloadUtils.a("wifiManulClickCount", this.S);
    this.P = PicPreDownloadUtils.a("wifiPreDownCout", this.P);
    this.M = PicPreDownloadUtils.a("xgHitCount", this.M);
    this.N = PicPreDownloadUtils.a("xgMissCount", this.N);
    this.O = PicPreDownloadUtils.a("xgManulClickCount", this.O);
    this.L = PicPreDownloadUtils.a("xgPreDownCount", this.L);
    this.I = PicPreDownloadUtils.a("accFlowPreTotal", this.I);
    this.J = PicPreDownloadUtils.a("accFlowWasteTotal", this.J);
    this.T = PicPreDownloadUtils.a("requestListOverLimitCount", this.T);
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "getLocalConfig(): wifiHitCount=" + this.Q + " wifiMissCount=" + this.R + " wifiManulClickCount=" + this.S + " wifiPreDownCout=" + this.P + " _4gFlowPre=" + this.E + " _4gFlowWaste=" + this.F + " xgFlowPre=" + this.G + " xgFlowWaste=" + this.H + " xgHitCount=" + this.M + " xgMissCount=" + this.N + " xgManulClickCount=" + this.O + " xgPreDownCout=" + this.L + " accFlowPreTotal=" + this.I + " accFlowWasteTotal=" + this.J + " requestOverLimitCount=" + this.T);
    }
  }
  
  private void f()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PicPredownloadFlow.name(), "1200|400|1400|400|600|200|700|200");
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initDPCConfig(): PicPredownloadFlow=" + (String)localObject);
    }
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length == 8) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initDPCConfig(): Error, use Server config");
      }
      this.y = PicPreDownloadUtils.a(this.b, "AMaxPDFlow3G", 614400L);
      this.z = PicPreDownloadUtils.a(this.b, "AMaxWFlow3G", 716800L);
      this.A = 0L;
      this.B = 0L;
      this.s = this.y;
      this.u = 0L;
      this.t = this.z;
      this.v = 0L;
      this.w = (this.s + this.u);
      this.x = (this.t + this.v);
      this.C = (this.y + this.A);
      this.D = (this.z + this.B);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initDPCConfig():_4gFlowPreLimit=" + this.s + " _4gFlowWasteLimit=" + this.t + "" + " _4gFlowPreFloatLimit" + this.u + " _4gFlowWasteFloatLimit=" + this.v + " xgFlowPreLimit=" + this.y + " xgFlowWasteLimit=" + this.z + " xgFlowPreFloatLimit=" + this.A + " xgFlowWasteFloatLimit=" + this.B);
      }
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PicPredownloadConfig.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "initDPCConfig(): PicPredownloadConfig=" + (String)localObject);
      }
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        if (!"".equals(localObject))
        {
          localObject = ((String)localObject).split("\\|");
          if (localObject.length >= 4) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initDPCConfig(): PicPredownloadConfig Error, use default config");
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, localException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "initDPCConfig(): troopDefaultCount=" + this.U + ", troopIncreaseCountEnterAIO=" + this.V + ", troopMaxCount=" + this.W + ", troopMinPicSize=" + this.X + ", mRequestListMaxSize=" + this.jdField_a_of_type_Int);
      }
      return;
      this.s = (Integer.valueOf(localObject[0]).intValue() * 1024);
      this.u = (Integer.valueOf(localObject[1]).intValue() * 1024);
      this.t = (Integer.valueOf(localObject[2]).intValue() * 1024);
      this.v = (Integer.valueOf(localObject[3]).intValue() * 1024);
      this.y = (Integer.valueOf(localObject[4]).intValue() * 1024);
      this.A = (Integer.valueOf(localObject[5]).intValue() * 1024);
      this.z = (Integer.valueOf(localObject[6]).intValue() * 1024);
      this.B = (Integer.valueOf(localObject[7]).intValue() * 1024);
      break;
      this.U = Long.parseLong(localObject[0]);
      this.V = Long.parseLong(localObject[1]);
      this.W = Long.parseLong(localObject[2]);
      this.X = (Long.parseLong(localObject[3]) * 1024L);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_Int = Integer.parseInt(localObject[4]);
    }
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1 = super.a(paramLong, paramInt1, paramInt2, paramBoolean);
    if (i1 != 0) {
      paramInt1 = i1;
    }
    do
    {
      boolean bool;
      do
      {
        return paramInt1;
        i1 = 0;
        bool = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
        if (QLog.isColorLevel()) {
          Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "NetworkType:" + paramInt2 + " isInDPCWhiteList:" + bool);
        }
        if (paramInt2 != 0) {
          break;
        }
        paramInt1 = i1;
      } while (!QLog.isColorLevel());
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "Wifi, result=" + 0);
      return 0;
      if ((!bool) || (paramInt2 == 3)) {
        break;
      }
      paramInt1 = i1;
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "InDPCWhiteList, result=" + 0);
    return 0;
    long l3 = a(paramLong);
    long l1;
    label219:
    long l2;
    if (paramBoolean) {
      if (paramInt2 == 1)
      {
        paramLong = this.t;
        if (paramInt2 != 1) {
          break label396;
        }
        l1 = this.E - this.u;
        if (paramInt2 != 1) {
          break label410;
        }
        l2 = this.F;
        label231:
        if ((l1 >= l3) && (l2 + l3 < paramLong)) {
          break label490;
        }
        if (l1 >= l3) {
          break label483;
        }
        i1 = -9;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit", "result:" + i1 + ",FlowWaste +picSize=" + (l2 + l3) + ",FlowWasteLimit：" + paramLong + ",FlowPre:" + l1 + ",picSize:" + l3 + ",FlowWaste:" + l2 + ",uinType:" + paramInt1 + ",networkType:" + paramInt2 + ",isDynamic:" + paramBoolean);
      }
      return i1;
      paramLong = this.z;
      break;
      label396:
      l1 = this.G - this.A;
      break label219;
      label410:
      l2 = this.H;
      break label231;
      if (paramInt2 == 1)
      {
        paramLong = this.x;
        label430:
        if (paramInt2 != 1) {
          break label465;
        }
        l1 = this.E;
        label442:
        if (paramInt2 != 1) {
          break label474;
        }
      }
      label465:
      label474:
      for (l2 = this.F;; l2 = this.H)
      {
        break;
        paramLong = this.D;
        break label430;
        l1 = this.G;
        break label442;
      }
      label483:
      i1 = -10;
      continue;
      label490:
      if ((!paramBoolean) && (l1 - l3 < this.u)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
  }
  
  public PredownloadTest.ConfigInfo a()
  {
    PredownloadTest.ConfigInfo localConfigInfo = new PredownloadTest.ConfigInfo();
    localConfigInfo.a = this.z;
    localConfigInfo.b = this.y;
    localConfigInfo.d = this.G;
    localConfigInfo.c = this.H;
    localConfigInfo.e = this.n;
    localConfigInfo.f = this.o;
    return localConfigInfo;
  }
  
  public HashMap a()
  {
    HashMap localHashMap = new HashMap();
    long l1 = PicPreDownloadUtils.a("4gFlowPre", this.E);
    long l2 = PicPreDownloadUtils.a("4gFlowWaste", this.F);
    long l3 = PicPreDownloadUtils.a("xgFlowPre", this.G);
    long l4 = PicPreDownloadUtils.a("xgFlowWaste", this.H);
    long l5 = PicPreDownloadUtils.a("accFlowPreTotal", this.I);
    long l6 = PicPreDownloadUtils.a("xgPreDownCount", this.L);
    long l7 = PicPreDownloadUtils.a("xgHitCount", this.M);
    long l8 = PicPreDownloadUtils.a("xgMissCount", this.N);
    long l9 = PicPreDownloadUtils.a("wifiPreDownCout", this.P);
    long l10 = PicPreDownloadUtils.a("wifiHitCount", this.Q);
    long l11 = PicPreDownloadUtils.a("wifiMissCount", this.R);
    long l12 = PicPreDownloadUtils.a("xgManulClickCount", this.O);
    long l13 = PicPreDownloadUtils.a("wifiManulClickCount", this.S);
    long l14 = PicPreDownloadUtils.a("requestListOverLimitCount", this.T);
    if (QLog.isColorLevel()) {
      Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "getReportInfo", "\n|- sp4gFlowPre:" + l1 + "\n|- sp4gFlowWaste:" + l2 + "\n|- spXgFlowPre:" + l3 + "\n|-  spXgFlowWaste：" + l4 + "\n|-  spFlowPreTotal:" + l5 + "\n|-  spXgPreDownCount：" + l6 + "\n|-  spXgHitCount:" + l7 + "\n|-  spXgMissCount：" + l8 + "\n|-  spWifiPreDownCount:" + l9 + "\n|-  spWifiHitCount：" + l10 + "\n|-  spWifiMissCount:" + l11 + "\n|-  spXgManulClickCount：" + l12 + "\n|-  spWifiManulClickCount:" + l13 + "\n|-  spRequestOverLimitCount:" + l14);
    }
    localHashMap.put("4gFlowPre", String.valueOf(l1));
    localHashMap.put("4gFlowWaste", String.valueOf(l2));
    localHashMap.put("xgFlowPre", String.valueOf(l3));
    localHashMap.put("xgFlowWaste", String.valueOf(l4));
    if ((l7 != 0L) || (l8 != 0L) || (l6 != 0L))
    {
      localHashMap.put("accFlowPreTotal", String.valueOf(l5));
      localHashMap.put("xgPreDownCount", String.valueOf(l6));
      localHashMap.put("xgHitCount", String.valueOf(l7));
      localHashMap.put("xgMissCount", String.valueOf(l6 - l7));
      localHashMap.put("xgManulClickCount", String.valueOf(l12));
      localHashMap.put("xgFlowWasteBalance", String.valueOf(this.z - l4));
    }
    localHashMap.put("wifiPreDownCout", String.valueOf(l9));
    localHashMap.put("wifiHitCount", String.valueOf(l10));
    localHashMap.put("wifiMissCount", String.valueOf(l11));
    localHashMap.put("wifiManulClickCount", String.valueOf(l13));
    localHashMap.put("requestListOverLimitCount", String.valueOf(this.T));
    return localHashMap;
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt == 0)
    {
      this.P += 1L;
      PicPreDownloadUtils.a("wifiPreDownCout", this.P, true);
    }
    do
    {
      return;
      paramLong = a(paramLong);
      a(paramInt, -paramLong, paramLong, false);
      this.I += paramLong;
      this.J += paramLong;
      this.L += 1L;
      PicPreDownloadUtils.a("accFlowPreTotal", this.I, false);
      PicPreDownloadUtils.a("accFlowWasteTotal", this.J, false);
      PicPreDownloadUtils.a("xgPreDownCount", this.L, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "networkType:" + paramInt + ",wifiPreDownCout:" + this.P + ",xgPreDownCout:" + this.L);
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "accFlowPreTotal:" + this.I + ",accFlowWasteTotal:" + this.J);
  }
  
  public void a(PredownloadTest.ConfigInfo paramConfigInfo)
  {
    if (paramConfigInfo.a != -1L) {
      this.z = paramConfigInfo.a;
    }
    if (paramConfigInfo.b != -1L) {
      this.y = paramConfigInfo.b;
    }
    if (paramConfigInfo.d != -1L)
    {
      this.G = paramConfigInfo.d;
      PicPreDownloadUtils.a("xgFlowPre", this.G, true);
    }
    if (paramConfigInfo.c != -1L)
    {
      this.H = paramConfigInfo.c;
      PicPreDownloadUtils.a("xgFlowWaste", this.H, true);
    }
    if (paramConfigInfo.e != -1L) {
      this.n = paramConfigInfo.e;
    }
    if (paramConfigInfo.f != -1L) {
      this.o = paramConfigInfo.f;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    this.b = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager = ((PicStatisticsManager)this.b.getManager(72));
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache = ((TroopStatisticsCache)this.b.a().a(3));
    f();
    c();
    e();
    long l1 = System.currentTimeMillis();
    if (l1 - PicPreDownloadUtils.a("lastDayTime", 0L) > 86400000L) {
      if (paramQQAppInterface == null) {
        break label140;
      }
    }
    label140:
    for (String str = paramQQAppInterface.a();; str = null)
    {
      PicPreDownloadUtils.a("lastDayTime", l1, true);
      PicReporter.a(str, a());
      d();
      if (paramQQAppInterface != null) {
        ((PicStatisticsManager)paramQQAppInterface.getManager(72)).a();
      }
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "init", "");
      }
      return;
    }
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    PicPreDownloadUtils.a(this.b, paramMessageForPic);
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((paramMessageForPic != null) && (paramMessageForPic.size == 0L) && ((paramMessageForPic.preDownState == 1) || (paramMessageForPic.preDownState == 2) || (paramMessageForPic.preDownState == 3)))
    {
      paramMessageForPic.size = paramLong;
      a(paramMessageForPic);
      if (paramMessageForPic.preDownNetworkType != 0) {
        break label55;
      }
    }
    label55:
    do
    {
      return;
      paramLong = this.q - paramLong;
      a(paramMessageForPic.preDownNetworkType, paramLong, -paramLong, false);
      this.I -= paramLong;
      this.J -= paramLong;
      PicPreDownloadUtils.a("accFlowPreTotal", this.I, false);
      PicPreDownloadUtils.a("accFlowWasteTotal", this.J, true);
    } while (!QLog.isColorLevel());
    Logger.a("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter", "accFlowPreTotal:" + this.I + ",accFlowWasteTotal:" + this.J);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache == null) {}
    TroopStatisticsInfo localTroopStatisticsInfo;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      return;
      localTroopStatisticsInfo = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache.a(paramString);
      if (localTroopStatisticsInfo == null) {
        break label139;
      }
      paramString = Long.valueOf(localTroopStatisticsInfo.count - 1L);
      if (paramString.longValue() >= 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "payPredownloadTroopPicCount troopRemainCount = 0");
    return;
    localTroopStatisticsInfo.count = paramString.longValue();
    for (paramString = localTroopStatisticsInfo;; paramString = localTroopStatisticsInfo)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache.a(paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "payPredownloadTroopPicCount troopRemainCount = " + paramString.count);
      return;
      label139:
      localTroopStatisticsInfo = new TroopStatisticsInfo();
      localTroopStatisticsInfo.troopUin = paramString;
      localTroopStatisticsInfo.count = (this.U - 1L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD_TROOP", "onDpcPullFinished", "try to initDPCConfig again");
      }
      f();
    }
  }
  
  public boolean a(MessageForPic paramMessageForPic)
  {
    if (PicPreDownloadUtils.a(this.b, paramMessageForPic.istroop, paramMessageForPic.frienduin) != 0) {}
    label349:
    for (;;)
    {
      return true;
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPredownloadInPeakFlowTime(): Peek Flow is disable[true]");
          return true;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ArrayOfLong == null) {}
        for (int i1 = 0; (i1 == 0) || ((i1 & 0x1) != 0); i1 = this.jdField_a_of_type_ArrayOfLong.length)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPredownloadInPeakFlowTime():  The length(" + i1 + ") of PeakFlowTimePeriod is error![false]");
          }
          return false;
        }
        int i3 = PicPreDownloadUtils.a();
        int i4 = Calendar.getInstance().get(11);
        int i2 = 0;
        for (;;)
        {
          if (i2 >= i1) {
            break label349;
          }
          if ((i4 >= this.jdField_a_of_type_ArrayOfLong[i2]) && (i4 < this.jdField_a_of_type_ArrayOfLong[(i2 + 1)]))
          {
            if (paramMessageForPic.size > this.Z)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "picSize=" + paramMessageForPic.size + " is larger than PeakFlowMaxPicSize(" + this.Z + ")[false]");
              }
              return false;
            }
            if ((paramMessageForPic.size > this.X) && (i3 == 0))
            {
              if (!a(paramMessageForPic.frienduin)) {
                return false;
              }
              if (!paramMessageForPic.hasBigFile())
              {
                a(paramMessageForPic.frienduin);
                return true;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
              return true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download because the pic.size=" + paramMessageForPic.size + " < troopMinPicSize=" + this.X);
            }
          }
          i2 += 2;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache == null) {}
    do
    {
      do
      {
        return true;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
      return true;
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache.a(paramString);
    } while ((paramString == null) || (paramString.count - 1L >= 0L));
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "don't predownload because troopRemainCount = 0");
    }
    return false;
  }
  
  public boolean[] a(int paramInt1, int paramInt2)
  {
    int i2;
    int i1;
    boolean bool1;
    if ((DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name())) && (paramInt2 != 3))
    {
      i2 = PicPreDownloadUtils.a(0, paramInt1, 0);
      i1 = PicPreDownloadUtils.a(0, paramInt1, 1);
      if ((this.m >> i2 & 1L) != 1L) {
        break label180;
      }
      bool1 = true;
      label52:
      if ((this.m >> i1 & 1L) != 1L) {
        break label186;
      }
    }
    label180:
    label186:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        Logger.a("PIC_TAG_PRELOAD", "isPreDownload", "netWokrType:" + paramInt2 + ",uinType:" + paramInt1 + ",preDownThumb:" + bool1 + ",preDownBig:" + bool2 + ",xGPreDownPolicy:" + this.m);
      }
      return new boolean[] { bool1, bool2 };
      i2 = PicPreDownloadUtils.a(paramInt2, paramInt1, 0);
      i1 = PicPreDownloadUtils.a(paramInt2, paramInt1, 1);
      break;
      bool1 = false;
      break label52;
    }
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager == null) {}
    int i1;
    do
    {
      do
      {
        return;
      } while ((paramMessageForPic.isSendFromLocal()) || (paramMessageForPic.subVersion < 5));
      i1 = PicPreDownloadUtils.a(this.b, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramMessageForPic.preDownState == 1)
      {
        a(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
        return;
      }
      if (paramMessageForPic.preDownState == 0)
      {
        if (a(i1, paramMessageForPic.preDownNetworkType)[1] == 0)
        {
          d(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
          return;
        }
        b(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
        return;
      }
    } while (paramMessageForPic.preDownState != 4);
    c(paramMessageForPic, paramLong, paramMessageForPic.preDownNetworkType, i1);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
    return;
    TroopStatisticsInfo localTroopStatisticsInfo = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache.a(paramString);
    long l1;
    if (localTroopStatisticsInfo != null)
    {
      long l2 = localTroopStatisticsInfo.count + this.V;
      l1 = l2;
      if (l2 > this.W) {
        l1 = this.W;
      }
      localTroopStatisticsInfo.count = l1;
    }
    for (paramString = localTroopStatisticsInfo;; paramString = localTroopStatisticsInfo)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheTroopStatisticsCache.b(paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "increaseTroopCountWhenEnterAIO troopRemainCount=" + l1);
      return;
      l1 = this.U + this.V;
      localTroopStatisticsInfo = new TroopStatisticsInfo();
      localTroopStatisticsInfo.troopUin = paramString;
      localTroopStatisticsInfo.count = l1;
    }
  }
  
  public void c()
  {
    int i1 = 0;
    this.m = PicPreDownloadUtils.a(this.b, "PicDPy471", 1374942199L);
    this.n = PicPreDownloadUtils.a(this.b, "AFBFlowHit3G", 150L);
    this.o = PicPreDownloadUtils.a(this.b, "AFBFlowMiss3G", 40960L);
    this.p = this.o;
    this.q = PicPreDownloadUtils.a(this.b, "APicAvgSize", 71680L);
    this.r = PicPreDownloadUtils.a(this.b, "APicMaxSize", 204800L);
    this.jdField_a_of_type_Boolean = PicPreDownloadUtils.a(this.b, false);
    this.jdField_a_of_type_ArrayOfLong = PicPreDownloadUtils.a(this.b);
    this.Z = PicPreDownloadUtils.a(this.b, "APicMaxSize", 921600L);
    int i2;
    if (QLog.isColorLevel())
    {
      i2 = this.jdField_a_of_type_ArrayOfLong.length;
      if ((i2 != 0) && ((i2 & 0x1) == 0)) {
        break label309;
      }
    }
    for (Object localObject = "Error(Length=" + i2 + ")";; localObject = ((StringBuilder)localObject).toString())
    {
      QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "getServerConfig(): xGPreDownPolicy=" + this.m + " xgFlowHitFeedback=" + this.n + " XgFlowMissFeedback=" + this.o + " XgFlowLeftRightFeddback=" + this.p + " pisSizeAvg=" + this.q + " pisSizeMax=" + this.r + " mEnablePeakFlow=" + this.jdField_a_of_type_Boolean + " mPeakFlowTimePeriod=" + (String)localObject + " mPeakFlowMaxPicSize=" + this.Z);
      return;
      label309:
      localObject = new StringBuilder();
      while (i1 < i2)
      {
        ((StringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[i1])).append("-").append(String.valueOf(this.jdField_a_of_type_ArrayOfLong[(i1 + 1)])).append(" ");
        i1 += 2;
      }
    }
  }
  
  public void d()
  {
    this.T = 0L;
    this.Q = 0L;
    this.R = 0L;
    this.S = 0L;
    this.P = 0L;
    this.F = 0L;
    this.H = 0L;
    this.M = 0L;
    this.N = 0L;
    this.O = 0L;
    this.L = 0L;
    PicPreDownloadUtils.a("requestListOverLimitCount", this.T, false);
    PicPreDownloadUtils.a("wifiHitCount", this.Q, false);
    PicPreDownloadUtils.a("wifiMissCount", this.R, false);
    PicPreDownloadUtils.a("wifiManulClickCount", this.S, false);
    PicPreDownloadUtils.a("wifiPreDownCout", this.P, false);
    PicPreDownloadUtils.a("4gFlowWaste", this.F, false);
    PicPreDownloadUtils.a("xgFlowWaste", this.H, false);
    PicPreDownloadUtils.a("xgHitCount", this.M, false);
    PicPreDownloadUtils.a("xgMissCount", this.N, false);
    PicPreDownloadUtils.a("xgManulClickCount", this.O, false);
    PicPreDownloadUtils.a("xgPreDownCount", this.L, true);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pic\PreDownloadStrategyBeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */