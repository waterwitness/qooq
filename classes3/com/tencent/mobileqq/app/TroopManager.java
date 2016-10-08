package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HWTroopMemberCard;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchConfigManager.TroopMemberSetting;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopRankColorConfig;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qhm;
import qho;
import qhp;
import tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef.ReqBody;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;

public class TroopManager
  implements Manager
{
  public static final int a = -100;
  public static final TroopManager.DownloadFileConfig a;
  public static final String a = "Q.contacttab.";
  protected static final int b = 12;
  public static final String b = "Q.contacttab.troop";
  protected static final int c = 24;
  public static final String c = "troopfileConfigVersion";
  public static final String d = "troopfileConfig";
  public static final int e = 259200;
  public static final String f = "5.5.0";
  public static final String g = "uniqueTitleNewFlag";
  protected static final String h = "oldestUniqueTitleExpireTime";
  protected static final String i = "troop_app_list_data";
  public static final String j = "is_first_upgrade_to_500";
  protected LruCache a;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  public QQAppInterface a;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new qhp(this);
  protected EntityManager a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected HashMap a;
  protected Map a;
  Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  protected ConcurrentHashMap a;
  protected boolean a;
  protected LruCache b;
  protected ArrayList b;
  HashMap b;
  protected Map b;
  protected ConcurrentHashMap b;
  protected LruCache c;
  private ArrayList jdField_c_of_type_JavaUtilArrayList;
  private Map jdField_c_of_type_JavaUtilMap = new HashMap();
  protected ConcurrentHashMap c;
  public int d;
  LruCache jdField_d_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
  private ArrayList jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  protected ConcurrentHashMap d;
  protected String e;
  private int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqAppTroopManager$DownloadFileConfig = new TroopManager.DownloadFileConfig();
  }
  
  public TroopManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(12);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver, true);
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.a() + "_troopManager", 0);
    this.jdField_d_of_type_Int = paramQQAppInterface.getInt("troopfileConfigVersion", 0);
    g(paramQQAppInterface.getString("troopfileConfig", "{}"));
  }
  
  private ConcurrentHashMap a()
  {
    int m = 0;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CommonlyUsedTroop.class, false, null, null, null, null, null, null);
      if (localArrayList != null) {}
      for (int k = localArrayList.size();; k = 0)
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(k);
        while (m < k)
        {
          CommonlyUsedTroop localCommonlyUsedTroop = (CommonlyUsedTroop)localArrayList.get(m);
          if (QLog.isColorLevel()) {
            QLog.d("OpenTroopDebug", 2, "init load groupcode = " + localCommonlyUsedTroop.troopUin);
          }
          this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localCommonlyUsedTroop.troopUin, localCommonlyUsedTroop);
          m += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("CommonlyUsedTroop", 2, "load CommonlyUsedTroop info: size = " + k);
      }
    }
    return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_0x787.Filter localFilter = new oidb_0x787.Filter();
    localFilter.uint32_special_title.set(0);
    localFilter.uint32_nick_name.set(0);
    localFilter.uint32_member_level_info_name.set(0);
    localFilter.uint32_member_level_info_uin.set(0);
    oidb_0x787.ReqBody localReqBody = new oidb_0x787.ReqBody();
    localReqBody.uint64_group_code.set(Long.parseLong(paramString));
    localReqBody.uint64_begin_uin.set(paramLong1);
    localReqBody.uint64_data_time.set(paramLong2);
    localReqBody.opt_filter.set(localFilter);
    ProtoUtils.a(paramQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x787_1", 1927, 1);
  }
  
  private void a(String paramString1, String paramString2, TroopMemberInfo paramTroopMemberInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    LruCache localLruCache2 = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
    LruCache localLruCache1 = localLruCache2;
    if (localLruCache2 == null) {
      localLruCache1 = new LruCache(24);
    }
    localLruCache1.put(paramString2, paramTroopMemberInfo);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString1, localLruCache1);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    oidb_cmd0x6ef.ReqBody localReqBody = new oidb_cmd0x6ef.ReqBody();
    localReqBody.gc.set(Long.parseLong(paramString1));
    localReqBody.event_id.set(paramString2);
    localReqBody.seq.set(paramLong);
    ProtoUtils.a(paramQQAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x6ef_0", 1775, 0);
    return false;
  }
  
  private boolean a(TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    Object localObject1;
    int k;
    Object localObject3;
    label162:
    boolean bool;
    label169:
    label208:
    int m;
    long l1;
    if (!paramBoolean)
    {
      SearchConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject1 = null;
      int n = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("is_first_upgrade_to_500", 0);
      if (n == 0) {
        k = 1;
      }
      for (;;)
      {
        if ((SearchConfigManager.troopMemberUpdateConfigs != null) && (!SearchConfigManager.troopMemberUpdateConfigs.isEmpty()))
        {
          Iterator localIterator = SearchConfigManager.troopMemberUpdateConfigs.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              SearchConfigManager.TroopMemberSetting localTroopMemberSetting = (SearchConfigManager.TroopMemberSetting)localIterator.next();
              if (k != 0)
              {
                localObject3 = localTroopMemberSetting;
                if (localObject1 != null)
                {
                  if (((SearchConfigManager.TroopMemberSetting)localObject1).b <= localTroopMemberSetting.b) {
                    break label719;
                  }
                  localObject3 = localTroopMemberSetting;
                }
                localObject1 = localObject3;
                continue;
                k = 0;
                break;
              }
              if ((paramTroopInfo.wMemberNum > localTroopMemberSetting.jdField_a_of_type_Int) && (paramTroopInfo.wMemberNum < localTroopMemberSetting.b))
              {
                localObject1 = localTroopMemberSetting;
                if (localObject1 == null)
                {
                  bool = false;
                  paramBoolean = bool;
                  if (k != 0)
                  {
                    paramBoolean = bool;
                    if (localObject1 != null)
                    {
                      if ((paramTroopInfo.wMemberNum <= ((SearchConfigManager.TroopMemberSetting)localObject1).jdField_a_of_type_Int) || (paramTroopInfo.wMemberNum >= ((SearchConfigManager.TroopMemberSetting)localObject1).b)) {
                        break label546;
                      }
                      paramBoolean = true;
                    }
                  }
                  m = 0;
                  l1 = FTSTroopOperator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopInfo.troopuin);
                  bool = paramBoolean;
                  k = m;
                  if (paramBoolean)
                  {
                    l1 = Math.abs(System.currentTimeMillis() - l1);
                    if (NetworkUtil.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))
                    {
                      if (l1 >= ((SearchConfigManager.TroopMemberSetting)localObject1).c * 3600000L) {
                        break label710;
                      }
                      paramBoolean = false;
                      label276:
                      if ((!paramBoolean) || (l1 <= ((SearchConfigManager.TroopMemberSetting)localObject1).c * 3600000L * 2L) || (l1 <= 3600000L * ((SearchConfigManager.TroopMemberSetting)localObject1).jdField_d_of_type_Int)) {
                        break label700;
                      }
                      k = 1;
                      bool = paramBoolean;
                    }
                  }
                  else
                  {
                    label320:
                    paramBoolean = bool;
                    if (n == 2)
                    {
                      paramBoolean = bool;
                      if (bool)
                      {
                        paramBoolean = bool;
                        if (k != 0) {}
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        l1 = Long.valueOf(paramTroopInfo.troopuin).longValue();
        k = Calendar.getInstance().get(5);
        m = ((SearchConfigManager.TroopMemberSetting)localObject1).c / 24;
        paramBoolean = bool;
        if (m != 0)
        {
          long l2 = m;
          paramBoolean = bool;
          if (l1 % l2 != k % m) {
            paramBoolean = false;
          }
        }
      }
      catch (Exception localException)
      {
        label546:
        paramBoolean = bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, except: %s", new Object[] { localException.getMessage() }));
        paramBoolean = bool;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, ignore troop: %s, wMemberNum: %d, mMemberNumSeq: %d mOldMemberNumSeq: %d, mMemberCardSeq: %d, mOldMemberCardSeq:%d, overtime: %s", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramTroopInfo.wMemberNum), Long.valueOf(paramTroopInfo.mMemberNumSeq), Long.valueOf(paramTroopInfo.mOldMemberNumSeq), Long.valueOf(paramTroopInfo.mMemberCardSeq), Long.valueOf(paramTroopInfo.mOldMemberCardSeq), Boolean.valueOf(paramBoolean) }));
        return false;
      }
      if ((paramBoolean) && ((!QLog.isColorLevel()) || ((paramTroopInfo.mMemberNumSeq != paramTroopInfo.mOldMemberNumSeq) || (paramTroopInfo.mMemberNumSeq == -1L) || (paramTroopInfo.mMemberCardSeq != paramTroopInfo.mOldMemberCardSeq) || (paramTroopInfo.mMemberCardSeq == -1L))))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.contacttab.troop", 2, String.format("needGetMemberListForFTS, get troop: %s, wMemberNum: %d, mMemberNumSeq: %d mOldMemberNumSeq: %d, mMemberCardSeq: %d, mOldMemberCardSeq:%d", new Object[] { paramTroopInfo.troopuin, Integer.valueOf(paramTroopInfo.wMemberNum), Long.valueOf(paramTroopInfo.mMemberNumSeq), Long.valueOf(paramTroopInfo.mOldMemberNumSeq), Long.valueOf(paramTroopInfo.mMemberCardSeq), Long.valueOf(paramTroopInfo.mOldMemberCardSeq) }));
        }
        return true;
        paramBoolean = false;
        break label208;
        if (l1 >= ((SearchConfigManager.TroopMemberSetting)localObject1).jdField_d_of_type_Int * 3600000L) {
          break label710;
        }
        paramBoolean = false;
        break label276;
      }
      label700:
      bool = paramBoolean;
      k = m;
      break label320;
      label710:
      break label276;
      bool = true;
      break label169;
      label719:
      localObject3 = localException;
      break;
      break label162;
      Object localObject2 = null;
      break label162;
      paramBoolean = true;
    }
  }
  
  private TroopMemberInfo b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
    if (paramString1 == null) {
      return null;
    }
    return (TroopMemberInfo)paramString1.get(paramString2);
  }
  
  private ConcurrentHashMap b()
  {
    int m = 0;
    if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ShowExternalTroop.class, false, null, null, null, null, null, null);
      if (localArrayList != null) {}
      for (int k = localArrayList.size();; k = 0)
      {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(k);
        while (m < k)
        {
          ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localArrayList.get(m);
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localShowExternalTroop.troopUin, localShowExternalTroop);
          m += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "load mShowExternalTroopCache info: size = " + k);
      }
    }
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  private void c(ArrayList paramArrayList)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      if (paramArrayList == null) {
        break label35;
      }
    }
    label35:
    for (int k = paramArrayList.size();; k = 0)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(k);
      if (paramArrayList != null) {
        break;
      }
      return;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        k = 0;
        if (k < paramArrayList.size())
        {
          TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(k);
          Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
          if ((localTroopInfo == null) || (((HotChatManager)localObject).b(localTroopInfo.troopuin)) || ((localTroopInfo != null) && (localTroopInfo.troopuin == null) && (localTroopInfo.troopcode == null))) {
            break label263;
          }
          if ((localTroopInfo.troopcode == null) || (localTroopInfo.troopcode.length() <= 1))
          {
            localObject = (Entity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localTroopInfo.troopuin);
            if ((localObject != null) && ((localObject instanceof TroopInfo)))
            {
              localObject = (TroopInfo)localObject;
              if ((((TroopInfo)localObject).troopcode != null) && (((TroopInfo)localObject).troopcode.length() > 1)) {
                localTroopInfo.troopcode = ((TroopInfo)localObject).troopcode;
              }
            }
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopInfo.troopuin, localTroopInfo);
          a(localTroopInfo);
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        localEntityTransaction.b();
        f();
        return;
        localEntityTransaction.c();
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        localEntityTransaction.b();
      }
      label263:
      k += 1;
    }
  }
  
  private void e()
  {
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "initTroopListCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, false, null, null, null, null, null, null);
    if (localObject2 != null) {}
    ConcurrentHashMap localConcurrentHashMap;
    ArrayList localArrayList;
    for (int k = ((ArrayList)localObject2).size();; k = 0)
    {
      localConcurrentHashMap = new ConcurrentHashMap(k);
      if (localObject2 == null) {
        break label219;
      }
      localArrayList = new ArrayList();
      k = 0;
      while (k < ((ArrayList)localObject2).size())
      {
        TroopInfo localTroopInfo = (TroopInfo)((ArrayList)localObject2).get(k);
        if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0))
        {
          ContactSorter.a(localTroopInfo);
          localArrayList.add(localTroopInfo);
        }
        localConcurrentHashMap.put(localTroopInfo.troopuin, localTroopInfo);
        k += 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject2).a();
      k = m;
    }
    try
    {
      while (k < localArrayList.size())
      {
        a((Entity)localArrayList.get(k));
        k += 1;
      }
      ((EntityTransaction)localObject2).c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ((EntityTransaction)localObject2).b();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).b();
    }
    localArrayList.clear();
    label219:
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "initTroopListCache end: " + localConcurrentHashMap.size());
    }
  }
  
  private void e(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramString1 = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
    } while (paramString1 == null);
    paramString1.remove(paramString2);
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "buildTroopUI begin: ");
    }
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      int k = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      if (k > 0)
      {
        localArrayList.ensureCapacity(k);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
          if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0)) {
            ContactSorter.a(localTroopInfo);
          }
          localArrayList.add(localTroopInfo);
        }
        if (k > 1) {
          Collections.sort(localArrayList, ContactSorter.a);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "buildTroopUI end: " + localArrayList.size());
    }
  }
  
  private boolean g(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  public double a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.troopMemberDistance", 2, "getTroopMemberDiatanceToSelf, uin is null");
      }
    }
    do
    {
      return -100.0D;
      paramString1 = a(paramString1, paramString2);
    } while (paramString1 == null);
    return paramString1.distanceToSelf;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_troopManager", 0).getInt("uniqueTitleNewFlag", 0);
  }
  
  public int a(TroopRankColorConfig paramTroopRankColorConfig, TroopInfo paramTroopInfo, TroopMemberInfo paramTroopMemberInfo, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramTroopRankColorConfig.e;
    }
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {
      return paramTroopRankColorConfig.jdField_d_of_type_Int;
    }
    if (paramTroopMemberInfo.level > 0)
    {
      if (paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin)) {
        return paramTroopRankColorConfig.jdField_a_of_type_Int;
      }
      if (paramTroopInfo.isTroopAdmin(paramTroopMemberInfo.memberuin)) {
        return paramTroopRankColorConfig.b;
      }
      if (!TextUtils.isEmpty(paramString)) {
        return paramTroopRankColorConfig.c;
      }
      return paramTroopRankColorConfig.a(paramTroopMemberInfo.level);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.troop", 2, "getTroopMemberLevel returns null");
    }
    return paramTroopRankColorConfig.jdField_d_of_type_Int;
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + paramString, 0).getLong("oldestUniqueTitleExpireTime", 0L);
  }
  
  public long a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.troop", 2, "getIsTroopMemberFollowed uin is null");
      }
    }
    do
    {
      return 0L;
      paramString1 = a(paramString1, paramString2);
    } while (paramString1 == null);
    return paramString1.distanceToSelfUpdateTimeStamp;
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    TroopManager.TroopMemberLevelValue localTroopMemberLevelValue = new TroopManager.TroopMemberLevelValue(this);
    localTroopMemberLevelValue.jdField_a_of_type_Int = paramInt;
    localTroopMemberLevelValue.jdField_a_of_type_JavaLangString = paramString;
    return (Drawable)this.jdField_d_of_type_AndroidSupportV4UtilLruCache.get(localTroopMemberLevelValue);
  }
  
  public TroopManager.DownloadFileConfig a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    localObject = (TroopManager.DownloadFileConfig)this.jdField_c_of_type_JavaUtilMap.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (TroopManager.DownloadFileConfig)this.jdField_c_of_type_JavaUtilMap.get("*");
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = jdField_a_of_type_ComTencentMobileqqAppTroopManager$DownloadFileConfig;
    }
    return (TroopManager.DownloadFileConfig)localObject;
  }
  
  public TroopManager.MemberGagInfo a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    long l = 0L;
    if (paramString1 != null) {
      l = paramString1.gagTimeStamp;
    }
    return new TroopManager.MemberGagInfo(this, paramString2, l);
  }
  
  public HWTroopMemberCard a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    return (HWTroopMemberCard)this.jdField_c_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
  }
  
  public TroopInfo a(String paramString)
  {
    TroopInfo localTroopInfo1 = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      localTroopInfo1 = (TroopInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    TroopInfo localTroopInfo2 = localTroopInfo1;
    if (localTroopInfo1 == null)
    {
      localTroopInfo2 = localTroopInfo1;
      if (!this.jdField_a_of_type_Boolean)
      {
        localTroopInfo1 = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, paramString);
        localTroopInfo2 = localTroopInfo1;
        if (localTroopInfo1 != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localTroopInfo1);
          localTroopInfo2 = localTroopInfo1;
        }
      }
    }
    return localTroopInfo2;
  }
  
  protected TroopInfo a(String paramString1, String paramString2)
  {
    TroopInfo localTroopInfo2 = a(paramString1);
    TroopInfo localTroopInfo1 = localTroopInfo2;
    if (localTroopInfo2 == null)
    {
      localTroopInfo1 = new TroopInfo();
      localTroopInfo1.troopuin = paramString1;
    }
    localTroopInfo1.troopname = paramString2;
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localTroopInfo1.troopuin))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopInfo1.troopuin, localTroopInfo1);
    }
    ContactSorter.a(localTroopInfo1);
    f();
    return localTroopInfo1;
  }
  
  public TroopMemberCard a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    return (TroopMemberCard)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString1);
  }
  
  public TroopMemberInfo a(String paramString1, String paramString2)
  {
    TroopMemberInfo localTroopMemberInfo = b(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      List localList = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? AND memberuin=?", new String[] { paramString1, paramString2 }, null, null, null, null);
      localEntityManager.a();
      if ((localList != null) && (localList.size() > 0))
      {
        localTroopMemberInfo = (TroopMemberInfo)localList.get(0);
        a(paramString1, paramString2, localTroopMemberInfo);
        return localTroopMemberInfo;
      }
    }
    return localTroopMemberInfo;
  }
  
  public EntityTransaction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
  
  public String a(TroopInfo paramTroopInfo, TroopMemberInfo paramTroopMemberInfo, Context paramContext)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.troop", 2, "getTroopMemberName tmi or ti null!");
      }
      paramContext = null;
    }
    String str;
    do
    {
      return paramContext;
      if (paramTroopMemberInfo.level <= 0) {
        break;
      }
      str = paramTroopInfo.getOwnerOrAdminString(paramTroopMemberInfo.memberuin, paramContext);
      paramContext = str;
    } while (str != null);
    paramTroopInfo = paramTroopInfo.getTroopLevelMap();
    if (paramTroopInfo != null)
    {
      return (String)paramTroopInfo.get(Integer.valueOf(paramTroopMemberInfo.level));
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.troop", 2, "getTroopMemberLevel returns null");
      }
    }
    return null;
  }
  
  public String a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject2;
    if (paramTroopMemberInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "getTroopMemberName tmi == null");
      }
      localObject2 = "";
      return (String)localObject2;
    }
    Object localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramTroopMemberInfo.memberuin);
    if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (!TextUtils.isEmpty(((Friends)localObject1).remark))) {
      localObject1 = ((Friends)localObject1).remark;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      return paramTroopMemberInfo.memberuin;
      if (!TextUtils.isEmpty(paramTroopMemberInfo.troopnick)) {
        localObject1 = paramTroopMemberInfo.troopnick;
      } else if ((localObject1 != null) && (((Friends)localObject1).isFriend())) {
        localObject1 = ((Friends)localObject1).name;
      } else if (!TextUtils.isEmpty(paramTroopMemberInfo.autoremark)) {
        localObject1 = paramTroopMemberInfo.autoremark;
      } else {
        localObject1 = paramTroopMemberInfo.friendnick;
      }
    }
  }
  
  public String a(String paramString)
  {
    TroopInfo localTroopInfo = a(paramString);
    String str = paramString;
    if (localTroopInfo != null)
    {
      str = paramString;
      if (localTroopInfo.troopname != null) {
        str = localTroopInfo.troopname;
      }
    }
    return str;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return ContactUtils.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  /* Error */
  public ArrayList a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 92	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 93	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: getfield 132	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   15: invokevirtual 481	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +132 -> 154
    //   25: aload_2
    //   26: invokevirtual 485	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   29: invokestatic 732	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   32: lstore 5
    //   34: aload_0
    //   35: getfield 132	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   38: ldc_w 470
    //   41: iconst_0
    //   42: ldc_w 734
    //   45: iconst_1
    //   46: anewarray 448	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: invokevirtual 202	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +92 -> 154
    //   65: aload_1
    //   66: invokeinterface 735 1 0
    //   71: astore_1
    //   72: aload_1
    //   73: invokeinterface 358 1 0
    //   78: ifeq +76 -> 154
    //   81: aload_1
    //   82: invokeinterface 362 1 0
    //   87: checkcast 470	com/tencent/mobileqq/data/TroopMemberInfo
    //   90: astore_3
    //   91: aload_3
    //   92: invokestatic 740	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/data/TroopMemberInfo;)Z
    //   95: ifeq -23 -> 72
    //   98: aload_3
    //   99: getfield 641	com/tencent/mobileqq/data/TroopMemberInfo:gagTimeStamp	J
    //   102: lconst_0
    //   103: lcmp
    //   104: ifeq -32 -> 72
    //   107: aload_3
    //   108: getfield 641	com/tencent/mobileqq/data/TroopMemberInfo:gagTimeStamp	J
    //   111: lload 5
    //   113: lcmp
    //   114: ifle -42 -> 72
    //   117: aload 4
    //   119: new 643	com/tencent/mobileqq/app/TroopManager$MemberGagInfo
    //   122: dup
    //   123: aload_0
    //   124: aload_3
    //   125: getfield 594	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   128: aload_3
    //   129: getfield 641	com/tencent/mobileqq/data/TroopMemberInfo:gagTimeStamp	J
    //   132: invokespecial 646	com/tencent/mobileqq/app/TroopManager$MemberGagInfo:<init>	(Lcom/tencent/mobileqq/app/TroopManager;Ljava/lang/String;J)V
    //   135: invokevirtual 525	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   138: pop
    //   139: goto -67 -> 72
    //   142: astore_1
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   151: aload 4
    //   153: areturn
    //   154: aload_2
    //   155: ifnull -4 -> 151
    //   158: aload_2
    //   159: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   162: aload 4
    //   164: areturn
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +7 -> 176
    //   172: aload_2
    //   173: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   176: aload_1
    //   177: athrow
    //   178: astore_1
    //   179: goto -11 -> 168
    //   182: astore_1
    //   183: goto -40 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	TroopManager
    //   0	186	1	paramString	String
    //   1	172	2	localObject1	Object
    //   18	111	3	localObject2	Object
    //   9	154	4	localArrayList	ArrayList
    //   32	80	5	l	long
    // Exception table:
    //   from	to	target	type
    //   25	61	142	java/lang/Throwable
    //   65	72	142	java/lang/Throwable
    //   72	139	142	java/lang/Throwable
    //   11	19	165	finally
    //   25	61	178	finally
    //   65	72	178	finally
    //   72	139	178	finally
    //   11	19	182	java/lang/Throwable
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((CommonlyUsedTroop)localIterator.next());
    }
    return localArrayList;
  }
  
  public List a(String paramString)
  {
    if ((paramString == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = new ArrayList();
      paramString = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopNotificationCache.class, true, "troopUin=? and read=? and currentUin=?", new String[] { paramString, "0", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() }, null, null, "time ASC", null);
    } while (paramString == null);
    HashMap localHashMap = new HashMap();
    int k = 0;
    if (k < paramString.size())
    {
      TroopNotificationCache localTroopNotificationCache = (TroopNotificationCache)paramString.get(k);
      if (localHashMap.containsKey(localTroopNotificationCache.feedsId)) {}
      for (;;)
      {
        k += 1;
        break;
        localArrayList.add(localTroopNotificationCache);
        localHashMap.put(localTroopNotificationCache.feedsId, Integer.valueOf(1));
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    e();
    f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_troopManager", 0).edit().putInt("uniqueTitleNewFlag", paramInt).commit();
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt == ((Integer)((Iterator)localObject).next()).intValue())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.contacttab.", 4, String.format("Discard message", new Object[0]));
        }
        return;
      }
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
      this.jdField_a_of_type_JavaUtilQueue.poll();
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt));
    String str = String.valueOf(paramLong1);
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    TroopInfo localTroopInfo = localTroopManager.a(String.valueOf(paramLong1));
    localObject = localTroopInfo;
    if (localTroopInfo == null)
    {
      localObject = new TroopInfo();
      ((TroopInfo)localObject).troopuin = str;
    }
    if ((((TroopInfo)localObject).troopPrivilegeFlag & paramLong3) != (paramLong4 & paramLong3)) {
      if ((paramLong4 & paramLong3) != paramLong3) {
        break label219;
      }
    }
    label219:
    for (((TroopInfo)localObject).troopPrivilegeFlag &= paramLong3;; ((TroopInfo)localObject).troopPrivilegeFlag &= (0xFFFFFFFFFFFFFFFF ^ paramLong3))
    {
      localTroopManager.b((TroopInfo)localObject);
      a(str, paramLong2, paramInt, paramLong3, paramLong4, paramString);
      return;
    }
  }
  
  public void a(int paramInt, String paramString, Drawable paramDrawable)
  {
    TroopManager.TroopMemberLevelValue localTroopMemberLevelValue = new TroopManager.TroopMemberLevelValue(this);
    localTroopMemberLevelValue.jdField_a_of_type_Int = paramInt;
    localTroopMemberLevelValue.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_AndroidSupportV4UtilLruCache.put(localTroopMemberLevelValue, paramDrawable);
  }
  
  public void a(TroopManager.TroopMemberUpdateObserver paramTroopMemberUpdateObserver)
  {
    try
    {
      this.jdField_d_of_type_JavaUtilArrayList.add(paramTroopMemberUpdateObserver);
      return;
    }
    finally
    {
      paramTroopMemberUpdateObserver = finally;
      throw paramTroopMemberUpdateObserver;
    }
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramTroopInfo.troopuin))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTroopInfo.troopuin, paramTroopInfo);
    }
    a(paramTroopInfo);
    f();
  }
  
  public void a(String paramString)
  {
    TroopInfo localTroopInfo = a(paramString);
    if (localTroopInfo == null) {}
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localTroopInfo);
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        }
        f();
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "tm->deleteTroop-->delete troop");
        }
        TroopNotificationHelper.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        TroopAssistantManager.a().b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(63, true, paramString);
        e(paramString);
        SharedPreUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
        try
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(Long.parseLong(paramString)))
          {
            BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
            return;
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.contacttab.", 2, "tm->deleteTroop-->NumberFormatException, troopUin:" + paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    if (!TextUtils.isEmpty(paramString))
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_troopManager", 0).edit();
      localEditor.putInt("troopfileConfigVersion", paramInt);
      localEditor.putString("troopfileConfig", paramString);
      localEditor.commit();
      g(paramString);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + paramString, 0).edit().putLong("oldestUniqueTitleExpireTime", paramLong).commit();
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "----------addTroopPrivilegeTipsMr troopUin: " + paramString1);
    }
    if (TextUtils.isEmpty(paramString2)) {
      if ((1L & paramLong2) == 1L) {
        if ((1L & paramLong3) == 1L) {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131364355);
        }
      }
    }
    for (;;)
    {
      MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(64523);
      localMessageForGrayTips.frienduin = paramString1;
      localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, paramString1, paramString2, paramLong1, 64523, 1, paramInt);
      localMessageForGrayTips.isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForGrayTips, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      return;
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131364354);
      continue;
      if ((0x2 & paramLong2) == 2L) {
        if ((0x2 & paramLong3) == 2L) {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131364353);
        } else {
          paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131364352);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    int k = 0;
    while (k < this.jdField_d_of_type_JavaUtilArrayList.size())
    {
      ((TroopManager.TroopMemberUpdateObserver)this.jdField_d_of_type_JavaUtilArrayList.get(k)).b(paramString1, paramString2);
      k += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, HWTroopMemberCard paramHWTroopMemberCard)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramHWTroopMemberCard != null))
    {
      paramString1 = paramString1 + "_" + paramString2;
      this.jdField_c_of_type_AndroidSupportV4UtilLruCache.put(paramString1, paramHWTroopMemberCard);
    }
  }
  
  public void a(String paramString1, String paramString2, TroopMemberCard paramTroopMemberCard)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramTroopMemberCard != null))
    {
      paramString1 = paramString1 + "_" + paramString2;
      this.jdField_b_of_type_AndroidSupportV4UtilLruCache.put(paramString1, paramTroopMemberCard);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ThreadManager.a(new qho(this, paramString1, paramString2, paramString3), 8, null, true);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    TroopMemberInfo localTroopMemberInfo2 = a(paramString1, paramString2);
    TroopMemberInfo localTroopMemberInfo1 = localTroopMemberInfo2;
    if (localTroopMemberInfo2 == null)
    {
      localTroopMemberInfo1 = new TroopMemberInfo();
      localTroopMemberInfo1.memberuin = paramString2;
      localTroopMemberInfo1.troopuin = paramString1;
    }
    localTroopMemberInfo1.mUniqueTitle = paramString3;
    localTroopMemberInfo1.mUniqueTitleExpire = paramInt;
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (localTroopMemberInfo1.getStatus() == 1000)
    {
      a(paramString1, paramString2, localTroopMemberInfo1);
      paramString3.b(localTroopMemberInfo1);
    }
    for (;;)
    {
      paramString3.a();
      a(paramString1, paramString2, false);
      return;
      paramString3.a(localTroopMemberInfo1);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + paramString1, 0).edit().putBoolean(paramString2, paramBoolean).commit();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + paramString, 0).edit().putString("troop_app_list_data", Base64Util.encodeToString(paramArrayOfByte, 2)).commit();
  }
  
  public void a(ArrayList paramArrayList)
  {
    TraceUtils.a("queryTroops_" + paramArrayList.size());
    if (paramArrayList.size() > 0)
    {
      Object localObject = new StringBuilder("troopuin=? ");
      int k = 1;
      while (k < paramArrayList.size())
      {
        ((StringBuilder)localObject).append("or troopuin=? ");
        k += 1;
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, true, ((StringBuilder)localObject).toString(), (String[])paramArrayList.toArray(new String[paramArrayList.size()]), null, null, null, null);
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject = (TroopInfo)paramArrayList.next();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(((TroopInfo)localObject).troopuin, localObject);
        }
      }
    }
    TraceUtils.a();
  }
  
  /* Error */
  void a(ArrayList paramArrayList, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +54 -> 57
    //   6: new 148	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 980
    //   16: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore 4
    //   21: aload_1
    //   22: ifnull +47 -> 69
    //   25: aload_1
    //   26: invokevirtual 206	java/util/ArrayList:size	()I
    //   29: istore 8
    //   31: ldc 17
    //   33: iconst_2
    //   34: aload 4
    //   36: iload 8
    //   38: invokevirtual 238	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 982
    //   44: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: lload_2
    //   48: invokevirtual 985	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   51: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 227	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_1
    //   58: ifnull +10 -> 68
    //   61: aload_1
    //   62: invokevirtual 206	java/util/ArrayList:size	()I
    //   65: ifne +10 -> 75
    //   68: return
    //   69: iconst_m1
    //   70: istore 8
    //   72: goto -41 -> 31
    //   75: aload_0
    //   76: aload_1
    //   77: invokespecial 987	com/tencent/mobileqq/app/TroopManager:c	(Ljava/util/ArrayList;)V
    //   80: aload_0
    //   81: getfield 132	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   84: invokevirtual 481	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 485	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   92: aload_0
    //   93: getfield 74	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   96: invokevirtual 991	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   99: invokeinterface 994 1 0
    //   104: astore 4
    //   106: aload 4
    //   108: invokeinterface 358 1 0
    //   113: ifeq +119 -> 232
    //   116: aload 4
    //   118: invokeinterface 362 1 0
    //   123: checkcast 996	java/util/Map$Entry
    //   126: invokeinterface 999 1 0
    //   131: checkcast 368	com/tencent/mobileqq/data/TroopInfo
    //   134: astore 5
    //   136: aload 5
    //   138: getfield 1002	com/tencent/mobileqq/data/TroopInfo:timeSec	J
    //   141: lload_2
    //   142: lcmp
    //   143: ifge -37 -> 106
    //   146: aload 4
    //   148: invokeinterface 1004 1 0
    //   153: aload_0
    //   154: getfield 132	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   157: aload 5
    //   159: invokevirtual 809	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   162: pop
    //   163: aload_0
    //   164: getfield 119	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   167: invokevirtual 1007	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   170: astore 6
    //   172: aload 6
    //   174: invokevirtual 1012	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   177: aload 5
    //   179: getfield 376	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   182: iconst_1
    //   183: invokevirtual 1017	com/tencent/mobileqq/app/proxy/RecentUserProxy:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/data/RecentUser;
    //   186: astore 7
    //   188: aload 7
    //   190: ifnull +13 -> 203
    //   193: aload 6
    //   195: invokevirtual 1012	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lcom/tencent/mobileqq/app/proxy/RecentUserProxy;
    //   198: aload 7
    //   200: invokevirtual 1020	com/tencent/mobileqq/app/proxy/RecentUserProxy:b	(Lcom/tencent/mobileqq/data/RecentUser;)V
    //   203: invokestatic 822	com/tencent/mobileqq/managers/TroopAssistantManager:a	()Lcom/tencent/mobileqq/managers/TroopAssistantManager;
    //   206: aload 5
    //   208: getfield 376	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   211: aload_0
    //   212: getfield 119	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   215: invokevirtual 824	com/tencent/mobileqq/managers/TroopAssistantManager:b	(Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   218: goto -112 -> 106
    //   221: astore 4
    //   223: aload_1
    //   224: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   227: aload_0
    //   228: invokespecial 509	com/tencent/mobileqq/app/TroopManager:f	()V
    //   231: return
    //   232: aload_1
    //   233: invokevirtual 511	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   236: aload_1
    //   237: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   240: goto -13 -> 227
    //   243: astore 4
    //   245: aload_1
    //   246: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   249: aload 4
    //   251: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	TroopManager
    //   0	252	1	paramArrayList	ArrayList
    //   0	252	2	paramLong	long
    //   19	128	4	localObject1	Object
    //   221	1	4	localException	Exception
    //   243	7	4	localObject2	Object
    //   134	73	5	localTroopInfo	TroopInfo
    //   170	24	6	localProxyManager	ProxyManager
    //   186	13	7	localRecentUser	RecentUser
    //   29	42	8	k	int
    // Exception table:
    //   from	to	target	type
    //   88	106	221	java/lang/Exception
    //   106	188	221	java/lang/Exception
    //   193	203	221	java/lang/Exception
    //   203	218	221	java/lang/Exception
    //   232	236	221	java/lang/Exception
    //   88	106	243	finally
    //   106	188	243	finally
    //   193	203	243	finally
    //   203	218	243	finally
    //   232	236	243	finally
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)paramList.next();
      if ((localTroopInfo != null) && (!TextUtils.isEmpty(localTroopInfo.troopuin)) && (!"0".equals(localTroopInfo.troopuin)))
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localTroopInfo.troopuin, localTroopInfo);
        }
        if ((!a(localTroopInfo)) && (QLog.isColorLevel())) {
          QLog.d("Q.contacttab.troop", 2, "saveTroopInfo failed.");
        }
        ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        RecentUser localRecentUser = localProxyManager.a().a(localTroopInfo.troopuin, 1);
        localRecentUser.displayName = localTroopInfo.troopname;
        if (localRecentUser.getStatus() == 1001) {
          localProxyManager.a().a(localRecentUser);
        }
      }
    }
    f();
  }
  
  public void a(Map paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, false, null, null, null, null, null, String.valueOf("1"));
    } while ((localArrayList != null) && (localArrayList.size() > 0));
    return true;
  }
  
  public boolean a(Entity paramEntity)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {}
    do
    {
      do
      {
        return false;
        if (paramEntity.getStatus() != 1000) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      } while (paramEntity.getStatus() != 1001);
      return true;
    } while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002));
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  public boolean a(String paramString)
  {
    return a().get(paramString) != null;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    ConcurrentHashMap localConcurrentHashMap = a();
    CommonlyUsedTroop localCommonlyUsedTroop = (CommonlyUsedTroop)localConcurrentHashMap.get(paramString);
    if (localCommonlyUsedTroop == null)
    {
      localCommonlyUsedTroop = new CommonlyUsedTroop();
      localCommonlyUsedTroop.troopUin = paramString;
      localCommonlyUsedTroop.addedTimestamp = paramLong;
      localConcurrentHashMap.put(paramString, localCommonlyUsedTroop);
      a(localCommonlyUsedTroop);
      return true;
    }
    if (localCommonlyUsedTroop.addedTimestamp != paramLong)
    {
      localCommonlyUsedTroop.addedTimestamp = paramLong;
      a(localCommonlyUsedTroop);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + paramString1, 0).getBoolean(paramString2, false);
  }
  
  public boolean a(String paramString1, String paramString2, byte paramByte)
  {
    TroopMemberInfo localTroopMemberInfo = a(paramString1, paramString2);
    if (localTroopMemberInfo == null) {}
    label123:
    for (;;)
    {
      return false;
      if (paramByte != -100)
      {
        localTroopMemberInfo.isTroopFollowed = false;
        localTroopMemberInfo.mIsShielded = false;
        if (paramByte == 1) {
          localTroopMemberInfo.isTroopFollowed = true;
        }
      }
      for (paramByte = 1;; paramByte = 0)
      {
        if (paramByte == 0) {
          break label123;
        }
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          a(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.b(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.a();
          return true;
          if (paramByte != 2) {
            break;
          }
          localTroopMemberInfo.mIsShielded = true;
          break;
          localEntityManager.a(localTroopMemberInfo);
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    TroopMemberInfo localTroopMemberInfo = a(paramString1, paramString2);
    if (localTroopMemberInfo == null)
    {
      localTroopMemberInfo = new TroopMemberInfo();
      localTroopMemberInfo.troopuin = paramString1;
      localTroopMemberInfo.memberuin = paramString2;
      localTroopMemberInfo.isTroopFollowed = false;
    }
    for (int k = 1;; k = 0)
    {
      int m = k;
      if (paramInt > 0)
      {
        m = k;
        if (paramInt != localTroopMemberInfo.mGlamourLevel)
        {
          localTroopMemberInfo.mGlamourLevel = paramInt;
          m = 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troop.memberCard", 2, "saveTroopMemberEx ," + localTroopMemberInfo.toString());
      }
      if (m != 0)
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localTroopMemberInfo.getStatus() == 1000)
        {
          a(paramString1, paramString2, localTroopMemberInfo);
          localEntityManager.b(localTroopMemberInfo);
        }
        for (;;)
        {
          localEntityManager.a();
          b(paramString1, paramString2);
          return true;
          localEntityManager.a(localTroopMemberInfo);
        }
      }
      return false;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, byte paramByte, long paramLong2, double paramDouble)
  {
    TroopMemberInfo localTroopMemberInfo = a(paramString1, paramString2);
    int m = 0;
    paramString5 = localTroopMemberInfo;
    if (localTroopMemberInfo == null)
    {
      paramString5 = new TroopMemberInfo();
      paramString5.troopuin = paramString1;
      paramString5.memberuin = paramString2;
      paramString5.isTroopFollowed = false;
      m = 1;
    }
    int k = m;
    if (paramString3 != null)
    {
      k = m;
      if (!paramString3.equals(paramString5.troopnick))
      {
        paramString5.troopnick = paramString3;
        k = 1;
      }
    }
    m = k;
    if (paramString4 != null)
    {
      m = k;
      if (!paramString4.equals(paramString5.friendnick))
      {
        paramString5.friendnick = paramString4;
        m = 1;
      }
    }
    k = m;
    if (paramInt1 > 0)
    {
      k = m;
      if (paramInt1 != paramString5.level)
      {
        paramString5.level = paramInt1;
        k = 1;
      }
    }
    paramInt1 = k;
    if (paramLong2 != -100L)
    {
      paramInt1 = k;
      if (paramLong2 != paramString5.gagTimeStamp)
      {
        paramString5.gagTimeStamp = paramLong2;
        paramInt1 = 1;
      }
    }
    boolean bool;
    if (paramByte == 1)
    {
      bool = true;
      k = paramInt1;
      if (paramByte != -100)
      {
        k = paramInt1;
        if (paramString5.isTroopFollowed != bool)
        {
          paramString5.isTroopFollowed = bool;
          k = 1;
        }
      }
      paramInt1 = k;
      if (paramDouble != -100.0D)
      {
        paramInt1 = k;
        if (paramDouble != paramString5.distanceToSelf)
        {
          paramString5.distanceToSelf = paramDouble;
          paramString5.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
          paramInt1 = 1;
        }
      }
      if ((paramLong1 == -100L) || (paramLong1 >= paramString5.msgseq)) {
        break label402;
      }
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troop.memberCard", 2, "saveTroopMemberEx ," + paramString5.toString());
      }
      if (paramInt2 == 0) {
        break label528;
      }
      if (paramString5.getStatus() == 1000) {
        a(paramString1, paramString2, paramString5);
      }
      ThreadManager.a(new qhm(this, paramString5, new Handler(Looper.getMainLooper()), paramString1, paramString2), 8, null, false);
      return true;
      bool = false;
      break;
      label402:
      if (paramLong1 != -100L) {
        paramString5.msgseq = paramLong1;
      }
      paramByte = paramInt1;
      if (paramInt2 != -100)
      {
        paramByte = paramInt1;
        if (paramInt2 != paramString5.age)
        {
          paramString5.age = ((byte)paramInt2);
          paramByte = 1;
        }
      }
      paramInt1 = paramByte;
      if (paramInt3 != -100)
      {
        paramInt1 = paramByte;
        if (paramInt3 != paramString5.sex)
        {
          paramString5.sex = ((byte)paramInt3);
          paramInt1 = 1;
        }
      }
      paramInt2 = paramInt1;
      if (paramInt4 != -100)
      {
        paramInt2 = paramInt1;
        if (paramInt4 != paramString5.distance)
        {
          paramString5.distance = paramInt4;
          paramInt2 = 1;
        }
      }
    }
    label528:
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2)
  {
    return a(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramInt3, paramInt4, paramLong1, (byte)-100, paramLong2, -100.0D);
  }
  
  /* Error */
  public boolean a(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 1105 1 0
    //   10: ifeq +9 -> 19
    //   13: iconst_0
    //   14: istore 7
    //   16: iload 7
    //   18: ireturn
    //   19: new 1107	java/util/HashSet
    //   22: dup
    //   23: invokespecial 1108	java/util/HashSet:<init>	()V
    //   26: astore 4
    //   28: iconst_0
    //   29: istore 7
    //   31: iconst_0
    //   32: istore 8
    //   34: iconst_0
    //   35: istore 6
    //   37: aconst_null
    //   38: astore_2
    //   39: aload_0
    //   40: getfield 132	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   43: invokevirtual 481	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: iload 8
    //   51: istore 7
    //   53: aload_2
    //   54: invokevirtual 485	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   57: iload 8
    //   59: istore 7
    //   61: aload_1
    //   62: invokeinterface 735 1 0
    //   67: astore_1
    //   68: iload 6
    //   70: istore 7
    //   72: aload_1
    //   73: invokeinterface 358 1 0
    //   78: ifeq +153 -> 231
    //   81: iload 6
    //   83: istore 7
    //   85: aload_1
    //   86: invokeinterface 362 1 0
    //   91: checkcast 470	com/tencent/mobileqq/data/TroopMemberInfo
    //   94: astore_3
    //   95: iload 6
    //   97: istore 7
    //   99: new 148	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   106: aload_3
    //   107: getfield 934	com/tencent/mobileqq/data/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   110: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 609
    //   116: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_3
    //   120: getfield 594	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   123: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore 5
    //   131: iload 6
    //   133: istore 7
    //   135: aload_3
    //   136: getfield 594	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   139: ldc_w 1110
    //   142: invokevirtual 569	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   145: ifne -77 -> 68
    //   148: iload 6
    //   150: istore 7
    //   152: aload 4
    //   154: aload 5
    //   156: invokevirtual 1113	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   159: ifne +182 -> 341
    //   162: iload 6
    //   164: istore 7
    //   166: aload_0
    //   167: aload_3
    //   168: getfield 934	com/tencent/mobileqq/data/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   171: aload_3
    //   172: getfield 594	com/tencent/mobileqq/data/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   175: aload_3
    //   176: getfield 708	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   179: aload_3
    //   180: getfield 591	com/tencent/mobileqq/data/TroopMemberInfo:level	I
    //   183: aload_3
    //   184: getfield 717	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   187: aconst_null
    //   188: aload_3
    //   189: getfield 1094	com/tencent/mobileqq/data/TroopMemberInfo:age	B
    //   192: aload_3
    //   193: getfield 1097	com/tencent/mobileqq/data/TroopMemberInfo:sex	B
    //   196: aload_3
    //   197: getfield 1100	com/tencent/mobileqq/data/TroopMemberInfo:distance	I
    //   200: aload_3
    //   201: getfield 1074	com/tencent/mobileqq/data/TroopMemberInfo:msgseq	J
    //   204: aload_3
    //   205: getfield 641	com/tencent/mobileqq/data/TroopMemberInfo:gagTimeStamp	J
    //   208: invokevirtual 1115	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   211: istore 8
    //   213: iload 8
    //   215: iload 6
    //   217: ior
    //   218: istore 6
    //   220: aload 4
    //   222: aload 5
    //   224: invokevirtual 1116	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   227: pop
    //   228: goto -160 -> 68
    //   231: iload 6
    //   233: istore 7
    //   235: aload_2
    //   236: invokevirtual 511	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   239: iload 6
    //   241: istore 7
    //   243: aload_2
    //   244: ifnull -228 -> 16
    //   247: aload_2
    //   248: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   251: iload 6
    //   253: ireturn
    //   254: astore_3
    //   255: iload 7
    //   257: istore 6
    //   259: aload_2
    //   260: astore_1
    //   261: aload_3
    //   262: astore_2
    //   263: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +13 -> 279
    //   269: ldc 17
    //   271: iconst_2
    //   272: aload_2
    //   273: invokestatic 1120	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   276: invokestatic 694	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: iload 6
    //   281: istore 7
    //   283: aload_1
    //   284: ifnull -268 -> 16
    //   287: aload_1
    //   288: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   291: iload 6
    //   293: ireturn
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_2
    //   297: aload_2
    //   298: ifnull +7 -> 305
    //   301: aload_2
    //   302: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   305: aload_1
    //   306: athrow
    //   307: astore_1
    //   308: goto -11 -> 297
    //   311: astore_3
    //   312: aload_1
    //   313: astore_2
    //   314: aload_3
    //   315: astore_1
    //   316: goto -19 -> 297
    //   319: astore_3
    //   320: aload_2
    //   321: astore_1
    //   322: aload_3
    //   323: astore_2
    //   324: iload 7
    //   326: istore 6
    //   328: goto -65 -> 263
    //   331: astore_1
    //   332: aload_2
    //   333: astore_3
    //   334: aload_1
    //   335: astore_2
    //   336: aload_3
    //   337: astore_1
    //   338: goto -75 -> 263
    //   341: goto -113 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	TroopManager
    //   0	344	1	paramList	List
    //   38	298	2	localObject1	Object
    //   46	159	3	localObject2	Object
    //   254	8	3	localThrowable1	Throwable
    //   311	4	3	localObject3	Object
    //   319	4	3	localThrowable2	Throwable
    //   333	4	3	localObject4	Object
    //   26	195	4	localHashSet	java.util.HashSet
    //   129	94	5	str	String
    //   35	292	6	bool1	boolean
    //   14	311	7	bool2	boolean
    //   32	186	8	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   39	47	254	java/lang/Throwable
    //   39	47	294	finally
    //   53	57	307	finally
    //   61	68	307	finally
    //   72	81	307	finally
    //   85	95	307	finally
    //   99	131	307	finally
    //   135	148	307	finally
    //   152	162	307	finally
    //   166	213	307	finally
    //   220	228	307	finally
    //   235	239	307	finally
    //   263	279	311	finally
    //   53	57	319	java/lang/Throwable
    //   61	68	319	java/lang/Throwable
    //   72	81	319	java/lang/Throwable
    //   85	95	319	java/lang/Throwable
    //   99	131	319	java/lang/Throwable
    //   135	148	319	java/lang/Throwable
    //   152	162	319	java/lang/Throwable
    //   166	213	319	java/lang/Throwable
    //   235	239	319	java/lang/Throwable
    //   220	228	331	java/lang/Throwable
  }
  
  public byte[] a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_" + paramString, 0).getString("troop_app_list_data", null);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = Base64Util.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public int b()
  {
    try
    {
      int k = this.jdField_b_of_type_JavaUtilHashMap.size();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, "hasGroupInviting  : " + k);
      }
      return k;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public TroopInfo b(String paramString)
  {
    Object localObject2;
    if ((paramString == null) || ("".equals(paramString))) {
      localObject2 = new TroopInfo();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, StringUtil.a(new Object[] { "getTroopInfo()", paramString, Long.valueOf(((TroopInfo)localObject2).dwGroupFlagExt) }));
      }
      return (TroopInfo)localObject2;
      localObject2 = a(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopname = TroopSystemMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
        ((TroopInfo)localObject1).dwGroupFlagExt = TroopSystemMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString);
      }
      localObject2 = localObject1;
      if (!g(((TroopInfo)localObject1).troopname))
      {
        ((TroopInfo)localObject1).troopname = paramString;
        localObject2 = localObject1;
      }
    }
  }
  
  public String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return (String)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (TroopInfo)((Map.Entry)localIterator.next()).getValue();
        if ((localObject != null) && (((TroopInfo)localObject).troopcode != null) && (((TroopInfo)localObject).troopcode.equals(paramString)))
        {
          localObject = ((TroopInfo)localObject).troopuin;
          if ((localObject != null) && (((String)localObject).length() > 0))
          {
            this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
            return (String)localObject;
          }
        }
      }
    }
    return null;
  }
  
  public String b(String paramString1, String paramString2)
  {
    return ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
  
  public ArrayList b()
  {
    Iterator localIterator = null;
    Object localObject = localIterator;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      int k = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      localObject = localIterator;
      if (k > 0)
      {
        localObject = new ArrayList();
        localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
          if ((localTroopInfo != null) && (localTroopInfo.dwOfficeMode == 1L) && (TroopUtils.a(Long.toString(localTroopInfo.dwGroupClassExt))))
          {
            if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0)) {
              ContactSorter.a(localTroopInfo);
            }
            ((ArrayList)localObject).add(localTroopInfo);
          }
        }
        if (k > 1) {
          Collections.sort((List)localObject, ContactSorter.a);
        }
      }
    }
    return (ArrayList)localObject;
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b().values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((ShowExternalTroop)localIterator.next());
    }
    return localArrayList;
  }
  
  public List b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopMemberInfo.class, false, "troopuin=?", new String[] { paramString }, null, null, null, null);
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokespecial 743	com/tencent/mobileqq/app/TroopManager:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 132	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 481	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +134 -> 152
    //   21: aload_1
    //   22: invokevirtual 485	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   25: aload_0
    //   26: getfield 132	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: ldc -59
    //   31: invokevirtual 1173	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 1174	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   39: aload_0
    //   40: getfield 1033	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   43: ifnull +105 -> 148
    //   46: aload_0
    //   47: getfield 1033	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   50: invokeinterface 1177 1 0
    //   55: invokeinterface 994 1 0
    //   60: astore_2
    //   61: aload_2
    //   62: invokeinterface 358 1 0
    //   67: ifeq +81 -> 148
    //   70: aload_2
    //   71: invokeinterface 362 1 0
    //   76: checkcast 448	java/lang/String
    //   79: astore 4
    //   81: new 197	com/tencent/mobileqq/data/CommonlyUsedTroop
    //   84: dup
    //   85: invokespecial 1043	com/tencent/mobileqq/data/CommonlyUsedTroop:<init>	()V
    //   88: astore 5
    //   90: aload 5
    //   92: aload 4
    //   94: putfield 224	com/tencent/mobileqq/data/CommonlyUsedTroop:troopUin	Ljava/lang/String;
    //   97: aload 5
    //   99: aload_0
    //   100: getfield 1033	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   103: aload 4
    //   105: invokeinterface 635 2 0
    //   110: checkcast 269	java/lang/Long
    //   113: invokevirtual 412	java/lang/Long:longValue	()J
    //   116: putfield 1046	com/tencent/mobileqq/data/CommonlyUsedTroop:addedTimestamp	J
    //   119: aload_3
    //   120: aload 4
    //   122: aload 5
    //   124: invokevirtual 231	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_0
    //   129: aload 5
    //   131: invokevirtual 502	com/tencent/mobileqq/app/TroopManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   134: pop
    //   135: goto -74 -> 61
    //   138: astore_2
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   147: return
    //   148: aload_1
    //   149: invokevirtual 511	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   152: aload_1
    //   153: ifnull -6 -> 147
    //   156: aload_1
    //   157: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   160: return
    //   161: astore_1
    //   162: aconst_null
    //   163: astore_3
    //   164: aload_1
    //   165: astore_2
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   174: aload_2
    //   175: athrow
    //   176: astore_2
    //   177: aload_1
    //   178: astore_3
    //   179: goto -13 -> 166
    //   182: astore_2
    //   183: goto -44 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	TroopManager
    //   1	156	1	localObject1	Object
    //   161	17	1	localObject2	Object
    //   14	57	2	localObject3	Object
    //   138	1	2	localThrowable1	Throwable
    //   165	10	2	localObject4	Object
    //   176	1	2	localObject5	Object
    //   182	1	2	localThrowable2	Throwable
    //   6	173	3	localObject6	Object
    //   79	42	4	str	String
    //   88	42	5	localCommonlyUsedTroop	CommonlyUsedTroop
    // Exception table:
    //   from	to	target	type
    //   21	61	138	java/lang/Throwable
    //   61	135	138	java/lang/Throwable
    //   148	152	138	java/lang/Throwable
    //   7	15	161	finally
    //   21	61	176	finally
    //   61	135	176	finally
    //   148	152	176	finally
    //   7	15	182	java/lang/Throwable
  }
  
  public void b(TroopManager.TroopMemberUpdateObserver paramTroopMemberUpdateObserver)
  {
    try
    {
      this.jdField_d_of_type_JavaUtilArrayList.remove(paramTroopMemberUpdateObserver);
      return;
    }
    finally
    {
      paramTroopMemberUpdateObserver = finally;
      throw paramTroopMemberUpdateObserver;
    }
  }
  
  public void b(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramTroopInfo.troopuin)) || ("0".equals(paramTroopInfo.troopuin))) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    ContactSorter.a(paramTroopInfo);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramTroopInfo.troopuin, paramTroopInfo);
    }
    if ((!a(paramTroopInfo)) && (QLog.isColorLevel())) {
      QLog.d("Q.contacttab.troop", 2, "saveTroopInfo failed.");
    }
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    RecentUser localRecentUser = localProxyManager.a().a(paramTroopInfo.troopuin, 1);
    localRecentUser.displayName = paramTroopInfo.troopname;
    if (localRecentUser.getStatus() == 1001) {
      localProxyManager.a().a(localRecentUser);
    }
    f();
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = (LruCache)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    } while (paramString == null);
    paramString.evictAll();
  }
  
  public void b(String paramString1, String paramString2)
  {
    int k = 0;
    while (k < this.jdField_d_of_type_JavaUtilArrayList.size())
    {
      ((TroopManager.TroopMemberUpdateObserver)this.jdField_d_of_type_JavaUtilArrayList.get(k)).a(paramString1, paramString2);
      k += 1;
    }
  }
  
  public void b(ArrayList paramArrayList)
  {
    int k = 0;
    while (k < this.jdField_d_of_type_JavaUtilArrayList.size())
    {
      ((TroopManager.TroopMemberUpdateObserver)this.jdField_d_of_type_JavaUtilArrayList.get(k)).a(paramArrayList);
      k += 1;
    }
  }
  
  void b(ArrayList paramArrayList, long paramLong)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    c(paramArrayList);
    f();
  }
  
  public void b(Map paramMap)
  {
    this.jdField_b_of_type_JavaUtilMap = paramMap;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(String paramString)
  {
    paramString = (CommonlyUsedTroop)a().remove(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString, long paramLong)
  {
    ConcurrentHashMap localConcurrentHashMap = b();
    ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localConcurrentHashMap.get(paramString);
    if (localShowExternalTroop == null)
    {
      localShowExternalTroop = ShowExternalTroop.createShowExternalTroop(paramString, ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString), paramLong);
      localConcurrentHashMap.put(paramString, localShowExternalTroop);
      a(localShowExternalTroop);
      return true;
    }
    if (localShowExternalTroop.addedTimestamp != paramLong)
    {
      localShowExternalTroop.addedTimestamp = paramLong;
      a(localShowExternalTroop);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if ((localEntityManager == null) || (localTroopManager == null)) {
      return false;
    }
    TroopInfo localTroopInfo = localTroopManager.a(paramString1);
    if (localTroopInfo == null) {
      return false;
    }
    TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localEntityManager.a(TroopMemberInfo.class, "troopuin=? and memberuin=?", new String[] { paramString1, paramString2 });
    if (localTroopMemberInfo != null)
    {
      localEntityManager.b(localTroopMemberInfo);
      if (localTroopInfo.wMemberNum > 0) {
        localTroopInfo.wMemberNum -= 1;
      }
      if ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(paramString2))) {
        localTroopInfo.Administrator.replace(paramString2, "");
      }
    }
    localTroopManager.b(localTroopInfo);
    localEntityManager.a();
    e(paramString1, paramString2);
    a(paramString1, paramString2);
    return true;
  }
  
  public String c(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, "troopcode=?", new String[] { paramString });
      if (localTroopInfo == null) {
        return null;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localTroopInfo.troopcode, localTroopInfo.troopuin);
    }
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public String c(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.troop", 2, "getTroopMemberNick uin is null");
      }
      paramString2 = "";
    }
    do
    {
      return paramString2;
      paramString1 = a(paramString1, paramString2);
      if (paramString1 == null) {
        break;
      }
      if (!TextUtils.isEmpty(paramString1.troopnick)) {
        return paramString1.troopnick;
      }
    } while (TextUtils.isEmpty(paramString1.friendnick));
    return paramString1.friendnick;
    return "";
  }
  
  public ArrayList c()
  {
    Iterator localIterator = null;
    Object localObject = localIterator;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      int k = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      localObject = localIterator;
      if (k > 0)
      {
        localObject = new ArrayList();
        localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (localIterator.hasNext())
        {
          TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
          if ((localTroopInfo != null) && (localTroopInfo.dwOfficeMode == 0L) && (TroopUtils.a(Long.toString(localTroopInfo.dwGroupClassExt))) && (((localTroopInfo.dwAdditionalFlag & 1L) == 1L) || ((localTroopInfo.dwCmdUinUinFlag & 1L) == 1L)))
          {
            if ((localTroopInfo.mCompareSpell == null) || (localTroopInfo.mCompareSpell.length() == 0)) {
              ContactSorter.a(localTroopInfo);
            }
            ((ArrayList)localObject).add(localTroopInfo);
          }
        }
        if (k > 1) {
          Collections.sort((List)localObject, ContactSorter.a);
        }
      }
    }
    return (ArrayList)localObject;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokespecial 1168	com/tencent/mobileqq/app/TroopManager:b	()Ljava/util/concurrent/ConcurrentHashMap;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 132	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 481	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +130 -> 148
    //   21: aload_1
    //   22: invokevirtual 485	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   25: aload_0
    //   26: getfield 132	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: ldc_w 474
    //   32: invokevirtual 1173	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Z
    //   35: pop
    //   36: aload_3
    //   37: invokevirtual 1174	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   40: aload_0
    //   41: getfield 1188	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   44: ifnull +100 -> 144
    //   47: aload_0
    //   48: getfield 1188	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   51: invokeinterface 1177 1 0
    //   56: invokeinterface 994 1 0
    //   61: astore_2
    //   62: aload_2
    //   63: invokeinterface 358 1 0
    //   68: ifeq +76 -> 144
    //   71: aload_2
    //   72: invokeinterface 362 1 0
    //   77: checkcast 448	java/lang/String
    //   80: astore 4
    //   82: aload 4
    //   84: aload_0
    //   85: getfield 119	com/tencent/mobileqq/app/TroopManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   88: aload 4
    //   90: invokestatic 1191	com/tencent/mobileqq/utils/ContactUtils:h	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   93: aload_0
    //   94: getfield 1188	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   97: aload 4
    //   99: invokeinterface 635 2 0
    //   104: checkcast 269	java/lang/Long
    //   107: invokevirtual 412	java/lang/Long:longValue	()J
    //   110: invokestatic 1195	com/tencent/mobileqq/data/ShowExternalTroop:createShowExternalTroop	(Ljava/lang/String;Ljava/lang/String;J)Lcom/tencent/mobileqq/data/ShowExternalTroop;
    //   113: astore 5
    //   115: aload_3
    //   116: aload 4
    //   118: aload 5
    //   120: invokevirtual 231	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: pop
    //   124: aload_0
    //   125: aload 5
    //   127: invokevirtual 502	com/tencent/mobileqq/app/TroopManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   130: pop
    //   131: goto -69 -> 62
    //   134: astore_2
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   143: return
    //   144: aload_1
    //   145: invokevirtual 511	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   148: aload_1
    //   149: ifnull -6 -> 143
    //   152: aload_1
    //   153: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   156: return
    //   157: astore_1
    //   158: aconst_null
    //   159: astore_3
    //   160: aload_1
    //   161: astore_2
    //   162: aload_3
    //   163: ifnull +7 -> 170
    //   166: aload_3
    //   167: invokevirtual 507	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   170: aload_2
    //   171: athrow
    //   172: astore_2
    //   173: aload_1
    //   174: astore_3
    //   175: goto -13 -> 162
    //   178: astore_2
    //   179: goto -44 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	TroopManager
    //   1	152	1	localObject1	Object
    //   157	17	1	localObject2	Object
    //   14	58	2	localObject3	Object
    //   134	1	2	localThrowable1	Throwable
    //   161	10	2	localObject4	Object
    //   172	1	2	localObject5	Object
    //   178	1	2	localThrowable2	Throwable
    //   6	169	3	localObject6	Object
    //   80	37	4	str	String
    //   113	13	5	localShowExternalTroop	ShowExternalTroop
    // Exception table:
    //   from	to	target	type
    //   21	62	134	java/lang/Throwable
    //   62	131	134	java/lang/Throwable
    //   144	148	134	java/lang/Throwable
    //   7	15	157	finally
    //   21	62	172	finally
    //   62	131	172	finally
    //   144	148	172	finally
    //   7	15	178	java/lang/Throwable
  }
  
  void c(TroopInfo paramTroopInfo)
  {
    b(paramTroopInfo);
    f();
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b("update TroopNotificationCache set read=1 where troopUin=" + paramString);
  }
  
  public void c(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString1 + paramString2, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, new Object[] { "addGroupInviteStatus groupUin : " + paramString1, ", inviterUin:" + paramString2 });
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean c(String paramString)
  {
    return b().get(paramString) != null;
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1 + paramString2);
      if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, new Object[] { "isTheSameInviterInviting re:" + bool + ", troopUin : " + paramString1, ", inviterUin:" + paramString2 });
      }
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public String d(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsValue(paramString))
    {
      localObject3 = (TroopInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopInfo.class, "troopuin=?", new String[] { paramString });
      if (localObject3 != null) {}
    }
    do
    {
      do
      {
        return (String)localObject2;
        this.jdField_a_of_type_JavaUtilHashMap.put(((TroopInfo)localObject3).troopcode, ((TroopInfo)localObject3).troopuin);
        localObject3 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        localObject2 = localObject1;
      } while (localObject3 == null);
      localObject2 = localObject1;
    } while (!((Iterator)localObject3).hasNext());
    localObject2 = (String)((Iterator)localObject3).next();
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
    if ((str != null) && (str.equals(paramString))) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      break;
    }
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_JavaUtilArrayList != null) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), last getTroopsMemberList(int memberLimit) is not finished.");
      }
    }
    Object localObject2;
    do
    {
      return;
      localObject2 = a();
      if (localObject2 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("Q.contacttab.troop", 2, "getTroopsMemberList(memberLimit), troopList is null");
    return;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    int n;
    int k;
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      n = 0;
      k = 0;
    }
    int i2;
    for (int m = 0;; m = i2)
    {
      int i1;
      if (n < ((ArrayList)localObject2).size())
      {
        TroopInfo localTroopInfo = (TroopInfo)((ArrayList)localObject2).get(n);
        i1 = k;
        i2 = m;
        if (a(localTroopInfo, false)) {
          try
          {
            this.jdField_c_of_type_JavaUtilArrayList.add(localTroopInfo);
            i2 = m + 1;
            i1 = k + localTroopInfo.wMemberNum;
          }
          finally {}
        }
      }
      else
      {
        if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
        {
          localObject2 = (TroopInfo)this.jdField_c_of_type_JavaUtilArrayList.get(0);
          ((TroopHandler)localObject1).a(true, ((TroopInfo)localObject2).troopuin, ((TroopInfo)localObject2).troopcode, 4);
        }
        while (m > 0)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("reqUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
          localHashMap.put("tpNum", String.valueOf(m));
          localHashMap.put("tpMemNum", String.valueOf(k));
          localHashMap.put("isFirst", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("is_first_upgrade_to_500", 0)));
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "tMSearchUpdateReq", false, 0L, 0L, localHashMap, "");
          return;
          this.jdField_c_of_type_JavaUtilArrayList = null;
          continue;
          this.jdField_c_of_type_JavaUtilArrayList = null;
          k = 0;
          m = 0;
        }
        break;
      }
      n += 1;
      k = i1;
    }
  }
  
  public void d(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {}
    ProxyManager localProxyManager;
    RecentUser localRecentUser;
    do
    {
      return;
      localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localRecentUser = localProxyManager.a().a(paramTroopInfo.troopuin, 1);
      localRecentUser.displayName = paramTroopInfo.troopname;
    } while (localRecentUser.getStatus() != 1000);
    localRecentUser.lastmsgtime = NetConnInfoCenter.getServerTime();
    HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentUser);
    localProxyManager.a().a(localRecentUser);
    ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0)).a(6003, true, new String[] { paramTroopInfo.troopuin });
  }
  
  public void d(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_JavaUtilHashMap.remove(paramString1 + paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab..troopgroup_vedio.invite", 2, "removeGroupInviteStatus groupUin : " + paramString1);
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean d(String paramString)
  {
    paramString = (ShowExternalTroop)b().remove(paramString);
    if (paramString != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramString);
      return true;
    }
    return false;
  }
  
  public void e(String paramString)
  {
    int k = 0;
    while (k < this.jdField_d_of_type_JavaUtilArrayList.size())
    {
      ((TroopManager.TroopMemberUpdateObserver)this.jdField_d_of_type_JavaUtilArrayList.get(k)).b(paramString);
      k += 1;
    }
  }
  
  public boolean e(String paramString)
  {
    try
    {
      boolean bool = TextUtils.equals(paramString, this.e);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void f(String paramString)
  {
    int k = 0;
    while (k < this.jdField_d_of_type_JavaUtilArrayList.size())
    {
      ((TroopManager.TroopMemberUpdateObserver)this.jdField_d_of_type_JavaUtilArrayList.get(k)).a(paramString);
      k += 1;
    }
  }
  
  /* Error */
  public boolean f(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +22 -> 28
    //   9: aload_0
    //   10: getfield 115	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual 1301	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +9 -> 28
    //   22: iconst_1
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -6 -> 24
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	TroopManager
    //   0	38	1	paramString	String
    //   17	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	33	finally
  }
  
  public void g(String paramString)
  {
    this.jdField_c_of_type_JavaUtilMap.clear();
    int k;
    Object localObject1;
    Object localObject2;
    TroopManager.DownloadFileConfig localDownloadFileConfig;
    label172:
    int m;
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.length() == 0) {
          return;
        }
        JSONArray localJSONArray = paramString.names();
        k = 0;
        if (k >= localJSONArray.length()) {
          break label233;
        }
        localObject1 = localJSONArray.getString(k).trim().toLowerCase();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label234;
        }
        localObject2 = paramString.optJSONObject((String)localObject1);
        localDownloadFileConfig = new TroopManager.DownloadFileConfig();
        localDownloadFileConfig.c = ((JSONObject)localObject2).getInt("CellNetAutoDownloadSize");
        localDownloadFileConfig.b = ((JSONObject)localObject2).getInt("CellNetWarningSize");
        localDownloadFileConfig.jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("WiFiNetAutoDownloadSize");
        if (((String)localObject1).contains(",")) {
          break label172;
        }
        this.jdField_c_of_type_JavaUtilMap.put(localObject1, localDownloadFileConfig);
      }
      catch (JSONException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label233;
        }
      }
      QLog.d("Q.contacttab.", 2, QLog.getStackTraceString(paramString));
      return;
      localObject1 = ((String)localObject1).split(",");
      m = 0;
    }
    for (;;)
    {
      if (m < localObject1.length)
      {
        localObject2 = localObject1[m].trim().toLowerCase();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_c_of_type_JavaUtilMap.put(localObject2, localDownloadFileConfig);
        }
      }
      else
      {
        label233:
        label234:
        k += 1;
        break;
      }
      m += 1;
    }
  }
  
  /* Error */
  public void h(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +19 -> 25
    //   9: aload_0
    //   10: getfield 115	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   13: aload_1
    //   14: invokevirtual 1301	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 115	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   29: aload_1
    //   30: invokevirtual 525	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   33: pop
    //   34: goto -12 -> 22
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	TroopManager
    //   0	42	1	paramString	String
    //   17	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	37	finally
    //   25	34	37	finally
  }
  
  /* Error */
  public void i(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 309	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 115	com/tencent/mobileqq/app/TroopManager:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: aload_1
    //   19: invokevirtual 1179	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   22: pop
    //   23: goto -12 -> 11
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	TroopManager
    //   0	31	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\TroopManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */