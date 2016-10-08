package com.tencent.biz.pubaccount.troopbarassit;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptionFeed;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import ieq;
import ier;
import ies;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopBarAssistantManager
{
  public static final String a;
  protected static final boolean a = true;
  protected static final String b = "subscribe_setTop_flag";
  protected static final String c = "first_login";
  protected static final String d = "first_enter_subscribe";
  protected static final String e = "first_enter_subscribe_no_reset";
  public static final String f = "init_troopbar_assist";
  public static final String g = "troopbar_assist_deleted";
  public static final String h = "troopbar_assist_show_in_msg";
  public static final String i = "troopbar_assist_last_read_time";
  public static final String j = "troopbar_assist_new_unread_list";
  protected static final String k = "is_update_troopbar_assist";
  protected static final String l = "troopbar_recent_item_last_del_time";
  protected int a;
  protected long a;
  protected Boolean a;
  public Object a;
  Comparator a;
  public List a;
  protected final Map a;
  public ConcurrentHashMap a;
  public int b;
  protected long b;
  protected final ConcurrentHashMap b;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  protected String m;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopBarAssistantManager.class.getSimpleName();
  }
  
  private TroopBarAssistantManager()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilComparator = new ieq(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static TroopBarAssistantManager a()
  {
    try
    {
      if (TroopBarAssistantManager.SingletonHolder.a == null) {
        TroopBarAssistantManager.SingletonHolder.a = new TroopBarAssistantManager();
      }
      TroopBarAssistantManager localTroopBarAssistantManager = TroopBarAssistantManager.SingletonHolder.a;
      return localTroopBarAssistantManager;
    }
    finally {}
  }
  
  private TroopBarData a(QQAppInterface arg1, String paramString)
  {
    a(???);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  private TroopBarData a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface, String paramString)
  {
    a(paramQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      TroopBarData localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      paramEntityManager = localTroopBarData;
      if (localTroopBarData == null)
      {
        localTroopBarData = new TroopBarData();
        localTroopBarData.mUin = paramString;
        paramQQAppInterface = paramQQAppInterface.a();
        paramEntityManager = localTroopBarData;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramString, 1008);
          paramEntityManager = localTroopBarData;
          if (paramQQAppInterface != null)
          {
            localTroopBarData.mLastDraftTime = paramQQAppInterface.getTime();
            paramEntityManager = localTroopBarData;
          }
        }
      }
      return paramEntityManager;
    }
  }
  
  private List a(QQAppInterface paramQQAppInterface, List paramList)
  {
    if (paramList == null) {
      return null;
    }
    paramList = paramList.iterator();
    ArrayList localArrayList = new ArrayList();
    while (paramList.hasNext())
    {
      TroopBarData localTroopBarData = (TroopBarData)paramList.next();
      if (ServiceAccountFolderManager.c(paramQQAppInterface, localTroopBarData.mUin)) {
        localArrayList.add(localTroopBarData);
      }
    }
    return localArrayList;
  }
  
  private void a(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager, TroopBarData paramTroopBarData)
  {
    if (paramTroopBarData == null) {
      return;
    }
    paramEntityManager = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramTroopBarData.mUin);
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramTroopBarData.mUin, paramTroopBarData);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        if (paramEntityManager != null) {
          this.jdField_a_of_type_JavaUtilList.remove(paramEntityManager);
        }
        this.jdField_a_of_type_JavaUtilList.remove(paramTroopBarData);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), paramTroopBarData);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "save TroopBarData " + paramTroopBarData.mUin + " to dataList");
        }
      }
      a();
      paramEntityManager = (ProxyManager)paramQQAppInterface.getManager(17);
      if (paramTroopBarData.getStatus() == 1000)
      {
        paramEntityManager.a(paramQQAppInterface.getAccount(), 0, paramTroopBarData.getTableName(), paramTroopBarData, 3, null);
        return;
        paramQQAppInterface = finally;
        throw paramQQAppInterface;
      }
    }
    paramEntityManager.a(paramQQAppInterface.getAccount(), 0, paramTroopBarData.getTableName(), paramTroopBarData, 4, null);
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!ServiceAccountFolderManager.c(paramQQAppInterface, paramString)) {
      return;
    }
    o(paramQQAppInterface);
    if ((paramMessageRecord != null) && (!paramMessageRecord.isread))
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        break label109;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue() + 1));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "add uin " + paramString + " to newMsgMap");
      }
      n(paramQQAppInterface);
      return;
      label109:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(1));
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int i1 = 0;
    Object localObject = (TroopManager)paramQQAppInterface.getManager(51);
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    if (localObject == null) {
      return false;
    }
    int n = i1;
    if (this.jdField_b_of_type_Boolean)
    {
      n = i1;
      if (!this.d) {
        n = 1;
      }
    }
    if (n != 0)
    {
      localObject = localRecentUserProxy.a(AppConstants.aI, 7210);
      if (((RecentUser)localObject).lastmsgtime < paramLong) {
        ((RecentUser)localObject).lastmsgtime = paramLong;
      }
      if (d(paramQQAppInterface)) {
        localRecentUserProxy.a((RecentUser)localObject);
      }
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a(Conversation.class);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendEmptyMessage(1009);
      }
      return true;
      TroopBarData localTroopBarData = a(paramQQAppInterface);
      if (localTroopBarData == null) {
        break;
      }
      ((RecentUser)localObject).lastmsgtime = localTroopBarData.mLastMsgTime;
      ((RecentUser)localObject).lastmsgdrafttime = localTroopBarData.mLastDraftTime;
      break;
      localObject = localRecentUserProxy.b(AppConstants.aI, 7210);
      if (localObject != null) {
        localRecentUserProxy.b((RecentUser)localObject);
      }
    }
  }
  
  private boolean a(EntityManager paramEntityManager, String paramString)
  {
    TroopBarData localTroopBarData;
    Object localObject2;
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      localObject2 = this.jdField_a_of_type_JavaLangObject;
      ??? = localTroopBarData;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          ??? = localTroopBarData;
          if (localTroopBarData == null)
          {
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            ??? = localTroopBarData;
            if (localIterator.hasNext())
            {
              ??? = (TroopBarData)localIterator.next();
              if (!TextUtils.equals(((TroopBarData)???).mUin, paramString)) {
                continue;
              }
            }
          }
          this.jdField_a_of_type_JavaUtilList.remove(???);
        }
        if (??? == null) {
          break;
        }
        if (paramEntityManager.b((Entity)???)) {
          break label178;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "remove TroopBarData " + ((TroopBarData)???).mUin + " from em fail");
        }
        return true;
      }
      finally {}
      paramEntityManager = finally;
      throw paramEntityManager;
      label178:
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "remove TroopBarData " + ((TroopBarData)???).mUin + " from em success");
      }
    }
    return false;
  }
  
  private long b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 0L;
    }
    if (!this.c)
    {
      this.jdField_b_of_type_Long = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getLong("troopbar_recent_item_last_del_time", 0L);
      this.c = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getTroopBarRecentItemLastDelTime, lastDelTime:" + this.jdField_b_of_type_Long);
    }
    return this.jdField_b_of_type_Long;
  }
  
  public static void b()
  {
    TroopBarAssistantManager.SingletonHolder.a = null;
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    paramString = paramQQAppInterface.b(paramString, 1008);
    if (paramString != null) {
      paramQQAppInterface.b(paramString);
    }
  }
  
  private void b(EntityManager arg1, QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      Object localObject;
      int n;
      try
      {
        localObject = ???.a(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          Collections.sort((List)localObject, this.jdField_a_of_type_JavaUtilComparator);
        }
        long l1;
        localObject = ((TroopBarData)this.jdField_a_of_type_JavaUtilList.get(n)).mUin;
      }
      catch (Exception ???)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilList = ((List)localObject);
          if (this.jdField_a_of_type_JavaUtilList == null)
          {
            this.jdField_a_of_type_JavaUtilList = new ArrayList(15);
            synchronized (this.jdField_a_of_type_JavaUtilMap)
            {
              this.jdField_a_of_type_JavaUtilMap.clear();
              paramQQAppInterface = this.jdField_a_of_type_JavaUtilList.iterator();
              if (!paramQQAppInterface.hasNext()) {
                break label363;
              }
              localObject = (TroopBarData)paramQQAppInterface.next();
              this.jdField_a_of_type_JavaUtilMap.put(((TroopBarData)localObject).mUin, localObject);
            }
            ??? = ???;
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "initTroopBarAssistRecent doInit error: ", ???);
            }
            return;
          }
          l1 = b(paramQQAppInterface);
          n = 0;
          if (n >= this.jdField_a_of_type_JavaUtilList.size()) {
            continue;
          }
          localObject = (TroopBarData)this.jdField_a_of_type_JavaUtilList.get(n);
          if (localObject == null)
          {
            if (QLog.isColorLevel()) {
              QLog.w(jdField_a_of_type_JavaLangString, 2, "doInit==> pad == null");
            }
            this.jdField_a_of_type_JavaUtilList.remove(n);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "doInit==> uin:" + ((TroopBarData)localObject).mUin + ", lastMsgTime:" + ((TroopBarData)localObject).mLastMsgTime);
            }
            if (((TroopBarData)localObject).mLastMsgTime < l1) {
              this.jdField_a_of_type_JavaUtilList.remove(n);
            }
          }
        }
      }
      finally {}
      ((TroopBarData)this.jdField_a_of_type_JavaUtilList.get(n)).mLatestMessage = paramQQAppInterface.a().a((String)localObject, 1008);
      break label366;
      label363:
      return;
      label366:
      n += 1;
    }
  }
  
  private void f(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramQQAppInterface.a() == null)) {
      return;
    }
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("is_update_troopbar_assist", paramBoolean).commit();
  }
  
  private void g(String paramString, QQAppInterface paramQQAppInterface)
  {
    a(paramString, paramQQAppInterface, false);
  }
  
  private boolean g(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("is_update_troopbar_assist", true);
  }
  
  private void h(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!ServiceAccountFolderManager.c(paramQQAppInterface, paramString)) {
      return;
    }
    o(paramQQAppInterface);
    if (paramQQAppInterface.a().a(paramString, 1008) > 0)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        break label73;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue() + 1));
    }
    for (;;)
    {
      n(paramQQAppInterface);
      return;
      label73:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(1));
    }
  }
  
  private void m(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (!paramQQAppInterface.getAccount().equals(this.m)) {}
      synchronized (this.jdField_a_of_type_JavaLangBoolean)
      {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        this.m = paramQQAppInterface.getAccount();
        ??? = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
        this.jdField_b_of_type_Boolean = ((SharedPreferences)???).getBoolean("troopbar_assist_show_in_msg", true);
        this.jdField_a_of_type_Long = ((SharedPreferences)???).getLong("troopbar_assist_last_read_time", 0L);
        this.d = ((SharedPreferences)???).getBoolean("troopbar_assist_deleted", false);
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList = null;
      o(paramQQAppInterface);
      this.c = false;
      return;
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private void n(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.b(new ier(this, paramQQAppInterface));
  }
  
  private void o(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return;
    }
    for (;;)
    {
      int n;
      synchronized (this.jdField_a_of_type_JavaLangBoolean)
      {
        if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          Object localObject = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getString("troopbar_assist_new_unread_list", "");
          if (ReadInJoyHelper.b()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "changeAccount, get newMsgStr from sp:" + (String)localObject);
          }
          try
          {
            localObject = new JSONArray((String)localObject);
            n = 0;
            if (n < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(n);
              Iterator localIterator = localJSONObject.keys();
              if (!localIterator.hasNext()) {
                break label254;
              }
              String str = (String)localIterator.next();
              if (!ServiceAccountFolderManager.c(paramQQAppInterface, str)) {
                continue;
              }
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Integer.valueOf(localJSONObject.getInt(str)));
              continue;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "initNewMsgMapIfNeeds:" + paramQQAppInterface.toString());
            }
            this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
            if (ReadInJoyHelper.b()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "initNewMsgMapIfNeeds, succ");
            }
          }
        }
        return;
      }
      label254:
      n += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(QQAppInterface arg1)
  {
    int n = 0;
    if (!???.getAccount().equals(this.m)) {
      return 0;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangBoolean)
      {
        if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
          n = 0;
          if (localIterator.hasNext()) {
            n += ((Integer)localIterator.next()).intValue();
          }
        }
        else
        {
          return n;
        }
      }
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      paramQQAppInterface = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (paramQQAppInterface.hasNext())
      {
        Object localObject = (String)paramQQAppInterface.next();
        if (paramString.equals(localObject))
        {
          localObject = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
          if (localObject != null) {
            return ((Integer)localObject).intValue();
          }
        }
      }
    }
    return 0;
  }
  
  public int a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    int n = 0;
    ConversationFacade localConversationFacade = paramQQAppInterface.a();
    Object localObject1 = paramQQAppInterface.a();
    if ((localConversationFacade == null) || (localObject1 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "countAllSubscriptionUnread getConversationFacade fail");
      }
      return 0;
    }
    label179:
    label182:
    label189:
    label192:
    label198:
    label208:
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          n = 0;
          if (!localIterator.hasNext()) {
            break label208;
          }
          TroopBarData localTroopBarData = (TroopBarData)localIterator.next();
          localObject1 = localTroopBarData.mLatestMessage;
          if (localObject1 != null) {
            break label179;
          }
          localObject1 = paramQQAppInterface.a().a(localTroopBarData.mUin, 1008);
          if ((localObject1 != null) && (ServiceAccountFolderManager.c(paramQQAppInterface, ((MessageRecord)localObject1).frienduin)))
          {
            i1 = localConversationFacade.a(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
            if (!paramBoolean) {
              break label198;
            }
            if (i1 <= 0) {
              break label192;
            }
            i1 = 1;
            break label182;
          }
        }
        else
        {
          return n;
        }
      }
      break label189;
      continue;
      for (n = i1 + n;; n = i1 + n)
      {
        break;
        i1 = 0;
        break label182;
      }
    }
  }
  
  public int a(ConversationFacade paramConversationFacade)
  {
    int n;
    int i1;
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      n = 0;
      if (localIterator.hasNext())
      {
        i1 = paramConversationFacade.a((String)localIterator.next(), 1008);
        if (i1 <= 0) {
          break label78;
        }
      }
      else
      {
        return n;
      }
    }
    for (;;)
    {
      n = i1 + n;
      break;
      label78:
      i1 = 0;
    }
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().a().a(AppConstants.aI, 7210);
    long l1 = 0L;
    if (paramQQAppInterface != null) {
      l1 = paramQQAppInterface.lastmsgtime;
    }
    return l1;
  }
  
  public TroopBarData a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    for (;;)
    {
      TroopBarData localTroopBarData;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break;
        }
        long l1 = b(paramQQAppInterface);
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localTroopBarData = (TroopBarData)localIterator.next();
        if (localTroopBarData.mLastMsgTime < l1) {
          localIterator.remove();
        }
      }
      DraftSummaryInfo localDraftSummaryInfo = paramQQAppInterface.a().a(localTroopBarData.mUin, 1008);
      if (localDraftSummaryInfo != null) {
        localTroopBarData.mLastDraftTime = localDraftSummaryInfo.getTime();
      } else {
        localTroopBarData.mLastDraftTime = 0L;
      }
    }
    a();
    paramQQAppInterface = a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilList);
    if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty())) {}
    for (paramQQAppInterface = (TroopBarData)paramQQAppInterface.get(0);; paramQQAppInterface = null)
    {
      return paramQQAppInterface;
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "getFirstData return null");
      }
    }
  }
  
  public String a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      paramString = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {
        return paramString.name;
      }
    }
    return "";
  }
  
  public List a(QQAppInterface paramQQAppInterface)
  {
    int i2 = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int n = this.jdField_a_of_type_JavaUtilList.size();; n = 0)
    {
      ArrayList localArrayList = new ArrayList(n);
      a(paramQQAppInterface);
      for (;;)
      {
        int i1;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_JavaUtilList != null)
          {
            long l1 = b(paramQQAppInterface);
            i1 = this.jdField_a_of_type_JavaUtilList.size() - 1;
            n = i2;
            if (i1 >= 0)
            {
              TroopBarData localTroopBarData = (TroopBarData)this.jdField_a_of_type_JavaUtilList.get(i1);
              if (localTroopBarData == null)
              {
                this.jdField_a_of_type_JavaUtilList.remove(i1);
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "getUseTroopBarAssistList==> uin:" + localTroopBarData.mUin + ", lastMsgTime:" + localTroopBarData.mLastMsgTime);
                }
                if (localTroopBarData.mLastMsgTime < l1)
                {
                  this.jdField_a_of_type_JavaUtilList.remove(i1);
                }
                else
                {
                  MessageRecord localMessageRecord = paramQQAppInterface.a().a(localTroopBarData.mUin, 1008);
                  if (localMessageRecord == null)
                  {
                    this.jdField_a_of_type_JavaUtilList.remove(i1);
                  }
                  else if (localMessageRecord.time > localTroopBarData.mLastMsgTime)
                  {
                    ((TroopBarData)this.jdField_a_of_type_JavaUtilList.get(i1)).mLastMsgTime = localMessageRecord.time;
                    n = 1;
                  }
                }
              }
            }
            else
            {
              if (n != 0) {
                Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
              }
              localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
            }
          }
          else
          {
            return localArrayList;
          }
        }
        i1 -= 1;
      }
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
      }
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int n;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        n = 1;
        if (n != 0)
        {
          ??? = paramQQAppInterface.a().createEntityManager();
          b((EntityManager)???, paramQQAppInterface);
          ((EntityManager)???).a();
          paramQQAppInterface = ((PublicAccountDataManager)paramQQAppInterface.getManager(55)).a();
          if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
          {
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            paramQQAppInterface = paramQQAppInterface.iterator();
            while (paramQQAppInterface.hasNext())
            {
              ??? = (PublicAccountInfo)paramQQAppInterface.next();
              this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(((PublicAccountInfo)???).getUin(), ???);
            }
          }
        }
      }
      else
      {
        n = 0;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (!paramQQAppInterface.getAccount().equals(this.m)) {
      m(paramQQAppInterface);
    }
    this.jdField_a_of_type_Long = paramLong;
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putLong("troopbar_assist_last_read_time", paramLong).commit();
    RecentUser localRecentUser = paramQQAppInterface.a().a().a(AppConstants.aI, 7210);
    if (localRecentUser != null) {
      localRecentUser.lastmsgtime = paramLong;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (ReadInJoyHelper.b()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setLastReadTime, newMsgStr clear in memory");
    }
    n(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    o(paramQQAppInterface);
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().contains(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Integer.valueOf(0));
    }
    n(paramQQAppInterface);
    RecentUtil.b(paramQQAppInterface, paramString, PublicAccountUtil.a(paramQQAppInterface, paramString));
  }
  
  public void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.getAccount().equals(this.m))) {}
    do
    {
      return;
      if (((PublicAccountDataManager)paramQQAppInterface.getManager(55)).a) {
        break;
      }
    } while (!ReadInJoyHelper.b());
    QLog.w(jdField_a_of_type_JavaLangString, 2, "refreshSettings but padm not cached");
    return;
    this.e = true;
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)paramList.next();
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(localPublicAccountInfo.getUin(), localPublicAccountInfo);
      }
    }
    h(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("troopbar_assist_deleted", paramBoolean).commit();
    this.d = paramBoolean;
  }
  
  public void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (d(paramQQAppInterface)) {
      if ((!this.jdField_b_of_type_Boolean) || (this.d)) {
        break label93;
      }
    }
    label93:
    for (int n = 1;; n = 0)
    {
      if (n != 0)
      {
        localObject = paramQQAppInterface.a().a().a(AppConstants.aI, 7210);
        if (paramMessageRecord.time >= ((RecentUser)localObject).lastmsgtime) {
          c(paramQQAppInterface, false);
        }
      }
      Object localObject = paramQQAppInterface.a().createEntityManager();
      a(paramMessageRecord, paramMessageRecord.frienduin, paramMessageRecord.time, (EntityManager)localObject, paramQQAppInterface);
      ((EntityManager)localObject).a();
      return;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData = a(paramEntityManager, paramQQAppInterface, paramString);
    if ((paramMessageRecord != null) && (paramMessageRecord.time > paramLong))
    {
      localTroopBarData.mLastMsgTime = paramMessageRecord.time;
      localTroopBarData.mLatestMessage = paramMessageRecord;
    }
    for (;;)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(localTroopBarData.mUin, 1008);
      if (localMessage != null)
      {
        long l1 = localMessage.time;
        if (l1 > localTroopBarData.mLastMsgTime)
        {
          localTroopBarData.mLastMsgTime = l1;
          localTroopBarData.mLatestMessage = localMessage;
        }
      }
      a(paramQQAppInterface, paramEntityManager, localTroopBarData);
      a(paramMessageRecord, paramString, paramQQAppInterface);
      if (this.d) {
        a(paramQQAppInterface, false);
      }
      b(paramQQAppInterface, paramString);
      a(paramQQAppInterface, paramLong);
      return;
      localTroopBarData.mLastMsgTime = paramLong;
    }
  }
  
  public void a(EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    try
    {
      a(paramQQAppInterface);
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      Object localObject2 = localRecentUserProxy.a(false);
      long l1 = System.currentTimeMillis() / 1000L;
      Object localObject1 = new ArrayList();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentUser)((Iterator)localObject2).next();
          if (((((RecentUser)localObject3).type == 1008) || (((RecentUser)localObject3).type == 1024)) && (a(paramQQAppInterface, ((RecentUser)localObject3).uin, ((RecentUser)localObject3).type))) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (((List)localObject1).size() > 0)
      {
        l1 = ((RecentUser)((List)localObject1).get(0)).lastmsgtime;
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (RecentUser)((Iterator)localObject1).next();
          localObject3 = a(paramEntityManager, paramQQAppInterface, ((RecentUser)localObject2).uin);
          ((TroopBarData)localObject3).mLastDraftTime = ((RecentUser)localObject2).lastmsgdrafttime;
          QQMessageFacade.Message localMessage;
          if (((RecentUser)localObject2).lastmsgtime == 0L)
          {
            localMessage = paramQQAppInterface.a().a(((TroopBarData)localObject3).mUin, 1008);
            if (localMessage == null) {}
          }
          for (((TroopBarData)localObject3).mLastMsgTime = localMessage.time;; ((TroopBarData)localObject3).mLastMsgTime = ((RecentUser)localObject2).lastmsgtime)
          {
            a(paramQQAppInterface, paramEntityManager, (TroopBarData)localObject3);
            localRecentUserProxy.b((RecentUser)localObject2);
            h(((TroopBarData)localObject3).mUin, paramQQAppInterface);
            break;
          }
        }
      }
      ((PublicAccountHandler)paramQQAppInterface.a(11)).c();
      paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("init_troopbar_assist", false).commit();
      return;
    }
    catch (Exception paramEntityManager) {}
  }
  
  public void a(String paramString, long paramLong, EntityManager paramEntityManager, QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData;
    if (paramLong == 0L)
    {
      localTroopBarData = a(paramQQAppInterface, paramString);
      if (localTroopBarData != null)
      {
        localTroopBarData.mLastDraftTime = paramLong;
        if ((paramLong != 0L) || (localTroopBarData.mLastMsgTime != 0L)) {
          break label102;
        }
        b(paramQQAppInterface, paramString);
      }
    }
    for (;;)
    {
      if (this.d) {
        a(paramQQAppInterface, false);
      }
      b(paramQQAppInterface, paramString);
      if (localTroopBarData != null) {
        a(paramQQAppInterface, localTroopBarData.mLastMsgTime);
      }
      return;
      localTroopBarData = a(paramEntityManager, paramQQAppInterface, paramString);
      break;
      label102:
      a(paramQQAppInterface, paramEntityManager, localTroopBarData);
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 != null) {
      ((PublicAccountInfo)localObject1).mShowMsgFlag = 0;
    }
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    Object localObject2 = localRecentUserProxy.b(paramString, 1008);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localRecentUserProxy.b(paramString, 0);
    }
    if (localObject1 != null)
    {
      paramString = a(localEntityManager, paramQQAppInterface, paramString);
      if (((RecentUser)localObject1).lastmsgtime != 0L) {
        break label211;
      }
      localObject2 = paramQQAppInterface.a().a(paramString.mUin, 1008);
      if (localObject2 == null) {}
    }
    label211:
    for (paramString.mLastMsgTime = ((QQMessageFacade.Message)localObject2).time;; paramString.mLastMsgTime = ((RecentUser)localObject1).lastmsgtime)
    {
      paramString.mLastDraftTime = ((RecentUser)localObject1).lastmsgdrafttime;
      a(paramQQAppInterface, localEntityManager, paramString);
      h(paramString.mUin, paramQQAppInterface);
      RecentDataListManager.a().a(((RecentUser)localObject1).uin + "-" + ((RecentUser)localObject1).type);
      localRecentUserProxy.b((RecentUser)localObject1);
      paramString = a(paramQQAppInterface);
      if (paramString != null) {
        a(paramQQAppInterface, paramString.mLastMsgTime);
      }
      localEntityManager.a();
      return;
    }
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, Context paramContext, PublicAccountObserver paramPublicAccountObserver)
  {
    PublicAccountUtil.a(paramQQAppInterface, paramContext, paramString, true, paramPublicAccountObserver);
  }
  
  public void a(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    o(paramQQAppInterface);
    if (((paramBoolean) || (paramQQAppInterface.a().a(paramString, 1008) > 0)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    n(paramQQAppInterface);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("init_troopbar_assist", true);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
        b(localEntityManager, paramQQAppInterface);
        localEntityManager.a();
      }
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return (paramInt == 1008) && (ServiceAccountFolderManager.c(paramQQAppInterface, paramString));
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramString = a(paramQQAppInterface, paramString);
    if (paramString != null) {
      return paramString.mIsSticky;
    }
    return false;
  }
  
  public int b()
  {
    int i1;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      int n = 0;
      i1 = n;
      if (!localIterator.hasNext()) {
        break label59;
      }
      if (!((TroopBarData)localIterator.next()).mIsSticky) {
        break label61;
      }
      n += 1;
    }
    label59:
    label61:
    for (;;)
    {
      break;
      i1 = 0;
      return i1;
    }
  }
  
  public int b(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    int n = 0;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!ServiceAccountFolderManager.c(paramQQAppInterface, (String)localEntry.getKey())) {
        break label74;
      }
      n = ((Integer)localEntry.getValue()).intValue() + n;
    }
    label74:
    for (;;)
    {
      break;
      return n;
    }
  }
  
  public List b(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
    Object localObject1 = new ArrayList();
    Object localObject3;
    for (;;)
    {
      long l1;
      TroopBarData localTroopBarData;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label320;
        }
        l1 = b(paramQQAppInterface);
        localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localTroopBarData = (TroopBarData)((Iterator)localObject3).next();
        if (localTroopBarData == null) {
          ((Iterator)localObject3).remove();
        }
      }
      Object localObject4 = paramQQAppInterface.a().a(localTroopBarData.mUin, 1008);
      if (localObject4 == null)
      {
        ((Iterator)localObject3).remove();
      }
      else
      {
        localTroopBarData.mLatestMessage = ((MessageRecord)localObject4);
        localTroopBarData.mLastMsgTime = ((MessageRecord)localObject4).time;
        if (PublicAccountUtil.a((MessageRecord)localObject4))
        {
          localObject4 = paramQQAppInterface.a().b(localTroopBarData.mUin, 1008);
          if (localObject4 != null) {
            localTroopBarData.mLatestMessage = ((MessageRecord)localObject4);
          }
        }
        localObject4 = paramQQAppInterface.a().a(localTroopBarData.mUin, 1008);
        if (localObject4 != null) {}
        for (localTroopBarData.mLastDraftTime = ((DraftSummaryInfo)localObject4).getTime();; localTroopBarData.mLastDraftTime = 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "getUseTroopBarAssistList==> uin:" + localTroopBarData.mUin + ", lastMsgTime:" + localTroopBarData.mLastMsgTime + ", lastDraftTime: " + localTroopBarData.mLastDraftTime);
          }
          if (localTroopBarData.mLastMsgTime >= l1) {
            break;
          }
          ((Iterator)localObject3).remove();
          break;
        }
      }
    }
    a();
    ((List)localObject1).addAll(a(paramQQAppInterface, this.jdField_a_of_type_JavaUtilList));
    label320:
    ??? = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (TroopBarData)((Iterator)localObject1).next();
      localObject3 = SubscriptionFeed.a(paramQQAppInterface, paramQQAppInterface.getApplication().getApplicationContext(), (TroopBarData)localObject3);
      if ((localObject3 != null) && (!((List)???).contains(localObject3))) {
        ((List)???).add(localObject3);
      }
    }
    return (List)???;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopBarAssistManager", 2, "app == null; what happen.");
      }
    }
    TroopBarData localTroopBarData;
    do
    {
      return;
      if (!paramQQAppInterface.getAccount().equals(this.m)) {
        m(paramQQAppInterface);
      }
      if (d(paramQQAppInterface))
      {
        c(paramQQAppInterface, false);
        b(paramQQAppInterface, false);
        a(paramQQAppInterface, NetConnInfoCenter.getServerTime());
        return;
      }
      localTroopBarData = a(paramQQAppInterface);
    } while (localTroopBarData == null);
    a(paramQQAppInterface, localTroopBarData.mLastMsgTime);
  }
  
  public void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_login", paramBoolean).commit();
  }
  
  public void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    if (a(localEntityManager, paramString)) {
      g(paramString, paramQQAppInterface);
    }
    localEntityManager.a();
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    return this.d;
  }
  
  public List c(QQAppInterface paramQQAppInterface)
  {
    Object localObject = ((PublicAccountDataManager)paramQQAppInterface.getManager(55)).a();
    if (localObject != null)
    {
      paramQQAppInterface = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        if (PublicAccountUtil.a(localPublicAccountInfo.accountFlag, localPublicAccountInfo.accountFlag2)) {
          paramQQAppInterface.add(localPublicAccountInfo);
        }
      }
      return paramQQAppInterface;
    }
    return null;
  }
  
  public void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().a();
    RecentUser localRecentUser = paramQQAppInterface.a(AppConstants.aI, 7210);
    if (localRecentUser != null) {
      paramQQAppInterface.b(localRecentUser);
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("subscribe_setTop_flag", paramBoolean).commit();
  }
  
  public void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 != null) {
      ((PublicAccountInfo)localObject1).mShowMsgFlag = 1;
    }
    localObject1 = null;
    try
    {
      EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
      localObject1 = localEntityManager;
      TroopBarData localTroopBarData = a(paramQQAppInterface, paramString);
      localObject1 = localEntityManager;
      RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
      if (localTroopBarData != null)
      {
        localObject1 = localEntityManager;
        Object localObject2 = localRecentUserProxy.b(localTroopBarData.mUin, 1008);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localEntityManager;
          localObject2 = localRecentUserProxy.b(localTroopBarData.mUin, 0);
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = localEntityManager;
          localObject2 = localRecentUserProxy.a(localTroopBarData.mUin, 1008);
        }
        localObject1 = localEntityManager;
        ((RecentUser)localObject2).lastmsgtime = localTroopBarData.mLastMsgTime;
        localObject1 = localEntityManager;
        ((RecentUser)localObject2).lastmsgdrafttime = localTroopBarData.mLastDraftTime;
        localObject1 = localEntityManager;
        if (a(localEntityManager, paramString))
        {
          localObject1 = localEntityManager;
          localRecentUserProxy.a((RecentUser)localObject2);
          localObject1 = localEntityManager;
          g(paramString, paramQQAppInterface);
        }
      }
      localObject1 = localEntityManager;
      paramString = a(paramQQAppInterface);
      if (paramString != null)
      {
        localObject1 = localEntityManager;
        a(paramQQAppInterface, paramString.mLastMsgTime);
      }
      if (localEntityManager != null) {
        localEntityManager.a();
      }
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((EntityManager)localObject1).a();
      }
    }
  }
  
  public boolean c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("first_login", false);
  }
  
  public void d(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (ReadInJoyHelper.b()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "setFirstEnterFeeds, newMsgStr clear in memory");
    }
    n(paramQQAppInterface);
  }
  
  public void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe", paramBoolean).commit();
  }
  
  public void d(String paramString, QQAppInterface paramQQAppInterface)
  {
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    if (a(localEntityManager, paramString)) {
      g(paramString, paramQQAppInterface);
    }
    localEntityManager.a();
  }
  
  public boolean d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("subscribe_setTop_flag", false);
  }
  
  public void e(QQAppInterface paramQQAppInterface)
  {
    TroopBarData localTroopBarData = a(paramQQAppInterface);
    if (localTroopBarData != null) {}
    for (long l1 = localTroopBarData.mLastMsgTime;; l1 = NetConnInfoCenter.getServerTime())
    {
      a(paramQQAppInterface, l1);
      return;
    }
  }
  
  public void e(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit().putBoolean("first_enter_subscribe_no_reset", paramBoolean).commit();
  }
  
  public void e(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.mIsSticky = true;
      paramString.mLastStickyTime = (System.currentTimeMillis() / 1000L);
      ((ProxyManager)paramQQAppInterface.getManager(17)).a(paramQQAppInterface.getAccount(), 0, paramString.getTableName(), paramString, 4, null);
      a();
      paramString = paramQQAppInterface.a(Conversation.class);
      if (paramString != null)
      {
        paramString.sendEmptyMessage(1009);
        return;
      }
    }
  }
  
  public boolean e(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("first_enter_subscribe", true);
  }
  
  public void f(QQAppInterface paramQQAppInterface)
  {
    o(paramQQAppInterface);
    n(paramQQAppInterface);
  }
  
  public void f(String paramString, QQAppInterface paramQQAppInterface)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (TroopBarData)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.mIsSticky = false;
      paramString.mLastStickyTime = 0L;
      ((ProxyManager)paramQQAppInterface.getManager(17)).a(paramQQAppInterface.getAccount(), 0, paramString.getTableName(), paramString, 4, null);
      a();
      paramString = paramQQAppInterface.a(Conversation.class);
      if (paramString != null)
      {
        paramString.sendEmptyMessage(1009);
        return;
      }
    }
  }
  
  public boolean f(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).getBoolean("first_enter_subscribe_no_reset", true);
  }
  
  public void g(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.b(new ies(this, paramQQAppInterface));
  }
  
  public void h(QQAppInterface paramQQAppInterface)
  {
    RecentUserProxy localRecentUserProxy = paramQQAppInterface.a().a();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    ??? = localRecentUserProxy.a(false);
    Object localObject4;
    if ((??? != null) && (((List)???).size() > 0))
    {
      ??? = ((List)???).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)???).next();
        if ((((RecentUser)localObject4).type == 1008) && (a(paramQQAppInterface, ((RecentUser)localObject4).uin, ((RecentUser)localObject4).type)) && (!((RecentUser)localObject4).shouldShowInRecentList())) {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    a(paramQQAppInterface);
    Object localObject5;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (TroopBarData)((Iterator)localObject4).next();
          if (!a(paramQQAppInterface, ((TroopBarData)localObject5).mUin, 1008)) {
            ((ArrayList)localObject1).add(localObject5);
          }
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      if (this.d) {
        a(paramQQAppInterface, false);
      }
      localObject2 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        ??? = (RecentUser)((Iterator)localObject2).next();
        localObject4 = a(localEntityManager, paramQQAppInterface, ((RecentUser)???).uin);
        if (((RecentUser)???).lastmsgtime == 0L)
        {
          localObject5 = paramQQAppInterface.a().a(((TroopBarData)localObject4).mUin, 1008);
          if (localObject5 == null) {}
        }
        for (((TroopBarData)localObject4).mLastMsgTime = ((QQMessageFacade.Message)localObject5).time;; ((TroopBarData)localObject4).mLastMsgTime = ((RecentUser)???).lastmsgtime)
        {
          a(paramQQAppInterface, localEntityManager, (TroopBarData)localObject4);
          localRecentUserProxy.b((RecentUser)???);
          h(((RecentUser)???).uin, paramQQAppInterface);
          break;
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (TroopBarData)((Iterator)localObject2).next();
        localObject4 = localRecentUserProxy.a(((TroopBarData)???).mUin, 1008);
        ((RecentUser)localObject4).uin = ((TroopBarData)???).mUin;
        ((RecentUser)localObject4).type = 1008;
        ((RecentUser)localObject4).lastmsgtime = ((TroopBarData)???).mLastMsgTime;
        ((RecentUser)localObject4).lastmsgdrafttime = ((TroopBarData)???).mLastDraftTime;
        if (ReadInJoyHelper.b())
        {
          localObject1 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
          QLog.i(jdField_a_of_type_JavaLangString, 2, "uinConfigMap size: " + this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() + ", pam cache: " + ((PublicAccountDataManager)localObject1).a);
          QLog.i(jdField_a_of_type_JavaLangString, 2, "to remove incognizance TroopBarData " + ((TroopBarData)???).mUin + " from dataList");
        }
        if (a(localEntityManager, ((TroopBarData)???).mUin))
        {
          if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {}
          for (localObject1 = null;; localObject1 = (PublicAccountInfo)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(((TroopBarData)???).mUin))
          {
            if (localObject1 != null) {
              localRecentUserProxy.a((RecentUser)localObject4);
            }
            if (ReadInJoyHelper.b()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "to remove incognizance uin " + ((TroopBarData)???).mUin + " from newMsgSet");
            }
            g(((TroopBarData)???).mUin, paramQQAppInterface);
            break;
          }
        }
      }
    }
    localObject1 = a(paramQQAppInterface);
    if (localObject1 != null) {
      a(paramQQAppInterface, ((TroopBarData)localObject1).mLastMsgTime);
    }
    if (localEntityManager != null) {
      localEntityManager.a();
    }
  }
  
  public void i(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a(SubscriptFeedsActivity.class);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface.removeMessages(1002);
      paramQQAppInterface.sendEmptyMessage(1002);
      paramQQAppInterface.removeMessages(1005);
      paramQQAppInterface.sendEmptyMessage(1005);
    }
  }
  
  public void j(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0).edit();
      this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
      paramQQAppInterface.putLong("troopbar_recent_item_last_del_time", this.jdField_b_of_type_Long);
      paramQQAppInterface.commit();
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "saveTroopBarRecentItemLastDelTime, lastDelTime:" + this.jdField_b_of_type_Long);
  }
  
  public void k(QQAppInterface paramQQAppInterface)
  {
    a().d(paramQQAppInterface, false);
    this.jdField_b_of_type_Int = 0;
  }
  
  public void l(QQAppInterface paramQQAppInterface)
  {
    try
    {
      m(paramQQAppInterface);
      if (a(paramQQAppInterface) == true)
      {
        EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
        a(localEntityManager, paramQQAppInterface);
        localEntityManager.a();
      }
      b(paramQQAppInterface);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\troopbarassit\TroopBarAssistantManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */