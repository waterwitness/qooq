package com.tencent.mobileqq.app;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import qfl;
import qfn;

public class RoamSettingManager
  implements Manager
{
  public static final String a = "RoamSettingManager";
  RoamSetting jdField_a_of_type_ComTencentMobileqqDataRoamSetting;
  public EntityManager a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  public Lock a;
  private boolean jdField_a_of_type_Boolean;
  private HashMap b;
  
  public RoamSettingManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    a();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = ((RoamSetting)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(RoamSetting.class, "setting_revision"));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = null;
      return 0;
    }
    try
    {
      i = Integer.parseInt(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "parse revision.value exception, revision.value=" + this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value);
        }
        int i = 0;
      }
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    RoamSetting localRoamSetting2 = a(paramString);
    RoamSetting localRoamSetting1 = localRoamSetting2;
    if (localRoamSetting2 == null)
    {
      localRoamSetting1 = localRoamSetting2;
      if (!TextUtils.isEmpty(paramString))
      {
        localRoamSetting1 = new RoamSetting(paramString, Integer.toString(paramInt));
        a(localRoamSetting1);
      }
    }
    return RoamSetting.getIntValue(localRoamSetting1, paramInt);
  }
  
  /* Error */
  public RoamSetting a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 51	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   10: invokeinterface 134 1 0
    //   15: aload_1
    //   16: invokestatic 138	com/tencent/mobileqq/utils/RoamSettingController:a	(Ljava/lang/String;)I
    //   19: istore 4
    //   21: iload 4
    //   23: iconst_1
    //   24: if_icmpne +100 -> 124
    //   27: aload_0
    //   28: getfield 33	com/tencent/mobileqq/app/RoamSettingManager:b	Ljava/util/HashMap;
    //   31: aload_1
    //   32: invokevirtual 142	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 65	com/tencent/mobileqq/data/RoamSetting
    //   38: astore_2
    //   39: aload_2
    //   40: astore_3
    //   41: aload_2
    //   42: ifnonnull +71 -> 113
    //   45: aload_2
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 58	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_Boolean	Z
    //   51: ifne +62 -> 113
    //   54: aload_0
    //   55: getfield 46	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: ldc 65
    //   60: aload_1
    //   61: invokevirtual 72	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   64: checkcast 65	com/tencent/mobileqq/data/RoamSetting
    //   67: astore_1
    //   68: aload_1
    //   69: astore_3
    //   70: aload_1
    //   71: ifnull +42 -> 113
    //   74: aload_1
    //   75: astore_3
    //   76: aload_1
    //   77: getfield 145	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   80: ifnull +33 -> 113
    //   83: aload_1
    //   84: astore_3
    //   85: aload_1
    //   86: getfield 75	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   89: ifnull +24 -> 113
    //   92: iload 4
    //   94: iconst_1
    //   95: if_icmpne +44 -> 139
    //   98: aload_0
    //   99: getfield 33	com/tencent/mobileqq/app/RoamSettingManager:b	Ljava/util/HashMap;
    //   102: aload_1
    //   103: getfield 145	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   106: aload_1
    //   107: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: aload_1
    //   112: astore_3
    //   113: aload_0
    //   114: getfield 51	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   117: invokeinterface 152 1 0
    //   122: aload_3
    //   123: areturn
    //   124: aload_0
    //   125: getfield 31	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   128: aload_1
    //   129: invokevirtual 142	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: checkcast 65	com/tencent/mobileqq/data/RoamSetting
    //   135: astore_2
    //   136: goto -97 -> 39
    //   139: aload_0
    //   140: getfield 31	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   143: aload_1
    //   144: getfield 145	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   147: aload_1
    //   148: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: aload_1
    //   153: astore_3
    //   154: goto -41 -> 113
    //   157: astore_1
    //   158: aload_0
    //   159: getfield 51	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   162: invokeinterface 152 1 0
    //   167: aload_1
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	RoamSettingManager
    //   0	169	1	paramString	String
    //   38	98	2	localRoamSetting	RoamSetting
    //   40	114	3	localObject	Object
    //   19	77	4	i	int
    // Exception table:
    //   from	to	target	type
    //   15	21	157	finally
    //   27	39	157	finally
    //   47	68	157	finally
    //   76	83	157	finally
    //   85	92	157	finally
    //   98	111	157	finally
    //   124	136	157	finally
    //   139	152	157	finally
  }
  
  /* Error */
  public RoamSetting a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 110	com/tencent/mobileqq/app/RoamSettingManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/RoamSetting;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +54 -> 71
    //   20: new 65	com/tencent/mobileqq/data/RoamSetting
    //   23: dup
    //   24: aload_1
    //   25: aload_2
    //   26: invokespecial 122	com/tencent/mobileqq/data/RoamSetting:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 51	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   34: invokeinterface 134 1 0
    //   39: aload_1
    //   40: invokestatic 138	com/tencent/mobileqq/utils/RoamSettingController:a	(Ljava/lang/String;)I
    //   43: iconst_1
    //   44: if_icmpne +50 -> 94
    //   47: aload_0
    //   48: getfield 33	com/tencent/mobileqq/app/RoamSettingManager:b	Ljava/util/HashMap;
    //   51: aload_2
    //   52: getfield 145	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   55: aload_2
    //   56: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: pop
    //   60: aload_0
    //   61: getfield 51	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   64: invokeinterface 152 1 0
    //   69: aload_2
    //   70: areturn
    //   71: aload_2
    //   72: aload_3
    //   73: getfield 75	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   76: invokevirtual 159	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifeq +5 -> 84
    //   82: aconst_null
    //   83: areturn
    //   84: aload_3
    //   85: aload_2
    //   86: putfield 75	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   89: aload_3
    //   90: astore_2
    //   91: goto -61 -> 30
    //   94: aload_0
    //   95: getfield 31	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   98: aload_2
    //   99: getfield 145	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   102: aload_2
    //   103: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   106: pop
    //   107: goto -47 -> 60
    //   110: astore_1
    //   111: aload_0
    //   112: getfield 51	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   115: invokeinterface 152 1 0
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	RoamSettingManager
    //   0	122	1	paramString1	String
    //   0	122	2	paramString2	String
    //   15	75	3	localRoamSetting	RoamSetting
    // Exception table:
    //   from	to	target	type
    //   39	60	110	finally
    //   94	107	110	finally
  }
  
  public void a()
  {
    ThreadManager.a(new qfl(this), 8, null, false);
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting != null)
    {
      localObject = Integer.toString(paramInt);
      if (((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting.value = ((String)localObject);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting);
      return;
      localObject = new RoamSetting();
      ((RoamSetting)localObject).path = "setting_revision";
      ((RoamSetting)localObject).value = Integer.toString(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqDataRoamSetting = ((RoamSetting)localObject);
    }
  }
  
  /* Error */
  public void a(RoamSetting paramRoamSetting)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +17 -> 18
    //   4: aload_1
    //   5: getfield 145	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   8: ifnull +10 -> 18
    //   11: aload_1
    //   12: getfield 75	com/tencent/mobileqq/data/RoamSetting:value	Ljava/lang/String;
    //   15: ifnonnull +4 -> 19
    //   18: return
    //   19: aload_0
    //   20: getfield 51	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   23: invokeinterface 134 1 0
    //   28: aload_1
    //   29: getfield 145	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   32: invokestatic 138	com/tencent/mobileqq/utils/RoamSettingController:a	(Ljava/lang/String;)I
    //   35: iconst_1
    //   36: if_icmpne +41 -> 77
    //   39: aload_0
    //   40: getfield 33	com/tencent/mobileqq/app/RoamSettingManager:b	Ljava/util/HashMap;
    //   43: aload_1
    //   44: getfield 145	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   47: aload_1
    //   48: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: aload_0
    //   53: getfield 51	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   56: invokeinterface 152 1 0
    //   61: new 176	qfm
    //   64: dup
    //   65: aload_0
    //   66: aload_1
    //   67: invokespecial 179	qfm:<init>	(Lcom/tencent/mobileqq/app/RoamSettingManager;Lcom/tencent/mobileqq/data/RoamSetting;)V
    //   70: iconst_5
    //   71: aconst_null
    //   72: iconst_0
    //   73: invokestatic 169	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   76: return
    //   77: aload_0
    //   78: getfield 31	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   81: aload_1
    //   82: getfield 145	com/tencent/mobileqq/data/RoamSetting:path	Ljava/lang/String;
    //   85: aload_1
    //   86: invokevirtual 149	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: goto -38 -> 52
    //   93: astore_1
    //   94: aload_0
    //   95: getfield 51	com/tencent/mobileqq/app/RoamSettingManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   98: invokeinterface 152 1 0
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	RoamSettingManager
    //   0	105	1	paramRoamSetting	RoamSetting
    // Exception table:
    //   from	to	target	type
    //   28	52	93	finally
    //   77	90	93	finally
  }
  
  public void a(String paramString)
  {
    RoamSetting localRoamSetting = a(paramString);
    if ((localRoamSetting == null) || (localRoamSetting.path == null) || (localRoamSetting.value == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (RoamSettingController.a(paramString) == 1) {
        this.b.remove(localRoamSetting.path);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
          break;
        }
        ThreadManager.a(new qfn(this, localRoamSetting), 5, null, false);
        return;
        this.jdField_a_of_type_JavaUtilHashMap.remove(localRoamSetting.path);
      }
      b(localRoamSetting);
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(List paramList)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.a();
      if (paramList != null)
      {
        int i = 0;
        for (;;)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          if (i >= paramList.size()) {
            break;
          }
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          a((Entity)paramList.get(i));
          i += 1;
        }
      }
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.c();
      if (localEntityTransaction != null) {
        localEntityTransaction.b();
      }
      return;
    }
    catch (Exception paramList)
    {
      localObject2 = localObject1;
      paramList.printStackTrace();
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        QLog.w("RoamSettingManager", 2, "insert write exception: " + paramList.getMessage());
      }
      return;
    }
    finally
    {
      if (localObject2 != null) {
        ((EntityTransaction)localObject2).b();
      }
    }
  }
  
  public boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())
    {
      if (paramEntity.getStatus() != 1000) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public boolean b(Entity paramEntity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
    }
    return false;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\RoamSettingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */