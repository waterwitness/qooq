package cooperation.huangye;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class HYBusinessDataManager
  implements Manager
{
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public String a;
  private List jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public boolean a;
  
  public HYBusinessDataManager(EntityManager paramEntityManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = HYBusinessDataManager.class.getSimpleName();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(0);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    a();
  }
  
  private void a()
  {
    b();
  }
  
  private List b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * from ");
    localStringBuilder.append(HYBusinessInfo.tableName());
    localStringBuilder.append(" where category = " + paramString);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(HYBusinessInfo.class, localStringBuilder.toString(), null);
  }
  
  private void b()
  {
    Object localObject = " select * from " + HYBusinessInfo.tableName();
    localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(HYBusinessInfo.class, (String)localObject, null);
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      int j = ((List)localObject).size();
      int i = 0;
      while (i < j)
      {
        HYBusinessInfo localHYBusinessInfo = (HYBusinessInfo)((List)localObject).get(i);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localHYBusinessInfo.bId, localHYBusinessInfo);
        i += 1;
      }
    }
  }
  
  public HYBusinessInfo a(String paramString)
  {
    return (HYBusinessInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public List a(String paramString)
  {
    return b(paramString);
  }
  
  public boolean a(String paramString)
  {
    return true;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\HYBusinessDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */