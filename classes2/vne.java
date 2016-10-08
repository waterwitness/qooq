import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

class vne
  implements DialogInterface.OnClickListener
{
  vne(vnd paramvnd)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (TroopFileItemOperation.a(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation) == 0);
    TroopFileTransferManager.a(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.a, this.a.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation.b).b(this.a.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileInfo.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */