package com.tencent.mobileqq.activity.qqcard;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import mqq.manager.Manager;

public class QQCardManager
  implements QQCardConstant, Manager
{
  public static final int A = 86400;
  public static final int B = -28800;
  public static final String r = "QQCard.QQCardManager";
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  
  public QQCardManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount() + "qqcard", 0);
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    int i = (int)((paramLong2 + 28800L) / 86400L);
    int j = (int)((paramLong1 + 28800L) / 86400L);
    if (QLog.isColorLevel()) {}
    return i - j;
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramString, 0L);
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, "");
  }
  
  public List a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(QQCardItem.class);
  }
  
  public Map a()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("qqcard_page_map", null);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    StringTokenizer localStringTokenizer = new StringTokenizer((String)localObject1, "^");
    for (;;)
    {
      try
      {
        if (!localStringTokenizer.hasMoreTokens()) {
          return localHashMap;
        }
        localObject1 = new StringTokenizer(localStringTokenizer.nextToken(), "'");
        int i = Integer.parseInt(((StringTokenizer)localObject1).nextToken());
        if (!((StringTokenizer)localObject1).hasMoreTokens()) {
          break label117;
        }
        localObject1 = ((StringTokenizer)localObject1).nextToken();
        localHashMap.put(Integer.valueOf(i), localObject1);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (NumberFormatException localNumberFormatException) {}
      QLog.e("QQCard.QQCardManager", 2, "getPageMap, parse String to Integer exception=", localNumberFormatException);
      return null;
      label117:
      Object localObject2 = null;
    }
    return localHashMap;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("has_clicked_" + paramInt, paramBoolean).commit();
  }
  
  public void a(String paramString, int paramInt)
  {
    ReportController.b(null, "P_CliOper", "Vip_pay_mywallet", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "wallet", paramString, 1, paramInt, "", "", "", "");
  }
  
  public void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).commit();
  }
  
  public void a(Map paramMap)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        StringBuffer localStringBuffer2 = localStringBuffer1.append(((Integer)paramMap.getKey()).toString()).append("'");
        if (paramMap.getValue() == null)
        {
          paramMap = "";
          label78:
          localStringBuffer2 = localStringBuffer2.append(paramMap);
          if (!localIterator.hasNext()) {
            break label124;
          }
        }
        label124:
        for (paramMap = "^";; paramMap = "")
        {
          localStringBuffer2.append(paramMap);
          break;
          paramMap = ((String)paramMap.getValue()).toString();
          break label78;
        }
      }
    }
    paramMap = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramMap.putString("qqcard_page_map", localStringBuffer1.toString());
    paramMap.commit();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("has_clicked_" + paramInt, false);
  }
  
  public boolean a(List paramList)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCard.QQCardManager", 2, "handleChange, list = null");
      }
      return false;
    }
    return b(paramList);
  }
  
  public boolean b(List paramList)
  {
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    try
    {
      localEntityTransaction.a();
      if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b("delete from t_qqcard_item")) {
        break label168;
      }
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        localQQCardItem = (QQCardItem)paramList.next();
        localQQCardItem.setStatus(1000);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(localQQCardItem);
        if (localQQCardItem.getStatus() != 1001) {
          throw new Exception("insert card failre.");
        }
      }
    }
    catch (Exception paramList)
    {
      for (;;)
      {
        QQCardItem localQQCardItem;
        if (QLog.isColorLevel()) {
          QLog.e("QQCard.QQCardManager", 2, "", paramList);
        }
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("QQCard.QQCardManager", 2, "persist " + localQQCardItem.getUID());
        }
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityTransaction.c();
    for (boolean bool = true;; bool = false)
    {
      localEntityTransaction.b();
      return bool;
      label168:
      if (QLog.isColorLevel()) {
        QLog.d("QQCard.QQCardManager", 2, "clearAndPersistCardList, delete failure");
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\QQCardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */