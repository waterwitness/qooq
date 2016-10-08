package com.tencent.mobileqq.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import vzl;

public class ThreadPriorityManager
{
  private static final int jdField_a_of_type_Int = 1;
  private static final long jdField_a_of_type_Long = 30000L;
  private static Handler jdField_a_of_type_AndroidOsHandler = new vzl(Looper.getMainLooper());
  private static LongSparseArray jdField_a_of_type_ComTencentUtilLongSparseArray;
  private static final int b = 2;
  private static int c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    c = 1;
    jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray(40);
  }
  
  public static void a(boolean paramBoolean)
  {
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localHandler.sendEmptyMessage(i);
      return;
    }
  }
  
  private static Thread[] a()
  {
    try
    {
      ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup();
      Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
      localThreadGroup.enumerate(arrayOfThread);
      return arrayOfThread;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadPriorityManager", 2, "", localException);
      }
    }
    return new Thread[0];
  }
  
  private static void c()
  {
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 30000L);
    if (jdField_a_of_type_ComTencentUtilLongSparseArray.a() > 0) {}
    for (;;)
    {
      return;
      Thread[] arrayOfThread = a();
      if (arrayOfThread.length < 2)
      {
        jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        return;
      }
      int j = arrayOfThread.length;
      int i = 0;
      while (i < j)
      {
        Thread localThread = arrayOfThread[i];
        if ((localThread != null) && (localThread.getId() != 1L) && (localThread.isAlive()))
        {
          jdField_a_of_type_ComTencentUtilLongSparseArray.a(localThread.getId(), Integer.valueOf(localThread.getPriority()));
          localThread.setPriority(c);
        }
        i += 1;
      }
    }
  }
  
  private static void d()
  {
    if (jdField_a_of_type_ComTencentUtilLongSparseArray.a() <= 0) {
      return;
    }
    Thread[] arrayOfThread = a();
    int j = arrayOfThread.length;
    int i = 0;
    while (i < j)
    {
      Thread localThread = arrayOfThread[i];
      if ((localThread != null) && (localThread.isAlive()))
      {
        int k = ((Integer)jdField_a_of_type_ComTencentUtilLongSparseArray.a(localThread.getId(), Integer.valueOf(0))).intValue();
        if (k != 0) {
          localThread.setPriority(k);
        }
      }
      i += 1;
    }
    jdField_a_of_type_ComTencentUtilLongSparseArray.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\ThreadPriorityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */