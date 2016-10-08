import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class vpd
  implements Runnable
{
  public vpd(TroopAppMgr paramTroopAppMgr, EntityManager paramEntityManager, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(TroopAIOAppInfo.class);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      localTroopAIOAppInfo.setStatus(1000);
      if (localTroopAIOAppInfo.hashVal != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a.put(Integer.valueOf(localTroopAIOAppInfo.appid), localTroopAIOAppInfo.hashVal);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, localTroopAIOAppInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */