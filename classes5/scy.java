import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.utils.NetworkUtil;

public class scy
  implements View.OnClickListener
{
  public scy(ActionBarTroopFile paramActionBarTroopFile, TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarTroopFileActionBarTroopFile.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity()))
    {
      FMToastUtil.a(2131362941);
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarTroopFileActionBarTroopFile.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), "P_CliOper", "Grp_files", "", "in_mid", "Clk_download", 0, 0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarTroopFileActionBarTroopFile.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin + "", "", TroopFileDetailBrowserActivity.a(paramView.getContext()) + "", FileManagerUtil.b(FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g)));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarActionBarTroopFileActionBarTroopFile.d();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\scy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */