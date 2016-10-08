import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;

public class vpf
  implements Runnable
{
  public vpf(TroopAppMgr paramTroopAppMgr, EntityManager paramEntityManager, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAppMgr.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAIOAppInfo);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */