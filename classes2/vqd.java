import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.io.File;
import java.util.UUID;

public class vqd
  implements Runnable
{
  public vqd(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, UUID paramUUID)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item == null) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Status)
    {
    default: 
      return;
    case 9: 
    case 10: 
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile != null) {
        new File(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.TmpFile).delete();
      }
      break;
    }
    for (;;)
    {
      Message localMessage = new Message();
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("UUID", this.jdField_a_of_type_JavaUtilUUID);
      localMessage.setData(localBundle);
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager).sendMessage(localMessage);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile != null) {
        new File(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile).delete();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */