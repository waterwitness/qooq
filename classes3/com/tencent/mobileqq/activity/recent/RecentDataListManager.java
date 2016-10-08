package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RecentDataListManager
{
  private static RecentDataListManager jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public final List a;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(109);
  public List b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private RecentDataListManager()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
  }
  
  public static RecentDataListManager a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager = new RecentDataListManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityRecentRecentDataListManager;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramString + "-" + paramInt;
  }
  
  private void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    TraceUtils.a("splitRecents");
    ArrayList localArrayList1 = new ArrayList(4);
    ArrayList localArrayList2 = new ArrayList(4);
    ArrayList localArrayList3 = new ArrayList(4);
    localArrayList1.add(paramQQAppInterface.a());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      switch (localRecentUser.type)
      {
      default: 
        break;
      case 0: 
        localArrayList1.add(localRecentUser.uin);
        break;
      case 1: 
        localArrayList2.add(localRecentUser.uin);
        break;
      case 3000: 
        localArrayList3.add(localRecentUser.uin);
      }
    }
    TraceUtils.a();
    if (localArrayList1.size() > 2) {
      ((FriendsManager)paramQQAppInterface.getManager(50)).a(localArrayList1);
    }
    if (localArrayList3.size() > 2) {
      ((DiscussionManager)paramQQAppInterface.getManager(52)).a(localArrayList3);
    }
    if (localArrayList2.size() > 2) {
      ((TroopManager)paramQQAppInterface.getManager(51)).a(localArrayList2);
    }
  }
  
  public RecentBaseData a(String paramString)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)))
      {
        paramString = (RecentBaseData)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, paramString.toString());
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString)) && (paramRecentBaseData != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramRecentBaseData);
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramQQAppInterface == null)
    {
      localObject = null;
      if (localObject == null) {
        break label176;
      }
    }
    label31:
    label118:
    label176:
    for (Object localObject = ((RecentUserProxy)localObject).a(true);; localObject = null)
    {
      int i;
      int j;
      if (localObject == null)
      {
        i = 0;
        j = Math.min(8, i);
        if (j > 0)
        {
          if (paramBoolean) {
            break label118;
          }
          a(paramQQAppInterface, (List)localObject);
          this.b = new ArrayList(j);
          ConversationDataFactory.a((List)localObject, paramQQAppInterface, paramContext, this.b, j);
        }
      }
      for (;;)
      {
        paramBoolean = bool;
        if (j > 0) {
          paramBoolean = true;
        }
        return paramBoolean;
        localObject = paramQQAppInterface.a().a();
        break;
        i = ((List)localObject).size();
        break label31;
        paramQQAppInterface = new RecentFaceDecoder(paramQQAppInterface);
        i = 0;
        while (i < j)
        {
          paramContext = (RecentUser)((List)localObject).get(i);
          if (paramContext != null) {
            paramQQAppInterface.a(paramContext.type, paramContext.uin);
          }
          i += 1;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentDataListManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */