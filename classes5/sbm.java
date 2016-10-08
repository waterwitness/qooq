import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarDataLineCloudFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sbm
  implements DialogInterface.OnClickListener
{
  sbm(sbl paramsbl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
    {
      paramInt = DataLineMsgRecord.getDevTypeBySeId(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      paramDialogInterface = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(paramInt).a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      if (paramDialogInterface != null) {
        paramDialogInterface.setPaused(false);
      }
    }
    if (this.a.jdField_a_of_type_Boolean) {
      ActionBarDataLineCloudFile.b(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.k();
      return;
      ActionBarDataLineCloudFile.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */