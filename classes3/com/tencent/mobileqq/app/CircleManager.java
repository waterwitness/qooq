package com.tencent.mobileqq.app;

import KQQ.ResRichSigInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.CircleGroup;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.circle.IFriendObserver;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import com.tencent.mobileqq.service.circle.ISwitchObserver;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import puw;
import pux;
import puz;
import pva;
import pvb;
import pvc;
import pve;
import pvf;
import pvg;
import pvh;
import tencent.im.cs.cmd0x6ff.subcmd0x111.GroupInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x111.OneRenMaiFrd;
import tencent.im.cs.cmd0x6ff.subcmd0x111.RenMaiInfo;

public class CircleManager
  implements Manager
{
  public static final int a = -2;
  public static final String a = "CircleManager";
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "param_WIFICircleDownloadFlow", "param_WIFIFlow", "param_Flow" };
  public static final int b = -1;
  public static final String b = "CircleManager_Detail";
  private static final boolean jdField_b_of_type_Boolean = true;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "param_XGCircleDownloadFlow", "param_XGFlow", "param_Flow" };
  public static final int c = 0;
  private static final String jdField_c_of_type_JavaLangString = "pref_circle_";
  public static final int d = 1;
  private static long jdField_d_of_type_Long = 0L;
  private static final String jdField_d_of_type_JavaLangString = "circle_data_update_stamp";
  private static final boolean jdField_d_of_type_Boolean = false;
  public static final int e = 2;
  private static final long jdField_e_of_type_Long = 30000L;
  private static final String jdField_e_of_type_JavaLangString = "circle_server_req_interval";
  private static final boolean jdField_e_of_type_Boolean = false;
  public static final int f = 3;
  private static final long jdField_f_of_type_Long = 2400000L;
  private static final String jdField_f_of_type_JavaLangString = "circle_server_stamp";
  public static final int g = -1000;
  private static final long jdField_g_of_type_Long = 60000L;
  private static final String jdField_g_of_type_JavaLangString = "_circle_svc";
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  private static final int l = 1;
  private static final int n = 100;
  private static int o = 2;
  private static int p = 1;
  private static int q;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private volatile AsyncTask jdField_a_of_type_AndroidOsAsyncTask;
  private CircleObserver jdField_a_of_type_ComTencentMobileqqAppCircleObserver = new pvh(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new pvg(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Runnable jdField_a_of_type_JavaLangRunnable = new puw(this);
  public HashMap a;
  public LinkedList a;
  public ConcurrentHashMap a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new pux(this);
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long jdField_b_of_type_Long;
  public LinkedList b;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private volatile long jdField_c_of_type_Long = 300000L;
  public LinkedList c;
  private boolean jdField_c_of_type_Boolean;
  private String[] jdField_c_of_type_ArrayOfJavaLangString;
  private int k;
  private int m;
  private int r;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    d = 120000L;
  }
  
  public CircleManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilLinkedList = null;
    this.jdField_b_of_type_JavaUtilLinkedList = null;
    this.jdField_c_of_type_JavaUtilLinkedList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppCircleObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("pref_circle_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("circle_data_update_stamp", 0L);
    this.m = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("circle_server_stamp", 0);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("circle_server_req_interval", this.jdField_c_of_type_Long);
    e();
  }
  
  private int a()
  {
    int i2 = 0;
    int i1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("$checkUpdate | mGroupMap=");
      if (this.jdField_a_of_type_JavaUtilHashMap == null)
      {
        i1 = 0;
        localStringBuilder2.append(i1);
        localStringBuilder1.append(" | current").append(System.currentTimeMillis() / 1000L);
        localStringBuilder1.append(" | lastStamp=").append(this.jdField_a_of_type_Long / 1000L);
        localStringBuilder1.append(" | interval=").append(this.jdField_c_of_type_Long / 1000L);
        QLog.d("CircleManager", 2, localStringBuilder1.toString());
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        break label124;
      }
      i1 = 1;
    }
    label124:
    do
    {
      return i1;
      i1 = this.jdField_a_of_type_JavaUtilHashMap.size();
      break;
      i1 = i2;
    } while (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) <= this.jdField_c_of_type_Long);
    return 2;
  }
  
  private int a(boolean paramBoolean)
  {
    int i2 = -1;
    for (;;)
    {
      try
      {
        if (a() != 2)
        {
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("CircleManager", 2, "$updateCircle_remote | checkUpdate is not remote");
            i1 = i2;
          }
          return i1;
        }
        long l1 = System.currentTimeMillis();
        i1 = NetworkCenter.a().a();
        if (QLog.isColorLevel()) {
          QLog.d("CircleManager", 2, "updateCircle_remote | isRequesting=" + this.jdField_c_of_type_Boolean + " net avaliable=" + i1 + " | now=" + l1 + " | circleDataUpdateFlag=" + this.jdField_b_of_type_Long);
        }
        if (this.jdField_c_of_type_Boolean)
        {
          i1 = 0;
          continue;
          if (Math.abs(l1 - this.jdField_b_of_type_Long) < d)
          {
            i1 = i2;
            if (!paramBoolean) {
              continue;
            }
          }
          c();
          i1 = 0;
          continue;
        }
        if (i1 != 0) {
          continue;
        }
      }
      finally {}
      int i1 = -2;
    }
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 16 & 0xFF).append(".");
    localStringBuilder.append(paramInt1 >> 24 & 0xFF);
    return a(localStringBuilder.toString(), paramInt2);
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    localStringBuffer.append("http://").append(paramString);
    if (paramInt != 80) {
      localStringBuffer.append(":").append(paramInt);
    }
    localStringBuffer.append("/");
    return localStringBuffer.toString();
  }
  
  private void a(subcmd0x111.RenMaiInfo paramRenMaiInfo, boolean paramBoolean)
  {
    int i1 = paramRenMaiInfo.uint32_next_start_time.get();
    if (paramBoolean)
    {
      this.m = i1;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("circle_server_stamp", this.m).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "$saveRenmaiInfo | next interval = " + paramRenMaiInfo.uint32_next_interval.get());
    }
    int i2 = paramRenMaiInfo.uint32_next_interval.get();
    i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    this.jdField_c_of_type_Long = ((i1 + 300) * 1000L);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("circle_server_req_interval", this.jdField_c_of_type_Long).commit();
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
  }
  
  private boolean a(subcmd0x111.RenMaiInfo paramRenMaiInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleGroup.class);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleBuddy.class);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Object localObject1 = paramRenMaiInfo.rpt_msg_group_info.get();
    HashMap localHashMap = new HashMap();
    int i1;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = ((List)localObject1).iterator();
      i1 = 0;
    }
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (subcmd0x111.GroupInfo)((Iterator)localObject1).next();
      localObject3 = new CircleGroup();
      ((CircleGroup)localObject3).showIndex = i1;
      ((CircleGroup)localObject3).groupId = ((subcmd0x111.GroupInfo)localObject2).uint32_type.get();
      ((CircleGroup)localObject3).groupName = ((subcmd0x111.GroupInfo)localObject2).bytes_name.get().toStringUtf8();
      a((Entity)localObject3);
      localHashMap.put(Integer.valueOf(((CircleGroup)localObject3).groupId), localObject3);
      i1 += 1;
      continue;
      throw new RuntimeException("msg_group_info's size is 0");
    }
    paramRenMaiInfo = paramRenMaiInfo.rpt_msg_frd.get();
    if ((paramRenMaiInfo != null) && (paramRenMaiInfo.size() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "rebuildCircleCache: updateFriendList size=" + paramRenMaiInfo.size());
      }
      localObject2 = paramRenMaiInfo.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (subcmd0x111.OneRenMaiFrd)((Iterator)localObject2).next();
        String str = String.valueOf(((subcmd0x111.OneRenMaiFrd)localObject3).uint64_uin.get());
        localObject1 = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        paramRenMaiInfo = (subcmd0x111.RenMaiInfo)localObject1;
        if (localObject1 == null) {
          paramRenMaiInfo = new CircleBuddy();
        }
        paramRenMaiInfo.uin = str;
        paramRenMaiInfo.nickName = ((subcmd0x111.OneRenMaiFrd)localObject3).bytes_nick.get().toStringUtf8();
        paramRenMaiInfo.remark = ((subcmd0x111.OneRenMaiFrd)localObject3).bytes_remark.get().toStringUtf8();
        paramRenMaiInfo.closeness = ((subcmd0x111.OneRenMaiFrd)localObject3).uint32_closeness.get();
        paramRenMaiInfo.groupId = ((subcmd0x111.OneRenMaiFrd)localObject3).uint32_group.get();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramRenMaiInfo);
        paramRenMaiInfo = (CircleGroup)localHashMap.get(paramRenMaiInfo.uin);
        if (paramRenMaiInfo != null) {
          paramRenMaiInfo.buddyCount += 1;
        }
      }
    }
    paramRenMaiInfo = localHashMap.values().iterator();
    while (paramRenMaiInfo.hasNext())
    {
      localObject1 = (CircleGroup)paramRenMaiInfo.next();
      ((CircleGroup)localObject1).buddyList = new ArrayList(((CircleGroup)localObject1).buddyCount);
    }
    paramRenMaiInfo = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (paramRenMaiInfo.hasNext())
    {
      localObject1 = (CircleBuddy)paramRenMaiInfo.next();
      if (a(((CircleBuddy)localObject1).uin))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CircleManager", 2, "$updateCircle_local | buddy is friend or black");
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((CircleBuddy)localObject1).uin);
      }
      else
      {
        localObject2 = (CircleGroup)localHashMap.get(Integer.valueOf(((CircleBuddy)localObject1).groupId));
        if (localObject2 != null) {
          ((CircleGroup)localObject2).buddyList.add(localObject1);
        } else if (QLog.isColorLevel()) {
          QLog.d("CircleManager", 2, "$updateCircle_local | cannot find buddy" + ((CircleBuddy)localObject1).uin.substring(0, 3) + "'s group");
        }
      }
    }
    paramRenMaiInfo = localHashMap.values().iterator();
    while (paramRenMaiInfo.hasNext())
    {
      localObject1 = (CircleGroup)paramRenMaiInfo.next();
      ((CircleGroup)localObject1).buddyCount = ((CircleGroup)localObject1).buddyList.size();
    }
    this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
    return true;
  }
  
  private int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "updateCircle_Local");
    }
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "updateCircle_Local | real do");
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new pvc(this).execute(new Void[0]);
    return 0;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new pvb(this));
  }
  
  private void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new pve(this, paramString));
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleGroup.class);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleBuddy.class);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    return true;
  }
  
  private boolean b(subcmd0x111.RenMaiInfo arg1)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleGroup.class);
    Object localObject1 = ???.rpt_msg_group_info.get();
    HashMap localHashMap = new HashMap();
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = ((List)localObject1).iterator();
      i1 = 0;
    }
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (subcmd0x111.GroupInfo)((Iterator)localObject1).next();
      ??? = new CircleGroup();
      ((CircleGroup)???).showIndex = i1;
      ((CircleGroup)???).groupId = ((subcmd0x111.GroupInfo)???).uint32_type.get();
      ((CircleGroup)???).groupName = ((subcmd0x111.GroupInfo)???).bytes_name.get().toStringUtf8();
      ??? = (CircleGroup)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((CircleGroup)???).groupId));
      if (??? != null) {
        ((CircleGroup)???).buddyList = ((CircleGroup)???).buddyList;
      }
      a((Entity)???);
      localHashMap.put(Integer.valueOf(((CircleGroup)???).groupId), ???);
      i1 += 1;
      continue;
      throw new RuntimeException("msg_group_info's size is 0");
    }
    localObject1 = ???.rpt_msg_frd.get();
    boolean bool1 = bool2;
    Object localObject5;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (((List)localObject1).size() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CircleManager", 2, "incrementalUpdateCircle: updateFriendList size=" + ((List)localObject1).size());
        }
        ??? = ((List)localObject1).iterator();
        if (((Iterator)???).hasNext())
        {
          ??? = (subcmd0x111.OneRenMaiFrd)((Iterator)???).next();
          localObject5 = String.valueOf(((subcmd0x111.OneRenMaiFrd)???).uint64_uin.get());
          localObject1 = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject5);
          if (localObject1 == null) {
            localObject1 = new CircleBuddy();
          }
        }
      }
    }
    for (int i1 = 1;; i1 = 1)
    {
      ((CircleBuddy)localObject1).uin = ((String)localObject5);
      ((CircleBuddy)localObject1).nickName = ((subcmd0x111.OneRenMaiFrd)???).bytes_nick.get().toStringUtf8();
      ((CircleBuddy)localObject1).remark = ((subcmd0x111.OneRenMaiFrd)???).bytes_remark.get().toStringUtf8();
      ((CircleBuddy)localObject1).closeness = ((subcmd0x111.OneRenMaiFrd)???).uint32_closeness.get();
      ((CircleBuddy)localObject1).groupId = ((subcmd0x111.OneRenMaiFrd)???).uint32_group.get();
      a((Entity)localObject1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject5, localObject1);
      if (i1 == 0) {
        break;
      }
      localObject5 = (CircleGroup)localHashMap.get(Integer.valueOf(((CircleBuddy)localObject1).groupId));
      if (localObject5 != null) {
        synchronized (((CircleGroup)localObject5).buddyList)
        {
          ((CircleGroup)localObject5).buddyList.add(localObject1);
          if (!QLog.isColorLevel()) {
            break;
          }
          break;
          if (((subcmd0x111.OneRenMaiFrd)???).uint32_group.get() != ((CircleBuddy)localObject1).groupId)
          {
            CircleGroup localCircleGroup = (CircleGroup)localHashMap.get(Integer.valueOf(((CircleBuddy)localObject1).groupId));
            if (localCircleGroup != null) {
              synchronized (localCircleGroup.buddyList)
              {
                localCircleGroup.buddyList.remove(localObject1);
              }
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("CircleManager", 2, "incrementalUpdateCircle | Exception: can't find buddy " + ((CircleBuddy)localObject1).uin + " in group " + ((CircleBuddy)localObject1).groupId);
            continue;
          }
          i1 = 0;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CircleManager_Detail", 2, "incrementalUpdateCircle | Exception: can't find group id " + ((CircleBuddy)localObject1).groupId + "while adding " + b(((CircleBuddy)localObject1).uin));
      break;
      bool1 = true;
      ??? = ???.rpt_uint64_del_frd.get();
      bool2 = bool1;
      if (??? != null)
      {
        bool2 = bool1;
        if (???.size() != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CircleManager", 2, "incrementalUpdateCircle | deleteUinList size=" + ???.size() + " | " + ???.toString());
          }
          ??? = ???.iterator();
          while (???.hasNext())
          {
            ??? = String.valueOf(((Long)???.next()).longValue());
            localObject1 = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(???);
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("CircleManager", 2, "delete uin:" + b((String)???));
              }
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject1);
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(???);
              ??? = (CircleGroup)localHashMap.get(Integer.valueOf(((CircleBuddy)localObject1).groupId));
              if (??? != null) {
                synchronized (((CircleGroup)???).buddyList)
                {
                  ((CircleGroup)???).buddyList.remove(localObject1);
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("CircleManager", 2, "incrementalUpdateCircle | Exception: can't find group id " + ((CircleBuddy)localObject1).groupId + " while deleting");
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("CircleManager", 2, "$incrementalUpdateCircle | can't find " + b((String)???) + " in buddy cache map");
            }
          }
          bool2 = true;
        }
      }
      localObject1 = localHashMap.values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ??? = (CircleGroup)((Iterator)localObject1).next();
        synchronized (((CircleGroup)???).buddyList)
        {
          ??? = ???.iterator();
          while (((Iterator)???).hasNext())
          {
            localObject5 = (CircleBuddy)((Iterator)???).next();
            if (a(((CircleBuddy)localObject5).uin))
            {
              if (QLog.isColorLevel()) {
                QLog.d("CircleManager", 2, "$updateCircle_local | buddy is friend or black");
              }
              ((Iterator)???).remove();
              this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b((Entity)localObject5);
            }
          }
        }
        ((CircleGroup)???).buddyCount = ???.size();
        if (QLog.isColorLevel()) {
          QLog.d("CircleManager", 2, "incrementalUpdateCircle | groupId=" + ((CircleGroup)???).groupId + "|groupName=" + ((CircleGroup)???).groupName + "|buddyCount=" + ???.size());
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
      return bool2;
    }
  }
  
  private void c()
  {
    CircleServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.m);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Boolean = true;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new pvf(this));
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: new 631	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 148	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   16: invokevirtual 635	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   19: new 173	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   26: aload_0
    //   27: getfield 148	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: invokevirtual 637	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   33: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 47
    //   38: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 640	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +360 -> 409
    //   52: aload_2
    //   53: invokevirtual 643	java/io/File:exists	()Z
    //   56: ifeq +353 -> 409
    //   59: aload_2
    //   60: invokestatic 648	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   63: astore_1
    //   64: new 650	java/io/ByteArrayInputStream
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 653	java/io/ByteArrayInputStream:<init>	([B)V
    //   72: astore_3
    //   73: new 655	java/io/ObjectInputStream
    //   76: dup
    //   77: aload_3
    //   78: invokespecial 658	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore_2
    //   82: aload_2
    //   83: invokevirtual 661	java/io/ObjectInputStream:readInt	()I
    //   86: istore 5
    //   88: iload 5
    //   90: aload_1
    //   91: arraylength
    //   92: if_icmple +111 -> 203
    //   95: new 445	java/lang/RuntimeException
    //   98: dup
    //   99: new 173	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 663
    //   109: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload 5
    //   114: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 450	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   123: athrow
    //   124: astore_1
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 665	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   130: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +13 -> 146
    //   136: ldc 12
    //   138: iconst_2
    //   139: ldc_w 667
    //   142: aload_1
    //   143: invokestatic 670	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 673	java/io/ObjectInputStream:close	()V
    //   154: aload_3
    //   155: ifnull +7 -> 162
    //   158: aload_3
    //   159: invokevirtual 674	java/io/ByteArrayInputStream:close	()V
    //   162: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +32 -> 197
    //   168: ldc 12
    //   170: iconst_2
    //   171: new 173	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 676
    //   181: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: getfield 678	com/tencent/mobileqq/app/CircleManager:r	I
    //   188: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: aload_0
    //   198: iconst_0
    //   199: putfield 678	com/tencent/mobileqq/app/CircleManager:r	I
    //   202: return
    //   203: iload 5
    //   205: ifle +20 -> 225
    //   208: aload_0
    //   209: iload 5
    //   211: newarray <illegal type>
    //   213: putfield 665	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   216: aload_2
    //   217: aload_0
    //   218: getfield 665	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   221: invokevirtual 682	java/io/ObjectInputStream:read	([B)I
    //   224: pop
    //   225: aload_2
    //   226: invokevirtual 661	java/io/ObjectInputStream:readInt	()I
    //   229: istore 5
    //   231: iload 5
    //   233: aload_1
    //   234: arraylength
    //   235: if_icmple +51 -> 286
    //   238: new 445	java/lang/RuntimeException
    //   241: dup
    //   242: new 173	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 684
    //   252: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: iload 5
    //   257: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokespecial 450	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   266: athrow
    //   267: astore_1
    //   268: aload_2
    //   269: ifnull +7 -> 276
    //   272: aload_2
    //   273: invokevirtual 673	java/io/ObjectInputStream:close	()V
    //   276: aload_3
    //   277: ifnull +7 -> 284
    //   280: aload_3
    //   281: invokevirtual 674	java/io/ByteArrayInputStream:close	()V
    //   284: aload_1
    //   285: athrow
    //   286: iload 5
    //   288: ifle +20 -> 308
    //   291: aload_0
    //   292: iload 5
    //   294: newarray <illegal type>
    //   296: putfield 686	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   299: aload_2
    //   300: aload_0
    //   301: getfield 686	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   304: invokevirtual 682	java/io/ObjectInputStream:read	([B)I
    //   307: pop
    //   308: aload_0
    //   309: aload_2
    //   310: invokevirtual 661	java/io/ObjectInputStream:readInt	()I
    //   313: putfield 678	com/tencent/mobileqq/app/CircleManager:r	I
    //   316: aload_0
    //   317: aload_2
    //   318: invokevirtual 689	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   321: checkcast 690	[Ljava/lang/String;
    //   324: checkcast 690	[Ljava/lang/String;
    //   327: putfield 692	com/tencent/mobileqq/app/CircleManager:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   330: aload_3
    //   331: astore_1
    //   332: aload_2
    //   333: ifnull +7 -> 340
    //   336: aload_2
    //   337: invokevirtual 673	java/io/ObjectInputStream:close	()V
    //   340: aload_1
    //   341: ifnull -179 -> 162
    //   344: aload_1
    //   345: invokevirtual 674	java/io/ByteArrayInputStream:close	()V
    //   348: goto -186 -> 162
    //   351: astore_1
    //   352: goto -190 -> 162
    //   355: astore_2
    //   356: goto -16 -> 340
    //   359: astore_1
    //   360: goto -206 -> 154
    //   363: astore_1
    //   364: goto -202 -> 162
    //   367: astore_2
    //   368: goto -92 -> 276
    //   371: astore_2
    //   372: goto -88 -> 284
    //   375: astore_1
    //   376: aconst_null
    //   377: astore_3
    //   378: aconst_null
    //   379: astore_2
    //   380: goto -112 -> 268
    //   383: astore_1
    //   384: aconst_null
    //   385: astore_2
    //   386: goto -118 -> 268
    //   389: astore_1
    //   390: goto -122 -> 268
    //   393: astore_1
    //   394: aconst_null
    //   395: astore_3
    //   396: aload 4
    //   398: astore_2
    //   399: goto -274 -> 125
    //   402: astore_1
    //   403: aload 4
    //   405: astore_2
    //   406: goto -281 -> 125
    //   409: aconst_null
    //   410: astore_2
    //   411: goto -79 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	CircleManager
    //   1	90	1	arrayOfByte	byte[]
    //   124	110	1	localException1	Exception
    //   267	18	1	localObject1	Object
    //   331	14	1	localObject2	Object
    //   351	1	1	localIOException1	java.io.IOException
    //   359	1	1	localIOException2	java.io.IOException
    //   363	1	1	localIOException3	java.io.IOException
    //   375	1	1	localObject3	Object
    //   383	1	1	localObject4	Object
    //   389	1	1	localObject5	Object
    //   393	1	1	localException2	Exception
    //   402	1	1	localException3	Exception
    //   47	290	2	localObject6	Object
    //   355	1	2	localIOException4	java.io.IOException
    //   367	1	2	localIOException5	java.io.IOException
    //   371	1	2	localIOException6	java.io.IOException
    //   379	32	2	localObject7	Object
    //   72	324	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   3	401	4	localObject8	Object
    //   86	207	5	i1	int
    // Exception table:
    //   from	to	target	type
    //   82	124	124	java/lang/Exception
    //   208	225	124	java/lang/Exception
    //   225	267	124	java/lang/Exception
    //   291	308	124	java/lang/Exception
    //   308	330	124	java/lang/Exception
    //   82	124	267	finally
    //   208	225	267	finally
    //   225	267	267	finally
    //   291	308	267	finally
    //   308	330	267	finally
    //   344	348	351	java/io/IOException
    //   336	340	355	java/io/IOException
    //   150	154	359	java/io/IOException
    //   158	162	363	java/io/IOException
    //   272	276	367	java/io/IOException
    //   280	284	371	java/io/IOException
    //   5	48	375	finally
    //   52	73	375	finally
    //   73	82	383	finally
    //   125	146	389	finally
    //   5	48	393	java/lang/Exception
    //   52	73	393	java/lang/Exception
    //   73	82	402	java/lang/Exception
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: new 694	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 695	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 697	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 700	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_0
    //   20: getfield 665	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   23: ifnull +13 -> 36
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: getfield 665	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   32: arraylength
    //   33: ifne +127 -> 160
    //   36: aload_2
    //   37: astore_1
    //   38: aload_2
    //   39: iconst_0
    //   40: invokevirtual 703	java/io/ObjectOutputStream:writeInt	(I)V
    //   43: aload_2
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 686	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   49: ifnull +13 -> 62
    //   52: aload_2
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 686	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   58: arraylength
    //   59: ifne +176 -> 235
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: iconst_0
    //   66: invokevirtual 703	java/io/ObjectOutputStream:writeInt	(I)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 678	com/tencent/mobileqq/app/CircleManager:r	I
    //   76: invokevirtual 703	java/io/ObjectOutputStream:writeInt	(I)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_0
    //   83: getfield 692	com/tencent/mobileqq/app/CircleManager:jdField_c_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   86: invokevirtual 707	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: invokevirtual 710	java/io/ObjectOutputStream:flush	()V
    //   95: aload_2
    //   96: astore_1
    //   97: new 631	java/io/File
    //   100: dup
    //   101: aload_0
    //   102: getfield 148	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   108: invokevirtual 635	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   111: new 173	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   118: aload_0
    //   119: getfield 148	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: invokevirtual 637	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   125: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 47
    //   130: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokespecial 640	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   139: invokevirtual 713	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   142: aload_3
    //   143: invokevirtual 717	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   146: iconst_0
    //   147: invokestatic 720	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   150: pop
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 721	java/io/ObjectOutputStream:close	()V
    //   159: return
    //   160: aload_2
    //   161: astore_1
    //   162: aload_2
    //   163: aload_0
    //   164: getfield 665	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   167: arraylength
    //   168: invokevirtual 703	java/io/ObjectOutputStream:writeInt	(I)V
    //   171: aload_2
    //   172: astore_1
    //   173: aload_2
    //   174: aload_0
    //   175: getfield 665	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ArrayOfByte	[B
    //   178: invokevirtual 724	java/io/ObjectOutputStream:write	([B)V
    //   181: goto -138 -> 43
    //   184: astore_3
    //   185: aload_2
    //   186: astore_1
    //   187: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +34 -> 224
    //   193: aload_2
    //   194: astore_1
    //   195: ldc 12
    //   197: iconst_2
    //   198: new 173	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 726
    //   208: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_3
    //   212: invokevirtual 729	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_2
    //   225: ifnull -66 -> 159
    //   228: aload_2
    //   229: invokevirtual 721	java/io/ObjectOutputStream:close	()V
    //   232: return
    //   233: astore_1
    //   234: return
    //   235: aload_2
    //   236: astore_1
    //   237: aload_2
    //   238: aload_0
    //   239: getfield 686	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   242: arraylength
    //   243: invokevirtual 703	java/io/ObjectOutputStream:writeInt	(I)V
    //   246: aload_2
    //   247: astore_1
    //   248: aload_2
    //   249: aload_0
    //   250: getfield 686	com/tencent/mobileqq/app/CircleManager:jdField_b_of_type_ArrayOfByte	[B
    //   253: invokevirtual 724	java/io/ObjectOutputStream:write	([B)V
    //   256: goto -187 -> 69
    //   259: astore_3
    //   260: aload_1
    //   261: astore_2
    //   262: aload_3
    //   263: astore_1
    //   264: aload_2
    //   265: ifnull +7 -> 272
    //   268: aload_2
    //   269: invokevirtual 721	java/io/ObjectOutputStream:close	()V
    //   272: aload_1
    //   273: athrow
    //   274: astore_1
    //   275: return
    //   276: astore_2
    //   277: goto -5 -> 272
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_2
    //   283: goto -19 -> 264
    //   286: astore_3
    //   287: aconst_null
    //   288: astore_2
    //   289: goto -104 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	CircleManager
    //   18	177	1	localObject1	Object
    //   233	1	1	localException1	Exception
    //   236	37	1	localObject2	Object
    //   274	1	1	localException2	Exception
    //   280	1	1	localObject3	Object
    //   16	253	2	localObject4	Object
    //   276	1	2	localException3	Exception
    //   282	7	2	localObject5	Object
    //   7	136	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   184	28	3	localException4	Exception
    //   259	4	3	localObject6	Object
    //   286	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   19	26	184	java/lang/Exception
    //   28	36	184	java/lang/Exception
    //   38	43	184	java/lang/Exception
    //   45	52	184	java/lang/Exception
    //   54	62	184	java/lang/Exception
    //   64	69	184	java/lang/Exception
    //   71	79	184	java/lang/Exception
    //   81	89	184	java/lang/Exception
    //   91	95	184	java/lang/Exception
    //   97	151	184	java/lang/Exception
    //   162	171	184	java/lang/Exception
    //   173	181	184	java/lang/Exception
    //   237	246	184	java/lang/Exception
    //   248	256	184	java/lang/Exception
    //   228	232	233	java/lang/Exception
    //   19	26	259	finally
    //   28	36	259	finally
    //   38	43	259	finally
    //   45	52	259	finally
    //   54	62	259	finally
    //   64	69	259	finally
    //   71	79	259	finally
    //   81	89	259	finally
    //   91	95	259	finally
    //   97	151	259	finally
    //   162	171	259	finally
    //   173	181	259	finally
    //   187	193	259	finally
    //   195	224	259	finally
    //   237	246	259	finally
    //   248	256	259	finally
    //   155	159	274	java/lang/Exception
    //   268	272	276	java/lang/Exception
    //   0	17	280	finally
    //   0	17	286	java/lang/Exception
  }
  
  private void g()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 1) {
      return 2130840571;
    }
    if (paramInt == 3) {
      return 2130840572;
    }
    if (paramInt == 2) {
      return 2130840573;
    }
    return 2130843467;
  }
  
  public int a(int paramInt, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null) {
      throw new InvalidParameterException("list is null!");
    }
    paramArrayList.clear();
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return 1;
    }
    Object localObject1 = (CircleGroup)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localObject1 != null)
    {
      localObject1 = ((CircleGroup)localObject1).buddyList;
      Object localObject2;
      if (paramBoolean) {
        try
        {
          localObject2 = new Random();
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            CircleBuddy localCircleBuddy = (CircleBuddy)localIterator.next();
            localCircleBuddy.randomCloseness = (localCircleBuddy.closeness * (((Random)localObject2).nextInt(3) + 5));
          }
          Collections.sort((List)localObject1, new pva(this));
        }
        finally {}
      }
      paramArrayList.ensureCapacity(((List)localObject1).size());
      try
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramArrayList.add((CircleBuddy)((Iterator)localObject2).next());
        }
      }
      finally {}
    }
    return a();
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 1) {
      return b();
    }
    if (paramInt == 2) {
      return a(paramBoolean);
    }
    return -1;
  }
  
  public int a(String paramString)
  {
    paramString = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    long l1 = System.currentTimeMillis();
    if (paramString == null) {
      return 0;
    }
    if ((Math.abs(l1 - paramString.checkUpdateTime) < 2400000L) || (Math.abs(l1 - paramString.reqCheckTimeFlag) < 60000L)) {
      return 0;
    }
    return 2;
  }
  
  public int a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      throw new InvalidParameterException("list is null!");
    }
    paramArrayList.clear();
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CircleGroup localCircleGroup = (CircleGroup)((Iterator)localObject).next();
        if (localCircleGroup.buddyCount != 0) {
          paramArrayList.add(localCircleGroup);
        }
      }
    }
    Collections.sort(paramArrayList, new puz(this));
    return a();
  }
  
  public CircleBuddy a(String paramString)
  {
    CircleBuddy localCircleBuddy2 = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    CircleBuddy localCircleBuddy1 = localCircleBuddy2;
    if (localCircleBuddy2 == null)
    {
      localCircleBuddy2 = (CircleBuddy)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleBuddy.class, paramString);
      localCircleBuddy1 = localCircleBuddy2;
      if (localCircleBuddy2 != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localCircleBuddy2);
        localCircleBuddy1 = localCircleBuddy2;
      }
    }
    return localCircleBuddy1;
  }
  
  public RichStatus a(String paramString, int paramInt)
  {
    paramString = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null)
    {
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false) {
        return paramString.getRichStatus(bool);
      }
    }
    return RichStatus.getEmptyStatus();
  }
  
  String a()
  {
    String[] arrayOfString = this.jdField_c_of_type_ArrayOfJavaLangString;
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      this.r %= arrayOfString.length;
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "getCircleSrvUrl | usingIndex = " + this.r + " | count = " + arrayOfString.length + " | result = " + arrayOfString[this.r]);
      }
      return arrayOfString[this.r];
    }
    return null;
  }
  
  public String a(CircleBuddy paramCircleBuddy)
  {
    if ((paramCircleBuddy.remark != null) && (paramCircleBuddy.remark.length() != 0)) {
      return paramCircleBuddy.remark;
    }
    if ((paramCircleBuddy.nickName != null) && (paramCircleBuddy.nickName.length() != 0)) {
      return paramCircleBuddy.nickName;
    }
    return "";
  }
  
  public String a(String paramString)
  {
    paramString = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (paramString != null) {
      return a(paramString);
    }
    return "";
  }
  
  public List a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "getFourHundredSearchableBuddyies");
    }
    ArrayList localArrayList = new ArrayList(100);
    ??? = this.jdField_a_of_type_JavaUtilHashMap;
    if (??? != null)
    {
      a(new ArrayList());
      float f1 = 100.0F / this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
      Iterator localIterator = ((HashMap)???).values().iterator();
      while (localIterator.hasNext())
      {
        CircleGroup localCircleGroup = (CircleGroup)localIterator.next();
        synchronized (localCircleGroup.buddyList)
        {
          localArrayList.addAll(localCircleGroup.buddyList);
        }
      }
    }
    for (;;)
    {
      b();
      return localList1;
      List localList2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleBuddy.class, false, null, null, null, null, null, "100");
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CircleManager", 2, "onResponseException | current index = " + this.r);
    }
    this.r += 1;
  }
  
  void a(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 0) {
      return;
    }
    label18:
    QQAppInterface localQQAppInterface;
    String str;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (!bool) {
        break label100;
      }
    }
    label100:
    for (String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;; arrayOfString = jdField_b_of_type_ArrayOfJavaLangString)
    {
      localQQAppInterface.a(str, arrayOfString, paramInt);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CircleManager", 2, "$doFlowReport | iswifi=" + bool + " | size=" + paramInt);
      return;
      bool = false;
      break label18;
    }
  }
  
  public void a(ResRichSigInfo paramResRichSigInfo)
  {
    if ((paramResRichSigInfo.cStatus == 0) || (paramResRichSigInfo.cStatus == 1))
    {
      CircleBuddy localCircleBuddy = a(String.valueOf(paramResRichSigInfo.lUin));
      if (localCircleBuddy != null)
      {
        localCircleBuddy.checkUpdateTime = System.currentTimeMillis();
        if (paramResRichSigInfo.cStatus == 1)
        {
          localCircleBuddy.setRichBuffer(paramResRichSigInfo.vbSigInfo, paramResRichSigInfo.dwTime);
          this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localCircleBuddy);
        }
      }
    }
  }
  
  void a(Card paramCard)
  {
    CircleBuddy localCircleBuddy = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramCard.uin);
    if (localCircleBuddy != null)
    {
      localCircleBuddy.nickName = paramCard.strNick;
      localCircleBuddy.setRichBuffer(paramCard.vRichSign, paramCard.lSignModifyTime);
      a(localCircleBuddy);
      localCircleBuddy.checkUpdateTime = System.currentTimeMillis();
      b(paramCard.uin);
    }
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramObject instanceof ISwitchObserver)) {
              break;
            }
            if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
              this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
            }
          } while (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject));
          this.jdField_a_of_type_JavaUtilLinkedList.add((ISwitchObserver)paramObject);
          return;
          if (!(paramObject instanceof IGroupObserver)) {
            break;
          }
          if (this.jdField_b_of_type_JavaUtilLinkedList == null) {
            this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
          }
        } while (this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject));
        this.jdField_b_of_type_JavaUtilLinkedList.add((IGroupObserver)paramObject);
        return;
      } while (!(paramObject instanceof IFriendObserver));
      if (this.jdField_c_of_type_JavaUtilLinkedList == null) {
        this.jdField_c_of_type_JavaUtilLinkedList = new LinkedList();
      }
    } while (this.jdField_c_of_type_JavaUtilLinkedList.contains(paramObject));
    this.jdField_c_of_type_JavaUtilLinkedList.add((IFriendObserver)paramObject);
  }
  
  void a(String paramString)
  {
    CircleBuddy localCircleBuddy = (CircleBuddy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localCircleBuddy != null)
    {
      ??? = (CircleGroup)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localCircleBuddy.groupId));
      if (??? == null) {}
    }
    synchronized (((CircleGroup)???).buddyList)
    {
      ((List)???).remove(localCircleBuddy);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(localCircleBuddy);
      d();
      return;
    }
  }
  
  /* Error */
  public void a(List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 168	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 895	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 899	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   12: aload_1
    //   13: invokeinterface 394 1 0
    //   18: astore_1
    //   19: aload_1
    //   20: invokeinterface 399 1 0
    //   25: ifeq +66 -> 91
    //   28: aload_1
    //   29: invokeinterface 403 1 0
    //   34: checkcast 374	com/tencent/mobileqq/data/CircleBuddy
    //   37: astore_3
    //   38: aload_0
    //   39: getfield 168	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   42: aload_3
    //   43: invokevirtual 366	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   46: pop
    //   47: goto -28 -> 19
    //   50: astore_1
    //   51: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +32 -> 86
    //   57: ldc 12
    //   59: iconst_2
    //   60: new 173	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 901
    //   70: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 729	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload_2
    //   87: invokevirtual 902	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   90: return
    //   91: aload_2
    //   92: invokevirtual 903	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   95: aload_2
    //   96: invokevirtual 902	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   99: return
    //   100: astore_1
    //   101: aload_2
    //   102: invokevirtual 902	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	CircleManager
    //   0	107	1	paramList	List
    //   7	95	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   37	6	3	localCircleBuddy	CircleBuddy
    // Exception table:
    //   from	to	target	type
    //   8	19	50	java/lang/Exception
    //   19	47	50	java/lang/Exception
    //   91	95	50	java/lang/Exception
    //   8	19	100	finally
    //   19	47	100	finally
    //   51	86	100	finally
    //   91	95	100	finally
  }
  
  /* Error */
  void a(subcmd0x111.RenMaiInfo paramRenMaiInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 907	tencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo:uint32_sync_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6: invokevirtual 330	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9: istore 4
    //   11: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +42 -> 56
    //   17: ldc 12
    //   19: iconst_2
    //   20: new 173	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 909
    //   30: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   36: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: ldc_w 911
    //   42: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 4
    //   47: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iload 4
    //   58: getstatic 102	com/tencent/mobileqq/app/CircleManager:p	I
    //   61: if_icmpeq +69 -> 130
    //   64: iconst_1
    //   65: istore_3
    //   66: iload_3
    //   67: ifeq +196 -> 263
    //   70: aload_0
    //   71: getfield 168	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   74: invokevirtual 895	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 899	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   86: iload 4
    //   88: getstatic 100	com/tencent/mobileqq/app/CircleManager:o	I
    //   91: if_icmpne +44 -> 135
    //   94: aload_0
    //   95: invokespecial 913	com/tencent/mobileqq/app/CircleManager:b	()Z
    //   98: istore 5
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 903	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   108: iload_3
    //   109: ifeq +10 -> 119
    //   112: aload_0
    //   113: aload_1
    //   114: iload 5
    //   116: invokespecial 915	com/tencent/mobileqq/app/CircleManager:a	(Ltencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo;Z)V
    //   119: aload_2
    //   120: ifnull +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 902	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: iconst_0
    //   131: istore_3
    //   132: goto -66 -> 66
    //   135: iload 4
    //   137: getstatic 102	com/tencent/mobileqq/app/CircleManager:p	I
    //   140: if_icmpne +13 -> 153
    //   143: aload_0
    //   144: aload_1
    //   145: invokespecial 917	com/tencent/mobileqq/app/CircleManager:a	(Ltencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo;)Z
    //   148: istore 5
    //   150: goto -50 -> 100
    //   153: iload 4
    //   155: getstatic 919	com/tencent/mobileqq/app/CircleManager:q	I
    //   158: if_icmpne +13 -> 171
    //   161: aload_0
    //   162: aload_1
    //   163: invokespecial 921	com/tencent/mobileqq/app/CircleManager:b	(Ltencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo;)Z
    //   166: istore 5
    //   168: goto -68 -> 100
    //   171: new 445	java/lang/RuntimeException
    //   174: dup
    //   175: new 173	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 923
    //   185: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload 4
    //   190: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokespecial 450	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   199: athrow
    //   200: astore_1
    //   201: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +32 -> 236
    //   207: ldc 12
    //   209: iconst_2
    //   210: new 173	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   217: ldc_w 925
    //   220: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: aload_1
    //   224: invokevirtual 729	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   227: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_2
    //   237: ifnull -110 -> 127
    //   240: aload_2
    //   241: invokevirtual 902	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   244: goto -117 -> 127
    //   247: astore_1
    //   248: aload_0
    //   249: monitorexit
    //   250: aload_1
    //   251: athrow
    //   252: astore_1
    //   253: aload_2
    //   254: ifnull +7 -> 261
    //   257: aload_2
    //   258: invokevirtual 902	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   261: aload_1
    //   262: athrow
    //   263: aconst_null
    //   264: astore_2
    //   265: goto -187 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	CircleManager
    //   0	268	1	paramRenMaiInfo	subcmd0x111.RenMaiInfo
    //   77	188	2	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   65	67	3	i1	int
    //   9	180	4	i2	int
    //   98	69	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   82	86	200	java/lang/Exception
    //   86	100	200	java/lang/Exception
    //   104	108	200	java/lang/Exception
    //   112	119	200	java/lang/Exception
    //   135	150	200	java/lang/Exception
    //   153	168	200	java/lang/Exception
    //   171	200	200	java/lang/Exception
    //   2	56	247	finally
    //   56	64	247	finally
    //   70	78	247	finally
    //   123	127	247	finally
    //   240	244	247	finally
    //   257	261	247	finally
    //   261	263	247	finally
    //   82	86	252	finally
    //   86	100	252	finally
    //   104	108	252	finally
    //   112	119	252	finally
    //   135	150	252	finally
    //   153	168	252	finally
    //   171	200	252	finally
    //   201	236	252	finally
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      CircleServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean1);
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367843) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBoolean1).commit();
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool1 = bool2;
    if (paramArrayOfByte1 != null) {}
    for (bool1 = bool2;; bool1 = bool2) {
      try
      {
        if (paramArrayOfByte1.length > 0)
        {
          this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
          bool1 = true;
        }
        bool2 = bool1;
        if (paramArrayOfByte2 != null)
        {
          bool2 = bool1;
          if (paramArrayOfByte2.length > 0)
          {
            this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
            bool2 = true;
          }
        }
        if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
        {
          this.r = 0;
          this.jdField_c_of_type_ArrayOfJavaLangString = paramArrayOfString;
          bool1 = bool3;
          if (bool1) {
            f();
          }
          if (QLog.isColorLevel()) {
            QLog.d("CircleManager", 2, "saveCircleSrvParam | changed = " + bool1 + " | usingIndex = " + this.r);
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    BaseApplicationImpl.a.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
    return true;
  }
  
  public boolean a(String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if ((localFriendsManager == null) || (paramString.length() < 4)) {
      return false;
    }
    Friends localFriends = localFriendsManager.a(paramString);
    if ((localFriends != null) && (localFriends.groupid >= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "$beFriendOrBlack | " + b(paramString) + " is friend, " + localFriends.groupid);
      }
      return true;
    }
    if (localFriendsManager.a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CircleManager", 2, "$beFriendOrBlack | " + b(paramString) + " is in black list");
      }
      return true;
    }
    return false;
  }
  
  public final boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      CircleServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367843) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
  }
  
  byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int b(int paramInt)
  {
    return paramInt - 1;
  }
  
  String b(String paramString)
  {
    if ((paramString == null) || (paramString.length() < 4)) {
      return paramString;
    }
    return paramString.substring(0, 3);
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (this.jdField_b_of_type_JavaUtilLinkedList != null) {
        this.jdField_b_of_type_JavaUtilLinkedList.remove(paramObject);
      }
    } while (this.jdField_c_of_type_JavaUtilLinkedList == null);
    this.jdField_c_of_type_JavaUtilLinkedList.remove(paramObject);
  }
  
  /* Error */
  void b(subcmd0x111.RenMaiInfo paramRenMaiInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 907	tencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo:uint32_sync_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6: invokevirtual 330	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9: istore_2
    //   10: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +41 -> 54
    //   16: ldc 12
    //   18: iconst_2
    //   19: new 173	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 987
    //   29: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokestatic 229	java/lang/System:currentTimeMillis	()J
    //   35: invokevirtual 234	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   38: ldc_w 911
    //   41: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_2
    //   45: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: getstatic 102	com/tencent/mobileqq/app/CircleManager:p	I
    //   57: istore_3
    //   58: iload_2
    //   59: iload_3
    //   60: if_icmpeq +6 -> 66
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 989	com/tencent/mobileqq/app/CircleManager:c	(Ltencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo;)V
    //   71: aload_0
    //   72: aload_1
    //   73: iconst_1
    //   74: invokespecial 915	com/tencent/mobileqq/app/CircleManager:a	(Ltencent/im/cs/cmd0x6ff/subcmd0x111$RenMaiInfo;Z)V
    //   77: goto -14 -> 63
    //   80: astore_1
    //   81: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq -21 -> 63
    //   87: ldc 12
    //   89: iconst_2
    //   90: ldc_w 991
    //   93: aload_1
    //   94: invokestatic 670	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   97: goto -34 -> 63
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	CircleManager
    //   0	105	1	paramRenMaiInfo	subcmd0x111.RenMaiInfo
    //   9	52	2	i1	int
    //   57	4	3	i2	int
    // Exception table:
    //   from	to	target	type
    //   66	77	80	java/lang/Exception
    //   2	54	100	finally
    //   54	58	100	finally
    //   66	77	100	finally
    //   81	97	100	finally
  }
  
  byte[] b()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public int c(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public String c(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      if (this.jdField_a_of_type_JavaUtilHashMap != null)
      {
        paramString = (CircleGroup)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramString.groupId));
        if (paramString != null) {
          return paramString.groupName;
        }
      }
      else
      {
        b();
        paramString = (CircleGroup)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(CircleGroup.class, paramString.groupId);
        if (paramString != null) {
          return paramString.groupName;
        }
      }
    }
    return "";
  }
  
  /* Error */
  public void c(subcmd0x111.RenMaiInfo paramRenMaiInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 118	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 118	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: invokevirtual 813	java/util/concurrent/ConcurrentHashMap:size	()I
    //   14: ifne +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getfield 118	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   22: invokevirtual 1000	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   25: aload_0
    //   26: getfield 118	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: invokevirtual 813	java/util/concurrent/ConcurrentHashMap:size	()I
    //   32: anewarray 84	java/lang/String
    //   35: invokeinterface 1006 2 0
    //   40: checkcast 690	[Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: arraylength
    //   46: bipush 100
    //   48: idiv
    //   49: iconst_1
    //   50: iadd
    //   51: istore 6
    //   53: iconst_0
    //   54: istore 4
    //   56: iload 4
    //   58: iload 6
    //   60: if_icmpge +129 -> 189
    //   63: aconst_null
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 168	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: invokevirtual 895	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 899	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   79: iload 4
    //   81: iconst_1
    //   82: iadd
    //   83: bipush 100
    //   85: imul
    //   86: aload_3
    //   87: arraylength
    //   88: invokestatic 1010	java/lang/Math:min	(II)I
    //   91: istore 7
    //   93: iload 4
    //   95: bipush 100
    //   97: imul
    //   98: istore 5
    //   100: iload 5
    //   102: iload 7
    //   104: if_icmpge +31 -> 135
    //   107: aload_0
    //   108: getfield 118	com/tencent/mobileqq/app/CircleManager:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   111: aload_3
    //   112: iload 5
    //   114: aaload
    //   115: invokevirtual 471	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 374	com/tencent/mobileqq/data/CircleBuddy
    //   121: astore_2
    //   122: aload_2
    //   123: ifnull +118 -> 241
    //   126: aload_0
    //   127: aload_2
    //   128: invokespecial 433	com/tencent/mobileqq/app/CircleManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   131: pop
    //   132: goto +109 -> 241
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 903	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 902	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   151: iload 4
    //   153: iload 6
    //   155: iconst_1
    //   156: isub
    //   157: if_icmpge +9 -> 166
    //   160: ldc2_w 1011
    //   163: invokestatic 1018	java/lang/Thread:sleep	(J)V
    //   166: iload 4
    //   168: iconst_1
    //   169: iadd
    //   170: istore 4
    //   172: goto -116 -> 56
    //   175: astore_2
    //   176: aload_2
    //   177: athrow
    //   178: astore_2
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 902	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   187: aload_2
    //   188: athrow
    //   189: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -175 -> 17
    //   195: ldc 12
    //   197: iconst_2
    //   198: new 173	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 1020
    //   208: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: iload 6
    //   213: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: return
    //   223: astore_1
    //   224: goto -58 -> 166
    //   227: astore_2
    //   228: aconst_null
    //   229: astore_1
    //   230: goto -51 -> 179
    //   233: astore_2
    //   234: goto -55 -> 179
    //   237: astore_2
    //   238: goto -62 -> 176
    //   241: iload 5
    //   243: iconst_1
    //   244: iadd
    //   245: istore 5
    //   247: goto -147 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	CircleManager
    //   0	250	1	paramRenMaiInfo	subcmd0x111.RenMaiInfo
    //   72	56	2	localObject1	Object
    //   175	2	2	localException1	Exception
    //   178	10	2	localObject2	Object
    //   227	1	2	localObject3	Object
    //   233	1	2	localObject4	Object
    //   237	1	2	localException2	Exception
    //   43	69	3	arrayOfString	String[]
    //   54	117	4	i1	int
    //   98	148	5	i2	int
    //   51	161	6	i3	int
    //   91	14	7	i4	int
    // Exception table:
    //   from	to	target	type
    //   65	73	175	java/lang/Exception
    //   176	178	178	finally
    //   160	166	223	java/lang/Exception
    //   65	73	227	finally
    //   75	93	233	finally
    //   107	122	233	finally
    //   126	132	233	finally
    //   139	143	233	finally
    //   75	93	237	java/lang/Exception
    //   107	122	237	java/lang/Exception
    //   126	132	237	java/lang/Exception
    //   139	143	237	java/lang/Exception
  }
  
  public void onDestroy()
  {
    BaseApplicationImpl.a.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\CircleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */