import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class lag
  implements ActionSheet.OnButtonClickListener
{
  public lag(ChatSettingForTroop paramChatSettingForTroop, ActionSheet paramActionSheet)
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
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app != null)) {
        ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a.troopUin, null, this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.app.getAccount(), 1102);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */