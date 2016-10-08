package com.tencent.mobileqq.dating;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import appoint.define.appoint_define.AppointInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DatingApplyInfo;
import com.tencent.mobileqq.data.DatingFeedInfo;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.data.DatingPublishInfo;
import com.tencent.mobileqq.data.DatingRecentDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class DatingCacheMng
  implements Handler.Callback
{
  public static final int a = 0;
  public static final long a = 86400000L;
  private static final SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private static final String jdField_a_of_type_JavaLangString = "last_align_dating_cache_time";
  public static final int b = 1;
  public static final long b = 60000L;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 20;
  private static final int f = 0;
  private DatingManager jdField_a_of_type_ComTencentMobileqqDatingDatingManager;
  private final EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final SparseArray b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(4);
    jdField_a_of_type_AndroidUtilSparseArray.put(0, DatingFeedInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(1, DatingPublishInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(2, DatingApplyInfo.class);
    jdField_a_of_type_AndroidUtilSparseArray.put(3, DatingRecentDetail.class);
  }
  
  protected DatingCacheMng(AppInterface paramAppInterface, EntityManager paramEntityManager)
  {
    DatingUtil.a("init", new Object[] { "star" });
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager = ((DatingManager)paramAppInterface.getManager(212));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(80);
    this.jdField_a_of_type_ArrayOfByte = new byte[jdField_a_of_type_AndroidUtilSparseArray.size()];
    this.b = new SparseArray(jdField_a_of_type_AndroidUtilSparseArray.size());
    this.b.put(0, new LinkedList());
    this.b.put(1, new LinkedList());
    this.b.put(2, new LinkedList());
    this.b.put(3, new LinkedList());
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.a(), this);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
    paramEntityManager = new LinkedList();
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ??? = (Class)jdField_a_of_type_AndroidUtilSparseArray.get(i);
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Class)???);
      paramEntityManager.clear();
      if (??? != null)
      {
        ??? = ((List)???).iterator();
        while ((??? != null) && (((Iterator)???).hasNext()))
        {
          localObject2 = a((Entity)((Iterator)???).next());
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramEntityManager.add(localObject2);
          }
        }
      }
      this.jdField_a_of_type_ArrayOfByte[i] = 0;
      synchronized ((LinkedList)this.b.get(i))
      {
        ((LinkedList)???).clear();
        ((LinkedList)???).addAll(paramEntityManager);
        i += 1;
      }
    }
    Object localObject2 = paramAppInterface.getPreferences();
    long l2 = ((SharedPreferences)localObject2).getLong("last_align_dating_cache_time", 0L);
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    DatingUtil.a("init", new Object[] { "alignCache", Long.valueOf(l3 - l2) });
    if (Math.abs(l2 - l3) > 86400000L) {}
    try
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingInfo.class);
      if ((??? != null) && (((List)???).size() > 120))
      {
        paramAppInterface = null;
        try
        {
          paramEntityManager = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
          paramAppInterface = paramEntityManager;
          paramEntityManager.a();
          paramAppInterface = paramEntityManager;
          Iterator localIterator = ((List)???).iterator();
          for (;;)
          {
            paramAppInterface = paramEntityManager;
            if (!localIterator.hasNext()) {
              break label610;
            }
            paramAppInterface = paramEntityManager;
            localDatingInfo = (DatingInfo)localIterator.next();
            if (localDatingInfo != null) {
              break;
            }
            ??? = null;
            paramAppInterface = paramEntityManager;
            if (!TextUtils.isEmpty((CharSequence)???))
            {
              paramAppInterface = paramEntityManager;
              if (a((String)???, -1)) {}
            }
            else
            {
              paramAppInterface = paramEntityManager;
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDatingInfo);
              paramAppInterface = paramEntityManager;
              DatingUtil.a("init", new Object[] { "alignData_del", ??? });
            }
          }
          if (paramEntityManager == null) {
            break label550;
          }
        }
        catch (Exception localException)
        {
          paramEntityManager = paramAppInterface;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.dating", 2, localException.toString());
            paramEntityManager = paramAppInterface;
          }
        }
        paramEntityManager.b();
      }
      label550:
      DatingUtil.a("init", new Object[] { "end", Long.valueOf(System.currentTimeMillis() - l1) });
      return;
    }
    catch (Exception paramAppInterface)
    {
      for (;;)
      {
        DatingInfo localDatingInfo;
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating", 2, paramAppInterface.toString());
        }
        String str = null;
        continue;
        paramAppInterface = paramEntityManager;
        str = localDatingInfo.datingId;
        continue;
        label610:
        paramAppInterface = paramEntityManager;
        paramEntityManager.c();
        paramAppInterface = paramEntityManager;
        ((SharedPreferences)localObject2).edit().putLong("last_align_dating_cache_time", l3).commit();
      }
    }
  }
  
  /* Error */
  public static Entity a(Class paramClass, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 269
    //   4: invokevirtual 273	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 276	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   12: checkcast 158	com/tencent/mobileqq/persistence/Entity
    //   15: astore_0
    //   16: aload_2
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 282	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   22: aload_0
    //   23: areturn
    //   24: astore_1
    //   25: aconst_null
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 285	java/lang/InstantiationException:printStackTrace	()V
    //   31: aload_0
    //   32: areturn
    //   33: astore_1
    //   34: aconst_null
    //   35: astore_0
    //   36: aload_1
    //   37: invokevirtual 286	java/lang/NoSuchFieldException:printStackTrace	()V
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: aconst_null
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 287	java/lang/IllegalArgumentException:printStackTrace	()V
    //   49: aload_0
    //   50: areturn
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_1
    //   55: invokevirtual 288	java/lang/IllegalAccessException:printStackTrace	()V
    //   58: aload_0
    //   59: areturn
    //   60: astore_1
    //   61: goto -7 -> 54
    //   64: astore_1
    //   65: goto -20 -> 45
    //   68: astore_1
    //   69: goto -33 -> 36
    //   72: astore_1
    //   73: goto -46 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramClass	Class
    //   0	76	1	paramString	String
    //   7	10	2	localField	Field
    // Exception table:
    //   from	to	target	type
    //   0	16	24	java/lang/InstantiationException
    //   0	16	33	java/lang/NoSuchFieldException
    //   0	16	42	java/lang/IllegalArgumentException
    //   0	16	51	java/lang/IllegalAccessException
    //   16	22	60	java/lang/IllegalAccessException
    //   16	22	64	java/lang/IllegalArgumentException
    //   16	22	68	java/lang/NoSuchFieldException
    //   16	22	72	java/lang/InstantiationException
  }
  
  public static String a(Entity paramEntity)
  {
    if (paramEntity != null) {}
    for (;;)
    {
      try
      {
        paramEntity = (String)paramEntity.getClass().getField("datingId").get(paramEntity);
        return paramEntity;
      }
      catch (NoSuchFieldException paramEntity)
      {
        paramEntity.printStackTrace();
        return null;
      }
      catch (IllegalArgumentException paramEntity)
      {
        paramEntity.printStackTrace();
        return null;
      }
      catch (IllegalAccessException paramEntity)
      {
        paramEntity.printStackTrace();
        return null;
      }
      paramEntity = null;
    }
  }
  
  private void a(int paramInt, byte paramByte)
  {
    DatingUtil.a("updateCacheFlag", new Object[] { Integer.valueOf(paramInt), Byte.valueOf(paramByte) });
    if ((paramInt >= 0) && (paramInt <= this.jdField_a_of_type_ArrayOfByte.length))
    {
      this.jdField_a_of_type_ArrayOfByte[paramInt] = paramByte;
      if ((paramByte != 0) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0))) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(0, 60000L);
      }
    }
  }
  
  private void a(DatingInfo paramDatingInfo)
  {
    if ((paramDatingInfo == null) || (TextUtils.isEmpty(paramDatingInfo.datingId))) {
      return;
    }
    if (paramDatingInfo.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramDatingInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramDatingInfo);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    int i = 0;
    boolean bool = false;
    if ((!bool) && (i < jdField_a_of_type_AndroidUtilSparseArray.size())) {
      if (jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) != paramInt) {}
    }
    for (;;)
    {
      i += 1;
      break;
      for (;;)
      {
        int j;
        synchronized ((LinkedList)this.b.get(i))
        {
          String[] arrayOfString = new String[???.size()];
          ???.toArray(arrayOfString);
          if (arrayOfString == null) {
            break;
          }
          int k = arrayOfString.length;
          j = 0;
          if (j >= k) {
            break;
          }
          if (Utils.a(arrayOfString[j], paramString)) {
            bool = true;
          }
        }
        j += 1;
      }
      return bool;
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: ldc_w 343
    //   3: iconst_1
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   12: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   15: aastore
    //   16: invokestatic 75	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: iconst_0
    //   20: istore 5
    //   22: iload 5
    //   24: getstatic 48	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   27: invokevirtual 102	android/util/SparseArray:size	()I
    //   30: if_icmpge +150 -> 180
    //   33: aload_0
    //   34: getfield 104	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_ArrayOfByte	[B
    //   37: iload 5
    //   39: baload
    //   40: ifne +6 -> 46
    //   43: goto +196 -> 239
    //   46: getstatic 48	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   49: iload 5
    //   51: invokevirtual 130	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   54: checkcast 132	java/lang/Class
    //   57: astore_2
    //   58: aload_0
    //   59: getfield 106	com/tencent/mobileqq/dating/DatingCacheMng:b	Landroid/util/SparseArray;
    //   62: iload 5
    //   64: invokevirtual 130	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   67: checkcast 108	java/util/LinkedList
    //   70: astore_1
    //   71: aload_1
    //   72: monitorenter
    //   73: aload_1
    //   74: invokevirtual 332	java/util/LinkedList:size	()I
    //   77: anewarray 297	java/lang/String
    //   80: astore_3
    //   81: aload_1
    //   82: aload_3
    //   83: invokevirtual 336	java/util/LinkedList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   86: pop
    //   87: aload_1
    //   88: monitorexit
    //   89: aload_3
    //   90: ifnull +149 -> 239
    //   93: aload_3
    //   94: arraylength
    //   95: iconst_1
    //   96: if_icmplt +143 -> 239
    //   99: aload_0
    //   100: getfield 83	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   103: invokevirtual 210	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 214	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   111: aload_2
    //   112: aload_3
    //   113: iconst_0
    //   114: aaload
    //   115: invokestatic 345	com/tencent/mobileqq/dating/DatingCacheMng:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   118: astore 4
    //   120: aload_0
    //   121: getfield 83	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   124: aload 4
    //   126: invokevirtual 347	com/tencent/mobileqq/persistence/EntityManager:c	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   129: aload_3
    //   130: arraylength
    //   131: istore 7
    //   133: iconst_0
    //   134: istore 6
    //   136: iload 6
    //   138: iload 7
    //   140: if_icmpge +73 -> 213
    //   143: aload_3
    //   144: iload 6
    //   146: aaload
    //   147: astore 4
    //   149: aload 4
    //   151: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: istore 8
    //   156: iload 8
    //   158: ifeq +23 -> 181
    //   161: iload 6
    //   163: iconst_1
    //   164: iadd
    //   165: istore 6
    //   167: goto -31 -> 136
    //   170: astore_2
    //   171: aload_1
    //   172: monitorexit
    //   173: aload_2
    //   174: athrow
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 348	java/lang/Exception:printStackTrace	()V
    //   180: return
    //   181: aload_2
    //   182: aload 4
    //   184: invokestatic 345	com/tencent/mobileqq/dating/DatingCacheMng:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   187: astore 4
    //   189: aload_0
    //   190: getfield 83	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   193: aload 4
    //   195: invokevirtual 325	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   198: goto -37 -> 161
    //   201: astore_2
    //   202: aload_2
    //   203: invokevirtual 348	java/lang/Exception:printStackTrace	()V
    //   206: aload_1
    //   207: invokevirtual 239	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   210: goto +29 -> 239
    //   213: aload_1
    //   214: invokevirtual 246	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   217: aload_0
    //   218: getfield 104	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_ArrayOfByte	[B
    //   221: iload 5
    //   223: iconst_0
    //   224: bastore
    //   225: aload_1
    //   226: invokevirtual 239	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   229: goto +10 -> 239
    //   232: astore_2
    //   233: aload_1
    //   234: invokevirtual 239	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   237: aload_2
    //   238: athrow
    //   239: iload 5
    //   241: iconst_1
    //   242: iadd
    //   243: istore 5
    //   245: goto -223 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	DatingCacheMng
    //   175	59	1	localException1	Exception
    //   57	55	2	localClass1	Class
    //   170	12	2	localClass2	Class
    //   201	2	2	localException2	Exception
    //   232	6	2	localObject2	Object
    //   80	64	3	arrayOfString	String[]
    //   118	76	4	localObject3	Object
    //   20	224	5	i	int
    //   134	32	6	j	int
    //   131	10	7	k	int
    //   154	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   73	89	170	finally
    //   171	173	170	finally
    //   22	43	175	java/lang/Exception
    //   46	73	175	java/lang/Exception
    //   93	107	175	java/lang/Exception
    //   173	175	175	java/lang/Exception
    //   206	210	175	java/lang/Exception
    //   225	229	175	java/lang/Exception
    //   233	239	175	java/lang/Exception
    //   107	133	201	java/lang/Exception
    //   149	156	201	java/lang/Exception
    //   181	198	201	java/lang/Exception
    //   213	225	201	java/lang/Exception
    //   107	133	232	finally
    //   149	156	232	finally
    //   181	198	232	finally
    //   202	206	232	finally
    //   213	225	232	finally
  }
  
  public DatingInfo a(appoint_define.AppointInfo paramAppointInfo)
  {
    Object localObject1 = null;
    Object localObject2 = DatingUtil.a(paramAppointInfo);
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      boolean bool = a((String)localObject2, -1);
      localObject2 = a((String)localObject2, bool, true, bool);
      DatingUtil.a((DatingInfo)localObject2, paramAppointInfo);
      localObject1 = localObject2;
      if (bool)
      {
        a((DatingInfo)localObject2);
        localObject1 = localObject2;
      }
    }
    return (DatingInfo)localObject1;
  }
  
  public DatingInfo a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    byte b1 = 0;
    Object localObject1;
    byte b2;
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject1 = (DatingInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (localObject1 != null)
        {
          b2 = 1;
          ??? = localObject1;
          b1 = b2;
          localObject1 = ???;
          if (??? == null)
          {
            b1 = b2;
            localObject1 = ???;
            if (paramBoolean2)
            {
              localObject1 = new DatingInfo();
              ((DatingInfo)localObject1).datingId = paramString;
              b1 = 3;
            }
          }
          if ((localObject1 == null) || (b1 == 1) || (!paramBoolean3)) {
            break label310;
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        ??? = (DatingInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (??? == null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
          DatingUtil.a("getDatingInfo", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Byte.valueOf(b1) });
          return (DatingInfo)localObject1;
          paramString = finally;
          throw paramString;
          b2 = b1;
          if (paramBoolean1)
          {
            ??? = (DatingInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingInfo.class, paramString);
            localObject1 = ???;
            b2 = b1;
            if (??? != null)
            {
              b2 = 2;
              ((DatingInfo)???).init();
              localObject1 = ???;
            }
          }
          ??? = localObject1;
          break;
        }
        DatingUtil.a("getDatingInfo", new Object[] { paramString, "add to cache", Boolean.valueOf(((DatingInfo)???).isDefaultValue()), Boolean.valueOf(((DatingInfo)localObject1).isDefaultValue()) });
        localObject1 = ???;
      }
      label310:
      continue;
      localObject1 = null;
      b1 = 0;
    }
  }
  
  /* Error */
  public List a(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 383
    //   3: iconst_1
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: iload_1
    //   10: invokestatic 305	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: aastore
    //   14: invokestatic 75	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: iload_1
    //   18: iflt +13 -> 31
    //   21: iload_1
    //   22: getstatic 48	com/tencent/mobileqq/dating/DatingCacheMng:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   25: invokevirtual 102	android/util/SparseArray:size	()I
    //   28: if_icmplt +5 -> 33
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: getfield 106	com/tencent/mobileqq/dating/DatingCacheMng:b	Landroid/util/SparseArray;
    //   37: iload_1
    //   38: invokevirtual 130	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   41: checkcast 108	java/util/LinkedList
    //   44: astore 4
    //   46: new 385	java/util/ArrayList
    //   49: dup
    //   50: aload 4
    //   52: invokevirtual 332	java/util/LinkedList:size	()I
    //   55: invokespecial 386	java/util/ArrayList:<init>	(I)V
    //   58: astore_2
    //   59: aload 4
    //   61: monitorenter
    //   62: aload 4
    //   64: invokevirtual 332	java/util/LinkedList:size	()I
    //   67: anewarray 297	java/lang/String
    //   70: astore_3
    //   71: aload 4
    //   73: aload_3
    //   74: invokevirtual 336	java/util/LinkedList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   77: pop
    //   78: aload 4
    //   80: monitorexit
    //   81: aload_3
    //   82: ifnull +67 -> 149
    //   85: aload_3
    //   86: arraylength
    //   87: ifle +62 -> 149
    //   90: aload_3
    //   91: arraylength
    //   92: istore 5
    //   94: iconst_0
    //   95: istore_1
    //   96: iload_1
    //   97: iload 5
    //   99: if_icmpge +50 -> 149
    //   102: aload_3
    //   103: iload_1
    //   104: aaload
    //   105: astore 4
    //   107: aload 4
    //   109: invokestatic 167	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: istore 6
    //   114: iload 6
    //   116: ifeq +42 -> 158
    //   119: iload_1
    //   120: iconst_1
    //   121: iadd
    //   122: istore_1
    //   123: goto -27 -> 96
    //   126: astore_3
    //   127: aload 4
    //   129: monitorexit
    //   130: aload_3
    //   131: athrow
    //   132: astore_3
    //   133: invokestatic 227	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +13 -> 149
    //   139: ldc -27
    //   141: iconst_2
    //   142: aload_3
    //   143: invokevirtual 233	java/lang/Exception:toString	()Ljava/lang/String;
    //   146: invokestatic 237	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: ldc_w 383
    //   152: aload_2
    //   153: invokestatic 389	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;Ljava/util/List;)V
    //   156: aload_2
    //   157: areturn
    //   158: aload_0
    //   159: aload 4
    //   161: iconst_1
    //   162: iconst_1
    //   163: iconst_1
    //   164: invokevirtual 355	com/tencent/mobileqq/dating/DatingCacheMng:a	(Ljava/lang/String;ZZZ)Lcom/tencent/mobileqq/data/DatingInfo;
    //   167: astore 4
    //   169: aload 4
    //   171: ifnull -52 -> 119
    //   174: aload_2
    //   175: aload 4
    //   177: invokeinterface 390 2 0
    //   182: pop
    //   183: goto -64 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	DatingCacheMng
    //   0	186	1	paramInt	int
    //   58	117	2	localArrayList	ArrayList
    //   70	33	3	arrayOfString	String[]
    //   126	5	3	localObject1	Object
    //   132	11	3	localException	Exception
    //   44	132	4	localObject2	Object
    //   92	8	5	i	int
    //   112	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   62	81	126	finally
    //   127	130	126	finally
    //   59	62	132	java/lang/Exception
    //   85	94	132	java/lang/Exception
    //   107	114	132	java/lang/Exception
    //   130	132	132	java/lang/Exception
    //   158	169	132	java/lang/Exception
    //   174	183	132	java/lang/Exception
  }
  
  public List a(int paramInt, List arg2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    int i;
    ArrayList localArrayList;
    label74:
    Object localObject2;
    Object localObject3;
    if (??? == null)
    {
      i = 0;
      DatingUtil.a("saveDatingList", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Integer.valueOf(i) });
      if ((paramInt < 0) || (paramInt >= jdField_a_of_type_AndroidUtilSparseArray.size())) {
        break label406;
      }
      localArrayList = new ArrayList(i);
      if (!paramBoolean1) {
        break label212;
      }
      j = 0;
      if (j >= i) {
        break label200;
      }
      localObject2 = ???.get(j);
      localObject3 = DatingUtil.a(localObject2);
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a().a(paramInt, (String)localObject3).booleanValue())) {
        break label145;
      }
    }
    for (;;)
    {
      j += 1;
      break label74;
      i = ???.size();
      break;
      label145:
      localObject3 = a((String)localObject3, false, true, false);
      if (localObject3 != null)
      {
        DatingUtil.a((DatingInfo)localObject3, localObject2);
        if ((paramInt == 2) && (((DatingInfo)localObject3).datingApply == 0)) {
          ((DatingInfo)localObject3).datingApply = 1;
        }
        localArrayList.add(localObject3);
      }
    }
    label200:
    label212:
    label406:
    for (??? = localArrayList;; ??? = null) {
      for (;;)
      {
        DatingUtil.a("saveDatingList", ???);
        return (List)???;
        localObject2 = new LinkedList();
        if (j < i)
        {
          localObject3 = ???.get(j);
          Object localObject4 = DatingUtil.a(localObject3);
          if ((TextUtils.isEmpty((CharSequence)localObject4)) || (this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a().a(paramInt, (String)localObject4).booleanValue())) {}
          for (;;)
          {
            j += 1;
            break;
            ((LinkedList)localObject2).add(localObject4);
            localObject4 = a((String)localObject4, true, true, true);
            if (localObject4 != null)
            {
              DatingUtil.a((DatingInfo)localObject4, localObject3);
              if ((paramInt == 2) && (((DatingInfo)localObject4).datingApply == 0)) {
                ((DatingInfo)localObject4).datingApply = 1;
              }
              if (!paramBoolean2) {
                a((DatingInfo)localObject4);
              }
              localArrayList.add(localObject4);
            }
          }
        }
        if (!paramBoolean2) {}
        synchronized ((LinkedList)this.b.get(paramInt))
        {
          ???.clear();
          ???.addAll((Collection)localObject2);
          a(paramInt, (byte)1);
          ??? = localArrayList;
        }
      }
    }
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < jdField_a_of_type_AndroidUtilSparseArray.size())) {}
    synchronized ((LinkedList)this.b.get(paramInt))
    {
      ???.clear();
      a(paramInt, (byte)2);
      return;
    }
  }
  
  public void a(DatingInfo paramDatingInfo, int paramInt)
  {
    if ((paramDatingInfo == null) || (TextUtils.isEmpty(paramDatingInfo.datingId))) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramDatingInfo.datingId, paramDatingInfo);
      if ((paramInt < 0) || (paramInt >= jdField_a_of_type_AndroidUtilSparseArray.size())) {}
    }
    synchronized ((LinkedList)this.b.get(paramInt))
    {
      ((LinkedList)???).addFirst(paramDatingInfo.datingId);
      if (((LinkedList)???).size() > 20) {
        ((LinkedList)???).removeLast();
      }
      a(paramDatingInfo);
      return;
      paramDatingInfo = finally;
      throw paramDatingInfo;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < jdField_a_of_type_AndroidUtilSparseArray.size())) {}
    synchronized ((LinkedList)this.b.get(paramInt))
    {
      ???.remove(paramString);
      a(paramInt, (byte)2);
      return;
    }
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramLong == 0L) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return;
    }
    DatingSig localDatingSig = new DatingSig();
    localDatingSig.datingId = paramString;
    localDatingSig.openId = paramLong;
    localDatingSig.sig = paramArrayOfByte;
    localDatingSig.timestamp = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDatingSig);
  }
  
  public byte[] a(String paramString, long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    paramString = (DatingSig)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingSig.class, String.valueOf(paramLong));
    if (paramString != null) {
      return paramString.sig;
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      b();
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingCacheMng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */