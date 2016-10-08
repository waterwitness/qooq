package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class PttInfoCollector
{
  public static final int A = 5;
  public static final int B = 6;
  public static final int C = 7;
  public static final int D = 8;
  public static final int E = 1;
  public static final int F = 2;
  public static final int G = 3;
  public static final int H = 4;
  static int I = 0;
  static int J = 0;
  static int K = 0;
  public static final int a = 0;
  public static long a = 0L;
  public static final String a;
  static PhantomReference jdField_a_of_type_JavaLangRefPhantomReference;
  static ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private static Random jdField_a_of_type_JavaUtilRandom;
  public static ConcurrentHashMap a;
  public static boolean a = false;
  public static final int b = 1;
  public static long b = 0L;
  public static boolean b = false;
  public static final int c = 2;
  static long jdField_c_of_type_Long = 0L;
  static boolean jdField_c_of_type_Boolean = false;
  public static final int d = 1;
  static long d = 0L;
  public static final int e = 3;
  static long e = 0L;
  public static final int f = 2;
  public static final int g = 4;
  public static final int h = 4;
  public static final int i = 3;
  public static final int j = 2;
  public static final int k = 1;
  public static final int l = 1;
  public static final int m = 2;
  public static final int n = 3;
  public static final int o = 4;
  public static final int p = 5;
  public static final int q = 6;
  public static final int r = 7;
  public static final int s = 1;
  public static final int t = 2;
  public static final int u = 3;
  public static final int v = 4;
  public static final int w = 1;
  public static final int x = 2;
  public static final int y = 3;
  public static final int z = 4;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PttInfoCollector.class.getSimpleName();
    jdField_a_of_type_JavaUtilRandom = new Random();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static final int a(int paramInt1, int paramInt2)
  {
    return (paramInt2 & 0xF) + paramInt1 * 100;
  }
  
  public static void a()
  {
    int i1 = VcSystemInfo.f();
    int i2 = VcSystemInfo.e();
    long l1 = VcSystemInfo.c();
    long l2 = DeviceInfoUtil.c() / 1048576L;
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("cpuArch", String.valueOf(i1));
    localHashMap.put("numCores", String.valueOf(i2));
    localHashMap.put("maxFreq", String.valueOf(l1));
    localHashMap.put("memory", String.valueOf(l2));
    localHashMap.put("param_FailCode", String.valueOf(i1));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttCpuArch", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttLongPressFate2", false, 0L, 0L, localHashMap, "");
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    if (J != 0) {}
    for (long l1 = d / J;; l1 = 0L)
    {
      if (K != 0) {}
      for (long l2 = e / K;; l2 = 0L)
      {
        localHashMap.put("consumePerFrame", String.valueOf(l1));
        localHashMap.put("releasePerGc", String.valueOf(l2));
        localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        if (QLog.isColorLevel())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "reportSoundProcessCost gcCount=" + I + " type=" + paramInt1 + " time" + paramInt2);
          QLog.e(jdField_a_of_type_JavaLangString, 2, "reportSoundProcessCost consume=" + l1 + " release=" + l2);
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttGcCount", true, paramInt2, I, localHashMap, "");
        I = 0;
        jdField_c_of_type_Boolean = false;
        jdField_a_of_type_JavaLangRefReferenceQueue.poll();
        jdField_c_of_type_Long = 0L;
        d = 0L;
        e = 0L;
        J = 0;
        K = 0;
        return;
      }
    }
  }
  
  public static void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    HashMap localHashMap;
    if (Math.abs(jdField_a_of_type_JavaUtilRandom.nextInt() % 100) < 10)
    {
      int i1 = VcSystemInfo.f();
      int i2 = VcSystemInfo.e();
      long l1 = VcSystemInfo.c();
      long l2 = DeviceInfoUtil.c() / 1048576L;
      localHashMap = new HashMap();
      localHashMap.put("cpuArch", String.valueOf(i1));
      localHashMap.put("numCores", String.valueOf(i2));
      localHashMap.put("maxFreq", String.valueOf(l1));
      localHashMap.put("memory", String.valueOf(l2));
      if (paramInt2 <= 2) {
        break label172;
      }
    }
    label172:
    for (boolean bool = b;; bool = jdField_a_of_type_Boolean)
    {
      localHashMap.put("v7so", String.valueOf(bool));
      localHashMap.put("type", String.valueOf(paramInt2));
      localHashMap.put("maxFrameCost", String.valueOf(paramLong2));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttProcessFrameCost", true, paramLong1, paramInt1, localHashMap, "");
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80059B1", "0X80059B1", paramInt, 0, "", "", "", "6.5.5");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      paramInt1 = 9999;
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1D", "0X8005C1D", paramInt1, paramInt2, "", "", "", "6.5.5");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, MessageRecord paramMessageRecord)
  {
    int i1 = 1;
    if (!(paramMessageRecord instanceof MessageForPtt)) {}
    for (;;)
    {
      return;
      if (paramMessageRecord.getPttStreamFlag() != 10001)
      {
        if (!paramMessageRecord.isSend()) {
          break;
        }
        if (((MessageForPtt)paramMessageRecord).voiceChangeFlag == 1) {}
        while ((i1 != 0) && (paramInt == 1001))
        {
          a(paramQQAppInterface, 4);
          return;
          i1 = 0;
        }
      }
    }
    switch (paramInt)
    {
    case 2002: 
    case 2004: 
    default: 
      return;
    case 2001: 
      a(paramQQAppInterface, 2);
      return;
    case 2003: 
      a(paramQQAppInterface, 1);
      return;
    }
    a(paramQQAppInterface, 3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1C", "0X8005C1C", i1 * 10 + paramInt1 * 100 + paramInt2, 0, "", "", "", "6.5.5");
      return;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong)
  {
    for (;;)
    {
      try
      {
        localObject = (Long)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if ((localObject == null) || (((Long)localObject).longValue() <= 0L)) {
          continue;
        }
        if (!paramBoolean1) {
          continue;
        }
        str = "pttSendTotalCost";
      }
      catch (Exception paramString)
      {
        Object localObject;
        String str;
        long l1;
        long l2;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "report sendcost error" + paramString);
        return;
        if (!paramBoolean1) {
          continue;
        }
        continue;
      }
      l1 = SystemClock.uptimeMillis();
      l2 = ((Long)localObject).longValue();
      localObject = new HashMap();
      ((HashMap)localObject).put("isVoiceChange", String.valueOf(paramInt));
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, paramBoolean2, l1 - l2, paramLong, (HashMap)localObject, "");
      if ((!paramBoolean1) || (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
        return;
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      return;
      str = "offlinePttHandleCost";
      continue;
      paramBoolean2 = true;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttDownloadStream2Offline", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  public static void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == 1000L) || (paramLong1 == 1001L) || (paramLong1 == 1002L) || (paramLong1 == 1003L) || (paramLong1 == 1004L) || (paramLong1 == 1005L) || (paramLong1 == 1006L) || (paramLong1 == 1008L) || (paramLong1 == 1009L) || (paramLong1 == 1010L) || (paramLong1 == 1011L) || (paramLong1 == 2800L) || (paramLong1 == 1020L) || (paramLong1 == 1021L) || (paramLong1 == 1022L) || (paramLong1 == 1023L) || (paramLong1 == 1024L) || (paramLong1 == 1025L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(paramLong1));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actAllC2CPttUp", paramBoolean, paramLong2, paramLong3, localHashMap, "");
    }
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    int i1 = 1;
    if (paramString.equals("codecsilk")) {
      if (paramBoolean)
      {
        jdField_a_of_type_Boolean = true;
        i1 = 0;
      }
    }
    for (;;)
    {
      paramString = new HashMap();
      paramString.put("param_FailCode", String.valueOf(i1));
      paramString.put(BaseConstants.RDM_NoChangeFailCode, "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttSoUpdate", false, 0L, 0L, paramString, "");
      return;
      jdField_a_of_type_Boolean = false;
      continue;
      if (paramBoolean)
      {
        b = true;
        i1 = 2;
      }
      else
      {
        i1 = 3;
        b = false;
      }
    }
  }
  
  public static void b()
  {
    c();
    d();
  }
  
  public static void b(int paramInt)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    long l1 = SystemClock.uptimeMillis() - jdField_a_of_type_Long;
    if (l1 > 0L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localStatisticCollector.a("", "PTTCostUntilPrepare", true, l1, paramInt, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "COST : " + l1 + " from : " + paramInt);
      }
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actPttNoRangeFailed", paramBoolean, 0L, 0L, localHashMap, "");
  }
  
  private static void c()
  {
    if (jdField_a_of_type_JavaLangRefReferenceQueue.poll() != null)
    {
      I += 1;
      jdField_c_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "gc occurred:" + I);
      }
    }
    if (!jdField_c_of_type_Boolean)
    {
      jdField_a_of_type_JavaLangRefPhantomReference = new PhantomReference(new Object(), jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "add object enqueue to detect gc");
      }
    }
  }
  
  public static void c(int paramInt)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localStatisticCollector.a("", "PTTStraightRecordCount", false, 0L, 0L, localHashMap, "");
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "pttStraightRecordCount " + paramInt);
    }
  }
  
  private static void d()
  {
    try
    {
      Runtime localRuntime = Runtime.getRuntime();
      long l1 = localRuntime.freeMemory();
      long l2 = localRuntime.totalMemory();
      if (jdField_c_of_type_Long != 0L)
      {
        if (l2 - l1 <= jdField_c_of_type_Long) {
          break label61;
        }
        d += l2 - l1 - jdField_c_of_type_Long;
        J += 1;
      }
      for (;;)
      {
        jdField_c_of_type_Long = l2 - l1;
        return;
        label61:
        e += jdField_c_of_type_Long - (l2 - l1);
        K += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\PttInfoCollector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */