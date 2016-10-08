package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import vxu;
import vxv;

public abstract class FaceDecodeTask
{
  public static int a = 0;
  protected static Looper a;
  private static FaceDecodeTask.FaceDecodeThreadInfo jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo;
  protected static Object a;
  private static final String jdField_a_of_type_JavaLangString = "Q.qqhead.FaceDecodeTask";
  public static ArrayList a;
  protected static MqqHandler a;
  protected static vxv[] a;
  protected static int b;
  public static ArrayList b;
  public Bitmap a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public FaceInfo a;
  public WeakReference a;
  public boolean a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Int = 111;
    jdField_b_of_type_Int = 6;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList(100);
  }
  
  public FaceDecodeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.DecodeCompletionListener paramDecodeCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = paramFaceInfo;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDecodeCompletionListener);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public static FaceDecodeTask.FaceDecodeThreadInfo a()
  {
    FaceDecodeTask.FaceDecodeThreadInfo localFaceDecodeThreadInfo = new FaceDecodeTask.FaceDecodeThreadInfo();
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecodeTask", 2, "processor count:" + i);
    }
    if (i >= 4) {}
    do
    {
      return localFaceDecodeThreadInfo;
      localFaceDecodeThreadInfo.jdField_b_of_type_Int = (i + 1);
    } while (i > 2);
    localFaceDecodeThreadInfo.c = 10;
    return localFaceDecodeThreadInfo;
  }
  
  public static FaceDecodeTask a(AppInterface paramAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.DecodeCompletionListener paramDecodeCompletionListener)
  {
    if (paramAppInterface == null) {}
    do
    {
      return null;
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new FaceDecodeTaskImpl((QQAppInterface)paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new NearByFaceDecodeTask((NearbyAppInterface)paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
  }
  
  public static void a(FaceDecodeTask paramFaceDecodeTask)
  {
    
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      jdField_a_of_type_JavaUtilArrayList.add(paramFaceDecodeTask);
      jdField_a_of_type_JavaUtilArrayList.notify();
      return;
    }
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecodeTask", 2, "closeFaceDecodeThread");
    }
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilArrayList != null) {
          jdField_a_of_type_JavaUtilArrayList.clear();
        }
        if (jdField_b_of_type_JavaUtilArrayList != null) {
          jdField_b_of_type_JavaUtilArrayList.clear();
        }
        if (jdField_a_of_type_MqqOsMqqHandler != null) {
          jdField_a_of_type_MqqOsMqqHandler.removeMessages(jdField_a_of_type_Int);
        }
        if (jdField_a_of_type_ArrayOfVxv != null)
        {
          i = 0;
          if (i < jdField_a_of_type_ArrayOfVxv.length)
          {
            if (jdField_a_of_type_ArrayOfVxv[i] == null) {
              break label133;
            }
            jdField_a_of_type_ArrayOfVxv[i].a();
            break label133;
          }
        }
        synchronized (jdField_a_of_type_JavaUtilArrayList)
        {
          jdField_a_of_type_JavaUtilArrayList.notifyAll();
          jdField_a_of_type_ArrayOfVxv = null;
          jdField_a_of_type_AndroidOsLooper = null;
          jdField_a_of_type_MqqOsMqqHandler = null;
          return;
        }
      }
      label133:
      i += 1;
    }
  }
  
  private static void c()
  {
    if (jdField_a_of_type_ArrayOfVxv == null) {
      for (;;)
      {
        int i;
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          if (jdField_a_of_type_ArrayOfVxv == null)
          {
            jdField_a_of_type_AndroidOsLooper = Looper.getMainLooper();
            jdField_a_of_type_MqqOsMqqHandler = new vxu(jdField_a_of_type_AndroidOsLooper);
            String str = BaseApplicationImpl.processName;
            d();
            if (jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo.jdField_b_of_type_Int != Integer.MIN_VALUE) {
              jdField_b_of_type_Int = jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo.jdField_b_of_type_Int;
            }
            if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq"))) {
              jdField_b_of_type_Int = 2;
            }
            jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            jdField_a_of_type_ArrayOfVxv = new vxv[jdField_b_of_type_Int];
            i = 0;
            if (i < jdField_a_of_type_ArrayOfVxv.length)
            {
              jdField_a_of_type_ArrayOfVxv[i] = new vxv(null);
              if (ThreadOptimizer.a().c()) {
                jdField_a_of_type_ArrayOfVxv[i].setPriority(1);
              }
              if (jdField_a_of_type_ArrayOfVxv[i].getState() != Thread.State.NEW) {
                break label210;
              }
              jdField_a_of_type_ArrayOfVxv[i].start();
              bool = true;
              if (!QLog.isColorLevel()) {
                break label215;
              }
              QLog.i("Q.qqhead.FaceDecodeTask", 2, "initFaceDecodeThread, thread isStatusNew=" + bool);
              break label215;
            }
          }
          return;
        }
        label210:
        boolean bool = false;
        continue;
        label215:
        i += 1;
      }
    }
  }
  
  private static void d()
  {
    if (TextUtils.isEmpty(BaseApplicationImpl.processName)) {}
    for (;;)
    {
      return;
      if (BaseApplicationImpl.processName.equals("com.tencent.mobileqq:tool")) {}
      for (jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo = a(); QLog.isColorLevel(); jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo = new FaceDecodeTask.FaceDecodeThreadInfo())
      {
        QLog.i("Q.qqhead.FaceDecodeTask", 2, "initFaceDecodeThreadInfo, maxThreadCount=" + jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo.jdField_b_of_type_Int + ",priority=" + jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo.c);
        return;
      }
    }
  }
  
  public abstract void a();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\FaceDecodeTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */