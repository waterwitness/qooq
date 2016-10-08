package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import pzp;
import pzq;
import pzr;
import pzs;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PushPeopleMayKnow;

public class MayknowRecommendManager
  implements Manager
{
  public static int a = 0;
  public static long a = 0L;
  public static final String a = "MayknowRecommendManager";
  private static int jdField_b_of_type_Int = 70;
  public static final String b = "EntranceId";
  private static final String c = "sp_get_mayknow_timestamp";
  private static final String d = "sp_report_explosure_time";
  private static final String e = "sp_config_version";
  private static final String f = "sp_report_interval";
  private static final String g = "sp_config_showcount";
  private static final String h = "sp_config_expectcount";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new pzr(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private volatile boolean jdField_a_of_type_Boolean;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private volatile boolean jdField_b_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Long = 86400000L;
    jdField_a_of_type_Int = 37;
  }
  
  public MayknowRecommendManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(jdField_b_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.b());
    this.jdField_a_of_type_MqqOsMqqHandler.post(new pzp(this));
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private ArrayList a(ArrayList paramArrayList)
  {
    if (paramArrayList.size() == 0) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)paramArrayList.next();
      if (!localFriendsManager.b(localMayKnowRecommend.uin))
      {
        if (localFriendsManager.d(localMayKnowRecommend.uin)) {}
        for (int i = 1;; i = 0)
        {
          localMayKnowRecommend.friendStatus = i;
          localArrayList.add(localMayKnowRecommend);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.aX, 0, true, false);
    MessageRecord localMessageRecord = MessageRecordFactory.a(64536);
    localMessageRecord.msgtype = 64536;
    localMessageRecord.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localMessageRecord.frienduin = AppConstants.aX;
    localMessageRecord.senderuin = AppConstants.aX;
    localMessageRecord.istroop = 0;
    localMessageRecord.msg = paramString;
    localMessageRecord.time = paramLong;
    ((ChatMessage)localMessageRecord).parse();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a("handleGetSystemMsgResp", true, 1, true, false);
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(MayKnowExposure.class, false, null, null, null, null, null, null);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            MayKnowExposure localMayKnowExposure = (MayKnowExposure)((Iterator)localObject1).next();
            localMayKnowExposure = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(MayKnowExposure.generateKey(localMayKnowExposure), localMayKnowExposure);
            continue;
          }
        }
        this.jdField_b_of_type_Boolean = true;
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_report_explosure_time", 0L);
        jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_report_interval", 86400000L);
        if (Math.abs(System.currentTimeMillis() - l) > jdField_a_of_type_Long)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() == 1) {
            e();
          }
        }
        else
        {
          jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_showcount", 37);
          jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_expectcount", 70);
          localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(MayKnowRecommend.class, false, null, null, null, null, null, null);
          if (localObject1 != null) {
            this.jdField_a_of_type_JavaUtilArrayList = a((ArrayList)localObject1);
          }
          localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(PushRecommend.class, false, null, null, null, null, null, null);
          if (localObject1 != null) {
            this.jdField_b_of_type_JavaUtilArrayList = a((ArrayList)localObject1);
          }
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(92, true, null);
          return;
        }
      }
      finally {}
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new pzq(this), 5000L);
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 73	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 323	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7: invokestatic 329	com/tencent/component/network/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: invokestatic 334	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +48 -> 65
    //   20: ldc 15
    //   22: iconst_2
    //   23: new 336	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 339
    //   33: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 91	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   40: invokevirtual 344	java/util/concurrent/ConcurrentHashMap:size	()I
    //   43: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: ldc_w 349
    //   49: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 269	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_b_of_type_Boolean	Z
    //   56: invokevirtual 352	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   59: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_0
    //   66: getfield 91	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: invokevirtual 344	java/util/concurrent/ConcurrentHashMap:size	()I
    //   72: ifle -59 -> 13
    //   75: aload_0
    //   76: getfield 269	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_b_of_type_Boolean	Z
    //   79: ifeq -66 -> 13
    //   82: ldc 15
    //   84: monitorenter
    //   85: aload_0
    //   86: iconst_1
    //   87: putfield 360	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_Boolean	Z
    //   90: ldc 15
    //   92: monitorexit
    //   93: aload_0
    //   94: getfield 73	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   97: iconst_1
    //   98: invokevirtual 305	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   101: checkcast 307	com/tencent/mobileqq/app/FriendListHandler
    //   104: aload_0
    //   105: getfield 91	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   108: invokevirtual 363	com/tencent/mobileqq/app/FriendListHandler:a	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   111: invokestatic 334	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq -101 -> 13
    //   117: aload_0
    //   118: getfield 91	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   121: invokevirtual 367	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   124: invokeinterface 370 1 0
    //   129: astore_1
    //   130: aload_1
    //   131: invokeinterface 153 1 0
    //   136: ifeq -123 -> 13
    //   139: aload_1
    //   140: invokeinterface 157 1 0
    //   145: checkcast 372	java/util/Map$Entry
    //   148: astore_2
    //   149: ldc 15
    //   151: iconst_2
    //   152: new 336	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 374
    //   162: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_2
    //   166: invokeinterface 377 1 0
    //   171: checkcast 379	java/lang/String
    //   174: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 381
    //   180: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_2
    //   184: invokeinterface 384 1 0
    //   189: checkcast 250	com/tencent/mobileqq/data/MayKnowExposure
    //   192: getfield 387	com/tencent/mobileqq/data/MayKnowExposure:exposeCnt	I
    //   195: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc_w 389
    //   201: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_2
    //   205: invokeinterface 384 1 0
    //   210: checkcast 250	com/tencent/mobileqq/data/MayKnowExposure
    //   213: getfield 392	com/tencent/mobileqq/data/MayKnowExposure:exposeTime	I
    //   216: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: goto -95 -> 130
    //   228: astore_1
    //   229: ldc 15
    //   231: monitorexit
    //   232: aload_1
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	MayknowRecommendManager
    //   129	11	1	localIterator	Iterator
    //   228	5	1	localObject	Object
    //   148	57	2	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   85	93	228	finally
    //   229	232	228	finally
  }
  
  public int a()
  {
    int i = 0;
    label75:
    label80:
    for (;;)
    {
      int j;
      try
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          i = 0;
          if (!localIterator.hasNext()) {
            break label80;
          }
          if (!((PushRecommend)localIterator.next()).isReaded) {
            break label75;
          }
          j = 0;
        }
        else
        {
          return i;
        }
      }
      finally {}
      for (;;)
      {
        i += j;
        break;
        j = 1;
      }
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "markAllPushRecommendReaded size=" + this.jdField_b_of_type_JavaUtilArrayList.size());
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      try
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          MayKnowRecommend localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
          ((PushRecommend)localMayKnowRecommend).isReaded = true;
          a(localMayKnowRecommend);
          continue;
          localObject2 = finally;
        }
      }
      finally {}
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityTransaction.c();
    localEntityTransaction.b();
  }
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramString != null)
        {
          int i = Integer.valueOf(paramString.optString("reportInterval").trim()).intValue();
          if ((i <= 86400000) && (i > 0)) {
            jdField_a_of_type_Long = i;
          }
          i = Integer.valueOf(paramString.optString("showCount").trim()).intValue();
          if ((i > 0) && (i <= 100)) {
            jdField_a_of_type_Int = i;
          }
          i = Integer.valueOf(paramString.optString("totalCount").trim()).intValue();
          if ((i <= 100) && (i > 0)) {
            jdField_b_of_type_Int = i;
          }
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_report_interval", jdField_a_of_type_Long).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_showcount", jdField_a_of_type_Int).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_expectcount", jdField_b_of_type_Int).commit();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_config_version", paramInt).commit();
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MayknowRecommendManager", 2, "updateConfigs error " + paramString.getMessage());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "timeInterval = " + jdField_a_of_type_Long + ",showCount=" + jdField_a_of_type_Int + ",expectCount=" + jdField_b_of_type_Int);
    }
  }
  
  public void a(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      String str;
      try
      {
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
          return;
        }
        str = MayKnowExposure.generateKey(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
        {
          paramMayKnowRecommend = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "recordtartExpose " + paramMayKnowRecommend.toString());
          }
          if (paramInt3 != 1) {
            paramMayKnowRecommend.exposeCnt += 1;
          }
          if ((paramMayKnowRecommend.startExploseTime != 0L) || (paramInt3 != 1)) {
            break;
          }
          paramMayKnowRecommend.startExploseTime = SystemClock.uptimeMillis();
          return;
        }
      }
      finally {}
      paramMayKnowRecommend = new MayKnowExposure(paramMayKnowRecommend.uin, paramInt1, paramInt2, paramInt3, paramMayKnowRecommend.algBuffer);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramMayKnowRecommend);
    }
  }
  
  public void a(String paramString)
  {
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
    int i = 0;
    MayKnowRecommend localMayKnowRecommend;
    if (i < localArrayList.size())
    {
      localMayKnowRecommend = (MayKnowRecommend)localArrayList.get(i);
      if (!localMayKnowRecommend.uin.equals(paramString)) {}
    }
    for (;;)
    {
      if (localMayKnowRecommend != null)
      {
        localArrayList.remove(localMayKnowRecommend);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localMayKnowRecommend);
      }
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
      localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      Iterator localIterator = localArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMayKnowRecommend = (MayKnowRecommend)localIterator.next();
      } while (!((PushRecommend)localMayKnowRecommend).uin.equals(paramString));
      for (paramString = localMayKnowRecommend;; paramString = null)
      {
        if (paramString != null)
        {
          localArrayList.remove(paramString);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
        }
        this.jdField_b_of_type_JavaUtilArrayList = localArrayList;
        return;
        i += 1;
        break;
      }
      localMayKnowRecommend = null;
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "updateMayKnowRecommend fromPush=" + paramBoolean + " pushTime=" + paramLong);
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    this.jdField_a_of_type_JavaUtilArrayList = a(paramArrayList);
    label380:
    do
    {
      Object localObject;
      for (;;)
      {
        int i;
        try
        {
          localEntityTransaction.a();
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b("delete from MayKnowRecommend");
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break label380;
          }
          paramArrayList = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (paramArrayList.hasNext())
          {
            a((MayKnowRecommend)paramArrayList.next());
            continue;
          }
          PushRecommend localPushRecommend;
          paramArrayList = PushRecommend.copyRecommend(paramArrayList, paramLong);
        }
        catch (Exception paramArrayList)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "updateMayKnowRecommend ex", paramArrayList);
          }
          return;
          if (!paramBoolean) {
            break label380;
          }
          i = 0;
          if ((i >= 3) || (i >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
            break;
          }
          paramArrayList = (MayKnowRecommend)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          try
          {
            localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
            if (((Iterator)localObject).hasNext())
            {
              localPushRecommend = (PushRecommend)((Iterator)localObject).next();
              if (!localPushRecommend.uin.equals(paramArrayList.uin)) {
                continue;
              }
              ((Iterator)localObject).remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localPushRecommend);
              continue;
              paramArrayList = finally;
            }
          }
          finally {}
        }
        finally
        {
          localEntityTransaction.b();
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(paramArrayList);
        a(paramArrayList);
        i += 1;
      }
      try
      {
        if (this.jdField_b_of_type_JavaUtilArrayList.size() > 80)
        {
          paramArrayList = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          while (paramArrayList.hasNext()) {
            if (this.jdField_b_of_type_JavaUtilArrayList.size() > 80)
            {
              localObject = (MayKnowRecommend)paramArrayList.next();
              paramArrayList.remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject);
            }
          }
        }
      }
      finally {}
      localEntityTransaction.c();
      localEntityTransaction.b();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_get_mayknow_timestamp", System.currentTimeMillis()).commit();
    } while (!paramBoolean);
    paramArrayList = (MayKnowRecommend)this.jdField_b_of_type_JavaUtilArrayList.get(0);
    if (paramArrayList == null)
    {
      paramArrayList = "";
      if (!TextUtils.isEmpty(paramArrayList)) {
        break label501;
      }
    }
    label501:
    for (paramArrayList = "你有可能认识的人";; paramArrayList = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369713), new Object[] { paramArrayList }))
    {
      a(paramArrayList, paramLong);
      return;
      if (TextUtils.isEmpty(paramArrayList.remark))
      {
        if (TextUtils.isEmpty(paramArrayList.nick))
        {
          paramArrayList = paramArrayList.uin;
          break;
        }
        paramArrayList = paramArrayList.nick;
        break;
      }
      paramArrayList = paramArrayList.remark;
      break;
    }
  }
  
  public void a(SubMsgType0xae.MsgBody paramMsgBody)
  {
    if ((paramMsgBody != null) && (paramMsgBody.uint32_type.get() == 1))
    {
      long l = paramMsgBody.msg_people_may_konw.fixed32_timestamp.get();
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "handleMayknowRecommend receive push time=" + l);
      }
      a(true, l);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b("delete from MayKnowExposure");
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "onReportExplosures , success");
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_report_explosure_time", System.currentTimeMillis());
    }
    try
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new pzs(this, paramBoolean, paramLong));
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
      }
    }
    QLog.d("MayknowRecommendManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("sp_config_version", 0);
  }
  
  public ArrayList b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public void b()
  {
    a(false, 0L);
  }
  
  public void b(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        return;
      }
      paramMayKnowRecommend = MayKnowExposure.generateKey(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramMayKnowRecommend))
      {
        paramMayKnowRecommend = (MayKnowExposure)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramMayKnowRecommend);
        if ((paramInt3 == 1) && (paramMayKnowRecommend.startExploseTime != 0L))
        {
          paramMayKnowRecommend.exposeTime = ((int)(SystemClock.uptimeMillis() - paramMayKnowRecommend.startExploseTime + paramMayKnowRecommend.exposeTime));
          paramMayKnowRecommend.exposeCnt += 1;
          if (QLog.isColorLevel()) {
            QLog.d("MayknowRecommendManager", 2, "recordStopExpose " + paramMayKnowRecommend.toString() + ";stopExploseTime: " + SystemClock.uptimeMillis());
          }
          paramMayKnowRecommend.startExploseTime = 0L;
          return;
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: ldc 15
    //   2: monitorenter
    //   3: aload_0
    //   4: iconst_0
    //   5: putfield 269	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_b_of_type_Boolean	Z
    //   8: ldc 15
    //   10: monitorexit
    //   11: aload_0
    //   12: getfield 91	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: invokevirtual 367	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   18: invokeinterface 370 1 0
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 86	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   28: invokevirtual 401	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 405	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   36: aload_2
    //   37: invokeinterface 153 1 0
    //   42: ifeq +65 -> 107
    //   45: aload_2
    //   46: invokeinterface 157 1 0
    //   51: checkcast 372	java/util/Map$Entry
    //   54: invokeinterface 384 1 0
    //   59: checkcast 250	com/tencent/mobileqq/data/MayKnowExposure
    //   62: astore_3
    //   63: aload_3
    //   64: getfield 387	com/tencent/mobileqq/data/MayKnowExposure:exposeCnt	I
    //   67: ifle -31 -> 36
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 408	com/tencent/mobileqq/app/MayknowRecommendManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   75: pop
    //   76: goto -40 -> 36
    //   79: astore_2
    //   80: invokestatic 334	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +13 -> 96
    //   86: ldc 15
    //   88: iconst_2
    //   89: ldc_w 632
    //   92: aload_2
    //   93: invokestatic 634	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   96: aload_1
    //   97: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   100: return
    //   101: astore_1
    //   102: ldc 15
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    //   107: aload_1
    //   108: invokevirtual 412	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   111: invokestatic 334	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +35 -> 149
    //   117: ldc 15
    //   119: iconst_2
    //   120: new 336	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   127: ldc_w 636
    //   130: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: getfield 91	com/tencent/mobileqq/app/MayknowRecommendManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   137: invokevirtual 344	java/util/concurrent/ConcurrentHashMap:size	()I
    //   140: invokevirtual 347	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_1
    //   150: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   153: return
    //   154: astore_2
    //   155: aload_1
    //   156: invokevirtual 410	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   159: aload_2
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	MayknowRecommendManager
    //   31	66	1	localEntityTransaction	EntityTransaction
    //   101	55	1	localObject1	Object
    //   23	23	2	localIterator	Iterator
    //   79	14	2	localException	Exception
    //   154	6	2	localObject2	Object
    //   62	10	3	localMayKnowExposure	MayKnowExposure
    // Exception table:
    //   from	to	target	type
    //   32	36	79	java/lang/Exception
    //   36	76	79	java/lang/Exception
    //   107	149	79	java/lang/Exception
    //   3	11	101	finally
    //   102	105	101	finally
    //   32	36	154	finally
    //   36	76	154	finally
    //   80	96	154	finally
    //   107	149	154	finally
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    c();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\MayknowRecommendManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */