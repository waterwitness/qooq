import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.core.DirectForwarder;
import com.dataline.core.DirectForwarder.CallBack;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar.IActionBarClickEvent;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.HlistViewHolder;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

public final class sdm
  implements View.OnClickListener
{
  public sdm(BaseActivity paramBaseActivity, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367539));
    localBundle.putInt("forward_type", 0);
    localBundle.putBoolean("not_forward", true);
    localBundle.putInt("dataline_forward_type", 100);
    localBundle.putString("dataline_forward_path", this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    localBundle.putBoolean("isBack2Root", true);
    localBundle.putParcelable("fileinfo", ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    sdn localsdn = new sdn(this);
    int i = localDataLineHandler.a().b(AppConstants.aj, localBundle, localsdn);
    if ((!localsdn.a) || (i == 0)) {
      DirectForwarder.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, i);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004B10", "0X8004B10", 0, 0, "", "", "", "");
    if ((paramView.getTag() instanceof HorizontalListViewAdapter.HlistViewHolder))
    {
      paramView = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
      if (paramView.a.isShowing()) {
        paramView.a.dismiss();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent.f();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */