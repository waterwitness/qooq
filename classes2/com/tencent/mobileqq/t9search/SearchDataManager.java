package com.tencent.mobileqq.t9search;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SearchDataManager
{
  private static final int jdField_a_of_type_Int = 1;
  private static final String jdField_a_of_type_JavaLangString = "SearchDataManager";
  private static final int b = 2;
  private static final int c = 3;
  
  public SearchDataManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject;
    if (paramBoolean1)
    {
      ExecutorService localExecutorService = Executors.newFixedThreadPool(1);
      localObject = localExecutorService;
      if (!paramBoolean2) {
        break label200;
      }
      localArrayList2.add(localExecutorService.submit(new SearchDataManager.CallableForSearchData(paramQQAppInterface, 2)));
      paramQQAppInterface = localExecutorService;
    }
    for (;;)
    {
      int i = 0;
      try
      {
        for (;;)
        {
          if (i < localArrayList2.size())
          {
            localObject = (List)((Future)localArrayList2.get(i)).get();
            localArrayList1.addAll((Collection)localObject);
            ((List)localObject).clear();
            i += 1;
            continue;
            localObject = Executors.newFixedThreadPool(3);
            localArrayList2.add(((ExecutorService)localObject).submit(new SearchDataManager.CallableForSearchData(paramQQAppInterface, 1)));
            if (paramBoolean2) {
              localArrayList2.add(((ExecutorService)localObject).submit(new SearchDataManager.CallableForSearchData(paramQQAppInterface, 2)));
            }
            localArrayList2.add(((ExecutorService)localObject).submit(new SearchDataManager.CallableForSearchData(paramQQAppInterface, 3)));
            label200:
            paramQQAppInterface = (QQAppInterface)localObject;
            break;
          }
        }
        localArrayList2.clear();
        paramQQAppInterface.shutdown();
        return localArrayList1;
      }
      catch (InterruptedException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return localArrayList1;
      }
      catch (ExecutionException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
    return localArrayList1;
  }
  
  private static List d(QQAppInterface paramQQAppInterface)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(50);
    if (localFriendsManager != null)
    {
      Object localObject1 = localFriendsManager.a();
      paramQQAppInterface = paramQQAppInterface.a();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = localFriendsManager.a(String.valueOf(((Groups)((Iterator)localObject1).next()).group_id));
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Friends localFriends = (Friends)((Iterator)localObject2).next();
              if (!localFriends.uin.equals(paramQQAppInterface))
              {
                localArrayList.add(new T9SearchableData(localFriends));
                if (QLog.isColorLevel()) {
                  QLog.d("SearchDataManager", 2, "friend uin:" + localFriends.uin);
                }
              }
            }
          }
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchDataManager", 2, "getFriends() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private static List e(QQAppInterface paramQQAppInterface)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (localObject != null)
    {
      localObject = ((PhoneContactManager)localObject).c();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(new T9SearchableData((PhoneContact)((Iterator)localObject).next(), paramQQAppInterface));
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchDataManager", 2, "getPhoneContacts() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  private static List f(QQAppInterface paramQQAppInterface)
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((QCallFacade)paramQQAppInterface.getManager(37)).a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QCallRecent localQCallRecent = (QCallRecent)((Iterator)localObject).next();
        localArrayList.add(new T9SearchableData(localQCallRecent, paramQQAppInterface));
        if (QLog.isColorLevel()) {
          QLog.d("SearchDataManager", 2, "recent:" + localQCallRecent + "\n");
        }
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("SearchDataManager", 2, "getRecentCalls() time cost = " + (l2 - l1) + " , size = " + localArrayList.size());
    }
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\t9search\SearchDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */