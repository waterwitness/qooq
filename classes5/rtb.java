import android.media.MediaScannerConnection;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class rtb
  implements ActionSheet.OnButtonClickListener
{
  rtb(rta paramrta, FileInfo paramFileInfo, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d())) || (FileUtil.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d())))
    {
      FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d());
      this.jdField_a_of_type_Rta.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
      MediaScannerConnection.scanFile(this.jdField_a_of_type_Rta.a.a.a, new String[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.d() }, null, null);
      this.jdField_a_of_type_Rta.a.a.d();
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
    }
    FMToastUtil.a(2131362771);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rtb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */