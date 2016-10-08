package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloActionPackageData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import psr;

public class ApolloDaoManager
  implements Manager
{
  public static final String a = "ApolloDaoManager";
  public QQAppInterface a;
  private Runnable a;
  public List a;
  public List b;
  public List c;
  public List d;
  
  public ApolloDaoManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.b = Collections.synchronizedList(new ArrayList());
    this.c = Collections.synchronizedList(new ArrayList());
    this.d = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_JavaLangRunnable = new psr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ThreadManager.a().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public static List a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQAppInterface == null) {
      return localArrayList;
    }
    String str = paramQQAppInterface.f();
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.a(ApolloActionRecentData.class, false, "uin=? and sessionType=?", new String[] { str, paramString }, null, null, null, null);; paramQQAppInterface = localArrayList) {
      return paramQQAppInterface;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData)
  {
    if ((paramQQAppInterface == null) || (paramApolloActionRecentData == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(paramApolloActionRecentData);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData1, ApolloActionRecentData paramApolloActionRecentData2)
  {
    if ((paramQQAppInterface == null) || (paramApolloActionRecentData1 == null) || (paramApolloActionRecentData2 == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.b(paramApolloActionRecentData2);
    paramQQAppInterface.a(paramApolloActionRecentData1);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, ApolloActionRecentData paramApolloActionRecentData)
  {
    if ((paramQQAppInterface == null) || (paramApolloActionRecentData == null)) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramApolloActionRecentData);
  }
  
  public int a(int paramInt)
  {
    int i = -1;
    Object localObject1;
    if (this.b != null)
    {
      localObject1 = this.b;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.b.size())
        {
          if (((ApolloActionPackage)this.b.get(i)).type == paramInt)
          {
            i = ((ApolloActionPackage)this.b.get(i)).packageId;
            int j = i;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
              j = i;
              if (localObject1 != null)
              {
                localObject1 = (ApolloActionPackage)((EntityManager)localObject1).a(ApolloActionPackage.class, "type=?", new String[] { paramInt + "" });
                j = i;
                if (localObject1 != null) {
                  j = ((ApolloActionPackage)localObject1).packageId;
                }
              }
            }
            return j;
          }
          i += 1;
        }
        else
        {
          i = -1;
        }
      }
      finally {}
    }
  }
  
  public ApolloActionData a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      for (;;)
      {
        int i;
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          i = this.jdField_a_of_type_JavaUtilList.size() - 1;
          if (i < 0) {
            break;
          }
          if (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i)).actionId == paramInt)
          {
            ApolloActionData localApolloActionData = (ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i);
            return localApolloActionData;
          }
        }
        i -= 1;
      }
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (??? != null) {
      return (ApolloActionData)((EntityManager)???).a(ApolloActionData.class, paramInt + "");
    }
    return null;
  }
  
  public ApolloActionPackage a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if (this.b != null) {
      for (;;)
      {
        int i;
        synchronized (this.b)
        {
          i = this.b.size() - 1;
          if (i < 0) {
            break;
          }
          if (((ApolloActionPackage)this.b.get(i)).packageId == paramInt)
          {
            ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)this.b.get(i);
            return localApolloActionPackage;
          }
        }
        i -= 1;
      }
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (??? != null) {
      return (ApolloActionPackage)((EntityManager)???).a(ApolloActionPackage.class, paramInt + "");
    }
    return null;
  }
  
  public ApolloFavActionData a(long paramLong)
  {
    Object localObject4 = null;
    List localList;
    int i;
    if (this.d != null)
    {
      localList = this.d;
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = localObject4;
      try
      {
        if (i < this.d.size())
        {
          if (((ApolloFavActionData)this.d.get(i)).favId != paramLong) {
            break label160;
          }
          localObject1 = (ApolloFavActionData)this.d.get(i);
        }
        return (ApolloFavActionData)localObject1;
      }
      finally {}
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localObject3 != null) {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "find ApolloFavActionData favid=" + paramLong);
          }
        }
        for (localObject3 = (ApolloFavActionData)((EntityManager)localObject3).a(ApolloFavActionData.class, paramLong);; localObject3 = null) {
          return (ApolloFavActionData)localObject3;
        }
      }
      return null;
      label160:
      i += 1;
    }
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EntityManager localEntityManager;
    do
    {
      return null;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        return this.jdField_a_of_type_JavaUtilList;
      }
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    } while (localEntityManager == null);
    return localEntityManager.a(ApolloActionData.class);
  }
  
  public List a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i)).feeType != paramInt) {
            break label174;
          }
          localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(i));
          break label174;
        }
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          return localArrayList;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (??? != null) {
          return ((EntityManager)???).a(ApolloActionData.class, false, "feeType=?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
        }
      }
      return new ArrayList();
      label174:
      i += 1;
    }
  }
  
  public List a(SessionInfo paramSessionInfo)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if ((localObject == null) || (paramSessionInfo == null))
        {
          paramSessionInfo = null;
          return paramSessionInfo;
        }
        if (paramSessionInfo.a == 0)
        {
          paramSessionInfo = "1";
          if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
            continue;
          }
          localObject = new ArrayList();
          i = 0;
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            if ((((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i)).sessionType != Integer.parseInt(paramSessionInfo)) && (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i)).sessionType != 0)) {
              break label235;
            }
            ((List)localObject).add(this.jdField_a_of_type_JavaUtilList.get(i));
            break label235;
          }
        }
        else
        {
          if (paramSessionInfo.a == 1) {
            break label242;
          }
          if (paramSessionInfo.a != 3000) {
            break label229;
          }
          break label242;
        }
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramSessionInfo = (SessionInfo)localObject;
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localObject != null)
        {
          paramSessionInfo = ((EntityManager)localObject).a(ApolloActionData.class, false, "sessionType=? or sessionType=?", new String[] { "0", paramSessionInfo }, null, null, null, null);
          continue;
        }
        paramSessionInfo = null;
        continue;
        paramSessionInfo = "";
      }
      finally {}
      label229:
      continue;
      label235:
      i += 1;
      continue;
      label242:
      paramSessionInfo = "2";
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    EntityManager localEntityManager;
    List localList;
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localEntityManager != null)
        {
          localList = localEntityManager.a(ApolloActionData.class);
          if (localList != null) {
            ??? = localEntityManager.a();
          }
        }
      }
    }
    try
    {
      ((EntityTransaction)???).a();
      int i = 0;
      while (i < localList.size())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)localList.get(i);
        if (localApolloActionData != null) {
          localEntityManager.b(localApolloActionData);
        }
        i += 1;
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      ((EntityTransaction)???).c();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      ((EntityTransaction)???).b();
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          if ((this.jdField_a_of_type_JavaUtilList.get(i) != null) && (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i)).actionId == paramApolloActionData.actionId))
          {
            this.jdField_a_of_type_JavaUtilList.remove(i);
            this.jdField_a_of_type_JavaUtilList.add(i, paramApolloActionData);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            continue;
          }
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).a(paramApolloActionData);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void a(ApolloActionPackage paramApolloActionPackage)
  {
    if ((paramApolloActionPackage == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (this.b != null) {}
      synchronized (this.b)
      {
        int i = this.b.size() - 1;
        if (i >= 0)
        {
          if ((this.b.get(i) != null) && (((ApolloActionPackage)this.b.get(i)).packageId == paramApolloActionPackage.packageId))
          {
            this.b.remove(i);
            this.b.add(i, paramApolloActionPackage);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            continue;
          }
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).a(paramApolloActionPackage);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void a(ApolloActionPackageData paramApolloActionPackageData)
  {
    if (paramApolloActionPackageData == null) {}
    for (;;)
    {
      return;
      if (this.c != null) {}
      synchronized (this.c)
      {
        this.c.add(paramApolloActionPackageData);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          continue;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (??? == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "insert ApolloActionPackageData id=" + paramApolloActionPackageData.acitonId + " text=" + paramApolloActionPackageData.text + " packid=" + paramApolloActionPackageData.packageId);
        }
        ((EntityManager)???).a(paramApolloActionPackageData);
        return;
      }
    }
  }
  
  public void a(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {}
    for (;;)
    {
      return;
      if (this.d != null) {}
      synchronized (this.d)
      {
        this.d.add(paramApolloFavActionData);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          continue;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (??? == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "insert ApolloFavActionData id=" + paramApolloFavActionData.acitonId + " text=" + paramApolloFavActionData.text);
        }
        ((EntityManager)???).a(paramApolloFavActionData);
        return;
      }
    }
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if (localEntityManager != null)
      {
        ??? = localEntityManager.a();
        ((EntityTransaction)???).a();
      }
      try
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)localIterator.next();
          a(localEntityManager, localApolloActionData);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "saveAction ID: " + localApolloActionData.actionId);
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "saveAction exception: ", localException);
        }
        ((EntityTransaction)???).b();
        while (this.jdField_a_of_type_JavaUtilList != null)
        {
          synchronized (this.jdField_a_of_type_JavaUtilList)
          {
            this.jdField_a_of_type_JavaUtilList.addAll(paramList);
            return;
          }
          ((EntityTransaction)???).c();
          ((EntityTransaction)???).b();
        }
      }
      finally
      {
        ((EntityTransaction)???).b();
      }
    }
  }
  
  public boolean a(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return paramEntityManager.a(paramEntity);
      }
    }
    QLog.d("ApolloDaoManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public List b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i)).isShow != 0) {
            break label170;
          }
          localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(i));
          break label170;
        }
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          return localArrayList;
        }
        ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (??? != null) {
          return ((EntityManager)???).a(ApolloActionData.class, false, "isShow=?", new String[] { String.valueOf(0) }, null, null, null, null);
        }
      }
      return new ArrayList();
      label170:
      i += 1;
    }
  }
  
  public List b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    List localList = c(paramInt);
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramInt = 0;
      while (paramInt < localList.size())
      {
        if (((ApolloActionData)localList.get(paramInt)).status == 0) {
          localArrayList.add(localList.get(paramInt));
        }
        paramInt += 1;
      }
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        return localArrayList;
      }
    }
    return null;
  }
  
  public List b(SessionInfo paramSessionInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramSessionInfo == null)) {
      return null;
    }
    if (paramSessionInfo.a == 0) {
      paramSessionInfo = "1";
    }
    for (;;)
    {
      if ((this.b != null) && (this.b.size() > 0))
      {
        localObject = new ArrayList();
        int i = 0;
        for (;;)
        {
          if (i < this.b.size())
          {
            if ((((ApolloActionPackage)this.b.get(i)).sessionType == Integer.parseInt(paramSessionInfo)) || (((ApolloActionPackage)this.b.get(i)).sessionType == 0)) {
              ((List)localObject).add(this.b.get(i));
            }
            i += 1;
            continue;
            if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000)) {
              break label227;
            }
            paramSessionInfo = "2";
            break;
          }
        }
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "return packageInfoBySession from cache");
          }
          return (List)localObject;
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if (localObject == null) {
        break;
      }
      return ((EntityManager)localObject).a(ApolloActionPackage.class, false, "sessionType=? or sessionType=?", new String[] { "0", paramSessionInfo }, null, null, null, null);
      label227:
      paramSessionInfo = "";
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      if (this.b != null) {}
      EntityManager localEntityManager;
      synchronized (this.b)
      {
        this.b.clear();
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        if (localEntityManager == null) {
          continue;
        }
        ??? = localEntityManager.a();
      }
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    if ((paramApolloActionData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList != null) {}
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(i) != null) && (((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i)).actionId == paramApolloActionData.actionId))
          {
            this.jdField_a_of_type_JavaUtilList.remove(i);
            this.jdField_a_of_type_JavaUtilList.add(i, paramApolloActionData);
          }
        }
        else
        {
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          if (??? == null) {
            continue;
          }
          ((EntityManager)???).a(paramApolloActionData);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void b(ApolloFavActionData paramApolloFavActionData)
  {
    if (paramApolloFavActionData == null) {}
    for (;;)
    {
      return;
      if (this.d != null) {}
      synchronized (this.d)
      {
        int i = this.d.size() - 1;
        if (i >= 0)
        {
          if (((ApolloFavActionData)this.d.get(i)).favId == paramApolloFavActionData.favId) {
            this.d.remove(i);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            continue;
          }
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          if (??? == null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDaoManager", 2, "insert ApolloFavActionData id=" + paramApolloFavActionData.toString());
          }
          ((EntityManager)???).b(paramApolloFavActionData);
          return;
        }
        i -= 1;
      }
    }
  }
  
  public void b(List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramList == null)) {
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null)) {}
    for (;;)
    {
      int i;
      int j;
      EntityManager localEntityManager;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        i = this.jdField_a_of_type_JavaUtilList.size() - 1;
        if (i >= 0)
        {
          j = paramList.size() - 1;
          if (j <= 0) {
            break label233;
          }
          if (((ApolloActionData)paramList.get(j)).actionId != ((ApolloActionData)this.jdField_a_of_type_JavaUtilList.get(i)).actionId) {
            break label224;
          }
          this.jdField_a_of_type_JavaUtilList.remove(i);
          this.jdField_a_of_type_JavaUtilList.add(i, paramList.get(j));
          break label224;
        }
        localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        ??? = localEntityManager.a();
      }
      try
      {
        ((EntityTransaction)???).a();
        i = 0;
        while (i < paramList.size())
        {
          a(localEntityManager, (Entity)paramList.get(i));
          i += 1;
          continue;
          paramList = finally;
          throw paramList;
        }
        ((EntityTransaction)???).c();
        return;
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      finally
      {
        ((EntityTransaction)???).b();
      }
      label224:
      j -= 1;
      continue;
      label233:
      i -= 1;
    }
  }
  
  public List c()
  {
    label116:
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject1 == null)
        {
          localObject1 = null;
          return (List)localObject1;
        }
        List localList = e();
        int i;
        if ((localList != null) && (localList.size() > 0))
        {
          localObject1 = new ArrayList();
          i = 0;
          if (i < localList.size())
          {
            if (((ApolloActionData)localList.get(i)).status != 0) {
              break label116;
            }
            ((List)localObject1).add(localList.get(i));
            break label116;
          }
          if (localObject1 != null)
          {
            i = ((List)localObject1).size();
            if (i > 0) {
              continue;
            }
          }
        }
        localObject1 = null;
        continue;
        i += 1;
      }
      finally {}
    }
  }
  
  public List c(int paramInt)
  {
    int j = 0;
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    int i;
    if ((this.c != null) && (this.c.size() > 0))
    {
      ??? = this.c;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.c.size())
        {
          if (((ApolloActionPackageData)this.c.get(i)).packageId != paramInt) {
            break label302;
          }
          localArrayList1.add(this.c.get(i));
          break label302;
        }
        if (localArrayList1 == null) {
          break label300;
        }
        paramInt = j;
        if (paramInt >= localArrayList1.size()) {
          break label300;
        }
        ??? = a(((ApolloActionPackageData)localArrayList1.get(paramInt)).acitonId);
        if (??? == null) {
          break label243;
        }
        localArrayList2.add(???);
        paramInt += 1;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label181;
        }
      }
      finally {}
      return null;
      label181:
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if (??? != null)
      {
        List localList = ((EntityManager)???).a(ApolloActionPackageData.class, false, "packageId=?", new String[] { paramInt + "" }, null, null, null, null);
        continue;
        label243:
        if ((this.c != null) && (this.c.size() > 0))
        {
          synchronized (this.c)
          {
            this.c.remove(localList.get(paramInt));
          }
          label300:
          return localArrayList2;
          label302:
          i += 1;
        }
      }
    }
  }
  
  public void c()
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (localEntityManager == null) {
      return;
    }
    if (this.c != null) {}
    synchronized (this.c)
    {
      this.c.clear();
      ??? = localEntityManager.a();
    }
  }
  
  /* Error */
  public void c(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 107 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 40	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 40	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   25: aload_1
    //   26: invokeinterface 292 2 0
    //   31: pop
    //   32: aload_2
    //   33: monitorexit
    //   34: aload_0
    //   35: getfield 53	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: ifnull -25 -> 13
    //   41: aload_0
    //   42: getfield 53	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   48: invokevirtual 81	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull -40 -> 13
    //   56: aload_3
    //   57: invokevirtual 222	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   60: astore_2
    //   61: aload_2
    //   62: invokevirtual 226	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   65: aload_1
    //   66: invokeinterface 269 1 0
    //   71: astore_1
    //   72: aload_1
    //   73: invokeinterface 274 1 0
    //   78: ifeq +88 -> 166
    //   81: aload_1
    //   82: invokeinterface 278 1 0
    //   87: checkcast 113	com/tencent/mobileqq/data/ApolloActionPackage
    //   90: astore 4
    //   92: aload_0
    //   93: aload_3
    //   94: aload 4
    //   96: invokevirtual 281	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   99: pop
    //   100: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq -31 -> 72
    //   106: ldc 10
    //   108: iconst_2
    //   109: new 124	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 283
    //   119: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 4
    //   124: getfield 120	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   127: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: goto -64 -> 72
    //   139: astore_1
    //   140: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +13 -> 156
    //   146: ldc 10
    //   148: iconst_2
    //   149: ldc_w 285
    //   152: aload_1
    //   153: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   156: aload_2
    //   157: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   160: return
    //   161: astore_1
    //   162: aload_2
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    //   166: aload_2
    //   167: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   170: aload_2
    //   171: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   174: return
    //   175: astore_1
    //   176: aload_2
    //   177: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   180: aload_1
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	ApolloDaoManager
    //   0	182	1	paramList	List
    //   18	159	2	localObject	Object
    //   51	43	3	localEntityManager	EntityManager
    //   90	33	4	localApolloActionPackage	ApolloActionPackage
    // Exception table:
    //   from	to	target	type
    //   65	72	139	java/lang/Exception
    //   72	136	139	java/lang/Exception
    //   166	170	139	java/lang/Exception
    //   21	34	161	finally
    //   162	164	161	finally
    //   65	72	175	finally
    //   72	136	175	finally
    //   140	156	175	finally
    //   166	170	175	finally
  }
  
  public List d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (this.d != null) {
      localObject = this.d;
    }
    EntityManager localEntityManager;
    do
    {
      do
      {
        return (List)localObject;
        localObject = localArrayList;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject = localArrayList;
    } while (localEntityManager == null);
    return localEntityManager.a(ApolloFavActionData.class);
  }
  
  public List d(int paramInt)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if (this.c != null) {}
    List localList;
    for (;;)
    {
      synchronized (this.c)
      {
        if (i < this.c.size())
        {
          if (((ApolloActionPackageData)this.c.get(i)).packageId != paramInt) {
            break label173;
          }
          localArrayList.add(this.c.get(i));
          break label173;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloDaoManager", 2, "return getPackageActionDataById from cache");
        }
        return localArrayList;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      if (??? != null) {
        localList = ((EntityManager)???).a(ApolloActionPackageData.class, false, "packageId=?", new String[] { paramInt + "" }, null, null, null, null);
      }
      for (;;)
      {
        return localList;
      }
      label173:
      i += 1;
    }
    return localList;
  }
  
  /* Error */
  public void d(List paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +12 -> 13
    //   4: aload_1
    //   5: invokeinterface 107 1 0
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_0
    //   15: getfield 42	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	Ljava/util/List;
    //   18: ifnull +23 -> 41
    //   21: aload_0
    //   22: getfield 42	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	Ljava/util/List;
    //   25: astore_2
    //   26: aload_2
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 42	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	Ljava/util/List;
    //   32: aload_1
    //   33: invokeinterface 292 2 0
    //   38: pop
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: getfield 53	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: ifnull -32 -> 13
    //   48: aload_0
    //   49: getfield 53	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   55: invokevirtual 81	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -47 -> 13
    //   63: aload_3
    //   64: invokevirtual 222	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 226	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   72: aload_1
    //   73: invokeinterface 269 1 0
    //   78: astore_1
    //   79: aload_1
    //   80: invokeinterface 274 1 0
    //   85: ifeq +88 -> 173
    //   88: aload_1
    //   89: invokeinterface 278 1 0
    //   94: checkcast 248	com/tencent/mobileqq/data/ApolloActionPackageData
    //   97: astore 4
    //   99: aload_0
    //   100: aload_3
    //   101: aload 4
    //   103: invokevirtual 281	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:a	(Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   106: pop
    //   107: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq -31 -> 79
    //   113: ldc 10
    //   115: iconst_2
    //   116: new 124	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   123: ldc_w 340
    //   126: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload 4
    //   131: getfield 259	com/tencent/mobileqq/data/ApolloActionPackageData:packageId	I
    //   134: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: goto -64 -> 79
    //   146: astore_1
    //   147: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +13 -> 163
    //   153: ldc 10
    //   155: iconst_2
    //   156: ldc_w 285
    //   159: aload_1
    //   160: invokestatic 288	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_2
    //   164: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   167: return
    //   168: astore_1
    //   169: aload_2
    //   170: monitorexit
    //   171: aload_1
    //   172: athrow
    //   173: aload_2
    //   174: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   177: aload_2
    //   178: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   181: return
    //   182: astore_1
    //   183: aload_2
    //   184: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   187: aload_1
    //   188: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	ApolloDaoManager
    //   0	189	1	paramList	List
    //   25	159	2	localObject	Object
    //   58	43	3	localEntityManager	EntityManager
    //   97	33	4	localApolloActionPackageData	ApolloActionPackageData
    // Exception table:
    //   from	to	target	type
    //   72	79	146	java/lang/Exception
    //   79	143	146	java/lang/Exception
    //   173	177	146	java/lang/Exception
    //   28	41	168	finally
    //   169	171	168	finally
    //   72	79	182	finally
    //   79	143	182	finally
    //   147	163	182	finally
    //   173	177	182	finally
  }
  
  public List e()
  {
    ArrayList localArrayList = new ArrayList();
    List localList1;
    int i;
    if (this.d != null)
    {
      localList1 = this.d;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.d.size())
        {
          ApolloActionData localApolloActionData = a(((ApolloFavActionData)this.d.get(i)).acitonId);
          if (localApolloActionData == null) {
            break label102;
          }
          localArrayList.add(localApolloActionData);
          break label102;
        }
        return localArrayList;
      }
      finally {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloDaoManager", 2, "favActionList is null");
      return localList2;
      label102:
      i += 1;
    }
    return localList2;
  }
  
  /* Error */
  public List e(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 29	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 30	java/util/ArrayList:<init>	()V
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 40	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   15: ifnull +300 -> 315
    //   18: aload_0
    //   19: getfield 40	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   22: astore_3
    //   23: aload_3
    //   24: monitorenter
    //   25: iconst_0
    //   26: istore 4
    //   28: iload 4
    //   30: aload_0
    //   31: getfield 40	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   34: invokeinterface 107 1 0
    //   39: if_icmpge +270 -> 309
    //   42: aload_0
    //   43: getfield 40	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   46: iload 4
    //   48: invokeinterface 111 2 0
    //   53: checkcast 113	com/tencent/mobileqq/data/ApolloActionPackage
    //   56: getfield 117	com/tencent/mobileqq/data/ApolloActionPackage:type	I
    //   59: iload_1
    //   60: if_icmpne +99 -> 159
    //   63: aload_0
    //   64: getfield 40	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:b	Ljava/util/List;
    //   67: iload 4
    //   69: invokeinterface 111 2 0
    //   74: checkcast 113	com/tencent/mobileqq/data/ApolloActionPackage
    //   77: getfield 120	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   80: istore 4
    //   82: aload_3
    //   83: monitorexit
    //   84: aload_0
    //   85: getfield 42	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	Ljava/util/List;
    //   88: ifnull +94 -> 182
    //   91: aload_0
    //   92: getfield 42	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	Ljava/util/List;
    //   95: astore_3
    //   96: aload_3
    //   97: monitorenter
    //   98: iload 5
    //   100: istore_1
    //   101: iload_1
    //   102: aload_0
    //   103: getfield 42	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	Ljava/util/List;
    //   106: invokeinterface 107 1 0
    //   111: if_icmpge +62 -> 173
    //   114: aload_0
    //   115: getfield 42	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	Ljava/util/List;
    //   118: iload_1
    //   119: invokeinterface 111 2 0
    //   124: checkcast 248	com/tencent/mobileqq/data/ApolloActionPackageData
    //   127: getfield 259	com/tencent/mobileqq/data/ApolloActionPackageData:packageId	I
    //   130: iload 4
    //   132: if_icmpne +20 -> 152
    //   135: aload_2
    //   136: aload_0
    //   137: getfield 42	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:c	Ljava/util/List;
    //   140: iload_1
    //   141: invokeinterface 111 2 0
    //   146: invokeinterface 186 2 0
    //   151: pop
    //   152: iload_1
    //   153: iconst_1
    //   154: iadd
    //   155: istore_1
    //   156: goto -55 -> 101
    //   159: iload 4
    //   161: iconst_1
    //   162: iadd
    //   163: istore 4
    //   165: goto -137 -> 28
    //   168: astore_2
    //   169: aload_3
    //   170: monitorexit
    //   171: aload_2
    //   172: athrow
    //   173: aload_3
    //   174: monitorexit
    //   175: aload_2
    //   176: areturn
    //   177: astore_2
    //   178: aload_3
    //   179: monitorexit
    //   180: aload_2
    //   181: athrow
    //   182: aload_0
    //   183: getfield 53	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: ifnull +135 -> 321
    //   189: aload_0
    //   190: getfield 53	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   193: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   196: invokevirtual 81	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   199: astore_3
    //   200: aload_3
    //   201: ifnull +105 -> 306
    //   204: iload 4
    //   206: iconst_m1
    //   207: if_icmpne +93 -> 300
    //   210: aload_3
    //   211: ldc 113
    //   213: ldc 122
    //   215: iconst_1
    //   216: anewarray 87	java/lang/String
    //   219: dup
    //   220: iconst_0
    //   221: new 124	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   228: iload_1
    //   229: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc -125
    //   234: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: aastore
    //   241: invokevirtual 140	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   244: checkcast 113	com/tencent/mobileqq/data/ApolloActionPackage
    //   247: astore_2
    //   248: aload_2
    //   249: ifnull +51 -> 300
    //   252: aload_2
    //   253: getfield 120	com/tencent/mobileqq/data/ApolloActionPackage:packageId	I
    //   256: istore_1
    //   257: aload_3
    //   258: ldc -8
    //   260: iconst_0
    //   261: ldc_w 332
    //   264: iconst_1
    //   265: anewarray 87	java/lang/String
    //   268: dup
    //   269: iconst_0
    //   270: new 124	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   277: iload_1
    //   278: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc -125
    //   283: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: aastore
    //   290: aconst_null
    //   291: aconst_null
    //   292: aconst_null
    //   293: aconst_null
    //   294: invokevirtual 92	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   297: astore_2
    //   298: aload_2
    //   299: areturn
    //   300: iload 4
    //   302: istore_1
    //   303: goto -46 -> 257
    //   306: goto -8 -> 298
    //   309: iconst_m1
    //   310: istore 4
    //   312: goto -230 -> 82
    //   315: iconst_m1
    //   316: istore 4
    //   318: goto -234 -> 84
    //   321: aload_2
    //   322: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	ApolloDaoManager
    //   0	323	1	paramInt	int
    //   10	126	2	localArrayList	ArrayList
    //   168	8	2	localList	List
    //   177	4	2	localObject1	Object
    //   247	75	2	localObject2	Object
    //   22	236	3	localObject3	Object
    //   26	291	4	i	int
    //   1	98	5	j	int
    // Exception table:
    //   from	to	target	type
    //   28	82	168	finally
    //   82	84	168	finally
    //   169	171	168	finally
    //   101	152	177	finally
    //   173	175	177	finally
    //   178	180	177	finally
  }
  
  /* Error */
  public void e(List paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_1
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:d	Ljava/util/List;
    //   12: ifnull +94 -> 106
    //   15: aload_0
    //   16: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:d	Ljava/util/List;
    //   19: astore_2
    //   20: aload_2
    //   21: monitorenter
    //   22: iconst_0
    //   23: istore 4
    //   25: iload 4
    //   27: aload_1
    //   28: invokeinterface 107 1 0
    //   33: if_icmpge +71 -> 104
    //   36: aload_0
    //   37: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:d	Ljava/util/List;
    //   40: invokeinterface 107 1 0
    //   45: iconst_1
    //   46: isub
    //   47: istore 5
    //   49: iload 5
    //   51: iflt +162 -> 213
    //   54: aload_0
    //   55: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:d	Ljava/util/List;
    //   58: iload 5
    //   60: invokeinterface 111 2 0
    //   65: checkcast 153	com/tencent/mobileqq/data/ApolloFavActionData
    //   68: getfield 157	com/tencent/mobileqq/data/ApolloFavActionData:favId	J
    //   71: aload_1
    //   72: iload 4
    //   74: invokeinterface 111 2 0
    //   79: checkcast 153	com/tencent/mobileqq/data/ApolloFavActionData
    //   82: getfield 157	com/tencent/mobileqq/data/ApolloFavActionData:favId	J
    //   85: lcmp
    //   86: ifne +118 -> 204
    //   89: aload_0
    //   90: getfield 44	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:d	Ljava/util/List;
    //   93: iload 5
    //   95: invokeinterface 237 2 0
    //   100: pop
    //   101: goto +103 -> 204
    //   104: aload_2
    //   105: monitorexit
    //   106: aload_0
    //   107: getfield 53	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   110: ifnull -103 -> 7
    //   113: aload_0
    //   114: getfield 53	com/tencent/mobileqq/apollo/utils/ApolloDaoManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   117: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   120: invokevirtual 81	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   123: astore_3
    //   124: aload_3
    //   125: invokevirtual 222	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual 226	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   133: iload 6
    //   135: istore 4
    //   137: iload 4
    //   139: aload_1
    //   140: invokeinterface 107 1 0
    //   145: if_icmpge +33 -> 178
    //   148: aload_3
    //   149: aload_1
    //   150: iload 4
    //   152: invokeinterface 111 2 0
    //   157: checkcast 296	com/tencent/mobileqq/persistence/Entity
    //   160: invokevirtual 96	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   163: pop
    //   164: iload 4
    //   166: iconst_1
    //   167: iadd
    //   168: istore 4
    //   170: goto -33 -> 137
    //   173: astore_1
    //   174: aload_2
    //   175: monitorexit
    //   176: aload_1
    //   177: athrow
    //   178: aload_2
    //   179: invokevirtual 228	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   182: aload_2
    //   183: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   186: return
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   192: aload_2
    //   193: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   196: return
    //   197: astore_1
    //   198: aload_2
    //   199: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   202: aload_1
    //   203: athrow
    //   204: iload 5
    //   206: iconst_1
    //   207: isub
    //   208: istore 5
    //   210: goto -161 -> 49
    //   213: iload 4
    //   215: iconst_1
    //   216: iadd
    //   217: istore 4
    //   219: goto -194 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	ApolloDaoManager
    //   0	222	1	paramList	List
    //   19	180	2	localObject	Object
    //   123	26	3	localEntityManager	EntityManager
    //   23	195	4	i	int
    //   47	162	5	j	int
    //   1	133	6	k	int
    // Exception table:
    //   from	to	target	type
    //   25	49	173	finally
    //   54	101	173	finally
    //   104	106	173	finally
    //   174	176	173	finally
    //   129	133	187	java/lang/Exception
    //   137	164	187	java/lang/Exception
    //   178	182	187	java/lang/Exception
    //   129	133	197	finally
    //   137	164	197	finally
    //   178	182	197	finally
    //   188	192	197	finally
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\utils\ApolloDaoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */