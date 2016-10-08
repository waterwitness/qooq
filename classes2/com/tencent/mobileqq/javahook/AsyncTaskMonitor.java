package com.tencent.mobileqq.javahook;

import android.os.AsyncTask;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import swm;
import swn;

public class AsyncTaskMonitor
{
  public static final String a = "AsyncTaskMonitor";
  private static Map jdField_a_of_type_JavaUtilMap;
  private static Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private static Set b = new HashSet();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    try
    {
      Class localClass1 = Class.forName("com.tencent.image.NativeGifImage$NativeDecodeFrameTask");
      Class localClass2 = Class.forName("com.tencent.image.NativeGifIndex8$NativeDecodeFrameTask");
      Class localClass3 = Class.forName("com.tencent.mobileqq.vas.PendantInfo$DecodeNextFrameTask");
      b.add(localClass1);
      b.add(localClass2);
      b.add(localClass3);
      jdField_a_of_type_JavaUtilMap = new WeakHashMap();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
  }
  
  public static void a() {}
  
  private static void b()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(AsyncTask.class, "executeOnExecutor", new Object[] { Executor.class, Object[].class, new swm() });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
  }
  
  private static void b(AsyncTask paramAsyncTask, AsyncTaskMonitor.AsyncTaskMonitorResult paramAsyncTaskMonitorResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AsyncTask Log : ");
      localStringBuilder.append("class = ").append(paramAsyncTask.getClass().getName()).append(" ; ");
      localStringBuilder.append("thread name = ").append(paramAsyncTaskMonitorResult.jdField_a_of_type_JavaLangString).append(" ; ");
      localStringBuilder.append("wait time = ").append(paramAsyncTaskMonitorResult.b - paramAsyncTaskMonitorResult.jdField_a_of_type_Long).append(" ; ");
      localStringBuilder.append("doInBackground cost time = ").append(paramAsyncTaskMonitorResult.c - paramAsyncTaskMonitorResult.b).append(" ; ");
      QLog.d("AsyncTaskMonitor", 2, localStringBuilder.toString());
    }
  }
  
  private static void b(Class paramClass)
  {
    try
    {
      JavaHookBridge.findAndHookMethod(paramClass, "doInBackground", new Object[] { Object[].class, new swn() });
      return;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\javahook\AsyncTaskMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */