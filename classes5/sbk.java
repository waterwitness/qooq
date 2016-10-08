import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarDataLineCloudFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sbk
  implements FMDialogUtil.FMDialogInterface
{
  sbk(sbj paramsbj)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
    {
      int i = DataLineMsgRecord.getDevTypeBySeId(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      DataLineMsgSet localDataLineMsgSet = this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(i).a(this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      if (localDataLineMsgSet != null) {
        localDataLineMsgSet.setPaused(false);
      }
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    ActionBarDataLineCloudFile.a(this.a.a);
    this.a.a.k();
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */