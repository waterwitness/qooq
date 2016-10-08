import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarTroopFile.ActionBarTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;

public class scz
  implements View.OnClickListener
{
  public scz(ActionBarTroopFile paramActionBarTroopFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity()))
    {
      FMToastUtil.a(2131362941);
      return;
    }
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(), "P_CliOper", "Grp_files", "", "in_mid", "Clk_download_restore", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin + "", "", "", "");
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\scz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */