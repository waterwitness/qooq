package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.model.ArDownloadInfo;
import com.tencent.mobileqq.ar.model.ArResourceInfo;
import com.tencent.mobileqq.ar.model.ModelResource;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import mqq.manager.Manager;
import qpj;

public class ArResourceManager
  implements Handler.Callback, Manager
{
  public static final int a = 86400000;
  public static final String a = "ArConfig_ArResourceManager";
  public static final int b = 1;
  public static final String b = "key_config_version";
  public static final int c = 2;
  public static final String c = "key_ar_entrance_effect_version";
  public static final int d = 3;
  public static final String d = "pref_ar_config";
  public static final int e = 4;
  public static final String e = "ar_feature/";
  public static final String f = "ar_model/";
  public static final String g = "_signature.db";
  public static final String h = "_model.zip";
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public ArDownloadDPC a;
  public ArResourceDownload a;
  protected volatile ArConfigInfo a;
  protected volatile ArEffectConfig a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Vector jdField_a_of_type_JavaUtilVector;
  private boolean jdField_a_of_type_Boolean;
  private Handler b;
  public String i;
  
  public ArResourceManager(AppInterface paramAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilVector = new Vector();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramAppInterface.a().getSharedPreferences("pref_ar_config" + paramAppInterface.getAccount(), 0);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.b = new Handler(Looper.getMainLooper(), this);
    this.i = ArConfigUtils.a();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().createEntityManager();
    ThreadManager.a(new qpj(this), 8, null, true);
    this.jdField_a_of_type_ComTencentMobileqqArArResourceDownload = new ArResourceDownload(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this);
  }
  
  public int a()
  {
    ArConfigInfo localArConfigInfo = a();
    int j = 0;
    if (localArConfigInfo != null) {
      j = localArConfigInfo.version;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "getLocalVersion | version = " + j);
    }
    return j;
  }
  
  public ArConfigInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo == null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = ArConfigInfo.loadConfigFromFile(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount());
      return this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
    }
    finally {}
  }
  
  public ArEffectConfig a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = ArEffectConfig.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
  }
  
  /* Error */
  public ArDownloadInfo a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 189	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_0
    //   18: getfield 130	com/tencent/mobileqq/ar/ArResourceManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   21: ldc -65
    //   23: aload_1
    //   24: invokevirtual 196	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   27: checkcast 191	com/tencent/mobileqq/ar/model/ArDownloadInfo
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -23 -> 13
    //   39: ldc 14
    //   41: iconst_2
    //   42: new 74	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   49: ldc -58
    //   51: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_2
    //   65: astore_1
    //   66: goto -53 -> 13
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	ArResourceManager
    //   0	74	1	paramString	String
    //   30	35	2	localArDownloadInfo	ArDownloadInfo
    //   6	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	69	finally
    //   17	31	69	finally
    //   33	64	69	finally
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = null;
      ArConfigInfo.deleteConfigFile(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Vector localVector = this.jdField_a_of_type_JavaUtilVector;
    paramInt2 = 0;
    for (;;)
    {
      try
      {
        if (paramInt2 < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(paramInt2);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.jdField_a_of_type_JavaUtilVector;
            int j = paramInt2 - 1;
            ((Vector)localObject1).remove(paramInt2);
            paramInt2 = j;
          }
          else
          {
            ((IArConfigListener)((WeakReference)localObject1).get()).a(paramInt1);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      paramInt2 += 1;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Vector localVector = this.jdField_a_of_type_JavaUtilVector;
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(j);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.jdField_a_of_type_JavaUtilVector;
            int k = j - 1;
            ((Vector)localObject1).remove(j);
            j = k;
          }
          else
          {
            ((IArConfigListener)((WeakReference)localObject1).get()).a(paramLong1, paramLong2);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      j += 1;
    }
  }
  
  void a(IArConfigListener paramIArConfigListener)
  {
    if (paramIArConfigListener != null) {
      this.jdField_a_of_type_JavaUtilVector.add(new WeakReference(paramIArConfigListener));
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "handleNewConfig");
    }
    if (paramArConfigInfo == null) {
      return;
    }
    Object localObject1 = paramArConfigInfo.featureResources.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ArResourceInfo)((Iterator)localObject1).next();
      ((ArResourceInfo)localObject2).n = (this.i + "ar_feature/" + ((ArResourceInfo)localObject2).c + File.separator + ((ArResourceInfo)localObject2).e + "_signature.db");
      ((ArResourceInfo)localObject2).g = (this.i + "ar_model/" + ((ArResourceInfo)localObject2).c + File.separator);
      ((ArResourceInfo)localObject2).f = (((ArResourceInfo)localObject2).g + ((ArResourceInfo)localObject2).f);
      ((ArResourceInfo)localObject2).h = (((ArResourceInfo)localObject2).g + ((ArResourceInfo)localObject2).h);
      ((ArResourceInfo)localObject2).i = (((ArResourceInfo)localObject2).g + ((ArResourceInfo)localObject2).i);
    }
    localObject1 = paramArConfigInfo.modelResources.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ModelResource)((Iterator)localObject1).next();
      ((ModelResource)localObject2).c = (this.i + "ar_model/" + ((ModelResource)localObject2).a + File.separator + ((ModelResource)localObject2).b + "_model.zip");
    }
    int j;
    if (a(paramArConfigInfo))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilVector;
      j = 0;
    }
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilVector.size())
        {
          localObject2 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(j);
          if ((localObject2 == null) || (((WeakReference)localObject2).get() == null))
          {
            localObject2 = this.jdField_a_of_type_JavaUtilVector;
            int k = j - 1;
            ((Vector)localObject2).remove(j);
            j = k;
            break label433;
          }
          ((IArConfigListener)((WeakReference)localObject2).get()).a(paramArConfigInfo);
          break label433;
        }
        a(true, true);
        return;
      }
      finally {}
      a();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_ArResourceManager", 2, "saveArConfigToFile error!");
      return;
      label433:
      j += 1;
    }
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    if (paramArEffectConfig == null) {
      return;
    }
    Vector localVector;
    int j;
    if (ArEffectConfig.a(paramArEffectConfig))
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = paramArEffectConfig;
      localVector = this.jdField_a_of_type_JavaUtilVector;
      j = 0;
    }
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(j);
          if ((localObject == null) || (((WeakReference)localObject).get() == null))
          {
            localObject = this.jdField_a_of_type_JavaUtilVector;
            int k = j - 1;
            ((Vector)localObject).remove(j);
            j = k;
            break label132;
          }
          ((IArConfigListener)((WeakReference)localObject).get()).a(paramArEffectConfig);
          break label132;
        }
        return;
      }
      finally {}
      b();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ArConfig_ArResourceManager", 2, "saveArEffectInfoToFile error!");
      return;
      label132:
      j += 1;
    }
  }
  
  /* Error */
  public void a(ArDownloadInfo paramArDownloadInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 130	com/tencent/mobileqq/ar/ArResourceManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: invokevirtual 319	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   16: astore_2
    //   17: aload_2
    //   18: invokevirtual 322	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   21: aload_0
    //   22: getfield 130	com/tencent/mobileqq/ar/ArResourceManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   25: aload_1
    //   26: invokevirtual 325	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   29: aload_2
    //   30: invokevirtual 327	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   33: aload_2
    //   34: invokevirtual 328	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   37: goto -31 -> 6
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 331	java/lang/Exception:printStackTrace	()V
    //   56: aload_2
    //   57: invokevirtual 328	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   60: goto -54 -> 6
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 328	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	ArResourceManager
    //   0	70	1	paramArDownloadInfo	ArDownloadInfo
    //   16	49	2	localEntityTransaction	EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   9	17	40	finally
    //   33	37	40	finally
    //   56	60	40	finally
    //   64	70	40	finally
    //   17	33	45	java/lang/Exception
    //   17	33	63	finally
    //   46	56	63	finally
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      long l;
      ArDownloadInfo localArDownloadInfo;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        l = System.currentTimeMillis();
        localArDownloadInfo = a(paramString);
        if (localArDownloadInfo == null)
        {
          if (paramBoolean) {
            continue;
          }
          localArDownloadInfo = new ArDownloadInfo();
          localArDownloadInfo.md5 = paramString;
          localArDownloadInfo.dailyRetryCount = 1;
          localArDownloadInfo.totalRetryCount = 1;
          localArDownloadInfo.dailyStartTime = l;
          a(localArDownloadInfo);
          continue;
        }
        if (!paramBoolean) {
          break label124;
        }
      }
      finally {}
      localArDownloadInfo.dailyRetryCount = 0;
      localArDownloadInfo.dailyStartTime = l;
      label92:
      paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        paramString.a();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localArDownloadInfo);
        paramString.c();
        paramString.b();
        continue;
        label124:
        if (l - localArDownloadInfo.dailyStartTime >= 86400000L)
        {
          localArDownloadInfo.dailyRetryCount = 1;
          localArDownloadInfo.dailyStartTime = l;
          localArDownloadInfo.totalRetryCount += 1;
          break label92;
        }
        localArDownloadInfo.dailyRetryCount += 1;
        localArDownloadInfo.totalRetryCount += 1;
        break label92;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        paramString.b();
      }
      finally
      {
        paramString.b();
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, Object paramObject)
  {
    if (!this.jdField_a_of_type_Boolean) {
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          if (!paramBoolean) {
            break label46;
          }
        }
        label46:
        for (Handler localHandler = this.b;; localHandler = this.jdField_a_of_type_AndroidOsHandler)
        {
          localHandler.sendMessageDelayed(Message.obtain(localHandler, paramInt, 0, 0, paramObject), paramLong);
          return;
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    if (paramBoolean1)
    {
      j = 1;
      localMessage.arg1 = j;
      if (!paramBoolean2) {
        break label55;
      }
    }
    label55:
    for (int j = k;; j = 0)
    {
      localMessage.arg2 = j;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      j = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) {
      if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.aRBegin <= l) && (l <= this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.aREnd)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      QLog.d("ArConfig_ArResourceManager", 1, "isShowArPort|result=" + bool1);
      return bool1;
      QLog.d("ArConfig_ArResourceManager", 1, "isShowArPort | ArConfigInfo out of date !");
      bool1 = bool2;
      continue;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_ArResourceManager", 2, "isShowArPort | ArConfigInfo is null !");
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  public boolean a(ArConfigInfo paramArConfigInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 67	com/tencent/mobileqq/ar/ArResourceManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   7: invokevirtual 202	com/tencent/common/app/AppInterface:a	()Ljava/lang/String;
    //   10: invokestatic 414	com/tencent/mobileqq/ar/aidl/ArConfigInfo:saveArConfigToFile	(Lcom/tencent/mobileqq/ar/aidl/ArConfigInfo;Ljava/lang/String;)Z
    //   13: ifeq +14 -> 27
    //   16: aload_0
    //   17: aload_1
    //   18: putfield 171	com/tencent/mobileqq/ar/ArResourceManager:jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArConfigInfo;
    //   21: iconst_1
    //   22: istore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_2
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_2
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	ArResourceManager
    //   0	37	1	paramArConfigInfo	ArConfigInfo
    //   22	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	21	32	finally
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = false;
    }
    int k;
    label55:
    label94:
    label105:
    label111:
    do
    {
      do
      {
        return bool1;
        paramString = a(paramString);
        bool1 = bool2;
      } while (paramString == null);
      long l = System.currentTimeMillis();
      int j;
      if (this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC == null)
      {
        j = 3;
        if (this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC != null) {
          break label94;
        }
        k = 1000;
        if (l - paramString.dailyStartTime <= 86400000L) {
          break label111;
        }
        if (paramString.totalRetryCount >= k) {
          break label105;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        return bool1;
        j = this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.h;
        break;
        k = this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.i;
        break label55;
      }
      if (paramString.dailyRetryCount > j) {
        break;
      }
      bool1 = bool2;
    } while (paramString.totalRetryCount <= k);
    return false;
  }
  
  public int b()
  {
    ArEffectConfig localArEffectConfig = a();
    int j = 0;
    if (localArEffectConfig != null) {
      j = localArEffectConfig.a;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArResourceManager", 2, "getEntranceVersion | version = " + j);
    }
    return j;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = new ArEffectConfig();
      ARDeviceController.a().a(this.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig);
    }
    ArEffectConfig.a();
  }
  
  void b(IArConfigListener paramIArConfigListener)
  {
    Vector localVector = this.jdField_a_of_type_JavaUtilVector;
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(j);
          if ((localObject == null) || (((WeakReference)localObject).get() == null))
          {
            localObject = this.jdField_a_of_type_JavaUtilVector;
            int k = j - 1;
            ((Vector)localObject).remove(j);
            j = k;
          }
          else if (((WeakReference)localObject).get() == paramIArConfigListener)
          {
            this.jdField_a_of_type_JavaUtilVector.remove(j);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      j += 1;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        ArConfigInfo localArConfigInfo1 = a();
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource: isAuto" + paramBoolean1);
        }
        if (paramBoolean1)
        {
          a(false, 1, 0L, null);
          a(false, 3, 0L, null);
        }
        boolean bool = ARDeviceController.a().b();
        if (!bool) {
          return;
        }
        if ((localArConfigInfo1 != null) && (paramBoolean1)) {
          a(false, 2, 10000L, null);
        }
        if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("ArConfig_ArResourceManager", 2, "downLoad:isNetSupport = false!");
          continue;
        }
        l = NetConnInfoCenter.getServerTimeMillis();
      }
      finally {}
      long l;
      if ((localArConfigInfo2 != null) && (l <= localArConfigInfo2.aREnd))
      {
        if (paramBoolean1)
        {
          if (!c())
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource, isCanAutoPreDownload = false");
            continue;
          }
          if (!b())
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ArConfig_ArResourceManager", 2, "downloadArResource, isNetworkCanPreDownload = false");
            continue;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqArArResourceDownload.a(localArConfigInfo2, paramBoolean1, paramBoolean2);
      }
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC == null) {}
    for (int j = 0; j == 1; j = this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.g) {
      return true;
    }
    int k = NetworkUtil.a(BaseApplicationImpl.getContext());
    if (j == 0) {
      if ((k != 1) && (k != 4)) {}
    }
    for (bool = true;; bool = true) {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceManager", 2, "isNetworkCanPreDownload,dpcNet=" + j + ", type=" + k);
        }
        return bool;
      } while ((k != 1) && (k != 4) && (k != 3));
    }
  }
  
  public void c()
  {
    bool = true;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC = new ArDownloadDPC();
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.olympic_act_config.name());
    }
    try
    {
      if (((String)localObject).length() <= 0) {
        break label276;
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 9) {
        break label276;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.g = Integer.valueOf(localObject[4]).intValue();
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.h = Integer.valueOf(localObject[5]).intValue();
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.i = Integer.valueOf(localObject[6]).intValue();
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.j = Integer.valueOf(localObject[7]).intValue();
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.k = Integer.valueOf(localObject[8]).intValue();
      j = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArResourceManager", 2, "loadDPCConfig Exception:" + localException.toString());
        }
        int j = 1;
        continue;
        bool = false;
      }
    }
    if (j != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.g = 0;
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.h = 3;
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.i = 1000;
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.j = 1;
      this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.k = 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.j == 1)
    {
      OlympicUtil.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArResourceManager", 2, "loadDPCConfig|dpc:" + this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.toString());
      }
      return;
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC == null) {}
    for (int j = 1; j == 1; j = this.jdField_a_of_type_ComTencentMobileqqArArDownloadDPC.k) {
      return true;
    }
    return false;
  }
  
  public void d()
  {
    Vector localVector = this.jdField_a_of_type_JavaUtilVector;
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilVector.size())
        {
          Object localObject1 = (WeakReference)this.jdField_a_of_type_JavaUtilVector.get(j);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.jdField_a_of_type_JavaUtilVector;
            int k = j - 1;
            ((Vector)localObject1).remove(j);
            j = k;
          }
          else
          {
            ((IArConfigListener)((WeakReference)localObject1).get()).a();
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      j += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1 = true;
    long l = NetConnInfoCenter.getServerTimeMillis();
    int j;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null)
      {
        j = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.version;
        bool1 = false;
      }
      break;
    }
    while (l - this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("ar_config_report_time", 0L) >= 86400000L)
    {
      ArConfigUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), bool1, j);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("ar_config_report_time", l).commit();
      return false;
      if (l - this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("ar_so_report_time", 0L) < 86400000L) {
        break;
      }
      j = BaseApplicationImpl.a.getSharedPreferences("mobileQQ", 0).getInt("ar_native_so_version", 0);
      if (j > 0) {}
      for (bool1 = true;; bool1 = false)
      {
        HashMap localHashMap = new HashMap();
        if (bool1) {}
        for (paramMessage = "1";; paramMessage = "0")
        {
          localHashMap.put("param_FailCode", paramMessage);
          localHashMap.put("ar_so_version", String.valueOf(j));
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), "olympic_ar_native_so_report", bool1, 0L, 0L, localHashMap, null);
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("ar_so_report_time", l).commit();
          return false;
        }
        if ((l - this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("ar_res_report_time", 0L) < 86400000L) || (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo == null)) {
          break;
        }
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.featureResources.iterator();
        do
        {
          if (!paramMessage.hasNext()) {
            break;
          }
        } while (FileUtils.a(((ArResourceInfo)paramMessage.next()).n));
        for (bool1 = false;; bool1 = true)
        {
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.modelResources.iterator();
          do
          {
            bool2 = bool3;
            if (!paramMessage.hasNext()) {
              break;
            }
          } while (FileUtils.a(((ModelResource)paramMessage.next()).c));
          bool2 = false;
          ArConfigUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), bool1, bool2);
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("ar_res_report_time", l).commit();
          return false;
          if (paramMessage.arg1 == 1)
          {
            bool1 = true;
            if (paramMessage.arg2 != 1) {
              break label470;
            }
          }
          for (;;)
          {
            b(bool1, bool2);
            return false;
            bool1 = false;
            break;
            label470:
            bool2 = false;
          }
        }
      }
      j = 0;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ArResourceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */