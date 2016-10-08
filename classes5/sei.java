import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qlink.QlAndQQInterface.WorkState;
import java.util.ArrayList;

public class sei
  implements View.OnClickListener
{
  public sei(FileBrowserActivity paramFileBrowserActivity, IFileViewerAdapter paramIFileViewerAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.a())
    {
      paramView = new ArrayList();
      paramView.add(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.app.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity, paramView, 6, 6, false, null);
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.app.a().a();
    if (!paramView.mWorking)
    {
      paramView = new Intent();
      paramView.putExtra("_FILE_PATH_", this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.setResult(10, paramView);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.finish();
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity.app.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserActivity, new sej(this, paramView, str), new sek(this), new sel(this), null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */