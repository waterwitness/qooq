package com.tencent.mobileqq.dating;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DatingConfig;
import com.tencent.mobileqq.data.DatingConfigItem;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.data.DatingOthersCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyConfigUtil;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import rdz;
import rea;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;

public class DatingManager
  implements Manager
{
  public static final int a = 0;
  public static long a = 0L;
  public static final String a = "rank_title.cfg";
  public static final int b = 1;
  public static long b = 0L;
  public static final String b = "inprocess_dating_id";
  public static long c = 0L;
  private static final long e = 180000L;
  private byte jdField_a_of_type_Byte;
  private AnchorageManager jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager;
  private DateEventManager jdField_a_of_type_ComTencentMobileqqDatingDateEventManager;
  private DatingCacheDel jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel;
  private DatingCacheMng jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng;
  private RankEventManager jdField_a_of_type_ComTencentMobileqqDatingRankEventManager;
  public NearbyAppInterface a;
  private NearbyConfigUtil jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil;
  protected EntityManager a;
  private Object jdField_a_of_type_JavaLangObject;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  private List jdField_a_of_type_JavaUtilList;
  public boolean[] a;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  public long d;
  
  public DatingManager(NearbyAppInterface paramNearbyAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[] { 0, 0 };
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new DatingManager.2(this, 4);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramNearbyAppInterface.a().createEntityManager();
    this.jdField_a_of_type_Byte = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = Integer.MIN_VALUE;
  }
  
  private void a()
  {
    int j = 1;
    int i = j;
    if (!a().a(2, 1)) {
      if (!a().a(1, 1)) {
        break label36;
      }
    }
    label36:
    for (i = j;; i = 0)
    {
      this.jdField_c_of_type_Int = i;
      return;
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    jdField_a_of_type_Long = ((Long)NearbySPUtil.a(paramString, "DatingManager.maplng", Long.valueOf(0L))).longValue();
    b = ((Long)NearbySPUtil.a(paramString, "DatingManager.maplat", Long.valueOf(0L))).longValue();
    jdField_c_of_type_Long = ((Long)NearbySPUtil.a(paramString, "DatingManager.timestamp", Long.valueOf(0L))).longValue();
  }
  
  public static void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!NearbyUtils.c())
    {
      NearbySPUtil.a(paramString, "DatingManager.maplng", Long.valueOf(paramLong1));
      NearbySPUtil.a(paramString, "DatingManager.maplat", Long.valueOf(paramLong2));
      NearbySPUtil.a(paramString, "DatingManager.timestamp", Long.valueOf(paramLong3));
      return;
    }
    jdField_a_of_type_Long = paramLong1;
    b = paramLong2;
    jdField_c_of_type_Long = paramLong3;
  }
  
  /* Error */
  private void b(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq +82 -> 85
    //   6: aload_2
    //   7: ifnonnull +78 -> 85
    //   10: aload_0
    //   11: getfield 78	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   14: ifnonnull +71 -> 85
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 61	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   22: invokevirtual 139	com/tencent/mobileqq/nearby/NearbyAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   25: aload_0
    //   26: getfield 61	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface	Lcom/tencent/mobileqq/nearby/NearbyAppInterface;
    //   29: invokevirtual 142	com/tencent/mobileqq/nearby/NearbyAppInterface:a	()Ljava/lang/String;
    //   32: iconst_0
    //   33: invokevirtual 148	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   36: ldc 19
    //   38: ldc -106
    //   40: invokeinterface 156 3 0
    //   45: putfield 78	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   48: aload_0
    //   49: getfield 78	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   52: ifnonnull +9 -> 61
    //   55: aload_0
    //   56: ldc -106
    //   58: putfield 78	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   61: ldc -98
    //   63: iconst_2
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: ldc -96
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload_0
    //   75: getfield 78	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   78: aastore
    //   79: invokestatic 165	com/tencent/mobileqq/dating/DatingUtil:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: iload_1
    //   86: ifne -4 -> 82
    //   89: aload_0
    //   90: getfield 78	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   93: astore 4
    //   95: aload_2
    //   96: astore_3
    //   97: aload_2
    //   98: ifnonnull +6 -> 104
    //   101: ldc -106
    //   103: astore_3
    //   104: aload_0
    //   105: aload_3
    //   106: putfield 78	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   109: aload_0
    //   110: getfield 78	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   113: aload 4
    //   115: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifne +18 -> 136
    //   121: invokestatic 176	com/tencent/mobileqq/app/ThreadManager:a	()Lmqq/os/MqqHandler;
    //   124: new 178	rdy
    //   127: dup
    //   128: aload_0
    //   129: invokespecial 181	rdy:<init>	(Lcom/tencent/mobileqq/dating/DatingManager;)V
    //   132: invokevirtual 187	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   135: pop
    //   136: ldc -98
    //   138: iconst_2
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload 4
    //   146: aastore
    //   147: dup
    //   148: iconst_1
    //   149: aload_0
    //   150: getfield 78	com/tencent/mobileqq/dating/DatingManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 189	com/tencent/mobileqq/dating/DatingUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: goto -75 -> 82
    //   160: astore_2
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_2
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	DatingManager
    //   0	165	1	paramBoolean	boolean
    //   0	165	2	paramString	String
    //   96	10	3	str1	String
    //   93	52	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   10	61	160	finally
    //   61	82	160	finally
    //   89	95	160	finally
    //   104	136	160	finally
    //   136	157	160	finally
  }
  
  public int a()
  {
    int i = 1;
    DatingConfig localDatingConfig = a();
    if (localDatingConfig != null) {
      i = localDatingConfig.defaultSubject;
    }
    return i;
  }
  
  public int a(int paramInt)
  {
    DatingConfig localDatingConfig = a();
    if (localDatingConfig != null) {}
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return localDatingConfig.timeStamp;
    }
    return localDatingConfig.timeGap;
  }
  
  public long a()
  {
    return this.d;
  }
  
  public appoint_define.LocaleInfo a()
  {
    Object localObject2 = null;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0);
    long l = ((SharedPreferences)localObject3).getLong("publish_dep_local_time", 0L);
    Object localObject1 = localObject2;
    if (System.currentTimeMillis() - l < 180000L)
    {
      localObject3 = ((SharedPreferences)localObject3).getString("publish_dep_local_msg", null);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = Base64.decode((String)localObject3, 0);
        if (localObject3 == null) {
          break label133;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (localObject3.length > 0)
        {
          localObject1 = new appoint_define.LocaleInfo();
          ((appoint_define.LocaleInfo)localObject1).mergeFrom((byte[])localObject3);
          return (appoint_define.LocaleInfo)localObject1;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.dating", 2, "getDepLocalCache mergeFrom fail|" + localInvalidProtocolBufferMicroException.getMessage());
        return null;
      }
      label133:
      localObject1 = null;
    }
  }
  
  public DatingConfig a()
  {
    try
    {
      DatingConfig localDatingConfig = a().a();
      return localDatingConfig;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public DatingConfigItem a()
  {
    Object localObject = a();
    DatingConfigItem localDatingConfigItem = null;
    if (localObject != null) {
      localDatingConfigItem = ((DatingConfig)localObject).timeRequestConfig;
    }
    localObject = localDatingConfigItem;
    if (localDatingConfigItem == null) {
      localObject = new DatingConfigItem(1800, BaseApplication.getContext().getResources().getString(2131371714));
    }
    return (DatingConfigItem)localObject;
  }
  
  public DatingInfo a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng.a(paramString, paramBoolean, false, false);
    }
    while (!paramBoolean) {
      return null;
    }
    return (DatingInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingInfo.class, paramString);
  }
  
  public AnchorageManager a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager = new AnchorageManager();
      }
      AnchorageManager localAnchorageManager = this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager;
      return localAnchorageManager;
    }
    finally {}
  }
  
  public DateEventManager a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager = new DateEventManager(this);
      }
      DateEventManager localDateEventManager = this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager;
      return localDateEventManager;
    }
    finally {}
  }
  
  public DatingCacheDel a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel = new DatingCacheDel(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
      }
      DatingCacheDel localDatingCacheDel = this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel;
      return localDatingCacheDel;
    }
    finally {}
  }
  
  public DatingCacheMng a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng = new DatingCacheMng(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
      }
      DatingCacheMng localDatingCacheMng = this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng;
      return localDatingCacheMng;
    }
    finally {}
  }
  
  public GodListConfig a(int paramInt)
  {
    Object localObject2 = null;
    List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(GodListConfig.class, new GodListConfig().getTableName(), true, "listType = ?", new String[] { paramInt + "" }, null, null, null, null);
    Object localObject1 = localObject2;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (localList.size() > 0) {
        localObject1 = (GodListConfig)localList.get(0);
      }
    }
    return (GodListConfig)localObject1;
  }
  
  public RankEventManager a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDatingRankEventManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingRankEventManager = new RankEventManager(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      }
      RankEventManager localRankEventManager = this.jdField_a_of_type_ComTencentMobileqqDatingRankEventManager;
      return localRankEventManager;
    }
    finally {}
  }
  
  public NearbyConfigUtil a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil != null) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil == null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil = new NearbyConfigUtil();
      }
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyConfigUtil;
    }
  }
  
  public String a()
  {
    String str = null;
    Object localObject = a();
    if (localObject != null) {
      str = ((DatingConfig)localObject).aioTravelSendMsgTip;
    }
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = BaseApplication.getContext().getResources().getString(2131371855);
    }
    return (String)localObject;
  }
  
  public final String a(int paramInt)
  {
    Object localObject2 = null;
    String str = String.valueOf(paramInt);
    Entity localEntity = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingOthersCache.class, str);
    Object localObject1 = localObject2;
    if (localEntity != null)
    {
      localObject1 = localObject2;
      if (localEntity.getStatus() != 1003) {
        localObject1 = (DatingOthersCache)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(DatingOthersCache.class, str);
      }
    }
    if (localObject1 != null) {
      return ((DatingOthersCache)localObject1).cacheStr;
    }
    return "";
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
    localStringBuilder.append(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "0";
    }
    localStringBuilder.append(paramString1);
    return (String)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localStringBuilder.toString());
  }
  
  public List a()
  {
    ArrayList localArrayList = null;
    Object localObject = a();
    if (localObject != null)
    {
      localArrayList = new ArrayList();
      localObject = ((DatingConfig)localObject).hotLocales.iterator();
      while (((Iterator)localObject).hasNext())
      {
        byte[] arrayOfByte = (byte[])((Iterator)localObject).next();
        try
        {
          appoint_define.LocaleInfo localLocaleInfo = new appoint_define.LocaleInfo();
          localLocaleInfo.mergeFrom(arrayOfByte);
          localArrayList.add(localLocaleInfo);
        }
        catch (Exception localException) {}
      }
    }
    return localArrayList;
  }
  
  public List a(int paramInt)
  {
    int[] arrayOfInt = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject = a();
    if ((localObject != null) && (((DatingConfig)localObject).othersConfigs != null))
    {
      localObject = ((DatingConfig)localObject).othersConfigs;
      if (((HashMap)localObject).containsKey(Integer.valueOf(paramInt))) {
        localArrayList.addAll((Collection)((HashMap)localObject).get(Integer.valueOf(paramInt)));
      }
    }
    if (localArrayList.isEmpty())
    {
      switch (paramInt)
      {
      default: 
        localObject = null;
      }
      while (localObject != null)
      {
        paramInt = 0;
        while (paramInt < localObject.length)
        {
          localArrayList.add(new DatingConfigItem(arrayOfInt[paramInt], localObject[paramInt]));
          paramInt += 1;
        }
        localObject = BaseApplication.getContext().getResources().getStringArray(2131230758);
        arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230766);
        continue;
        localObject = BaseApplication.getContext().getResources().getStringArray(2131230759);
        arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230767);
        continue;
        localObject = BaseApplication.getContext().getResources().getStringArray(2131230760);
        arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230768);
        continue;
        localObject = BaseApplication.getContext().getResources().getStringArray(2131230761);
        arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230769);
        continue;
        localObject = BaseApplication.getContext().getResources().getStringArray(2131230762);
        arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230770);
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("delete from ");
    localStringBuilder.append(new GodEntity().getTableName());
    localStringBuilder.append(" where listType = ");
    localStringBuilder.append(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localStringBuilder.toString());
  }
  
  public final void a(int paramInt, String paramString)
  {
    DatingOthersCache localDatingOthersCache = new DatingOthersCache();
    localDatingOthersCache.subjectID = paramInt;
    localDatingOthersCache.cacheStr = paramString;
    paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      paramString.a();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localDatingOthersCache);
      paramString.c();
      return;
    }
    finally
    {
      paramString.b();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    a().a(paramInt, paramBoolean1, paramArrayList, paramBoolean2);
    a();
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(appoint_define.LocaleInfo paramLocaleInfo)
  {
    ThreadManager.a(new rdz(this, paramLocaleInfo), 8, null, false);
  }
  
  public void a(DatingHandler paramDatingHandler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2) {
      if ((!a().a(paramInt1)) && (a().a(2, paramInt2)))
      {
        a().a(paramInt1, true);
        str = a().a(2);
        if (!TextUtils.isEmpty(str)) {
          break label102;
        }
        paramDatingHandler.a(a().a(2), 3);
        DatingUtil.a("syncDel", new Object[] { "type:" + paramInt1 });
      }
    }
    label102:
    while ((paramInt1 != 1) || (a().a(paramInt1)) || (!a().a(1, paramInt2))) {
      for (;;)
      {
        return;
        paramDatingHandler.c(str, 4);
      }
    }
    a().a(paramInt1, true);
    String str = a().a(1);
    if (TextUtils.isEmpty(str)) {
      paramDatingHandler.b(a().a(1), 1, 0);
    }
    for (;;)
    {
      DatingUtil.a("syncDel", new Object[] { "type:" + paramInt1 });
      return;
      paramDatingHandler.b(str, 2, 0);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a());
    localStringBuilder.append(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "0";
    }
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    if ((this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramString1)) && (TextUtils.isEmpty(paramString3)))
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString1);
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localStringBuilder.toString(), paramString3);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      a().a(paramInt);
    }
    for (;;)
    {
      a().a(paramString, paramBoolean, paramInt);
      a();
      return;
      a().a(paramString, paramInt);
    }
  }
  
  public void a(List paramList, int paramInt, long paramLong)
  {
    if (paramLong == 0L) {
      a(paramInt);
    }
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        GodEntity localGodEntity = (GodEntity)paramList.next();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localGodEntity);
      }
    }
  }
  
  public void a(Oidb_0x686.NearbyRankConfig paramNearbyRankConfig)
  {
    if (paramNearbyRankConfig == null) {
      return;
    }
    ThreadManager.a().post(new rea(this, paramNearbyRankConfig));
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool;
    int i;
    if (this.jdField_a_of_type_Byte == 1)
    {
      bool = true;
      if (bool == paramBoolean) {
        break label128;
      }
      i = 1;
      label19:
      if (i != 0) {
        if (!paramBoolean) {
          break label133;
        }
      }
    }
    label128:
    label133:
    for (byte b1 = 1;; b1 = 2)
    {
      this.jdField_a_of_type_Byte = b1;
      DatingUtil.a("setRemindFlag", new Object[] { "update", Byte.valueOf(this.jdField_a_of_type_Byte) });
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0).edit().putBoolean("isNeedRemindApply", paramBoolean).commit();
      }
      return;
      bool = false;
      break;
      i = 0;
      break label19;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      c(paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0).edit().putBoolean("toplist_sp_typelist_set_refuse_rank", paramBoolean).commit();
  }
  
  public boolean a()
  {
    int i = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "self_age", Integer.valueOf(0))).intValue();
    return (i >= 18) || (i < 0);
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
  
  /* Error */
  public boolean a(List paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_1
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokeinterface 435 1 0
    //   14: ifeq +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: new 389	java/util/ArrayList
    //   22: dup
    //   23: invokespecial 390	java/util/ArrayList:<init>	()V
    //   26: astore 4
    //   28: aload_1
    //   29: invokeinterface 397 1 0
    //   34: astore_1
    //   35: aload_1
    //   36: invokeinterface 402 1 0
    //   41: ifeq +71 -> 112
    //   44: new 603	com/tencent/mobileqq/data/RankTitleConfig
    //   47: dup
    //   48: aload_1
    //   49: invokeinterface 406 1 0
    //   54: checkcast 605	tencent/im/oidb/cmd0x686/Oidb_0x686$RankTitleConfig
    //   57: invokespecial 608	com/tencent/mobileqq/data/RankTitleConfig:<init>	(Ltencent/im/oidb/cmd0x686/Oidb_0x686$RankTitleConfig;)V
    //   60: astore 5
    //   62: aload 4
    //   64: aload 5
    //   66: invokeinterface 411 2 0
    //   71: pop
    //   72: invokestatic 611	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   75: ifeq -40 -> 35
    //   78: ldc_w 613
    //   81: iconst_4
    //   82: new 245	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 615
    //   92: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload 5
    //   97: invokevirtual 616	com/tencent/mobileqq/data/RankTitleConfig:toString	()Ljava/lang/String;
    //   100: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: goto -74 -> 35
    //   112: new 618	java/io/File
    //   115: dup
    //   116: invokestatic 280	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   119: invokevirtual 622	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   122: ldc 15
    //   124: invokespecial 625	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 628	java/io/File:exists	()Z
    //   132: ifeq +8 -> 140
    //   135: aload_1
    //   136: invokevirtual 631	java/io/File:delete	()Z
    //   139: pop
    //   140: new 633	java/io/FileOutputStream
    //   143: dup
    //   144: aload_1
    //   145: invokespecial 636	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   148: astore_1
    //   149: new 638	java/io/ObjectOutputStream
    //   152: dup
    //   153: new 640	java/io/BufferedOutputStream
    //   156: dup
    //   157: aload_1
    //   158: invokespecial 643	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   161: invokespecial 644	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   164: astore_2
    //   165: aload_2
    //   166: aload 4
    //   168: invokevirtual 648	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   171: iconst_1
    //   172: istore 6
    //   174: aload_0
    //   175: aload 4
    //   177: putfield 650	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   180: aload_2
    //   181: invokevirtual 653	java/io/ObjectOutputStream:close	()V
    //   184: aload_1
    //   185: invokevirtual 654	java/io/FileOutputStream:close	()V
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_1
    //   191: iconst_1
    //   192: ireturn
    //   193: astore_1
    //   194: iconst_0
    //   195: istore 6
    //   197: aconst_null
    //   198: astore_1
    //   199: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +13 -> 215
    //   205: ldc_w 613
    //   208: iconst_4
    //   209: ldc_w 656
    //   212: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_1
    //   216: invokevirtual 653	java/io/ObjectOutputStream:close	()V
    //   219: aload_2
    //   220: invokevirtual 654	java/io/FileOutputStream:close	()V
    //   223: iload 6
    //   225: ireturn
    //   226: astore_1
    //   227: iload 6
    //   229: ireturn
    //   230: astore_2
    //   231: aconst_null
    //   232: astore_1
    //   233: aload_3
    //   234: invokevirtual 653	java/io/ObjectOutputStream:close	()V
    //   237: aload_1
    //   238: invokevirtual 654	java/io/FileOutputStream:close	()V
    //   241: aload_2
    //   242: athrow
    //   243: astore_1
    //   244: goto -3 -> 241
    //   247: astore_2
    //   248: goto -15 -> 233
    //   251: astore 4
    //   253: aload_2
    //   254: astore_3
    //   255: aload 4
    //   257: astore_2
    //   258: goto -25 -> 233
    //   261: astore_3
    //   262: aload_2
    //   263: astore 4
    //   265: aload_3
    //   266: astore_2
    //   267: aload_1
    //   268: astore_3
    //   269: aload 4
    //   271: astore_1
    //   272: goto -39 -> 233
    //   275: astore_2
    //   276: iconst_0
    //   277: istore 6
    //   279: aconst_null
    //   280: astore_3
    //   281: aload_1
    //   282: astore_2
    //   283: aload_3
    //   284: astore_1
    //   285: goto -86 -> 199
    //   288: astore_3
    //   289: aload_1
    //   290: astore_3
    //   291: iconst_0
    //   292: istore 6
    //   294: aload_2
    //   295: astore_1
    //   296: aload_3
    //   297: astore_2
    //   298: goto -99 -> 199
    //   301: astore_3
    //   302: aload_1
    //   303: astore_3
    //   304: aload_2
    //   305: astore_1
    //   306: aload_3
    //   307: astore_2
    //   308: goto -109 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	DatingManager
    //   0	311	1	paramList	List
    //   3	217	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   230	12	2	localObject1	Object
    //   247	7	2	localObject2	Object
    //   257	10	2	localObject3	Object
    //   275	1	2	localException1	Exception
    //   282	26	2	localList1	List
    //   1	254	3	localObject4	Object
    //   261	5	3	localObject5	Object
    //   268	16	3	localList2	List
    //   288	1	3	localException2	Exception
    //   290	7	3	localList3	List
    //   301	1	3	localException3	Exception
    //   303	4	3	localList4	List
    //   26	150	4	localArrayList	ArrayList
    //   251	5	4	localObject6	Object
    //   263	7	4	localObject7	Object
    //   60	36	5	localRankTitleConfig	com.tencent.mobileqq.data.RankTitleConfig
    //   172	121	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   180	188	190	java/lang/Exception
    //   140	149	193	java/lang/Exception
    //   215	223	226	java/lang/Exception
    //   140	149	230	finally
    //   233	241	243	java/lang/Exception
    //   149	165	247	finally
    //   165	171	251	finally
    //   174	180	251	finally
    //   199	215	261	finally
    //   149	165	275	java/lang/Exception
    //   165	171	288	java/lang/Exception
    //   174	180	301	java/lang/Exception
  }
  
  public int b()
  {
    return ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "self_gender", Integer.valueOf(0))).intValue();
  }
  
  public String b()
  {
    return BaseApplication.getContext().getResources().getString(2131371808);
  }
  
  public String b(int paramInt)
  {
    String str = null;
    Object localObject = a();
    if (localObject != null) {
      if (paramInt != 5) {
        break label50;
      }
    }
    label50:
    for (str = ((DatingConfig)localObject).aioTravelApplyTip;; str = ((DatingConfig)localObject).aioApllyTips)
    {
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        if (paramInt != 5) {
          break;
        }
        localObject = BaseApplication.getContext().getResources().getString(2131371856);
      }
      return (String)localObject;
    }
    return BaseApplication.getContext().getResources().getString(2131371807);
  }
  
  public List b()
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = a();
    if ((localObject1 != null) && (((DatingConfig)localObject1).cancelReasons != null)) {
      ((List)localObject2).addAll(((DatingConfig)localObject1).cancelReasons);
    }
    localObject1 = localObject2;
    if (((List)localObject2).isEmpty())
    {
      localObject1 = new ArrayList();
      localObject2 = BaseApplication.getContext().getResources().getStringArray(2131230763);
      int[] arrayOfInt = BaseApplication.getContext().getResources().getIntArray(2131230772);
      int i = 0;
      while (i < localObject2.length)
      {
        ((List)localObject1).add(new DatingConfigItem(arrayOfInt[i], localObject2[i]));
        i += 1;
      }
    }
    return (List)localObject1;
  }
  
  public List b(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(GodEntity.class, new GodEntity().getTableName(), true, "listType = ?", new String[] { paramInt + "" }, null, null, null, null);
  }
  
  public void b(String paramString)
  {
    b(false, paramString);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Byte == 0) {
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0).getBoolean("isNeedRemindApply", true)) {
        break label98;
      }
    }
    label98:
    for (byte b1 = 1;; b1 = 2)
    {
      this.jdField_a_of_type_Byte = b1;
      DatingUtil.a("isNeedRemind", new Object[] { "init", Byte.valueOf(this.jdField_a_of_type_Byte) });
      if (this.jdField_a_of_type_Byte != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public String c()
  {
    if (this.jdField_c_of_type_JavaLangString == null) {
      b(true, null);
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  /* Error */
  public List c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 650	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 650	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   16: astore_2
    //   17: aload_2
    //   18: areturn
    //   19: new 618	java/io/File
    //   22: dup
    //   23: invokestatic 280	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   26: invokevirtual 622	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   29: ldc 15
    //   31: invokespecial 625	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 628	java/io/File:exists	()Z
    //   39: ifeq +220 -> 259
    //   42: new 682	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 683	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: astore_1
    //   51: new 685	java/io/ObjectInputStream
    //   54: dup
    //   55: new 687	java/io/BufferedInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 690	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: invokespecial 691	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 694	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   71: checkcast 344	java/util/List
    //   74: astore 5
    //   76: aload_2
    //   77: invokevirtual 695	java/io/ObjectInputStream:close	()V
    //   80: aload_1
    //   81: invokevirtual 696	java/io/FileInputStream:close	()V
    //   84: aload_2
    //   85: invokevirtual 695	java/io/ObjectInputStream:close	()V
    //   88: aload 5
    //   90: astore_1
    //   91: aload_1
    //   92: astore_2
    //   93: aload_1
    //   94: ifnull -77 -> 17
    //   97: aload_0
    //   98: aload_1
    //   99: putfield 650	com/tencent/mobileqq/dating/DatingManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   102: aload_1
    //   103: areturn
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: aconst_null
    //   108: astore_1
    //   109: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +32 -> 144
    //   115: ldc -13
    //   117: iconst_2
    //   118: new 245	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   125: ldc_w 698
    //   128: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_3
    //   132: invokevirtual 699	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_2
    //   145: invokevirtual 696	java/io/FileInputStream:close	()V
    //   148: aload 4
    //   150: invokevirtual 695	java/io/ObjectInputStream:close	()V
    //   153: goto -62 -> 91
    //   156: astore_2
    //   157: goto -66 -> 91
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_2
    //   163: aload_3
    //   164: astore 4
    //   166: aload_2
    //   167: invokevirtual 696	java/io/FileInputStream:close	()V
    //   170: aload 4
    //   172: invokevirtual 695	java/io/ObjectInputStream:close	()V
    //   175: aload_1
    //   176: athrow
    //   177: astore_2
    //   178: goto -3 -> 175
    //   181: astore 4
    //   183: aload_1
    //   184: astore_2
    //   185: aload 4
    //   187: astore_1
    //   188: aload_3
    //   189: astore 4
    //   191: goto -25 -> 166
    //   194: astore 4
    //   196: aload_1
    //   197: astore_3
    //   198: aload 4
    //   200: astore_1
    //   201: aload_2
    //   202: astore 4
    //   204: aload_3
    //   205: astore_2
    //   206: goto -40 -> 166
    //   209: astore_1
    //   210: goto -44 -> 166
    //   213: astore_3
    //   214: aconst_null
    //   215: astore 5
    //   217: aload_1
    //   218: astore_2
    //   219: aload 5
    //   221: astore_1
    //   222: goto -113 -> 109
    //   225: astore_3
    //   226: aconst_null
    //   227: astore 5
    //   229: aload_2
    //   230: astore 4
    //   232: aload_1
    //   233: astore_2
    //   234: aload 5
    //   236: astore_1
    //   237: goto -128 -> 109
    //   240: astore_3
    //   241: aload_2
    //   242: astore 4
    //   244: aload_1
    //   245: astore_2
    //   246: aload 5
    //   248: astore_1
    //   249: goto -140 -> 109
    //   252: astore_1
    //   253: aload 5
    //   255: astore_1
    //   256: goto -165 -> 91
    //   259: aconst_null
    //   260: astore_1
    //   261: goto -170 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	DatingManager
    //   34	75	1	localObject1	Object
    //   160	24	1	localObject2	Object
    //   187	14	1	localObject3	Object
    //   209	9	1	localObject4	Object
    //   221	28	1	localObject5	Object
    //   252	1	1	localException1	Exception
    //   255	6	1	localObject6	Object
    //   16	129	2	localObject7	Object
    //   156	1	2	localException2	Exception
    //   162	5	2	localObject8	Object
    //   177	1	2	localException3	Exception
    //   184	62	2	localObject9	Object
    //   1	1	3	localObject10	Object
    //   104	85	3	localException4	Exception
    //   197	8	3	localObject11	Object
    //   213	1	3	localException5	Exception
    //   225	1	3	localException6	Exception
    //   240	1	3	localException7	Exception
    //   3	168	4	localException8	Exception
    //   181	5	4	localObject12	Object
    //   189	1	4	localException9	Exception
    //   194	5	4	localObject13	Object
    //   202	41	4	localObject14	Object
    //   74	180	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   42	51	104	java/lang/Exception
    //   144	153	156	java/lang/Exception
    //   42	51	160	finally
    //   166	175	177	java/lang/Exception
    //   51	67	181	finally
    //   67	76	194	finally
    //   76	80	194	finally
    //   109	144	209	finally
    //   51	67	213	java/lang/Exception
    //   67	76	225	java/lang/Exception
    //   76	80	240	java/lang/Exception
    //   80	88	252	java/lang/Exception
  }
  
  public void c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      paramString = (GodEntity)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(GodEntity.class, "uin=?", new String[] { paramString });
      if (paramString != null)
      {
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
      }
      if (localEntityTransaction != null) {
        localEntityTransaction.b();
      }
      return;
    }
    catch (Exception paramString)
    {
      localObject2 = localObject1;
      paramString.printStackTrace();
      return;
    }
    finally
    {
      if (localObject2 != null) {
        ((EntityTransaction)localObject2).b();
      }
    }
  }
  
  public boolean c()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(), 0).getBoolean("toplist_hide_boygod_flag", false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_bank", 2, "getBoyGodHideFlag,isHide：" + bool);
    }
    return bool;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheMng.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDateEventManager.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingRankEventManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingRankEventManager.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingCacheDel.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\DatingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */