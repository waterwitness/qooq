import android.widget.ProgressBar;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarDataLineCloudFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sbo
  extends DataLineObserver
{
  public sbo(ActionBarDataLineCloudFile paramActionBarDataLineCloudFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.k();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = paramFloat;
    ActionBarDataLineCloudFile.c(this.a);
    ActionBarDataLineCloudFile.c(this.a).setProgress((int)(100.0F * paramFloat));
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong1 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin != 0L) {
        break;
      }
      paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(paramInt).b(paramLong1);
    } while ((paramString == null) || (paramString.isSendFromLocal()));
    paramString.fileMsgStatus = 0L;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(paramInt).c(paramString.msgId);
    this.a.k();
    ActionBarDataLineCloudFile.c(this.a);
    ActionBarDataLineCloudFile.a(this.a).setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
  }
  
  protected void a(String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.j();
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramString);
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
      {
        int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
        paramString = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(i).b(paramLong);
        if ((paramString != null) && (paramString.strMoloKey != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(paramString.path);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
      return;
    }
    this.a.a();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong1 != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.k();
    ActionBarDataLineCloudFile.c(this.a);
    ActionBarDataLineCloudFile.b(this.a).setProgress((int)(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F));
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramLong != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.j();
    if (paramBoolean)
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
      return;
    }
    this.a.a();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */