package com.tencent.mobileqq.app;

import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import mqq.os.MqqMessageQueue;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;
import pzn;
import pzo;
import qgz;

public class LooperMonitorHelper
{
  public static int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "AutoMonitor";
  private static AbstractUnifiedMonitor.ThreadMonitorCallback jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback = new pzn();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 100;
  }
  
  public static void a()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(0)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(0);
    UnifiedMonitor.a().setMonitoredThread(0, Looper.getMainLooper().getThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    pzo localpzo = new pzo(0);
    localpzo.a(i, false);
    Looper.getMainLooper().setMessageLogging(localpzo);
    MqqMessageQueue.getSubMainThreadQueue().setMessageLogging(localpzo);
  }
  
  public static void b()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(14)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(14);
    UnifiedMonitor.a().setMonitoredThread(14, Looper.getMainLooper().getThread(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    pzo localpzo = new pzo(14);
    localpzo.a(i, false);
    Looper.getMainLooper().setMessageLogging(localpzo);
  }
  
  public static void c()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(4)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(4);
    UnifiedMonitor.a().setMonitoredThread(4, ThreadManager.b(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    qgz localqgz = new qgz(4, "SubLooper");
    localqgz.a(i, false);
    ThreadManager.b().setMessageLogging(localqgz);
  }
  
  public static void d()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(13)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(13);
    UnifiedMonitor.a().setMonitoredThread(13, ThreadManager.c(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    qgz localqgz = new qgz(13, "RecentLooper");
    localqgz.a(i, false);
    ThreadManager.c().setMessageLogging(localqgz);
  }
  
  public static void e()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(5)) {
      return;
    }
    int i = UnifiedMonitor.a().getThreshold(5);
    UnifiedMonitor.a().setMonitoredThread(5, ThreadManager.a(), jdField_a_of_type_MqqUtilAbstractUnifiedMonitor$ThreadMonitorCallback);
    qgz localqgz = new qgz(5, "FileLooper");
    localqgz.a(i, false);
    ThreadManager.a().setMessageLogging(localqgz);
  }
  
  public static void f()
  {
    if (!UnifiedMonitor.a().whetherReportDuringThisStartup(6))
    {
      ThreadExcutor.a = false;
      return;
    }
    ThreadExcutor.a = true;
    ThreadExcutor.c = UnifiedMonitor.a().getThreshold(6);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\LooperMonitorHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */