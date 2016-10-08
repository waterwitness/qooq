package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import friendlist.GetOnlineInfoResp;
import friendlist.SimpleOnlineFriendInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import pyb;
import pyd;
import pye;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RecommendReason;

public class FriendsManager
  implements Manager
{
  public static final int a = -100;
  private static final long jdField_a_of_type_Long = 500654080L;
  public static final String a = "Q.contacttab.";
  private static final long jdField_b_of_type_Long = 259200000L;
  public static final String b = "Q.contacttab.friend";
  public static final String c = "Q.contacttab.extension";
  public static final String d = "Q.contacttab.group";
  private static final String jdField_e_of_type_JavaLangString = "add_friend_request_sp";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Map jdField_a_of_type_JavaUtilMap;
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_b_of_type_Boolean;
  public int c;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  private ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_d_of_type_Boolean;
  public int e;
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_e_of_type_Boolean;
  public int f;
  private ConcurrentHashMap f;
  public int g;
  private ConcurrentHashMap g;
  public int h;
  private ConcurrentHashMap h;
  int jdField_i_of_type_Int;
  private ConcurrentHashMap jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int j;
  
  public FriendsManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(500);
    this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Int = 3;
    this.jdField_c_of_type_Int = 30;
    this.jdField_d_of_type_Int = 3;
    this.jdField_e_of_type_Int = 30;
    this.jdField_f_of_type_Int = 3;
    this.jdField_g_of_type_Int = 30;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_MqqObserverAccountObserver = new pyb(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(6);
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "add_friend_request_sp", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private ConcurrentHashMap a(boolean paramBoolean)
  {
    label529:
    label532:
    label535:
    label538:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject4;
      int k;
      Object localObject3;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildNormalAndGatheredUiMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject4 = new ConcurrentHashMap(4);
        Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
        k = 0;
        if (localIterator.hasNext())
        {
          Friends localFriends = (Friends)((Map.Entry)localIterator.next()).getValue();
          if (localFriends.gathtertype != 1) {
            break label535;
          }
          k += 1;
          if (paramBoolean)
          {
            if (localFriends.gathtertype != 1) {}
          }
          else
          {
            if (localFriends.gathtertype == 0) {
              break label532;
            }
            if (localFriends.gathtertype == 2) {
              continue;
            }
          }
          if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
            ContactSorter.a(localFriends);
          }
          String str = localFriends.groupid + "";
          localObject3 = (ArrayList)localConcurrentHashMap.get(str);
          Object localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = new ArrayList();
            localConcurrentHashMap.put(str, localObject1);
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              break label529;
            }
            localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label529;
            }
            Groups localGroups = (Groups)((Iterator)localObject3).next();
            if (localGroups.group_id != localFriends.groupid) {
              continue;
            }
            ((ArrayList)localObject1).ensureCapacity(localGroups.group_friend_count);
          }
          ((ArrayList)localObject1).add(localFriends);
          if ((!paramBoolean) || ((localFriends.status != 10) && (localFriends.status != 11))) {
            break label538;
          }
          localObject1 = (Integer)((ConcurrentHashMap)localObject4).get(str);
          if (localObject1 == null) {
            ((ConcurrentHashMap)localObject4).put(str, Integer.valueOf(1));
          } else {
            ((ConcurrentHashMap)localObject4).put(str, Integer.valueOf(((Integer)localObject1).intValue() + 1));
          }
        }
      }
      finally {}
      if (paramBoolean) {
        this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)localObject4);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(300);
        localStringBuilder.append("buildNormalAndGatheredUiMaps end " + localConcurrentHashMap.size() + ": ");
        localObject3 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localStringBuilder.append((String)localObject4).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject4)).size()).append("; ");
        }
        localStringBuilder.append(" gatherCount=").append(k);
        QLog.d("Q.contacttab.friend", 2, localStringBuilder.toString());
      }
      this.j = k;
      return localConcurrentHashMap;
      continue;
      continue;
    }
  }
  
  private void a(Friends[] paramArrayOfFriends)
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while (k < paramArrayOfFriends.length)
    {
      localArrayList.add(paramArrayOfFriends[k].uin);
      k += 1;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), localArrayList);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init begin");
    }
    g();
    a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "init end");
    }
  }
  
  private void f()
  {
    ??? = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NoC2CExtensionInfo.class);
    if (??? != null)
    {
      Iterator localIterator = ((ArrayList)???).iterator();
      while (localIterator.hasNext())
      {
        NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)localIterator.next();
        if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.uin != null)) {
          synchronized (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap)
          {
            String str = NoC2CExtensionInfo.getNoC2Ckey(localNoC2CExtensionInfo.type, localNoC2CExtensionInfo.uin);
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localNoC2CExtensionInfo);
          }
        }
      }
    }
  }
  
  private boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin empty uin");
      }
    }
    for (;;)
    {
      return false;
      if (paramString.length() >= 4) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.", 2, "isValidUin uin=" + paramString);
      }
    }
    return true;
  }
  
  private void g()
  {
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initGroupList begin");
    }
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, false, "group_id>=?", new String[] { "0" }, null, null, "seqid asc", null));
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = new ConcurrentHashMap(this.jdField_a_of_type_JavaUtilArrayList.size());
      k = 0;
      while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        ((ConcurrentHashMap)localObject).put(localGroups.group_id + "", localGroups);
        k += 1;
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("initGroupList end: ");
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        break label186;
      }
    }
    label186:
    for (int k = m;; k = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size())
    {
      QLog.d("Q.contacttab.friend", 2, k);
      return;
    }
  }
  
  private void h()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_e_of_type_Boolean;
        if (bool) {
          return;
        }
        long l = System.currentTimeMillis();
        try
        {
          ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NearbyPeopleCard.class, false, "lastUpdateNickTime>?", new String[] { "0" }, null, null, "_id desc", String.valueOf(100));
          if (!QLog.isColorLevel()) {
            break label207;
          }
          if (localArrayList == null)
          {
            k = 0;
            QLog.d("Q.contacttab.", 2, "nearby people card count = " + k);
            break label207;
            if (k >= localArrayList.size()) {
              continue;
            }
            NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localArrayList.get(k);
            if (localNearbyPeopleCard == null) {
              break label216;
            }
            a(localNearbyPeopleCard);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NearbyPeopleCard.class.getSimpleName());
          Object localObject1 = null;
          continue;
          k = ((ArrayList)localObject1).size();
          continue;
          this.jdField_e_of_type_Boolean = true;
        }
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("Q.contacttab.", 4, "initDateNickNameCache cost time:" + (System.currentTimeMillis() - l));
        continue;
        if (localObject2 == null) {
          continue;
        }
      }
      finally {}
      label207:
      int k = 0;
      continue;
      label216:
      k += 1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.status;
    }
    return 10;
  }
  
  public int a(String paramString, ExtensionInfo paramExtensionInfo, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    do
    {
      do
      {
        return 0;
        if (((paramInt != 0) || (this.jdField_c_of_type_Boolean)) && ((paramInt != 1) || (this.jdField_d_of_type_Boolean))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HotFriend_Q.contacttab.", 2, "getChatDays|config close, type=" + paramInt);
      return 0;
    } while (paramExtensionInfo == null);
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_Q.contacttab.", 2, "getChatDays|uin=" + paramString + ",days=" + paramExtensionInfo.chatDays);
    }
    return paramExtensionInfo.chatDays;
  }
  
  public int a(String paramString, ExtensionInfo paramExtensionInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (paramExtensionInfo == null) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_Q.contacttab.", 2, "getBestIntimacyType|uin=" + paramString + ",type=" + paramExtensionInfo.bestIntimacyType);
    }
    return paramExtensionInfo.bestIntimacyType;
  }
  
  public Card a(String paramString)
  {
    return (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
  }
  
  public ContactCard a(String paramString)
  {
    return (ContactCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactCard.class, paramString);
  }
  
  public DateNickNameInfo a(String paramString)
  {
    if (!Friends.isValidUin(paramString)) {
      return null;
    }
    if (!this.jdField_e_of_type_Boolean) {
      h();
    }
    return (DateNickNameInfo)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
  }
  
  public ExtensionInfo a(String paramString)
  {
    return a(paramString, true);
  }
  
  public ExtensionInfo a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString)))
    {
      ??? = null;
      return (ExtensionInfo)???;
    }
    if (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    for (ExtensionInfo localExtensionInfo = (ExtensionInfo)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);; localExtensionInfo = null)
    {
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
      if (!paramBoolean) {
        return null;
      }
      if ((Thread.currentThread() == Looper.getMainLooper().getThread()) && (QLog.isColorLevel())) {
        QLog.e("Q.contacttab.extension", 2, "getExtensionInfo, query db in main thread, abort!!!");
      }
      ??? = localExtensionInfo;
      if (localExtensionInfo != null) {
        break;
      }
      ??? = localExtensionInfo;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      localExtensionInfo = (ExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class, paramString);
      ??? = localExtensionInfo;
      if (localExtensionInfo == null) {
        break;
      }
      synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localExtensionInfo);
        return localExtensionInfo;
      }
    }
  }
  
  public Friends a(String paramString)
  {
    Object localObject;
    if (!f(paramString)) {
      localObject = null;
    }
    Friends localFriends;
    do
    {
      do
      {
        do
        {
          return (Friends)localObject;
          localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          localObject = localFriends;
        } while (localFriends != null);
        localObject = localFriends;
      } while (this.jdField_a_of_type_Boolean);
      localFriends = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
      if (localFriends != null) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, localFriends);
      }
      localObject = localFriends;
    } while (!QLog.isColorLevel());
    if (localFriends == null) {}
    for (paramString = "null";; paramString = StringUtil.f(localFriends.uin))
    {
      QLog.d("Q.contacttab.", 2, new Object[] { "findFriendEntifyFromCache from db f=", paramString });
      return localFriends;
    }
  }
  
  public Friends a(String paramString1, String paramString2)
  {
    paramString1 = b(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1.name = paramString2;
      paramString1.datetime = System.currentTimeMillis();
      if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin)) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
      }
      ContactSorter.a(paramString1);
    }
    return paramString1;
  }
  
  public Groups a(String paramString)
  {
    Object localObject;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      localObject = null;
    }
    Groups localGroups;
    do
    {
      do
      {
        return (Groups)localObject;
        localGroups = (Groups)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject = localGroups;
      } while (localGroups != null);
      localGroups = (Groups)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, paramString);
      localObject = localGroups;
    } while (localGroups == null);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localGroups);
    this.jdField_a_of_type_JavaUtilArrayList = ContactSorter.a(this.jdField_a_of_type_JavaUtilArrayList, localGroups);
    return localGroups;
  }
  
  public NoC2CExtensionInfo a(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = NoC2CExtensionInfo.getNoC2Ckey(paramInt, paramString);
    NoC2CExtensionInfo localNoC2CExtensionInfo = (NoC2CExtensionInfo)this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    ??? = localNoC2CExtensionInfo;
    if (localNoC2CExtensionInfo == null)
    {
      ??? = localNoC2CExtensionInfo;
      if (paramBoolean)
      {
        ??? = localNoC2CExtensionInfo;
        if (!this.jdField_b_of_type_Boolean)
        {
          paramString = (NoC2CExtensionInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NoC2CExtensionInfo.class, "type=? and uin=?", new String[] { String.valueOf(paramInt), paramString });
          ??? = paramString;
          if (paramString != null) {
            synchronized (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap)
            {
              this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
              return paramString;
            }
          }
        }
      }
    }
    return (NoC2CExtensionInfo)???;
  }
  
  public SpecialCareInfo a(String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    ??? = localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        break label28;
      }
      ??? = localObject1;
    }
    for (;;)
    {
      return (SpecialCareInfo)???;
      label28:
      localObject1 = localObject3;
      if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
      synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject1 = (SpecialCareInfo)this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        ??? = localObject1;
        if (localObject1 == null) {
          continue;
        }
        return (SpecialCareInfo)((SpecialCareInfo)localObject1).clone();
      }
    }
  }
  
  public EntityTransaction a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
  
  public String a(int paramInt)
  {
    return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramInt));
  }
  
  public String a(String paramString)
  {
    Friends localFriends = c(paramString);
    String str = paramString;
    if (localFriends != null)
    {
      str = paramString;
      if (localFriends.alias != null)
      {
        str = paramString;
        if (localFriends.alias.length() > 0) {
          str = localFriends.alias;
        }
      }
    }
    return str;
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      ThreadManager.a(new pyd(this), null, false);
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (((Friends)localObject).groupid == paramInt) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public ArrayList a(String paramString)
  {
    return (ArrayList)this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public List a()
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.", 2, "getSpecailCareInfos isSpecialCareInfoCacheInited is false or specailCareInfoCache is null");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Iterator localIterator = this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)localIterator.next();
        if (localSpecialCareInfo.globalSwitch != 0) {
          localArrayList.add((SpecialCareInfo)localSpecialCareInfo.clone());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getSpecailCareInfos: size=" + localList.size());
    }
    return localList;
  }
  
  public ConcurrentHashMap a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, Friends.class.getSimpleName(), false, "gathtertype=?", new String[] { String.valueOf(2) }, null, null, null, null);
    Object localObject1 = new ConcurrentHashMap();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Friends)((Iterator)localObject2).next();
        ((ConcurrentHashMap)localObject1).put(((Friends)localObject3).uin, localObject3);
      }
    }
    Object localObject3 = new ConcurrentHashMap(6);
    Iterator localIterator = ((ConcurrentHashMap)localObject1).values().iterator();
    while (localIterator.hasNext())
    {
      Friends localFriends = (Friends)localIterator.next();
      String str = localFriends.groupid + "";
      localObject2 = (ArrayList)((ConcurrentHashMap)localObject3).get(str);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        ((ConcurrentHashMap)localObject3).put(str, localObject1);
      }
      ((ArrayList)localObject1).add(localFriends);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArrayList)((ConcurrentHashMap)localObject3).get(String.valueOf(((Groups)((Iterator)localObject1).next()).group_id));
        if (localObject2 != null) {
          Collections.sort((List)localObject2, ContactSorter.a);
        }
      }
    }
    return (ConcurrentHashMap)localObject3;
  }
  
  public void a()
  {
    label299:
    label505:
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap;
      Object localObject5;
      Object localObject4;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.", 2, "buildUIMaps begin :");
        }
        localConcurrentHashMap = new ConcurrentHashMap(6);
        localObject5 = new ConcurrentHashMap(4);
        Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        if (!localIterator.hasNext()) {
          break label299;
        }
        Friends localFriends = (Friends)localIterator.next();
        if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0)) {
          ContactSorter.a(localFriends);
        }
        String str = localFriends.groupid + "";
        localObject4 = (ArrayList)localConcurrentHashMap.get(str);
        Object localObject1 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = new ArrayList();
          localConcurrentHashMap.put(str, localObject1);
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            break label505;
          }
          localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label505;
          }
          Groups localGroups = (Groups)((Iterator)localObject4).next();
          if (localGroups.group_id != localFriends.groupid) {
            continue;
          }
          ((ArrayList)localObject1).ensureCapacity(localGroups.group_friend_count);
        }
        ((ArrayList)localObject1).add(localFriends);
        if ((localFriends.status != 10) && (localFriends.status != 11)) {
          continue;
        }
        localObject1 = (Integer)((ConcurrentHashMap)localObject5).get(str);
        if (localObject1 == null)
        {
          ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(1));
          continue;
        }
        ((ConcurrentHashMap)localObject5).put(str, Integer.valueOf(((Integer)localObject2).intValue() + 1));
      }
      finally {}
      continue;
      Object localObject3;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ArrayList)localConcurrentHashMap.get(String.valueOf(((Groups)((Iterator)localObject3).next()).group_id));
          if (localObject4 != null) {
            Collections.sort((List)localObject4, ContactSorter.a);
          }
        }
      }
      this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)localObject5);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder(300);
        ((StringBuilder)localObject3).append("buildUIMaps end " + localConcurrentHashMap.size() + ": ");
        localObject4 = localConcurrentHashMap.keySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          ((StringBuilder)localObject3).append((String)localObject5).append(", ").append(((ArrayList)localConcurrentHashMap.get(localObject5)).size()).append("; ");
        }
        QLog.d("Q.contacttab.friend", 2, ((StringBuilder)localObject3).toString());
      }
      this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = localConcurrentHashMap;
      return;
    }
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: new 577	java/lang/StringBuffer
    //   6: dup
    //   7: invokespecial 578	java/lang/StringBuffer:<init>	()V
    //   10: astore 5
    //   12: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +19 -> 34
    //   18: aload 5
    //   20: ldc_w 580
    //   23: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   26: pop
    //   27: aload 5
    //   29: iload_1
    //   30: invokevirtual 586	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   33: pop
    //   34: aload_0
    //   35: iload_1
    //   36: invokevirtual 588	com/tencent/mobileqq/app/FriendsManager:a	(I)Ljava/util/ArrayList;
    //   39: astore 4
    //   41: aconst_null
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 134	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   47: invokevirtual 523	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   50: astore_3
    //   51: aload_3
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 591	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   57: aload 4
    //   59: invokevirtual 239	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   62: astore_3
    //   63: iconst_0
    //   64: istore 7
    //   66: aload_3
    //   67: invokeinterface 188 1 0
    //   72: ifeq +175 -> 247
    //   75: aload_3
    //   76: invokeinterface 192 1 0
    //   81: checkcast 241	com/tencent/mobileqq/persistence/Entity
    //   84: checkcast 199	com/tencent/mobileqq/data/Friends
    //   87: astore 6
    //   89: aload_0
    //   90: aload 6
    //   92: getfield 296	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   95: invokevirtual 593	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   98: istore 10
    //   100: iload 7
    //   102: istore 8
    //   104: aload 6
    //   106: getfield 203	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   109: iconst_1
    //   110: if_icmpeq +18 -> 128
    //   113: iload 7
    //   115: istore 8
    //   117: iload 10
    //   119: ifeq +9 -> 128
    //   122: iload 7
    //   124: iconst_1
    //   125: iadd
    //   126: istore 8
    //   128: aload 6
    //   130: iconst_0
    //   131: putfield 220	com/tencent/mobileqq/data/Friends:groupid	I
    //   134: aload_0
    //   135: aload 6
    //   137: invokevirtual 596	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   140: pop
    //   141: iload 8
    //   143: istore 7
    //   145: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -82 -> 66
    //   151: aload 5
    //   153: ldc_w 598
    //   156: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: aload 5
    //   162: aload 6
    //   164: getfield 296	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   167: iconst_0
    //   168: iconst_4
    //   169: invokevirtual 602	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   175: pop
    //   176: aload 5
    //   178: ldc_w 604
    //   181: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   184: pop
    //   185: aload 5
    //   187: iload 10
    //   189: invokevirtual 607	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   192: pop
    //   193: iload 8
    //   195: istore 7
    //   197: goto -131 -> 66
    //   200: astore_3
    //   201: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +30 -> 234
    //   207: ldc 26
    //   209: iconst_2
    //   210: new 143	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 609
    //   220: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: iload_1
    //   224: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: aload_3
    //   231: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: aload_2
    //   235: ifnull +7 -> 242
    //   238: aload_2
    //   239: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   242: aload_0
    //   243: invokevirtual 313	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   246: return
    //   247: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +14 -> 264
    //   253: ldc 26
    //   255: iconst_2
    //   256: aload 5
    //   258: invokevirtual 615	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   261: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: aload_0
    //   265: iconst_0
    //   266: invokestatic 380	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   269: invokevirtual 617	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   272: astore_3
    //   273: aload_3
    //   274: ifnull +34 -> 308
    //   277: aload_3
    //   278: aload_3
    //   279: getfield 249	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   282: aload 4
    //   284: invokevirtual 284	java/util/ArrayList:size	()I
    //   287: iadd
    //   288: putfield 249	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   291: aload_3
    //   292: iload 7
    //   294: aload_3
    //   295: getfield 620	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   298: iadd
    //   299: putfield 620	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   302: aload_0
    //   303: aload_3
    //   304: invokevirtual 623	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   307: pop
    //   308: aload_0
    //   309: new 143	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   316: iload_1
    //   317: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: ldc -31
    //   322: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokevirtual 617	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   331: astore_3
    //   332: aload_0
    //   333: getfield 359	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   336: ifnull +30 -> 366
    //   339: aload_0
    //   340: getfield 359	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   343: new 143	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   350: iload_1
    //   351: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: ldc -31
    //   356: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokevirtual 626	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   365: pop
    //   366: aload_0
    //   367: getfield 238	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   370: invokevirtual 627	java/util/ArrayList:clone	()Ljava/lang/Object;
    //   373: checkcast 231	java/util/ArrayList
    //   376: astore 4
    //   378: iload 9
    //   380: istore 7
    //   382: iload 7
    //   384: aload 4
    //   386: invokevirtual 284	java/util/ArrayList:size	()I
    //   389: if_icmpge +28 -> 417
    //   392: iload_1
    //   393: aload 4
    //   395: iload 7
    //   397: invokevirtual 357	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   400: checkcast 243	com/tencent/mobileqq/data/Groups
    //   403: getfield 246	com/tencent/mobileqq/data/Groups:group_id	I
    //   406: if_icmpne +41 -> 447
    //   409: aload 4
    //   411: iload 7
    //   413: invokevirtual 629	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   416: pop
    //   417: aload_0
    //   418: aload 4
    //   420: putfield 238	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   423: aload_0
    //   424: getfield 134	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   427: aload_3
    //   428: invokevirtual 631	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   431: pop
    //   432: aload_2
    //   433: invokevirtual 633	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   436: aload_2
    //   437: ifnull -195 -> 242
    //   440: aload_2
    //   441: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   444: goto -202 -> 242
    //   447: iload 7
    //   449: iconst_1
    //   450: iadd
    //   451: istore 7
    //   453: goto -71 -> 382
    //   456: astore_3
    //   457: aconst_null
    //   458: astore_2
    //   459: aload_2
    //   460: ifnull +7 -> 467
    //   463: aload_2
    //   464: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   467: aload_3
    //   468: athrow
    //   469: astore_3
    //   470: goto -11 -> 459
    //   473: astore_3
    //   474: goto -15 -> 459
    //   477: astore_3
    //   478: goto -277 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	this	FriendsManager
    //   0	481	1	paramInt	int
    //   42	422	2	localObject1	Object
    //   50	26	3	localObject2	Object
    //   200	31	3	localException1	Exception
    //   272	156	3	localGroups	Groups
    //   456	12	3	localObject3	Object
    //   469	1	3	localObject4	Object
    //   473	1	3	localObject5	Object
    //   477	1	3	localException2	Exception
    //   39	380	4	localArrayList	ArrayList
    //   10	247	5	localStringBuffer	StringBuffer
    //   87	76	6	localFriends	Friends
    //   64	388	7	k	int
    //   102	92	8	m	int
    //   1	378	9	n	int
    //   98	90	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   53	63	200	java/lang/Exception
    //   66	100	200	java/lang/Exception
    //   104	113	200	java/lang/Exception
    //   128	141	200	java/lang/Exception
    //   145	193	200	java/lang/Exception
    //   247	264	200	java/lang/Exception
    //   264	273	200	java/lang/Exception
    //   277	308	200	java/lang/Exception
    //   308	366	200	java/lang/Exception
    //   366	378	200	java/lang/Exception
    //   382	417	200	java/lang/Exception
    //   417	436	200	java/lang/Exception
    //   43	51	456	finally
    //   53	63	469	finally
    //   66	100	469	finally
    //   104	113	469	finally
    //   128	141	469	finally
    //   145	193	469	finally
    //   247	264	469	finally
    //   264	273	469	finally
    //   277	308	469	finally
    //   308	366	469	finally
    //   366	378	469	finally
    //   382	417	469	finally
    //   417	436	469	finally
    //   201	234	473	finally
    //   43	51	477	java/lang/Exception
  }
  
  public void a(long paramLong)
  {
    if (!Friends.isValidUin(paramLong)) {}
    String str;
    do
    {
      return;
      str = String.valueOf(paramLong);
    } while ((a(str) != 20) && (a(str) > 0));
    b(str, 10);
  }
  
  public void a(ExtensionInfo paramExtensionInfo)
  {
    if ((paramExtensionInfo == null) || (TextUtils.isEmpty(paramExtensionInfo.uin))) {}
    do
    {
      return;
      a(paramExtensionInfo);
    } while (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramExtensionInfo.uin, paramExtensionInfo);
      return;
    }
  }
  
  public void a(Friends paramFriends)
  {
    if (paramFriends != null)
    {
      ContactSorter.a(paramFriends);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
      a(paramFriends);
    }
  }
  
  public void a(Friends paramFriends, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "updateSingleFriend: " + paramFriends.uin + ", needRefreshUI=" + paramBoolean);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramFriends.uin, paramFriends);
    a(paramFriends);
    if (paramBoolean) {
      a();
    }
  }
  
  public void a(Groups paramGroups)
  {
    int n = 0;
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    int k;
    if (paramGroups.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramGroups);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramGroups.group_id + "", paramGroups);
      k = 0;
    }
    for (;;)
    {
      int m = n;
      if (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (localGroups.group_id == paramGroups.group_id)
        {
          localGroups.datetime = paramGroups.datetime;
          localGroups.group_friend_count = paramGroups.group_friend_count;
          localGroups.group_id = paramGroups.group_id;
          localGroups.group_name = paramGroups.group_name;
          localGroups.group_online_friend_count = paramGroups.group_online_friend_count;
          localGroups.seqid = paramGroups.seqid;
          localGroups.sqqOnLine_count = paramGroups.sqqOnLine_count;
          m = 1;
        }
      }
      else
      {
        if (m == 0) {
          this.jdField_a_of_type_JavaUtilArrayList = ContactSorter.a(this.jdField_a_of_type_JavaUtilArrayList, paramGroups);
        }
        a();
        return;
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramGroups);
        break;
      }
      k += 1;
    }
  }
  
  /* Error */
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +34 -> 37
    //   6: aload_1
    //   7: getfield 675	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   10: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +24 -> 37
    //   16: aload_1
    //   17: getfield 678	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   20: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +14 -> 37
    //   26: aload_1
    //   27: getfield 681	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   30: lstore_3
    //   31: lload_3
    //   32: lconst_0
    //   33: lcmp
    //   34: ifgt +6 -> 40
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: new 448	com/tencent/mobileqq/data/DateNickNameInfo
    //   43: dup
    //   44: aload_1
    //   45: getfield 678	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   48: aload_1
    //   49: getfield 681	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   52: invokespecial 684	com/tencent/mobileqq/data/DateNickNameInfo:<init>	(Ljava/lang/String;J)V
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 83	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   60: aload_1
    //   61: getfield 675	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   64: aload_2
    //   65: invokevirtual 685	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   68: pop
    //   69: goto -32 -> 37
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	FriendsManager
    //   0	77	1	paramNearbyPeopleCard	NearbyPeopleCard
    //   55	10	2	localDateNickNameInfo	DateNickNameInfo
    //   30	2	3	l	long
    // Exception table:
    //   from	to	target	type
    //   6	31	72	finally
    //   40	69	72	finally
  }
  
  public void a(NoC2CExtensionInfo paramNoC2CExtensionInfo, boolean paramBoolean)
  {
    if ((paramNoC2CExtensionInfo == null) || (paramNoC2CExtensionInfo.uin == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        continue;
      }
      synchronized (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        String str = NoC2CExtensionInfo.getNoC2Ckey(paramNoC2CExtensionInfo.type, paramNoC2CExtensionInfo.uin);
        this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramNoC2CExtensionInfo);
        if (!paramBoolean) {
          continue;
        }
        a(paramNoC2CExtensionInfo);
        return;
      }
    }
  }
  
  public void a(SpecialCareInfo paramSpecialCareInfo)
  {
    if ((paramSpecialCareInfo == null) || (paramSpecialCareInfo.uin == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo, specailCareInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "saveOrUpdateSpecialCareInfo: " + paramSpecialCareInfo.toString());
    }
    if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramSpecialCareInfo.uin, paramSpecialCareInfo);
      a(paramSpecialCareInfo);
      return;
    }
  }
  
  public void a(String paramString)
  {
    String[] arrayOfString = paramString.split("\\|");
    if (arrayOfString.length == 6) {}
    try
    {
      this.jdField_b_of_type_Int = Integer.valueOf(arrayOfString[0]).intValue();
      this.jdField_c_of_type_Int = Integer.valueOf(arrayOfString[1]).intValue();
      this.jdField_d_of_type_Int = Integer.valueOf(arrayOfString[2]).intValue();
      this.jdField_e_of_type_Int = Integer.valueOf(arrayOfString[3]).intValue();
      this.jdField_f_of_type_Int = Integer.valueOf(arrayOfString[4]).intValue();
      this.jdField_g_of_type_Int = Integer.valueOf(arrayOfString[5]).intValue();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.contacttab.", 2, paramString, localException);
    }
  }
  
  protected void a(String paramString, byte paramByte)
  {
    Card localCard = (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
    if (localCard == null)
    {
      localCard = new Card();
      localCard.uin = paramString;
      localCard.bSingle = paramByte;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
      return;
    }
    localCard.bSingle = paramByte;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
  }
  
  public void a(String paramString, int paramInt)
  {
    Friends localFriends = c(paramString);
    int k;
    Groups localGroups1;
    Groups localGroups2;
    if (localFriends != null)
    {
      k = localFriends.groupid;
      localGroups1 = a(String.valueOf(k));
      if ((k >= 0) && (localGroups1 != null))
      {
        localGroups1.group_friend_count -= 1;
        if (c(localFriends.uin)) {
          localGroups1.group_online_friend_count -= 1;
        }
      }
      localGroups2 = a(String.valueOf(paramInt));
      if (localGroups2 != null)
      {
        localGroups2.group_friend_count += 1;
        if (c(localFriends.uin)) {
          localGroups2.group_online_friend_count += 1;
        }
      }
      localFriends.groupid = paramInt;
      localObject = null;
      paramString = null;
    }
    try
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      localEntityTransaction.a();
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      a(localFriends);
      if ((k >= 0) && (localGroups1 != null))
      {
        paramString = localEntityTransaction;
        localObject = localEntityTransaction;
        a(localGroups1);
      }
      if (localGroups2 != null)
      {
        paramString = localEntityTransaction;
        localObject = localEntityTransaction;
        a(localGroups2);
      }
      paramString = localEntityTransaction;
      localObject = localEntityTransaction;
      localEntityTransaction.c();
      if (localEntityTransaction != null) {
        localEntityTransaction.b();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          localObject = paramString;
          QLog.e("Q.contacttab.group", 2, "setFriendGroup ex=", localException);
        }
        if (paramString != null) {
          paramString.b();
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label280;
      }
      ((EntityTransaction)localObject).b();
    }
    a();
  }
  
  void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (paramGetOnlineInfoResp != null)
    {
      paramString = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (paramString != null) {}
    }
    else
    {
      return;
    }
    paramString.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
    paramString.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
    paramString.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
    paramString.eNetwork = paramGetOnlineInfoResp.eNetworkType;
    paramString.netTypeIconId = paramGetOnlineInfoResp.eIconType;
    paramString.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString1 == null)) {
      return;
    }
    Friends localFriends = b(paramString1);
    localFriends.alias = paramString2;
    localFriends.datetime = System.currentTimeMillis();
    if (paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString1, paramString2);
    }
    a(localFriends);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte)
  {
    NearbyPeopleCard localNearbyPeopleCard2 = (NearbyPeopleCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { paramString1 });
    NearbyPeopleCard localNearbyPeopleCard1 = localNearbyPeopleCard2;
    if (localNearbyPeopleCard2 == null)
    {
      localNearbyPeopleCard1 = new NearbyPeopleCard();
      localNearbyPeopleCard1.uin = paramString1;
    }
    localNearbyPeopleCard1.lastUpdateNickTime = System.currentTimeMillis();
    localNearbyPeopleCard1.nickname = paramString2;
    if (paramByte != -1) {
      localNearbyPeopleCard1.gender = paramByte;
    }
    a(localNearbyPeopleCard1);
    a(localNearbyPeopleCard1);
  }
  
  public void a(String paramString1, short paramShort, String paramString2, String paramString3)
  {
    paramString1 = b(paramString1);
    paramString1.name = paramString2;
    paramString1.faceid = paramShort;
    if (paramString3 != null) {
      paramString1.signature = paramString3;
    }
    paramString1.datetime = System.currentTimeMillis();
    if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin)) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
    }
    ContactSorter.a(paramString1);
    a(paramString1);
  }
  
  protected void a(String paramString1, short paramShort1, String paramString2, String paramString3, byte paramByte1, short paramShort2, byte paramByte2)
  {
    byte b1 = 1;
    if (paramByte1 == 1) {
      return;
    }
    paramString1 = b(paramString1);
    paramString1.cSpecialFlag = paramByte1;
    paramString1.name = paramString2;
    paramString1.faceid = paramShort1;
    if (paramShort2 == 0) {
      paramByte1 = b1;
    }
    for (;;)
    {
      paramString1.gender = paramByte1;
      paramString1.age = paramByte2;
      if (paramString3 != null) {
        paramString1.signature = paramString3;
      }
      paramString1.datetime = System.currentTimeMillis();
      if (!this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1.uin)) {
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1.uin, paramString1);
      }
      ContactSorter.a(paramString1);
      a(paramString1);
      return;
      if (paramShort2 == 1) {
        paramByte1 = 2;
      } else {
        paramByte1 = 0;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      a().edit().putLong(paramString, System.currentTimeMillis()).commit();
    }
    for (;;)
    {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(105, paramBoolean, paramString);
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(0L));
      a().edit().remove(paramString).commit();
    }
  }
  
  void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      HashMap localHashMap = new HashMap(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      Object localObject1;
      Object localObject2;
      while (paramArrayList.hasNext())
      {
        localObject1 = (SimpleOnlineFriendInfo)paramArrayList.next();
        localObject2 = String.valueOf(((SimpleOnlineFriendInfo)localObject1).friendUin);
        Friends localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2);
        if (localFriends != null)
        {
          if (((SimpleOnlineFriendInfo)localObject1).isMqqOnLine != 0) {}
          for (boolean bool = true;; bool = false)
          {
            localFriends.isMqqOnLine = bool;
            localFriends.status = ((SimpleOnlineFriendInfo)localObject1).status;
            localFriends.detalStatusFlag = ((SimpleOnlineFriendInfo)localObject1).detalStatusFlag;
            localFriends.sqqOnLineState = ((SimpleOnlineFriendInfo)localObject1).sqqOnLineState;
            localFriends.isIphoneOnline = ((SimpleOnlineFriendInfo)localObject1).isIphoneOnline;
            localFriends.iTermType = ((SimpleOnlineFriendInfo)localObject1).iTermType;
            localFriends.cNetwork = ((SimpleOnlineFriendInfo)localObject1).cNetwork;
            localFriends.abilityBits = ((SimpleOnlineFriendInfo)localObject1).uAbiFlag;
            localFriends.eNetwork = ((SimpleOnlineFriendInfo)localObject1).eNetworkType;
            localFriends.netTypeIconId = ((SimpleOnlineFriendInfo)localObject1).eIconType;
            localFriends.strTermDesc = ((SimpleOnlineFriendInfo)localObject1).strTermDesc;
            localHashMap.put(localObject2, Boolean.TRUE);
            break;
          }
        }
      }
      paramArrayList = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (String)paramArrayList.next();
        localObject2 = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        if (((Boolean)localHashMap.get(localObject1) == null) && (((Friends)localObject2).isFriend()))
        {
          ((Friends)localObject2).status = 20;
          ((Friends)localObject2).isMqqOnLine = false;
          ((Friends)localObject2).sqqOnLineState = 0;
          ((Friends)localObject2).detalStatusFlag = 20;
          ((Friends)localObject2).isIphoneOnline = 0;
          ((Friends)localObject2).cNetwork = 0;
          ((Friends)localObject2).abilityBits = 0L;
          ((Friends)localObject2).eNetwork = 0;
        }
      }
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    Object localObject2;
    Friends localFriends;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(paramArrayList.size() * 12 + 48);
      ((StringBuilder)localObject1).append("saveGatherList size=").append(paramArrayList.size()).append(" startIndex=").append(paramInt).append(" uin=");
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localFriends = (Friends)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append(localFriends.uin + ",");
      }
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramArrayList.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putBoolean("everHasGatheredContacts", true).commit();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject1).a();
      if (paramInt == 0)
      {
        localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFriends = (Friends)((Iterator)localObject2).next();
          if (localFriends.gathtertype == 1)
          {
            localFriends.gathtertype = 0;
            a(localFriends);
          }
        }
      }
    }
    catch (Exception paramArrayList)
    {
      QLog.e("Q.contacttab.", 1, "saveGatherList", paramArrayList);
      return;
      this.j = 0;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Friends)paramArrayList.next();
        localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Friends)localObject2).uin);
        if (localFriends != null)
        {
          localFriends.gathtertype = 1;
          localFriends.age = ((Friends)localObject2).age;
          localFriends.smartRemark = ((Friends)localObject2).smartRemark;
          localFriends.gender = ((Friends)localObject2).gender;
          localFriends.recommReason = ((Friends)localObject2).recommReason;
          a(localFriends);
          this.j += 1;
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).b();
    }
    ((EntityTransaction)localObject1).b();
  }
  
  public void a(List paramList)
  {
    TraceUtils.a("queryFriends_" + paramList.size());
    if (paramList.size() > 0)
    {
      Object localObject = new StringBuilder("uin=? ");
      int k = 1;
      while (k < paramList.size())
      {
        ((StringBuilder)localObject).append("or uin=? ");
        k += 1;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, true, ((StringBuilder)localObject).toString(), (String[])paramList.toArray(new String[paramList.size()]), null, null, null, null);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (Friends)paramList.next();
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(((Friends)localObject).uin, localObject);
        }
      }
    }
    TraceUtils.a();
  }
  
  public void a(List paramList, long paramLong, boolean paramBoolean)
  {
    int n = 0;
    if (paramList != null) {}
    for (int k = paramList.size();; k = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "syncSpecialCareInfos: " + k + ", " + paramLong + ", " + paramBoolean);
      }
      int m;
      if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null)
      {
        localObject = this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap;
        m = 0;
        for (;;)
        {
          if (m < k) {}
          Iterator localIterator;
          try
          {
            this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(((SpecialCareInfo)paramList.get(m)).uin, paramList.get(m));
            m += 1;
          }
          finally {}
        }
        if (paramBoolean)
        {
          localIterator = this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          while (localIterator.hasNext()) {
            if (((SpecialCareInfo)((Map.Entry)localIterator.next()).getValue()).dateTime < paramLong) {
              localIterator.remove();
            }
          }
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        ((EntityTransaction)localObject).a();
        m = n;
        while (m < k)
        {
          a((Entity)paramList.get(m));
          m += 1;
        }
        if (paramBoolean)
        {
          paramList = ((SpecialCareInfo)SpecialCareInfo.class.newInstance()).getTableName();
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b("delete from " + paramList + " where dateTime<" + paramLong);
        }
        ((EntityTransaction)localObject).c();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((EntityTransaction)localObject).b();
      }
    }
  }
  
  public void a(Set paramSet)
  {
    int k;
    if (paramSet != null) {
      k = paramSet.size();
    }
    while (k > 0)
    {
      SharedPreferences.Editor localEditor = a().edit();
      paramSet = paramSet.iterator();
      for (;;)
      {
        if (paramSet.hasNext())
        {
          String str = (String)paramSet.next();
          this.jdField_a_of_type_JavaUtilHashMap.put(str, Long.valueOf(0L));
          localEditor.remove(str);
          continue;
          k = 0;
          break;
        }
      }
      localEditor.commit();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt3;
    this.jdField_e_of_type_Int = paramInt4;
    this.jdField_f_of_type_Int = paramInt5;
    this.jdField_g_of_type_Int = paramInt6;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Card localCard = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (localCard == null)
    {
      localCard = new Card();
      localCard.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localCard.vQQFaceID = paramArrayOfByte;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
      return;
    }
    localCard.vQQFaceID = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard);
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_1
    //   4: ifnull +290 -> 294
    //   7: aload_2
    //   8: ifnull +286 -> 294
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 134	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   17: invokevirtual 523	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   20: astore 4
    //   22: aload 4
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 591	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   29: new 577	java/lang/StringBuffer
    //   32: dup
    //   33: invokespecial 578	java/lang/StringBuffer:<init>	()V
    //   36: astore 4
    //   38: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +12 -> 53
    //   44: aload 4
    //   46: ldc_w 948
    //   49: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   52: pop
    //   53: iconst_0
    //   54: istore 6
    //   56: iload 6
    //   58: istore 7
    //   60: iload 8
    //   62: aload_1
    //   63: arraylength
    //   64: if_icmpge +231 -> 295
    //   67: iload 6
    //   69: istore 7
    //   71: aload_0
    //   72: aload_1
    //   73: iload 8
    //   75: baload
    //   76: invokestatic 380	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 617	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   82: astore 5
    //   84: iload 6
    //   86: istore 7
    //   88: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +75 -> 166
    //   94: iload 6
    //   96: istore 7
    //   98: aload 4
    //   100: ldc_w 950
    //   103: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   106: pop
    //   107: iload 6
    //   109: istore 7
    //   111: aload 4
    //   113: aload_1
    //   114: iload 8
    //   116: baload
    //   117: invokevirtual 586	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   120: pop
    //   121: iload 6
    //   123: istore 7
    //   125: aload 4
    //   127: ldc_w 952
    //   130: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   133: pop
    //   134: iload 6
    //   136: istore 7
    //   138: aload 4
    //   140: aload_2
    //   141: iload 8
    //   143: baload
    //   144: invokevirtual 586	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   147: pop
    //   148: aload 5
    //   150: ifnonnull +16 -> 166
    //   153: iload 6
    //   155: istore 7
    //   157: aload 4
    //   159: ldc_w 954
    //   162: invokevirtual 583	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   165: pop
    //   166: iload 6
    //   168: istore 7
    //   170: aload 5
    //   172: ifnull +225 -> 397
    //   175: iload 6
    //   177: istore 7
    //   179: aload 5
    //   181: getfield 670	com/tencent/mobileqq/data/Groups:seqid	B
    //   184: aload_2
    //   185: iload 8
    //   187: baload
    //   188: if_icmpne +10 -> 198
    //   191: iload 6
    //   193: istore 7
    //   195: goto +202 -> 397
    //   198: iload 6
    //   200: istore 7
    //   202: aload 5
    //   204: aload_2
    //   205: iload 8
    //   207: baload
    //   208: putfield 670	com/tencent/mobileqq/data/Groups:seqid	B
    //   211: iconst_1
    //   212: istore 6
    //   214: iconst_1
    //   215: istore 7
    //   217: aload_0
    //   218: aload 5
    //   220: invokevirtual 623	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   223: pop
    //   224: iload 6
    //   226: istore 7
    //   228: goto +169 -> 397
    //   231: astore_2
    //   232: aload_3
    //   233: astore_1
    //   234: iload 7
    //   236: istore 6
    //   238: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +32 -> 273
    //   244: ldc 26
    //   246: iconst_2
    //   247: new 143	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 956
    //   257: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_2
    //   261: invokevirtual 959	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   264: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload_1
    //   274: ifnull +116 -> 390
    //   277: aload_1
    //   278: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   281: iload 6
    //   283: istore 7
    //   285: iload 7
    //   287: ifeq +7 -> 294
    //   290: aload_0
    //   291: invokevirtual 961	com/tencent/mobileqq/app/FriendsManager:d	()V
    //   294: return
    //   295: iload 6
    //   297: istore 7
    //   299: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +18 -> 320
    //   305: iload 6
    //   307: istore 7
    //   309: ldc 26
    //   311: iconst_2
    //   312: aload 4
    //   314: invokevirtual 615	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   317: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: iload 6
    //   322: istore 7
    //   324: aload_3
    //   325: invokevirtual 633	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   328: iload 6
    //   330: istore 7
    //   332: aload_3
    //   333: ifnull -48 -> 285
    //   336: aload_3
    //   337: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   340: iload 6
    //   342: istore 7
    //   344: goto -59 -> 285
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_3
    //   350: aload_3
    //   351: ifnull +7 -> 358
    //   354: aload_3
    //   355: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   358: aload_1
    //   359: athrow
    //   360: astore_1
    //   361: goto -11 -> 350
    //   364: astore_2
    //   365: aload_1
    //   366: astore_3
    //   367: aload_2
    //   368: astore_1
    //   369: goto -19 -> 350
    //   372: astore_2
    //   373: iconst_0
    //   374: istore 6
    //   376: aload_3
    //   377: astore_1
    //   378: goto -140 -> 238
    //   381: astore_2
    //   382: aload_3
    //   383: astore_1
    //   384: iconst_0
    //   385: istore 6
    //   387: goto -149 -> 238
    //   390: iload 6
    //   392: istore 7
    //   394: goto -109 -> 285
    //   397: iload 8
    //   399: iconst_1
    //   400: iadd
    //   401: istore 8
    //   403: iload 7
    //   405: istore 6
    //   407: goto -351 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	FriendsManager
    //   0	410	1	paramArrayOfByte1	byte[]
    //   0	410	2	paramArrayOfByte2	byte[]
    //   12	371	3	localObject1	Object
    //   20	293	4	localObject2	Object
    //   82	137	5	localGroups	Groups
    //   54	352	6	k	int
    //   58	346	7	m	int
    //   1	401	8	n	int
    // Exception table:
    //   from	to	target	type
    //   60	67	231	java/lang/Exception
    //   71	84	231	java/lang/Exception
    //   88	94	231	java/lang/Exception
    //   98	107	231	java/lang/Exception
    //   111	121	231	java/lang/Exception
    //   125	134	231	java/lang/Exception
    //   138	148	231	java/lang/Exception
    //   157	166	231	java/lang/Exception
    //   179	191	231	java/lang/Exception
    //   202	211	231	java/lang/Exception
    //   217	224	231	java/lang/Exception
    //   299	305	231	java/lang/Exception
    //   309	320	231	java/lang/Exception
    //   324	328	231	java/lang/Exception
    //   13	22	347	finally
    //   25	53	360	finally
    //   60	67	360	finally
    //   71	84	360	finally
    //   88	94	360	finally
    //   98	107	360	finally
    //   111	121	360	finally
    //   125	134	360	finally
    //   138	148	360	finally
    //   157	166	360	finally
    //   179	191	360	finally
    //   202	211	360	finally
    //   217	224	360	finally
    //   299	305	360	finally
    //   309	320	360	finally
    //   324	328	360	finally
    //   238	273	364	finally
    //   13	22	372	java/lang/Exception
    //   25	53	381	java/lang/Exception
  }
  
  void a(Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean)
  {
    int k;
    if (paramArrayOfFriends != null) {
      k = paramArrayOfFriends.length;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "saveFriendsList: " + k + ", " + paramLong + ", " + paramBoolean);
      }
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      try
      {
        localEntityTransaction.a();
        int m = 0;
        while (m < k)
        {
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayOfFriends[m].uin, paramArrayOfFriends[m]);
          a(paramArrayOfFriends[m]);
          m += 1;
        }
        if (paramBoolean)
        {
          Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Friends localFriends = (Friends)((Map.Entry)localIterator.next()).getValue();
            if ((localFriends.datetime < paramLong) && (localFriends.isFriend()))
            {
              localIterator.remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localFriends);
            }
          }
        }
        k = -1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localEntityTransaction.b();
        for (;;)
        {
          if (k > 0) {
            a(paramArrayOfFriends);
          }
          return;
          localEntityTransaction.c();
          localEntityTransaction.b();
        }
      }
      finally
      {
        localEntityTransaction.b();
      }
    }
  }
  
  /* Error */
  void a(Groups[] paramArrayOfGroups)
  {
    // Byte code:
    //   0: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +40 -> 43
    //   6: new 143	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 969
    //   16: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore_2
    //   20: aload_1
    //   21: ifnull +32 -> 53
    //   24: aload_1
    //   25: arraylength
    //   26: istore 6
    //   28: ldc 20
    //   30: iconst_2
    //   31: aload_2
    //   32: iload 6
    //   34: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_1
    //   44: ifnull +8 -> 52
    //   47: aload_1
    //   48: arraylength
    //   49: ifne +10 -> 59
    //   52: return
    //   53: iconst_m1
    //   54: istore 6
    //   56: goto -28 -> 28
    //   59: new 231	java/util/ArrayList
    //   62: dup
    //   63: aload_1
    //   64: arraylength
    //   65: invokespecial 970	java/util/ArrayList:<init>	(I)V
    //   68: astore_3
    //   69: new 57	java/util/concurrent/ConcurrentHashMap
    //   72: dup
    //   73: aload_1
    //   74: arraylength
    //   75: invokespecial 74	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   78: astore 4
    //   80: aload_0
    //   81: getfield 134	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   84: invokevirtual 523	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 591	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   92: iconst_0
    //   93: istore 6
    //   95: iload 6
    //   97: aload_1
    //   98: arraylength
    //   99: if_icmpge +65 -> 164
    //   102: aload 4
    //   104: new 143	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   111: aload_1
    //   112: iload 6
    //   114: aaload
    //   115: getfield 246	com/tencent/mobileqq/data/Groups:group_id	I
    //   118: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc -31
    //   123: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: aload_1
    //   130: iload 6
    //   132: aaload
    //   133: invokevirtual 236	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   136: pop
    //   137: aload_3
    //   138: aload_1
    //   139: iload 6
    //   141: aaload
    //   142: invokevirtual 256	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   145: pop
    //   146: aload_0
    //   147: aload_1
    //   148: iload 6
    //   150: aaload
    //   151: invokevirtual 623	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   154: pop
    //   155: iload 6
    //   157: iconst_1
    //   158: iadd
    //   159: istore 6
    //   161: goto -66 -> 95
    //   164: aload_1
    //   165: arraylength
    //   166: iconst_1
    //   167: if_icmple +10 -> 177
    //   170: aload_3
    //   171: getstatic 563	com/tencent/mobileqq/app/ContactSorter:a	Ljava/util/Comparator;
    //   174: invokestatic 569	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   177: aload_0
    //   178: getfield 359	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   181: ifnull +112 -> 293
    //   184: aload_0
    //   185: getfield 359	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   188: invokevirtual 177	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   191: invokeinterface 183 1 0
    //   196: astore_1
    //   197: aload_1
    //   198: invokeinterface 188 1 0
    //   203: ifeq +90 -> 293
    //   206: aload_1
    //   207: invokeinterface 192 1 0
    //   212: checkcast 194	java/util/Map$Entry
    //   215: astore 5
    //   217: aload 4
    //   219: aload 5
    //   221: invokeinterface 973 1 0
    //   226: checkcast 208	java/lang/String
    //   229: invokevirtual 502	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   232: ifne -35 -> 197
    //   235: aload_0
    //   236: getfield 134	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   239: aload 5
    //   241: invokeinterface 197 1 0
    //   246: checkcast 241	com/tencent/mobileqq/persistence/Entity
    //   249: invokevirtual 631	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   252: pop
    //   253: goto -56 -> 197
    //   256: astore_1
    //   257: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +13 -> 273
    //   263: ldc 26
    //   265: iconst_2
    //   266: ldc_w 975
    //   269: aload_1
    //   270: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   273: aload_2
    //   274: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   277: aload_0
    //   278: aload_3
    //   279: putfield 238	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   282: aload_0
    //   283: aload 4
    //   285: putfield 359	com/tencent/mobileqq/app/FriendsManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   288: aload_0
    //   289: invokevirtual 313	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   292: return
    //   293: aload_2
    //   294: invokevirtual 633	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   297: aload_2
    //   298: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   301: goto -24 -> 277
    //   304: astore_1
    //   305: aload_2
    //   306: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   309: aload_1
    //   310: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	FriendsManager
    //   0	311	1	paramArrayOfGroups	Groups[]
    //   19	287	2	localObject	Object
    //   68	211	3	localArrayList	ArrayList
    //   78	206	4	localConcurrentHashMap	ConcurrentHashMap
    //   215	25	5	localEntry	Map.Entry
    //   26	134	6	k	int
    // Exception table:
    //   from	to	target	type
    //   88	92	256	java/lang/Exception
    //   95	155	256	java/lang/Exception
    //   164	177	256	java/lang/Exception
    //   177	197	256	java/lang/Exception
    //   197	253	256	java/lang/Exception
    //   293	297	256	java/lang/Exception
    //   88	92	304	finally
    //   95	155	304	finally
    //   164	177	304	finally
    //   177	197	304	finally
    //   197	253	304	finally
    //   257	273	304	finally
    //   293	297	304	finally
  }
  
  public boolean a()
  {
    boolean bool = b();
    e();
    this.jdField_c_of_type_Boolean = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    this.jdField_d_of_type_Boolean = SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1);
    a(SharedPreUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
    return bool;
  }
  
  public boolean a(Card paramCard)
  {
    return a(paramCard);
  }
  
  public boolean a(ContactCard paramContactCard)
  {
    return a(paramContactCard);
  }
  
  protected boolean a(Friends paramFriends)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramFriends.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramFriends);
        if (paramFriends.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return bool;
      } while ((paramFriends.getStatus() != 1001) && (paramFriends.getStatus() != 1002));
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramFriends);
    }
    QLog.d("Q.contacttab.friend", 2, "updateFriendEntity em closed f=" + paramFriends.uin);
    return false;
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
    QLog.d("Q.contacttab.friend", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList begin");
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Groups.class, false, "group_id=?", new String[] { "-1002" }, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friends localFriends = (Friends)((Iterator)localObject).next();
          this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, "");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "initBlackList end, size=" + this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      }
    }
    return this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
  }
  
  /* Error */
  protected boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +49 -> 55
    //   9: ldc 26
    //   11: iconst_2
    //   12: new 143	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1013
    //   22: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 283
    //   32: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_2
    //   36: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 283
    //   42: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload_3
    //   46: invokevirtual 655	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_0
    //   56: getfield 134	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   59: invokevirtual 523	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   62: astore 5
    //   64: aload 5
    //   66: astore 6
    //   68: aload 5
    //   70: invokevirtual 591	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   73: aload 5
    //   75: astore 6
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 493	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   82: astore 7
    //   84: aload 5
    //   86: astore 6
    //   88: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +48 -> 139
    //   94: aload 5
    //   96: astore 6
    //   98: ldc_w 877
    //   101: iconst_2
    //   102: new 143	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 1015
    //   112: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc_w 1017
    //   122: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 7
    //   127: getfield 203	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   130: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload 5
    //   141: astore 6
    //   143: aload_0
    //   144: aload_1
    //   145: invokevirtual 1018	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Z
    //   148: ifeq +12 -> 160
    //   151: aload 5
    //   153: astore 6
    //   155: aload_0
    //   156: aload_1
    //   157: invokevirtual 1020	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)V
    //   160: aload 5
    //   162: astore 6
    //   164: aload 7
    //   166: getfield 220	com/tencent/mobileqq/data/Friends:groupid	I
    //   169: iconst_m1
    //   170: if_icmpne +341 -> 511
    //   173: aload 5
    //   175: astore 6
    //   177: aload 7
    //   179: iload_2
    //   180: putfield 220	com/tencent/mobileqq/data/Friends:groupid	I
    //   183: iconst_m1
    //   184: istore 9
    //   186: iconst_1
    //   187: istore 11
    //   189: aload 5
    //   191: astore 6
    //   193: aload 7
    //   195: invokestatic 371	java/lang/System:currentTimeMillis	()J
    //   198: putfield 499	com/tencent/mobileqq/data/Friends:datetime	J
    //   201: iload_3
    //   202: ifeq +99 -> 301
    //   205: aload 5
    //   207: astore 6
    //   209: aload 7
    //   211: iconst_1
    //   212: putfield 203	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   215: aload 5
    //   217: astore 6
    //   219: aload 7
    //   221: ldc_w 1022
    //   224: putfield 891	com/tencent/mobileqq/data/Friends:recommReason	Ljava/lang/String;
    //   227: aload 5
    //   229: astore 6
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 290	com/tencent/mobileqq/app/FriendsManager:j	I
    //   236: iconst_1
    //   237: iadd
    //   238: putfield 290	com/tencent/mobileqq/app/FriendsManager:j	I
    //   241: aload 5
    //   243: astore 6
    //   245: aload_0
    //   246: aload 7
    //   248: getfield 296	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   251: invokevirtual 941	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   254: astore 8
    //   256: aload 8
    //   258: ifnull +43 -> 301
    //   261: aload 5
    //   263: astore 6
    //   265: aload 8
    //   267: getfield 1025	com/tencent/mobileqq/data/Card:shGender	S
    //   270: ifne +268 -> 538
    //   273: iconst_1
    //   274: istore 4
    //   276: aload 5
    //   278: astore 6
    //   280: aload 7
    //   282: iload 4
    //   284: putfield 787	com/tencent/mobileqq/data/Friends:gender	B
    //   287: aload 5
    //   289: astore 6
    //   291: aload 7
    //   293: aload 8
    //   295: getfield 1027	com/tencent/mobileqq/data/Card:age	B
    //   298: putfield 790	com/tencent/mobileqq/data/Friends:age	I
    //   301: aload 5
    //   303: astore 6
    //   305: aload_0
    //   306: aload 7
    //   308: invokevirtual 623	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   311: pop
    //   312: aload 5
    //   314: astore 6
    //   316: aload_0
    //   317: iload_2
    //   318: invokestatic 380	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   321: invokevirtual 617	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   324: astore 7
    //   326: aload 7
    //   328: ifnull +61 -> 389
    //   331: aload 5
    //   333: astore 6
    //   335: aload 7
    //   337: aload 7
    //   339: getfield 249	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   342: iconst_1
    //   343: iadd
    //   344: putfield 249	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   347: aload 5
    //   349: astore 6
    //   351: aload_0
    //   352: aload_1
    //   353: invokevirtual 593	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   356: ifeq +19 -> 375
    //   359: aload 5
    //   361: astore 6
    //   363: aload 7
    //   365: aload 7
    //   367: getfield 620	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   370: iconst_1
    //   371: iadd
    //   372: putfield 620	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   375: aload 5
    //   377: astore 6
    //   379: aload_0
    //   380: getfield 134	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   383: aload 7
    //   385: invokevirtual 674	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   388: pop
    //   389: iload 11
    //   391: ifne +89 -> 480
    //   394: iload 9
    //   396: iflt +84 -> 480
    //   399: iload 9
    //   401: iload_2
    //   402: if_icmpeq +78 -> 480
    //   405: aload 5
    //   407: astore 6
    //   409: aload_0
    //   410: iload 9
    //   412: invokestatic 380	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   415: invokevirtual 617	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Groups;
    //   418: astore 7
    //   420: aload 7
    //   422: ifnull +58 -> 480
    //   425: aload 5
    //   427: astore 6
    //   429: aload 7
    //   431: aload 7
    //   433: getfield 249	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   436: iconst_1
    //   437: isub
    //   438: putfield 249	com/tencent/mobileqq/data/Groups:group_friend_count	I
    //   441: aload 5
    //   443: astore 6
    //   445: aload_0
    //   446: aload_1
    //   447: invokevirtual 593	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Z
    //   450: ifeq +19 -> 469
    //   453: aload 5
    //   455: astore 6
    //   457: aload 7
    //   459: aload 7
    //   461: getfield 620	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   464: iconst_1
    //   465: isub
    //   466: putfield 620	com/tencent/mobileqq/data/Groups:group_online_friend_count	I
    //   469: aload 5
    //   471: astore 6
    //   473: aload_0
    //   474: aload 7
    //   476: invokevirtual 623	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   479: pop
    //   480: aload 5
    //   482: astore 6
    //   484: aload 5
    //   486: invokevirtual 633	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   489: iload 11
    //   491: istore_3
    //   492: aload 5
    //   494: ifnull +11 -> 505
    //   497: aload 5
    //   499: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   502: iload 11
    //   504: istore_3
    //   505: aload_0
    //   506: invokevirtual 313	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   509: iload_3
    //   510: ireturn
    //   511: aload 5
    //   513: astore 6
    //   515: aload 7
    //   517: getfield 220	com/tencent/mobileqq/data/Friends:groupid	I
    //   520: istore 9
    //   522: aload 5
    //   524: astore 6
    //   526: aload 7
    //   528: iload_2
    //   529: putfield 220	com/tencent/mobileqq/data/Friends:groupid	I
    //   532: iconst_0
    //   533: istore 11
    //   535: goto -346 -> 189
    //   538: aload 5
    //   540: astore 6
    //   542: aload 8
    //   544: getfield 1025	com/tencent/mobileqq/data/Card:shGender	S
    //   547: istore 10
    //   549: iload 10
    //   551: iconst_1
    //   552: if_icmpne -276 -> 276
    //   555: iconst_2
    //   556: istore 4
    //   558: goto -282 -> 276
    //   561: astore_1
    //   562: aconst_null
    //   563: astore 5
    //   565: iconst_0
    //   566: istore 11
    //   568: aload 5
    //   570: astore 6
    //   572: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +17 -> 592
    //   578: aload 5
    //   580: astore 6
    //   582: ldc 26
    //   584: iconst_2
    //   585: ldc_w 1029
    //   588: aload_1
    //   589: invokestatic 612	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   592: iload 11
    //   594: istore_3
    //   595: aload 5
    //   597: ifnull -92 -> 505
    //   600: aload 5
    //   602: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   605: iload 11
    //   607: istore_3
    //   608: goto -103 -> 505
    //   611: astore_1
    //   612: aconst_null
    //   613: astore 6
    //   615: aload 6
    //   617: ifnull +8 -> 625
    //   620: aload 6
    //   622: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   625: aload_1
    //   626: athrow
    //   627: astore_1
    //   628: goto -13 -> 615
    //   631: astore_1
    //   632: iconst_0
    //   633: istore 11
    //   635: goto -67 -> 568
    //   638: astore_1
    //   639: goto -71 -> 568
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	this	FriendsManager
    //   0	642	1	paramString	String
    //   0	642	2	paramInt	int
    //   0	642	3	paramBoolean	boolean
    //   1	556	4	b1	byte
    //   62	539	5	localEntityTransaction1	EntityTransaction
    //   66	555	6	localEntityTransaction2	EntityTransaction
    //   82	445	7	localObject	Object
    //   254	289	8	localCard	Card
    //   184	337	9	k	int
    //   547	6	10	m	int
    //   187	447	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   55	64	561	java/lang/Exception
    //   55	64	611	finally
    //   68	73	627	finally
    //   77	84	627	finally
    //   88	94	627	finally
    //   98	139	627	finally
    //   143	151	627	finally
    //   155	160	627	finally
    //   164	173	627	finally
    //   177	183	627	finally
    //   193	201	627	finally
    //   209	215	627	finally
    //   219	227	627	finally
    //   231	241	627	finally
    //   245	256	627	finally
    //   265	273	627	finally
    //   280	287	627	finally
    //   291	301	627	finally
    //   305	312	627	finally
    //   316	326	627	finally
    //   335	347	627	finally
    //   351	359	627	finally
    //   363	375	627	finally
    //   379	389	627	finally
    //   409	420	627	finally
    //   429	441	627	finally
    //   445	453	627	finally
    //   457	469	627	finally
    //   473	480	627	finally
    //   484	489	627	finally
    //   515	522	627	finally
    //   526	532	627	finally
    //   542	549	627	finally
    //   572	578	627	finally
    //   582	592	627	finally
    //   68	73	631	java/lang/Exception
    //   77	84	631	java/lang/Exception
    //   88	94	631	java/lang/Exception
    //   98	139	631	java/lang/Exception
    //   143	151	631	java/lang/Exception
    //   155	160	631	java/lang/Exception
    //   164	173	631	java/lang/Exception
    //   177	183	631	java/lang/Exception
    //   515	522	631	java/lang/Exception
    //   526	532	631	java/lang/Exception
    //   193	201	638	java/lang/Exception
    //   209	215	638	java/lang/Exception
    //   219	227	638	java/lang/Exception
    //   231	241	638	java/lang/Exception
    //   245	256	638	java/lang/Exception
    //   265	273	638	java/lang/Exception
    //   280	287	638	java/lang/Exception
    //   291	301	638	java/lang/Exception
    //   305	312	638	java/lang/Exception
    //   316	326	638	java/lang/Exception
    //   335	347	638	java/lang/Exception
    //   351	359	638	java/lang/Exception
    //   363	375	638	java/lang/Exception
    //   379	389	638	java/lang/Exception
    //   409	420	638	java/lang/Exception
    //   429	441	638	java/lang/Exception
    //   445	453	638	java/lang/Exception
    //   457	469	638	java/lang/Exception
    //   473	480	638	java/lang/Exception
    //   484	489	638	java/lang/Exception
    //   542	549	638	java/lang/Exception
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      l2 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue();
    }
    while (l2 == 0L)
    {
      return false;
      l2 = a().getLong(paramString, 0L);
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (paramString.startsWith("+")) {
          l1 = a().getLong(paramString.replace("+", ""), 0L);
        }
      }
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (paramString.startsWith("+86")) {
          l2 = a().getLong(paramString.replace("+86", ""), 0L);
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(l2));
    }
    long l2 = System.currentTimeMillis() - l2;
    if (paramBoolean) {}
    for (long l1 = 259200000L; (l2 > 0L) && (l2 < l1); l1 = 500654080L) {
      return true;
    }
    a().edit().remove(paramString).commit();
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(0L));
    return false;
  }
  
  public boolean a(Friends[] paramArrayOfFriends, int paramInt)
  {
    if ((paramArrayOfFriends == null) || (paramArrayOfFriends.length == 0)) {
      return true;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      int k = 0;
      while (k < paramInt)
      {
        ContactSorter.a(paramArrayOfFriends[k]);
        a(paramArrayOfFriends[k]);
        k += 1;
      }
      localEntityTransaction.c();
      return true;
    }
    catch (Exception paramArrayOfFriends)
    {
      paramArrayOfFriends.printStackTrace();
      return true;
    }
    finally
    {
      localEntityTransaction.b();
    }
  }
  
  public int b()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public int b(String paramString)
  {
    int m = 0;
    int k;
    if ((paramString == null) || (paramString.length() == 0)) {
      k = -1;
    }
    do
    {
      do
      {
        return k;
        k = m;
      } while (this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap == null);
      k = m;
    } while (!this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString));
    return ((Integer)this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).intValue();
  }
  
  public int b(String paramString, ExtensionInfo paramExtensionInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (paramExtensionInfo == null) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_Q.contacttab.", 2, "getInteractionType|uin=" + paramString + ",level=" + paramExtensionInfo.chatHotLevel + ",days=" + paramExtensionInfo.chatDays);
    }
    return paramExtensionInfo.chatHotLevel;
  }
  
  public Card b(String paramString)
  {
    Card localCard2 = (Card)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Card.class, paramString);
    Card localCard1 = localCard2;
    if (localCard2 == null)
    {
      localCard1 = new Card();
      localCard1.uin = paramString;
      localCard1.shGender = -1;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCard1);
    }
    return localCard1;
  }
  
  public ContactCard b(String paramString)
  {
    ContactCard localContactCard2 = (ContactCard)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ContactCard.class, paramString);
    ContactCard localContactCard1 = localContactCard2;
    if (localContactCard2 == null)
    {
      localContactCard1 = new ContactCard();
      localContactCard1.mobileNo = paramString;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localContactCard1);
    }
    return localContactCard1;
  }
  
  public Friends b(String paramString)
  {
    Friends localFriends2 = c(paramString);
    Friends localFriends1 = localFriends2;
    if (localFriends2 == null)
    {
      localFriends1 = new Friends();
      localFriends1.uin = paramString;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localFriends1);
      a(localFriends1);
    }
    return localFriends1;
  }
  
  public Friends b(String paramString1, String paramString2)
  {
    Friends localFriends = b(paramString1);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (!paramString1.equals(localFriends.remark))
    {
      localFriends.remark = paramString1;
      localFriends.datetime = System.currentTimeMillis();
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFriends.uin, localFriends);
      ContactSorter.a(localFriends);
      a(localFriends);
      a();
    }
    return localFriends;
  }
  
  public ArrayList b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      e();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List b()
  {
    List localList = a();
    if (localList != null) {
      Collections.sort(localList, new pye(this));
    }
    return localList;
  }
  
  public ConcurrentHashMap b()
  {
    return a(false);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache begin");
    }
    if (!this.jdField_b_of_type_Boolean) {
      if (!this.jdField_b_of_type_Boolean) {}
    }
    while (!QLog.isColorLevel())
    {
      return;
      ??? = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ExtensionInfo.class);
      if (??? != null)
      {
        Iterator localIterator = ((ArrayList)???).iterator();
        while (localIterator.hasNext())
        {
          ExtensionInfo localExtensionInfo = (ExtensionInfo)localIterator.next();
          if ((localExtensionInfo != null) && (localExtensionInfo.uin != null)) {
            synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
            {
              this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localExtensionInfo.uin, localExtensionInfo);
            }
          }
        }
      }
      f();
      this.jdField_b_of_type_Boolean = true;
    }
    QLog.d("Q.contacttab.friend", 2, "initExtensionInfoCache end: " + this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size());
  }
  
  public void b(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    if ((QLog.isColorLevel()) && (!TextUtils.isEmpty(paramString)) && (paramString.length() > 3)) {
      QLog.d("Q.contacttab.", 2, "add friend to black list " + paramString.substring(0, 2));
    }
    if (this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, "");
    }
    localObject2 = null;
    localObject1 = null;
    try
    {
      EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.a();
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      Friends localFriends = b(paramString);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      if (localFriends.groupid >= 0)
      {
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        Groups localGroups = a(String.valueOf(localFriends.groupid));
        if (localGroups != null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localGroups.group_friend_count -= 1;
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          if (c(paramString))
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            localGroups.group_online_friend_count -= 1;
          }
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          a(localGroups);
        }
      }
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localFriends.groupid = 64534;
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localFriends.uin);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      a(localFriends);
      localObject1 = localEntityTransaction;
      localObject2 = localEntityTransaction;
      localEntityTransaction.c();
      if (localEntityTransaction != null) {
        localEntityTransaction.b();
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          QLog.e("Q.contacttab.group", 2, "addFriendToBlackList ex", paramString);
        }
        if (localObject1 != null) {
          ((EntityTransaction)localObject1).b();
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label322;
      }
      ((EntityTransaction)localObject2).b();
    }
    a();
  }
  
  void b(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if (paramString != null) {
      paramString.status = ((byte)paramInt);
    }
  }
  
  public void b(ArrayList paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, " FriendsManger saveRecommGatherList  list size : " + paramArrayList.size());
    }
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramArrayList.iterator();
    Friends localFriends;
    while (((Iterator)localObject2).hasNext())
    {
      localFriends = (Friends)((Iterator)localObject2).next();
      ((StringBuilder)localObject1).append(localFriends.uin + ",");
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, " FriendsManger saveRecommGatherList : " + ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      ((EntityTransaction)localObject1).a();
      if (paramInt == 0)
      {
        localObject2 = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localFriends = (Friends)((Iterator)localObject2).next();
          if (localFriends.gathtertype == 2) {
            localFriends.gathtertype = 0;
          }
          a(localFriends);
        }
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Friends)paramArrayList.next();
        localFriends = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Friends)localObject2).uin);
        if (localFriends != null)
        {
          localFriends.gathtertype = 2;
          localFriends.age = ((Friends)localObject2).age;
          localFriends.smartRemark = ((Friends)localObject2).smartRemark;
          localFriends.gender = ((Friends)localObject2).gender;
          localFriends.recommReason = ((Friends)localObject2).recommReason;
          a(localFriends);
        }
      }
    }
    finally
    {
      ((EntityTransaction)localObject1).b();
    }
    ((EntityTransaction)localObject1).b();
  }
  
  public void b(List arg1)
  {
    if ((??? == null) || (???.size() == 0)) {}
    for (;;)
    {
      return;
      if (???.size() == 1)
      {
        a((ExtensionInfo)???.get(0));
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject1).a();
      try
      {
        Iterator localIterator = ???.iterator();
        while (localIterator.hasNext())
        {
          ExtensionInfo localExtensionInfo2 = (ExtensionInfo)localIterator.next();
          if (!TextUtils.isEmpty(localExtensionInfo2.uin)) {
            a(localExtensionInfo2);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.extension", 2, "bulk insert exception: " + localException.getMessage());
        }
        ((EntityTransaction)localObject1).b();
        for (;;)
        {
          localObject1 = ???.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ExtensionInfo localExtensionInfo1 = (ExtensionInfo)((Iterator)localObject1).next();
            if ((!TextUtils.isEmpty(localExtensionInfo1.uin)) && (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
              synchronized (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap)
              {
                this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(localExtensionInfo1.uin, localExtensionInfo1);
              }
            }
          }
          ((EntityTransaction)localObject2).c();
          ((EntityTransaction)localObject2).b();
        }
      }
      finally
      {
        ((EntityTransaction)localObject2).b();
      }
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache begin");
    }
    localObject2 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
    int k;
    ConcurrentHashMap localConcurrentHashMap;
    StringBuilder localStringBuilder;
    ArrayList localArrayList;
    label117:
    Friends localFriends;
    if (localObject2 != null)
    {
      k = ((ArrayList)localObject2).size();
      localConcurrentHashMap = new ConcurrentHashMap(k);
      this.jdField_i_of_type_Int = 0;
      localStringBuilder = new StringBuilder();
      new ArrayList();
      if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
        break label346;
      }
      localArrayList = new ArrayList();
      k = 0;
      if (k >= ((ArrayList)localObject2).size()) {
        break label276;
      }
      localFriends = (Friends)((ArrayList)localObject2).get(k);
      if ((localFriends.mCompareSpell == null) || (localFriends.mCompareSpell.length() == 0))
      {
        ContactSorter.a(localFriends);
        localArrayList.add(localFriends);
      }
      localConcurrentHashMap.put(localFriends.uin, localFriends);
      if (localFriends.gathtertype == 1) {
        localStringBuilder.append(localFriends.uin + ";");
      }
      if (localFriends.gathtertype != 2) {
        break label254;
      }
      this.jdField_i_of_type_Int += 1;
    }
    for (;;)
    {
      k += 1;
      break label117;
      k = 0;
      break;
      label254:
      if (localFriends.gathtertype == 1) {
        this.j += 1;
      }
    }
    label276:
    if (localArrayList.size() > 0)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
      ((EntityTransaction)localObject2).a();
      k = 0;
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
        label346:
        ((EntityTransaction)localObject2).b();
      }
    }
    finally
    {
      ((EntityTransaction)localObject2).b();
    }
    localArrayList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initFriendCache end: " + localConcurrentHashMap.size());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "mRecomCount: " + this.jdField_i_of_type_Int + " ; mGatheredCount = " + this.j + " ; initFriendCache gathered : " + localStringBuilder);
    }
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
    this.jdField_a_of_type_Boolean = true;
    if (localConcurrentHashMap.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean b(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.isFriend();
    }
    return false;
  }
  
  public int c()
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    int k = 0;
    if (localIterator.hasNext())
    {
      if (!((Friends)localIterator.next()).isFriend()) {
        break label51;
      }
      k += 1;
    }
    label51:
    for (;;)
    {
      break;
      return k;
    }
  }
  
  public int c(String paramString, ExtensionInfo paramExtensionInfo, boolean paramBoolean)
  {
    if (paramBoolean) {}
    while (paramExtensionInfo == null) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_Q.contacttab.", 2, "getmLikeType|uin=" + paramString + ",level=" + paramExtensionInfo.praiseHotLevel + ",days=" + paramExtensionInfo.praiseDays);
    }
    return paramExtensionInfo.praiseHotLevel;
  }
  
  public Friends c(String paramString)
  {
    Object localObject2;
    if (!f(paramString)) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return (Friends)localObject2;
      localObject2 = a(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.contacttab.", 2, "findFriendEntityByUin from db isFriendCacheInited=" + this.jdField_a_of_type_Boolean + " f=" + localObject2 + " uin=" + paramString);
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
    } while (localObject1 == null);
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
    return (Friends)localObject1;
  }
  
  public ArrayList c()
  {
    ArrayList localArrayList = new ArrayList(16);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Groups)localIterator.next();
        localObject = (List)this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(((Groups)localObject).group_id));
        if (localObject != null) {
          localArrayList.addAll((Collection)localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public ConcurrentHashMap c()
  {
    return a(true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache begin");
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(SpecialCareInfo.class, false, "globalSwitch!=?", new String[] { "0" }, null, null, null, null);
      if (localObject1 != null) {
        synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            SpecialCareInfo localSpecialCareInfo = (SpecialCareInfo)((Iterator)localObject1).next();
            if ((localSpecialCareInfo != null) && (localSpecialCareInfo.uin != null)) {
              this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(localSpecialCareInfo.uin, localSpecialCareInfo);
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "initSpecialCareInfoCache end: " + this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_i_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
    paramString = b(paramString);
    paramString.groupid = -1;
    a(paramString);
  }
  
  /* Error */
  public void c(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 553 1 0
    //   10: ifne +19 -> 29
    //   13: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +12 -> 28
    //   19: ldc 20
    //   21: iconst_2
    //   22: ldc_w 1145
    //   25: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: return
    //   29: aload_1
    //   30: invokeinterface 553 1 0
    //   35: iconst_1
    //   36: if_icmpne +18 -> 54
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_0
    //   42: invokeinterface 915 2 0
    //   47: checkcast 517	com/tencent/mobileqq/data/SpecialCareInfo
    //   50: invokevirtual 1147	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/SpecialCareInfo;)V
    //   53: return
    //   54: aload_0
    //   55: getfield 85	com/tencent/mobileqq/app/FriendsManager:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   58: ifnull +73 -> 131
    //   61: aload_0
    //   62: getfield 85	com/tencent/mobileqq/app/FriendsManager:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   65: astore_2
    //   66: aload_2
    //   67: monitorenter
    //   68: aload_1
    //   69: invokeinterface 560 1 0
    //   74: astore_3
    //   75: aload_3
    //   76: invokeinterface 188 1 0
    //   81: ifeq +48 -> 129
    //   84: aload_3
    //   85: invokeinterface 192 1 0
    //   90: checkcast 517	com/tencent/mobileqq/data/SpecialCareInfo
    //   93: astore 4
    //   95: aload 4
    //   97: getfield 688	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   100: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne -28 -> 75
    //   106: aload_0
    //   107: getfield 85	com/tencent/mobileqq/app/FriendsManager:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   110: aload 4
    //   112: getfield 688	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   115: aload 4
    //   117: invokevirtual 236	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: goto -46 -> 75
    //   124: astore_1
    //   125: aload_2
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: aload_2
    //   130: monitorexit
    //   131: aload_0
    //   132: getfield 134	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   135: invokevirtual 523	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 591	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   143: aload_1
    //   144: invokeinterface 560 1 0
    //   149: astore_1
    //   150: aload_1
    //   151: invokeinterface 188 1 0
    //   156: ifeq +108 -> 264
    //   159: aload_1
    //   160: invokeinterface 192 1 0
    //   165: checkcast 517	com/tencent/mobileqq/data/SpecialCareInfo
    //   168: astore_3
    //   169: aload_3
    //   170: getfield 688	com/tencent/mobileqq/data/SpecialCareInfo:uin	Ljava/lang/String;
    //   173: invokestatic 337	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   176: ifne -26 -> 150
    //   179: aload_0
    //   180: aload_3
    //   181: invokevirtual 623	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   184: pop
    //   185: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   188: ifeq -38 -> 150
    //   191: ldc 20
    //   193: iconst_2
    //   194: new 143	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 1149
    //   204: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_3
    //   208: invokevirtual 693	com/tencent/mobileqq/data/SpecialCareInfo:toString	()Ljava/lang/String;
    //   211: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: goto -70 -> 150
    //   223: astore_1
    //   224: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +32 -> 259
    //   230: ldc 23
    //   232: iconst_2
    //   233: new 143	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 1151
    //   243: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 959	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   250: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload_2
    //   260: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   263: return
    //   264: aload_2
    //   265: invokevirtual 633	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   268: aload_2
    //   269: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   272: return
    //   273: astore_1
    //   274: aload_2
    //   275: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   278: aload_1
    //   279: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	FriendsManager
    //   0	280	1	paramList	List
    //   65	210	2	localObject1	Object
    //   74	134	3	localObject2	Object
    //   93	23	4	localSpecialCareInfo	SpecialCareInfo
    // Exception table:
    //   from	to	target	type
    //   68	75	124	finally
    //   75	121	124	finally
    //   125	127	124	finally
    //   129	131	124	finally
    //   143	150	223	java/lang/Exception
    //   150	220	223	java/lang/Exception
    //   264	268	223	java/lang/Exception
    //   143	150	273	finally
    //   150	220	273	finally
    //   224	259	273	finally
    //   264	268	273	finally
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_h_of_type_Int == -1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "contactGetSwitch enableInteractive" + bool + "IsDisableInteractive=" + this.jdField_h_of_type_Int);
      }
      return bool;
      if (this.jdField_h_of_type_Int != 1) {
        bool = false;
      }
    }
  }
  
  public boolean c(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.isOnline();
    }
    return false;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() - this.j;
  }
  
  public ArrayList d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      g();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  void d()
  {
    g();
    a();
  }
  
  public void d(String paramString)
  {
    Object localObject4 = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    if (localObject4 != null)
    {
      if (((Friends)localObject4).gathtertype != 2) {
        break label269;
      }
      this.jdField_i_of_type_Int -= 1;
    }
    for (;;)
    {
      localObject2 = null;
      localObject1 = null;
      try
      {
        EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.a();
        Object localObject3 = localObject4;
        if (localObject4 == null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localObject3 = (Friends)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(Friends.class, paramString);
        }
        if (localObject3 != null)
        {
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          localObject4 = a(String.valueOf(((Friends)localObject3).groupid));
          if (localObject4 != null)
          {
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            ((Groups)localObject4).group_friend_count -= 1;
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            if (((Friends)localObject3).isOnline())
            {
              localObject1 = localEntityTransaction;
              localObject2 = localEntityTransaction;
              ((Groups)localObject4).group_online_friend_count -= 1;
            }
            localObject1 = localEntityTransaction;
            localObject2 = localEntityTransaction;
            a((Entity)localObject4);
          }
          localObject1 = localEntityTransaction;
          localObject2 = localEntityTransaction;
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject3);
        }
        localObject1 = localEntityTransaction;
        localObject2 = localEntityTransaction;
        localEntityTransaction.c();
        if (localEntityTransaction != null) {
          localEntityTransaction.b();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject2 = localObject1;
          QLog.e("Q.contacttab.", 1, "", localException);
          if (localObject1 != null) {
            ((EntityTransaction)localObject1).b();
          }
        }
      }
      finally
      {
        if (localObject2 == null) {
          break;
        }
        ((EntityTransaction)localObject2).b();
      }
      a();
      if (QvipSpecialCareManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        QvipSpecialCareManager.b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (QvipSpecialCareManager.b(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        QvipSpecialCareManager.c(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      e(paramString);
      return;
      label269:
      if (((Friends)localObject4).gathtertype == 1) {
        this.j -= 1;
      }
    }
  }
  
  /* Error */
  public void d(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 553 1 0
    //   10: ifgt +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 134	com/tencent/mobileqq/app/FriendsManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   18: invokevirtual 523	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 591	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   26: aload_1
    //   27: invokeinterface 560 1 0
    //   32: astore_1
    //   33: aload_1
    //   34: invokeinterface 188 1 0
    //   39: ifeq +67 -> 106
    //   42: aload_1
    //   43: invokeinterface 192 1 0
    //   48: checkcast 208	java/lang/String
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 60	com/tencent/mobileqq/app/FriendsManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: aload_3
    //   57: invokevirtual 229	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 199	com/tencent/mobileqq/data/Friends
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull -32 -> 33
    //   68: aload_3
    //   69: iconst_0
    //   70: putfield 203	com/tencent/mobileqq/data/Friends:gathtertype	B
    //   73: aload_0
    //   74: aload_3
    //   75: invokevirtual 596	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)Z
    //   78: pop
    //   79: aload_0
    //   80: aload_0
    //   81: getfield 290	com/tencent/mobileqq/app/FriendsManager:j	I
    //   84: iconst_1
    //   85: isub
    //   86: putfield 290	com/tencent/mobileqq/app/FriendsManager:j	I
    //   89: goto -56 -> 33
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 935	java/lang/Exception:printStackTrace	()V
    //   97: aload_2
    //   98: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   101: aload_0
    //   102: invokevirtual 313	com/tencent/mobileqq/app/FriendsManager:a	()V
    //   105: return
    //   106: aload_2
    //   107: invokevirtual 633	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   110: aload_2
    //   111: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   114: goto -13 -> 101
    //   117: astore_1
    //   118: aload_2
    //   119: invokevirtual 614	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	FriendsManager
    //   0	124	1	paramList	List
    //   21	98	2	localEntityTransaction	EntityTransaction
    //   51	24	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	33	92	java/lang/Exception
    //   33	64	92	java/lang/Exception
    //   68	89	92	java/lang/Exception
    //   106	110	92	java/lang/Exception
    //   22	33	117	finally
    //   33	64	117	finally
    //   68	89	117	finally
    //   93	97	117	finally
    //   106	110	117	finally
  }
  
  public boolean d()
  {
    boolean bool;
    if (this.jdField_h_of_type_Int == -1)
    {
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).k();
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "getEnableReactive enableInteractive" + bool + "IsDisableInteractive=" + this.jdField_h_of_type_Int);
      }
      return bool;
      if (this.jdField_h_of_type_Int == 1) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public boolean d(String paramString)
  {
    return a(paramString, false);
  }
  
  public int e()
  {
    return this.j;
  }
  
  public ArrayList e()
  {
    new ConcurrentHashMap(4);
    ConcurrentHashMap localConcurrentHashMap = a(true);
    ArrayList localArrayList = new ArrayList(16);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localConcurrentHashMap.get(String.valueOf(((Groups)localIterator.next()).group_id));
        if (localList != null) {
          localArrayList.addAll(localList);
        }
      }
    }
    return localArrayList;
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "deleteSpecialCareInfo: uin=" + paramString);
    }
    SpecialCareInfo localSpecialCareInfo = null;
    if (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap != null) {}
    synchronized (this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      localSpecialCareInfo = (SpecialCareInfo)this.jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      ??? = localSpecialCareInfo;
      if (localSpecialCareInfo == null) {
        ??? = (SpecialCareInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(SpecialCareInfo.class, paramString);
      }
      if (??? != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)???);
      }
      return;
    }
  }
  
  public void e(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          continue;
        }
        localObject = (String)paramList.next();
        localObject = (Friends)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject == null) {
          continue;
        }
        if (((Friends)localObject).gathtertype == 2) {
          this.jdField_i_of_type_Int -= 1;
        }
        if ((((Friends)localObject).gathtertype != 2) && (((Friends)localObject).gathtertype != 0)) {
          continue;
        }
        if (((Friends)localObject).gathtertype == 0) {
          ((Friends)localObject).recommReason = "手工设置";
        }
        ((Friends)localObject).gathtertype = 1;
        localCard = a(((Friends)localObject).uin);
        if (localCard == null) {
          continue;
        }
        if (localCard.shGender != 0) {
          continue;
        }
        b1 = 1;
      }
      catch (Exception paramList)
      {
        Object localObject;
        Card localCard;
        paramList.printStackTrace();
        localEntityTransaction.b();
        return;
        if (localCard.shGender != 1) {
          break label238;
        }
        b1 = 2;
        continue;
        localEntityTransaction.c();
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        localEntityTransaction.b();
      }
      ((Friends)localObject).gender = b1;
      ((Friends)localObject).age = localCard.age;
      a((Friends)localObject);
      this.j += 1;
      continue;
      label238:
      byte b1 = 0;
    }
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() > 0));
  }
  
  public boolean e(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.isShield();
    }
    return false;
  }
  
  public void f(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (cmd0x7c4.RecommendReason)paramList.next();
        String str = String.valueOf(((cmd0x7c4.RecommendReason)localObject).uint32_reason_id.get());
        localObject = ((cmd0x7c4.RecommendReason)localObject).bytes_recommend_reason.get().toStringUtf8();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "key : " + str + " ; reason : " + (String)localObject);
        }
      }
    }
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.", 2, "FriendsManager onDestory");
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\FriendsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */