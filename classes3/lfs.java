import android.view.View;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lfs
  implements ActionSheet.OnButtonClickListener
{
  public lfs(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, "P_CliOper", "Grp_discuss", "", "0X80040ED", "0X80040ED", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, "CliOper", "", "", "0X8006623", "0X8006623", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.f();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */