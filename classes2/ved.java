import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.NearbyMemberActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ved
  implements ActionSheet.OnButtonClickListener
{
  public ved(NearbyMemberActivity paramNearbyMemberActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberActivity.b;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberActivity.b, false)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberActivity.b = i;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberActivity.b = 2;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberActivity.b = 0;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyMemberActivity.b = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ved.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */