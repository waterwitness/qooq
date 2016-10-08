import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class qvt
  implements ActionSheet.OnButtonClickListener
{
  public qvt(BusinessCardEditActivity paramBusinessCardEditActivity, boolean paramBoolean, ActionSheet paramActionSheet)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a();
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.getActivity(), FlowCameraPhotoActivity.class);
      paramView.putExtra("extra_return_result", true);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.startActivityForResult(paramView, 10);
      if (this.jdField_a_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, "CliOper", "", "", "0X80064EB", "0X80064EB", 0, 0, "", "", "", "");
        continue;
        BusinessCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity);
        if (this.jdField_a_of_type_Boolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, "CliOper", "", "", "0X80064EC", "0X80064EC", 0, 0, "", "", "", "");
          continue;
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.getActivity(), BusinessCardListActivity.class);
          paramView.putExtra("Extra_Entrance", 2);
          this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.startActivityForResult(paramView, 12);
          if (this.jdField_a_of_type_Boolean) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardEditActivity.app, "CliOper", "", "", "0X80064ED", "0X80064ED", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */