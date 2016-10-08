package com.tencent.mfsdk.collector;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.Display;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kga;
import kgb;
import kgc;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class DropFrameMonitor
{
  private static final float jdField_a_of_type_Float = 58.0F;
  public static final int a = 0;
  private static DropFrameMonitor jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor;
  public static final String a = "list_conv";
  private static final float jdField_b_of_type_Float = 62.0F;
  public static final int b = 1;
  public static final String b = "list_g_contacts";
  public static final int c = 2;
  public static final String c = "list_a_contacts";
  private static final boolean jdField_c_of_type_Boolean = true;
  public static final int d = 3;
  public static final String d = "list_leba";
  public static final int e = 4;
  public static final String e = "list_aio_";
  public static final int f = 5;
  public static final String f = "list_new_kandian";
  public static final int g = 6;
  public static final String g = "list_subscript";
  public static final int h = 0;
  public static final String h = "qzone_homepage";
  public static final int i = 1;
  private static final String i = "AutoMonitor.DropFrame";
  public static final int j = 1000;
  private static final String j = "last_report_time";
  private long jdField_a_of_type_Long;
  private Choreographer.FrameCallback jdField_a_of_type_AndroidViewChoreographer$FrameCallback;
  private Choreographer jdField_a_of_type_AndroidViewChoreographer;
  private final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool;
  private DropFrameMonitor.MonitorItem jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem;
  private kgc jdField_a_of_type_Kgc;
  private AbstractUnifiedMonitor.ThreadMonitorCallback jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private int k;
  
  public DropFrameMonitor()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(DropFrameMonitor.MonitorItem.class, 4);
    this.jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = new kgb(this);
  }
  
  private float a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    if (Build.VERSION.SDK_INT > 17) {
      return ((DisplayManager)localBaseApplicationImpl.getSystemService("display")).getDisplay(0).getRefreshRate();
    }
    return 60.0F;
  }
  
  private final int a(int paramInt)
  {
    int m = 1;
    if (paramInt <= 0) {
      m = 0;
    }
    while (paramInt == 1) {
      return m;
    }
    if (paramInt < 4) {
      return 2;
    }
    if (paramInt < 8) {
      return 3;
    }
    if (paramInt < 15) {
      return 4;
    }
    return 5;
  }
  
  private final long a(long paramLong)
  {
    return paramLong / 1000000L;
  }
  
  public static DropFrameMonitor a()
  {
    if (jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor == null) {
        jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor = new DropFrameMonitor();
      }
      return jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor;
    }
    finally {}
  }
  
  public static String a(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(paramLong));
  }
  
  private boolean a()
  {
    if (b())
    {
      if (!UnifiedMonitor.a().whetherReportDuringThisStartup(9)) {}
      while (!UnifiedMonitor.a().whetherReportThisTime(9)) {
        return false;
      }
    }
    while ((!c()) || (this.jdField_a_of_type_Kgc == null)) {
      return true;
    }
    return this.jdField_a_of_type_Kgc.a();
  }
  
  private boolean a(long paramLong)
  {
    if (b()) {}
    for (;;)
    {
      return true;
      if (c())
      {
        if (this.jdField_a_of_type_Kgc != null) {}
        for (long l = this.jdField_a_of_type_Kgc.jdField_a_of_type_Int; paramLong <= l; l = 2L) {
          return false;
        }
      }
    }
  }
  
  private final long b(long paramLong)
  {
    return paramLong * 1000L * 1000L;
  }
  
  private boolean b()
  {
    return 1 == BaseApplicationImpl.i;
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem == null)
    {
      this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      this.c = 0L;
    }
  }
  
  private boolean c()
  {
    return 2 == BaseApplicationImpl.i;
  }
  
  public int a()
  {
    if (b()) {
      return UnifiedMonitor.a().getThreshold(9);
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    float f1;
    do
    {
      do
      {
        return;
        if (Build.VERSION.SDK_INT >= 16) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AutoMonitor.DropFrame", 2, "build version is low");
      return;
      f1 = a();
      if ((f1 >= 58.0F) && (f1 <= 62.0F)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AutoMonitor.DropFrame", 2, "refresh rate is valid, " + f1);
    return;
    if (c())
    {
      this.jdField_a_of_type_Kgc = new kgc(null);
      this.jdField_a_of_type_Kgc.jdField_a_of_type_Long = LocalMultiProcConfig.a("last_report_time", 0L);
      this.jdField_a_of_type_Kgc.jdField_b_of_type_Long = (QzoneConfig.a().a("QzoneHomepage", "DropFrame_Interval", 24) * 60 * 60 * 1000);
      this.jdField_a_of_type_Kgc.jdField_a_of_type_Int = QzoneConfig.a().a("QzoneHomepage", "DropFrame_DropCount", 2);
    }
    try
    {
      this.jdField_a_of_type_AndroidViewChoreographer = Choreographer.getInstance();
      this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback = new kga(this);
      this.jdField_b_of_type_Long = ((1.0E9F / f1));
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(long paramLong)
  {
    long l = paramLong - this.c;
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem != null)
    {
      if (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_b_of_type_Long == 0L) {
        this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_b_of_type_Long = paramLong;
      }
    }
    else if ((b()) && (this.jdField_b_of_type_Boolean))
    {
      if ((this.c == 0L) || (l <= this.jdField_a_of_type_Long)) {
        break label220;
      }
      if (UnifiedMonitor.a().whetherReportThisTime(10)) {
        break label183;
      }
      this.k = 0;
    }
    for (;;)
    {
      if (UnifiedMonitor.a().whetherStackEnabled(10)) {
        UnifiedMonitor.a().reportStackIfTimeout(10);
      }
      this.c = paramLong;
      this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      return;
      int m = a((int)((l - this.jdField_b_of_type_Long) / this.jdField_b_of_type_Long));
      Object localObject = this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem;
      ((DropFrameMonitor.MonitorItem)localObject).jdField_a_of_type_Long += 1L;
      localObject = this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_ArrayOfLong;
      localObject[m] += 1L;
      this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.c = paramLong;
      break;
      label183:
      localObject = UnifiedMonitor.a();
      UnifiedMonitor.a().addEvent(10, null, (int)a(paramLong - this.c), this.k, (Map)localObject);
      this.k = 0;
      continue;
      label220:
      if (UnifiedMonitor.a().whetherStackEnabled(10)) {
        UnifiedMonitor.a().notifyNotTimeout(10);
      }
      this.k += 1;
    }
  }
  
  public void a(String paramString)
  {
    if (!a()) {}
    do
    {
      do
      {
        return;
      } while ((!this.jdField_a_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem != null) && (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_JavaLangString.equals(paramString))));
      this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem = ((DropFrameMonitor.MonitorItem)this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(DropFrameMonitor.MonitorItem.class));
      this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_JavaLangString = paramString;
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
    this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    HashMap localHashMap;
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem != null) {
      if (!paramBoolean)
      {
        long l1 = a(this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.c - this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_b_of_type_Long);
        if ((this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_Long > 0L) && (l1 > a()))
        {
          long l2 = (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.c - this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_b_of_type_Long) / this.jdField_b_of_type_Long + 1L - this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_Long;
          if (a(l2))
          {
            if (c()) {}
            localHashMap = new HashMap(10);
            localHashMap.put("dropCount", String.valueOf(l2));
            localHashMap.put("totalMs", String.valueOf(l1));
            localHashMap.put("scene", this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_JavaLangString);
            localHashMap.put("dropTimes", Arrays.toString(this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem.jdField_a_of_type_ArrayOfLong));
            if (!b()) {
              break label239;
            }
            UnifiedMonitor.a().addEvent(9, null, 0, 0, localHashMap);
          }
        }
      }
    }
    label239:
    while (!c())
    {
      this.jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem);
      this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem = null;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      this.c = 0L;
      return;
    }
    localHashMap.put("family", String.valueOf(9));
    localHashMap.put("revision", "229354");
    localHashMap.put("event", "");
    paramString = null;
    if (0 == 0) {
      paramString = "pub";
    }
    localHashMap.put("build_type", paramString);
    if (QLog.isColorLevel()) {}
    for (paramString = "-1";; paramString = String.valueOf(0))
    {
      localHashMap.put("not_reported", paramString);
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "unifiedMonitor", true, 0L, 0L, localHashMap, null);
      if (this.jdField_a_of_type_Kgc == null) {
        break;
      }
      this.jdField_a_of_type_Kgc.a();
      break;
    }
  }
  
  public void b()
  {
    if (!b()) {}
    while ((!UnifiedMonitor.a().whetherReportDuringThisStartup(10)) || (!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMfsdkCollectorDropFrameMonitor$MonitorItem == null)
    {
      this.jdField_a_of_type_AndroidViewChoreographer.removeFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
      this.jdField_a_of_type_AndroidViewChoreographer.postFrameCallback(this.jdField_a_of_type_AndroidViewChoreographer$FrameCallback);
    }
    UnifiedMonitor.a().setMonitoredThread(10, Looper.getMainLooper().getThread(), this.jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    this.jdField_a_of_type_Long = b(UnifiedMonitor.a().getThreshold(10));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mfsdk\collector\DropFrameMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */