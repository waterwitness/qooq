package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.memory.MemoryReporter;
import com.tencent.mobileqq.app.memory.MemoryReporter.IMemoryListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import pyg;
import pzt;
import pzu;
import pzv;

public class MemoryManager
  implements MemoryReporter.IMemoryListener
{
  private static final byte jdField_a_of_type_Byte = 1;
  private static final long jdField_a_of_type_Long = 1048576L;
  private static MemoryManager jdField_a_of_type_ComTencentMobileqqAppMemoryManager;
  public static final String a = "Q.Memory.MemoryManager";
  private static List jdField_a_of_type_JavaUtilList;
  private static final byte jdField_b_of_type_Byte = 2;
  public static final String b = "com.tencent.process.exit";
  private static List jdField_b_of_type_JavaUtilList;
  private static long jdField_c_of_type_Long = 0L;
  public static final String c = "MemoryInfomation";
  private static List jdField_c_of_type_JavaUtilList;
  public static final String d = "MemoryAlertAutoClear";
  private Object jdField_a_of_type_JavaLangObject;
  private pzu jdField_a_of_type_Pzu;
  private pzv jdField_a_of_type_Pzv;
  private long jdField_b_of_type_Long;
  
  private MemoryManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    MemoryReporter.a().a(this);
  }
  
  public static long a()
  {
    if (jdField_c_of_type_Long > 0L) {
      return jdField_c_of_type_Long;
    }
    long l1 = DeviceInfoUtil.c();
    long l2 = DeviceInfoUtil.d();
    long l3 = (3L * l1 + 7L * l2) / 10L;
    long l4 = DeviceInfoUtil.e();
    if (l3 <= 157286400L) {
      jdField_c_of_type_Long = Math.min(25165824L, l4);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getAvailClassSize, availClassSize=" + jdField_c_of_type_Long / 1048576L + "M, totalMemSize=" + l1 / 1048576L + "M, remainMemSize=" + l2 / 1048576L + "M, availMemSize=" + l3 / 1048576L + "M, classMemSize=" + l4 / 1048576L + "M");
      }
      return jdField_c_of_type_Long;
      if (l3 <= 262144000L) {
        jdField_c_of_type_Long = Math.min(37748736L, l4);
      } else if (l3 <= 419430400L) {
        jdField_c_of_type_Long = Math.min(67108864L, l4);
      } else if (l3 <= 524288000L) {
        jdField_c_of_type_Long = Math.min(134217728L, l4);
      } else {
        jdField_c_of_type_Long = Math.min(268435456L, l4);
      }
    }
  }
  
  public static long a(int paramInt)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        int i = arrayOfMemoryInfo[0].getTotalPss();
        return i * 1024L;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getMemory ex pid=" + paramInt, localException);
      }
    }
    return 62914560L;
  }
  
  public static MemoryManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMemoryManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppMemoryManager == null) {
        jdField_a_of_type_ComTencentMobileqqAppMemoryManager = new MemoryManager();
      }
      return jdField_a_of_type_ComTencentMobileqqAppMemoryManager;
    }
    finally {}
  }
  
  private pzu a()
  {
    if (this.jdField_a_of_type_Pzu == null)
    {
      this.jdField_a_of_type_Pzu = new pzu(this);
      this.jdField_a_of_type_Pzu.a();
    }
    return this.jdField_a_of_type_Pzu;
  }
  
  private boolean a()
  {
    if (Math.abs(System.currentTimeMillis() - this.jdField_b_of_type_Long) >= 300000L)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return true;
    }
    return false;
  }
  
  public void a()
  {
    b();
    c();
  }
  
  public void a(long paramLong)
  {
    if (a())
    {
      int i = BaseApplicationImpl.a.size() * 1 / 4;
      BaseApplicationImpl.a.trimToSize(i);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      pzu localpzu = a();
      localpzu.jdField_a_of_type_Long += paramLong2;
      localpzu.jdField_b_of_type_Long += paramLong1;
      localpzu.jdField_a_of_type_Int += 1;
      localpzu.c();
      return;
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.k)) {}
    while (!MemoryConfigs.a().b) {
      return;
    }
    paramQQAppInterface.a(new pzt(paramQQAppInterface, paramContext, 2));
  }
  
  protected void b()
  {
    Object localObject1 = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    if (this.jdField_a_of_type_Pzv == null)
    {
      this.jdField_a_of_type_Pzv = new pzv(this);
      this.jdField_a_of_type_Pzv.a();
    }
    if (this.jdField_a_of_type_Pzv.jdField_b_of_type_Long == 0L) {
      this.jdField_a_of_type_Pzv.jdField_b_of_type_Long = DeviceInfoUtil.c();
    }
    if (this.jdField_a_of_type_Pzv.jdField_c_of_type_Long == 0L) {
      this.jdField_a_of_type_Pzv.jdField_c_of_type_Long = DeviceInfoUtil.e();
    }
    long l3 = DeviceInfoUtil.d();
    long l4 = a(Process.myPid());
    localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
    long l1;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      for (l1 = 0L;; l1 += a(((ActivityManager.RunningAppProcessInfo)localObject2).pid))
      {
        l2 = l1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        String str = ((ActivityManager.RunningAppProcessInfo)localObject2).processName;
        if ((!str.startsWith("com.tencent.mobileqq")) || (str.equals("com.tencent.mobileqq"))) {
          break label1194;
        }
      }
    }
    long l2 = 0L;
    if ((l3 < 0L) || (l4 < 0L) || (l2 < 0L)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Pzv.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Pzv.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      localObject1 = this.jdField_a_of_type_Pzv;
      ((pzv)localObject1).d = (l3 + ((pzv)localObject1).d);
      localObject1 = this.jdField_a_of_type_Pzv;
      ((pzv)localObject1).e = (l2 + ((pzv)localObject1).e);
      localObject1 = this.jdField_a_of_type_Pzv;
      ((pzv)localObject1).f += l4;
      localObject1 = this.jdField_a_of_type_Pzv;
      ((pzv)localObject1).jdField_a_of_type_Int += 1;
      try
      {
        localObject1 = BaseApplicationImpl.a;
        localObject2 = this.jdField_a_of_type_Pzv;
        ((pzv)localObject2).g += ((MQLruCache)localObject1).maxSize();
        localObject2 = this.jdField_a_of_type_Pzv;
        ((pzv)localObject2).h += ((MQLruCache)localObject1).size();
        localObject2 = this.jdField_a_of_type_Pzv;
        ((pzv)localObject2).jdField_c_of_type_Int += ((MQLruCache)localObject1).hitCount();
        localObject2 = this.jdField_a_of_type_Pzv;
        i = ((pzv)localObject2).jdField_b_of_type_Int;
        ((pzv)localObject2).jdField_b_of_type_Int = (((MQLruCache)localObject1).missCount() + i);
        l1 = System.currentTimeMillis();
        if (l1 - this.jdField_a_of_type_Pzv.jdField_a_of_type_Long <= 86400000L) {
          break label996;
        }
        i = this.jdField_a_of_type_Pzv.jdField_a_of_type_Int;
        localObject1 = new HashMap();
        l2 = this.jdField_a_of_type_Pzv.jdField_b_of_type_Long / 1024L;
        if (l2 <= 0L) {
          throw new IllegalStateException("sysTotalMemory illegal");
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", localIllegalStateException);
        }
        this.jdField_a_of_type_Pzv.b();
        this.jdField_a_of_type_Pzv.c();
        return;
        localIllegalStateException.put("sysTotalMemory", String.valueOf(l2));
        l2 = this.jdField_a_of_type_Pzv.jdField_c_of_type_Long / 1024L;
        if (l2 > 0L) {
          break;
        }
        throw new IllegalStateException("sysClassMemory illegal");
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", localException);
    return;
    localException.put("sysClassMemory", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Pzv.d / (i * 1024);
    if (l2 <= 0L) {
      throw new IllegalStateException("sysAvailableMemory illegal");
    }
    localException.put("sysAvailableMemory", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Pzv.e / (i * 1024);
    if (l2 < 0L) {
      throw new IllegalStateException("qqOtherUsedMemory illegal");
    }
    localException.put("qqOtherUsedMemory", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Pzv.f / (i * 1024);
    if (l2 <= 0L) {
      throw new IllegalStateException("qqUsedMemory illegal");
    }
    localException.put("qqUsedMemory", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Pzv.g / (i * 1024);
    if (l2 < 0L) {
      throw new IllegalStateException("imageCacheMax illegal");
    }
    localException.put("imageCacheMax", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Pzv.h / (i * 1024);
    if (l2 < 0L) {
      throw new IllegalStateException("imageCacheUsed illegal");
    }
    localException.put("imageCacheUsed", String.valueOf(l2));
    l2 = this.jdField_a_of_type_Pzv.jdField_c_of_type_Int / i;
    if (l2 < 0L) {
      throw new IllegalStateException("imageHitCount illegal");
    }
    localException.put("imageHitCount", String.valueOf(l2));
    if (this.jdField_a_of_type_Pzv.jdField_c_of_type_Int + this.jdField_a_of_type_Pzv.jdField_b_of_type_Int != 0) {}
    for (int i = this.jdField_a_of_type_Pzv.jdField_c_of_type_Int * 100 / (this.jdField_a_of_type_Pzv.jdField_c_of_type_Int + this.jdField_a_of_type_Pzv.jdField_b_of_type_Int);; i = 0)
    {
      l2 = i;
      if (l2 < 0L) {
        throw new IllegalStateException("imageHitRate illegal");
      }
      localException.put("imageHitRate", String.valueOf(l2));
      localException.put("guardConfigId", pyg.a().a());
      localException.put("memoryConfigId", MemoryConfigs.a().a);
      localException.put("osVersion", Build.VERSION.RELEASE);
      localException.put("resolution", DeviceInfoUtil.l());
      StatisticCollector.a(BaseApplicationImpl.a()).a(null, "actMemory", true, 0L, 0L, localException, null);
      this.jdField_a_of_type_Pzv.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Pzv.b();
      label996:
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo, startTime=" + this.jdField_a_of_type_Pzv.jdField_a_of_type_Long + ", statCount=" + this.jdField_a_of_type_Pzv.jdField_a_of_type_Int + ", sysTotalMemory=" + this.jdField_a_of_type_Pzv.jdField_b_of_type_Long + ", sysAvailableMemory=" + this.jdField_a_of_type_Pzv.d + ", qqOtherUsedMemory=" + this.jdField_a_of_type_Pzv.e + ", qqUsedMemory=" + this.jdField_a_of_type_Pzv.f + ",imageCacheMax=" + this.jdField_a_of_type_Pzv.g + ",imageCacheUsed=" + this.jdField_a_of_type_Pzv.h + ",imageHitCount=" + this.jdField_a_of_type_Pzv.jdField_c_of_type_Int + ",imageHitTotal=" + (this.jdField_a_of_type_Pzv.jdField_c_of_type_Int + this.jdField_a_of_type_Pzv.jdField_b_of_type_Int));
      }
      this.jdField_a_of_type_Pzv.c();
      return;
      label1194:
      break;
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      pzu localpzu = a();
      localpzu.jdField_c_of_type_Long += paramLong2;
      localpzu.d += paramLong1;
      localpzu.jdField_b_of_type_Int += 1;
      localpzu.c();
      return;
    }
  }
  
  protected void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localpzu = a();
      l1 = System.currentTimeMillis();
      long l2 = localpzu.e;
      if (l1 - l2 > 86400000L) {}
      for (;;)
      {
        try
        {
          i = localpzu.jdField_a_of_type_Int;
          j = localpzu.jdField_b_of_type_Int;
          HashMap localHashMap = new HashMap();
          localHashMap.put("sysTotalMemory", String.valueOf(DeviceInfoUtil.c() / 1024L));
          if (i != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("lowWarningMemory", str);
          if (i != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("lowRemainMemory", str);
          localHashMap.put("lowMemoryCount", String.valueOf(i));
          if (j != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("clearWarningMemory", str);
          if (j != 0) {
            continue;
          }
          str = "0";
          localHashMap.put("clearRemainMemory", str);
          localHashMap.put("clearCount", String.valueOf(j));
          StatisticCollector.a(BaseApplicationImpl.a()).a(null, "LowMemoryStat", true, 0L, 0L, localHashMap, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "reportLowMemory, sysTotalMemory=" + String.valueOf(DeviceInfoUtil.c() / 1024L) + ", lowWarningMemory=" + localpzu.jdField_b_of_type_Long + ", lowRemainMemory=" + localpzu.jdField_a_of_type_Long + ", lowMemoryCount=" + i + ", clearWarningMemory=" + localpzu.d + ", clearRemainMemory=" + localpzu.jdField_c_of_type_Long + ",clearCount=" + j);
          }
        }
        catch (Exception localException)
        {
          int i;
          int j;
          String str;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.Memory.MemoryManager", 2, "reportMemoryInfo exception", localException);
          localpzu.b();
          localpzu.e = l1;
          continue;
          localObject1 = finally;
          throw ((Throwable)localObject1);
        }
        finally
        {
          localpzu.b();
          localpzu.e = l1;
        }
        localpzu.c();
        return;
        str = String.valueOf(localpzu.jdField_b_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localpzu.jdField_a_of_type_Long / (i * 1024));
        continue;
        str = String.valueOf(localpzu.d / (j * 1024));
      }
      l2 = localpzu.jdField_c_of_type_Long / (j * 1024);
      str = String.valueOf(l2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\MemoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */