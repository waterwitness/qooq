import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;

public class vmw
  implements DialogInterface.OnClickListener
{
  public vmw(TroopFileItemOperation paramTroopFileItemOperation, FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      TroopFileItemOperation.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileItemOperation, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */