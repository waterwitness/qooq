import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class vmv
  implements DialogInterface.OnClickListener
{
  public vmv(TroopFileItemOperation paramTroopFileItemOperation, TroopFileTransferManager paramTroopFileTransferManager, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vmv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */