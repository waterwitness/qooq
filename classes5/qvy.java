import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.businessCard.activity.FlowCameraPhotoActivity;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class qvy
  implements ActionSheet.OnButtonClickListener
{
  public qvy(BusinessCardListActivity paramBusinessCardListActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity, FlowCameraPhotoActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity.app, "CliOper", "", "", "0X80064DA", "0X80064DA", 0, 0, "", "", "", "");
      continue;
      BusinessCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity.app, this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityBusinessCardListActivity.app, "CliOper", "", "", "0X80064DB", "0X80064DB", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */