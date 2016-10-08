import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.ActionBarDataLineCloudFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class sbl
  implements View.OnClickListener
{
  public sbl(ActionBarDataLineCloudFile paramActionBarDataLineCloudFile, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    sbn localsbn;
    int j;
    if (FileManagerUtil.a())
    {
      paramView = new sbm(this);
      localsbn = new sbn(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
        break label217;
      }
      j = 2131362128;
    }
    for (int i = 2131362851;; i = 2131362852)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(i);
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity(), 230, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity().getString(j), str, 2131367262, 2131362134, paramView, localsbn).show();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerDin == 0L)
      {
        i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        paramView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a().a(i).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        if (paramView != null) {
          paramView.setPaused(false);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {
        ActionBarDataLineCloudFile.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile.k();
        return;
        ActionBarDataLineCloudFile.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarDataLineFileActionBarDataLineCloudFile);
      }
      label217:
      j = 2131362131;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */