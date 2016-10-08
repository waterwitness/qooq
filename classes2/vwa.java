import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopreward.TroopRewardDetailActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vwa
  implements ActionSheet.OnButtonClickListener
{
  public vwa(TroopRewardDetailActivity paramTroopRewardDetailActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity.c();
      this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity.c("Clk_payrecord");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (paramInt == 1)
      {
        TroopRewardDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity);
        this.jdField_a_of_type_ComTencentMobileqqTrooprewardTroopRewardDetailActivity.c("Clk_report");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vwa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */