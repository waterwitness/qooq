import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class scc
  implements DialogInterface.OnClickListener
{
  scc(sbx paramsbx, MessageRecord paramMessageRecord)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_Sbx.a.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.jdField_a_of_type_Sbx.a.a.fProgress = 0.0F;
    this.jdField_a_of_type_Sbx.a.a.uniseq = ((MessageForDeviceFile)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).uSessionID;
    this.jdField_a_of_type_Sbx.a.a.msgSeq = ((MessageForDeviceFile)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).uniseq;
    this.jdField_a_of_type_Sbx.a.a.status = 2;
    this.jdField_a_of_type_Sbx.a.k();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\scc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */