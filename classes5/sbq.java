import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBarDataLineFile.BaseActionBarDataLineFile;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;

public class sbq
  implements View.OnClickListener
{
  public sbq(BaseActionBarDataLineFile paramBaseActionBarDataLineFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e((BaseActivity)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.getActivity()))
    {
      BaseActionBarDataLineFile.b(this.a, System.currentTimeMillis());
      FMToastUtil.a(2131362941);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize == 0L)
    {
      BaseActionBarDataLineFile.b(this.a, System.currentTimeMillis());
      FMToastUtil.a("'" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "'" + BaseApplication.getContext().getResources().getString(2131362193));
      return;
    }
    BaseActionBarDataLineFile.b(this.a, true);
    BaseActionBarDataLineFile.g(this.a);
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    BaseActionBarDataLineFile.e(this.a);
    this.a.k();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */