package com.tencent.mfsdk;

import android.app.Application;
import com.tencent.mfsdk.LeakInspector.LeakInspector;
import com.tencent.mfsdk.LeakInspector.LeakInspector.InspectorListener;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mfsdk.reporter.StackObservable;
import com.tencent.mfsdk.reporter.StackObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import mqq.os.MqqHandler;

public class MagnifierSDK
{
  public static int a = 0;
  public static long a = 0L;
  private static MagnifierSDK jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
  private static ReporterMachine jdField_a_of_type_ComTencentMfsdkReporterReporterMachine;
  private static StackObserver jdField_a_of_type_ComTencentMfsdkReporterStackObserver = new StackObserver();
  public static String a;
  public static MqqHandler a;
  public static final int b = 1;
  public static final String b = "MagniFierSDK";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 14;
  private LeakInspector.InspectorListener jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static MagnifierSDK a(MqqHandler paramMqqHandler, int paramInt, String paramString)
  {
    if (jdField_a_of_type_ComTencentMfsdkMagnifierSDK == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMfsdkMagnifierSDK == null)
      {
        jdField_a_of_type_ComTencentMfsdkMagnifierSDK = new MagnifierSDK();
        jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
        jdField_a_of_type_Int = paramInt;
        jdField_a_of_type_JavaLangString = paramString;
      }
      return jdField_a_of_type_ComTencentMfsdkMagnifierSDK;
    }
    finally {}
  }
  
  public static void a(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Application paramApplication)
  {
    if ((this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener != null) && (jdField_a_of_type_MqqOsMqqHandler != null)) {
      LeakInspector.a(jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener);
    }
  }
  
  public void a(LeakInspector.InspectorListener paramInspectorListener)
  {
    this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener = paramInspectorListener;
  }
  
  public boolean a(Application paramApplication)
  {
    if ((jdField_a_of_type_Int <= 0) || (jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_JavaLangString.length() == 0) || (paramApplication == null)) {
      return false;
    }
    jdField_a_of_type_ComTencentMfsdkReporterReporterMachine = ReporterMachine.a(1);
    jdField_a_of_type_ComTencentMfsdkReporterReporterMachine.a();
    a(paramApplication);
    StackObservable.a().addObserver(jdField_a_of_type_ComTencentMfsdkReporterStackObserver);
    return true;
  }
  
  public void b(Application paramApplication)
  {
    paramApplication = DropFrameMonitor.a();
    if (paramApplication != null) {
      paramApplication.a();
    }
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(10)) {
      DropFrameMonitor.a().b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\MagnifierSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */