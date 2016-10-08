package com.tencent.mobileqq.freshnews;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import appoint.define.appoint_define.FeedEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.freshnews.data.FNBaseItemData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import sqi;
import sqj;
import sqk;
import sql;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;

public class FreshNewsManager
  implements Manager
{
  public static final int a = 500;
  public static final String a = "fresh_news_config";
  public static final int b = 200;
  public static final String b = "_";
  public static final int c = 1;
  public static final int d = 2;
  private static final String jdField_d_of_type_JavaLangString = "FreshNewsManager";
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 4;
  private static final int k = 4;
  long jdField_a_of_type_Long;
  public Handler a;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private FreshNewsManager.Config jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config;
  public NearbyAppInterface a;
  public EntityManager a;
  private Object jdField_a_of_type_JavaLangObject;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  public LinkedList a;
  public List a;
  private Map jdField_a_of_type_JavaUtilMap;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte;
  private Long[] jdField_a_of_type_ArrayOfJavaLangLong;
  long jdField_b_of_type_Long;
  public List b;
  boolean jdField_b_of_type_Boolean;
  byte[] jdField_b_of_type_ArrayOfByte;
  long jdField_c_of_type_Long;
  public String c;
  List jdField_c_of_type_JavaUtilList;
  public boolean c;
  byte[] jdField_c_of_type_ArrayOfByte;
  long jdField_d_of_type_Long;
  List jdField_d_of_type_JavaUtilList;
  public boolean d;
  public long e;
  List e;
  public boolean e;
  public long f;
  private List jdField_f_of_type_JavaUtilList;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private List jdField_g_of_type_JavaUtilList;
  private boolean jdField_g_of_type_Boolean;
  private long jdField_h_of_type_Long;
  private List jdField_h_of_type_JavaUtilList;
  private boolean jdField_h_of_type_Boolean;
  private int j;
  
  public FreshNewsManager(NearbyAppInterface paramNearbyAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_f_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config = new FreshNewsManager.Config();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_e_of_type_Long = -1L;
    this.jdField_f_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new FreshNewsManager.1(this, 4);
    this.jdField_a_of_type_AndroidOsHandler = new sql(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ArrayOfJavaLangLong = new Long[4];
    this.jdField_h_of_type_JavaUtilList = new ArrayList(1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramNearbyAppInterface.a(paramNearbyAppInterface.getAccount()).createEntityManager();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(200);
    ThreadManager.b().post(new sqi(this));
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    return ((Boolean)NearbySPUtil.a(paramAppInterface.getAccount(), "ShowFreshNews", Boolean.valueOf(true))).booleanValue();
  }
  
  private void h()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(FreshNewsInfo.class, false, "publishState = 2 OR publishState = 3", null, null, null, null, null);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          FreshNewsInfo localFreshNewsInfo = (FreshNewsInfo)((Iterator)localObject1).next();
          localFreshNewsInfo.publishState = 3;
          this.jdField_a_of_type_JavaUtilList.add(localFreshNewsInfo);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsManager", 4, "getUnpublishedFeedsFromDB, size=" + this.jdField_a_of_type_JavaUtilList.size());
    }
  }
  
  private void i()
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(5)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    }
  }
  
  private void j()
  {
    if (this.jdField_h_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_h_of_type_Boolean) {
        return;
      }
    }
    this.jdField_h_of_type_Boolean = true;
    this.jdField_f_of_type_Long = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "nearby_event_file", 4, "freshfeed_red_event_seq", Long.valueOf(0L))).longValue();
    this.jdField_e_of_type_Long = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "nearby_event_file", 4, "freshfeed_last_event_seq", Long.valueOf(0L))).longValue();
    try
    {
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(FreshNewsNotify.class, false, "readType = 1", null, null, null, null, null);
      if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
        synchronized (this.jdField_f_of_type_JavaUtilList)
        {
          this.jdField_f_of_type_JavaUtilList.clear();
          localObject3 = ((List)localObject3).iterator();
          FreshNewsNotify localFreshNewsNotify;
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localFreshNewsNotify = (FreshNewsNotify)((Iterator)localObject3).next();
            this.jdField_f_of_type_JavaUtilList.add(Long.valueOf(localFreshNewsNotify.eventId));
          } while (localFreshNewsNotify.eventId <= this.jdField_e_of_type_Long);
          this.jdField_e_of_type_Long = localFreshNewsNotify.eventId;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      i();
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.minPublishFeedLevel;
  }
  
  public int a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!this.jdField_h_of_type_Boolean)) {
      j();
    }
    return this.jdField_f_of_type_JavaUtilList.size();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "NEW_FRESH_SP", 0, "last_exit_newfreshtab_time", Long.valueOf(0L))).longValue();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public FreshNewsManager.Config a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config;
  }
  
  public FNBaseItemData a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      return (FNBaseItemData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.publishPageTip;
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
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    for (;;)
    {
      FreshNewsInfo localFreshNewsInfo;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localFreshNewsInfo = (FreshNewsInfo)localIterator.next();
        if (2 == localFreshNewsInfo.publishState) {
          localArrayList1.add(localFreshNewsInfo);
        }
      }
      if (3 == localFreshNewsInfo.publishState) {
        localArrayList2.add(localFreshNewsInfo);
      }
    }
    Collections.sort(localList2, new FreshNewsManager.FreshNewsComparator());
    Collections.sort(localArrayList2, new FreshNewsManager.FreshNewsComparator());
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(localList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 3)) {
      ??? = null;
    }
    Collection localCollection;
    do
    {
      for (;;)
      {
        return (List)???;
        try
        {
          List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(FreshNewsInfo.class, false, "whichPage = " + paramInt + " AND publishState = 1", null, null, null, "publishTime DESC", null);
          ??? = localList;
          if (localList != null)
          {
            ??? = localList;
            if (localList.size() > 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("FreshNewsManager", 2, "getFeedListFromDb, list.size():" + localList.size() + " whichPage:" + paramInt);
              }
              ??? = localList;
              if (!this.jdField_f_of_type_Boolean) {
                if (paramInt == 1) {
                  synchronized (this.jdField_c_of_type_JavaUtilList)
                  {
                    this.jdField_c_of_type_JavaUtilList.clear();
                    this.jdField_c_of_type_JavaUtilList.addAll(localList);
                    return localList;
                  }
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            localCollection = null;
          }
          ??? = localCollection;
        }
      }
    } while (paramInt != 3);
    synchronized (this.jdField_d_of_type_JavaUtilList)
    {
      this.jdField_d_of_type_JavaUtilList.clear();
      this.jdField_d_of_type_JavaUtilList.addAll(localCollection);
      return localCollection;
    }
  }
  
  public List a(int paramInt1, int paramInt2)
  {
    try
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(FreshNewsNotify.class, false, "feedId <> ''", null, null, null, "time DESC", paramInt1 + "," + paramInt2);
      return localList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public List a(Long paramLong)
  {
    return (List)this.jdField_a_of_type_JavaUtilMap.get(paramLong);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = new NearbyPeopleCard();
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "self_tinnyid", Long.valueOf(0L))).longValue();
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "self_age", Integer.valueOf(0))).intValue();
      int m = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "self_gender", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender = ((byte)(m - 1));
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "self_nick", String.valueOf("")));
      this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "self_school_name", String.valueOf("")));
      if (QLog.isColorLevel()) {
        NearbyUtils.a("initSelfInfo", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.tinyId), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age), Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender), this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname });
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    QLog.i("setMyCharmLevel", 1, "Charm=" + paramInt);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getAccount(), "NEW_FRESH_SP", 0, "last_exit_newfreshtab_time", Long.valueOf(paramLong));
  }
  
  public void a(appoint_define.FeedEvent paramFeedEvent)
  {
    if (paramFeedEvent == null) {}
    long l;
    do
    {
      return;
      if (!this.jdField_g_of_type_Boolean) {
        break;
      }
      l = paramFeedEvent.uint64_event_id.get();
      if (4 == paramFeedEvent.uint32_eventtype.get())
      {
        l = paramFeedEvent.uint64_cancel_event_id.get();
        g(l);
        c(l);
        return;
      }
    } while (!a(l));
    ??? = new ArrayList();
    FreshNewsNotify localFreshNewsNotify = new FreshNewsNotify();
    FreshNewsUtil.a(localFreshNewsNotify, paramFeedEvent);
    ((List)???).add(localFreshNewsNotify);
    a((List)???);
    return;
    synchronized (this.jdField_h_of_type_JavaUtilList)
    {
      this.jdField_h_of_type_JavaUtilList.add(paramFeedEvent);
      return;
    }
  }
  
  public void a(FreshNewsInfo paramFreshNewsInfo)
  {
    if (paramFreshNewsInfo == null) {
      return;
    }
    for (;;)
    {
      try
      {
        this.jdField_g_of_type_Long = paramFreshNewsInfo.publishTime;
        paramFreshNewsInfo.publishState = 2;
        if (this.jdField_a_of_type_JavaUtilList.contains(paramFreshNewsInfo))
        {
          d(paramFreshNewsInfo);
          ThreadManager.a(new sqj(this, paramFreshNewsInfo), 5, null, false);
          break;
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilList.add(paramFreshNewsInfo);
      b(paramFreshNewsInfo);
    }
  }
  
  public void a(FreshNewsManager.NotifyListener paramNotifyListener)
  {
    synchronized (this.jdField_g_of_type_JavaUtilList)
    {
      if (!this.jdField_g_of_type_JavaUtilList.contains(paramNotifyListener)) {
        this.jdField_g_of_type_JavaUtilList.add(paramNotifyListener);
      }
      return;
    }
  }
  
  public void a(FreshNewsManager.UnpublishedFeedsListener paramUnpublishedFeedsListener)
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramUnpublishedFeedsListener)) {
        this.jdField_b_of_type_JavaUtilList.add(paramUnpublishedFeedsListener);
      }
      return;
    }
  }
  
  /* Error */
  public void a(FreshNewsNotify paramFreshNewsNotify)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: invokevirtual 507	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 511	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   14: aload_0
    //   15: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: aload_1
    //   19: invokevirtual 514	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   22: pop
    //   23: aload_2
    //   24: invokevirtual 516	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   27: aload_2
    //   28: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   39: aload_2
    //   40: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   43: goto -12 -> 31
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: aload_2
    //   53: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	FreshNewsManager
    //   0	58	1	paramFreshNewsNotify	FreshNewsNotify
    //   9	44	2	localEntityTransaction	EntityTransaction
    // Exception table:
    //   from	to	target	type
    //   10	27	34	java/lang/Exception
    //   2	10	46	finally
    //   27	31	46	finally
    //   39	43	46	finally
    //   52	58	46	finally
    //   10	27	51	finally
    //   35	39	51	finally
  }
  
  public void a(Long paramLong, List paramList)
  {
    if ((paramList == null) || (paramLong.longValue() < 0L)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsManager", 2, "putGuestFeedsToRecentCache, list.size=" + paramList.size());
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramLong)) {
        this.jdField_a_of_type_JavaUtilMap.remove(paramLong);
      }
      if (this.jdField_a_of_type_JavaUtilMap.size() >= 4)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_ArrayOfJavaLangLong[0]);
        Long[] arrayOfLong = new Long[4];
        System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangLong, 1, arrayOfLong, 0, 3);
        this.jdField_a_of_type_ArrayOfJavaLangLong = arrayOfLong;
      }
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramLong, paramList);
    this.jdField_a_of_type_ArrayOfJavaLangLong[(this.jdField_a_of_type_JavaUtilMap.size() - 1)] = paramLong;
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_1
    //   4: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   15: ifnull +83 -> 98
    //   18: aload_0
    //   19: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: iconst_0
    //   26: istore 4
    //   28: iload 4
    //   30: aload_0
    //   31: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   34: invokeinterface 215 1 0
    //   39: if_icmpge +198 -> 237
    //   42: aload_0
    //   43: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   46: iload 4
    //   48: invokeinterface 542 2 0
    //   53: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   56: astore_3
    //   57: aload_3
    //   58: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   61: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +139 -> 203
    //   67: aload_3
    //   68: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   71: aload_1
    //   72: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifeq +128 -> 203
    //   78: iload 4
    //   80: iconst_m1
    //   81: if_icmpeq +15 -> 96
    //   84: aload_0
    //   85: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   88: iload 4
    //   90: invokeinterface 550 2 0
    //   95: pop
    //   96: aload_2
    //   97: monitorexit
    //   98: aload_0
    //   99: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   102: ifnull +84 -> 186
    //   105: aload_0
    //   106: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   109: astore_2
    //   110: aload_2
    //   111: monitorenter
    //   112: iload 5
    //   114: istore 4
    //   116: iload 4
    //   118: aload_0
    //   119: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   122: invokeinterface 215 1 0
    //   127: if_icmpge +104 -> 231
    //   130: aload_0
    //   131: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   134: iload 4
    //   136: invokeinterface 542 2 0
    //   141: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   144: astore_3
    //   145: aload_3
    //   146: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   149: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifne +65 -> 217
    //   155: aload_3
    //   156: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   159: aload_1
    //   160: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   163: ifeq +54 -> 217
    //   166: iload 4
    //   168: iconst_m1
    //   169: if_icmpeq +15 -> 184
    //   172: aload_0
    //   173: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   176: iload 4
    //   178: invokeinterface 550 2 0
    //   183: pop
    //   184: aload_2
    //   185: monitorexit
    //   186: invokestatic 158	com/tencent/mobileqq/app/ThreadManager:b	()Lmqq/os/MqqHandler;
    //   189: new 552	sqp
    //   192: dup
    //   193: aload_0
    //   194: aload_1
    //   195: invokespecial 555	sqp:<init>	(Lcom/tencent/mobileqq/freshnews/FreshNewsManager;Ljava/lang/String;)V
    //   198: invokevirtual 169	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   201: pop
    //   202: return
    //   203: iload 4
    //   205: iconst_1
    //   206: iadd
    //   207: istore 4
    //   209: goto -181 -> 28
    //   212: astore_1
    //   213: aload_2
    //   214: monitorexit
    //   215: aload_1
    //   216: athrow
    //   217: iload 4
    //   219: iconst_1
    //   220: iadd
    //   221: istore 4
    //   223: goto -107 -> 116
    //   226: astore_1
    //   227: aload_2
    //   228: monitorexit
    //   229: aload_1
    //   230: athrow
    //   231: iconst_m1
    //   232: istore 4
    //   234: goto -68 -> 166
    //   237: iconst_m1
    //   238: istore 4
    //   240: goto -162 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	FreshNewsManager
    //   0	243	1	paramString	String
    //   22	206	2	localList	List
    //   56	100	3	localFreshNewsInfo	FreshNewsInfo
    //   26	213	4	m	int
    //   1	112	5	n	int
    // Exception table:
    //   from	to	target	type
    //   28	78	212	finally
    //   84	96	212	finally
    //   96	98	212	finally
    //   213	215	212	finally
    //   116	166	226	finally
    //   172	184	226	finally
    //   184	186	226	finally
    //   227	229	226	finally
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   7: ifnull +74 -> 81
    //   10: aload_0
    //   11: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   14: astore_3
    //   15: aload_3
    //   16: monitorenter
    //   17: iconst_0
    //   18: istore 5
    //   20: iload 5
    //   22: aload_0
    //   23: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   26: invokeinterface 215 1 0
    //   31: if_icmpge +48 -> 79
    //   34: aload_0
    //   35: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   38: iload 5
    //   40: invokeinterface 542 2 0
    //   45: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   48: astore 4
    //   50: aload 4
    //   52: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   55: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +120 -> 178
    //   61: aload 4
    //   63: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   66: aload_1
    //   67: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +108 -> 178
    //   73: aload 4
    //   75: iload_2
    //   76: putfield 559	com/tencent/mobileqq/freshnews/FreshNewsInfo:praiseCount	I
    //   79: aload_3
    //   80: monitorexit
    //   81: aload_0
    //   82: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   85: ifnull +75 -> 160
    //   88: aload_0
    //   89: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   92: astore_3
    //   93: aload_3
    //   94: monitorenter
    //   95: iload 6
    //   97: istore 5
    //   99: iload 5
    //   101: aload_0
    //   102: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   105: invokeinterface 215 1 0
    //   110: if_icmpge +48 -> 158
    //   113: aload_0
    //   114: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   117: iload 5
    //   119: invokeinterface 542 2 0
    //   124: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   127: astore 4
    //   129: aload 4
    //   131: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   134: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +55 -> 192
    //   140: aload 4
    //   142: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   145: aload_1
    //   146: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq +43 -> 192
    //   152: aload 4
    //   154: iload_2
    //   155: putfield 559	com/tencent/mobileqq/freshnews/FreshNewsInfo:praiseCount	I
    //   158: aload_3
    //   159: monitorexit
    //   160: invokestatic 158	com/tencent/mobileqq/app/ThreadManager:b	()Lmqq/os/MqqHandler;
    //   163: new 561	sqm
    //   166: dup
    //   167: aload_0
    //   168: iload_2
    //   169: aload_1
    //   170: invokespecial 564	sqm:<init>	(Lcom/tencent/mobileqq/freshnews/FreshNewsManager;ILjava/lang/String;)V
    //   173: invokevirtual 169	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   176: pop
    //   177: return
    //   178: iload 5
    //   180: iconst_1
    //   181: iadd
    //   182: istore 5
    //   184: goto -164 -> 20
    //   187: astore_1
    //   188: aload_3
    //   189: monitorexit
    //   190: aload_1
    //   191: athrow
    //   192: iload 5
    //   194: iconst_1
    //   195: iadd
    //   196: istore 5
    //   198: goto -99 -> 99
    //   201: astore_1
    //   202: aload_3
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	FreshNewsManager
    //   0	206	1	paramString	String
    //   0	206	2	paramInt	int
    //   14	189	3	localList	List
    //   48	105	4	localFreshNewsInfo	FreshNewsInfo
    //   18	179	5	m	int
    //   1	95	6	n	int
    // Exception table:
    //   from	to	target	type
    //   20	79	187	finally
    //   79	81	187	finally
    //   188	190	187	finally
    //   99	158	201	finally
    //   158	160	201	finally
    //   202	204	201	finally
  }
  
  public void a(String paramString, FNBaseItemData paramFNBaseItemData)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)) && (paramFNBaseItemData != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramFNBaseItemData);
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
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   7: ifnull +78 -> 85
    //   10: aload_0
    //   11: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   14: astore_3
    //   15: aload_3
    //   16: monitorenter
    //   17: iconst_0
    //   18: istore 5
    //   20: iload 5
    //   22: aload_0
    //   23: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   26: invokeinterface 215 1 0
    //   31: if_icmpge +52 -> 83
    //   34: aload_0
    //   35: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   38: iload 5
    //   40: invokeinterface 542 2 0
    //   45: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   48: astore 4
    //   50: aload 4
    //   52: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   55: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +142 -> 200
    //   61: aload 4
    //   63: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   66: aload_1
    //   67: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +130 -> 200
    //   73: iload_2
    //   74: ifeq +112 -> 186
    //   77: aload 4
    //   79: iconst_1
    //   80: putfield 574	com/tencent/mobileqq/freshnews/FreshNewsInfo:praiseFlag	I
    //   83: aload_3
    //   84: monitorexit
    //   85: aload_0
    //   86: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   89: ifnull +79 -> 168
    //   92: aload_0
    //   93: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   96: astore_3
    //   97: aload_3
    //   98: monitorenter
    //   99: iload 6
    //   101: istore 5
    //   103: iload 5
    //   105: aload_0
    //   106: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   109: invokeinterface 215 1 0
    //   114: if_icmpge +52 -> 166
    //   117: aload_0
    //   118: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   121: iload 5
    //   123: invokeinterface 542 2 0
    //   128: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   131: astore 4
    //   133: aload 4
    //   135: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   138: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifne +82 -> 223
    //   144: aload 4
    //   146: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   149: aload_1
    //   150: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifeq +70 -> 223
    //   156: iload_2
    //   157: ifeq +52 -> 209
    //   160: aload 4
    //   162: iconst_1
    //   163: putfield 574	com/tencent/mobileqq/freshnews/FreshNewsInfo:praiseFlag	I
    //   166: aload_3
    //   167: monitorexit
    //   168: invokestatic 158	com/tencent/mobileqq/app/ThreadManager:b	()Lmqq/os/MqqHandler;
    //   171: new 576	sqo
    //   174: dup
    //   175: aload_0
    //   176: iload_2
    //   177: aload_1
    //   178: invokespecial 579	sqo:<init>	(Lcom/tencent/mobileqq/freshnews/FreshNewsManager;ZLjava/lang/String;)V
    //   181: invokevirtual 169	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   184: pop
    //   185: return
    //   186: aload 4
    //   188: iconst_0
    //   189: putfield 574	com/tencent/mobileqq/freshnews/FreshNewsInfo:praiseFlag	I
    //   192: goto -109 -> 83
    //   195: astore_1
    //   196: aload_3
    //   197: monitorexit
    //   198: aload_1
    //   199: athrow
    //   200: iload 5
    //   202: iconst_1
    //   203: iadd
    //   204: istore 5
    //   206: goto -186 -> 20
    //   209: aload 4
    //   211: iconst_0
    //   212: putfield 574	com/tencent/mobileqq/freshnews/FreshNewsInfo:praiseFlag	I
    //   215: goto -49 -> 166
    //   218: astore_1
    //   219: aload_3
    //   220: monitorexit
    //   221: aload_1
    //   222: athrow
    //   223: iload 5
    //   225: iconst_1
    //   226: iadd
    //   227: istore 5
    //   229: goto -126 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	FreshNewsManager
    //   0	232	1	paramString	String
    //   0	232	2	paramBoolean	boolean
    //   14	206	3	localList	List
    //   48	162	4	localFreshNewsInfo	FreshNewsInfo
    //   18	210	5	m	int
    //   1	99	6	n	int
    // Exception table:
    //   from	to	target	type
    //   20	73	195	finally
    //   77	83	195	finally
    //   83	85	195	finally
    //   186	192	195	finally
    //   196	198	195	finally
    //   103	156	218	finally
    //   160	166	218	finally
    //   166	168	218	finally
    //   209	215	218	finally
    //   219	221	218	finally
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {}
    synchronized (this.jdField_f_of_type_JavaUtilList)
    {
      this.jdField_f_of_type_JavaUtilList.addAll(paramList);
      i();
      return;
    }
  }
  
  public void a(List paramList, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int m;
    if (paramList == null) {
      m = 0;
    }
    for (;;)
    {
      NearbyUtils.a("FreshNewsManager", "addFeedsToCache", new Object[] { Integer.valueOf(m), Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()), Boolean.valueOf(paramBoolean) });
      if ((paramList != null) && (paramList.size() > 0)) {}
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_c_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.jdField_b_of_type_Boolean = paramBoolean;
        return;
        m = paramList.size();
      }
    }
  }
  
  public void a(Oidb_0x686.NearbyFeedConfig paramNearbyFeedConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.publishPageTip = paramNearbyFeedConfig.str_publish_feed_tips.get();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.minPublishFeedLevel = paramNearbyFeedConfig.uint32_publish_feed_min_level.get();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.cannotPublishTip = paramNearbyFeedConfig.str_unable_publish_feed_tips.get();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.minCommentLevel = paramNearbyFeedConfig.uint32_publish_comment_min_level.get();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.cannotCommentTip = paramNearbyFeedConfig.str_unable_publish_comment_tips.get();
    FileUtils.a("fresh_news_config", this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config);
    if (QLog.isDevelopLevel()) {
      QLog.d("FreshNewsManager", 4, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.toString());
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = false;
    synchronized (this.jdField_f_of_type_JavaUtilList)
    {
      if (!this.jdField_f_of_type_JavaUtilList.contains(Long.valueOf(paramLong)))
      {
        this.jdField_f_of_type_JavaUtilList.add(Long.valueOf(paramLong));
        bool = true;
      }
      i();
      return bool;
    }
  }
  
  public boolean a(String paramString)
  {
    label220:
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(FreshNewsInfo.class, false, "feedId = '" + paramString + "'", null, null, null, null, null);
        Object localObject3;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder().append("deleteFeedFromDb, feedId=").append(paramString).append("list.size()=");
          if (localObject1 == null)
          {
            paramString = "null";
            QLog.d("freshnews", 2, paramString);
          }
        }
        else
        {
          if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
            break label220;
          }
          paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        }
        try
        {
          paramString.a();
          localObject1 = ((List)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (FreshNewsInfo)((Iterator)localObject1).next();
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject3);
            continue;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          paramString.b();
          bool = false;
          return bool;
          int m = localException.size();
          paramString = Integer.valueOf(m);
          continue;
          paramString.c();
          paramString.b();
          bool = true;
          continue;
        }
        finally
        {
          paramString.b();
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: invokeinterface 215 1 0
    //   12: istore 5
    //   14: iload 5
    //   16: ifgt +11 -> 27
    //   19: iconst_0
    //   20: istore 8
    //   22: aload_0
    //   23: monitorexit
    //   24: iload 8
    //   26: ireturn
    //   27: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +34 -> 64
    //   33: ldc 22
    //   35: iconst_2
    //   36: new 242	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 651
    //   46: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokeinterface 215 1 0
    //   55: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_1
    //   65: invokeinterface 215 1 0
    //   70: istore 5
    //   72: aload_0
    //   73: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   76: invokevirtual 507	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   79: astore_2
    //   80: aload_2
    //   81: invokevirtual 511	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   84: aload_0
    //   85: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: ldc_w 289
    //   91: invokevirtual 654	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   94: astore_3
    //   95: aload_3
    //   96: ifnull +263 -> 359
    //   99: aload_3
    //   100: invokeinterface 215 1 0
    //   105: ifle +254 -> 359
    //   108: iload 5
    //   110: aload_3
    //   111: invokeinterface 215 1 0
    //   116: iadd
    //   117: istore 5
    //   119: aload_1
    //   120: invokeinterface 219 1 0
    //   125: astore_3
    //   126: aload_3
    //   127: invokeinterface 224 1 0
    //   132: ifeq +68 -> 200
    //   135: aload_3
    //   136: invokeinterface 228 1 0
    //   141: checkcast 289	com/tencent/mobileqq/freshnews/FreshNewsNotify
    //   144: astore 4
    //   146: aload_0
    //   147: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   150: aload 4
    //   152: invokevirtual 657	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   155: aload 4
    //   157: getfield 294	com/tencent/mobileqq/freshnews/FreshNewsNotify:eventId	J
    //   160: aload_0
    //   161: getfield 93	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_e_of_type_Long	J
    //   164: lcmp
    //   165: ifle -39 -> 126
    //   168: aload_0
    //   169: aload 4
    //   171: getfield 294	com/tencent/mobileqq/freshnews/FreshNewsNotify:eventId	J
    //   174: putfield 93	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_e_of_type_Long	J
    //   177: goto -51 -> 126
    //   180: astore_1
    //   181: iconst_0
    //   182: istore 8
    //   184: aload_1
    //   185: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   188: aload_2
    //   189: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   192: goto -170 -> 22
    //   195: astore_1
    //   196: aload_0
    //   197: monitorexit
    //   198: aload_1
    //   199: athrow
    //   200: iload 5
    //   202: sipush 500
    //   205: if_icmple +148 -> 353
    //   208: aload_0
    //   209: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   212: ldc_w 289
    //   215: iconst_0
    //   216: aconst_null
    //   217: aconst_null
    //   218: aconst_null
    //   219: aconst_null
    //   220: ldc_w 659
    //   223: ldc_w 661
    //   226: invokevirtual 206	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   229: astore_3
    //   230: aload_3
    //   231: ifnull +122 -> 353
    //   234: aload_3
    //   235: invokeinterface 215 1 0
    //   240: ifle +113 -> 353
    //   243: aload_1
    //   244: iconst_0
    //   245: invokeinterface 542 2 0
    //   250: checkcast 289	com/tencent/mobileqq/freshnews/FreshNewsNotify
    //   253: getfield 294	com/tencent/mobileqq/freshnews/FreshNewsNotify:eventId	J
    //   256: lstore 6
    //   258: aload_0
    //   259: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   262: new 242	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 663
    //   272: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: lload 6
    //   277: invokevirtual 666	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   280: ldc_w 668
    //   283: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokevirtual 670	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   292: istore 8
    //   294: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +30 -> 327
    //   300: ldc 22
    //   302: iconst_2
    //   303: new 242	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   310: ldc_w 672
    //   313: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: iload 8
    //   318: invokevirtual 675	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   321: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: aload_2
    //   328: invokevirtual 516	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   331: aload_2
    //   332: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   335: goto -313 -> 22
    //   338: astore_1
    //   339: aload_2
    //   340: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   343: aload_1
    //   344: athrow
    //   345: astore_1
    //   346: goto -162 -> 184
    //   349: astore_1
    //   350: goto -166 -> 184
    //   353: iconst_0
    //   354: istore 8
    //   356: goto -29 -> 327
    //   359: goto -240 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	FreshNewsManager
    //   0	362	1	paramList	List
    //   79	261	2	localEntityTransaction	EntityTransaction
    //   94	141	3	localObject	Object
    //   144	26	4	localFreshNewsNotify	FreshNewsNotify
    //   12	194	5	m	int
    //   256	20	6	l	long
    //   20	335	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   80	95	180	java/lang/Exception
    //   99	119	180	java/lang/Exception
    //   119	126	180	java/lang/Exception
    //   126	177	180	java/lang/Exception
    //   208	230	180	java/lang/Exception
    //   234	294	180	java/lang/Exception
    //   6	14	195	finally
    //   27	64	195	finally
    //   64	80	195	finally
    //   188	192	195	finally
    //   331	335	195	finally
    //   339	345	195	finally
    //   80	95	338	finally
    //   99	119	338	finally
    //   119	126	338	finally
    //   126	177	338	finally
    //   184	188	338	finally
    //   208	230	338	finally
    //   234	294	338	finally
    //   294	327	338	finally
    //   327	331	338	finally
    //   294	327	345	java/lang/Exception
    //   327	331	349	java/lang/Exception
  }
  
  /* Error */
  public boolean a(List paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: invokeinterface 215 1 0
    //   12: istore 7
    //   14: iload 7
    //   16: ifgt +9 -> 25
    //   19: iconst_0
    //   20: istore_3
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_3
    //   24: ireturn
    //   25: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +54 -> 82
    //   31: ldc 22
    //   33: iconst_2
    //   34: new 242	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 678
    //   44: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokeinterface 215 1 0
    //   53: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: ldc_w 361
    //   59: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: iload_2
    //   63: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: ldc_w 680
    //   69: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: iload_3
    //   73: invokevirtual 675	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   76: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   86: invokevirtual 507	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   89: astore 4
    //   91: aload 4
    //   93: invokevirtual 511	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   96: iload_3
    //   97: ifeq +84 -> 181
    //   100: aload_0
    //   101: iload_2
    //   102: invokevirtual 682	com/tencent/mobileqq/freshnews/FreshNewsManager:a	(I)Ljava/util/List;
    //   105: astore 5
    //   107: aload 5
    //   109: ifnull +72 -> 181
    //   112: aload 5
    //   114: invokeinterface 215 1 0
    //   119: ifle +62 -> 181
    //   122: aload 5
    //   124: invokeinterface 219 1 0
    //   129: astore 5
    //   131: aload 5
    //   133: invokeinterface 224 1 0
    //   138: ifeq +43 -> 181
    //   141: aload 5
    //   143: invokeinterface 228 1 0
    //   148: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   151: astore 6
    //   153: aload_0
    //   154: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   157: aload 6
    //   159: invokevirtual 649	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   162: pop
    //   163: goto -32 -> 131
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   171: aload 4
    //   173: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   176: iconst_0
    //   177: istore_3
    //   178: goto -157 -> 21
    //   181: iconst_0
    //   182: istore_2
    //   183: iload_2
    //   184: aload_1
    //   185: invokeinterface 215 1 0
    //   190: if_icmpge +27 -> 217
    //   193: aload_0
    //   194: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   197: aload_1
    //   198: iload_2
    //   199: invokeinterface 542 2 0
    //   204: checkcast 684	com/tencent/mobileqq/persistence/Entity
    //   207: invokevirtual 657	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   210: iload_2
    //   211: iconst_1
    //   212: iadd
    //   213: istore_2
    //   214: goto -31 -> 183
    //   217: aload 4
    //   219: invokevirtual 516	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   222: aload 4
    //   224: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   227: iconst_1
    //   228: istore_3
    //   229: goto -208 -> 21
    //   232: astore_1
    //   233: aload 4
    //   235: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	FreshNewsManager
    //   0	245	1	paramList	List
    //   0	245	2	paramInt	int
    //   0	245	3	paramBoolean	boolean
    //   89	145	4	localEntityTransaction	EntityTransaction
    //   105	37	5	localObject	Object
    //   151	7	6	localFreshNewsInfo	FreshNewsInfo
    //   12	3	7	m	int
    // Exception table:
    //   from	to	target	type
    //   91	96	166	java/lang/Exception
    //   100	107	166	java/lang/Exception
    //   112	131	166	java/lang/Exception
    //   131	163	166	java/lang/Exception
    //   183	210	166	java/lang/Exception
    //   217	222	166	java/lang/Exception
    //   91	96	232	finally
    //   100	107	232	finally
    //   112	131	232	finally
    //   131	163	232	finally
    //   167	171	232	finally
    //   183	210	232	finally
    //   217	222	232	finally
    //   6	14	240	finally
    //   25	82	240	finally
    //   82	91	240	finally
    //   171	176	240	finally
    //   222	227	240	finally
    //   233	240	240	finally
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FreshNewsManager", 2, "canICommentFeed, result=" + bool + ",isSelf=" + paramBoolean + ",mMyCharmLevel=" + this.j + ",mConfig.minCommentLevel=" + this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.minCommentLevel);
      }
      return bool;
      if (this.j < this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.minCommentLevel) {
        bool = false;
      }
    }
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public long b()
  {
    return this.jdField_h_of_type_Long;
  }
  
  public List b()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public void b()
  {
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config = ((FreshNewsManager.Config)FileUtils.a("fresh_news_config"));
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config == null) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config = new FreshNewsManager.Config();
    }
    a();
    a(1);
    a(3);
    h();
    this.jdField_f_of_type_Boolean = true;
    List localList = this.jdField_b_of_type_JavaUtilList;
    int m = 0;
    for (;;)
    {
      try
      {
        if (m < this.jdField_b_of_type_JavaUtilList.size())
        {
          FreshNewsManager.UnpublishedFeedsListener localUnpublishedFeedsListener = (FreshNewsManager.UnpublishedFeedsListener)this.jdField_b_of_type_JavaUtilList.get(m);
          if (localUnpublishedFeedsListener != null) {
            localUnpublishedFeedsListener.a();
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          NearbyUtils.a("FreshNewsManager", new Object[] { "initCache" });
          return;
        }
      }
      finally {}
      m += 1;
    }
  }
  
  public void b(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    this.jdField_h_of_type_Long = paramLong;
  }
  
  public void b(FreshNewsInfo paramFreshNewsInfo)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramFreshNewsInfo).sendToTarget();
  }
  
  public void b(FreshNewsManager.NotifyListener paramNotifyListener)
  {
    synchronized (this.jdField_g_of_type_JavaUtilList)
    {
      this.jdField_g_of_type_JavaUtilList.remove(paramNotifyListener);
      return;
    }
  }
  
  public void b(FreshNewsManager.UnpublishedFeedsListener paramUnpublishedFeedsListener)
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.remove(paramUnpublishedFeedsListener);
      return;
    }
  }
  
  /* Error */
  public void b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   7: ifnull +74 -> 81
    //   10: aload_0
    //   11: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   14: astore_3
    //   15: aload_3
    //   16: monitorenter
    //   17: iconst_0
    //   18: istore 5
    //   20: iload 5
    //   22: aload_0
    //   23: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   26: invokeinterface 215 1 0
    //   31: if_icmpge +48 -> 79
    //   34: aload_0
    //   35: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   38: iload 5
    //   40: invokeinterface 542 2 0
    //   45: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   48: astore 4
    //   50: aload 4
    //   52: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   55: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +120 -> 178
    //   61: aload 4
    //   63: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   66: aload_1
    //   67: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +108 -> 178
    //   73: aload 4
    //   75: iload_2
    //   76: putfield 721	com/tencent/mobileqq/freshnews/FreshNewsInfo:commentCount	I
    //   79: aload_3
    //   80: monitorexit
    //   81: aload_0
    //   82: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   85: ifnull +75 -> 160
    //   88: aload_0
    //   89: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   92: astore_3
    //   93: aload_3
    //   94: monitorenter
    //   95: iload 6
    //   97: istore 5
    //   99: iload 5
    //   101: aload_0
    //   102: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   105: invokeinterface 215 1 0
    //   110: if_icmpge +48 -> 158
    //   113: aload_0
    //   114: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   117: iload 5
    //   119: invokeinterface 542 2 0
    //   124: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   127: astore 4
    //   129: aload 4
    //   131: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   134: invokestatic 317	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   137: ifne +55 -> 192
    //   140: aload 4
    //   142: getfield 545	com/tencent/mobileqq/freshnews/FreshNewsInfo:feedId	Ljava/lang/String;
    //   145: aload_1
    //   146: invokevirtual 548	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq +43 -> 192
    //   152: aload 4
    //   154: iload_2
    //   155: putfield 721	com/tencent/mobileqq/freshnews/FreshNewsInfo:commentCount	I
    //   158: aload_3
    //   159: monitorexit
    //   160: invokestatic 158	com/tencent/mobileqq/app/ThreadManager:b	()Lmqq/os/MqqHandler;
    //   163: new 723	sqn
    //   166: dup
    //   167: aload_0
    //   168: iload_2
    //   169: aload_1
    //   170: invokespecial 724	sqn:<init>	(Lcom/tencent/mobileqq/freshnews/FreshNewsManager;ILjava/lang/String;)V
    //   173: invokevirtual 169	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   176: pop
    //   177: return
    //   178: iload 5
    //   180: iconst_1
    //   181: iadd
    //   182: istore 5
    //   184: goto -164 -> 20
    //   187: astore_1
    //   188: aload_3
    //   189: monitorexit
    //   190: aload_1
    //   191: athrow
    //   192: iload 5
    //   194: iconst_1
    //   195: iadd
    //   196: istore 5
    //   198: goto -99 -> 99
    //   201: astore_1
    //   202: aload_3
    //   203: monitorexit
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	FreshNewsManager
    //   0	206	1	paramString	String
    //   0	206	2	paramInt	int
    //   14	189	3	localList	List
    //   48	105	4	localFreshNewsInfo	FreshNewsInfo
    //   18	179	5	m	int
    //   1	95	6	n	int
    // Exception table:
    //   from	to	target	type
    //   20	79	187	finally
    //   79	81	187	finally
    //   188	190	187	finally
    //   99	158	201	finally
    //   158	160	201	finally
    //   202	204	201	finally
  }
  
  public void b(List paramList, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0)) {}
    synchronized (this.jdField_d_of_type_JavaUtilList)
    {
      this.jdField_d_of_type_JavaUtilList.addAll(paramList);
      this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    return Math.abs(System.currentTimeMillis() - this.jdField_g_of_type_Long) <= 60000L;
  }
  
  /* Error */
  public boolean b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: invokevirtual 507	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   9: astore_3
    //   10: aload_3
    //   11: invokevirtual 511	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   14: aload_0
    //   15: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: new 242	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 741
    //   28: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: lload_1
    //   32: invokevirtual 666	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   35: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 670	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   41: istore 5
    //   43: aload_3
    //   44: invokevirtual 516	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   47: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +30 -> 80
    //   53: ldc 22
    //   55: iconst_2
    //   56: new 242	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 743
    //   66: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: iload 5
    //   71: invokevirtual 675	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   74: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_0
    //   81: lload_1
    //   82: putfield 95	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_f_of_type_Long	J
    //   85: aload_3
    //   86: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: iload 5
    //   93: ireturn
    //   94: astore 4
    //   96: aload 4
    //   98: invokevirtual 297	java/lang/Exception:printStackTrace	()V
    //   101: iconst_0
    //   102: istore 5
    //   104: aload_3
    //   105: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   108: goto -19 -> 89
    //   111: astore_3
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_3
    //   115: athrow
    //   116: astore 4
    //   118: aload_3
    //   119: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   122: aload 4
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	FreshNewsManager
    //   0	125	1	paramLong	long
    //   9	96	3	localEntityTransaction	EntityTransaction
    //   111	8	3	localObject1	Object
    //   94	3	4	localException	Exception
    //   116	7	4	localObject2	Object
    //   41	62	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   10	80	94	java/lang/Exception
    //   80	85	94	java/lang/Exception
    //   2	10	111	finally
    //   85	89	111	finally
    //   104	108	111	finally
    //   118	125	111	finally
    //   10	80	116	finally
    //   80	85	116	finally
    //   96	101	116	finally
  }
  
  public byte[] b()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public long c()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public List c()
  {
    return this.jdField_d_of_type_JavaUtilList;
  }
  
  public void c()
  {
    FreshNewsPublisher localFreshNewsPublisher = (FreshNewsPublisher)this.jdField_a_of_type_JavaUtilLinkedList.poll();
    if (localFreshNewsPublisher != null)
    {
      this.jdField_a_of_type_Boolean = true;
      localFreshNewsPublisher.a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(long paramLong)
  {
    for (;;)
    {
      int m;
      synchronized (this.jdField_f_of_type_JavaUtilList)
      {
        m = this.jdField_f_of_type_JavaUtilList.size() - 1;
        if (m >= 0)
        {
          if (paramLong == ((Long)this.jdField_f_of_type_JavaUtilList.get(m)).longValue()) {
            this.jdField_f_of_type_JavaUtilList.remove(m);
          }
        }
        else
        {
          i();
          return;
        }
      }
      m -= 1;
    }
  }
  
  /* Error */
  public void c(FreshNewsInfo paramFreshNewsInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   4: ifnull +66 -> 70
    //   7: aload_0
    //   8: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: iconst_0
    //   15: istore_3
    //   16: iload_3
    //   17: aload_0
    //   18: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   21: invokeinterface 215 1 0
    //   26: if_icmpge +156 -> 182
    //   29: aload_0
    //   30: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   33: iload_3
    //   34: invokeinterface 542 2 0
    //   39: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   42: getfield 484	com/tencent/mobileqq/freshnews/FreshNewsInfo:publishTime	J
    //   45: aload_1
    //   46: getfield 484	com/tencent/mobileqq/freshnews/FreshNewsInfo:publishTime	J
    //   49: lcmp
    //   50: ifgt +103 -> 153
    //   53: iload_3
    //   54: ifle +128 -> 182
    //   57: aload_0
    //   58: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   61: iload_3
    //   62: aload_1
    //   63: invokeinterface 754 3 0
    //   68: aload_2
    //   69: monitorexit
    //   70: aload_0
    //   71: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   74: ifnull +66 -> 140
    //   77: aload_0
    //   78: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   81: astore_2
    //   82: aload_2
    //   83: monitorenter
    //   84: iconst_0
    //   85: istore_3
    //   86: iload_3
    //   87: aload_0
    //   88: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   91: invokeinterface 215 1 0
    //   96: if_icmpge +81 -> 177
    //   99: aload_0
    //   100: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   103: iload_3
    //   104: invokeinterface 542 2 0
    //   109: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   112: getfield 484	com/tencent/mobileqq/freshnews/FreshNewsInfo:publishTime	J
    //   115: aload_1
    //   116: getfield 484	com/tencent/mobileqq/freshnews/FreshNewsInfo:publishTime	J
    //   119: lcmp
    //   120: ifgt +45 -> 165
    //   123: iload_3
    //   124: ifle +53 -> 177
    //   127: aload_0
    //   128: getfield 85	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_d_of_type_JavaUtilList	Ljava/util/List;
    //   131: iload_3
    //   132: aload_1
    //   133: invokeinterface 754 3 0
    //   138: aload_2
    //   139: monitorexit
    //   140: aload_0
    //   141: getfield 115	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   144: iconst_2
    //   145: aload_1
    //   146: invokevirtual 711	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   149: invokevirtual 716	android/os/Message:sendToTarget	()V
    //   152: return
    //   153: iload_3
    //   154: iconst_1
    //   155: iadd
    //   156: istore_3
    //   157: goto -141 -> 16
    //   160: astore_1
    //   161: aload_2
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    //   165: iload_3
    //   166: iconst_1
    //   167: iadd
    //   168: istore_3
    //   169: goto -83 -> 86
    //   172: astore_1
    //   173: aload_2
    //   174: monitorexit
    //   175: aload_1
    //   176: athrow
    //   177: iconst_0
    //   178: istore_3
    //   179: goto -52 -> 127
    //   182: iconst_0
    //   183: istore_3
    //   184: goto -127 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	FreshNewsManager
    //   0	187	1	paramFreshNewsInfo	FreshNewsInfo
    //   11	163	2	localList	List
    //   15	169	3	m	int
    // Exception table:
    //   from	to	target	type
    //   16	53	160	finally
    //   57	70	160	finally
    //   161	163	160	finally
    //   86	123	172	finally
    //   127	140	172	finally
    //   173	175	172	finally
  }
  
  public void c(List paramList, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0)) {}
    synchronized (this.jdField_e_of_type_JavaUtilList)
    {
      this.jdField_e_of_type_JavaUtilList.addAll(paramList);
      this.jdField_c_of_type_ArrayOfByte = paramArrayOfByte;
      this.jdField_d_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean c()
  {
    return this.j >= this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$Config.minPublishFeedLevel;
  }
  
  public byte[] c()
  {
    return this.jdField_c_of_type_ArrayOfByte;
  }
  
  public List d()
  {
    return this.jdField_e_of_type_JavaUtilList;
  }
  
  public void d()
  {
    synchronized (this.jdField_f_of_type_JavaUtilList)
    {
      this.jdField_f_of_type_JavaUtilList.clear();
      i();
      return;
    }
  }
  
  public void d(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void d(FreshNewsInfo paramFreshNewsInfo)
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramFreshNewsInfo).sendToTarget();
  }
  
  public boolean d()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void e()
  {
    NearbyUtils.a("FreshNewsManager", "clearFeedsCache", new Object[] { Integer.valueOf(this.jdField_c_of_type_JavaUtilList.size()) });
    if (this.jdField_c_of_type_JavaUtilList != null) {
      synchronized (this.jdField_c_of_type_JavaUtilList)
      {
        this.jdField_c_of_type_JavaUtilList.clear();
        return;
      }
    }
  }
  
  public void e(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void e(FreshNewsInfo paramFreshNewsInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramFreshNewsInfo)) {
        this.jdField_a_of_type_JavaUtilList.remove(paramFreshNewsInfo);
      }
      return;
    }
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_JavaUtilList != null) {
      synchronized (this.jdField_d_of_type_JavaUtilList)
      {
        this.jdField_d_of_type_JavaUtilList.clear();
        return;
      }
    }
  }
  
  public void f(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
  
  public void f(FreshNewsInfo paramFreshNewsInfo)
  {
    ThreadManager.b().post(new sqk(this, paramFreshNewsInfo));
  }
  
  public void g()
  {
    if (this.jdField_e_of_type_JavaUtilList != null) {
      synchronized (this.jdField_e_of_type_JavaUtilList)
      {
        this.jdField_e_of_type_JavaUtilList.clear();
        return;
      }
    }
  }
  
  public void g(long paramLong)
  {
    try
    {
      FreshNewsNotify localFreshNewsNotify = (FreshNewsNotify)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(FreshNewsNotify.class, String.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("FreshNewsManager", 2, "deleteNotify, eventId=" + paramLong + ", find notify=" + localFreshNewsNotify);
      }
      if (localFreshNewsNotify != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localFreshNewsNotify);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void h(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifgt +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   11: ifnull +81 -> 92
    //   14: aload_0
    //   15: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   18: astore_3
    //   19: aload_3
    //   20: monitorenter
    //   21: iconst_0
    //   22: istore 5
    //   24: iload 5
    //   26: aload_0
    //   27: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   30: invokeinterface 215 1 0
    //   35: if_icmpge +55 -> 90
    //   38: aload_0
    //   39: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   42: iload 5
    //   44: invokeinterface 542 2 0
    //   49: checkcast 199	com/tencent/mobileqq/freshnews/FreshNewsInfo
    //   52: astore 4
    //   54: aload 4
    //   56: ifnull +125 -> 181
    //   59: aload 4
    //   61: getfield 780	com/tencent/mobileqq/freshnews/FreshNewsInfo:publisherID	J
    //   64: lload_1
    //   65: lcmp
    //   66: ifne +115 -> 181
    //   69: aload_0
    //   70: getfield 83	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_c_of_type_JavaUtilList	Ljava/util/List;
    //   73: iload 5
    //   75: invokeinterface 550 2 0
    //   80: pop
    //   81: iload 5
    //   83: iconst_1
    //   84: isub
    //   85: istore 5
    //   87: goto +94 -> 181
    //   90: aload_3
    //   91: monitorexit
    //   92: aload_0
    //   93: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   96: invokevirtual 507	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   99: astore_3
    //   100: aload_3
    //   101: invokevirtual 511	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   104: aload_0
    //   105: getfield 148	com/tencent/mobileqq/freshnews/FreshNewsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   108: new 242	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 782
    //   118: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: lload_1
    //   122: invokevirtual 666	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 670	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   131: pop
    //   132: aload_3
    //   133: invokevirtual 516	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   136: aload_3
    //   137: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   140: return
    //   141: astore 4
    //   143: aload_3
    //   144: monitorexit
    //   145: aload 4
    //   147: athrow
    //   148: astore 4
    //   150: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +14 -> 167
    //   156: ldc 22
    //   158: iconst_2
    //   159: ldc_w 784
    //   162: aload 4
    //   164: invokestatic 787	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   167: aload_3
    //   168: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   171: return
    //   172: astore 4
    //   174: aload_3
    //   175: invokevirtual 518	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   178: aload 4
    //   180: athrow
    //   181: iload 5
    //   183: iconst_1
    //   184: iadd
    //   185: istore 5
    //   187: goto -163 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	FreshNewsManager
    //   0	190	1	paramLong	long
    //   18	157	3	localObject1	Object
    //   52	8	4	localFreshNewsInfo	FreshNewsInfo
    //   141	5	4	localObject2	Object
    //   148	15	4	localException	Exception
    //   172	7	4	localObject3	Object
    //   22	164	5	m	int
    // Exception table:
    //   from	to	target	type
    //   24	54	141	finally
    //   59	81	141	finally
    //   90	92	141	finally
    //   143	145	141	finally
    //   100	136	148	java/lang/Exception
    //   100	136	172	finally
    //   150	167	172	finally
  }
  
  public void onDestroy()
  {
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


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */