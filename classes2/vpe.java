import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;

public class vpe
  implements Runnable
{
  public vpe(TroopAppMgr paramTroopAppMgr, EntityManager paramEntityManager, TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAIOAppInfo);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vpe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */