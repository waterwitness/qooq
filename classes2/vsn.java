import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class vsn
  implements ActionSheet.OnButtonClickListener
{
  public vsn(AvatarWallAdapter paramAvatarWallAdapter, Activity paramActivity, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      AvatarWallAdapter.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_AndroidAppActivity, 13);
      continue;
      AvatarWallAdapter.a(this.jdField_a_of_type_AndroidAppActivity, 8 - this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vsn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */