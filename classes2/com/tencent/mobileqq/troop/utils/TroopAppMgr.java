package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import vpc;
import vpd;
import vpe;
import vpf;

public class TroopAppMgr
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = "KEY_APP_LIST_TIME_STAMP";
  public static final int b = 1;
  public static final int c = 2;
  protected int a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopHandler jdField_a_of_type_ComTencentMobileqqAppTroopHandler;
  final Object jdField_a_of_type_JavaLangObject;
  protected List a;
  public ConcurrentHashMap a;
  protected boolean a;
  protected boolean b;
  
  public TroopAppMgr(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)paramQQAppInterface.a(20));
    b();
  }
  
  private void b()
  {
    if (AppSetting.a("6.0") < 0) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList = localEntityManager.a(TroopAIOAppInfo.class);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("KEY_APP_LIST_TIME_STAMP_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
        if (localTroopAIOAppInfo.hashVal != null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localTroopAIOAppInfo.appid), localTroopAIOAppInfo.hashVal);
        }
      }
    }
    ((EntityManager)localObject2).a();
  }
  
  private void c(ArrayList paramArrayList)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList = paramArrayList;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      ThreadManager.a(new vpd(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager(), a(paramArrayList)), 8, null, false);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public TroopAIOAppInfo a(int paramInt)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject1).next();
          if (localTroopAIOAppInfo.appid != paramInt) {
            continue;
          }
          localObject1 = new TroopAIOAppInfo(localTroopAIOAppInfo);
          return (TroopAIOAppInfo)localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  protected List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        localArrayList.add(paramList.get(i));
        i += 1;
      }
      return localArrayList;
    }
    finally {}
  }
  
  public List a(boolean paramBoolean)
  {
    if (AppSetting.a("6.0") < 0) {
      return new ArrayList();
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(1, null, b());
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        int j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i < j)
        {
          TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          if (localTroopAIOAppInfo.isValidTroopApp()) {
            localArrayList.add(localTroopAIOAppInfo);
          }
        }
        else
        {
          return localArrayList;
        }
      }
      i += 1;
    }
  }
  
  public void a()
  {
    ArrayList localArrayList1 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
        if (localTroopAIOAppInfo.redPoint) {
          localArrayList1.add(Integer.valueOf(localTroopAIOAppInfo.appid));
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b(localArrayList2);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        TroopAIOAppInfo localTroopAIOAppInfo = null;
        if (i >= 0)
        {
          localTroopAIOAppInfo = (TroopAIOAppInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          if (localTroopAIOAppInfo.appid == paramInt) {
            this.jdField_a_of_type_JavaUtilList.remove(localTroopAIOAppInfo);
          }
        }
        else
        {
          if ((localTroopAIOAppInfo == null) || (localTroopAIOAppInfo.appid != paramInt)) {
            continue;
          }
          ThreadManager.a(new vpe(this, localEntityManager, localTroopAIOAppInfo), 8, null, false);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
          if (localTroopAIOAppInfo.hashVal != null)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localTroopAIOAppInfo.appid), localTroopAIOAppInfo.hashVal);
            break label166;
            if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
              continue;
            }
            if (localTroopAIOAppInfo.appid != ((TroopAIOAppInfo)this.jdField_a_of_type_JavaUtilList.get(i)).appid) {
              break label172;
            }
            this.jdField_a_of_type_JavaUtilList.set(i, localTroopAIOAppInfo);
            break label172;
          }
        }
        else
        {
          ThreadManager.a(new vpc(this, paramArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager()), 8, null, false);
          return;
        }
      }
      label166:
      int i = 0;
      continue;
      label172:
      i += 1;
    }
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty())) {}
    do
    {
      return;
      if (paramArrayList1.containsAll(paramArrayList2))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_a_of_type_Int, paramArrayList1, paramArrayList2);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopAppMgr.addTroopApp.troop.troop_app", 2, "appids to add are not contained in Appids list!");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) && (paramString != null) && (paramString.equals(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))));
  }
  
  public boolean a(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEntityManager.a())
    {
      if (paramEntity.getStatus() != 1000) {
        break label45;
      }
      paramEntityManager.b(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label45:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return paramEntityManager.a(paramEntity);
  }
  
  public boolean a(List paramList)
  {
    if (paramList == null) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    int k = paramList.size();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilList == null) {
        return false;
      }
    }
    boolean bool;
    int i;
    Object localObject2;
    if (k != this.jdField_a_of_type_JavaUtilList.size())
    {
      bool = true;
      break label234;
      if (i < k) {
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      }
    }
    label234:
    label255:
    for (;;)
    {
      TroopAIOAppInfo localTroopAIOAppInfo;
      if (((Iterator)localObject2).hasNext())
      {
        localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject2).next();
        if (((Integer)paramList.get(i)).intValue() == localTroopAIOAppInfo.appid) {
          localArrayList.add(localTroopAIOAppInfo);
        }
      }
      for (int j = 0; j != 0; j = 1)
      {
        localObject2 = new TroopAIOAppInfo();
        ((TroopAIOAppInfo)localObject2).appid = ((Integer)paramList.get(i)).intValue();
        localArrayList.add(localObject2);
        bool = true;
        break;
        if ((!bool) && (i == this.jdField_a_of_type_JavaUtilList.indexOf(localTroopAIOAppInfo)))
        {
          bool = true;
          break label255;
          if (bool) {
            c(localArrayList);
          }
          return bool;
        }
        break label255;
      }
      for (;;)
      {
        i = 0;
        break;
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("KEY_APP_LIST_TIME_STAMP_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).commit();
  }
  
  public void b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localInteger))) {
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(this.jdField_a_of_type_Int, paramArrayList);
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.b = paramBoolean;
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally {}
  }
  
  public void c(int paramInt)
  {
    if (a(paramInt) == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b(localArrayList);
  }
  
  public void d(int paramInt)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (localEntityManager != null)) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        Object localObject1 = null;
        if (localIterator.hasNext())
        {
          TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
          localObject1 = localTroopAIOAppInfo;
          if (localTroopAIOAppInfo.appid != paramInt) {
            continue;
          }
          localTroopAIOAppInfo.redPoint = false;
          bool = true;
          localObject1 = localTroopAIOAppInfo;
          if (bool) {
            ThreadManager.a(new vpf(this, localEntityManager, (TroopAIOAppInfo)localObject1), 8, null, false);
          }
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_app", 2, "appid" + paramInt + "clearLocalTroopAppRedPoint," + bool);
          }
          return;
        }
      }
      boolean bool = false;
      continue;
      Object localObject3 = null;
      bool = false;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopAppMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */