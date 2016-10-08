import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Map;
import java.util.UUID;

public class vqj
  implements Runnable
{
  public vqj(TroopFileTransferManager paramTroopFileTransferManager, UUID paramUUID, TroopFileInfo paramTroopFileInfo, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.c();
    TroopFileTransferManager.Item localItem2 = (TroopFileTransferManager.Item)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.b.get(this.jdField_a_of_type_JavaUtilUUID);
    TroopFileTransferManager.Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      localItem1 = new TroopFileTransferManager.Item(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.b.put(this.jdField_a_of_type_JavaUtilUUID, localItem1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.c(localItem1, this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */