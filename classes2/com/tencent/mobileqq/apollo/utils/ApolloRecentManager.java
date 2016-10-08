package com.tencent.mobileqq.apollo.utils;

import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.data.ApolloActionRecentData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import pss;

public class ApolloRecentManager
  implements Manager
{
  public static final String a = "ApolloRecentManager";
  public QQAppInterface a;
  public List a;
  public List b;
  
  public ApolloRecentManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.b = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = ApolloDaoManager.a(paramQQAppInterface, "recent_c2c");
    this.b = ApolloDaoManager.a(paramQQAppInterface, "recent_troop");
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    }
    if (this.b == null) {
      this.b = Collections.synchronizedList(new ArrayList());
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() > 8)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(i - 8, this.jdField_a_of_type_JavaUtilList.size());
    }
    if (this.b.size() > 8)
    {
      i = this.b.size();
      this.b = this.b.subList(i - 8, this.b.size());
    }
  }
  
  public void a(ApolloActionRecentData paramApolloActionRecentData1, ApolloActionRecentData paramApolloActionRecentData2)
  {
    if ((paramApolloActionRecentData1 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    ThreadManager.a(new pss(this, paramApolloActionRecentData2, paramApolloActionRecentData1), 5, null, false);
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    int k = 1;
    if (paramApolloActionData == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRecentManager", 2, "insertRecent action id=" + paramApolloActionData.actionId);
        }
        int m = paramApolloActionData.actionId;
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break;
        }
        ApolloActionRecentData localApolloActionRecentData = new ApolloActionRecentData();
        if (this.jdField_a_of_type_JavaUtilList.size() <= 0)
        {
          i = 1;
          j = this.jdField_a_of_type_JavaUtilList.size() - 1;
          if (j < 0) {
            break label355;
          }
          if (m != ((ApolloActionRecentData)this.jdField_a_of_type_JavaUtilList.get(j)).actionId) {
            break label346;
          }
          if (j == this.jdField_a_of_type_JavaUtilList.size() - 1) {
            break;
          }
          localObject = (ApolloActionRecentData)this.jdField_a_of_type_JavaUtilList.get(j);
          this.jdField_a_of_type_JavaUtilList.remove(j);
          localApolloActionRecentData.orderId = i;
          this.jdField_a_of_type_JavaUtilList.add(localApolloActionRecentData);
          j = k;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break;
          }
          localApolloActionRecentData.actionId = paramApolloActionData.actionId;
          localApolloActionRecentData.orderId = i;
          localApolloActionRecentData.sessionType = "recent_c2c";
          localApolloActionRecentData.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
          paramApolloActionData = (ApolloActionData)localObject;
          if (j == 0)
          {
            if (this.jdField_a_of_type_JavaUtilList.size() >= 8) {
              localObject = (ApolloActionRecentData)this.jdField_a_of_type_JavaUtilList.remove(0);
            }
            this.jdField_a_of_type_JavaUtilList.add(localApolloActionRecentData);
            paramApolloActionData = (ApolloActionData)localObject;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
          if (localObject != null) {
            ((MqqHandler)localObject).obtainMessage(44).sendToTarget();
          }
          a(localApolloActionRecentData, paramApolloActionData);
          break;
        }
      }
      finally {}
      int i = ((ApolloActionRecentData)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).orderId;
      i += 1;
      continue;
      label346:
      j -= 1;
      continue;
      label355:
      int j = 0;
      Object localObject = null;
    }
  }
  
  public void a(ApolloActionData paramApolloActionData, SessionInfo paramSessionInfo)
  {
    if ((paramApolloActionData == null) || (paramSessionInfo == null)) {}
    for (;;)
    {
      return;
      try
      {
        if (paramSessionInfo.a == 0)
        {
          a(paramApolloActionData);
          continue;
        }
      }
      finally {}
      if ((paramSessionInfo.a == 1) || (paramSessionInfo.a == 3000)) {
        b(paramApolloActionData);
      }
    }
  }
  
  public void b(ApolloActionData paramApolloActionData)
  {
    int k = 1;
    if (paramApolloActionData == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloRecentManager", 2, "insertRecent troop action id=" + paramApolloActionData.actionId);
        }
        int m = paramApolloActionData.actionId;
        if (this.b == null) {
          break;
        }
        ApolloActionRecentData localApolloActionRecentData = new ApolloActionRecentData();
        if (this.b.size() <= 0)
        {
          i = 1;
          j = this.b.size() - 1;
          if (j < 0) {
            break label355;
          }
          if (m != ((ApolloActionRecentData)this.b.get(j)).actionId) {
            break label346;
          }
          if (j == this.b.size() - 1) {
            break;
          }
          localObject = (ApolloActionRecentData)this.b.get(j);
          this.b.remove(j);
          localApolloActionRecentData.orderId = i;
          this.b.add(localApolloActionRecentData);
          j = k;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break;
          }
          localApolloActionRecentData.actionId = paramApolloActionData.actionId;
          localApolloActionRecentData.orderId = i;
          localApolloActionRecentData.sessionType = "recent_troop";
          localApolloActionRecentData.uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f();
          paramApolloActionData = (ApolloActionData)localObject;
          if (j == 0)
          {
            if (this.b.size() >= 8) {
              localObject = (ApolloActionRecentData)this.b.remove(0);
            }
            this.b.add(localApolloActionRecentData);
            paramApolloActionData = (ApolloActionData)localObject;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
          if (localObject != null) {
            ((MqqHandler)localObject).obtainMessage(44).sendToTarget();
          }
          a(localApolloActionRecentData, paramApolloActionData);
          break;
        }
      }
      finally {}
      int i = ((ApolloActionRecentData)this.b.get(this.b.size() - 1)).orderId;
      i += 1;
      continue;
      label346:
      j -= 1;
      continue;
      label355:
      int j = 0;
      Object localObject = null;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\utils\ApolloRecentManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */