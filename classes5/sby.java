import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sby
  implements DialogInterface.OnClickListener
{
  sby(sbx paramsbx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
    {
      paramInt = DataLineMsgRecord.getDevTypeBySeId(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      paramDialogInterface = this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(paramInt).a(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      if (paramDialogInterface != null) {
        paramDialogInterface.setPaused(false);
      }
    }
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
      BaseActionBarDataLineFile.c(this.a.a);
    }
    for (;;)
    {
      this.a.a.k();
      return;
      BaseActionBarDataLineFile.d(this.a.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */