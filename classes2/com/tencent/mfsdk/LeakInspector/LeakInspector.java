package com.tencent.mfsdk.LeakInspector;

import android.app.Activity;
import android.app.Instrumentation;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.memory.MemoryReporter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.UUID;
import kfy;
import mqq.os.MqqHandler;

public class LeakInspector
{
  private static int jdField_a_of_type_Int = 100;
  private static Instrumentation jdField_a_of_type_AndroidAppInstrumentation;
  private static RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool;
  private static LeakInspector jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector;
  public static final String a = "LeakInspector";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private LeakInspector.InspectorListener jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private LeakInspector(MqqHandler paramMqqHandler, LeakInspector.InspectorListener paramInspectorListener)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener = paramInspectorListener;
  }
  
  private LeakInspector.InspectUUID a(Object paramObject, String paramString)
  {
    LeakInspector.InspectUUID localInspectUUID = (LeakInspector.InspectUUID)jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(LeakInspector.InspectUUID.class);
    localInspectUUID.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramObject);
    localInspectUUID.jdField_a_of_type_ArrayOfChar = UUID.randomUUID().toString().toCharArray();
    localInspectUUID.b = paramString;
    localInspectUUID.jdField_a_of_type_JavaLangString = paramObject.getClass().getSimpleName();
    return localInspectUUID;
  }
  
  public static LeakInspector a()
  {
    return jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector;
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, new Object[] { "afterOnDestroy ", paramActivity.getClass().getSimpleName() });
    }
    ActivityLeakSolution.a(paramActivity);
    ActivityLeakSolution.b(paramActivity);
    ActivityLeakSolution.a(paramActivity);
    try
    {
      a(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("LeakInspector", 2, "afterOnDestroy error", paramActivity);
    }
  }
  
  public static void a(LeakInspector.InspectUUID paramInspectUUID)
  {
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      jdField_a_of_type_JavaUtilArrayList.add(paramInspectUUID);
      return;
    }
  }
  
  public static void a(Object paramObject)
  {
    a(paramObject, "");
  }
  
  public static void a(Object paramObject, String paramString)
  {
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector == null) {
      throw new RuntimeException("Please call initInspector before this");
    }
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener == null) {
      throw new RuntimeException("Please init a listener first!");
    }
    jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector.b(paramObject, paramString);
  }
  
  public static void a(String paramString)
  {
    ArrayList localArrayList = jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < jdField_a_of_type_JavaUtilArrayList.size())
        {
          LeakInspector.InspectUUID localInspectUUID = (LeakInspector.InspectUUID)jdField_a_of_type_JavaUtilArrayList.get(i);
          if (localInspectUUID.b.equals(paramString)) {
            jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.recycle(localInspectUUID);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public static void a(MqqHandler paramMqqHandler, LeakInspector.InspectorListener paramInspectorListener)
  {
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector != null) {
      throw new RuntimeException("Oh man, this only can be called once.");
    }
    jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector = new LeakInspector(paramMqqHandler, paramInspectorListener);
    jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(LeakInspector.InspectUUID.class, 20);
  }
  
  private void b(Object paramObject, String paramString)
  {
    if (jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector.jdField_a_of_type_ComTencentMfsdkLeakInspectorLeakInspector$InspectorListener.a(paramObject)) {}
    while (!MemoryReporter.a().a) {
      return;
    }
    paramObject = new kfy(this, a(paramObject, paramString), 0);
    this.jdField_a_of_type_MqqOsMqqHandler.post((Runnable)paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\LeakInspector\LeakInspector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */