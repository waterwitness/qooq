package com.tencent.mobileqq.apollo.task;

import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ApolloTaskExecutor
{
  public static final String a = "ApolloTaskExecutor";
  private int jdField_a_of_type_Int;
  public ApolloActionTask a;
  private ITaskStatusChangedCallback jdField_a_of_type_ComTencentMobileqqApolloTaskITaskStatusChangedCallback;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private List jdField_a_of_type_JavaUtilList;
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  
  public ApolloTaskExecutor(ITaskStatusChangedCallback paramITaskStatusChangedCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTaskExecutor", 2, "[ApolloTaskExecutor], this:" + this);
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskITaskStatusChangedCallback = paramITaskStatusChangedCallback;
  }
  
  private ApolloActionTask a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        int i = this.jdField_a_of_type_JavaUtilList.size();
        if (i != 0) {}
      }
      else
      {
        return null;
      }
      ApolloActionTask localApolloActionTask = (ApolloActionTask)this.jdField_a_of_type_JavaUtilList.get(0);
      return localApolloActionTask;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  /* Error */
  private boolean a(int paramInt, ApolloActionTask paramApolloActionTask)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 8
    //   11: iconst_2
    //   12: ldc 91
    //   14: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 56	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   21: invokevirtual 73	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   24: aload_0
    //   25: aload_2
    //   26: iconst_0
    //   27: invokespecial 94	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:a	(Lcom/tencent/mobileqq/apollo/task/ApolloActionTask;Z)Z
    //   30: ifeq +32 -> 62
    //   33: iload 4
    //   35: istore_3
    //   36: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +14 -> 53
    //   42: ldc 8
    //   44: iconst_2
    //   45: ldc 96
    //   47: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: iload 4
    //   52: istore_3
    //   53: aload_0
    //   54: getfield 56	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   57: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   60: iload_3
    //   61: ireturn
    //   62: aload_0
    //   63: getfield 66	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   66: aload_2
    //   67: invokeinterface 100 2 0
    //   72: pop
    //   73: aload_0
    //   74: getfield 61	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   77: iload_1
    //   78: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aload_2
    //   82: invokevirtual 110	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: pop
    //   86: iconst_1
    //   87: istore_3
    //   88: goto -35 -> 53
    //   91: astore_2
    //   92: aload_0
    //   93: getfield 56	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   99: aload_2
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	ApolloTaskExecutor
    //   0	101	1	paramInt	int
    //   0	101	2	paramApolloActionTask	ApolloActionTask
    //   35	53	3	bool1	boolean
    //   1	50	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   24	33	91	finally
    //   36	50	91	finally
    //   62	86	91	finally
  }
  
  private boolean a(ApolloActionTask paramApolloActionTask, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0) || (paramApolloActionTask == null)) {}
    for (;;)
    {
      return false;
      int i = this.jdField_a_of_type_JavaUtilList.size();
      if (paramBoolean) {
        i = 0;
      }
      while (paramApolloActionTask.a.jdField_a_of_type_Long == ((ApolloActionTask)this.jdField_a_of_type_JavaUtilList.get(i)).a.jdField_a_of_type_Long)
      {
        return true;
        i -= 1;
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskITaskStatusChangedCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskITaskStatusChangedCallback.a(paramInt);
    }
  }
  
  /* Error */
  private boolean b(int paramInt, ApolloActionTask paramApolloActionTask)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +11 -> 17
    //   9: ldc 8
    //   11: iconst_2
    //   12: ldc 126
    //   14: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 56	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   21: invokevirtual 73	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   24: aload_0
    //   25: aload_2
    //   26: iconst_1
    //   27: invokespecial 94	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:a	(Lcom/tencent/mobileqq/apollo/task/ApolloActionTask;Z)Z
    //   30: ifeq +32 -> 62
    //   33: iload 4
    //   35: istore_3
    //   36: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +14 -> 53
    //   42: ldc 8
    //   44: iconst_2
    //   45: ldc 96
    //   47: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: iload 4
    //   52: istore_3
    //   53: aload_0
    //   54: getfield 56	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   57: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   60: iload_3
    //   61: ireturn
    //   62: aload_0
    //   63: getfield 66	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   66: iconst_0
    //   67: aload_2
    //   68: invokeinterface 129 3 0
    //   73: aload_0
    //   74: getfield 61	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   77: iload_1
    //   78: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aload_2
    //   82: invokevirtual 110	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   85: pop
    //   86: iconst_1
    //   87: istore_3
    //   88: goto -35 -> 53
    //   91: astore_2
    //   92: aload_0
    //   93: getfield 56	com/tencent/mobileqq/apollo/task/ApolloTaskExecutor:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   99: aload_2
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	ApolloTaskExecutor
    //   0	101	1	paramInt	int
    //   0	101	2	paramApolloActionTask	ApolloActionTask
    //   35	53	3	bool1	boolean
    //   1	50	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   24	33	91	finally
    //   36	50	91	finally
    //   62	86	91	finally
  }
  
  public int a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.jdField_a_of_type_Int += 1;
      return this.jdField_a_of_type_Int;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public ApolloActionTask a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      ApolloActionTask localApolloActionTask = (ApolloActionTask)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      return localApolloActionTask;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTaskExecutor", 2, "[onDestroy].");
    }
    b();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTaskExecutor", 2, "[removeTask]");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      ApolloActionTask localApolloActionTask = (ApolloActionTask)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      if (localApolloActionTask != null)
      {
        this.jdField_a_of_type_JavaUtilList.remove(localApolloActionTask);
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public void a(int paramInt, ApolloActionTask paramApolloActionTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTaskExecutor", 2, "[addTask].");
    }
    if ((paramApolloActionTask == null) || (paramApolloActionTask.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTaskExecutor", 2, "errinfo->null param.");
      }
    }
    do
    {
      do
      {
        return;
        switch (paramApolloActionTask.a.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 0: 
          if (QLog.isColorLevel()) {
            QLog.d("ApolloTaskExecutor", 2, "PLAY_MODE_RIGHT_NOW, Add task to the front of the queue. Start it right now. taskId:" + paramInt);
          }
          break;
        }
      } while (!b(paramInt, paramApolloActionTask));
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionTask != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionTask.a.c = false;
        ApolloActionManager.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionTask.a.f, 3, "me");
      }
      b(0);
      c();
      return;
      if (a() != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTaskExecutor", 2, "PLAY_MODE_IN_ORDER, No task in queue, triger task to start. taskId:" + paramInt);
      }
    } while (!a(paramInt, paramApolloActionTask));
    b(0);
    c();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTaskExecutor", 2, "PLAY_MODE_IN_ORDER, Add task to the rear of the queue. taskId:" + paramInt);
    }
    a(paramInt, paramApolloActionTask);
  }
  
  public int b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTaskExecutor", 2, "[clear]");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTaskExecutor", 2, "[execNextTask]");
    }
    ApolloSurfaceView localApolloSurfaceView = ApolloActionManager.a().a;
    if ((!ApolloActionManager.a().b()) || (localApolloSurfaceView == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTaskExecutor", 2, "Surface NOT ready, pls wait.");
      }
    }
    ApolloActionTask localApolloActionTask;
    do
    {
      return;
      localApolloActionTask = a();
      ApolloRenderDriver localApolloRenderDriver = localApolloSurfaceView.a();
      if ((localApolloRenderDriver == null) || (!localApolloRenderDriver.a())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTaskExecutor", 2, "action SHOW cannot be interrupted, pls wait.");
      }
    } while ((localApolloActionTask == null) || (localApolloActionTask.a == null));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTaskExecutor", 2, "modify curTask playmode value, id:" + localApolloActionTask.a.f);
    }
    localApolloActionTask.a.jdField_a_of_type_Int = 1;
    return;
    if (localApolloActionTask == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTaskExecutor", 2, "No task in queue. Finish!");
      }
      b(1);
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionTask = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloTaskExecutor", 2, "status:" + localApolloSurfaceView.a() + ",taskinfo:" + localApolloActionTask.a.toString() + ",isEnterUnread:" + localApolloActionTask.a.d);
    }
    if ((!localApolloActionTask.a.d) && ((localApolloSurfaceView.a() == 1) || (ApolloActionManager.a().e == 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloTaskExecutor", 2, "DO stand up first.");
      }
      localApolloSurfaceView.a().e();
      return;
    }
    if (localApolloActionTask.a.jdField_a_of_type_Int == 0)
    {
      b();
      b(localApolloActionTask.a.f, localApolloActionTask);
    }
    ThreadManager.a(localApolloActionTask, 5, null, true);
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloActionTask = localApolloActionTask;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\task\ApolloTaskExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */