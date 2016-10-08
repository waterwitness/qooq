import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

public class vmy
  implements DialogInterface.OnClickListener
{
  public vmy(TroopFileItemOperation paramTroopFileItemOperation, TroopFileTransferManager paramTroopFileTransferManager, UUID paramUUID)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.e(this.jdField_a_of_type_JavaUtilUUID);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */