import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarOfflineFile.BaseActionBarOfflineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class scq
  implements View.OnClickListener
{
  public scq(BaseActionBarOfflineFile paramBaseActionBarOfflineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (FileManagerUtil.a())
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity();
      if (this.a.b)
      {
        i = 2131362851;
        FMDialogUtil.a(paramView, 2131362855, i, new scr(this));
      }
    }
    for (;;)
    {
      if (!this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f()) {
        break label112;
      }
      FileManagerReporter.a("0X8004BBA");
      return;
      i = 2131362852;
      break;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.a.k();
    }
    label112:
    FileManagerReporter.a("0X8004BD0");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\scq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */