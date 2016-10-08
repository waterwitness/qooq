package com.tencent.mobileqq.app.automator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mqq.app.Constants.Key;

public class Automator
  extends BusinessHandler
  implements Runnable
{
  public static final int a = 1;
  public static final String a = "QQInitHandler";
  private static ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  public static final boolean a = true;
  public static final int b = 2;
  public static final String b = "acc_info";
  public static final boolean b = false;
  public static final int c = 3;
  public static final String c = "isConvertOldQQHeadOK";
  public static final String d = "isFriendlistok";
  public static final String e = "isTrooplistok";
  public static final int f = 40001;
  public static final String f = "isPublicAccountListOK";
  private static final int g = 3;
  public static final String g = "isDiscussionlistok";
  public static final String h = "isFirstQQInit";
  public long a;
  public SharedPreferences a;
  private LinearGroup jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private LinkedList b;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  private volatile boolean f;
  private int h;
  
  public Automator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 1;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  }
  
  private void a(LinearGroup paramLinearGroup)
  {
    boolean bool = true;
    if ("{82,{4,3,5,6},[11,12,14],17,20,21,56,57,22,41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54,92}".equals(paramLinearGroup.b)) {
      this.jdField_b_of_type_JavaUtilLinkedList.clear();
    }
    do
    {
      if (bool) {
        this.jdField_b_of_type_JavaUtilLinkedList.add(paramLinearGroup);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addWaitingMode_Locked " + paramLinearGroup.b + " " + bool);
      }
      return;
      if ((!"{[13,16],19,21,55,57,86,23,43,33,58,40,89}".equals(paramLinearGroup.b)) && (!"{15,18,21,55,57,24}".equals(paramLinearGroup.b))) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null);
    bool = d();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
    label126:
    if (localIterator.hasNext())
    {
      AsyncStep localAsyncStep = (AsyncStep)localIterator.next();
      if ((!"{82,{4,3,5,6},[11,12,14],17,20,21,56,57,22,41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54,92}".equals(localAsyncStep.b)) && (!localAsyncStep.b.equals(paramLinearGroup.b))) {
        break label244;
      }
      bool = false;
    }
    label244:
    for (;;)
    {
      break label126;
      break;
      if (!"{{4,3,5,6},41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54}".equals(paramLinearGroup.b)) {
        break;
      }
      localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
      bool = true;
      if (localIterator.hasNext())
      {
        if ("{82,{4,3,5,6},[11,12,14],17,20,21,56,57,22,41,42,[76,62,25,10,26,27,28,29,30,32,34,35,37,38,39,40,44,45,47,52,66,90,67,68,69,70,{88,48},50,51,58,60,74,78,64,77,71,84,85,75,79,81,83],54,92}".equals(((AsyncStep)localIterator.next()).b)) {
          bool = false;
        }
        for (;;)
        {
          break;
        }
      }
      break;
    }
  }
  
  public int a()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup, false);
    }
    if (this.f) {
      return 1;
    }
    return -1;
  }
  
  public CheckUpdateItemInterface a(int paramInt)
  {
    return (CheckUpdateItemInterface)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  protected Class a()
  {
    return AutomatorObserver.class;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    a(0, true, null);
  }
  
  public void a(int paramInt, CheckUpdateItemInterface paramCheckUpdateItemInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramCheckUpdateItemInterface);
  }
  
  public void a(AsyncStep arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "start " + ???.b);
    }
    LinearGroup localLinearGroup = (LinearGroup)???;
    synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = localLinearGroup;
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "run " + localLinearGroup.b);
        }
        if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null)
        {
          jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24));
          if (Build.VERSION.SDK_INT > 8) {
            jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.allowCoreThreadTimeOut(true);
          }
        }
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(this);
        return;
      }
      a(localLinearGroup);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    new RuntimeException("WTF");
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_AndroidContentSharedPreferences != null) && (paramBoolean1)) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isFriendlistok", false).commit();
    }
    if (paramLong != 0L) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong(Constants.Key.SvcRegister_timeStamp.toString(), paramLong).commit();
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshAllList isListChanged=").append(paramBoolean1).append(",timeStamp=").append(paramLong).append(",accInfoPref!=null ");
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        bool = true;
      }
      QLog.d("QQInitHandler", 2, bool);
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      localStringBuilder = new StringBuilder().append("{");
      if (!paramBoolean1) {
        break label197;
      }
    }
    label197:
    for (int i = 7;; i = 8)
    {
      a(StepFactory.a(this, i + "}"));
      return;
    }
  }
  
  public void a(AsyncStep[] paramArrayOfAsyncStep)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        this.h -= 1;
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
        {
          if (paramArrayOfAsyncStep != null)
          {
            int j = paramArrayOfAsyncStep.length;
            i = 0;
            if (i < j)
            {
              AsyncStep localAsyncStep = paramArrayOfAsyncStep[i];
              if (!this.jdField_a_of_type_JavaUtilLinkedList.remove(localAsyncStep)) {
                break label91;
              }
              b(localAsyncStep);
              return;
            }
          }
          b((AsyncStep)this.jdField_a_of_type_JavaUtilLinkedList.poll());
        }
        else
        {
          return;
        }
      }
      label91:
      i += 1;
    }
  }
  
  public boolean a()
  {
    if (!StartService.a) {
      return false;
    }
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup);
    }
    return true;
  }
  
  public void b()
  {
    if (!this.f) {}
    for (;;)
    {
      return;
      boolean bool1 = true;
      boolean bool2 = true;
      LinkedList localLinkedList;
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
      {
        localLinkedList = this.jdField_b_of_type_JavaUtilLinkedList;
        bool1 = bool2;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup.a(4);
          bool1 = d();
        }
        if (!bool1) {
          continue;
        }
        a(StepFactory.a(this, "{[13,16],19,21,55,57,86,23,43,33,58,40,89}"));
        return;
      }
      finally {}
    }
  }
  
  protected void b(AsyncStep paramAsyncStep)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.h < 3)
      {
        this.h += 1;
        if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null)
        {
          jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24));
          if (Build.VERSION.SDK_INT > 8) {
            jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.allowCoreThreadTimeOut(true);
          }
        }
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramAsyncStep);
        return;
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramAsyncStep);
    }
  }
  
  public boolean b()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      if (StepFactory.a(localLinearGroup, true) != 0) {}
    }
    while (!this.f)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void c()
  {
    a(StepFactory.a(this, "{15,18,21,55,57,24}"));
  }
  
  public boolean c()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.b(localLinearGroup);
    }
    return true;
  }
  
  public void d()
  {
    a(4, true, null);
  }
  
  public boolean d()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.c(localLinearGroup);
    }
    return true;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onDestroy");
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.h = 0;
    }
    synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
    {
      this.jdField_b_of_type_JavaUtilLinkedList.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup.a(8);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = null;
      }
      this.jdField_a_of_type_Long = 0L;
      return;
      localObject1 = finally;
      throw ((Throwable)localObject1);
    }
  }
  
  public void run()
  {
    int i;
    if (!this.f) {
      i = 0;
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
      {
        if (!this.f)
        {
          i = 1;
          this.f = true;
        }
        if (i != 0) {
          StepFactory.a(this, "2").run();
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
        if (??? != null) {
          ((AsyncStep)???).run();
        }
      }
      synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = ((LinearGroup)this.jdField_b_of_type_JavaUtilLinkedList.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null)
        {
          return;
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\Automator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */