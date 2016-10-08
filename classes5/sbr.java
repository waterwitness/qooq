import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.widget.ProgressBar;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sbr
  extends DeviceFileObserver
{
  public sbr(BaseActionBarDataLineFile paramBaseActionBarDataLineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.getInt("cookie", 0);
    float f = paramBundle.getFloat("percent", 0.0F);
    this.a.k();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = f;
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize == 0L)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize = FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    }
    BaseActionBarDataLineFile.f(this.a);
    BaseActionBarDataLineFile.g(this.a).setProgress((int)(f * 100.0F));
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramSession.uSessionID != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.k();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = paramFloat;
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize == 0L)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize = paramSession.uFileSizeSrc;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    }
    BaseActionBarDataLineFile.f(this.a);
    BaseActionBarDataLineFile.f(this.a).setProgress((int)(100.0F * paramFloat));
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramSession.uSessionID != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {}
    do
    {
      do
      {
        return;
        this.a.j();
        if (paramBoolean)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramSession.strFilePathSrc);
          this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.a.a();
      } while (paramSession.bSend);
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        FMToastUtil.a(2131362151);
        return;
      }
    } while (new StatFs(AppConstants.bh).getAvailableBlocks() > 1);
    FMToastUtil.a(2131362150);
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      this.a.j();
      paramBundle.getInt("cookie", 0);
      if (paramBundle.getInt("err_code", 1) == 0)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath);
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity());
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.a.a();
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        FMToastUtil.a(2131362151);
        return;
      }
    } while (new StatFs(AppConstants.bh).getAvailableBlocks() > 1);
    FMToastUtil.a(2131362150);
  }
  
  public void b(Session paramSession)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) || (paramSession.uSessionID != this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq)) {
      return;
    }
    this.a.k();
    BaseActionBarDataLineFile.f(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    BaseActionBarDataLineFile.e(this.a).setProgress(0);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */