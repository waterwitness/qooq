package com.tencent.mobileqq.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMessageNavigateInfo;
import com.tencent.mobileqq.data.TroopVideoUrlEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;
import tfi;

public class TroopInfoManager
  extends Observable
  implements Manager
{
  public static final int a = -1;
  public static final long a = -1L;
  protected static final String a;
  public static final int b = 0;
  protected static final String b = "TROOP_INFO_MANAGER_CONFIG";
  public static final int c = 1;
  protected static final String c = "VIDEO_GET_TIME";
  public static final int d = 4;
  public static final int e = 8;
  public static final int f = 10;
  public static final int g = 11;
  public static final int h = 12;
  public static final int i = 13;
  public static final int j = 14;
  public static final int k = 15;
  public static final int l = 17;
  public static final int m = 3;
  protected Handler a;
  protected QQAppInterface a;
  public EntityManager a;
  private HashMap a;
  protected List a;
  protected ConcurrentHashMap a;
  protected boolean a;
  public List b;
  protected ConcurrentHashMap b;
  protected boolean b;
  protected ConcurrentHashMap c;
  protected ConcurrentHashMap d;
  protected ConcurrentHashMap e;
  protected ConcurrentHashMap f;
  protected ConcurrentHashMap g;
  protected int n;
  protected int o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopInfoManager.class.getSimpleName();
  }
  
  /* Error */
  public TroopInfoManager(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 70	java/util/Observable:<init>	()V
    //   4: aload_0
    //   5: new 72	java/util/HashMap
    //   8: dup
    //   9: invokespecial 73	java/util/HashMap:<init>	()V
    //   12: putfield 75	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   15: aload_0
    //   16: new 77	java/util/concurrent/ConcurrentHashMap
    //   19: dup
    //   20: invokespecial 78	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   23: putfield 80	com/tencent/mobileqq/model/TroopInfoManager:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   26: aload_0
    //   27: new 82	tfh
    //   30: dup
    //   31: aload_0
    //   32: invokestatic 87	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Looper;
    //   35: invokespecial 90	tfh:<init>	(Lcom/tencent/mobileqq/model/TroopInfoManager;Landroid/os/Looper;)V
    //   38: putfield 92	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   41: aload_0
    //   42: aload_1
    //   43: putfield 94	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 99	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   51: invokevirtual 105	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   54: putfield 107	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   57: aload_0
    //   58: getfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   61: ifnonnull +25 -> 86
    //   64: aload_0
    //   65: monitorenter
    //   66: aload_0
    //   67: getfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   70: ifnonnull +14 -> 84
    //   73: aload_0
    //   74: new 77	java/util/concurrent/ConcurrentHashMap
    //   77: dup
    //   78: invokespecial 78	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   81: putfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_0
    //   87: getfield 111	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   90: ifnonnull +25 -> 115
    //   93: aload_0
    //   94: monitorenter
    //   95: aload_0
    //   96: getfield 111	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   99: ifnonnull +14 -> 113
    //   102: aload_0
    //   103: new 77	java/util/concurrent/ConcurrentHashMap
    //   106: dup
    //   107: invokespecial 78	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   110: putfield 111	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_0
    //   116: getfield 113	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   119: ifnonnull +25 -> 144
    //   122: aload_0
    //   123: monitorenter
    //   124: aload_0
    //   125: getfield 113	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   128: ifnonnull +14 -> 142
    //   131: aload_0
    //   132: new 77	java/util/concurrent/ConcurrentHashMap
    //   135: dup
    //   136: invokespecial 78	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   139: putfield 113	com/tencent/mobileqq/model/TroopInfoManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_0
    //   145: invokespecial 115	com/tencent/mobileqq/model/TroopInfoManager:f	()V
    //   148: return
    //   149: astore_1
    //   150: aload_0
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: astore_1
    //   155: aload_0
    //   156: monitorexit
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	TroopInfoManager
    //   0	164	1	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   66	84	149	finally
    //   84	86	149	finally
    //   150	152	149	finally
    //   95	113	154	finally
    //   113	115	154	finally
    //   155	157	154	finally
    //   124	142	159	finally
    //   142	144	159	finally
    //   160	162	159	finally
  }
  
  private void b(List paramList)
  {
    Object localObject;
    TroopVideoUrlEntity localTroopVideoUrlEntity;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localObject = this.jdField_b_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localTroopVideoUrlEntity = (TroopVideoUrlEntity)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopVideoUrlEntity);
      }
    }
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        localTroopVideoUrlEntity = new TroopVideoUrlEntity();
        localTroopVideoUrlEntity.videoUrl = ((String)localObject);
        this.jdField_b_of_type_JavaUtilList.add(localTroopVideoUrlEntity);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopVideoUrlEntity);
      }
    }
  }
  
  private void c()
  {
    for (;;)
    {
      TroopMessageNavigateInfo localTroopMessageNavigateInfo;
      Object localObject4;
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        Object localObject1;
        Iterator localIterator;
        if (bool == true) {}else
        {
          this.jdField_a_of_type_Boolean = true;
          localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopMessageNavigateInfo.class, false, null, null, null, null, null, null);
          if (localObject1 == null) {
            continue;
          }
          localIterator = ((ArrayList)localObject1).iterator();
        }
        if (!localIterator.hasNext()) {
          continue;
        }
        localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localIterator.next();
        if (localTroopMessageNavigateInfo == null) {
          continue;
        }
        localObject4 = (List)this.c.get(localTroopMessageNavigateInfo.troopCode);
        if (this.c.containsKey(localTroopMessageNavigateInfo.troopCode))
        {
          localObject1 = ((List)localObject4).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = (TroopMessageNavigateInfo)((Iterator)localObject1).next();
            if ((localObject4 == null) || (((TroopMessageNavigateInfo)localObject4).status != TroopMessageNavigateInfo.STATUS_ADD)) {
              continue;
            }
            ((TroopMessageNavigateInfo)localObject4).status = TroopMessageNavigateInfo.STATUS_MODIFY;
            continue;
          }
          continue;
        }
        localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_NORMAL;
      }
      finally {}
      Object localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = new ArrayList();
      }
      ((List)localObject3).add(localTroopMessageNavigateInfo);
      e(localTroopMessageNavigateInfo.troopCode);
      this.c.put(localTroopMessageNavigateInfo.troopCode, localObject3);
    }
  }
  
  private void d()
  {
    for (;;)
    {
      TroopMessageNavigateInfo localTroopMessageNavigateInfo;
      try
      {
        if (!this.jdField_a_of_type_Boolean) {
          c();
        }
        Iterator localIterator = this.c.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = localIterator.next();
        if (!(localObject2 instanceof List)) {
          continue;
        }
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)((Iterator)localObject2).next();
          if (localTroopMessageNavigateInfo == null) {
            continue;
          }
          if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 3, null);
          }
        }
        else
        {
          continue;
        }
        if (localTroopMessageNavigateInfo.status != TroopMessageNavigateInfo.STATUS_MODIFY) {
          break label157;
        }
      }
      finally {}
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 4, null);
      continue;
      label157:
      if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE)
      {
        this.c.remove(localTroopMessageNavigateInfo.troopCode);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTroopMessageNavigateInfo.troopCode, 1, localTroopMessageNavigateInfo.getTableName(), localTroopMessageNavigateInfo, 5, null);
      }
    }
  }
  
  private void e()
  {
    for (;;)
    {
      int i1;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = new JSONObject(HttpUtil.a(BaseApplication.getContext(), "http://pub.idqqimg.com/pc/misc/shouq/videohost/whitelist", "GET", null, null));
        if (((JSONObject)localObject1).getInt("ret") == 0)
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("domains");
          if (localObject1 != null)
          {
            i1 = 0;
            if (i1 < ((JSONArray)localObject1).length())
            {
              Object localObject2 = ((JSONArray)localObject1).getJSONObject(i1);
              if (localObject2 == null) {
                break label111;
              }
              localObject2 = ((JSONObject)localObject2).getString("dm");
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label111;
              }
              localArrayList.add(localObject2);
              break label111;
            }
          }
        }
        b(localArrayList);
        return;
      }
      catch (Exception localException)
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      label111:
      i1 += 1;
    }
  }
  
  /* Error */
  private void e(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +16 -> 22
    //   9: aload_0
    //   10: getfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_1
    //   14: invokevirtual 183	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: aload_1
    //   30: invokevirtual 180	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 123	java/util/List
    //   36: new 289	com/tencent/mobileqq/model/TroopInfoManager$NavigationMsgComparator
    //   39: dup
    //   40: invokespecial 290	com/tencent/mobileqq/model/TroopInfoManager$NavigationMsgComparator:<init>	()V
    //   43: invokestatic 296	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   46: goto -24 -> 22
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	TroopInfoManager
    //   0	54	1	paramString	String
    //   17	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	49	finally
    //   25	46	49	finally
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      return;
    }
    ThreadManager.a(new tfi(this), 8, null, false);
  }
  
  private void g()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("TROOP_INFO_MANAGER_CONFIG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l1 = localSharedPreferences.getLong("VIDEO_GET_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_b_of_type_Boolean) && (l2 - l1 < 86400L)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    localSharedPreferences.edit().putLong("VIDEO_GET_TIME", l2).commit();
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 0, 0));
  }
  
  public int a(String paramString)
  {
    int i2 = 0;
    int i1 = i2;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          i1 = i2;
          if (this.c != null)
          {
            i1 = b(paramString);
            if (i1 == 17) {
              continue;
            }
            i1 = i2;
          }
        }
        return i1;
        paramString = (List)this.c.get(paramString);
        i1 = i2;
        if (paramString != null)
        {
          i1 = i2;
          if (!paramString.isEmpty())
          {
            i1 = paramString.size() - 1;
            if (i1 >= 0)
            {
              TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)paramString.get(i1);
              if ((17 == localTroopMessageNavigateInfo.type) && (localTroopMessageNavigateInfo.status != TroopMessageNavigateInfo.STATUS_DELETE)) {
                i1 = localTroopMessageNavigateInfo.receivedFlowserCount;
              } else {
                i1 -= 1;
              }
            }
            else
            {
              i1 = 0;
            }
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public long a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 75	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 379	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: getfield 75	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 380	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 382	java/lang/Long
    //   24: invokevirtual 385	java/lang/Long:longValue	()J
    //   27: lstore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: lload_2
    //   31: lreturn
    //   32: ldc2_w 11
    //   35: lstore_2
    //   36: goto -8 -> 28
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	TroopInfoManager
    //   0	44	1	paramString	String
    //   27	9	2	l1	long
    // Exception table:
    //   from	to	target	type
    //   2	28	39	finally
  }
  
  public MessageInfo a(String paramString)
  {
    return (MessageInfo)this.g.get(paramString);
  }
  
  public MessageInfo a(String paramString, MessageInfo paramMessageInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString + "_At_Me_DISC", 2, "messageInfoMap: update__:" + paramString + " " + paramMessageInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramString) + " " + paramMessageInfo.a() + " " + paramMessageInfo.b());
    }
    MessageInfo localMessageInfo2 = (MessageInfo)this.g.get(paramString);
    MessageInfo localMessageInfo1 = localMessageInfo2;
    if (paramMessageInfo != null)
    {
      if (paramMessageInfo.a()) {
        break label129;
      }
      localMessageInfo1 = localMessageInfo2;
    }
    label129:
    do
    {
      do
      {
        return localMessageInfo1;
        if (localMessageInfo2 != null) {
          break;
        }
        paramMessageInfo = new MessageInfo(paramMessageInfo);
        this.g.put(paramString, paramMessageInfo);
        localMessageInfo1 = paramMessageInfo;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString + "_At_Me_DISC", 2, "messageInfoMap: put:" + paramString);
      return paramMessageInfo;
      localMessageInfo2.a(paramMessageInfo);
      localMessageInfo1 = localMessageInfo2;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString + "_At_Me_DISC", 2, "messageInfoMap: update:" + paramString);
    return localMessageInfo2;
  }
  
  public TroopFeedsDataManager a(Long paramLong, boolean paramBoolean)
  {
    if (this.f == null) {
      this.f = new ConcurrentHashMap();
    }
    TroopFeedsDataManager localTroopFeedsDataManager2 = (TroopFeedsDataManager)this.f.get(paramLong);
    TroopFeedsDataManager localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
    if (localTroopFeedsDataManager2 == null)
    {
      localTroopFeedsDataManager1 = localTroopFeedsDataManager2;
      if (paramBoolean)
      {
        localTroopFeedsDataManager1 = new TroopFeedsDataManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
        this.f.put(paramLong, localTroopFeedsDataManager1);
      }
    }
    return localTroopFeedsDataManager1;
  }
  
  public ArrayList a(String paramString)
  {
    return (ArrayList)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (Long)paramArrayList.next();
        localObject = (TroopAppInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public List a(String paramString, int paramInt)
  {
    for (;;)
    {
      ArrayList localArrayList;
      StringBuilder localStringBuilder;
      int i1;
      try
      {
        localArrayList = new ArrayList();
        if (!this.jdField_a_of_type_Boolean) {
          c();
        }
        localStringBuilder = new StringBuilder("getMultiNatigateSeqList, troopUin:");
        localStringBuilder.append(paramString).append("| type:").append(paramInt).append("| seqList:");
        if ((this.c != null) && (this.c.containsKey(paramString)))
        {
          paramString = (List)this.c.get(paramString);
          if (paramString != null)
          {
            boolean bool = paramString.isEmpty();
            if (!bool) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
          int i2 = paramString.size();
          i1 = 0;
          if (i1 < i2)
          {
            TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)paramString.get(i1);
            if ((localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_DELETE) || (localTroopMessageNavigateInfo.type != paramInt)) {
              break label245;
            }
            localArrayList.add(Long.valueOf(localTroopMessageNavigateInfo.msgseq));
            localStringBuilder.append(localTroopMessageNavigateInfo.msgseq).append(",");
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString + ".troop.special_msg.special_attention", 2, localStringBuilder.toString());
      }
      paramString = localArrayList;
      continue;
      label245:
      i1 += 1;
    }
  }
  
  public ConcurrentHashMap a()
  {
    if (this.e == null) {
      return null;
    }
    return this.e;
  }
  
  public void a()
  {
    if (this.e == null) {
      return;
    }
    this.e.clear();
  }
  
  public void a(Long paramLong)
  {
    if (this.f == null) {
      return;
    }
    this.f.remove(paramLong);
  }
  
  public void a(Long paramLong, TroopAppInfo paramTroopAppInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, paramTroopAppInfo);
  }
  
  public void a(String paramString)
  {
    if (this.d == null) {}
    try
    {
      if (this.d == null) {
        this.d = new ConcurrentHashMap();
      }
      this.d.put(paramString, Boolean.valueOf(true));
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt)
  {
    for (;;)
    {
      List localList;
      int i1;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString + ".troop.special_msg", 2, "clearTroopMsgNavigateInfo, troopCode:" + paramString + "|type:" + paramInt);
        }
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if ((this.c == null) || (!this.c.containsKey(paramString))) {
          continue;
        }
        localList = (List)this.c.get(paramString);
        if ((localList == null) || (localList.isEmpty())) {
          continue;
        }
        i1 = localList.size() - 1;
        if (i1 >= 0)
        {
          TroopMessageNavigateInfo localTroopMessageNavigateInfo = (TroopMessageNavigateInfo)localList.get(i1);
          if ((paramInt != localTroopMessageNavigateInfo.type) && (paramInt != 0)) {
            break label222;
          }
          if (localTroopMessageNavigateInfo.status == TroopMessageNavigateInfo.STATUS_ADD) {
            localList.remove(i1);
          } else {
            localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_DELETE;
          }
        }
      }
      finally {}
      if (localList.isEmpty())
      {
        this.c.remove(paramString);
        continue;
        label222:
        i1 -= 1;
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2)
  {
    Object localObject = null;
    if (paramInt1 <= 0) {}
    TroopMessageNavigateInfo localTroopMessageNavigateInfo;
    List localList;
    for (;;)
    {
      return;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "addTroopMsgNavigateInfo,type:" + paramInt1 + "|seq:" + paramLong + "|summary:" + paramString2 + "|troopCode:" + paramString1);
        }
        localTroopMessageNavigateInfo = new TroopMessageNavigateInfo();
        localTroopMessageNavigateInfo.type = paramInt1;
        localTroopMessageNavigateInfo.troopCode = paramString1;
        localTroopMessageNavigateInfo.msgseq = paramLong;
        localTroopMessageNavigateInfo.summary = paramString2;
        if (!this.c.containsKey(paramString1)) {
          break label420;
        }
        localList = (List)this.c.get(paramString1);
        if ((localList != null) && (localList.size() != 0))
        {
          if ((paramInt1 == 10) || (paramInt1 == 15))
          {
            paramString2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            if (paramString2 == null) {}
            for (paramString2 = null; (paramString2 != null) && (paramString2.hasOrgs()); paramString2 = paramString2.a(paramString1))
            {
              i1 = localList.size() - 1;
              label207:
              if (i1 < 0) {
                break;
              }
              paramString2 = (TroopMessageNavigateInfo)localList.get(i1);
              if (paramInt1 == paramString2.type) {
                break label477;
              }
              paramString2.status = TroopMessageNavigateInfo.STATUS_DELETE;
              break label477;
            }
          }
          if (paramInt1 == 10)
          {
            localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
            label271:
            localList.add(localTroopMessageNavigateInfo);
            e(paramString1);
          }
        }
      }
      finally {}
    }
    int i1 = localList.size() - 1;
    paramString2 = (String)localObject;
    for (;;)
    {
      if (i1 >= 0)
      {
        if (paramInt1 == ((TroopMessageNavigateInfo)localList.get(i1)).type)
        {
          paramString2 = (TroopMessageNavigateInfo)localList.remove(i1);
          break label486;
        }
      }
      else
      {
        if ((paramString2 == null) || (paramString2.status == TroopMessageNavigateInfo.STATUS_DELETE))
        {
          localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
          if (paramInt1 != 17) {
            break label271;
          }
          localTroopMessageNavigateInfo.receivedFlowserCount = paramInt2;
          break label271;
        }
        localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_MODIFY;
        if (paramInt1 != 17) {
          break label271;
        }
        paramString2.receivedFlowserCount += paramInt2;
        break label271;
        label420:
        localTroopMessageNavigateInfo.status = TroopMessageNavigateInfo.STATUS_ADD;
        if (paramInt1 == 17) {
          localTroopMessageNavigateInfo.receivedFlowserCount = paramInt2;
        }
        paramString2 = new ArrayList();
        paramString2.add(localTroopMessageNavigateInfo);
        this.c.put(paramString1, paramString2);
        break;
      }
      break label486;
      label477:
      i1 -= 1;
      break label207;
      label486:
      i1 -= 1;
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(paramLong));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (this.e == null) {}
    try
    {
      if (this.e == null) {
        this.e = new ConcurrentHashMap();
      }
      this.e.put(paramString, paramObject);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramArrayList);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a()
  {
    return ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) && (!this.jdField_b_of_type_Boolean);
  }
  
  public boolean a(String paramString)
  {
    if (this.d == null) {}
    while (!this.d.containsKey(paramString)) {
      return false;
    }
    return ((Boolean)this.d.get(paramString)).booleanValue();
  }
  
  /* Error */
  public int b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 165	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_Boolean	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokespecial 204	com/tencent/mobileqq/model/TroopInfoManager:c	()V
    //   13: aload_0
    //   14: getfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: ifnull +101 -> 118
    //   20: aload_0
    //   21: getfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_1
    //   25: invokevirtual 183	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   28: ifeq +90 -> 118
    //   31: aload_0
    //   32: getfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_1
    //   36: invokevirtual 180	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 123	java/util/List
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +16 -> 60
    //   47: aload_1
    //   48: invokeinterface 365 1 0
    //   53: istore 5
    //   55: iload 5
    //   57: ifeq +9 -> 66
    //   60: iconst_m1
    //   61: istore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: iload_3
    //   65: ireturn
    //   66: aload_1
    //   67: invokeinterface 368 1 0
    //   72: istore 4
    //   74: iconst_0
    //   75: istore_3
    //   76: iload_3
    //   77: iload 4
    //   79: if_icmpge +39 -> 118
    //   82: aload_1
    //   83: iload_3
    //   84: invokeinterface 371 2 0
    //   89: checkcast 167	com/tencent/mobileqq/data/TroopMessageNavigateInfo
    //   92: astore_2
    //   93: aload_2
    //   94: getfield 186	com/tencent/mobileqq/data/TroopMessageNavigateInfo:status	I
    //   97: getstatic 225	com/tencent/mobileqq/data/TroopMessageNavigateInfo:STATUS_DELETE	I
    //   100: if_icmpne +10 -> 110
    //   103: iload_3
    //   104: iconst_1
    //   105: iadd
    //   106: istore_3
    //   107: goto -31 -> 76
    //   110: aload_2
    //   111: getfield 374	com/tencent/mobileqq/data/TroopMessageNavigateInfo:type	I
    //   114: istore_3
    //   115: goto -53 -> 62
    //   118: iconst_m1
    //   119: istore_3
    //   120: goto -58 -> 62
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	TroopInfoManager
    //   0	128	1	paramString	String
    //   92	19	2	localTroopMessageNavigateInfo	TroopMessageNavigateInfo
    //   61	59	3	i1	int
    //   72	8	4	i2	int
    //   53	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	123	finally
    //   13	43	123	finally
    //   47	55	123	finally
    //   66	74	123	finally
    //   82	103	123	finally
    //   110	115	123	finally
  }
  
  /* Error */
  public long b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 165	com/tencent/mobileqq/model/TroopInfoManager:jdField_a_of_type_Boolean	Z
    //   6: ifne +7 -> 13
    //   9: aload_0
    //   10: invokespecial 204	com/tencent/mobileqq/model/TroopInfoManager:c	()V
    //   13: aload_0
    //   14: getfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: ifnull +104 -> 121
    //   20: aload_0
    //   21: getfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload_1
    //   25: invokevirtual 183	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   28: ifeq +93 -> 121
    //   31: aload_0
    //   32: getfield 109	com/tencent/mobileqq/model/TroopInfoManager:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   35: aload_1
    //   36: invokevirtual 180	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 123	java/util/List
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +16 -> 60
    //   47: aload_1
    //   48: invokeinterface 365 1 0
    //   53: istore 7
    //   55: iload 7
    //   57: ifeq +11 -> 68
    //   60: lconst_0
    //   61: lstore 5
    //   63: aload_0
    //   64: monitorexit
    //   65: lload 5
    //   67: lreturn
    //   68: aload_1
    //   69: invokeinterface 368 1 0
    //   74: istore 4
    //   76: iconst_0
    //   77: istore_3
    //   78: iload_3
    //   79: iload 4
    //   81: if_icmpge +40 -> 121
    //   84: aload_1
    //   85: iload_3
    //   86: invokeinterface 371 2 0
    //   91: checkcast 167	com/tencent/mobileqq/data/TroopMessageNavigateInfo
    //   94: astore_2
    //   95: aload_2
    //   96: getfield 186	com/tencent/mobileqq/data/TroopMessageNavigateInfo:status	I
    //   99: getstatic 225	com/tencent/mobileqq/data/TroopMessageNavigateInfo:STATUS_DELETE	I
    //   102: if_icmpne +10 -> 112
    //   105: iload_3
    //   106: iconst_1
    //   107: iadd
    //   108: istore_3
    //   109: goto -31 -> 78
    //   112: aload_2
    //   113: getfield 453	com/tencent/mobileqq/data/TroopMessageNavigateInfo:msgseq	J
    //   116: lstore 5
    //   118: goto -55 -> 63
    //   121: lconst_0
    //   122: lstore 5
    //   124: goto -61 -> 63
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	TroopInfoManager
    //   0	132	1	paramString	String
    //   94	19	2	localTroopMessageNavigateInfo	TroopMessageNavigateInfo
    //   77	32	3	i1	int
    //   74	8	4	i2	int
    //   61	62	5	l1	long
    //   53	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	127	finally
    //   13	43	127	finally
    //   47	55	127	finally
    //   68	76	127	finally
    //   84	105	127	finally
    //   112	118	127	finally
  }
  
  public MessageInfo b(String paramString)
  {
    return (MessageInfo)this.g.remove(paramString);
  }
  
  public void b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("TROOP_INFO_MANAGER_CONFIG" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l1 = localSharedPreferences.getLong("VIDEO_GET_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_b_of_type_Boolean) && (l2 - l1 < 86400L)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    localSharedPreferences.edit().putLong("VIDEO_GET_TIME", l2).commit();
    e();
  }
  
  public void b(String paramString)
  {
    if (this.d == null) {
      return;
    }
    this.d.remove(paramString);
  }
  
  public boolean b()
  {
    boolean bool = VersionUtils.d();
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    int i1;
    if (str1.equalsIgnoreCase("Xiaomi")) {
      if ((str2.equalsIgnoreCase("MI 1S")) || (str2.equalsIgnoreCase("MI 1SC"))) {
        i1 = 0;
      }
    }
    for (;;)
    {
      if ((bool) && (i1 != 0))
      {
        return true;
        if (str2.equalsIgnoreCase("MI-ONE Plus")) {
          i1 = 0;
        }
      }
      else
      {
        return false;
      }
      i1 = 1;
    }
  }
  
  public boolean b(String paramString)
  {
    if (a()) {
      return true;
    }
    g();
    paramString = paramString.toLowerCase();
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (paramString.indexOf(((TroopVideoUrlEntity)localIterator.next()).videoUrl.toLowerCase()) != -1) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int c(String paramString)
  {
    return 0;
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramString);
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    while (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return false;
    }
    return true;
  }
  
  public boolean c(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramString == null)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((str != null) && (str.equals(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
  }
  
  public void onDestroy()
  {
    d();
    if (this.f != null)
    {
      Iterator localIterator = this.f.values().iterator();
      while (localIterator.hasNext())
      {
        TroopFeedsDataManager localTroopFeedsDataManager = (TroopFeedsDataManager)localIterator.next();
        if (localTroopFeedsDataManager != null) {
          localTroopFeedsDataManager.deleteObservers();
        }
      }
      this.f.clear();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\model\TroopInfoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */