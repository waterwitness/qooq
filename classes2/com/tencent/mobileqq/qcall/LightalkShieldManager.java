package com.tencent.mobileqq.qcall;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class LightalkShieldManager
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = LightalkShieldManager.class.getSimpleName();
  private static final String jdField_b_of_type_JavaLangString = "key_lightalk_query_shield_last_time";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public LightalkShieldManager(QQAppInterface paramQQAppInterface)
  {
    this.b = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    a();
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(LightalkShieldData.class);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LightalkShieldData localLightalkShieldData = (LightalkShieldData)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(localLightalkShieldData.qcallId), localLightalkShieldData);
        this.b.put(localLightalkShieldData.phone, localLightalkShieldData);
      }
    }
  }
  
  private void c(LightalkShieldData paramLightalkShieldData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramLightalkShieldData.getStatus() == 1000) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramLightalkShieldData);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while ((paramLightalkShieldData.getStatus() != 1002) && (paramLightalkShieldData.getStatus() != 1001));
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramLightalkShieldData);
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "updateShieldEntity| em closed data=" + paramLightalkShieldData.phone);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getInt("key_lightalk_query_shield_last_time", 0);
    if (QLog.isColorLevel()) {
      QLog.d("lightalk_shield_manager", 2, "last time:" + i);
    }
    return i;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(UinUtils.a(((LightalkShieldData)localIterator.next()).qcallId));
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putInt("key_lightalk_query_shield_last_time", paramInt).commit();
  }
  
  public void a(LightalkShieldData paramLightalkShieldData)
  {
    if (paramLightalkShieldData == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLightalkShieldData.qcallId), paramLightalkShieldData);
    this.b.put(paramLightalkShieldData.phone, paramLightalkShieldData);
    c(paramLightalkShieldData);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong));
  }
  
  public boolean a(String paramString)
  {
    return this.b.containsKey(paramString);
  }
  
  public void b(LightalkShieldData paramLightalkShieldData)
  {
    if (paramLightalkShieldData == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLightalkShieldData.qcallId));
      this.b.remove(paramLightalkShieldData.phone);
      paramLightalkShieldData = (LightalkShieldData)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(LightalkShieldData.class, true, "phone=?", new String[] { paramLightalkShieldData.phone }, null, null, null, null);
    } while (paramLightalkShieldData == null);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramLightalkShieldData);
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\qcall\LightalkShieldManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */