package com.tencent.mobileqq.precover;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PrecoverConfig;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.data.PrecoverResourceBusiness;
import com.tencent.mobileqq.data.PrecoverRetryInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;
import tum;
import tun;
import tuo;
import tup;

public class PrecoverManager
  implements PrecoverListener, Manager
{
  public static final int a = 0;
  public static final String a = "PrecoverManager";
  private static Set jdField_a_of_type_JavaUtilSet;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private PrecoverControl jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl;
  private PrecoverReporter jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverReporter;
  private PrecoverResDownloader jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverResDownloader;
  private final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private PrecoverBusiConfigHandler[] jdField_a_of_type_ArrayOfComTencentMobileqqPrecoverPrecoverBusiConfigHandler = new PrecoverBusiConfigHandler[jdField_a_of_type_JavaUtilSet.size()];
  private final HashMap b = new HashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(0));
  }
  
  public PrecoverManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverResDownloader = new PrecoverResDownloader(paramQQAppInterface, this);
    this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl = PrecoverControl.a();
    this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverReporter = new PrecoverReporter(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.a(new tum(this), 10, null, false);
      return;
    }
    b();
  }
  
  private PrecoverResource a(String paramString, Class paramClass)
  {
    paramString = a("md5 = ?", new String[] { paramString }, paramClass);
    if ((paramString != null) && (paramString.size() > 0)) {
      return (PrecoverResource)paramString.get(0);
    }
    return null;
  }
  
  private PrecoverResource a(String paramString1, String paramString2, Class paramClass)
  {
    paramString1 = a("businessId = ? and resId = ?", new String[] { paramString1, paramString2 }, paramClass);
    if ((paramString1 != null) && (paramString1.size() > 0)) {
      return (PrecoverResource)paramString1.get(0);
    }
    return null;
  }
  
  private PrecoverRetryInfo a(PrecoverResource paramPrecoverResource)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "getRetryInfo, res=" + paramPrecoverResource);
    }
    if (paramPrecoverResource == null) {
      return null;
    }
    try
    {
      paramPrecoverResource = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PrecoverRetryInfo.class, false, "pk = ?", new String[] { paramPrecoverResource.businessId + "_" + paramPrecoverResource.md5 }, null, null, null, null);
      if ((paramPrecoverResource != null) && (paramPrecoverResource.size() > 0))
      {
        paramPrecoverResource = (PrecoverRetryInfo)paramPrecoverResource.get(0);
        return paramPrecoverResource;
      }
    }
    catch (Exception paramPrecoverResource)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverManager", 2, new Object[] { "getRetryInfo, exception=", paramPrecoverResource.getMessage() });
          paramPrecoverResource.printStackTrace();
        }
        paramPrecoverResource = null;
        continue;
        paramPrecoverResource = null;
      }
    }
  }
  
  private List a(String paramString, Class paramClass)
  {
    return a("businessId = ?", new String[] { paramString }, paramClass);
  }
  
  private void a(PrecoverRetryInfo paramPrecoverRetryInfo)
  {
    if (QLog.isColorLevel()) {
      if (paramPrecoverRetryInfo != null) {
        break label37;
      }
    }
    label37:
    for (Object localObject = "null";; localObject = paramPrecoverRetryInfo)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "updateRetryInfo, retryInfo=", localObject });
      if (paramPrecoverRetryInfo != null) {
        break;
      }
      return;
    }
    a(paramPrecoverRetryInfo);
  }
  
  private void a(Entity paramEntity)
  {
    if (QLog.isColorLevel()) {
      if (paramEntity != null) {
        break label37;
      }
    }
    label37:
    for (Object localObject = "null";; localObject = paramEntity)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, entity=", localObject });
      if (paramEntity != null) {
        break;
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, entity.Name=", paramEntity.getClass().getSimpleName() });
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      ((EntityTransaction)localObject).c();
      return;
    }
    catch (Exception paramEntity)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "insertEntity, exception=", paramEntity.getMessage() });
        paramEntity.printStackTrace();
      }
      return;
    }
    finally
    {
      ((EntityTransaction)localObject).b();
    }
  }
  
  private boolean a(Class paramClass)
  {
    return a("delete_all", paramClass);
  }
  
  /* Error */
  private boolean a(String paramString, Class paramClass)
  {
    // Byte code:
    //   0: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +43 -> 46
    //   6: aload_1
    //   7: ifnonnull +74 -> 81
    //   10: ldc -26
    //   12: astore_3
    //   13: ldc 14
    //   15: iconst_2
    //   16: iconst_4
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: ldc_w 276
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: aload_3
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: ldc_w 278
    //   35: aastore
    //   36: dup
    //   37: iconst_3
    //   38: aload_2
    //   39: invokevirtual 248	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   42: aastore
    //   43: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   46: aload_1
    //   47: invokestatic 284	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +29 -> 79
    //   53: aload_2
    //   54: ldc -105
    //   56: if_acmpeq +30 -> 86
    //   59: aload_2
    //   60: ldc_w 286
    //   63: if_acmpeq +23 -> 86
    //   66: aload_2
    //   67: ldc -71
    //   69: if_acmpeq +17 -> 86
    //   72: aload_2
    //   73: ldc_w 288
    //   76: if_acmpeq +10 -> 86
    //   79: iconst_0
    //   80: ireturn
    //   81: aload_1
    //   82: astore_3
    //   83: goto -70 -> 13
    //   86: aload_0
    //   87: getfield 87	com/tencent/mobileqq/precover/PrecoverManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   90: invokevirtual 251	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 255	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   98: aload_2
    //   99: invokevirtual 248	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   102: astore_2
    //   103: aload_1
    //   104: ldc_w 274
    //   107: invokevirtual 291	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   110: ifeq +63 -> 173
    //   113: ldc_w 293
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_2
    //   123: aastore
    //   124: invokestatic 297	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   127: astore_1
    //   128: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +23 -> 154
    //   134: ldc 14
    //   136: iconst_2
    //   137: iconst_2
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: ldc_w 299
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload_1
    //   150: aastore
    //   151: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   154: aload_0
    //   155: getfield 87	com/tencent/mobileqq/precover/PrecoverManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   158: aload_1
    //   159: invokevirtual 302	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   162: pop
    //   163: aload_3
    //   164: invokevirtual 260	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   167: aload_3
    //   168: invokevirtual 261	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   171: iconst_1
    //   172: ireturn
    //   173: ldc_w 304
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_2
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: aload_1
    //   187: aastore
    //   188: invokestatic 297	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   191: astore_1
    //   192: goto -64 -> 128
    //   195: astore_1
    //   196: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +30 -> 229
    //   202: ldc 14
    //   204: iconst_2
    //   205: iconst_2
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: ldc_w 306
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: aload_1
    //   218: invokevirtual 205	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: aastore
    //   222: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   225: aload_1
    //   226: invokevirtual 211	java/lang/Exception:printStackTrace	()V
    //   229: aload_3
    //   230: invokevirtual 261	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_1
    //   236: aload_3
    //   237: invokevirtual 261	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   240: aload_1
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	PrecoverManager
    //   0	242	1	paramString	String
    //   0	242	2	paramClass	Class
    //   12	225	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   94	128	195	java/lang/Exception
    //   128	154	195	java/lang/Exception
    //   154	167	195	java/lang/Exception
    //   173	192	195	java/lang/Exception
    //   94	128	235	finally
    //   128	154	235	finally
    //   154	167	235	finally
    //   173	192	235	finally
    //   196	229	235	finally
  }
  
  private PrecoverBusiConfigHandler b(int paramInt)
  {
    switch (paramInt)
    {
    }
    return null;
  }
  
  private static String b(PrecoverResource paramPrecoverResource)
  {
    return paramPrecoverResource.businessId + "_" + paramPrecoverResource.md5;
  }
  
  private void b()
  {
    Object localObject5;
    Object localObject6;
    List localList;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "initCache");
      }
      Object localObject1 = a(null, null, PrecoverResource.class);
      localObject5 = a(null, null, PrecoverResourceBusiness.class);
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        this.b.clear();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject6 = ((List)localObject1).iterator();
          while (((Iterator)localObject6).hasNext())
          {
            PrecoverResource localPrecoverResource = (PrecoverResource)((Iterator)localObject6).next();
            if (localPrecoverResource.isValid())
            {
              localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(localPrecoverResource.businessId);
              localObject1 = localList;
              if (localList == null) {
                localObject1 = new ArrayList();
              }
              ((List)localObject1).add(localPrecoverResource);
              this.jdField_a_of_type_JavaUtilHashMap.put(localPrecoverResource.businessId, localObject1);
              this.b.put(b(localPrecoverResource), localPrecoverResource);
            }
          }
        }
      }
      if (localObject5 == null) {
        break label315;
      }
    }
    finally {}
    if (((List)localObject5).size() > 0)
    {
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (PrecoverResource)((Iterator)localObject5).next();
        if (((PrecoverResource)localObject6).isValid())
        {
          localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(((PrecoverResource)localObject6).businessId);
          Object localObject4 = localList;
          if (localList == null) {
            localObject4 = new ArrayList();
          }
          ((List)localObject4).add(localObject6);
          this.jdField_a_of_type_JavaUtilHashMap.put(((PrecoverResource)localObject6).businessId, localObject4);
          this.b.put(b((PrecoverResource)localObject6), localObject6);
        }
      }
    }
    label315:
  }
  
  private boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "isNetworkCanDown");
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl.h;
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "isNetworkCanDown, return true, param == 2");
      }
      return true;
    }
    int j = NetworkUtil.a(BaseApplicationImpl.getContext());
    boolean bool;
    if (i == 0) {
      if ((j == 1) || (j == 4)) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "isNetworkCanDown, param=", Integer.valueOf(i), ", netType=", Integer.valueOf(j), ", result=", Boolean.valueOf(bool) });
      }
      return bool;
      bool = false;
      continue;
      if ((j == 1) || (j == 4) || (j == 3)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    for (Object localObject = "null";; localObject = paramString)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "clearRetryTable, businessId=", localObject });
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject).a();
      paramString = String.format("DELETE FROM %s WHERE businessId = '%s';", new Object[] { PrecoverRetryInfo.class.getSimpleName(), paramString });
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "clearRetryTable, sql=", paramString });
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
      ((EntityTransaction)localObject).c();
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "clearRetryTable, exception=", paramString.getMessage() });
        paramString.printStackTrace();
      }
      return false;
    }
    finally
    {
      ((EntityTransaction)localObject).b();
    }
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public PrecoverResource a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramString1 = null;
      return paramString1;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      for (;;)
      {
        if (i >= localList.size()) {
          break label96;
        }
        PrecoverResource localPrecoverResource = (PrecoverResource)localList.get(i);
        paramString1 = localPrecoverResource;
        if (localPrecoverResource.resId.equals(paramString2)) {
          break;
        }
        i += 1;
      }
    }
    label96:
    return null;
  }
  
  public PrecoverBusiConfigHandler a(int paramInt)
  {
    if (!jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {
      return null;
    }
    synchronized (this.jdField_a_of_type_ArrayOfComTencentMobileqqPrecoverPrecoverBusiConfigHandler)
    {
      PrecoverBusiConfigHandler localPrecoverBusiConfigHandler2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqPrecoverPrecoverBusiConfigHandler[paramInt];
      PrecoverBusiConfigHandler localPrecoverBusiConfigHandler1 = localPrecoverBusiConfigHandler2;
      if (localPrecoverBusiConfigHandler2 == null) {
        localPrecoverBusiConfigHandler1 = b(paramInt);
      }
      if (localPrecoverBusiConfigHandler1 != null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqPrecoverPrecoverBusiConfigHandler[paramInt] = localPrecoverBusiConfigHandler1;
      }
      return localPrecoverBusiConfigHandler1;
    }
  }
  
  public PrecoverControl a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl;
  }
  
  public PrecoverReporter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverReporter;
  }
  
  public PrecoverResDownloader a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverResDownloader;
  }
  
  protected HashMap a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public List a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  protected List a(String paramString, String[] paramArrayOfString, Class paramClass)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (paramString != null) {
        break label111;
      }
      str = "null";
      if (paramArrayOfString != null) {
        break label117;
      }
    }
    label111:
    label117:
    for (Object localObject = "null";; localObject = paramArrayOfString)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "queryAll, selction=", str, ", selectionArgs=", localObject, ", clz=", paramClass.getSimpleName() });
      if ((paramClass == PrecoverResource.class) || (paramClass == PrecoverResourceBusiness.class) || (paramClass == PrecoverRetryInfo.class) || (paramClass == PrecoverConfig.class)) {
        break label123;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "queryAll, clz not valid");
      }
      return null;
      str = paramString;
      break;
    }
    try
    {
      label123:
      paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramClass, false, paramString, paramArrayOfString, null, null, null, null);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "queryAll, exception=", paramString.getMessage() });
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      a(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(int paramInt)
  {
    if (!jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {
      return;
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqPrecoverPrecoverBusiConfigHandler[paramInt] = null;
  }
  
  public void a(int paramInt, String paramString, PrecoverResource paramPrecoverResource, Object paramObject)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilHashSet == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "onDownloadFinish, needReport, mReportSet.size=", Integer.valueOf(this.jdField_a_of_type_JavaUtilHashSet.size()), ", res=", paramPrecoverResource });
      }
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramPrecoverResource);
    } while (this.jdField_a_of_type_JavaUtilHashSet.size() != 0);
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, "onDownloadFinish, download finish, doing report");
    }
    this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverResDownloader.b(this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = null;
    ThreadManager.a(new tup(this), 5, null, false);
  }
  
  protected void a(PrecoverResource paramPrecoverResource)
  {
    if (paramPrecoverResource == null) {}
    PrecoverRetryInfo localPrecoverRetryInfo;
    do
    {
      return;
      localPrecoverRetryInfo = a(paramPrecoverResource);
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "deleteRertyInfo, info=" + localPrecoverRetryInfo);
      }
    } while (localPrecoverRetryInfo == null);
    paramPrecoverResource = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      paramPrecoverResource.a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localPrecoverRetryInfo);
      paramPrecoverResource.c();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverManager", 2, new Object[] { "deleteRertyInfo, exception=", localException.getMessage() });
        localException.printStackTrace();
      }
      return;
    }
    finally
    {
      paramPrecoverResource.b();
    }
  }
  
  public void a(PrecoverResource paramPrecoverResource, Object paramObject, long paramLong1, long paramLong2) {}
  
  protected void a(String paramString)
  {
    if (paramString == null) {}
    for (String str = "null";; str = paramString)
    {
      QLog.d("PrecoverManager", 1, new Object[] { "startDownload, businessId=", str });
      ThreadManager.a(new tun(this, paramString), 5, null, false);
      return;
    }
  }
  
  public void a(String paramString, List paramList)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        if (QLog.isColorLevel())
        {
          if (paramString == null)
          {
            str = "null";
            break label125;
            QLog.d("PrecoverManager", 2, new Object[] { "addBusinessRes, businessId=", str, ", resourceList=", localObject });
          }
        }
        else
        {
          boolean bool = TextUtils.isEmpty(paramString);
          if ((!bool) && (paramList != null)) {
            continue;
          }
          return;
        }
        String str = paramString;
        break label125;
        localObject = paramList;
        continue;
        paramString = new tuo(this, paramString, paramList);
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          ThreadManager.a(paramString, 5, null, false);
          continue;
        }
        paramString.run();
      }
      finally {}
      continue;
      label125:
      if (paramList == null) {
        localObject = "null";
      }
    }
  }
  
  public void a(List arg1)
  {
    Object localObject1;
    if (??? == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      Object localObject3;
      Object localObject5;
      try
      {
        QLog.d("PrecoverManager", 1, new Object[] { "onHandleConfigs, configList.size=", localObject1 });
        if ((??? == null) || (???.size() == 0))
        {
          a(PrecoverConfig.class);
          a(PrecoverResource.class);
          return;
          localObject1 = Integer.valueOf(???.size());
          continue;
        }
        a(PrecoverConfig.class);
        localObject3 = new HashMap();
        localObject1 = new HashMap();
        ??? = ???.iterator();
        Object localObject4;
        if (???.hasNext())
        {
          localObject4 = (Pair)???.next();
          if ((localObject4 == null) || (TextUtils.isEmpty((CharSequence)((Pair)localObject4).second))) {
            continue;
          }
          int i = ((Integer)((Pair)localObject4).first).intValue();
          localObject5 = PrecoverUtils.a((String)((Pair)localObject4).second);
          if ((localObject5 == null) || (((Pair)localObject5).first == null) || (((Pair)localObject5).second == null)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, new Object[] { "onHandleConfigs, businessid=", ((PrecoverBusinessInfo)((Pair)localObject5).first).a, ", name=", ((PrecoverBusinessInfo)((Pair)localObject5).first).b, ", list.size=", Integer.valueOf(((List)((Pair)localObject5).second).size()) });
          }
          if (TextUtils.isEmpty(((PrecoverBusinessInfo)((Pair)localObject5).first).a)) {
            continue;
          }
          String str = ((PrecoverBusinessInfo)((Pair)localObject5).first).a;
          if ((((HashMap)localObject3).containsKey(str)) && (((Integer)((HashMap)localObject3).get(str)).intValue() >= i)) {
            continue;
          }
          ((HashMap)localObject3).put(str, Integer.valueOf(i));
          ((HashMap)localObject1).put(str, ((Pair)localObject5).second);
          a(new PrecoverConfig(str, (String)((Pair)localObject4).second, i));
          continue;
        }
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          a(PrecoverResource.class);
          do
          {
            localObject3 = ((HashMap)localObject1).keySet().iterator();
            while (!((Iterator)localObject4).hasNext())
            {
              do
              {
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject4 = (List)((HashMap)localObject1).get((String)((Iterator)localObject3).next());
              } while ((localObject4 == null) || (((List)localObject4).size() <= 0));
              localObject4 = ((List)localObject4).iterator();
            }
            localObject5 = (PrecoverResource)((Iterator)localObject4).next();
            if (!((PrecoverResource)localObject5).isValid()) {
              break;
            }
            a((Entity)localObject5);
          } while (!QLog.isColorLevel());
          QLog.d("PrecoverManager", 2, "onHandleConfigs, insert res:" + localObject5);
        }
      }
      finally {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "onHandleConfigs, res invalid:" + localObject5);
        }
      }
      ??? = new StringBuilder();
      if (((HashMap)localObject2).size() > 0)
      {
        ???.append(" WHERE businessId NOT IN (");
        Iterator localIterator = ((HashMap)localObject2).keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (String)localIterator.next();
          ???.append("'").append((String)localObject3).append("',");
        }
        ???.setCharAt(???.length() - 1, ')');
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, "onHandleConfigs, selection of sql=" + ???.toString());
      }
      a("DELETE FROM " + PrecoverResourceBusiness.class.getSimpleName() + ???.toString());
      a("DELETE FROM " + PrecoverRetryInfo.class.getSimpleName() + ???.toString());
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_config_cover");
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverManager", 2, new Object[] { "checkReportConfigCover, succ=", Boolean.valueOf(paramBoolean), ", need=", Boolean.valueOf(bool) });
    }
    if (bool)
    {
      PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_config_cover");
      this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverReporter.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "get_config_time");
    int j = PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "get_config_count", 0);
    if (bool)
    {
      PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "get_config_time");
      PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "get_config_count", 1);
      return true;
    }
    if (a() != null) {}
    for (int i = a().m; j >= i; i = 5) {
      return false;
    }
    PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "get_config_count", j + 1);
    return true;
  }
  
  protected boolean a(PrecoverResource paramPrecoverResource)
  {
    if ((paramPrecoverResource == null) || (!paramPrecoverResource.isValid())) {}
    do
    {
      PrecoverRetryInfo localPrecoverRetryInfo;
      long l;
      do
      {
        do
        {
          return false;
          if (b()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("PrecoverManager", 2, "canDownload, networkRight, return false");
        return false;
        localPrecoverRetryInfo = a(paramPrecoverResource);
        l = System.currentTimeMillis();
        if (localPrecoverRetryInfo == null)
        {
          localPrecoverRetryInfo = new PrecoverRetryInfo();
          localPrecoverRetryInfo.businessId = paramPrecoverResource.businessId;
          localPrecoverRetryInfo.md5 = paramPrecoverResource.md5;
          localPrecoverRetryInfo.itemRetryCount = 1;
          localPrecoverRetryInfo.totalRetryCount = 1;
          localPrecoverRetryInfo.retryUpdateTime = l;
          a(localPrecoverRetryInfo);
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, "canDownload, info == null, return true");
          }
          return true;
        }
        if (localPrecoverRetryInfo.totalRetryCount <= this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl.j) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PrecoverManager", 2, "canDownload, info.totalRetryCount > mControl.totalRetry, return false");
      return false;
      if (Math.abs(l - localPrecoverRetryInfo.retryUpdateTime) > 86400000L)
      {
        localPrecoverRetryInfo.itemRetryCount = 1;
        localPrecoverRetryInfo.totalRetryCount += 1;
        localPrecoverRetryInfo.retryUpdateTime = l;
        a(localPrecoverRetryInfo);
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "canDownload, daily count expire, return true");
        }
        return true;
      }
      if (localPrecoverRetryInfo.itemRetryCount < this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverControl.i)
      {
        localPrecoverRetryInfo.itemRetryCount += 1;
        localPrecoverRetryInfo.totalRetryCount += 1;
        localPrecoverRetryInfo.retryUpdateTime = l;
        a(localPrecoverRetryInfo);
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "canDownload, info.itemRetryCount < mControl.itemRetry, return true");
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PrecoverManager", 2, "canDownload, return false");
    return false;
  }
  
  protected boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      if (paramString != null) {
        break label64;
      }
    }
    for (localObject = "null";; localObject = paramString)
    {
      QLog.d("PrecoverManager", 2, new Object[] { "execSql, businessId=", localObject });
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        ((EntityTransaction)localObject).a();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
        ((EntityTransaction)localObject).c();
        return true;
      }
      catch (Exception paramString)
      {
        label64:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PrecoverManager", 2, new Object[] { "execSql, exception=", paramString.getMessage() });
        paramString.printStackTrace();
        return false;
      }
      finally
      {
        ((EntityTransaction)localObject).b();
      }
    }
  }
  
  public PrecoverResource b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    return (PrecoverResource)this.b.get(paramString1 + "_" + paramString2);
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\precover\PrecoverManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */