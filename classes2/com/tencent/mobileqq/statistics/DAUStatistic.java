package com.tencent.mobileqq.statistics;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ActivityDAUInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class DAUStatistic
  implements Handler.Callback, UEC.IReporter, Manager
{
  public static final int a = 0;
  public static final long a = 120000L;
  public static final String a = "activity_dau";
  public static boolean a = false;
  public static final int b = 1;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public DAUStatistic(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.b(), this);
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      float f = Float.valueOf(paramString).floatValue();
      if (Math.random() < f) {
        jdField_a_of_type_Boolean = true;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      arrayOfString = paramString2.split("\\|");
      if (arrayOfString == null) {
        return paramString1;
      }
      i = 0;
    }
    catch (Exception localException1)
    {
      try
      {
        String[] arrayOfString;
        int i;
        if (i >= arrayOfString.length) {
          break label164;
        }
        String str1 = arrayOfString[i];
        int j = str1.indexOf("+");
        int k = str1.indexOf(":");
        paramString2 = paramString1;
        if (j > 0)
        {
          paramString2 = paramString1;
          if (k > 0)
          {
            paramString2 = str1.substring(0, j);
            String str2 = str1.substring(j + 1, k);
            str1 = str1.substring(k + 1);
            paramString2 = UEC.a(paramString1, paramString2, Integer.valueOf(str2).intValue(), Integer.valueOf(str1).intValue());
          }
        }
        i += 1;
        paramString1 = paramString2;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localException1 = localException1;
      paramString2 = paramString1;
      if (!QLog.isColorLevel()) {
        break label164;
      }
      QLog.d("Q.activity_dau", 2, "saveToDB|preActivityList error:" + localException1);
      paramString2 = paramString1;
    }
    paramString2 = paramString1;
    label164:
    return paramString2;
    return paramString1;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (jdField_a_of_type_Boolean)
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = paramArrayList;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2;
    Object localObject3;
    if (paramMessage.what == 0)
    {
      paramMessage = (ArrayList)paramMessage.obj;
      if (paramMessage != null)
      {
        paramMessage = paramMessage.iterator();
        label290:
        while (paramMessage.hasNext())
        {
          localObject2 = (UEC.UECItem)paramMessage.next();
          localObject1 = ((UEC.UECItem)localObject2).jdField_a_of_type_JavaLangString;
          if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1))
          {
            localObject3 = (ActivityDAUInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
            ((ActivityDAUInfo)localObject3).count += 1;
            ((ActivityDAUInfo)localObject3).showTime += ((UEC.UECItem)localObject2).jdField_a_of_type_Long;
            ((ActivityDAUInfo)localObject3).displayCount += ((UEC.UECItem)localObject2).jdField_b_of_type_Int;
            ((ActivityDAUInfo)localObject3).preActivityList = a(((ActivityDAUInfo)localObject3).preActivityList, ((UEC.UECItem)localObject2).jdField_b_of_type_JavaLangString);
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label290;
            }
            localObject2 = (ActivityDAUInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
            if (localObject2 == null) {
              break;
            }
            QLog.d("Q.activity_dau", 2, "reportInternal|activityName:" + (String)localObject1 + " count:" + ((ActivityDAUInfo)localObject2).count + " time:" + ((ActivityDAUInfo)localObject2).showTime + " dis:" + ((ActivityDAUInfo)localObject2).displayCount + " pre:" + ((ActivityDAUInfo)localObject2).preActivityList);
            break;
            localObject3 = new ActivityDAUInfo();
            ((ActivityDAUInfo)localObject3).count = 1;
            ((ActivityDAUInfo)localObject3).activityName = ((String)localObject1);
            ((ActivityDAUInfo)localObject3).showTime = ((UEC.UECItem)localObject2).jdField_a_of_type_Long;
            ((ActivityDAUInfo)localObject3).displayCount = ((UEC.UECItem)localObject2).jdField_b_of_type_Int;
            ((ActivityDAUInfo)localObject3).preActivityList = ((UEC.UECItem)localObject2).jdField_b_of_type_JavaLangString;
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localObject3);
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.size() >= 4)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      }
    }
    while (paramMessage.what != 1)
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1));
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 120000L);
      return false;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
        break label400;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {
        return false;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    label400:
    paramMessage = this.jdField_a_of_type_JavaUtilHashMap.keySet();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    for (;;)
    {
      try
      {
        ((EntityTransaction)localObject1).a();
        localObject2 = paramMessage.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label711;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        localActivityDAUInfo = (ActivityDAUInfo)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
        paramMessage = (ActivityDAUInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ActivityDAUInfo.class, (String)localObject3);
        if (paramMessage != null) {
          continue;
        }
        paramMessage = new ActivityDAUInfo();
        paramMessage.activityName = ((String)localObject3);
        paramMessage.count = localActivityDAUInfo.count;
        paramMessage.showTime = localActivityDAUInfo.showTime;
        paramMessage.displayCount = localActivityDAUInfo.displayCount;
        paramMessage.preActivityList = localActivityDAUInfo.preActivityList;
      }
      catch (Exception paramMessage)
      {
        ActivityDAUInfo localActivityDAUInfo;
        paramMessage.printStackTrace();
        ((EntityTransaction)localObject1).b();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.activity_dau", 2, "saveToDB|cache size:" + this.jdField_a_of_type_JavaUtilHashMap.size());
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        return false;
        paramMessage.count += localActivityDAUInfo.count;
        paramMessage.showTime += localActivityDAUInfo.showTime;
        paramMessage.displayCount += localActivityDAUInfo.displayCount;
        paramMessage.preActivityList = a(paramMessage.preActivityList, localActivityDAUInfo.preActivityList);
        continue;
      }
      finally
      {
        ((EntityTransaction)localObject1).b();
      }
      if (paramMessage.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramMessage);
      }
      else if ((paramMessage.getStatus() == 1001) || (paramMessage.getStatus() == 1002))
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramMessage);
        continue;
        label711:
        ((EntityTransaction)localObject1).c();
        ((EntityTransaction)localObject1).b();
      }
    }
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_Boolean = false;
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


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\statistics\DAUStatistic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */